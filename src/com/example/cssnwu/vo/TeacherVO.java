/**
 * @(#)TeacherVO.java     	2013-10-5 ����11:04:57
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.vo;

import java.util.ArrayList;

import com.example.cssnwu.businesslogicservice.resultenum.Department;
import com.example.cssnwu.businesslogicservice.resultenum.EnumToString;

/**
 *Class <code>TeacherVO.java</code> ���ӱ��ֲ���߼����TeacherVO
 *
 * @author never
 * @version 2013-10-5
 * @since JDK1.7
 */
public class TeacherVO extends UserVO{
	public Department department;                //Ժϵ�����ţ�
    public ArrayList<Integer> courseList = new ArrayList<Integer>();       //���ογ̱���б�

	public ArrayList<CourseVO> courseVOList=new ArrayList<CourseVO>();
	/**Title:getInformation
	 * Description:���ѧ����Ϣ
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
    		  result=result+"��"+" "+"��"+" "+"��";
    	 }
    	 
    	 return result;
    }
}
