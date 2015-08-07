
/**  
 * @Project: deposit-biz-service
 * @Package com.hehenian.deposit.dal.account
 * @Title: IUserDao.java
 * @Description: TODO
 * @author:  zhangyunhua
 * @date 2015年3月5日 上午10:59:14
 * @Copyright: HEHENIAN Co.,Ltd. All rights reserved.
 * @version V1.0  
 */
package com.redpack.dao.account;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.redpack.common.account.model.UserDo;

/**
 * 
 * @author:  zhangyunhua
 * @date 2015年3月5日 上午10:59:14
 */
@Repository
public interface IUserDao {
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
     * 根据条件查询用户对象
     * @param parameterMap
     * @return
     */
	UserDo getByUserDo(Map<String, Object> parameterMap);

	/**
	 * 根据parentid找出所有下级
	 * @param parentId
	 * @return
	 */
	List<UserDo> selectChildByParentId(Long parentId);

	/**
	 * 根据id 更新当前等级
	 * @param userid
	 * @param afterUpgrade
	 * @return
	 */
	int updateUserGradeById(@Param("userId")Long userid, @Param("grade")Integer afterUpgrade);
}
