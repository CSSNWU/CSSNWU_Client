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
			controller.drawDeptPlan(vo1);// Ժϵ�ƻ���Ϣ��ȫ
			
			vo1.minCreditPerSeason[2]=23;
			vo1.minCreditPerSeason[3]=23;
			controller.drawDeptPlan(vo1);///�ɹ�����
		
//			vo1=controller.drawDeptPlan()
		    /*
		     * �����γ�	
		     */
			CourseVO vo2=new CourseVO();
			controller.releaseCourse(vo2);// �γ���ϢΪ��
			vo2.courseIntro="���˼������й��ִ�������";
			vo2.courseLocation="����3";
			vo2.courseName="���˼";
			vo2.courseTime="�ܶ�/2-3";
			controller.releaseCourse(vo2);        ///����ĵص���Ϣ
			vo2.courseLocation="����";
			controller.releaseCourse(vo2);       ///�ɹ�����
			
			/*
			 * ���ѧԺ�γ�
			 */
			ArrayList<CourseVO> list=controller.getDeptCourses(Department.���ѧԺ);
			/*
			 * �޸�һ�ſγ�
			 */
			CourseVO vo3=controller.getCourse(111); ///����Ŀγ��б�
			vo3=controller.getCourse(20111);
			vo3.courseLocation="��¥";
			vo3.courseType=CourseType.ָѡ��;
			controller.modifyCourseInfo(vo3);          ///�ɹ��޸�
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
}
