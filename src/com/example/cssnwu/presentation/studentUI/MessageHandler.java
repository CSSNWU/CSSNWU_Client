package com.example.cssnwu.presentation.studentUI;

import java.awt.Component;

import javax.swing.JOptionPane;

import com.example.cssnwu.businesslogicservice.resultenum.ADD_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.DELETE_RESULT;

public class MessageHandler {
	/**
	 * Title:hangeMessage
	 * Description: 处理一些信息
	 * @param r
	 * @param componet
	 * @return  boolean
	 */
	public static boolean handleMessage(DELETE_RESULT r,Component componet)
	{  /**
	    *    根据r返回bool
	    */
		switch(r)
		{  case 删除成功:
			{   return true;
			
			}
			case 服务器端错误:
				{   
					JOptionPane.showMessageDialog(componet,"服务器端错误");
					return false;
				}
			case 要删除的内容不存在:
				{   JOptionPane.showMessageDialog(componet, "要删除的内容不存在");
				    return false;
					
				}
			case 删除失败:
				{   JOptionPane.showMessageDialog(componet, "删除失败");
				    return false;
					
				}
			case 课程是直选课程不可退选:
				{   JOptionPane.showMessageDialog(componet, "课程是直选课程不可退选");
				    return false;
					
				}
			default:{
				return false;
			}
		}
	}
	
	/**
	 * Title:  hangeMessage
	 * Description:处理信息
	 * @param r
	 * @param componet
	 * @return
	 */
	public static boolean handleMessage(ADD_RESULT r,Component componet)
	{  switch(r)
		{  case 添加成功:
			{   return true;
			
			}
			case 服务器端错误:
				{   
					JOptionPane.showMessageDialog(componet,"服务器端错误");
					return false;
				}
			case 和已有课程时间上冲突:
				{   JOptionPane.showMessageDialog(componet, "和已有课程时间上冲突");
				    return false;
					
				}
			case 相邻两门课程上课地点校区不同时间上来不及:
				{   JOptionPane.showMessageDialog(componet, "相邻两门课程上课地点校区不同时间上来不及");
				    return false;
					
				}
			case 已经选择了本课程不可再次选择:
				{   JOptionPane.showMessageDialog(componet, "已经选择了本课程不可再次选择");
				    return false;
					
				}
			case 操作失败:
			{   JOptionPane.showMessageDialog(componet, "操作失败");
			    return false;
				
			}
			default:{
				return false;
			}
		}
	
		
	}


}
