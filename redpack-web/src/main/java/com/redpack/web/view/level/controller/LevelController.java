package com.redpack.web.view.level.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

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
import com.redpack.common.grade.IGradeFeeService;
import com.redpack.common.grade.model.GradeFeeDo;
import com.redpack.common.upgrade.IUserUpgradeService;
import com.redpack.utils.ResponseUtils;
import com.redpack.web.view.base.controller.BaseController;
import comredpack.common.constant.WebConstants;


/**
 * 等级管理
 * @author:  zhangyunhua
 * @date 2015年3月5日 上午11:01:51
 */
@Controller
@RequestMapping("/upgrade")
public class LevelController  extends BaseController {
	
	private static transient Logger logger = Logger.getLogger(LevelController.class);
	@Autowired
	IUserUpgradeService userUpgradeService;
	
	@Autowired
	IUserService  userService;
	
	//@Autowired
	//IUserInfoService userInfoService;
	
	@Autowired
	IGradeFeeService gradeFeeService;
	
	
	/**
	 * 去升级申请页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/toApply")
    public String toApply(HttpServletRequest request,ModelMap map,HttpServletResponse response) {
		logger.debug("toApply");
		
		UserDo currentUser = (UserDo)  request.getSession().getAttribute(WebConstants.SESSION_USER);
		long  userId = currentUser.getId();
		
		//获取当前用户所有的PARENT
		UserDo userInfo = userService.getAllParent(userId, 8);
		map.put("currentUser", userInfo);
		
		//获取当前用户
		UserDo user = userService.getById(userId);
		map.put("currentUserAccount", user);
		
		
		//查询升级规则
		Map<String,Object> parameterMap = new HashMap<String,Object>();
		parameterMap.put("beforeUpgrade", user.getGrade());
		List<GradeFeeDo> gradeFeeList = gradeFeeService.selectGradeFee(parameterMap);
		if(gradeFeeList != null && gradeFeeList.size()>0){
			map.put("gradeFee", gradeFeeList.get(0));
		}
		return "upgrade/toApply";
    }
	
	
	/**
	 * 升级申请信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/apply")
    public String apply(HttpServletRequest request,HttpServletResponse response) {
		logger.debug("apply");
        return "upgrade/applyDetail";
    }
	
	/**
	 * 申请确认
	 * @param userDo
	 * @param model
	 * @return
	 */
	@RequestMapping("/confirm")
    public void upgradeConfirm(HttpServletRequest request,HttpServletResponse response) {
		logger.debug("confirm");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", 1);
		ResponseUtils.renderText(response, null, jsonObject.toString());
		return;
    }
	
	/**
	 * 申请列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/listApply")
    public String listApply(HttpServletRequest request,HttpServletResponse response) {
		logger.debug("listApply");
        return "upgrade/listMyApply";
    }
	
	/**
	 * 审批列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/listAudit")
    public String listAudit(HttpServletRequest request,HttpServletResponse response) {
		logger.debug("listAudit");
        return "upgrade/listAudit";
    }
	
	/**
	 * 申请审批
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "audit", method = RequestMethod.GET)
	public void audit(HttpServletRequest request,HttpServletResponse response) {
		logger.debug("audit");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", 1);
		ResponseUtils.renderText(response, null, jsonObject.toString());
		return;
	}
	
	/**
	 * 撤回
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "tookBack", method = RequestMethod.GET)
	public void tookBack(HttpServletRequest request,HttpServletResponse response) {
		logger.debug("tookBack");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", 1);
		ResponseUtils.renderText(response, null, jsonObject.toString());
		return;
	}
	
	/**
	 * 拒绝
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "refused", method = RequestMethod.GET)
	public void refused (HttpServletRequest request,HttpServletResponse response) {
		logger.debug("refused");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", 1);
		ResponseUtils.renderText(response, null, jsonObject.toString());
		return;
	}
	

}
