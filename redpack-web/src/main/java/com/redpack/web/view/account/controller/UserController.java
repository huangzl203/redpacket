
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.redpack.common.account.IUserInfoService;
import com.redpack.common.account.IUserService;
import com.redpack.common.account.model.UserDo;
import com.redpack.common.account.model.UserInfoDo;
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
	private IUserInfoService userInfoService;

	/**
	 * 重置密码跳转页面
	 * 
	 * @return
	 * @author: huangzl
	 * @date 2015年8月2日 22:45:08
	 */
	@RequestMapping("resetPwdIndex")
	public String resetPwdIndex(String pwdFlag,Model model) {
		logger.info("----重置密码跳转页面----");
		model.addAttribute("pwdFlag", pwdFlag);
		return "login/reInputPwd";
	}

	/**
	 * 支付密码修改成功
	 */
    @RequestMapping(value = "resetPaySucc")
    public String resetPaySucc(){
    	return "login/resetSucc";
    }
    /**
     * @Description 密码重置
     * @author huangzl QQ: 272950754
     * @date 2015-8-7 下午09:41:54
     * @Project redpack-web
     * @Package com.redpack.web.view.account.controller
     * @File UserController.java
     * @param request
     * @param response
     * @param session
    */
    @RequestMapping(value = "updateLoginPwd")
    public void updateLoginPwd(HttpServletRequest request,HttpServletResponse response, HttpSession session){
    	logger.info("----密码重置----");
     	String pwdFlag = request.getParameter("pwdFlag");
    	JSONObject jsonObject = new JSONObject();
    	String password = request.getParameter("pwd");
		String confirmPass = request.getParameter("confirmPwd");
		if(StringUtils.isBlank(password)){
			 jsonObject.put("result", 1);
			 ResponseUtils.renderText(response, "UTF-8", jsonObject.toString());
			 return;
		}
		 if(password.length()<6 || password.length()>20){
			 jsonObject.put("result", 1);
			 ResponseUtils.renderText(response, "UTF-8", jsonObject.toString());
			 return;
		 }
		 if(!password.endsWith(confirmPass)){
			 jsonObject.put("result", 2);
			 ResponseUtils.renderText(response, "UTF-8", jsonObject.toString());
			 return;
		}
		//userId
		UserDo user = (UserDo) session.getAttribute(WebConstants.SESSION_USER);
		user=userService.getById(user.getId());
		session.setAttribute(WebConstants.SESSION_USER, user);
		try{
			if(user == null){
				jsonObject.put("result", 5); //账号有误或者会话信息超时
				ResponseUtils.renderText(response, "UTF-8", jsonObject.toString());
				return;
			}
			String newPass =DigestUtils.md5Hex(confirmPass + WebConstants.PASS_KEY);
			int result = 0;
			UserDo tempSave =new UserDo();
			if(pwdFlag.equals("pay")){
				String userPwd = user.getTwoLevelPwd();//新密码不能与原密码相同
				if(newPass.equals(userPwd)){
					 jsonObject.put("result", 3);
					 ResponseUtils.renderText(response, "UTF-8", jsonObject.toString());
					 return;
				}
				tempSave.setId(user.getId());
				tempSave.setTwoLevelPwd(newPass);
				result = userService.updateUser(tempSave);//修改支付密码
			}else{
				String userPwd = user.getPassword();
				if(newPass.equals(userPwd)){
					 jsonObject.put("result", 3);
					 ResponseUtils.renderText(response, "UTF-8", jsonObject.toString());
					 return;
				}
				tempSave.setId(user.getId());
				tempSave.setPassword(newPass);
				result = userService.updateUser(tempSave);//修改登录密码
			}
			if(result > 0){
				//添加日志
				logger.info("----t_user"+ user.getUserName()+ "修改会员密码----");
//				operationLogService.addOperationLog("t_user", aud.getUsername(), IConstants.UPDATE, aud.getLastIP(), 0d, "修改会员密码", 1);
				jsonObject.put("result",result > 0?0:4);
			}
		}catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		ResponseUtils.renderText(response, "UTF-8", jsonObject.toString());
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
		return "redPack/register";
	}

	/**
	 * @Description: 用户注册
	 * @param request
	 * @param response
	 * @return
	 * @author: chenzhpmf
	 * @date 2015-3-29 上午5:06:48
	 */
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public void register(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		UserDo user = (UserDo) session.getAttribute(WebConstants.SESSION_USER);
		long userId=user.getId();
		JSONObject jsonObject = new JSONObject();
		if(user!=null&&user.getId()!=null&&user.getId()>0){
			String loginInfo = request.getParameter("userName");
			String mobilePhone = request.getParameter("mobilePhone");
			String pwd =  request.getParameter("mobilePhone");
			Map<String, Object> parameterMap = new HashMap<String, Object>();
			parameterMap.put("mobile", mobilePhone);
			UserInfoDo temp =userInfoService.getByUserInfoDo(parameterMap);
			if(temp!=null&&temp.getUserId()!=null){
				jsonObject.put("result", "输入的手机号已存在");
				ResponseUtils.renderText(response, "UTF-8", JSONObject.fromObject(jsonObject).toString());
				return;
			}
			if (StringUtils.isBlank(loginInfo)) {
				jsonObject.put("result", "请输入登录用户名");
				ResponseUtils.renderText(response, "UTF-8", JSONObject.fromObject(jsonObject).toString());
				return;
			}
			if (StringUtils.isBlank(mobilePhone)) {
				jsonObject.put("result", "请输入手机号");
				ResponseUtils.renderText(response, "UTF-8", JSONObject.fromObject(jsonObject).toString());
				return;
			}
			String pwdMd5 =DigestUtils.md5Hex(pwd + WebConstants.PASS_KEY);
			UserDo userDo =new UserDo();
			userDo.setUserName(mobilePhone);
			userDo.setPassword(pwdMd5);
			userDo.setTwoLevelPwd(pwdMd5);
			userDo.setGrade(0);								//当前等级
			userDo.setOrgan("");								//组织机构
			userDo.setEnabled("");								//状态
			userDo.setReferrerId(userId);				//推荐人ID
			userDo.setParentId(userId);					//接点人ID
			userDo.setTreeNode("");								//业务方向
			UserInfoDo userInfoDo = new UserInfoDo();
			userInfoDo.setRealName(loginInfo);
			userInfoDo.setMobile(mobilePhone);
			userDo.setCreateTime(new Date());
			userDo.setUserInfoDo(userInfoDo);
			long result = userService.saveUser(userDo);
			if (result>=0) {
				jsonObject.put("result", "注册成功");
				ResponseUtils.renderText(response, null, JSONObject.fromObject(jsonObject).toString());
			} else {
				jsonObject.put("result", "注册失败");
				ResponseUtils.renderText(response,
				null,JSONObject.fromObject(jsonObject).toString());
			}
		}else{
			jsonObject.put("result", "登录超时");
			ResponseUtils.renderText(response, "UTF-8", JSONObject.fromObject(jsonObject).toString());
			return;
		}
	}
	
	

}
