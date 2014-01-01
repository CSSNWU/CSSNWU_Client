/**
 * @(#)CourseVO.java     	2013-10-5 下午4:06:26
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.vo;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.cssnwu.businesslogicservice.resultenum.CourseType;

/**
 *Class <code>CourseVO.java</code> 连接表现层和逻辑层的CourseVO.
 *
 * @author never
 * @version 2013-10-5
 * @since JDK1.7
 */
public class CourseVO extends VO{
	public String courseName;                   //课程名称   
    public CourseType courseType;               //课程类型
    public String courseIntro;                  //课程介绍
    public ArrayList<Integer> teacherIdList = new ArrayList<Integer>();    //任课老师Id
    public ArrayList<String> teacherNameList = new ArrayList<String>();    //任课老师名字
    public String courseTime;                   //上课时间(格式：“周几” + "/" +  “1~3”)
    public String courseLocation;               //上课地点(格式："校区" + "/" + "教室")
    public int credit;                          //学分
    public double score;                        //成绩
    public String establishTime;                  //开课时间
    /**Title:getClassInformation()
     * 
     * @return
     */
	public String getClassInformation() {
		// TODO Auto-generated method stub
		String temp =  courseName+" "+courseTime+" "+courseLocation+" "
				              +courseIntro+" "+credit+" ";
		
		if(!teacherNameList.isEmpty()){
			temp += teacherNameList.get(0);
		}else{
			temp+="空";
		}
			
		return temp;
		

	}
	/**Title:
	 * Description:获得成绩信息
	 * @return
	 */
	public String getGradeInformation()
	{
		return courseName+" "+courseIntro+" "+credit+" "+score;
	}
    
    
}
