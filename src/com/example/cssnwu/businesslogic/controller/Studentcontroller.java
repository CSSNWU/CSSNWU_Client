/**
 * @(#)Studentcontroller.java     	2013-10-10 上午10:30:54
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
 *Class <code>Studentcontroller.java</code> 学生的控制器
 *
 * @author never
 * @version 2013-10-10
 * @since JDK1.7
 */
public class Studentcontroller implements StudentBLService {
    Student student = null;
    
    /**
     * 构造方法
     * @throws RemoteException
     */
    public Studentcontroller() throws RemoteException {
    	student = new Student();
    }
    
	/* (non-Javadoc)
	 * Title: getCourses
	 * Description:通过ID获取该学生的课程列表
	 * @see com.example.cssnwu.businesslogicservice.bl.StudentBLService#getCourses(int)
	 */
	@Override
	public ArrayList<CourseVO> getCourses(int studentId) throws RemoteException {
		return student.getCourses(studentId);
	}

	/* (non-Javadoc)
	 * Title: getTransferInfo
	 * Description:查看准入准出信息
	 * @see com.example.cssnwu.businesslogicservice.bl.StudentBLService#getTransferInfo(int)
	 */
	@Override
	public TRANSFER_RESULT getTransferInfo(int studentId) throws RemoteException {
		return student.getTransferInfo(studentId);
	}

	/* (non-Javadoc)
	 * Title: getCoursesBySemester
	 * Description:根据学期查看学生课程
	 * @see com.example.cssnwu.businesslogicservice.bl.StudentBLService#getCoursesBySemester(int, java.lang.String)
	 */
	@Override
	public ArrayList<CourseVO> getCoursesBySemester(int studentId,
			String semester) throws RemoteException {
		return student.getCoursesBySemester(studentId, semester);
	} 
  
}
