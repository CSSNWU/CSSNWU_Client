/**
 * @(#)LoginController.java     	2013-10-5 下午10:47:31
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.businesslogic.controller;

import java.rmi.RemoteException;

import com.example.cssnwu.businesslogic.domain.User;
import com.example.cssnwu.businesslogicservice.bl.LoginBLService;
import com.example.cssnwu.businesslogicservice.resultenum.Department;
import com.example.cssnwu.businesslogicservice.resultenum.LOGIN_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.LOGOUT_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.REGISTER_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.UserType;

/**
 *Class <code>LoginController.java</code> 登陆注销等的controller
 *
 * @author never
 * @version 2013-10-5
 * @since JDK1.7
 */
public class LoginController implements LoginBLService{
    private User user;
	
	public LoginController() throws RemoteException {
		this.user = new User();
	}

	/* (non-Javadoc)
	 * Title: login
	 * Description:处理用户登陆请求
	 * @see com.example.cssnwu.businesslogicservice.bl.LoginBLService#login(int, java.lang.String, com.example.cssnwu.businesslogicservice.resultenum.UserType)
	 */
	@Override
	public LOGIN_RESULT login(int id, String password, UserType userType)
			throws RemoteException {
		return user.login(id, password, userType);
	}

	/* (non-Javadoc)
	 * Title: register
	 * Description:处理用户注册请求
	 * @see com.example.cssnwu.businesslogicservice.bl.LoginBLService#register(int, java.lang.String, java.lang.String, com.example.cssnwu.businesslogicservice.resultenum.UserType, com.example.cssnwu.businesslogicservice.resultenum.Department)
	 */
	@Override
	public REGISTER_RESULT register(int id, String userName, String password,
			UserType userType, Department department) throws RemoteException {
		return user.register(id, userName, password, userType, department);
	}

	/* (non-Javadoc)
	 * Title: logout
	 * Description:处理用户注销请求
	 * @see com.example.cssnwu.businesslogicservice.bl.LoginBLService#logout(int)
	 */
	@Override
	public LOGOUT_RESULT logout(int id) throws RemoteException {
		return user.logout(id);
	}

}
