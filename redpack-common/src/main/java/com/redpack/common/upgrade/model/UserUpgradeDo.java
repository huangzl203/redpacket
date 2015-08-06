/*
 * Powered By zhangyunhua
 * Web Site: http://www.hehenian.com
 * Since 2008 - 2015
 */

package com.redpack.common.upgrade.model;



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


@Alias("userUpgradeDo")
public class UserUpgradeDo  implements java.io.Serializable{	
	
	//columns START
	private java.lang.Integer userid;
	private java.lang.Integer beforeUpgrade;
	private java.util.Date upgradeDate;
	private java.lang.Double upgradeAmount;
	private java.lang.Integer receiveUser;
	private java.lang.String paymentMethod;
	private java.lang.String accountReceive;
	private java.lang.String accountExpend;
	private java.lang.Integer afterUpgrade;
	//columns END
	public java.lang.Integer getUserid() {
		return this.userid;
	}
	
	public void setUserid(java.lang.Integer value) {
		this.userid = value;
	}
	public java.lang.Integer getBeforeUpgrade() {
		return this.beforeUpgrade;
	}
	
	public void setBeforeUpgrade(java.lang.Integer value) {
		this.beforeUpgrade = value;
	}
	public java.util.Date getUpgradeDate() {
		return this.upgradeDate;
	}
	
	public void setUpgradeDate(java.util.Date value) {
		this.upgradeDate = value;
	}
	public java.lang.Double getUpgradeAmount() {
		return this.upgradeAmount;
	}
	
	public void setUpgradeAmount(java.lang.Double value) {
		this.upgradeAmount = value;
	}
	public java.lang.Integer getReceiveUser() {
		return this.receiveUser;
	}
	
	public void setReceiveUser(java.lang.Integer value) {
		this.receiveUser = value;
	}
	public java.lang.String getPaymentMethod() {
		return this.paymentMethod;
	}
	
	public void setPaymentMethod(java.lang.String value) {
		this.paymentMethod = value;
	}
	public java.lang.String getAccountReceive() {
		return this.accountReceive;
	}
	
	public void setAccountReceive(java.lang.String value) {
		this.accountReceive = value;
	}
	public java.lang.String getAccountExpend() {
		return this.accountExpend;
	}
	
	public void setAccountExpend(java.lang.String value) {
		this.accountExpend = value;
	}
	public java.lang.Integer getAfterUpgrade() {
		return this.afterUpgrade;
	}
	
	public void setAfterUpgrade(java.lang.Integer value) {
		this.afterUpgrade = value;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Userid",getUserid())
			.append("BeforeUpgrade",getBeforeUpgrade())
			.append("UpgradeDate",getUpgradeDate())
			.append("UpgradeAmount",getUpgradeAmount())
			.append("ReceiveUser",getReceiveUser())
			.append("PaymentMethod",getPaymentMethod())
			.append("AccountReceive",getAccountReceive())
			.append("AccountExpend",getAccountExpend())
			.append("AfterUpgrade",getAfterUpgrade())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getUserid())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof UserUpgradeDo == false) return false;
		if(this == obj) return true;
		UserUpgradeDo other = (UserUpgradeDo)obj;
		return new EqualsBuilder()
			.append(getUserid(),other.getUserid())
			.isEquals();
	}
}

