/*
 * Powered By zhangyunhua
 * Web Site: http://www.hehenian.com
 * Since 2008 - 2015
 */

package com.redpack.service.account;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	


	@Override
	public UserInfoDo getById(Long id) {
		return userInfoDao.getById(id);
	}

	@Override
	public UserInfoDo getByUserId(Long userId) {
		return userInfoDao.getByUserId(userId);
	}
	@Override
	public UserInfoDo getByUserInfoDo(Map<String, Object> parameterMap) {
		return userInfoDao.getByUserInfoDo(parameterMap);
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	@Override
	public Long saveUserInfo(UserInfoDo userInfoDo) {
		long i = userInfoDao.saveUserInfo(userInfoDo);
		if (i > 0) {
			return userInfoDo.getId();
		} else {
			return 0l;
		}
	}

	@Override
	public int updataUserInfo(UserInfoDo userInfoDo) {
		return userInfoDao.updataUserInfo(userInfoDo);
	}

}
