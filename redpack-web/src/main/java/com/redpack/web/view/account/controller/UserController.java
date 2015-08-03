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

import java.util.Date;

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
import com.redpack.common.base.result.IResult;
import com.redpack.utils.ResponseUtils;

import comredpack.common.constant.WebConstants;

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
	public String resetPwdIndex() {
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
	public String regIndex() {
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
	public void register(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		session.removeAttribute("userDo");
		UserDo userDo =new UserDo();
		UserInfoDo userInfoDo =new UserInfoDo();
		userDo.setUserInfoDo(userInfoDo);
		String loginInfo = request.getParameter("userName");
		String mobilePhone = request.getParameter("mobilePhone");
		String pwd = request.getParameter("password");
		
		JSONObject jsonObject = new JSONObject();
		 if(StringUtils.isBlank(loginInfo)){
		 jsonObject.put("result", "请输入登录用户名");
		 ResponseUtils.renderText(response, "UTF-8",JSONObject.fromObject(jsonObject).toString());
		 return;
		 }
		 if(StringUtils.isBlank(pwd)){
		 jsonObject.put("result", "请设置您的密码");
		 ResponseUtils.renderText(response, "UTF-8",JSONObject.fromObject(jsonObject).toString());
		 return;
		 }
		 if(StringUtils.isBlank(mobilePhone)){
		 jsonObject.put("result", "请输入手机号");
		 ResponseUtils.renderText(response, "UTF-8",JSONObject.fromObject(jsonObject).toString());
		 return;
		 }
		 userDo.setUsername(mobilePhone);
		 userDo.setPassword(DigestUtils.md5Hex(pwd + WebConstants.PASS_KEY));
		 userDo.setMobilePhone(mobilePhone);
		 userDo.getUserInfoDo().setRealName(loginInfo);
		 userDo.getUserInfoDo().setMobile(mobilePhone);
		 userDo.setCreateTime(new Date());
//		 long result = userService.saveUser(userDo);
//		 if (result>=0) {
			session.setAttribute("userDo",userDo );
			jsonObject.put("result", "注册成功");
			ResponseUtils.renderText(response, null, JSONObject.fromObject(jsonObject).toString());
//		 } else {
//			 jsonObject.put("result", "注册失败");
//			 ResponseUtils.renderText(response, null,JSONObject.fromObject(jsonObject).toString());
//		 }
	}

}
