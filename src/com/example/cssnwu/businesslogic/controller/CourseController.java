/**
 * @(#)CourseController.java     	2013-10-10 ����2:06:49
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.businesslogic.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.example.cssnwu.businesslogic.domain.Course;
import com.example.cssnwu.businesslogic.domain.Teacher;
import com.example.cssnwu.businesslogicservice.bl.CourseBLService;
import com.example.cssnwu.businesslogicservice.resultenum.CourseType;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.StudentVO;

/**
 *Class <code>CourseController.java</code> �γ̵Ŀ�����
 *
 * @author never
 * @version 2013-10-10
 * @since JDK1.7
 */
public class CourseController implements CourseBLService {
    private Course course = null;
    private Teacher teacher = null;
    
    //���췽��
    public CourseController() throws RemoteException {
    	course = new Course();
    	teacher = new Teacher();
    }
    
	/* (non-Javadoc)
	 * Title: getAllCourse
	 * Description:��ȡ���еĿγ��б�
	 * @see com.example.cssnwu.businesslogicservice.bl.CourseBLService#getAllCourse()
	 */
	@Override
	public ArrayList<CourseVO> getAllCourse() throws RemoteException {
		return course.getAllCourse();
	}

	/* (non-Javadoc)
	 * Title: getCourseByType
	 * Description:��ȡĳ�����͵Ŀγ��б�
	 * @see com.example.cssnwu.businesslogicservice.bl.CourseBLService#getCourseByType(com.example.cssnwu.businesslogicservice.resultenum.CourseType)
	 */
	@Override
	public ArrayList<CourseVO> getCourseByType(CourseType courseType) throws RemoteException {
		return course.getCourseByType(courseType);
	}


	/* (non-Javadoc)
	 * Title: getStuByCourseId
	 * Description:��ȡѡ��ĳ�ſε�ѧ���б�
	 * @see com.example.cssnwu.businesslogicservice.bl.CourseBLService#getStuByCourseId(int)
	 */
	@Override
	public ArrayList<StudentVO> getStuByCourseId(int courseId) throws RemoteException {
		return teacher.getStuByCourseId(courseId);
	}

	/* (non-Javadoc)
	 * Title: getCourseById
	 * Description:ͨ����Ż�ȡ�γ�
	 * @see com.example.cssnwu.businesslogicservice.bl.CourseBLService#getCourseById(int)
	 */
	@Override
	public CourseVO getCourseById(int id) throws RemoteException {
		return course.getCourseById(id);
	}

}
