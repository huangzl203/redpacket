package com.redpack.web.view.account.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.redpack.common.account.IUserInfoService;
import com.redpack.common.account.IUserService;
import com.redpack.common.account.model.UserDo;
import com.redpack.common.account.model.UserInfoDo;
import com.redpack.utils.ResponseUtils;
import com.redpack.web.view.base.controller.BaseController;
import comredpack.common.constant.WebConstants;
import comredpack.common.constant.WebThreadVariable;

/**
 * @Description 描述方法作用
 * @author huangzl QQ: 272950754
 * @date 2015年5月27日 下午5:33:55
 * @Project hehenian-lend-login
 * @Package com.hehenian.login.account
 * @File LoginController.java
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController extends BaseController {
	private static final Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private IUserService userService;
	@Autowired
	private IUserInfoService userInfoService;

	// 登录页验证码标识
	private final static String pageId = "userlogin";

	/**
	 * 登录入口
	 * 
	 * @return
	 * @author: zhangyunhua
	 * @date 2015-3-29 上午3:36:11
	 */
	@RequestMapping(value = "index")
	public String index() {
		logger.info("----loginInit(初始化登录页面);----");
		int loginStrategy = super.getSessionIntAttr("loginStrategy", 0);
		request.setAttribute("loginStrategyInfo", loginStrategy >= 5);
		return "login/login";
	}

	/**
	 * 登录入口
	 * 
	 * @return
	 * @author: zhangyunhua
	 * @date 2015-3-29 上午3:36:11
	 */
	@RequestMapping(value = "main")
	public String main(ModelMap map, HttpSession sessionS) {
		logger.info("----loginInit(登录成功)----");
		return "main";
	}

	/**
	 * @Description: 登录
	 * @param response
	 * @param user
	 * @return 1用户名或密码未输入|2验证码输入错误
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public void login(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		session.removeAttribute("userDo");
		JSONObject jsonObject = new JSONObject();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		String loginInfo = request.getParameter("userName");
		loginInfo = loginInfo.replaceAll(" ", "");
		parameterMap.put("userName", loginInfo);
		String password = request.getParameter("password");
		String code = request.getParameter("code");

		// 是否输入用户名密码
		if (StringUtils.isBlank(loginInfo) || StringUtils.isBlank(password)) {
			jsonObject.put("result", 1);
			ResponseUtils.renderText(response, null, jsonObject.toString());
			return;
		}

		int loginStrategy = super.getSessionIntAttr("loginStrategy", 0);
		// 密码输入错误5次要求输入验证码
		if (loginStrategy >= 5) {
			// 验证码是否正确
			String sessionCode = (String) request.getSession().getAttribute(pageId + "_checkCode");
			if (StringUtils.isBlank(code) || !code.equals(sessionCode)) {
				jsonObject.put("result", 2);
				ResponseUtils.renderText(response, null, jsonObject.toString());
				return;
			}
		}

		// 获取登录用户userId
		UserDo loginUser = userService.getByUserDo(parameterMap);

		String pwdMd5 = DigestUtils.md5Hex(password + WebConstants.PASS_KEY);

		if (loginUser == null || !loginUser.getPassword().equals(pwdMd5)) {
			// 用户名密码错误
			jsonObject.put("result", 3);
			session.setAttribute("loginStrategy", ++loginStrategy);
			jsonObject.put("loginStrategy", loginStrategy >= 5);
			ResponseUtils.renderText(response, null, jsonObject.toString());
			return;
		}
		UserInfoDo userInfoDo = userInfoService.getByUserId(loginUser.getId());
		loginUser.setUserInfoDo(userInfoDo);
		session.setAttribute(WebConstants.SESSION_USER, loginUser);
		WebThreadVariable.setUserDo(loginUser);

		// 取缓存登录信息
		// String fromUrl = request.getHeader("referer");
		jsonObject.put("result", 0);
		jsonObject.put("fromUrl", "/redPack/personalCenter.html");
		// 登陆成功
		ResponseUtils.renderText(response, "UTF-8", jsonObject.toString());
	}

	/**
	 * 退出登录
	 * 
	 * @param request
	 * @param response
	 * @author: zhanbmf
	 * @date 2015-3-31 下午3:36:21
	 */
	@RequestMapping(value = "loginout")
	public String loginout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		return "redirect:/login/index.do";
	}

}
