/**
 * @(#)StudentPO.java     	2013-10-4 ����8:36:46
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.po;

import java.util.ArrayList;

import com.example.cssnwu.businesslogicservice.resultenum.Department;
import com.example.cssnwu.businesslogicservice.resultenum.StudentType;
import com.example.cssnwu.businesslogicservice.resultenum.UserType;

/**
 *Class <code>StudentPO.java</code> ѧ��
 *
 * @author never
 * @version 2013-10-4
 * @since JDK1.7
 */
@SuppressWarnings("serial")
public class StudentPO extends UserPO{
	Department department;            //����Ժϵ
    String grade;                     //�꼶
    double gpa;                       //ѧ�ּ�
    int year;						  //��ѧ���
    ArrayList<CoursePO> courseList;   //�γ��б�
//    ArrayList<Integer> courseIdList;   //�γ̱���б�
    Department targetDepartment;      //Ŀ��Ժϵ����תԺ�����ѧ����һ��ѧ��������Ϊ�գ�
    StudentType studentType;
    
    /**���췽��
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
    
    
    //getter����
    /**
     *
     *	���ѧ�����͵ķ���
     *	@author zyf
     *	@param null
     *	
     *
     */
    public StudentType getStudentType(){
    	return this.studentType;
    }
    
    /**
     * �����ѧ���
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
	 * �趨ѧ����ѧ���
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
	 * �趨ѧ������
	 *	
	 */
	public void setStudentType(StudentType sType){
		this.studentType = sType;
	}
	
}
