/**
 * @(#)PoToVo.java     	2013-10-10 ����7:23:27
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.businesslogic.domain;

import com.example.cssnwu.po.CoursePO;
import com.example.cssnwu.po.DepartmentPlanPO;
import com.example.cssnwu.po.SchoolStrategyPO;
import com.example.cssnwu.po.StudentPO;
import com.example.cssnwu.po.TeacherPO;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.DepartmentPlanVO;
import com.example.cssnwu.vo.SchoolStrategyVO;
import com.example.cssnwu.vo.StudentVO;
import com.example.cssnwu.vo.TeacherVO;

/**
 *Class <code>PoToVo.java</code> poת��Ϊvo�İ�����
 *
 * @author never
 * @version 2013-10-10
 * @since JDK1.7
 */
public class PoToVo {
	
	/**
	 * Title: transformCoursePO
	 * Description: CoursePoת��ΪCourseVO
	 * @param coursePO  CoursePO
	 * @return  CourseVO
	 */
    public static CourseVO transformCoursePO(CoursePO coursePO) {
    	CourseVO courseVO = new CourseVO();
		//TODO poת��Ϊvo���߼�
		courseVO.id = coursePO.getId();
		courseVO.courseName = coursePO.getCourseName();
		courseVO.courseIntro = coursePO.getCourseIntro();
		courseVO.courseLocation = coursePO.getCourseLocation();
		courseVO.courseTime = coursePO.getCourseTime();
		courseVO.courseType = coursePO.getCourseType();
		courseVO.credit = coursePO.getCredit();
		courseVO.establishTime = courseVO.establishTime;
		for(TeacherPO teacherPO:coursePO.getTeacherList()) {
			courseVO.teacherList.add(transformTeacherPO(teacherPO));
		}
		
		return courseVO;
    }
    
    /**
     * Title: transformTeacherPO
     * Description: TeacherPOת��ΪTeacherVO
     * @param teacherPO TeacherPO
     * @return  TeacherVO
     */
    public static TeacherVO transformTeacherPO(TeacherPO teacherPO) {
    	TeacherVO teacherVO = new TeacherVO();
    	//TODO poת��Ϊvo���߼�
    	teacherVO.id = teacherPO.getId();
    	teacherVO.department = teacherPO.getDepartment();
    	teacherVO.courseList = teacherPO.getCourseList();
    	
    	return teacherVO;
    }
    
    /**
     * Title: transformSchoolStrategyPO
     * Description: SchoolStrategyPOת��ΪSchoolStrategyVO
     * @param schoolStrategyPO SchoolStrategyPO
     * @return SchoolStrategyVO
     */
    public static SchoolStrategyVO transformSchoolStrategyPO(SchoolStrategyPO schoolStrategyPO) {
    	SchoolStrategyVO schoolStrategyVO = new SchoolStrategyVO();
    	//TODO poת��Ϊvo���߼�
    	schoolStrategyVO.id = schoolStrategyPO.getId();
    	schoolStrategyVO.minCreditPerSemester = schoolStrategyPO.getMinCreditPerSemester();
    	schoolStrategyVO.totalCredit = schoolStrategyPO.getTotalCredit();
    	schoolStrategyVO.creditArrangeMent = schoolStrategyPO.getCreditArrangeMent();
    	
    	return schoolStrategyVO;
    }
    
    /**
     * Title: transformStudentPO
     * Description:  StudentPOת��ΪStudentVO
     * @param studentPO StudentPO
     * @return StudentVO
     */
    public static StudentVO transformStudentPO(StudentPO studentPO) {
    	StudentVO studentVO = new StudentVO();
    	studentVO.id = studentPO.getId();
    	studentVO.department = studentPO.getDepartment();
    	studentVO.gpa = studentPO.getGpa();
    	studentVO.grade = studentPO.getGrade();
    	studentVO.password = studentPO.getPassword();
    	studentVO.userName = studentPO.getUserName();
    	studentVO.userType = studentPO.getUserType();
    	studentVO.targetDepartment = studentPO.getTargetDepartment();
    	for(CoursePO coursePO:studentPO.getCourseList()) {
    		studentVO.courseList.add(transformCoursePO(coursePO));
    	}
    	
    	return studentVO;
    }
    
    /**
     * Title: transformDepartPlanPO
     * Description: DepartmentPlanPOת��ΪDepartmentPlanVO
     * @param departmentPlanPO DepartmentPlanPO
     * @return DepartmentPlanVO
     */
    public static DepartmentPlanVO transformDepartPlanPO(DepartmentPlanPO departmentPlanPO) {
    	DepartmentPlanVO departmentPlanVO = new DepartmentPlanVO();
    	//TODO poת��Ϊvo���߼�
    	departmentPlanVO.id = departmentPlanPO.getId();
        departmentPlanVO.date = departmentPlanPO.getDate();
        departmentPlanVO.department = departmentPlanPO.getDepartment();
        for(CoursePO coursePO:departmentPlanPO.getCourseList()) {
        	departmentPlanVO.courseList.add(transformCoursePO(coursePO));
        }
        
        return departmentPlanVO;
    }
}


