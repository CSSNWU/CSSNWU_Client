/**
 * @(#)TeacherVO.java     	2013-10-5 下午11:04:57
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.vo;

import java.util.ArrayList;

import com.example.cssnwu.businesslogicservice.resultenum.Department;
import com.example.cssnwu.businesslogicservice.resultenum.EnumToString;

/**
 *Class <code>TeacherVO.java</code> 连接表现层和逻辑层的TeacherVO
 *
 * @author never
 * @version 2013-10-5
 * @since JDK1.7
 */
public class TeacherVO extends UserVO{
	public Department department;                //院系（部门）
    public ArrayList<Integer> courseList = new ArrayList<Integer>();       //开课课程编号列表

	public ArrayList<CourseVO> courseVOList=new ArrayList<CourseVO>();
	/**Title:getInformation
	 * Description:获得学生信息
	 * @return
	 */
    public  String getInformation()
    {    String result=id+" "+userName+" "+department.toString();
    	 result+=" ";
    	 if(!courseVOList.isEmpty())
    	 {
    		 for(int i=0;i<courseVOList.size();i++)
    		 {    result=result+((CourseVO)courseVOList.get(i)).courseName;
    		 	if(i!=courseVOList.size()-1)
    	      {
    	    	  result+=" ";
    	      }
    		 
    	     }
    	 }else{
    		  result=result+"空"+" "+"空"+" "+"空";
    	 }
    	 
    	 return result;
    }
}
