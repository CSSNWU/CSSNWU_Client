/**
 * @(#)LoginBLService.java     	2013-10-5 下午2:43:06
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.businesslogicservice.bl;

import java.rmi.RemoteException;

import com.example.cssnwu.businesslogicservice.resultenum.Department;
import com.example.cssnwu.businesslogicservice.resultenum.LOGIN_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.LOGOUT_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.REGISTER_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.UserType;

/**
 *Class <code>LoginBLService.java</code> 连接表现层和逻辑层和登陆注销有关的接口
 *
 * @author never
 * @version 2013-10-5
 * @since JDK1.7
 */
public interface LoginBLService {
	/**
	 * Title: login
	 * Description:     处理用户的登陆请求
	 * @param id        用户ID
	 * @param password  密码
	 * @param userType  用户类别
	 * @param department 院系（学校教务老师为空）
	 * @return          登陆请求操作的结果
	 * @throws RemoteException
	 */
    public LOGIN_RESULT login(int id,String password,UserType userType) throws RemoteException;
    
    /**
     * Title: register
     * Description:      处理用户的注册请求
     * @param id         用户ID
     * @param userName   用户名
     * @param password   密码
     * @param userType   用户类型 
     * @return           注册请求操作的结果
     * @throws RemoteException
     */
    public REGISTER_RESULT register(int id,String userName,String password,UserType userType,Department department) throws RemoteException;
    
    /**
     * Title: logout
     * Description:  处理用户的注销请求
     * @param id     用户ID
     * @return       注销操作的结果
     * @throws RemoteException
     */
    public LOGOUT_RESULT logout(int id) throws RemoteException;

}
