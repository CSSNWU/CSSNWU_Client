/**
 * @(#)CourseVO.java     	2013-10-5 下午4:06:26
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.vo;

import java.util.ArrayList;

import com.example.cssnwu.businesslogicservice.resultenum.CourseType;

/**
 *Class <code>CourseVO.java</code> 连接表现层和逻辑层的CourseVO
 *
 * @author never
 * @version 2013-10-5
 * @since JDK1.7
 */
public class CourseVO extends VO{
	public String courseName;                   //课程名称   
    public CourseType courseType;               //课程类型
    public String courseIntro;                  //课程介绍
    public ArrayList<TeacherVO> teacherList;    //任课老师
    public String courseTime;                   //上课时间
    public String courseLocation;               //上课地点
    public int credit;                          //学分
    public double score;                        //成绩
    public String establishTime;                  //开课时间
    
    
}
