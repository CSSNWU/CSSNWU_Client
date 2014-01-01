/**
 * @(#)VoToPo.java     	2013-10-10 ����8:15:24
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.vo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;


import com.example.cssnwu.businesslogicservice.resultenum.UserType;
import com.example.cssnwu.po.CoursePO;
import com.example.cssnwu.po.DepartmentPlanPO;
import com.example.cssnwu.po.SchoolStrategyPO;
import com.example.cssnwu.po.StudentPO;
import com.example.cssnwu.po.TeacherPO;

/**
 *Class <code>VoToPo.java</code> VOת��ΪPO�İ�����
 *
 * @author never
 * @version 2013-10-10
 * @since JDK1.7
 */
public class VoToPo {
    /**
     * Title: transformCourseVO
     * Description:  CourseVOת��ΪCoursePO
     * @param courseVO CourseVO
     * @return   CoursePO
     */
    public static CoursePO transformCourseVO(CourseVO courseVO) {
    	CoursePO coursePO = new CoursePO();
		//TODO voת��Ϊpo���߼�
		coursePO.setId(courseVO.id);
		coursePO.setCourseIntro(courseVO.courseIntro);
		coursePO.setCourseLocation(courseVO.courseLocation);
		coursePO.setCourseName(courseVO.courseName);
		coursePO.setCourseTime(courseVO.courseTime);
		coursePO.setCourseType(courseVO.courseType);
		coursePO.setCredit(courseVO.credit);
		coursePO.setEstablishTime(courseVO.establishTime);
		coursePO.setScore(courseVO.score);
		ArrayList<Integer> teacherIdList = new ArrayList<Integer>();
		ArrayList<String> teacherNameList = new ArrayList<String>();
		for(int i=0; i<courseVO.teacherIdList.size(); i++) {
			teacherIdList.add(courseVO.teacherIdList.get(i));
			teacherNameList.add(courseVO.teacherNameList.get(i));
		}
		coursePO.setTeacherIdList(teacherIdList);
		coursePO.setTeacherNameList(teacherNameList);
		
		return coursePO;
    }
    
    /**
     * Title: transformTeacherVO
     * Description:TeacherVOת��ΪTeacherPO
     * @param teacherVO TeacherVO
     * @return  TeacherPO
     */
    public static TeacherPO transformTeacherVO(TeacherVO teacherVO) {
    	TeacherPO teacherPO = new TeacherPO(teacherVO.userName, teacherVO.password, 
    			teacherVO.isLogin, teacherVO.userType);
    	teacherPO.setId(teacherVO.id);
    	teacherPO.setDepartment(teacherVO.department);
    	teacherPO.setCourseList(teacherVO.courseList);
    	
    	return teacherPO;
    }
    
    /**
     * Title: transformSchoolStrategyVO
     * Description: SchoolStrategyVOת��ΪSchoolStrategyPO
     * @param schoolStrategyVO  SchoolStrategyVO
     * @return  SchoolStrategyPO
     */
    public static SchoolStrategyPO transformSchoolStrategyVO(SchoolStrategyVO schoolStrategyVO) {
    	SchoolStrategyPO schoolStrategyPO = new SchoolStrategyPO();
    	schoolStrategyPO.setId(schoolStrategyVO.id);
    	schoolStrategyPO.setMinCreditPerSeason(schoolStrategyVO.minCreditPerSeason);
    	schoolStrategyPO.setTotalCredit(schoolStrategyVO.totalCredit);
    	
    	return schoolStrategyPO;
    	
    }
    
    /**Title: transformDepartmentPlanVO
     * Description:ת��ѧԺ����ƻ��ķ���
     * @param departmentPlanVO
     * @return
     */
    public static DepartmentPlanPO transformDepartmentPlanVO(DepartmentPlanVO departmentPlanVO) {
    	DepartmentPlanPO departmentPlanPO = new DepartmentPlanPO();
    	departmentPlanPO.setId(departmentPlanVO.id);
    	departmentPlanPO.setDepartment(departmentPlanVO.department);
        ArrayList<CoursePO> coursePOs = new ArrayList<CoursePO>();
        for(CourseVO courseVO:departmentPlanVO.courseList) {
        	coursePOs.add(transformCourseVO(courseVO));
        }
        departmentPlanPO.setCourseList(coursePOs);
        
    	return departmentPlanPO;
    }
    /**Title:transformStudentVO
     * Description:
     * @param studentVO
     * @return
     */
    public static StudentPO transformStudentVO(StudentVO studentVO)
    {   StudentPO studentPo=new StudentPO(studentVO.id,studentVO.userName,studentVO.password,
    		         false,UserType.Student);
        studentPo.setDepartment(studentVO.department);
        studentPo.setYearIntoSchool(Integer.parseInt(studentVO.year));
        studentPo.setGpa(0.0);
        studentPo.setGrade(1+"");
        studentPo.setTargetDepartment(studentVO.department);
        return studentPo;
        
        
        
    	
    }
    

}
