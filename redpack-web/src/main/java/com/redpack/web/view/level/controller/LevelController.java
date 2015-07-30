package com.redpack.web.view.level.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.redpack.common.account.model.UserDo;
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
	
	/**
	 * 升级申请
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/apply")
    public String apply(HttpServletRequest request,HttpServletResponse response) {
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
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", 1);
		ResponseUtils.renderText(response, null, jsonObject.toString());
		return;
    }
	
	
	/**
	 * 申请审批
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "audit", method = RequestMethod.GET)
	public void audit(HttpServletRequest request,HttpServletResponse response) {
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
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", 1);
		ResponseUtils.renderText(response, null, jsonObject.toString());
		return;
	}
	

}
