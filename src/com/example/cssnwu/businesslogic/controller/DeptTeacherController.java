/**
 * @(#)DeptTeacherController.java     	2013-10-9 下午11:40:38
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.businesslogic.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.example.cssnwu.businesslogic.domain.DeptTeacher;
import com.example.cssnwu.businesslogicservice.bl.DeptTeacherBLService;
import com.example.cssnwu.businesslogicservice.resultenum.Department;
import com.example.cssnwu.businesslogicservice.resultenum.INSERT_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.UPDATE_RESULT;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.DepartmentPlanVO;
import com.example.cssnwu.vo.StudentVO;

/**
 *Class <code>DeptTeacherController.java</code> 院系教务老师的控制器
 *
 * @author never
 * @version 2013-10-9
 * @since JDK1.7
 */
public class DeptTeacherController implements DeptTeacherBLService{
    private DeptTeacher deptTeacher = null;
    
    //构造方法
    public DeptTeacherController() throws RemoteException {
    	deptTeacher = new DeptTeacher();
    }
	/* (non-Javadoc)
	 * Title: drawDeptPlan
	 * Description: 制定院系教学计划
	 * @see com.example.cssnwu.businesslogicservice.bl.DeptTeacherBLService#drawDeptPlan(com.example.cssnwu.vo.DepartmentPlanVO)
	 */
	@Override
	public INSERT_RESULT drawDeptPlan(DepartmentPlanVO departmentPlanVO) throws RemoteException {
		return deptTeacher.drawDeptPlan(departmentPlanVO);
	}

	/* (non-Javadoc)
	 * Title: releaseCourse
	 * Description:发布课程
	 * @see com.example.cssnwu.businesslogicservice.bl.DeptTeacherBLService#releaseCourse(com.example.cssnwu.vo.CourseVO)
	 */
	@Override
	public INSERT_RESULT releaseCourse(CourseVO courseVO) throws RemoteException {
		return deptTeacher.releaseCourse(courseVO);
	}

	/* (non-Javadoc)
	 * Title: modifyCourseInfo
	 * Description:修改课程信息
	 * @see com.example.cssnwu.businesslogicservice.bl.DeptTeacherBLService#modifyCourseInfo(com.example.cssnwu.vo.CourseVO)
	 */
	@Override
	public UPDATE_RESULT modifyCourseInfo(CourseVO courseVO) throws RemoteException {
		return deptTeacher.modifyCourseInfo(courseVO);
	}

	/* (non-Javadoc)
	 * Title: getDeptCourses
	 * Description:查看本院课程列表
	 * @see com.example.cssnwu.businesslogicservice.bl.DeptTeacherBLService#getDeptCourses(com.example.cssnwu.businesslogicservice.resultenum.Department)
	 */
	@Override
	public ArrayList<CourseVO> getDeptCourses(Department department) throws RemoteException {
		return deptTeacher.getDeptCourses(department);
	}

	/* (non-Javadoc)
	 * Title: getCourse
	 * Description:查看本院任意课程信息
	 * @see com.example.cssnwu.businesslogicservice.bl.DeptTeacherBLService#getCourse(int)
	 */
	@Override
	public CourseVO getCourse(int courseId) throws RemoteException {
		return deptTeacher.getCourse(courseId);
	}

	/* (non-Javadoc)
	 * Title: getStuByCourse
	 * Description:查看本院任意课程的学生列表
	 * @see com.example.cssnwu.businesslogicservice.bl.DeptTeacherBLService#getStuByCourse(int, com.example.cssnwu.businesslogicservice.resultenum.Department)
	 */
	@Override
	public ArrayList<StudentVO> getStuByCourse(int courseId,
			Department department) throws RemoteException {
		return deptTeacher.getStuByCourse(courseId, department);
	}

}
