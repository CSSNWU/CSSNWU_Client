package com.example.cssnwu.businesslogic.Test;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.example.cssnwu.businesslogic.controller.ManageCourseController;
import com.example.cssnwu.businesslogic.controller.StudentController;
import com.example.cssnwu.businesslogicservice.resultenum.CourseType;
import com.example.cssnwu.businesslogicservice.resultenum.ManageCourseType;
import com.example.cssnwu.vo.CourseVO;

public class StudentTest {
	public static void main(String[] args)
	{   try {
		StudentController StudentController=new StudentController();
		ManageCourseController manageCourseController=new ManageCourseController();
		manageCourseController.addStudent(1);
		manageCourseController.addManageType(ManageCourseType.select);
		CourseVO vo1=new CourseVO();
		CourseVO vo2=new CourseVO();
		vo1.courseTime="周一/7-8";
		vo1.courseLocation="仙林";
		vo2.courseTime="周二/1-2";
		vo2.courseLocation="仙林";
		manageCourseController.addCourse(vo1);
		manageCourseController.addCourse(vo2);
		manageCourseController.endManage();////TUS11-1
		/**
		 * TUS12 退课
		 * 
		 */
	    manageCourseController.addStudent(1);
	    manageCourseController.addManageType(ManageCourseType.quit);
	    vo1.courseTime="周一/7-8";
	    vo1.courseType=CourseType.公选课;
	    manageCourseController.addCourse(vo1);
	    manageCourseController.endManage();///TUS12-1
	    
	    manageCourseController.addStudent(1);
	    manageCourseController.addManageType(ManageCourseType.quit);
	    vo2.courseTime="周一/5-7";
	    vo2.courseType=CourseType.指选课;
	    manageCourseController.addCourse(vo2);
	    manageCourseController.endManage();////TUS12-2
	    
	    /*
	     * 
	     */
	    
	    ArrayList<CourseVO> list=StudentController.getCourses(1);  ///正确读入
//	    System.out.println();
	    list=StudentController.getCourses(12324234);///无此学生
	    
	    
	    
		
		
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		 
	}

}
