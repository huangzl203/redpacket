
/**  
 * @Project: deposit-biz-common
 * @Package com.hehenian.deposit.common.account.model
 * @Title: UserDo.java
 * @Description: TODO
 * @author:  zhangyunhua
 * @date 2015年3月5日 上午10:46:58
 * @Copyright: HEHENIAN Co.,Ltd. All rights reserved.
 * @version V1.0  
 */
package com.redpack.common.account.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * @Description 用户表
 * @author huangzl QQ: 272950754
 * @date 2015年8月3日 下午6:09:33
 * @Project redpack-common
 * @Package com.redpack.common.account.model 
 * @File UserDo.java
*/
@Alias("userDo")
public class UserDo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long 	id; 				// 用户ID
	private String 	userName; 			// 用户名
	private String 	password; 			// 用户密码
	private String 	twoLevelPwd; 		// 二级密码(初始密码为用户密码)
	private Integer	grade; 				// 当前等级
	private String 	organ; 				// 组织机构
	private String 	remark; 			// 备注
	private String 	enabled; 			// 状态
	private Long 	referrerId; 		// 推荐人ID
	private Long 	parentId; 			// 接受人ID
	private String 	treeNode; 			// 业务方向
	private Date 	createTime; 		// 帐号创建时间
	private Date 	updateTime; 		// 帐号修改时间
	
	private UserInfoDo userInfoDo;		// 用户基础信息表
	private UserDo 	referrerDo; 		// 推荐人userDo
	private UserDo 	parentDo; 			// 接受人userDo

	private List<UserDo> childList;     //所有下级
	
	
	public List<UserDo> getChildList() {
		return childList;
	}
	public void setChildList(List<UserDo> childList) {
		this.childList = childList;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTwoLevelPwd() {
		return twoLevelPwd;
	}
	public void setTwoLevelPwd(String twoLevelPwd) {
		this.twoLevelPwd = twoLevelPwd;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public String getOrgan() {
		return organ;
	}
	public void setOrgan(String organ) {
		this.organ = organ;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public Long getReferrerId() {
		return referrerId;
	}
	public void setReferrerId(Long referrerId) {
		this.referrerId = referrerId;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getTreeNode() {
		return treeNode;
	}
	public void setTreeNode(String treeNode) {
		this.treeNode = treeNode;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public UserInfoDo getUserInfoDo() {
		return userInfoDo;
	}
	public void setUserInfoDo(UserInfoDo userInfoDo) {
		this.userInfoDo = userInfoDo;
	}
	public UserDo getReferrerDo() {
		return referrerDo;
	}
	public void setReferrerDo(UserDo referrerDo) {
		this.referrerDo = referrerDo;
	}
	public UserDo getParentDo() {
		return parentDo;
	}
	public void setParentDo(UserDo parentDo) {
		this.parentDo = parentDo;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
