/*
 * Powered By zhangyunhua
 * Web Site: http://www.hehenian.com
 * Since 2008 - 2015
 */

package com.redpack.service.upgrade;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redpack.common.upgrade.IUserUpgradeService;
import com.redpack.common.upgrade.model.UserUpgradeDo;
import com.redpack.dao.upgrade.IUserUpgradeDao;

/**
 * @author zhangyunhua
 * @version 1.0
 * @since 1.0
 */


@Service("userUpgradeService")
public class UserUpgradeServiceImpl implements IUserUpgradeService {

	private final Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired	
    private IUserUpgradeDao  userUpgradeDao;

	/**
	 * 根据ID 查询
	 * @parameter id
	 */
	public UserUpgradeDo getById(int id){
	  return userUpgradeDao.getById(id);
	}
	
	/**
	 *根据条件查询列表
	 */
	public List<UserUpgradeDo> selectUserUpgrade(Map<String,Object> parameterMap){
		return userUpgradeDao.selectUserUpgrade(parameterMap);
	}
	
	/**
	 * 更新
	 */
	public int  updateUserUpgradeById(UserUpgradeDo newUserUpgradeDo){
		return userUpgradeDao.updateUserUpgradeById(newUserUpgradeDo);
	}
	
	/**
	 * 新增
	 */
	public int addUserUpgrade(UserUpgradeDo newUserUpgradeDo){
		return userUpgradeDao.addUserUpgrade(newUserUpgradeDo);
	}
	
	/**
	 * 删除
	 */
	public int deleteById(int id){
		return userUpgradeDao.deleteById(id);
	}

}
