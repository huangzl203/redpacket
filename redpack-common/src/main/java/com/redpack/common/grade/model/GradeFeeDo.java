/*
 * Powered By zhangyunhua
 * Web Site: http://www.hehenian.com
 * Since 2008 - 2015
 */

package com.redpack.common.grade.model;



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


@Alias("gradeFeeDo")
public class GradeFeeDo  implements java.io.Serializable{	
	
	//columns START
	private java.lang.Integer id;
	private java.lang.Double gradeAmount;
	private java.lang.Double beforeUpgrade;
	private java.lang.Integer afterUpgrade;
	//columns END
	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setId(java.lang.Integer value) {
		this.id = value;
	}
	public java.lang.Double getGradeAmount() {
		return this.gradeAmount;
	}
	
	public void setGradeAmount(java.lang.Double value) {
		this.gradeAmount = value;
	}
	public java.lang.Double getBeforeUpgrade() {
		return this.beforeUpgrade;
	}
	
	public void setBeforeUpgrade(java.lang.Double value) {
		this.beforeUpgrade = value;
	}
	public java.lang.Integer getAfterUpgrade() {
		return this.afterUpgrade;
	}
	
	public void setAfterUpgrade(java.lang.Integer value) {
		this.afterUpgrade = value;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("GradeAmount",getGradeAmount())
			.append("BeforeUpgrade",getBeforeUpgrade())
			.append("AfterUpgrade",getAfterUpgrade())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof GradeFeeDo == false) return false;
		if(this == obj) return true;
		GradeFeeDo other = (GradeFeeDo)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

