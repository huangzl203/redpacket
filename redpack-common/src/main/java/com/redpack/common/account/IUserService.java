/**  
 * @Project: deposit-biz-common
 * @Package com.hehenian.deposit.common.account
 * @Title: IUserService.java
 * @Description: TODO
 * @author:  zhangyunhua
 * @date 2015年3月5日 上午10:46:01
 * @Copyright: HEHENIAN Co.,Ltd. All rights reserved.
 * @version V1.0  
 */
package com.redpack.common.account;

import java.util.List;

import com.redpack.common.account.model.UserDo;

/**
 * 
 * @author:  zhangyunhua
 * @date 2015年3月5日 上午10:46:01
 */
public interface IUserService {

    /**
     * 根据ID查询用户对象
     * 
     * @param id
     * @return
     * @author:  zhangyunhua
     * @date: 2015年3月5日上午10:49:36
     */
    UserDo getById(Long id);

    /**
     * 保存用户
     * @param userDo
     * @return
     */
    Long saveUser(UserDo userDo);

    /**
     * 登录调用
     * @param loginInfo  登录手机号
     * @return
     */
	UserDo getByLoginInfo(String loginInfo);


}
