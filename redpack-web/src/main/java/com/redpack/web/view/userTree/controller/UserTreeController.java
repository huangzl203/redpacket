package com.redpack.web.view.userTree.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.redpack.common.userTree.UserTreeDo;
import com.redpack.utils.ResponseUtils;

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
		JSONObject jsonObject = new JSONObject();
		// 取缓存登录信息
		String fromUrl = request.getHeader("referer");
		UserTreeDo userTreeDo = new UserTreeDo();
		
		userTreeDo.setId(100L);
		userTreeDo.setName("陈一");
//		userTreeDo.setData(100L);
//		List childRen = new ArrayList();
//		for(int i=1; i<4; i++){
//			UserTreeDo childTreeDo = new UserTreeDo();
//			childTreeDo.setId(100L+i);
//			childTreeDo.setName("陈五" + i);
//			
//			
//			childRen.add(childTreeDo);
//		}
		userTreeDo.setChildren(addChildren(100, 6));
		
		jsonObject.put("result", 0);
		jsonObject.put("userTree", userTreeDo);
		// 登陆成功
		ResponseUtils.renderText(response, "UTF-8", jsonObject.toString());
	}
	
	public List addChildren(int parent,int leavel){
		
		List childRen = new ArrayList();
		leavel --;
		if(leavel>0){
			for(int i=1; i<4; i++){
//				int id = parent+10 + i;
//				 Random random1 = new Random(100);
               int id = (int)(Math.random()*1000);
				UserTreeDo childTreeDo = new UserTreeDo();
				childTreeDo.setId(Long.valueOf(id));
				childTreeDo.setName("陈五" + id);
				childTreeDo.setChildren(addChildren(id , leavel));
				
				childRen.add(childTreeDo);
			}
		}
		return childRen;
	}
	

}
