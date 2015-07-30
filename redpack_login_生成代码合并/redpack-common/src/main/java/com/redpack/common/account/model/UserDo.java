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

import org.apache.ibatis.type.Alias;

/**
 * 
 * @author:  zhangyunhua
 * @date 2015年3月5日 上午10:46:58
 */
@Alias("userDo")
public class UserDo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id; // 用户ID
	private String username; // 帐号
	private String email; // 用户email
	private String password; // 用户密码

	private String twoLevelpwd; // 二级密码(初始密码为用户密码)
	private String mobilePhone; // 用户移动电话
	private Long refUser; // 推荐人ID
	private Long reciverUser; // 接受人ID
	private Integer vipStatus; // VIP会员状态(1 非VIP 2 VIP(默认)
								// 3 待续费VIP)
	private Date vipCreateTime; // VIP创建时间
	private Integer enable; // 是否禁用 1、启用 2、禁用 3.黑名单 默认1
	private Date createTime; // 帐号创建时间
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTwoLevelpwd() {
		return twoLevelpwd;
	}
	public void setTwoLevelpwd(String twoLevelpwd) {
		this.twoLevelpwd = twoLevelpwd;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public Long getRefUser() {
		return refUser;
	}
	public void setRefUser(Long refUser) {
		this.refUser = refUser;
	}
	public Long getReciverUser() {
		return reciverUser;
	}
	public void setReciverUser(Long reciverUser) {
		this.reciverUser = reciverUser;
	}
	public Integer getVipStatus() {
		return vipStatus;
	}
	public void setVipStatus(Integer vipStatus) {
		this.vipStatus = vipStatus;
	}
	public Date getVipCreateTime() {
		return vipCreateTime;
	}
	public void setVipCreateTime(Date vipCreateTime) {
		this.vipCreateTime = vipCreateTime;
	}
	public Integer getEnable() {
		return enable;
	}
	public void setEnable(Integer enable) {
		this.enable = enable;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	@Override
	public String toString() {
		return "UserDo [id=" + id + ", username=" + username + ", email="
				+ email + ", password=" + password + ", twoLevelpwd="
				+ twoLevelpwd + ", mobilePhone=" + mobilePhone + ", refUser="
				+ refUser + ", reciverUser=" + reciverUser + ", vipStatus="
				+ vipStatus + ", vipCreateTime=" + vipCreateTime + ", enable="
				+ enable + ", createTime=" + createTime + "]";
	}

	
	
}
