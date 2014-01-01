/**
 * @(#)DeptTeacherBLService_Stub.java     	2013-10-13 ����12:00:36
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.example.cssnwu.businesslogicservice.bl.DeptTeacherBLService;
import com.example.cssnwu.businesslogicservice.resultenum.Department;
import com.example.cssnwu.businesslogicservice.resultenum.INSERT_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.UPDATE_RESULT;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.DepartmentPlanVO;
import com.example.cssnwu.vo.StudentVO;

/**
 *Class <code>DeptTeacherBLService_Stub.java</code> DeptTeacherBLService�ӿڵ�׮.
 *
 * @author never
 * @version 2013-10-13
 * @since JDK1.7
 */
public class DeptTeacherBLService_Stub implements DeptTeacherBLService {

	/* (non-Javadoc)
	 * Title: drawDeptPlan
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.DeptTeacherBLService#drawDeptPlan(com.example.cssnwu.vo.DepartmentPlanVO)
	 */
	@Override
	public INSERT_RESULT drawDeptPlan(DepartmentPlanVO departmentPlanVO)
			throws RemoteException {
		if (departmentPlanVO.id == 100) {
			return INSERT_RESULT.����ɹ�;
		} else {
			return INSERT_RESULT.ID�Ѿ�����;
		}
	}

	/* (non-Javadoc)
	 * Title: releaseCourse
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.DeptTeacherBLService#releaseCourse(com.example.cssnwu.vo.CourseVO)
	 */
	@Override
	public INSERT_RESULT releaseCourse(CourseVO courseVO)
			throws RemoteException {
		if (courseVO.id == 0) {
			return INSERT_RESULT.����ɹ�;
		} else {
			return INSERT_RESULT.ID�Ѿ�����;
		}
	}

	/* (non-Javadoc)
	 * Title: modifyCourseInfo
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.DeptTeacherBLService#modifyCourseInfo(com.example.cssnwu.vo.CourseVO)
	 */
	@Override
	public UPDATE_RESULT modifyCourseInfo(CourseVO courseVO)
			throws RemoteException {
         if (courseVO.id == 0) {
        	 return UPDATE_RESULT.���³ɹ�;
         } else {
        	 return UPDATE_RESULT.�������˴���;
         }
	}

	/* (non-Javadoc)
	 * Title: getDeptCourses
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.DeptTeacherBLService#getDeptCourses(com.example.cssnwu.businesslogicservice.resultenum.Department)
	 */
	@Override
	public ArrayList<CourseVO> getDeptCourses(Department department)
			throws RemoteException {
		ArrayList<CourseVO> courseVOs = new ArrayList<CourseVO>();
		if (department == Department.���ѧԺ) {
			courseVOs = new DataHelper().courseVOs;
		}
		return courseVOs;
	}

	/* (non-Javadoc)
	 * Title: getCourse
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.DeptTeacherBLService#getCourse(int)
	 */
	@Override
	public CourseVO getCourse(int courseId) throws RemoteException {
		return new DataHelper().courseVOs.get(courseId);
	}

	/* (non-Javadoc)
	 * Title: getStuByCourse
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.DeptTeacherBLService#getStuByCourse(int, com.example.cssnwu.businesslogicservice.resultenum.Department)
	 */
	@Override
	public ArrayList<StudentVO> getStuByCourse(int courseId,
			Department department) throws RemoteException {
		
		return new DataHelper().studentVOs;
	}

}
