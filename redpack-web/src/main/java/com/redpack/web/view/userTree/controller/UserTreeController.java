package com.redpack.web.view.userTree.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.redpack.common.account.IUserService;
import com.redpack.common.account.model.UserDo;
import com.redpack.common.userTree.UserTreeDo;
import com.redpack.utils.ResponseUtils;
import com.redpack.web.view.base.controller.BaseController;

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
public class UserTreeController extends BaseController{

	private final Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	IUserService  userService; 
	/**
	 * 访问树节点
	 * @param model
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping("/view")
	public String index(Model model, HttpSession session, HttpServletRequest request) {
		return "usertree/index";
	}
	
	/**
	 *初始化树节点
	 * @param model
	 * @param session
	 * @param request
	 */
	@RequestMapping(value = "initTree", method = RequestMethod.POST)
	public void initTree(HttpServletRequest request,HttpServletResponse response) {
		//获取当前用户ID
		Long userId = super.getUserId();
		
		UserDo userDo = userService.getUserAndAllChild(userId);
		//组装树结构
//		UserTreeDo userTreeDo = initUserTree(userDo);
		
		
		
		
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", 0);
		jsonObject.put("userTree", userDo);
		// 数据传输成功
		ResponseUtils.renderText(response, "UTF-8", jsonObject.toString());
	}
	
	public UserTreeDo initUserTree(Long userId){
		
		//获取用户子级信息
		UserDo userDo = userService.getUserAndAllChild(userId);
		UserTreeDo userTreeDo = new UserTreeDo();
		userTreeDo.setId(userDo.getId());
		userTreeDo.setName(userDo.getUserName() + "(" + userDo.getGrade() + ")");
		List<UserDo> userChildrenList = userTreeDo.getChildren();
		for (UserDo userDo2 : userChildrenList) {
			
		}
		
		
		
		return userTreeDo;
	}

}
