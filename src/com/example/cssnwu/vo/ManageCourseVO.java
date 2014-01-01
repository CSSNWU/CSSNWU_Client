/**
 * @(#)ManageCourseVO.java     	2013-10-8 下午8:33:47
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.vo;

import java.util.ArrayList;
import java.util.Date;

import com.example.cssnwu.businesslogicservice.resultenum.ManageCourseType;

/**
 *Class <code>ManageCourseVO.java</code> 连接表现层和逻辑层的ManageCourseVO
 *
 * @author never
 * @version 2013-10-8
 * @since JDK1.7
 */
public class ManageCourseVO extends VO{
	public StudentVO studentVO;                 //管理课程学生
    public Date date;                           //管理课程时间
    public ManageCourseType manageCourseType;   //管理课程类型（选课/退选）
    public ArrayList<CourseVO> courseList = new ArrayList<CourseVO>();      //管理课程列表
    /**clear
     * 清除对象中的成员变量信息。
     */
    public void clear()
    {    studentVO=null;
    	 date=null;
    	 manageCourseType=null;
    	 courseList=new ArrayList<CourseVO>();
    	 
    }
}
