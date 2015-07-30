/*
 * Powered By zhangyunhua
 * Web Site: http://www.hehenian.com
 * Since 2008 - 2015
 */

package com.redpack.dao.account;

/**
 * @author zhangyunhua
 * @version 1.0
 * @since 1.0
 */


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.redpack.common.account.model.UserInfoDo;

@Repository
public interface IUserInfoDao {

	/**
	 * 根据ID 查询
	 * @parameter id
	 */
	public UserInfoDo getById(int id);
	
	/**
	 *根据条件查询列表
	 */
	public List<UserInfoDo> selectRedUserInfo(Map<String,Object> parameterMap);
	
	/**
	 * 更新
	 */
	public int  updateRedUserInfoById(UserInfoDo newUserInfoDo);
	
	/**
	 * 新增
	 */
	public int addRedUserInfo(UserInfoDo newUserInfoDo);
	
	/**
	 * 删除
	 */
	public int deleteById(int id);

}
