package com.example.cssnwu.businesslogicservice.resultenum;

public class EnumToString {
	/**
	 * ת��department��enum��string
	 * @param department
	 * @return
	 */
	public  static String departmentChange(Department department)
	{  String result=null;
		switch(department)
		{   case ���ѧԺ:
			{
			   result="���ѧԺ";
			}
	        default:
	        {
	        	result="��";
	        }
		}
		return result;
		
	}

}
