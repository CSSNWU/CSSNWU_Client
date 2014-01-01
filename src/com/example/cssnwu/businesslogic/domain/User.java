/**
 * @(#)User.java     	2013-10-5 ����10:51:24
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
import com.example.cssnwu.po.*;
;

/**
 *Class <code>User.java</code> User�������
 *
 * @author never
 * @version 2013-10-5
 * @since JDK1.7
 */
public class User extends DomainObject{
    private DatabaseFactory df = null;
    private DatabaseService userDatabaseService = null;
    private DatabaseService studentDatabaseService = null;
    private DatabaseService teacherDatabaseService=null;
//    private DatabaseService 
    
    //���췽������ʼ��
    public User() throws RemoteException{
    	df = ClientLaunch.getDatabaseFactory();
    	userDatabaseService = df.getUserDatabaseService();
    	studentDatabaseService = df.getStudentDatabaseService();
    	teacherDatabaseService=df.getTeacherDatabaseService();
    }
    
    /**
     * 
     * Title: login
     * Description:�����û���½����
     * @param id          �û�id
     * @param password    ����
     * @param userType    �û�����
     * @return            LOGIN_RESULT
     * @throws RemoteException     
     */
    public LOGIN_RESULT login(int id,String password,UserType userType) throws RemoteException{
        //ͨ��id��ȡUserPO
    	UserPO userPO=null;
    	switch(userType)
    	{  case Student:
    		{
    	
    		  userPO = (StudentPO) studentDatabaseService.find(id);
    		  System.out.println("����switch");
    		  break;
    		}
    	case Teacher:
    	{
    		userPO=(TeacherPO) teacherDatabaseService.find(id);
    		break;
    	}
    	case SchoolTeacher:
    	{  userPO=(TeacherPO) teacherDatabaseService.find(id);
    	   break;	
    	}
    	case DepartmentTeacher:
    	{   userPO=(TeacherPO) teacherDatabaseService.find(id);
    		break;
    	} 
    	}
    	
     
       // UserPO userPO = (StudentPO) studentDatabaseService.find(id);
    	//�ж��û��Ƿ����
    	if (userPO == null) {
        	return LOGIN_RESULT.�û�������;
        }
    	
    	System.out.println("�Ҹոյ��������ݿ⣬������");
    	System.out.println(password);
    	System.out.println(userPO.getPassword());
    	//�ж��û��Ƿ��½
    	if (userPO.isLogin()) {
    		System.out.println("has logined");
    		return LOGIN_RESULT.�û��ѵ�¼;
    	} else if (userPO.getPassword().equals(password)) {  //�ж������Ƿ���ȷ
    		//�жϷ������޸ĵ�½״̬�Ƿ�ɹ�
    	    if(true
    	    		//userDatabaseService.update(userPO, "isLogin", "1")
    	    		) {
    	    	
    	    	return LOGIN_RESULT.��¼�ɹ�;
    	    } else {
    	    	return LOGIN_RESULT.����˴���;
    	    }
    		
    	} else {
    		return LOGIN_RESULT.�������;
    	}
    }
    
    /**
     * Title: register
     * Description:       �����û�ע������
     * @param id          �û�ID
     * @param userName    �û���
     * @param password    ����
     * @param userType    �û�����
     * @param department  Ժϵ��ѧУ������ʦΪ�գ�
     * @return     REGISTER_RESULT ע������Ľ����ע��ɹ����������˴���ѧ���Ѵ��ڣ�     
     * @throws RemoteException
     */
    public REGISTER_RESULT register(int id,String userName,String password,UserType userType,Department department) throws RemoteException {
    	//ͨ��id��ȡUserPO
    	UserPO userPO = (UserPO) userDatabaseService.find(id);
    	
    	//�ж�ѧ���Ƿ��Ѿ���ע�ᣨ������ݵ��û�id��ʽ�ǲ�ͬ�ģ����Բ�����UserType��
    	if(userPO != null) {
    		return REGISTER_RESULT.ѧ���Ѵ���;
    	} else {
    		//�ж�ע���Ƿ�ɹ�
    		if(userDatabaseService.insert(userPO)) {
    			return REGISTER_RESULT.ע��ɹ�;
    		} else {
    			return REGISTER_RESULT.����˴���;
    		}
    	}
    }
    
    /**
     * 
     * Title: logout
     * Description: �����û�ע������
     * @param id    �û�id
     * @return      LOGOUT_RESULT
     * @throws RemoteException
     */
    public LOGOUT_RESULT logout(int id) throws RemoteException {
    	//ͨ��id��ȡUserPO
    	UserPO userPO = (UserPO) userDatabaseService.find(id);
    	
    	
    	
    	System.out.println("----------------------------------------------");
    	
    	
    	
    	//�ж��û��Ƿ����
    	if(userPO == null) {
    		return LOGOUT_RESULT.�û�������;
    	} else {
    		
    		//�жϷ��������ĵ�½״̬�Ƿ�ɹ�
    		if(userDatabaseService.update(userPO, "isLogin", "0")) {
    			return LOGOUT_RESULT.�˳��ɹ�;
    		} else {
				return LOGOUT_RESULT.����˴���;
			}
    	}
    }

	public String findName(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
    
    
}
