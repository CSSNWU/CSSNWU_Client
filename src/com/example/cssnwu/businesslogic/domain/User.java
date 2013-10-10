/**
 * @(#)User.java     	2013-10-5 下午10:51:24
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.businesslogic.domain;

import java.rmi.RemoteException;

import com.example.cssnwu.businesslogicservice.resultenum.Department;
import com.example.cssnwu.businesslogicservice.resultenum.LOGIN_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.LOGOUT_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.REGISTER_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.UserType;
import com.example.cssnwu.databaseservice.DatabaseFactory;
import com.example.cssnwu.databaseservice.DatabaseService;
import com.example.cssnwu.net.ClientLaunch;
import com.example.cssnwu.po.UserPO;

/**
 *Class <code>User.java</code> User领域对象
 *
 * @author never
 * @version 2013-10-5
 * @since JDK1.7
 */
public class User extends DomainObject{
    private DatabaseFactory df = null;
    private DatabaseService userDatabaseService = null;
    
    //构造方法，初始化
    public User() throws RemoteException{
    	df = ClientLaunch.getDatabaseFactory();
    	userDatabaseService = df.getUserDatabaseService();
    }
    
    /**
     * 
     * Title: login
     * Description:处理用户登陆请求
     * @param id          用户id
     * @param password    密码
     * @param userType    用户类型
     * @return            LOGIN_RESULT
     * @throws RemoteException     
     */
    public LOGIN_RESULT login(int id,String password,UserType userType) throws RemoteException{
        //通过id获取UserPO
    	UserPO userPO = (UserPO) userDatabaseService.find(id);
        
    	//判断用户是否存在
    	if (userPO == null) {
        	return LOGIN_RESULT.用户不存在;
        }
    	
    	//判断用户是否登陆
    	if (userPO.isLogin()) {
    		return LOGIN_RESULT.用户已登录;
    	} else if (userPO.getPassword().equals(password)) {  //判断密码是否正确
    		//判断服务器修改登陆状态是否成功
    	    if(userDatabaseService.update(userPO, "isLogin", 1)) {   
    	    	return LOGIN_RESULT.登录成功;
    	    } else {
    	    	return LOGIN_RESULT.服务端错误;
    	    }
    		
    	} else {
    		return LOGIN_RESULT.密码错误;
    	}
    }
    
    /**
     * Title: register
     * Description:       处理用户注册请求
     * @param id          用户ID
     * @param userName    用户名
     * @param password    密码
     * @param userType    用户类型
     * @param department  院系（学校教务老师为空）
     * @return     REGISTER_RESULT 注册请求的结果（注册成功、服务器端错误、学号已存在）     
     * @throws RemoteException
     */
    public REGISTER_RESULT register(int id,String userName,String password,UserType userType,Department department) throws RemoteException {
    	//通过id获取UserPO
    	UserPO userPO = (UserPO) userDatabaseService.find(id);
    	
    	//判断学号是否已经被注册（各种身份的用户id格式是不同的，所以不考虑UserType）
    	if(userPO != null) {
    		return REGISTER_RESULT.学号已存在;
    	} else {
    		//判断注册是否成功
    		if(userDatabaseService.insert(userPO)) {
    			return REGISTER_RESULT.注册成功;
    		} else {
    			return REGISTER_RESULT.服务端错误;
    		}
    	}
    }
    
    /**
     * 
     * Title: logout
     * Description: 处理用户注销请求
     * @param id    用户id
     * @return      LOGOUT_RESULT
     * @throws RemoteException
     */
    public LOGOUT_RESULT logout(int id) throws RemoteException {
    	//通过id获取UserPO
    	UserPO userPO = (UserPO) userDatabaseService.find(id);
    	
    	//判断用户是否存在
    	if(userPO == null) {
    		return LOGOUT_RESULT.用户不存在;
    	} else {
    		
    		//判断服务器更改登陆状态是否成功
    		if(userDatabaseService.update(userPO, "isLogin", 0)) {
    			return LOGOUT_RESULT.退出成功;
    		} else {
				return LOGOUT_RESULT.服务端错误;
			}
    	}
    }
    
    
}
