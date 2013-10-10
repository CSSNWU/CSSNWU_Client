/**
 * @(#)CourseVO.java     	2013-10-5 ����4:06:26
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.vo;

import java.util.ArrayList;

import com.example.cssnwu.businesslogicservice.resultenum.CourseType;

/**
 *Class <code>CourseVO.java</code> ���ӱ��ֲ���߼����CourseVO
 *
 * @author never
 * @version 2013-10-5
 * @since JDK1.7
 */
public class CourseVO extends VO{
	public String courseName;                   //�γ�����   
    public CourseType courseType;               //�γ�����
    public String courseIntro;                  //�γ̽���
    public ArrayList<TeacherVO> teacherList;    //�ο���ʦ
    public String courseTime;                   //�Ͽ�ʱ��
    public String courseLocation;               //�Ͽεص�
    public int credit;                          //ѧ��
    public double score;                        //�ɼ�
    public String establishTime;                  //����ʱ��
    
    
}
