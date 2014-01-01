package com.example.cssnwu.businesslogic.Test;

import java.util.HashMap;

import com.example.cssnwu.businesslogic.controller.TeacherController;
import com.example.cssnwu.vo.CourseVO;

public class TeacherTest {
	public static void main(String[] args)
	{   try{
		   TeacherController controller=new TeacherController();
		   CourseVO vo=new CourseVO();
		   
		   System.out.println(controller.updateCourseInfo(vo));   ///TUS9-1  全为空
		                                       ////
		   //////
		  // vo.

		   /// controller.updateCourseInfo()
		  /**
		   * 老师录入成绩Test   
		   */
	    HashMap<Integer,Double> map=new HashMap<Integer,Double>();
	    System.out.println(controller.registerScore(123,map));////错误课程号
	    System.out.println(controller.registerScore(20100,map));////正确的课程号,空的map
	    map.put(111160126,80.0);
	    map.put(1,100.0);
	    System.out.println(controller.registerScore(20100, map));///正确
	    map.put(123,4.3);
	    map.put(1345,5.4);
	    System.out.println(controller.registerScore(20100, map));///学生个数不对。
	    
	    
	
	  }catch(Exception el)
		   {
			   el.printStackTrace();
		   }
		
	}
}
