/*
 * Powered By zhangyunhua
 * Web Site: http://www.hehenian.com
 * Since 2008 - 2015
 */

package com.redpack.common.account.model;



import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.ibatis.type.Alias;

/**
 * @author zhangyunhua
 * @version 1.0
 * @since 1.0
 */


@Alias("userInfoDo")
public class UserInfoDo  implements java.io.Serializable{	
	
	//columns START
	private java.lang.Integer userid;
	private java.lang.String realName;
	private java.lang.String idCardno;
	private java.lang.String mobile;
	private java.lang.String qqNumber;
	private java.lang.String zfbNumber;
	private java.lang.String cftNumber;
	private java.lang.String bankName;
	private java.lang.String province;
	private java.lang.String city;
	private java.lang.String bankSubbranch;
	private java.lang.String bankAccount;
	private java.lang.String openAccount;
	private java.lang.String contactAddress;
	private java.lang.Integer referrerId;
	private java.lang.Integer parentId;
	private java.lang.String treeNode;
	//columns END
	
	private List<UserInfoDo> childList;
	
	public List<UserInfoDo> getChildList() {
		return childList;
	}

	public void setChildList(List<UserInfoDo> childList) {
		this.childList = childList;
	}

	public java.lang.Integer getUserid() {
		return this.userid;
	}
	
	public void setUserid(java.lang.Integer value) {
		this.userid = value;
	}
	public java.lang.String getRealName() {
		return this.realName;
	}
	
	public void setRealName(java.lang.String value) {
		this.realName = value;
	}
	public java.lang.String getIdCardno() {
		return this.idCardno;
	}
	
	public void setIdCardno(java.lang.String value) {
		this.idCardno = value;
	}
	public java.lang.String getMobile() {
		return this.mobile;
	}
	
	public void setMobile(java.lang.String value) {
		this.mobile = value;
	}
	public java.lang.String getQqNumber() {
		return this.qqNumber;
	}
	
	public void setQqNumber(java.lang.String value) {
		this.qqNumber = value;
	}
	public java.lang.String getZfbNumber() {
		return this.zfbNumber;
	}
	
	public void setZfbNumber(java.lang.String value) {
		this.zfbNumber = value;
	}
	public java.lang.String getCftNumber() {
		return this.cftNumber;
	}
	
	public void setCftNumber(java.lang.String value) {
		this.cftNumber = value;
	}
	public java.lang.String getBankName() {
		return this.bankName;
	}
	
	public void setBankName(java.lang.String value) {
		this.bankName = value;
	}
	public java.lang.String getProvince() {
		return this.province;
	}
	
	public void setProvince(java.lang.String value) {
		this.province = value;
	}
	public java.lang.String getCity() {
		return this.city;
	}
	
	public void setCity(java.lang.String value) {
		this.city = value;
	}
	public java.lang.String getBankSubbranch() {
		return this.bankSubbranch;
	}
	
	public void setBankSubbranch(java.lang.String value) {
		this.bankSubbranch = value;
	}
	public java.lang.String getBankAccount() {
		return this.bankAccount;
	}
	
	public void setBankAccount(java.lang.String value) {
		this.bankAccount = value;
	}
	public java.lang.String getOpenAccount() {
		return this.openAccount;
	}
	
	public void setOpenAccount(java.lang.String value) {
		this.openAccount = value;
	}
	public java.lang.String getContactAddress() {
		return this.contactAddress;
	}
	
	public void setContactAddress(java.lang.String value) {
		this.contactAddress = value;
	}
	public java.lang.Integer getReferrerId() {
		return this.referrerId;
	}
	
	public void setReferrerId(java.lang.Integer value) {
		this.referrerId = value;
	}
	public java.lang.Integer getParentId() {
		return this.parentId;
	}
	
	public void setParentId(java.lang.Integer value) {
		this.parentId = value;
	}
	public java.lang.String getTreeNode() {
		return this.treeNode;
	}
	
	public void setTreeNode(java.lang.String value) {
		this.treeNode = value;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Userid",getUserid())
			.append("RealName",getRealName())
			.append("IdCardno",getIdCardno())
			.append("Mobile",getMobile())
			.append("QqNumber",getQqNumber())
			.append("ZfbNumber",getZfbNumber())
			.append("CftNumber",getCftNumber())
			.append("BankName",getBankName())
			.append("Province",getProvince())
			.append("City",getCity())
			.append("BankSubbranch",getBankSubbranch())
			.append("BankAccount",getBankAccount())
			.append("OpenAccount",getOpenAccount())
			.append("ContactAddress",getContactAddress())
			.append("ReferrerId",getReferrerId())
			.append("ParentId",getParentId())
			.append("TreeNode",getTreeNode())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getUserid())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof UserInfoDo == false) return false;
		if(this == obj) return true;
		UserInfoDo other = (UserInfoDo)obj;
		return new EqualsBuilder()
			.append(getUserid(),other.getUserid())
			.isEquals();
	}
}

