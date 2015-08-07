package com.redpack.web.view.redpack.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 红包控制器
 * @author huangzl QQ: 272950754
 * @date 2015-7-26 下午06:18:37
 * @Project redpack-web
 * @Package com.redpack.view.controllor
 * @File RedPackController.java
 */
@Controller
@RequestMapping(value = "/redPack")
public class RedPackController {

	private final Logger logger = Logger.getLogger(this.getClass());

	/**
	 * @author huangzl QQ:272950754
	 * @version 创建时间：2015-7-26 下午06:22:07
	 * @param model
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	public String index(Model model, HttpSession session, HttpServletRequest request) {
		return "redPack/index";
	}
	
	

	/**
	 * 我要升级
	 * 
	 * @author huangzl QQ:272950754
	 * @version 创建时间：2015-7-26 下午09:05:57
	 * @param model
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping("/upgradeInfo")
	public String upgradeInfo(Model model, HttpSession session, HttpServletRequest request) {
		return "redPack/redPack_upgrade";
	}
	/**
	 * 个人中心
	 * @author huangzl QQ: 272950754
	 * @date 2015年8月3日 下午4:36:03
	 * @param model
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping("/personalCenter")
	public String personalCenter(Model model, HttpSession session, HttpServletRequest request) {
		return "redPack/redPack_personal_center";
	}

}
