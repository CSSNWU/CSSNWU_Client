/**
 * @(#)TeacherController.java     	2013-10-9 下午9:13:04
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.businesslogic.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.cssnwu.businesslogic.domain.Teacher;
import com.example.cssnwu.businesslogicservice.bl.TeacherBLService;
import com.example.cssnwu.businesslogicservice.resultenum.UPDATE_RESULT;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.StudentVO;

/**
 *Class <code>TeacherController.java</code> Teacher对象的控制器
 *
 * @author never
 * @version 2013-10-9
 * @since JDK1.7
 */
public class TeacherController implements TeacherBLService {
    private Teacher teacher = null;
	
    //构造方法
	public TeacherController() throws RemoteException {
		this.teacher = new Teacher();
	}
	/* (non-Javadoc)
	 * Title: getStuByCourseId
	 * Description:获取选择某门课的学生列表
	 * @see com.example.cssnwu.businesslogicservice.bl.TeacherBLService#getStuByCourseId(int)
	 */
	@Override
	public ArrayList<StudentVO> getStuByCourseId(int courseId) throws RemoteException {
		return teacher.getStuByCourseId(courseId);
	}

	/* (non-Javadoc)
	 * Title: updateCourseInfo
	 * Description:任课老师填写课程信息（课程大纲、教程、参考书目）
	 * @see com.example.cssnwu.businesslogicservice.bl.TeacherBLService#updateCourseInfo(com.example.cssnwu.vo.CourseVO)
	 */
	@Override
	public UPDATE_RESULT updateCourseInfo(CourseVO courseVO) throws RemoteException {
		return teacher.updateCourseInfo(courseVO);
	}

	/* (non-Javadoc)
	 * Title: registerScore
	 * Description:任课老师登记成绩
	 * @see com.example.cssnwu.businesslogicservice.bl.TeacherBLService#registerScore(int, java.util.HashMap)
	 */
	@Override
	public UPDATE_RESULT registerScore(int courseId,
			HashMap<Integer, Double> map) throws RemoteException {
		return teacher.registerScore(courseId, map);
	}

}
