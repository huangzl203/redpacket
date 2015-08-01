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

<<<<<<< HEAD
import java.util.List;
=======
import java.util.Map;
>>>>>>> b9bdccb92fe4149660895b52b5869113ebcfc1f2

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
<<<<<<< HEAD


=======
	/**
	 * 根据条件查询userDo
	 * @param parameterMap
	 * @return
	 */
	UserDo getByUserDo(Map<String, Object> parameterMap);
>>>>>>> b9bdccb92fe4149660895b52b5869113ebcfc1f2
}
