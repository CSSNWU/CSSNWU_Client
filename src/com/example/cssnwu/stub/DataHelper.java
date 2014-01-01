/**
 * @(#)DataHelper.java     	2013-10-12 ����10:33:05
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.stub;

import java.util.ArrayList;

import com.example.cssnwu.businesslogic.domain.Teacher;
import com.example.cssnwu.businesslogicservice.resultenum.CourseType;
import com.example.cssnwu.businesslogicservice.resultenum.Department;
import com.example.cssnwu.businesslogicservice.resultenum.UserType;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.DepartmentPlanVO;
import com.example.cssnwu.vo.SchoolStrategyVO;
import com.example.cssnwu.vo.StudentVO;
import com.example.cssnwu.vo.TeacherVO;

/**
 *Class <code>DataHelper.java</code> ���ݰ�����.
 *
 * @author never
 * @version 2013-10-12
 * @since JDK1.7
 */
public class DataHelper {
    public ArrayList<CourseVO> courseVOs = new ArrayList<CourseVO>();
    public ArrayList<TeacherVO> teacherVOs = new ArrayList<TeacherVO>();
    public ArrayList<DepartmentPlanVO> departmentPlanVOs = new ArrayList<DepartmentPlanVO>();
    public SchoolStrategyVO schoolStrategyVO;
    public ArrayList<StudentVO> studentVOs = new ArrayList<StudentVO>();
    
    public DataHelper() {
    	for(int i=0;i<10;i++) {
    		TeacherVO teacherVO = new TeacherVO();
    		teacherVO.id = 10 + i;
    		teacherVO.courseList.add(i);
    		teacherVO.department = Department.���ѧԺ;
    		teacherVOs.add(teacherVO);
    	}
    	
    	
    	for (int i = 0; i < 10; i++) {
    		CourseVO courseVO = new CourseVO();
    		courseVO.id = i;
    		courseVO.courseName = ("�γ�" + i);
    		courseVO.courseIntro = ("�γ̽���" + i);
    		courseVO.courseLocation = ("����У��/��һ20" + i);
    		courseVO.courseTime = ("��һ/1~" + i);
    		courseVO.courseType = CourseType.��ѡ��;
    		courseVO.credit = 3;
    		courseVO.establishTime = 20131 + "";
    		courseVO.teacherIdList.add(teacherVOs.get(1).id);
    		courseVO.teacherNameList.add(teacherVOs.get(i).userName);
    		courseVOs.add(courseVO);
    	}
    	
    	for (int i = 0; i < 2; i++) {
    		DepartmentPlanVO departmentPlanVO = new DepartmentPlanVO();
    		departmentPlanVO.id = 100 + i;
    		departmentPlanVO.minCreditPerSeason=new int[4];
    		departmentPlanVO.minCreditPerSeason[0]=1;
    		departmentPlanVO.minCreditPerSeason[1]=2;
    		departmentPlanVO.minCreditPerSeason[2]=3;
    		departmentPlanVO.minCreditPerSeason[3]=4;
    		departmentPlanVO.courseList.add(courseVOs.get(i));
    		departmentPlanVO.courseList.add(courseVOs.get(2 * i + 2));
    		departmentPlanVO.department = Department.���ѧԺ;
    		departmentPlanVOs.add(departmentPlanVO);
    	}
    	
    	for(int i = 0; i<10; i++) {
    		StudentVO studentVO = new StudentVO();
    		studentVO.id = 1000 + i;
    		studentVO.department = Department.���ѧԺ;
    		studentVO.grade = "2013";
    		studentVO.userName = "�û���" + i;
    		studentVO.userType = UserType.Student;
    		studentVO.password = "1000" + i;
//    		studentVO.courseList.add(courseVOs.get(i));
    		studentVOs.add(studentVO);
    	}
    	
    	schoolStrategyVO = new SchoolStrategyVO();
    	schoolStrategyVO.id = 2001;
    	for(int i=0;i<4;i++) {
    		schoolStrategyVO.minCreditPerSeason[i] = 27;
    	}
    	schoolStrategyVO.totalCredit = 108;
    	
    }
}
