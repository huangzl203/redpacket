package com.redpack.web.view.userTree.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户等级树
 * @author LiuSiHai
 * Q Q:1052202173
 *
 * 2015-7-31 上午11:44:16
 * com.redpack.web.view.userTree.controller.UserTreeController.java
 */
@Controller
@RequestMapping(value = "/userTree")
public class UserTreeController {

	private final Logger logger = Logger.getLogger(this.getClass());

	/**
	 * 
	 * @param model
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping("/view")
	public String index(Model model, HttpSession session, HttpServletRequest request) {
		return "usertree/index";
	}
	
	

}
