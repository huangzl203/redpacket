
/*
 * Powered By zhangyunhua
 * Web Site: http://www.hehenian.com
 * Since 2008 - 2015
 */

package com.redpack.common.upgrade;

/**
 * @author zhangyunhua
 * @version 1.0
 * @since 1.0
 */

import java.util.List;
import java.util.Map;

import com.redpack.common.upgrade.model.UserUpgradeDo;


public interface IUserUpgradeService{

	/**
	 * 根据ID 查询
	 * @parameter id
	 */
	public UserUpgradeDo getById(Long id);
	
	/**
	 *根据条件查询列表
	 */
	public List<UserUpgradeDo> selectUserUpgrade(Map<String,Object> parameterMap);
	
	/**
	 * 更新
	 */
	public int  updateUserUpgradeById(UserUpgradeDo newUserUpgradeDo);
	
	/**
	 * 新增
	 */
	public int addUserUpgrade(UserUpgradeDo newUserUpgradeDo);
	
	/**
	 * 删除
	 */
	public int deleteById(int id);

	/**
	 * 申请升级
	 * @param userId
	 * @return
	 */
	public UserUpgradeDo applyUpgrade(long userId);

	/**
	 * 根据id 更改状态
	 * @param upgradeId
	 * @param newStatus
	 */
	public void updateUpgradeStatusById(String upgradeId, String newStatus);
}
