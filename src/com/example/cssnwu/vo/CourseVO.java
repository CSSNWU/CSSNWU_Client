/**
 * @(#)CourseVO.java     	2013-10-5 ����4:06:26
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.vo;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.cssnwu.businesslogicservice.resultenum.CourseType;

/**
 *Class <code>CourseVO.java</code> ���ӱ��ֲ���߼����CourseVO.
 *
 * @author never
 * @version 2013-10-5
 * @since JDK1.7
 */
public class CourseVO extends VO{
	public String courseName;                   //�γ�����   
    public CourseType courseType;               //�γ�����
    public String courseIntro;                  //�γ̽���
    public ArrayList<Integer> teacherIdList = new ArrayList<Integer>();    //�ο���ʦId
    public ArrayList<String> teacherNameList = new ArrayList<String>();    //�ο���ʦ����
    public String courseTime;                   //�Ͽ�ʱ��(��ʽ�����ܼ��� + "/" +  ��1~3��)
    public String courseLocation;               //�Ͽεص�(��ʽ��"У��" + "/" + "����")
    public int credit;                          //ѧ��
    public double score;                        //�ɼ�
    public String establishTime;                  //����ʱ��
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
			temp+="��";
		}
			
		return temp;
		

	}
	/**Title:
	 * Description:��óɼ���Ϣ
	 * @return
	 */
	public String getGradeInformation()
	{
		return courseName+" "+courseIntro+" "+credit+" "+score;
	}
    
    
}
