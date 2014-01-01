/**
 * @(#)DepartmentPlanVO.java     	2013-10-8 下午7:37:23
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.vo;

import java.util.ArrayList;

import com.example.cssnwu.businesslogicservice.resultenum.Department;

/**
 *Class <code>DepartmentPlanVO.java</code> 连接表现层和逻辑层的DepartmentPlanVO
 *
 * @author never
 * @version 2013-10-8
 * @since JDK1.7
 */
public class DepartmentPlanVO extends VO {
	public Department department;               //院系
	public int[] minCreditPerSeason=new int[4];            //每学年最低学分安排
    public ArrayList<CourseVO> courseList = new ArrayList<CourseVO>();      //课程安排
    /**Title:getInformation
     * Description:
     * @return
     */
    public String getInformation()
    {    //String result=department.toString();
    	String result=String.valueOf(department); 
    	result=result+" "+minCreditPerSeason[0]+" "+minCreditPerSeason[1]+
        		        " "+minCreditPerSeason[2]+" "+
        		            minCreditPerSeason[3];
    	return result;
    }
}
