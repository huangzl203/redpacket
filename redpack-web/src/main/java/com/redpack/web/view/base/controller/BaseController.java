<<<<<<< HEAD
/**  
 * @Project: hehenian-mobile
 * @Package com.hehenian.mobile.controller
 * @Title: BaseController.java
 * @Description: TODO
 *
 * @author:  zhangyunhua
 * @date 2015-3-26 上午11:21:59
 * @Copyright: HEHENIAN Co.,Ltd. All rights reserved.
 * @version V1.0   
 */
package com.redpack.web.view.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.redpack.common.account.model.UserInfoDo;
import com.redpack.common.account.model.UserDo;
import com.redpack.utils.CommonUtils;
import comredpack.common.constant.WebConstants;

/**
 * @Description 描述方法作用
 * @author huangzl QQ: 272950754
 * @date 2015年5月27日 下午5:34:02
 * @Project hehenian-lend-login
 * @Package com.hehenian.login.common 
 * @File BaseController.java
*/
public class BaseController {
	@Autowired
	protected HttpServletRequest request;

	protected UserInfoDo getUserAccount() {
		UserInfoDo aud = CommonUtils.getUserAccountDo();
		if (aud == null) {
			aud = new UserInfoDo();
		}
		return aud;
	}
	
	protected UserDo getPerson() {
		UserDo pd = CommonUtils.getUserDo();
		if (pd == null) {
			pd = new UserDo();
		}
		return pd;
	}
	
	protected long getUserId() {
		UserDo currentUser = (UserDo)  request.getSession().getAttribute(WebConstants.SESSION_USER);
		return currentUser.getId();
	}
	
	protected Long getCurrentUserId(){
		return CommonUtils.getLoginId() != null ? CommonUtils.getLoginId().longValue() : -1;
	}
	
	protected String getSessionStrAttr(String attrName) {
		try {
			Object obj = request.getSession().getAttribute(attrName);
	        if (obj!=null){
	            return obj.toString();
	        }
	        
	        return null;
		} catch (Exception e) {
			return null;
		}
	}
	
    public String getSourcFrom(){
        HttpSession session = request.getSession();
        Object sourceFromObj = session.getAttribute("sourcefrom");
        if (sourceFromObj!=null){
            return sourceFromObj.toString();
        }else {
            return "1";
        }
    }
    
    protected int getSessionIntAttr(String attrName,int defaultValue){
        try {
            return (Integer)request.getSession().getAttribute(attrName);
        }catch (Exception e){
            return defaultValue;
        }
    }
    
	public static String FilteSqlInfusion(String input) {
		if ((input == null) || (input.trim() == "")) {
			return "";
		}
		if (!StringUtils.isNumeric(input)) {
			return input.replace("'", "’").replace("update", "ｕｐｄａｔｅ").replace(
					"drop", "ｄｒｏｐ").replace("delete", "ｄｅｌｅｔｅ").replace("exec",
					"ｅｘｅｃ").replace("create", "ｃｒｅａｔｅ").replace("execute",
					"ｅｘｅｃｕｔｅ").replace("where", "ｗｈｅｒｅ").replace("truncate",
					"ｔｒｕｎｃａｔｅ").replace("insert", "ｉｎｓｅｒｔ");
		} else {
			return input;
		}
	}
	
	public String getPath() {
        int port = request.getServerPort();
        String portStr = "";
        if(port != 80){
            portStr = ":"+port; 
        }
        String path = request.getScheme() + "://" + request.getServerName()
        + portStr + request.getContextPath()
        + "/";
        return path;
    }
	
	
}
=======
/**  
 * @Project: hehenian-mobile
 * @Package com.hehenian.mobile.controller
 * @Title: BaseController.java
 * @Description: TODO
 *
 * @author:  zhangyunhua
 * @date 2015-3-26 上午11:21:59
 * @Copyright: HEHENIAN Co.,Ltd. All rights reserved.
 * @version V1.0   
 */
package com.redpack.web.view.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.redpack.common.account.model.UserInfoDo;
import com.redpack.common.account.model.UserDo;
import com.redpack.utils.CommonUtils;

/**
 * @Description 描述方法作用
 * @author huangzl QQ: 272950754
 * @date 2015年5月27日 下午5:34:02
 * @Project hehenian-lend-login
 * @Package com.hehenian.login.common 
 * @File BaseController.java
*/
public class BaseController {
	@Autowired
	protected HttpServletRequest request;

	protected UserInfoDo getUserAccount() {
		UserInfoDo aud = CommonUtils.getUserAccountDo();
		if (aud == null) {
			aud = new UserInfoDo();
		}
		return aud;
	}
	
	protected UserDo getPerson() {
		UserDo pd = CommonUtils.getUserDo();
		if (pd == null) {
			pd = new UserDo();
		}
		return pd;
	}
	
	protected long getUserId() {
		return CommonUtils.getLoginId() != null ? CommonUtils.getLoginId() : -1;
	}
	
	protected Long getCurrentUserId(){
		return CommonUtils.getLoginId() != null ? CommonUtils.getLoginId().longValue() : -1;
	}
	
	protected String getSessionStrAttr(String attrName) {
		try {
			Object obj = request.getSession().getAttribute(attrName);
	        if (obj!=null){
	            return obj.toString();
	        }
	        
	        return null;
		} catch (Exception e) {
			return null;
		}
	}
	
    public String getSourcFrom(){
        HttpSession session = request.getSession();
        Object sourceFromObj = session.getAttribute("sourcefrom");
        if (sourceFromObj!=null){
            return sourceFromObj.toString();
        }else {
            return "1";
        }
    }
    
    protected int getSessionIntAttr(String attrName,int defaultValue){
        try {
            return (Integer)request.getSession().getAttribute(attrName);
        }catch (Exception e){
            return defaultValue;
        }
    }
    
	public static String FilteSqlInfusion(String input) {
		if ((input == null) || (input.trim() == "")) {
			return "";
		}
		if (!StringUtils.isNumeric(input)) {
			return input.replace("'", "’").replace("update", "ｕｐｄａｔｅ").replace(
					"drop", "ｄｒｏｐ").replace("delete", "ｄｅｌｅｔｅ").replace("exec",
					"ｅｘｅｃ").replace("create", "ｃｒｅａｔｅ").replace("execute",
					"ｅｘｅｃｕｔｅ").replace("where", "ｗｈｅｒｅ").replace("truncate",
					"ｔｒｕｎｃａｔｅ").replace("insert", "ｉｎｓｅｒｔ");
		} else {
			return input;
		}
	}
	
	public String getPath() {
        int port = request.getServerPort();
        String portStr = "";
        if(port != 80){
            portStr = ":"+port; 
        }
        String path = request.getScheme() + "://" + request.getServerName()
        + portStr + request.getContextPath()
        + "/";
        return path;
    }
	
	
}
>>>>>>> fe002e6a1f8651228f1e642370d2fede53dafc9d
