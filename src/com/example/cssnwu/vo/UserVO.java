/**
 * @(#)UserVO.java     	2013-10-5 下午11:07:46
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.vo;

import com.example.cssnwu.businesslogicservice.resultenum.UserType;

/**
 *Class <code>UserVO.java</code> 连接表现层和逻辑层的UserVO
 *
 * @author never
 * @version 2013-10-5
 * @since JDK1.7
 */
public class UserVO extends VO{
	public String userName;          //用户名
    public String password;          //密码
    public UserType userType;        //用户类型
    public boolean isLogin;          //是否登陆
}
