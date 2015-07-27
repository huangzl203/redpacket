/**  
 * @Project: deposit-biz-service
 * @Package com.hehenian.deposit.dal.account
 * @Title: IUserDao.java
 * @Description: TODO
 * @author: liuzgmf
 * @date 2015年3月5日 上午10:59:14
 * @Copyright: HEHENIAN Co.,Ltd. All rights reserved.
 * @version V1.0  
 */
package com.redpack.dao.account;

import org.springframework.stereotype.Repository;

import com.redpack.common.account.model.UserDo;

/**
 * 
 * @author: liuzgmf
 * @date 2015年3月5日 上午10:59:14
 */
@Repository
public interface IUserDao {
    /**
     * 根据ID查询用户对象
     * 
     * @param id
     * @return
     * @author: liuzgmf
     * @date: 2015年3月5日上午10:49:36
     */
    UserDo getById(Long id);

    /**
     * 保存用户
     * @param userDo
     * @return
     */
    int saveUser(UserDo userDo);
}
