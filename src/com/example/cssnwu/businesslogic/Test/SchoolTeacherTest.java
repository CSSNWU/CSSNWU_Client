package com.example.cssnwu.businesslogic.Test;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.example.cssnwu.businesslogic.controller.SchoolTeacherController;
import com.example.cssnwu.businesslogicservice.resultenum.Department;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.SchoolStrategyVO;
import com.example.cssnwu.vo.StudentVO;
import com.example.cssnwu.vo.TeacherVO;
import com.example.cssnwu.vo.VO;

public class SchoolTeacherTest {
	public static void main(String[] args)
	{	try {
		SchoolTeacherController teacherController=new SchoolTeacherController();
		SchoolStrategyVO stragetyVo=new SchoolStrategyVO();
		stragetyVo.id=1;
		stragetyVo.totalCredit=120;
		stragetyVo.minCreditPerSeason[0]=12;
		stragetyVo.minCreditPerSeason[1]=12;
		stragetyVo.minCreditPerSeason[2]=12;
		stragetyVo.minCreditPerSeason[3]=12;
		teacherController.realseSchoolStrategy(stragetyVo);   //测试发布整体框架
		/**
		 * 查看老师
		 */
		ArrayList<TeacherVO> teacherList=teacherController.getTeachers();
		/**
		 * 查看学生
		 */
		ArrayList<StudentVO> studentList=teacherController.getDropStudents();
		studentList=teacherController.getGraduateStudents();
		studentList=teacherController.getStayDownStudents();
		/**
		 * 测试导入学生
		 */
		StudentVO studentVo1=new StudentVO();
		StudentVO studentVo2=new StudentVO();
		ArrayList<VO> studentList2=new ArrayList<VO>();
		studentList2.add(studentVo1);
		studentList2.add(studentVo2);  //
		teacherController.addNewStudent(studentList2);////两学生信息全为空
		
		studentVo1.department=Department.软件学院;
		studentVo2.department=Department.地理学院;
		studentVo1.gender="女";
		studentVo2.gender="男";
		studentVo1.id=123;
		studentVo2.id=1234;
		studentVo1.password="123";
		studentVo2.password="1234";
		studentList2.clear();
		studentList2.add(studentVo1);
		studentList2.add(studentVo2);
		teacherController.addNewStudent(studentList2);
		/**
		 * 查看课程
		 */
		ArrayList<CourseVO> courseList=teacherController.getCourses();
		
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 	
		
	}

}
