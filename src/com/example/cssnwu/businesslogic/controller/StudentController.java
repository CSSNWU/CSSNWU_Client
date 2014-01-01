/**
 * @(#)StudentController.java     	2013-10-10 ����10:30:54
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.businesslogic.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.example.cssnwu.businesslogic.domain.Student;
import com.example.cssnwu.businesslogicservice.bl.StudentBLService;
import com.example.cssnwu.businesslogicservice.resultenum.TRANSFER_RESULT;
import com.example.cssnwu.vo.CourseVO;

/**
 *Class <code>StudentController.java</code> ѧ��Ŀ�����
 *
 * @author never
 * @version 2013-10-10
 * @since JDK1.7
 */
public class StudentController implements StudentBLService {
    Student student = null;
    
    /**
     * ���췽��
     * @throws RemoteException
     */
    public StudentController() throws RemoteException {
    	student = new Student();
    }
    
	/* (non-Javadoc)
	 * Title: getCourses
	 * Description:ͨ��ID��ȡ��ѧ��Ŀγ��б�
	 * @see com.example.cssnwu.busxinesslogicservice.bl.StudentBLService#getCourses(int)
	 */
	@Override
	public ArrayList<CourseVO> getCourses(int studentId) throws RemoteException {
		return student.getCourses(studentId);
	}

	/* (non-Javadoc)
	 * Title: getTransferInfo
	 * Description:�鿴׼��׼����Ϣ
	 * @see com.example.cssnwu.businesslogicservice.bl.StudentBLService#getTransferInfo(int)
	 */
	@Override
	public TRANSFER_RESULT getTransferInfo(int studentId) throws RemoteException {
		return student.getTransferInfo(studentId);
	}

	/* (non-Javadoc)
	 * Title: getCoursesBySemester
	 * Description:���ѧ�ڲ鿴ѧ��γ�
	 * @see com.example.cssnwu.businesslogicservice.bl.StudentBLService#getCoursesBySemester(int, java.lang.String)
	 */
	@Override
	public ArrayList<CourseVO> getCoursesBySemester(int studentId,
			String semester) throws RemoteException {
		return student.getCoursesBySemester(studentId, semester);
	} 
  
}
