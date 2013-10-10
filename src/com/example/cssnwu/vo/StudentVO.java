/**
 * @(#)StudentVO.java     	2013-10-5 ����4:07:02
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.vo;

import java.util.ArrayList;

import com.example.cssnwu.businesslogicservice.resultenum.Department;

/**
 *Class <code>StudentVO.java</code> ���ӱ��ֲ���߼����StudentVO
 *
 * @author never
 * @version 2013-10-5
 * @since JDK1.7
 */
public class StudentVO extends UserVO{
	 public Department department;            //����Ժϵ
	 public String grade;                     //�꼶
	 public double gpa;                       //ѧ�ּ�
	 public ArrayList<CourseVO> courseList;   //�γ��б�
	 public Department targetDepartment;      //Ŀ��Ժϵ����תԺ�����ѧ����һ��ѧ��������Ϊ�գ�
}
