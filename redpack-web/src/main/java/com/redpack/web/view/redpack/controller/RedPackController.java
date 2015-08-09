package com.redpack.web.view.redpack.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sun.security.util.BigInt;

import com.redpack.common.account.IUserService;
import com.redpack.common.account.model.UserDo;
import com.redpack.common.grade.IGradeFeeService;
import com.redpack.common.grade.model.GradeFeeDo;
import com.redpack.common.upgrade.IUserUpgradeService;

import comredpack.common.constant.WebConstants;

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
	
	@Autowired
	IGradeFeeService gradeFeeService;
	
	
	@Autowired
	IUserService  userService;
	
	@Autowired
	IUserUpgradeService userUpgradeService;

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
	 * 规则
	 * 
	 * @author huangzl QQ:272950754
	 * @version 创建时间：2015-7-26 下午09:05:57
	 * @param model
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping("/rule")
	public String rule(Model model, HttpSession session, HttpServletRequest request) {
		return "redPack/rule";
	}
	
	/**
	 * 公告
	 * 
	 * @author huangzl QQ:272950754
	 * @version 创建时间：2015-7-26 下午09:05:57
	 * @param model
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping("/notify")
	public String notify(Model model, HttpSession session, HttpServletRequest request) {
		return "redPack/notify";
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
		
		UserDo user = (UserDo)session.getAttribute(WebConstants.SESSION_USER);
		model.addAttribute(WebConstants.SESSION_USER,user);
		
		//查询升级规则
		Map<String,Object> parameterMap = new HashMap<String,Object>();
		parameterMap.put("beforeUpgrade", user.getGrade());
		List<GradeFeeDo> gradeFeeList = gradeFeeService.selectGradeFee(parameterMap);
		if(gradeFeeList != null && gradeFeeList.size()>0){
			model.addAttribute("gradeFee", gradeFeeList.get(0));
		}
			
		initGroupInfo(model,request);
		initGroupAmount(model,request);
		
		return "redPack/redPack_personal_center";
	}
	
	/**
	 * 统计每层人数
	 * @param model
	 * @param request
	 */
	private void initGroupInfo(Model model,HttpServletRequest request){
		List<String> groupList = new ArrayList<String>(15);
		UserDo user = (UserDo)request.getSession().getAttribute(WebConstants.SESSION_USER);
		userService.getAllChildren(user);
		List<UserDo> childList = user.getChildList();
		
		
		
		//第一层
		int levelCount = 0;
		levelCount = levelCount + ( childList == null ? 0 : childList.size());
	    groupList.add(levelCount+"/3");
		
	    int allChildCount = levelCount;
	    
		
		//第一层
		for(int level = 2 ; level < 16 ; level ++){
			levelCount = 0;
			int levelPersons = (int) Math.pow(3,level);
			List<UserDo> nextList = new ArrayList<UserDo>();
			for(UserDo userDo : childList){
				nextList.addAll(userDo.getChildList());
				levelCount = levelCount + ( userDo.getChildList() == null ? 0 : userDo.getChildList().size());
			}
			childList = nextList;
			allChildCount = allChildCount + levelCount;
		    groupList.add(levelCount+"/"+levelPersons);
		}
		model.addAttribute("groupList", groupList);
		model.addAttribute("groupCount", allChildCount);
	}
	
	/**
	 * 统计每层金额
	 * @param model
	 * @param request
	 */
	private void initGroupAmount(Model model,HttpServletRequest request){
		List<Map<String,String>> groupList = new ArrayList<Map<String,String>>(15);
		UserDo user = (UserDo)request.getSession().getAttribute(WebConstants.SESSION_USER);
		
		int levelCount = 0;
		//第一层
		for(int level = 1 ; level < 16 ; level ++){
			levelCount = 0;
			int levelPersons = (int) Math.pow(3,level);
			Map<String,Object> groupLevelMoneyMap = userUpgradeService.selectLevelAmount(user.getId(),level);
			Long countPersons = 0L;
			BigDecimal amount = BigDecimal.ZERO;
			if(groupLevelMoneyMap !=null){
				countPersons  = groupLevelMoneyMap.get("countPersons")==null? 0L: (Long)groupLevelMoneyMap.get("countPersons");
				amount = groupLevelMoneyMap.get("amount") == null? BigDecimal.ZERO : (BigDecimal)groupLevelMoneyMap.get("amount");
			}
			Map<String,String> row = new HashMap<String,String>();
			row.put("persons", countPersons+"/"+levelPersons);
			row.put("amount", amount.toString());
			groupList.add(row);
		}
		model.addAttribute("groupMoneyList", groupList);
	}
	

}
