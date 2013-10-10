/**
 * @(#)VoToPo.java     	2013-10-10 ����8:15:24
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.vo;

import java.util.ArrayList;

import com.example.cssnwu.po.CoursePO;
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
		ArrayList<TeacherPO> teacherPOList = new ArrayList<TeacherPO>();
		for(TeacherVO teacherVO:courseVO.teacherList) {
			teacherPOList.add(transformTeacherVO(teacherVO));
		}
		coursePO.setTeacherList(teacherPOList);
		
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
    

}
