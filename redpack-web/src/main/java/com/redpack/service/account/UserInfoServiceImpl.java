/*
 * Powered By zhangyunhua
 * Web Site: http://www.hehenian.com
 * Since 2008 - 2015
 */

package com.redpack.service.account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redpack.common.account.IUserInfoService;
import com.redpack.common.account.model.UserDo;
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
	public UserInfoDo getById(long id){
	  return userInfoDao.getById(id);
	}
	
	/**
	 * 根据当前用户ID ,查询他的第一层， 放到当前对象的 childList属性里，
	 * @param userId
	 * @return
	 */
	@Override
	public UserInfoDo getUserAndChild(long userId) {
		UserInfoDo  currentUser = this.getById(userId);
		if(null != currentUser){
			List<UserInfoDo> child = this.getChildList(userId);
			currentUser.setChildList(child);
		}
		return currentUser;
	}
	
	/**
	 * 据当前用户ID ,查询他的所有的下级， 放到当前对象的 childList属性里，
	 * @param userId
	 * @return
	 */
	@Override
	public UserInfoDo getUserAndAllChild(long userId) {
		UserInfoDo  currentUser = this.getById(userId);
		if(null != currentUser){
			getAllChildren(currentUser);
		}
		return currentUser;
	}
	
	@Override
	public List<UserInfoDo> getChildList(long userId) {
		Map<String,Object> parameterMap = new HashMap<String,Object>();
		parameterMap.put("parent_id", userId);
		List<UserInfoDo> child = this.selectRedUserInfo(parameterMap);
		return child;
	}
	
	
	/**
	 * 根据当前用户ID ,查询他的所有下级， 放到当前对象的 childList属性里， 递归查询到最后一级
	 * @param userId
	 * @return
	 */
	@Override
	public void getAllChildren(UserInfoDo currentUser) {
		
		List<UserInfoDo> child = this.getChildList(currentUser.getUserid());
		currentUser.setChildList(child);
		if(null == child){
			return;
		}
		
		for(UserInfoDo user : child){
			getAllChildren(user);				
		}
		return;
	}
	
	
	@Override
	public UserInfoDo getParent(long currentUserId ){
		UserInfoDo currentUser = this.getById(currentUserId);
		if(currentUser != null && currentUser.getParentId() != null){
			return this.getById(currentUser.getParentId());
		}
		return null;
	}
	
	/**
	 * 
	 * @param currentUserId
	 * @param levelNum
	 * @return
	 */
	@Override
	public UserInfoDo getAllParent(long currentUserId, int levelNum ){
		UserInfoDo currentUser = this.getById(currentUserId);
		if(currentUser != null && currentUser.getParentId() != null){
			return this.getById(currentUser.getParentId());
		}
		return null;
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
