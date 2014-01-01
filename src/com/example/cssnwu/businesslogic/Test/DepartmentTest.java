package com.example.cssnwu.businesslogic.Test;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.example.cssnwu.businesslogic.controller.DeptTeacherController;
import com.example.cssnwu.businesslogicservice.resultenum.CourseType;
import com.example.cssnwu.businesslogicservice.resultenum.Department;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.DepartmentPlanVO;

public class DepartmentTest {
	public static void main(String[] args)
	{     try {
			DeptTeacherController controller=new DeptTeacherController();
			DepartmentPlanVO vo1=new DepartmentPlanVO();
			vo1.minCreditPerSeason[0]=23;
			vo1.minCreditPerSeason[1]=23;
			//vo1.minCreditPerSeason[2]=23;
			//vo1.minCreditPerSeason[3]=23;
			controller.drawDeptPlan(vo1);// 院系计划信息不全
			
			vo1.minCreditPerSeason[2]=23;
			vo1.minCreditPerSeason[3]=23;
			controller.drawDeptPlan(vo1);///成功发表
		
//			vo1=controller.drawDeptPlan()
		    /*
		     * 发布课程	
		     */
			CourseVO vo2=new CourseVO();
			controller.releaseCourse(vo2);// 课程信息为空
			vo2.courseIntro="马克思主义的中国现代化表述";
			vo2.courseLocation="仙林3";
			vo2.courseName="马克思";
			vo2.courseTime="周二/2-3";
			controller.releaseCourse(vo2);        ///错误的地点信息
			vo2.courseLocation="仙林";
			controller.releaseCourse(vo2);       ///成功发表
			
			/*
			 * 获得学院课程
			 */
			ArrayList<CourseVO> list=controller.getDeptCourses(Department.软件学院);
			/*
			 * 修改一门课程
			 */
			CourseVO vo3=controller.getCourse(111); ///错误的课程列表
			vo3=controller.getCourse(20111);
			vo3.courseLocation="鼓楼";
			vo3.courseType=CourseType.指选课;
			controller.modifyCourseInfo(vo3);          ///成功修改
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
}
