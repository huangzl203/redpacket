/**  
 * @Project: hehenian-lend
 * @Package com.hehenian.web.common.constant
 * @Title: WebConstants.java
 * @Description: TODO
 * @author:  zhangyunhua
 * @date 2015年1月22日 上午11:52:02
 * @Copyright: HEHENIAN Co.,Ltd. All rights reserved.
 * @version V1.0  
 */
package comredpack.common.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 常量类
 * 
 * @author:  zhangyunhua
 * @date 2015年1月22日 上午11:52:02
 * @Description 描述方法作用
 * @author huangzl QQ: 272950754
 * @date 2015年5月27日 下午5:34:57
 * @Project hehenian-lend-login
 * @Package com.hehenian.login.common.constant 
 * @File WebConstants.java
*/
public class WebConstants {

    /** 消息提示KEY */
    public static final String MESSAGE_KEY  = "message";
    
    /** session用户信息KEY */
    public static final String SESSION_USER  = "userDo";
    /**
     * session内容：admin管理员
     */
    public static final String SESSION_ADMIN = "admin";
    

    /** 验证码 */
    public static final String VERIFICATION_CODE = "randomCode";


    /**
     * 用户来源
     */
    public static final String SOURCEFROM_WEB            = "1";
    public static final String SOURCEFROM_WEIXIN         = "10";

    /**
     * 密码加密串
     */
    public static String PASS_KEY = "GDgLwwdK270Qj155xho8lyTp";
    
  
    

	public static final String ERR_CODE= "验证码错误";
	
	public static final String ERR_NAME="用户名错误";
	

	public static final String NOT_NULL="用户名密码不能为空";
	
    
   
}
