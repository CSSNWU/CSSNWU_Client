package com.example.cssnwu.presentation.studentUI;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import javax.swing.*;

import com.example.cssnwu.businesslogicservice.resultenum.Department;
import com.example.cssnwu.businesslogicservice.resultenum.UserType;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.DepartmentPlanVO;
import com.example.cssnwu.vo.StudentVO;
import com.example.cssnwu.vo.TeacherVO;
import com.example.cssnwu.vo.VO;
import jxl.*; 
public class MyTable extends JTable{
   ArrayList<?> classList=null;
	/**
	 * Title:  MyTable 
	 * Description:构造方法
	 * @param list   
	 * @param columnNames
	 */
	public MyTable(ArrayList<?> list,Object[] columnNames) {            //重写的是这个构造函数，可以换
		super(changeData(list,columnNames.length),columnNames);
		classList=list;
		setDragEnabled(false);         //这个可以不要
		tableHeader.setReorderingAllowed(false); 
		getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //只能选一行
		setColumnSelectionAllowed(false);
		setRowSelectionAllowed(true);                       //只能选择行
		
	}
	/**
	 * Title: 
	 * Description:构造函数
	 * @param book
	 * @param columnNames
	 * @param type
	 */
	public MyTable(Workbook book ,Object[] columnNames,String type)
	{    super(changeData(book,columnNames.length),columnNames);
	     classList=changeToList(book,columnNames.length,type);
	     setDragEnabled(false);         //这个可以不要
	     tableHeader.setReorderingAllowed(false); 
	     getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //只能选一行
	     	setColumnSelectionAllowed(false);
	     	setRowSelectionAllowed(true);                       //只能选择行
		
	}
	/**
	 * Title: changeToList
	 * Description: 将WorkBook类型数据转换成ArrayList
	 * @param book
	 * @param length
	 * @param type
	 * @return ArrayList<?>
	 */
	private ArrayList<?> changeToList(Workbook book, int length,String type) {
		// TODO Auto-generated method stub
		ArrayList<StudentVO> list;
		if(type.equals("学生"))
		{
		    list=new ArrayList<StudentVO>();
		    ///////////////假定只有一个sheet
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
		    
		}else{
			list=new ArrayList<StudentVO>();
			System.out.println("the book from excel is null");
		}
		return list;
	}
	/**
	 * Title:changeDate
	 * Description:
	 * @param book
	 * @param length
	 * @return
	 */
	public static Object[][] changeData(Workbook book,int length)
	{   ///////假设booK只有一个xls页
	
		Sheet sheet=book.getSheet(0);
		Object[][] data=new Object[sheet.getRows()-1][length];
		for(int i=1;i<sheet.getRows();i++)
		{   if(sheet.getColumns()>=length-1)
			
				{    for(int j=0;j<length;j++)
					{   Cell cell=sheet.getCell(j,i);
					    data[i-1][j]=cell.getContents();
					    System.out.println(data[i-1][j]);
					    System.out.println(i+j);
					}
			
				}
		  	
		}
	
		return data;
		
	}////////////////for addNewStudent
    
 	public boolean isCellEditable(int row, int column) {return false;};      //不可编辑
 	/**
 	 * Title:changeData
 	 * Description:将arrayLists转换成数组形式
 	 * @param list
 	 * @param length
 	 * @return
 	 */
	private static Object[][] changeData( ArrayList<?> list,int length)
	{    Object[][] cellData=new Object[list.size()][length];
	    /**
	     *  处理list为courseVO的情景
	     */
	    if(!list.isEmpty())
	    {	if( list.get(0) instanceof CourseVO)
	    	{
	    		for(int i=0;i<list.size();i++)
	    		{    if(length==4)
	    			{  
	    	   cellData[i]=((CourseVO) list.get(i)).getGradeInformation().split(" ");
			 }else{
				 if(length==6)
				 {
				cellData[i]=((CourseVO) list.get(i)).getClassInformation().split(" ");
				 }
			 }
	       
	      
	       }
		}
	    /**
	     *  处理list为TeacherVO的情景
	     */
		if(list.get(0) instanceof TeacherVO)
		{    
		   for(int i=0;i<list.size();i++)
	       {   Object[] temp=((TeacherVO) list.get(i)).getInformation().split(" ");
	           if(temp.length>length)
	           {   for(int j=0;j<length;j++)
	           		{    cellData[i][j]=temp[j];
	        	   
	           		}
	        	   
	           }else{
	        	   for(int m=0;m<temp.length;m++)
	        	   {
	        		   cellData[i][m]=temp[m];
	        	   }
	        	   for(int n=temp.length;n<length;n++)
	        	   {   System.out.println("dddd"+n);
	        		   cellData[i][n]="无";
	        	   }
	           }
			 
	    	   ///////////////TODO:或许会超出数组
	       }
		   
			
		
		}
		 /**
	     *  处理list为StudentVO的情景
	     */
		if(list.get(0) instanceof StudentVO)
		{   if(length==6)
		  {
			for(int i=0;i<list.size();i++)
	        {     cellData[i]=((StudentVO) list.get(i)).getTransferInformation().split(" ");
  	           
	        }
		  }else{
			  if(length==5)
			  {
			  for(int i=0;i<list.size();i++)
		        {     cellData[i]=((StudentVO) list.get(i)).getInformation().split(" ");
	  	           
		        }
			  }else{
				  for(int i=0;i<list.size();i++)
			        {     cellData[i]=((StudentVO) list.get(i)).getDropInformation().split(" ");
		  	           
			        }
			  }
		  }
		////////////////////////////////有问题！！！！！！！！！！！！！！！！！！！！
		
			
		}///////////////////强耦合的地方，一定要小心传入的string【】的大小
		 /**
	     *  处理list为DepartmentVO的情景
	     */
		if(list.get(0) instanceof DepartmentPlanVO)
		
		{    if(length==5)
			{     
			    for(int i=0;i<list.size();i++)
			    {
			    	 cellData[i]=((DepartmentPlanVO)list.get(i)).getInformation().split(" ");
			    }
			}
			
		}
	    }else
	    {   System.out.println("is empty");
	    }
		return cellData;
	}
	/**
	 * Title:getSelectItem();
	 * Description:获得选中的项
	 * @return CoursePO
	 */
	public CourseVO getSelectedItem()
	{      int selectRows=getSelectedRow();// 取得用户所选行的行数
	         
		   if((selectRows>-1)&&(selectRows<=classList.size()))
				   {
			              return (CourseVO) classList.get(selectRows);
				   }
		   else{
			  
			   return null;
		   }
		
	}
}

