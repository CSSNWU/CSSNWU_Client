package com.example.cssnwu.presentation.schoolteacherui;
import java.util.ArrayList;

import com.example.cssnwu.businesslogicservice.resultenum.Department;
import com.example.cssnwu.businesslogicservice.resultenum.UserType;
import com.example.cssnwu.vo.StudentVO;
import com.example.cssnwu.vo.VO;

import jxl.*; 
public class WorkBookHandler {
	/**Title:handleWorkBook
	 * Description:处理workbook的方式
	 * @param book
	 * @return  ArrayList
	 */
	public static ArrayList<VO> handleWorkBook(Workbook book)
	{    
		
		ArrayList<VO> list=new ArrayList<VO>();
		    /*
		     * 假定只有一个sheet
		     */
		Sheet sheet=book.getSheet(0);
		for(int i=1;i<sheet.getRows();i++) /////!!!!!由于excell有题头所以从1开始
		  {   StudentVO studentVo=new StudentVO();
		      studentVo.id=Integer.parseInt(sheet.getCell(0,i).getContents());
		      studentVo.password=sheet.getCell(0, i).getContents();////初始密码，和学号相同
		      studentVo.userName=sheet.getCell(1, i).getContents();///姓名
		      studentVo.userType=UserType.Student;
		      studentVo.gender=sheet.getCell(2,i).getContents();///性别
		      studentVo.department=Department.valueOf(sheet.getCell(3,i).getContents());
		      studentVo.year=sheet.getCell(4,i).getContents();
		      list.add(studentVo);
		  }
	    return list;
	}
}
