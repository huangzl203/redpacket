/*
 * Powered By zhangyunhua
 * Web Site: http://www.hehenian.com
 * Since 2008 - 2015
 */

package com.redpack.service.grade;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redpack.common.grade.IGradeFeeService;
import com.redpack.common.grade.model.GradeFeeDo;
import com.redpack.dao.grade.IGradeFeeDao;

/**
 * @author zhangyunhua
 * @version 1.0
 * @since 1.0
 */


@Service("gradeFeeService")
public class GradeFeeServiceImpl implements IGradeFeeService {

	private final Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired	
    private IGradeFeeDao  gradeFeeDao;

	/**
	 * 根据ID 查询
	 * @parameter id
	 */
	public GradeFeeDo getById(int id){
	  return gradeFeeDao.getById(id);
	}
	
	/**
	 *根据条件查询列表
	 */
	public List<GradeFeeDo> selectGradeFee(Map<String,Object> parameterMap){
		return gradeFeeDao.selectGradeFee(parameterMap);
	}
	
	/**
	 * 更新
	 */
	public int  updateGradeFeeById(GradeFeeDo newGradeFeeDo){
		return gradeFeeDao.updateGradeFeeById(newGradeFeeDo);
	}
	
	/**
	 * 新增
	 */
	public int addGradeFee(GradeFeeDo newGradeFeeDo){
		return gradeFeeDao.addGradeFee(newGradeFeeDo);
	}
	
	/**
	 * 删除
	 */
	public int deleteById(int id){
		return gradeFeeDao.deleteById(id);
	}

}
