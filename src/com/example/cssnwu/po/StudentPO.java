/**
 * @(#)StudentPO.java     	2013-10-4 下午8:36:46
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.po;

import java.util.ArrayList;

import com.example.cssnwu.businesslogicservice.resultenum.Department;
import com.example.cssnwu.businesslogicservice.resultenum.StudentType;
import com.example.cssnwu.businesslogicservice.resultenum.UserType;

/**
 *Class <code>StudentPO.java</code> 学生
 *
 * @author never
 * @version 2013-10-4
 * @since JDK1.7
 */
@SuppressWarnings("serial")
public class StudentPO extends UserPO{
	Department department;            //所在院系
    String grade;                     //年级
    double gpa;                       //学分绩
    int year;						  //入学年份
    ArrayList<CoursePO> courseList;   //课程列表
//    ArrayList<Integer> courseIdList;   //课程编号列表
    Department targetDepartment;      //目标院系（有转院需求的学生，一般学生该属性为空）
    StudentType studentType;
    
    /**构造方法
	 * @param userName    
	 * @param password
	 * @param isLogin
	 * @param userType
	 */
    
    
    public StudentPO(String userName, String password, boolean isLogin,
			UserType userType) {
		super(userName, password, isLogin, userType);
	}
    public StudentPO(int id,String userName, String password, boolean isLogin,
			UserType userType) {
		super(userName, password, isLogin, userType);
		super.id = id;
	}
    
    
    //getter方法
    /**
     *
     *	获得学生类型的方法
     *	@author zyf
     *	@param null
     *	
     *
     */
    public StudentType getStudentType(){
    	return this.studentType;
    }
    
    /**
     * 获得入学年份
     * @return
     */
    public int getYearIntoSchool(){
    	return year;
    }
	public Department getDepartment() {
		return department;
	}
	public String getGrade() {
		return grade;
	}
	public double getGpa() {
		return gpa;
	}
//	public ArrayList<String> getCourseNameList() {
//		return courseNameList;
//	}
//	public ArrayList<Integer> getCourseIdList() {
//		return courseIdList;
//	}
	public Department getTargetDepartment() {
		return targetDepartment;
	}
	public ArrayList<CoursePO> getCoursePOList(){
		return this.courseList;
	}
	
	//setter
	public void setCoursePOList(ArrayList<CoursePO> a){
		this.courseList = a;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	/**
	 * 设定学生入学年份
	 * @param year
	 */
	public void setYearIntoSchool(int year){
		this.year=year;
	}
//	public void setCourseNameList(ArrayList<String> courseNameList) {
//		this.courseNameList = courseNameList;
//	}
//	public void setCourseIdList(ArrayList<Integer> courseIdList) {
//		this.courseIdList = courseIdList;
//	}
	public void setTargetDepartment(Department targetDepartment) {
		this.targetDepartment = targetDepartment;
	}
	/**
	 * 
	 * 设定学生类型
	 *	
	 */
	public void setStudentType(StudentType sType){
		this.studentType = sType;
	}
	
}
