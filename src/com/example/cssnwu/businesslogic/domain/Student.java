/**
 * @(#)Student.java     	2013-10-9 ����3:06:14
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.businesslogic.domain;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.example.cssnwu.businesslogicservice.resultenum.TRANSFER_RESULT;
import com.example.cssnwu.databaseservice.DatabaseFactory;
import com.example.cssnwu.databaseservice.DatabaseService;
import com.example.cssnwu.net.ClientLaunch;
import com.example.cssnwu.po.CoursePO;
import com.example.cssnwu.po.StudentPO;
import com.example.cssnwu.vo.CourseVO;

/**
 *Class <code>Student.java</code> ѧ����������
 *
 * @author never
 * @version 2013-10-9
 * @since JDK1.7
 */
public class Student extends DomainObject {
	private DatabaseFactory df = null;
	private DatabaseService studentDatabaseService = null;

	public Student() throws RemoteException{
		df = ClientLaunch.getDatabaseFactory();
		studentDatabaseService = df.getStudentDatabaseService();
	}

	/**
	 * Title: getCourses
	 * Description:       ͨ��ID��ȡ��ѧ���Ŀγ��б�
	 * @param studentId   ѧ��ID
	 * @return            ѧ���Ŀγ��б�ArrayList��
	 * @throws RemoteException 
	 */
	public ArrayList<CourseVO> getCourses(int studentId) throws RemoteException {
		ArrayList<CourseVO> voList = new ArrayList<CourseVO>();

		//ͨ��ID��ѯѧ��
		StudentPO studentPO = (StudentPO) studentDatabaseService.find(studentId);

		//POת��ΪVO
		for(CoursePO coursePO:studentPO.getCoursePOList()) {
			voList.add(PoToVo.transformCoursePO(coursePO));
			System.out.println(coursePO.getScore());
		}

		return voList;
	}

	/**
	 * Title: getCoursesBySemester
	 * Description: ����ѧ�ڲ鿴ѧ���γ�
	 * @param studentId ѧ��ID
	 * @param semester ѧ��
	 * @return     �γ̵��б�ArrayList��
	 * @throws RemoteException 
	 */
	public ArrayList<CourseVO> getCoursesBySemester(int studentId,String semester) throws RemoteException {
		ArrayList<CourseVO> voList = new ArrayList<CourseVO>();

		//ͨ��ID��ѯѧ��
		StudentPO studentPO = (StudentPO) studentDatabaseService.find(studentId);

		//POת��ΪVO
//		for(CoursePO coursePO:studentPO.getCourseList()) {
//			//�ж�ѧ���Ƿ����
//			if(coursePO.getEstablishTime().equals(semester)) {
//				voList.add(PoToVo.transformCoursePO(coursePO));
//			}
//		}

		return voList;
	}
	
	
    /**
     * Title: getTransferInfo
     * Description: �鿴׼��׼����Ϣ
     * @param studentId  ѧ��ID
     * @return    ׼��׼����Ϣ���
     * @throws RemoteException 
     */
    public TRANSFER_RESULT getTransferInfo(int studentId) throws RemoteException {
    	//ͨ��ID��ѯѧ��
		StudentPO studentPO = (StudentPO) studentDatabaseService.find(studentId);
		
		//TODO �ж�׼��׼�����Ե��߼�
		return null;
    	
    }
}
