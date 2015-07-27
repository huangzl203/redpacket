/**  
 * @Project: deposit-web
 * @Package com.hehenian.deposit.web.view.account.controller
 * @Title: UserController.java
 * @Description: TODO
 * @author: liuzgmf
 * @date 2015年3月5日 上午11:01:51
 * @Copyright: HEHENIAN Co.,Ltd. All rights reserved.
 * @version V1.0  
 */
package com.redpack.web.view.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.redpack.common.account.IUserAccountService;
import com.redpack.common.account.IUserService;
import com.redpack.common.account.model.UserDo;

/**
 * 
 * @author: liuzgmf
 * @date 2015年3月5日 上午11:01:51
 */
@Controller
@RequestMapping("/account")
public class UserController {
    @Autowired
    private IUserService        userService;
    @Autowired
    private IUserAccountService userAccountService;

    @RequestMapping(value = "/showUser", method = RequestMethod.GET)
    public String getById(Long userId, Model model) {
    	System.out.println("userId"+userId);
        UserDo userDo = userService.getById(userId);
        model.addAttribute("userDo", userDo);
        System.out.println(userAccountService.getById(1l));
        return "account/user_detail";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser() {
        return "account/user_add";
    }

    @RequestMapping("/addUser")
    public String addUser(@ModelAttribute UserDo userDo, Model model) {
        userService.saveUser(userDo);
        return "account/user_list";
    }
}
