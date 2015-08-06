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
import java.util.Map;

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

	/**
	 * 根据条件查询userDo
	 * @param parameterMap
	 * @return
	 */
	UserDo getByUserDo(Map<String, Object> parameterMap);
	
	/**
	 * 获取指定层数的上级
	 * @param currentUserId
	 * @param levelNum
	 * @return
	 */
	public UserDo getAllParent(long userId, int levelNum);

	/**
	 * 递归查询所有上级
	 */
	public  void getAllParent(UserDo currentUser);

	/**
	 * 获取指定层数的上级
	 * @param currentUserId
	 * @param levelNum
	 * @return
	 */
	public  void getAllParent(UserDo currentUser, int levelNum);

	/**
	 * 获取上级
	 * @param currentUserId
	 * @return
	 */
	public  UserDo getParent(long currentUserId);

	/**
	 * 根据当前用户ID ,查询他的所有下级， 放到当前对象的 childList属性里， 递归查询到最后一级
	 * @param userId
	 * @return
	 */
	public  void getAllChildren(UserDo currentUser);

	/**
	 * 获取第一层下级
	 */
	public  List<UserDo> getChildList(long userId);

	/**
	 * 据当前用户ID ,查询他的下级的下级， 直到没有下级， 放到当前对象的 childList属性里，
	 * @param userId
	 * @return
	 */
	public  UserDo getUserAndAllChild(long userId);

	/**
	 * 根据当前用户ID ,查询他的第一层下级， 放到当前对象的 childList属性里，
	 * @param userId
	 * @return
	 */
	public  UserDo getUserAndChild(long userId);

	/**
	 * 根据父ID查询第一层下级
	 * @param parentId
	 * @return
	 */
	public  List<UserDo> selectChildByParentId(Long parentId);
	
}
