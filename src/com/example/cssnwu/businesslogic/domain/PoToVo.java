/**
 * @(#)PoToVo.java     	2013-10-10 下午7:23:27
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
 *Class <code>PoToVo.java</code> po转化为vo的帮助类
 *
 * @author never
 * @version 2013-10-10
 * @since JDK1.7
 */
public class PoToVo {
	
	/**
	 * Title: transformCoursePO
	 * Description: CoursePo转化为CourseVO
	 * @param coursePO  CoursePO
	 * @return  CourseVO
	 */
    public static CourseVO transformCoursePO(CoursePO coursePO) {
    	CourseVO courseVO = new CourseVO();
		//TODO po转化为vo的逻辑
		courseVO.id = coursePO.getId();
		courseVO.courseName = coursePO.getCourseName();
		courseVO.courseIntro = coursePO.getCourseIntro();
		courseVO.courseLocation = coursePO.getCourseLocation();
		courseVO.courseTime = coursePO.getCourseTime();
		courseVO.courseType = coursePO.getCourseType();
		courseVO.credit = coursePO.getCredit();
		courseVO.establishTime = coursePO.getEstablishTime();
		courseVO.teacherIdList = coursePO.getTeacherIdList();
		courseVO.teacherNameList = coursePO.getTeacherNameList();
		courseVO.score=coursePO.getScore();
		
		return courseVO;
    }
    
    /**
     * Title: transformTeacherPO
     * Description: TeacherPO转化为TeacherVO
     * @param teacherPO TeacherPO
     * @return  TeacherVO
     */
    public static TeacherVO transformTeacherPO(TeacherPO teacherPO) {
    	TeacherVO teacherVO = new TeacherVO();
    	//TODO po转化为vo的逻辑
    	teacherVO.id = teacherPO.getId();
    	teacherVO.userName=teacherPO.getUserName();
    	teacherVO.department = teacherPO.getDepartment();
    	teacherVO.courseList = teacherPO.getCourseList();
    	for(int i=0;i<teacherPO.getCoursePOList().size();i++)
    	{
    	teacherVO.courseVOList.add(PoToVo.transformCoursePO(teacherPO.getCoursePOList().get(i)));
    	}
    	return teacherVO;
    }
    
    /**
     * Title: transformSchoolStrategyPO
     * Description: SchoolStrategyPO转化为SchoolStrategyVO
     * @param schoolStrategyPO SchoolStrategyPO
     * @return SchoolStrategyVO
     */
    public static SchoolStrategyVO transformSchoolStrategyPO(SchoolStrategyPO schoolStrategyPO) {
    	SchoolStrategyVO schoolStrategyVO = new SchoolStrategyVO();
    	//TODO po转化为vo的逻辑
    	schoolStrategyVO.id = schoolStrategyPO.getId();
    	for(int i=0;i<schoolStrategyPO.getMinCreditPerSeason().length;i++) {
    		schoolStrategyVO.minCreditPerSeason[i] = schoolStrategyPO.getMinCreditPerSeason()[i];
    	}
    	schoolStrategyVO.totalCredit = schoolStrategyPO.getTotalCredit();
    	
    	return schoolStrategyVO;
    }
    
    /**
     * Title: transformStudentPO
     * Description:  StudentPO转化为StudentVO
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
    	for(CoursePO course:studentPO.getCoursePOList()) {
    		
    		studentVO.courseList.add(course.getCourseName());
    	}
    	
    	return studentVO;
    }
    
    /**
     * Title: transformDepartPlanPO
     * Description: DepartmentPlanPO转化为DepartmentPlanVO
     * @param departmentPlanPO DepartmentPlanPO
     * @return DepartmentPlanVO
     */
    public static DepartmentPlanVO transformDepartPlanPO(DepartmentPlanPO departmentPlanPO) {
    	DepartmentPlanVO departmentPlanVO = new DepartmentPlanVO();
         
    	//TODO po转化为vo的逻辑
    	departmentPlanVO.id = departmentPlanPO.getId();
        departmentPlanVO.department = departmentPlanPO.getDepartment();
        departmentPlanVO.minCreditPerSeason[0]=departmentPlanPO.minCourseCredits[0];
        departmentPlanVO.minCreditPerSeason[1]=departmentPlanPO.minCourseCredits[1];
        departmentPlanVO.minCreditPerSeason[2]=departmentPlanPO.minCourseCredits[2];
        departmentPlanVO.minCreditPerSeason[3]=departmentPlanPO.minCourseCredits[3];
        if(!departmentPlanPO.getCourseList().isEmpty())
        { 	for(CoursePO coursePO:departmentPlanPO.getCourseList()) {
        		departmentPlanVO.courseList.add(transformCoursePO(coursePO));
        	}
        }else{
        	System.out.println("为空");
        }
        return departmentPlanVO;
    }
}


