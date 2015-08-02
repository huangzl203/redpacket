/**  
 * @Project: deposit-web
 * @Package com.hehenian.deposit.web.view.account.controller
 * @Title: UserController.java
 * @Description: TODO
 * @author:  zhangyunhua
 * @date 2015年3月5日 上午11:01:51
 * @Copyright: HEHENIAN Co.,Ltd. All rights reserved.
 * @version V1.0  
 */
package com.redpack.web.view.account.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.redpack.common.account.IUserInfoService;
import com.redpack.common.account.IUserService;
import com.redpack.utils.ResponseUtils;

/**
 * 
 * @author: zhangyunhua
 * @date 2015年3月5日 上午11:01:51
 */
@Controller
@RequestMapping("/account")
public class UserController {
	private static final Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	private IUserService userService;
	@Autowired
	private IUserInfoService userAccountService;

	/**
	 * 重置密码跳转页面
	 * 
	 * @return
	 * @author: huangzl
	 * @date 2015年8月2日 22:45:08
	 */
	@RequestMapping("resetPwdIndex")
	public String resetPwdIndex(ModelMap map, HttpSession sessionS) {
		logger.info("----重置密码跳转页面----");
		return "login/reInputPwd";
	}

	/**
	 * 注册用户跳转页面
	 * 
	 * @return
	 * @author: huangzl
	 * @date 2015年8月2日 22:45:08
	 */
	@RequestMapping("regIndex")
	public String regIndex(ModelMap map, HttpSession sessionS) {
		logger.info("----注册用户跳转页面----");
		return "login/register";
	}

	/**
	 * 用户注册
	 * 
	 * @Description: TODO
	 * @param request
	 * @param response
	 * @return
	 * @author: chenzhpmf
	 * @date 2015-3-29 上午5:06:48
	 */
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public void register(HttpServletRequest request, HttpServletResponse response) {
		String loginInfo = request.getParameter("userName");
		String mobilePhone = request.getParameter("mobilePhone");
		String pwd = request.getParameter("password");

		JSONObject jsonObject = new JSONObject();
		// if(StringUtils.isBlank(loginInfo)){
		// jsonObject.put("result", "请输入登录用户名");
		// ResponseUtils.renderText(response, "UTF-8",
		// JSONObject.fromObject(jsonObject).toString());
		// return;
		// }
		// if(StringUtils.isBlank(pwd)){
		// jsonObject.put("result", "请设置您的密码");
		// ResponseUtils.renderText(response, "UTF-8",
		// JSONObject.fromObject(jsonObject).toString());
		// return;
		// }
		// if(StringUtils.isBlank(mobilePhone)){
		// jsonObject.put("result", "请输入手机号");
		// ResponseUtils.renderText(response, "UTF-8",
		// JSONObject.fromObject(jsonObject).toString());
		// return;
		// }
		// //手机验证码校验
		// String identifyCode = request.getParameter("identifyCode");
		// boolean flag = identifyCodeService.checkIdentifyCode(mobilePhone,
		// identifyCode);
		// if (!flag){
		// //手机验证码校验不通过
		// jsonObject.put("result", "手机验证码不正确");
		// ResponseUtils.renderText(response, "UTF-8",
		// JSONObject.fromObject(jsonObject).toString());
		// return;
		// }
		//
		// AccountUserDo aud = new AccountUserDo();
		// aud.setUsername(loginInfo.trim());
		// aud.setMobilePhone(mobilePhone.trim());
		// String pwdMd5 = DigestUtils.md5Hex(pwd + WebConstants.PASS_KEY);
		// aud.setPassword(pwdMd5);
		// Date now = new Date();
		// aud.setCreateTime(now);
		// aud.setSource(100); //贷款代码100
		// IResult result = userService.registerUser(aud);
		// if (result.isSuccess()) {
		// Long userId = (Long)result.getModel();
		// //获取登录用户userId
		// LoginInfoRelate loginir = userInfoService.getByLoginInfo(loginInfo,
		// LoginInfoRelate.class, true);
		// if(loginir == null) {
		// //如果没有处理老数据，兼容老版本，取一次t_user信息
		// aud = userService.loginWithPwd(loginInfo, pwdMd5);
		// }else {
		// aud = userService.getById(userId);
		// }
		// request.getSession().setAttribute("user", aud);
		// // 取缓存登录信息
		// String root = session.getSessionId(request, response);
		// sessionCache.setAttribute(root, HHNConstants.SESSION_INFO, aud,
		// HHNConstants.SESSION_CACHE_TIME);
		// try {
		// int partnerId = getSessionIntAttr("partnerId",0);
		// String partnerUserId = getSessionStrAttr("partnerUserId");
		// if (partnerId>0&&StringUtils.isNotBlank(partnerUserId)){
		// UserBindDo userBindDo = new UserBindDo();
		// userBindDo.setPartnerId(partnerId);
		// userBindDo.setPartnerUserId(partnerUserId);
		// userBindDo.setCreateTime(new Date());
		// userBindDo.setUserId(aud.getId());
		// userService.saveUserBind(userBindDo);
		// }
		// }catch (Exception e){
		// logger.error(e.getMessage());
		// // ResponseUtils.renderText(response, null, JSONObject.fromObject(new
		// BaseReturn(1,"系统正忙请稍后重试")).toString());
		// return;
		// }
		jsonObject.put("result", "注册成功");
		ResponseUtils.renderText(response, null, JSONObject.fromObject(jsonObject).toString());
		// } else {
		// jsonObject.put("result", result.getErrorMessage());
		// ResponseUtils.renderText(response, null,
		// JSONObject.fromObject(jsonObject).toString());
		// }
	}

}
