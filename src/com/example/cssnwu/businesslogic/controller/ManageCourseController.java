/**
 * @(#)ManageCourseController.java     	2013-10-9 ����3:48:34
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.businesslogic.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.example.cssnwu.businesslogic.domain.ManageCourse;
import com.example.cssnwu.businesslogicservice.bl.ManageCourseBLService;
import com.example.cssnwu.businesslogicservice.resultenum.ADD_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.DELETE_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.MANAGE_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.ManageCourseType;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.ManageCourseVO;

/**
 *Class <code>ManageCourseController.java</code> ����γ̵Ŀ�����
 *
 * @author never
 * @version 2013-10-9
 * @since JDK1.7
 */
public class ManageCourseController implements ManageCourseBLService{
    public static  ManageCourse manageCourse;
    
    
	public ManageCourseController() throws RemoteException {
		manageCourse = new ManageCourse();
	}
	
	/* (non-Javadoc)
	 * Title: getSelectedCourses
	 * Description:ͨ��id��ȡ��ѧ���Ѿ�ѡ��Ŀγ��б�
	 * @see com.example.cssnwu.businesslogicservice.bl.ManageCourseBLService#getSelectedCourses(int)
	 */
	@Override
	public ArrayList<CourseVO> getSelectedCourses(int studentId) throws RemoteException {
		return manageCourse.getSelectedCourses(studentId);
	}

	/* (non-Javadoc)
	 * Title: addStudent
	 * Description:   ��ʼ����γ�ʱ�����ִ�иò�����ѧ��
	 * @see com.example.cssnwu.businesslogicservice.bl.ManageCourseBLService#addStudent(com.example.cssnwu.vo.StudentVO)
	 */
	@Override
	public ADD_RESULT addStudent(int studentId) throws RemoteException {
		return manageCourse.addStudent(studentId);
	}

	/* (non-Javadoc)
	 * Title: addManageType
	 * Description:��ʼ����γ�ʱ����ӹ���γ̲���������
	 * @see com.example.cssnwu.businesslogicservice.bl.ManageCourseBLService#addManageType(com.example.cssnwu.businesslogicservice.resultenum.ManageCourseType)
	 */
	@Override
	public ADD_RESULT addManageType(ManageCourseType manageCourseType) {
		return manageCourse.addManageType(manageCourseType);
	}

	/* (non-Javadoc)
	 * Title: addCourse
	 * Description:�ڽ��пγ̹���ʱ������Ҫ������Ŀγ��б�����ӿγ�
	 * @see com.example.cssnwu.businesslogicservice.bl.ManageCourseBLService#addCourse(com.example.cssnwu.vo.CourseVO)
	 */
	@Override
	public ADD_RESULT addCourse(CourseVO courseVO) {
		return manageCourse.addCourse(courseVO);
	}

	/* (non-Javadoc)
	 * Title: deleteCourse
	 * Description:�ڽ��пγ̹���ʱ���ӽ�Ҫ����Ŀγ��б���ɾ���γ�
	 * @see com.example.cssnwu.businesslogicservice.bl.ManageCourseBLService#deleteCourse(com.example.cssnwu.vo.CourseVO)
	 */
	@Override
	public DELETE_RESULT deleteCourse(CourseVO courseVO) {
		return manageCourse.deleteCourse(courseVO);
	}

	/* (non-Javadoc)
	 * Title: endManage
	 * Description: �����γ̹���������������ύ������
	 * @see com.example.cssnwu.businesslogicservice.bl.ManageCourseBLService#endManage(com.example.cssnwu.vo.ManageCourseVO)
	 */
	@Override
	public MANAGE_RESULT endManage(ManageCourseVO manageCourseVO) throws RemoteException {
		return manageCourse.endManage(manageCourseVO);
	}

}
