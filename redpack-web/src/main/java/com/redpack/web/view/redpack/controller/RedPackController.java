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
	 * 跳转首页
	 * @author  huangzl QQ:272950754
	 * @version 创建时间：2015-7-26 下午09:53:32 
	 * @param model
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping("/welcome")
	public String welcome(Model model, HttpSession session, HttpServletRequest request) {
		return "redPack/index";
	}

	/**
	 * 修改资料跳转方法
	 * 
	 * @author huangzl QQ:272950754
	 * @version 创建时间：2015-7-26 下午09:05:57
	 * @param model
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping("/modifyInfo")
	public String modifyInfo(Model model, HttpSession session, HttpServletRequest request) {
		return "redPack/redPack_modify";
	}
	/**
	 * 修改资料保存方法
	 * 
	 * @author huangzl QQ:272950754
	 * @version 创建时间：2015-7-26 下午09:50:57
	 * @param model
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping("/modifyUpdata")
	public String modifyUpdata(Model model, HttpSession session, HttpServletRequest request) {
		return "redirect:/login/main";
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

}
