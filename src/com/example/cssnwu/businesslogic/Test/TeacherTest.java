package com.example.cssnwu.businesslogic.Test;

import java.util.HashMap;

import com.example.cssnwu.businesslogic.controller.TeacherController;
import com.example.cssnwu.vo.CourseVO;

public class TeacherTest {
	public static void main(String[] args)
	{   try{
		   TeacherController controller=new TeacherController();
		   CourseVO vo=new CourseVO();
		   
		   System.out.println(controller.updateCourseInfo(vo));   ///TUS9-1  ȫΪ��
		                                       ////
		   //////
		  // vo.

		   /// controller.updateCourseInfo()
		  /**
		   * ��ʦ¼��ɼ�Test   
		   */
	    HashMap<Integer,Double> map=new HashMap<Integer,Double>();
	    System.out.println(controller.registerScore(123,map));////����γ̺�
	    System.out.println(controller.registerScore(20100,map));////��ȷ�Ŀγ̺�,�յ�map
	    map.put(111160126,80.0);
	    map.put(1,100.0);
	    System.out.println(controller.registerScore(20100, map));///��ȷ
	    map.put(123,4.3);
	    map.put(1345,5.4);
	    System.out.println(controller.registerScore(20100, map));///ѧ���������ԡ�
	    
	    
	
	  }catch(Exception el)
		   {
			   el.printStackTrace();
		   }
		
	}
}
