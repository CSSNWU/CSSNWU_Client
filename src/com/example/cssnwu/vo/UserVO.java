/**
 * @(#)UserVO.java     	2013-10-5 ����11:07:46
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.vo;

import com.example.cssnwu.businesslogicservice.resultenum.UserType;

/**
 *Class <code>UserVO.java</code> ���ӱ��ֲ���߼����UserVO
 *
 * @author never
 * @version 2013-10-5
 * @since JDK1.7
 */
public class UserVO extends VO{
	public String userName;          //�û���
    public String password;          //����
    public UserType userType;        //�û�����
    public boolean isLogin;          //�Ƿ��½
}
