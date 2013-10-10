/**
 * @(#)SchoolTeacherController.java     	2013-10-10 上午10:46:01
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.businesslogic.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.example.cssnwu.businesslogic.domain.SchoolTeacher;
import com.example.cssnwu.businesslogicservice.bl.SchoolTeacherBLService;
import com.example.cssnwu.businesslogicservice.resultenum.INSERT_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.UPDATE_RESULT;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.DepartmentPlanVO;
import com.example.cssnwu.vo.SchoolStrategyVO;
import com.example.cssnwu.vo.StudentVO;
import com.example.cssnwu.vo.TeacherVO;

/**
 *Class <code>SchoolTeacherController.java</code> 学校教务老师的控制器
 *
 * @author never
 * @version 2013-10-10
 * @since JDK1.7
 */
public class SchoolTeacherController implements SchoolTeacherBLService {
    private SchoolTeacher schoolTeacher = null;
    
    public SchoolTeacherController() throws RemoteException {
    	schoolTeacher = new SchoolTeacher();
    }
	
	/* (non-Javadoc)
	 * Title: realseSchoolStrategy
	 * Description:输入整体框架策略
	 * @see com.example.cssnwu.businesslogicservice.bl.SchoolTeacherBLService#realseSchoolStrategy(com.example.cssnwu.vo.SchoolStrategyVO)
	 */
	@Override
	public INSERT_RESULT realseSchoolStrategy(SchoolStrategyVO schoolStrategyVO) throws RemoteException {
		return schoolTeacher.realseSchoolStrategy(schoolStrategyVO);
	}

	/* (non-Javadoc)
	 * Title: modifySchoolStrategy
	 * Description:修改整体框架策略
	 * @see com.example.cssnwu.businesslogicservice.bl.SchoolTeacherBLService#modifySchoolStrategy(com.example.cssnwu.vo.SchoolStrategyVO)
	 */
	@Override
	public UPDATE_RESULT modifySchoolStrategy(SchoolStrategyVO schoolStrategyVO) throws RemoteException {
		return schoolTeacher.modifySchoolStrategy(schoolStrategyVO);
	}

	/* (non-Javadoc)
	 * Title: getSchoolStrategy
	 * Description:查看整体框架策略
	 * @see com.example.cssnwu.businesslogicservice.bl.SchoolTeacherBLService#getSchoolStrategy()
	 */
	@Override
	public SchoolStrategyVO getSchoolStrategy() throws RemoteException {
		return schoolTeacher.getSchoolStrategy();
	}

	/* (non-Javadoc)
	 * Title: getDepartmentPlans
	 * Description:查看各院系教学计划
	 * @see com.example.cssnwu.businesslogicservice.bl.SchoolTeacherBLService#getDepartmentPlans()
	 */
	@Override
	public ArrayList<DepartmentPlanVO> getDepartmentPlans() throws RemoteException {
		return schoolTeacher.getDepartmentPlans();
	}

	/* (non-Javadoc)
	 * Title: getTeachers
	 * Description:查看教师统计信息
	 * @see com.example.cssnwu.businesslogicservice.bl.SchoolTeacherBLService#getTeachers()
	 */
	@Override
	public ArrayList<TeacherVO> getTeachers() throws RemoteException {
		return schoolTeacher.getTeachers();
	}

	/* (non-Javadoc)
	 * Title: getCourses
	 * Description:查看课程统计信息
	 * @see com.example.cssnwu.businesslogicservice.bl.SchoolTeacherBLService#getCourses()
	 */
	@Override
	public ArrayList<CourseVO> getCourses() throws RemoteException {
		return schoolTeacher.getCourses();
	}

	/* (non-Javadoc)
	 * Title: getTransferStudents
	 * Description:查看学生准入准出信息
	 * @see com.example.cssnwu.businesslogicservice.bl.SchoolTeacherBLService#getTransferStudents()
	 */
	@Override
	public ArrayList<StudentVO> getTransferStudents() throws RemoteException {
		return schoolTeacher.getTransferStudents();
	}

	/* (non-Javadoc)
	 * Title: getGraduateStudents
	 * Description:查看学生毕业资格统计
	 * @see com.example.cssnwu.businesslogicservice.bl.SchoolTeacherBLService#getGraduateStudents()
	 */
	@Override
	public ArrayList<StudentVO> getGraduateStudents() throws RemoteException {
		return schoolTeacher.getGraduateStudents();
	}

	/* (non-Javadoc)
	 * Title: getStayDownStudents
	 * Description:查看留级的学生统计信息
	 * @see com.example.cssnwu.businesslogicservice.bl.SchoolTeacherBLService#getStayDownStudents()
	 */
	@Override
	public ArrayList<StudentVO> getStayDownStudents() throws RemoteException {
		return schoolTeacher.getStayDownStudents();
	}

	/* (non-Javadoc)
	 * Title: getDropStudents
	 * Description:查看退学的学生统计信息
	 * @see com.example.cssnwu.businesslogicservice.bl.SchoolTeacherBLService#getDropStudents()
	 */
	@Override
	public ArrayList<StudentVO> getDropStudents() throws RemoteException {
		return schoolTeacher.getDropStudents();
	}
  
}
