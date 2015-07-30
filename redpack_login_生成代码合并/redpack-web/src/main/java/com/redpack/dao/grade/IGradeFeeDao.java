/*
 * Powered By zhangyunhua
 * Web Site: http://www.hehenian.com
 * Since 2008 - 2015
 */

package com.redpack.dao.grade;

/**
 * @author zhangyunhua
 * @version 1.0
 * @since 1.0
 */


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.redpack.common.grade.model.GradeFeeDo;

@Repository
public interface IGradeFeeDao {

	/**
	 * 根据ID 查询
	 * @parameter id
	 */
	public GradeFeeDo getById(int id);
	
	/**
	 *根据条件查询列表
	 */
	public List<GradeFeeDo> selectGradeFee(Map<String,Object> parameterMap);
	
	/**
	 * 更新
	 */
	public int  updateGradeFeeById(GradeFeeDo newGradeFeeDo);
	
	/**
	 * 新增
	 */
	public int addGradeFee(GradeFeeDo newGradeFeeDo);
	
	/**
	 * 删除
	 */
	public int deleteById(int id);

}
