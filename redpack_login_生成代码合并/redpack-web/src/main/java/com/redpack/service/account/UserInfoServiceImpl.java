/*
 * Powered By zhangyunhua
 * Web Site: http://www.hehenian.com
 * Since 2008 - 2015
 */

package com.redpack.service.account;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redpack.common.account.IUserInfoService;
import com.redpack.common.account.model.UserInfoDo;
import com.redpack.dao.account.IUserInfoDao;

/**
 * @author zhangyunhua
 * @version 1.0
 * @since 1.0
 */


@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {

	private final Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired	
    private IUserInfoDao  userInfoDao;

	/**
	 * 根据ID 查询
	 * @parameter id
	 */
	@Override
	public UserInfoDo getById(int id){
	  return userInfoDao.getById(id);
	}
	
	/**
	 *根据条件查询列表
	 */
	@Override
	public List<UserInfoDo> selectRedUserInfo(Map<String,Object> parameterMap){
		return userInfoDao.selectRedUserInfo(parameterMap);
	}
	
	/**
	 * 更新
	 */
	@Override
	public int  updateRedUserInfoById(UserInfoDo newUserInfoDo){
		return userInfoDao.updateRedUserInfoById(newUserInfoDo);
	}
	
	/**
	 * 新增
	 */
	@Override
	public int addRedUserInfo(UserInfoDo newUserInfoDo){
		return userInfoDao.addRedUserInfo(newUserInfoDo);
	}
	
	/**
	 * 删除
	 */
	@Override
	public int deleteById(int id){
		return userInfoDao.deleteById(id);
	}

}
