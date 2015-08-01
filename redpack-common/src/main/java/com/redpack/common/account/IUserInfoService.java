/*
 * Powered By zhangyunhua
 * Web Site: http://www.hehenian.com
 * Since 2008 - 2015
 */

package com.redpack.common.account;

import java.util.List;
import java.util.Map;

import com.redpack.common.account.model.UserInfoDo;

/**
 * @author zhangyunhua
 * @version 1.0
 * @since 1.0
 */

public interface IUserInfoService {

	public abstract int deleteById(int id);

	public abstract int addRedUserInfo(UserInfoDo newUserInfoDo);

	public abstract int updateRedUserInfoById(UserInfoDo newUserInfoDo);

	public abstract List<UserInfoDo> selectRedUserInfo(Map<String,Object> parameterMap);

	public abstract UserInfoDo getById(long id);

	public abstract UserInfoDo getAllParent(long currentUserId, int levelNum);

	public abstract UserInfoDo getParent(long currentUserId);

	public abstract void getAllChildren(UserInfoDo currentUser);

	public abstract List<UserInfoDo> getChildList(long userId);

	public abstract UserInfoDo getUserAndAllChild(long userId);

	public abstract UserInfoDo getUserAndChild(long userId);
	
}
