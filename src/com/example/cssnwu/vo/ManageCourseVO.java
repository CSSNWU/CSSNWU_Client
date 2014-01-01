/**
 * @(#)ManageCourseVO.java     	2013-10-8 ����8:33:47
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.vo;

import java.util.ArrayList;
import java.util.Date;

import com.example.cssnwu.businesslogicservice.resultenum.ManageCourseType;

/**
 *Class <code>ManageCourseVO.java</code> ���ӱ��ֲ���߼����ManageCourseVO
 *
 * @author never
 * @version 2013-10-8
 * @since JDK1.7
 */
public class ManageCourseVO extends VO{
	public StudentVO studentVO;                 //����γ�ѧ��
    public Date date;                           //����γ�ʱ��
    public ManageCourseType manageCourseType;   //����γ����ͣ�ѡ��/��ѡ��
    public ArrayList<CourseVO> courseList = new ArrayList<CourseVO>();      //����γ��б�
    /**clear
     * ��������еĳ�Ա������Ϣ��
     */
    public void clear()
    {    studentVO=null;
    	 date=null;
    	 manageCourseType=null;
    	 courseList=new ArrayList<CourseVO>();
    	 
    }
}
