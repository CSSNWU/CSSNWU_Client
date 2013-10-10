/**
 * @(#)StudentVO.java     	2013-10-5 下午4:07:02
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.vo;

import java.util.ArrayList;

import com.example.cssnwu.businesslogicservice.resultenum.Department;

/**
 *Class <code>StudentVO.java</code> 连接表现层和逻辑层的StudentVO
 *
 * @author never
 * @version 2013-10-5
 * @since JDK1.7
 */
public class StudentVO extends UserVO{
	 public Department department;            //所在院系
	 public String grade;                     //年级
	 public double gpa;                       //学分绩
	 public ArrayList<CourseVO> courseList;   //课程列表
	 public Department targetDepartment;      //目标院系（有转院需求的学生，一般学生该属性为空）
}
