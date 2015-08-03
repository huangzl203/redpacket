/**  
 * @Project: deposit-biz-service
 * @Package com.hehenian.deposit.service.account
 * @Title: UserServiceImpl.java
 * @Description: TODO
 * @author:  zhangyunhua
 * @date 2015年3月5日 上午10:58:12
 * @Copyright: HEHENIAN Co.,Ltd. All rights reserved.
 * @version V1.0  
 */
package com.redpack.service.account;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.redpack.common.account.IUserService;
import com.redpack.common.account.model.UserDo;
import com.redpack.dao.account.IUserDao;

/**
 * 
 * @author: zhangyunhua
 * @date 2015年3月5日 上午10:58:12
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userDao;

	@Override
	public UserDo getById(Long id) {
		return userDao.getById(id);
	}

	/**
	 * 参 数 名 称 功 能 描 述 readOnly
	 * 该属性用于设置当前事务是否为只读事务，设置为true表示只读，false则表示可读写，默认值为false
	 * 。例如：@Transactional(readOnly=true)
	 * 
	 * rollbackFor 该属性用于设置需要进行回滚的异常类数组，当方法中抛出指定异常数组中的异常时，则进行事务回滚。例如：
	 * 指定单一异常类：@Transactional(rollbackFor=RuntimeException.class)
	 * 指定多个异常类：@Transactional(rollbackFor={RuntimeException.class,
	 * Exception.class})
	 * 
	 * rollbackForClassName
	 * 该属性用于设置需要进行回滚的异常类名称数组，当方法中抛出指定异常名称数组中的异常时，则进行事务回滚。例如：
	 * 指定单一异常类名称：@Transactional(rollbackForClassName="RuntimeException")
	 * 指定多个异常类名称
	 * ：@Transactional(rollbackForClassName={"RuntimeException","Exception"})
	 * 
	 * noRollbackFor 该属性用于设置不需要进行回滚的异常类数组，当方法中抛出指定异常数组中的异常时，不进行事务回滚。例如：
	 * 指定单一异常类：@Transactional(noRollbackFor=RuntimeException.class)
	 * 指定多个异常类：@Transactional(noRollbackFor={RuntimeException.class,
	 * Exception.class})
	 * 
	 * noRollbackForClassName
	 * 该属性用于设置不需要进行回滚的异常类名称数组，当方法中抛出指定异常名称数组中的异常时，不进行事务回滚。例如：
	 * 指定单一异常类名称：@Transactional(noRollbackForClassName="RuntimeException")
	 * 指定多个异常类名称：
	 * 
	 * @Transactional(noRollbackForClassName={"RuntimeException","Exception" )
	 * 
	 *                                                                       propagation
	 *                                                                       该属性用于设置事务的传播行为
	 * @Transactional(propagation=Propagation.REQUIRED) 如果有事务, 那么加入事务,
	 *                                                  没有的话新建一个(默认情况下)
	 * @Transactional(propagation=Propagation.NOT_SUPPORTED) 容器不为这个方法开启事务
	 * @Transactional(propagation=Propagation.REQUIRES_NEW) 
	 *                                                      不管是否存在事务,都创建一个新的事务,原来的挂起
	 *                                                      ,新的执行完毕,继续执行老的事务
	 * @Transactional(propagation=Propagation.MANDATORY) 必须在一个已有的事务中执行,否则抛出异常
	 * @Transactional(propagation=Propagation.NEVER) 
	 *                                               必须在一个没有的事务中执行,否则抛出异常(与Propagation
	 *                                               .MANDATORY相反)
	 * @Transactional(propagation=Propagation.SUPPORTS) 
	 *                                                  如果其他bean调用这个方法,在其他bean中声明事务
	 *                                                  ,那就用事务.如果其他bean没有声明事务,
	 *                                                  那就不用事务.
	 * 
	 *                                                  isolation
	 *                                                  该属性用于设置底层数据库的事务隔离级别
	 *                                                  ，事务隔离级别用于处理多事务并发的情况
	 *                                                  ，通常使用数据库的默认隔离级别即可
	 *                                                  ，基本不需要进行设置
	 * 
	 *                                                  timeout
	 *                                                  该属性用于设置事务的超时秒数，默认值为
	 *                                                  -1表示永不超时
	 * 
	 * @param userDo
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	@Override
	public Long saveUser(UserDo userDo) {
		int i = userDao.saveUser(userDo);
		if (i > 0) {
			int x = i / 0;// 抛出异常 事务就回滚了
			return userDo.getId();
		} else {
			return 0l;
		}
	}

	@Override
	public UserDo getByLoginInfo(String id) {
		return userDao.getById(Long.valueOf(id));
	}

	@Override
	public UserDo getByUserDo(Map<String, Object> parameterMap) {
		return userDao.getByUserDo(parameterMap);
	}

}
