/**
 * @(#)LoginBLService.java     	2013-10-5 ����2:43:06
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
 *Class <code>LoginBLService.java</code> ���ӱ��ֲ���߼���͵�½ע���йصĽӿ�
 *
 * @author never
 * @version 2013-10-5
 * @since JDK1.7
 */
public interface LoginBLService {
	/**
	 * Title: login
	 * Description:     �����û��ĵ�½����
	 * @param id        �û�ID
	 * @param password  ����
	 * @param userType  �û����
	 * @param department Ժϵ��ѧУ������ʦΪ�գ�
	 * @return          ��½��������Ľ��
	 * @throws RemoteException
	 */
    public LOGIN_RESULT login(int id,String password,UserType userType) throws RemoteException;
    
    /**
     * Title: register
     * Description:      �����û���ע������
     * @param id         �û�ID
     * @param userName   �û���
     * @param password   ����
     * @param userType   �û����� 
     * @return           ע����������Ľ��
     * @throws RemoteException
     */
    public REGISTER_RESULT register(int id,String userName,String password,UserType userType,Department department) throws RemoteException;
    
    /**
     * Title: logout
     * Description:  �����û���ע������
     * @param id     �û�ID
     * @return       ע�������Ľ��
     * @throws RemoteException
     */
    public LOGOUT_RESULT logout(int id) throws RemoteException;

}
