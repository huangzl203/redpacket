package com.redpack.web.view.level.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.redpack.common.account.IUserService;
import com.redpack.common.enums.TreeNodeDirectionEnum;
import com.redpack.common.upgrade.IUserUpgradeService;
import com.redpack.utils.ResponseUtils;
import com.redpack.web.view.base.controller.BaseController;


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
	
	
	/**
	 * 去升级申请页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/toApply")
    public String toApply(HttpServletRequest request,HttpServletResponse response) {
		logger.debug("toApply");
		
		long  userId = this.getCurrentUserId();
		//userService.buildRelationTree(userId, TreeNodeDirectionEnum.UP.toString());
		
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
