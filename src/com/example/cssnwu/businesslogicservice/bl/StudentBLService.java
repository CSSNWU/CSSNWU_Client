/**
 * @(#)StudentBLService.java     	2013-10-5 ����3:00:45
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.businesslogicservice.bl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.example.cssnwu.businesslogicservice.resultenum.TRANSFER_RESULT;
import com.example.cssnwu.vo.CourseVO;


/**
 *Class <code>StudentBLService.java</code> ���ӱ��ֲ���߼����ѧ�������йصĽӿ�
 *
 * @author never
 * @version 2013-10-5
 * @since JDK1.7
 */
public interface StudentBLService {
	/**
	 * Title: getCourses
	 * Description:       ͨ��ID��ȡ��ѧ���Ŀγ��б�
	 * @param studentId   ѧ��ID
	 * @return            ѧ���Ŀγ��б�ArrayList��
	 * @throws RemoteException 
	 */
    public ArrayList<CourseVO> getCourses(int studentId) throws RemoteException;
    
    /**
     * Title: getTransferInfo
     * Description: �鿴׼��׼����Ϣ
     * @param studentId  ѧ��ID
     * @return    ׼��׼����Ϣ���
     * @throws RemoteException 
     */
    public TRANSFER_RESULT getTransferInfo(int studentId) throws RemoteException;
    
    
    /**
     * Title: getCoursesBySemester
     * Description: ����ѧ�ڲ鿴ѧ���γ�
     * @param studentId ѧ��ID
     * @param semester ѧ��
     * @return     �γ̵��б�ArrayList��
     * @throws RemoteException 
     */
    public ArrayList<CourseVO> getCoursesBySemester(int studentId,String semester) throws RemoteException;
    
    
}
