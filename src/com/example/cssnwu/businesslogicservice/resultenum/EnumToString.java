package com.example.cssnwu.businesslogicservice.resultenum;

public class EnumToString {
	/**
	 * 转化department的enum和string
	 * @param department
	 * @return
	 */
	public  static String departmentChange(Department department)
	{  String result=null;
		switch(department)
		{   case 软件学院:
			{
			   result="软件学院";
			}
	        default:
	        {
	        	result="无";
	        }
		}
		return result;
		
	}

}
