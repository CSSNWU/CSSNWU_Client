package com.example.cssnwu.presentation.loginui;

import java.awt.Component;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.example.cssnwu.businesslogic.controller.LoginController;
import com.example.cssnwu.businesslogicservice.resultenum.LOGIN_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.UserType;
import com.example.cssnwu.presentation.deptteacherui.DeptTeacherUI;
import com.example.cssnwu.presentation.schoolteacherui.SchoolTeacherUI;
import com.example.cssnwu.presentation.studentUI.StudentUI2;
import com.example.cssnwu.presentation.teacherui.TeacherUI;


/**
 * Created with IntelliJ IDEA.
 * User: Thunder
 * Date: 13-12-7
 * Time: 涓嬪崍3:24
 * To change this template use File | Settings | File Templates.
 */
public class LoginManager {
	final static int maxNumber=3;//最大登陆次数
	int loginNumber=0;////标记登陆次数
	JFrame frame=null;//
	LOGIN_RESULT result;
    LoginController controller=null;
    /* Title:
     * Description:构造函数
     */
	public LoginManager()
	{
		try {
		   
		   controller=new LoginController();
		   frame=new JFrame();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
		   e1.printStackTrace();
		   JOptionPane.showMessageDialog(frame,"远程错误");
		   //System.out.println("remoteException in create a LoginController");
		}
	}
	/*
	 *  Description:构造函数
	 */
	public LoginManager(Component componet)
	{   try {
			controller=new LoginController();
			frame=(JFrame) componet;
	} catch (RemoteException e) {
	
		e.printStackTrace();
	}
    }
	/**Title:login
	 * Description:登陆判断和界面跳转的方法
	 * @param userId
	 * @param password
	 * @param type
	 * @return
	 * @throws RemoteException
	 */
   public boolean Login(int userId,String password,String type)throws RemoteException
   {   boolean isSuccessful=false;
       if(loginNumber<maxNumber)
       {
   
       /**
        * 学生
        */
	   if(type.equals("学生"))
          {   System.out.println("student is loiging.....");
	          LOGIN_RESULT result= controller.login(userId, password,UserType.Student);
              if(checkLogin(result,userId,UserType.Student))
			  {   
				  isSuccessful=true;
				  
			  }

          }
	   /**
	    * 学校教务员
	    */
	   if(type.equals("学校教务员"))
	   {   System.out.println("schoolTeacher is logiging.....");
		   LOGIN_RESULT result= controller.login(userId, password,UserType.SchoolTeacher);
		   if(checkLogin(result,userId,UserType.SchoolTeacher))
		   {
			   isSuccessful=true;
		   }

	   }
	   /**
	    * 学园教务员
	    */
	   if(type.equals("学院教务员"))
	   {
		   LOGIN_RESULT result= controller.login(userId, password,UserType.DepartmentTeacher);
           if(checkLogin(result,userId,UserType.DepartmentTeacher))
           {   isSuccessful=true;
           }
 	   }
	   /**
	    * 任课老师
	    */
	   if(type.equals("任课教师"))
	   {
		   LOGIN_RESULT result= controller.login(userId, password,UserType.Teacher);
	       if(checkLogin(result, userId,UserType.Teacher))
              {
	    	   isSuccessful=true;
              }

	   }
       }else{
    	   JOptionPane.showMessageDialog(frame,"超过最大登陆次数,系统将在3秒钟关闭");
    	   try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   isSuccessful=true;
       }
	   return isSuccessful;
     }
    /**Title:checkLogin
     * Description:被login调用，检查是否登陆成功，并负责界面跳转
     * @param result
     * @param UserId
     * @param type
     * @return
     */
	public boolean  checkLogin(LOGIN_RESULT result,int UserId,UserType type)
	{      boolean isSuccessful=false;
		switch (result)
			 { case 登录成功:
					 {   //System.out.println("登陆成功");
					     this.goToUserUI(UserId,type);
						 isSuccessful=true;
						 break;
					 }
				 case 密码错误:
				    {    loginNumber++;
				    	 JOptionPane.showMessageDialog(frame,"密码错误");
                         isSuccessful=false;
                         break;
				    }
				 case 用户不存在:
 
				  {	  JOptionPane.showMessageDialog(frame, "用户不存在");
                        
				   break;
				   }
				 case 网络异常:

				    { JOptionPane.showMessageDialog(frame,"网络异常");
     				 
				 	   break;
				 	}
				 case 用户已登录:
				 	{ 
				 		JOptionPane.showMessageDialog(frame, "用户已存在");
				 		break;
                
				 	}
				 case 服务端错误:
				 	{ 
				 		JOptionPane.showMessageDialog(frame,"服务端错误");
				 		break;
				 		
					}
				 default:
				 {   System.out.println("default");
				
				 }
		     }
                return isSuccessful;
	}
	/**Title: goToUI
	 * Description:负责跳转到相应界面
	 * @param UserId
	 * @param type
	 */
	private void goToUserUI(int UserId,UserType type)
	{      switch (type)//渚濇嵁鐢ㄦ埛绫诲瀷锛岃皟鐢╣oto璇彞
			{  case Student:
				{
					goToStudentUI(UserId);
					break;
				}
			   case SchoolTeacher:
			   {
				   goToSchoolTeacherUI(UserId);
				   break;
			   }
			   case DepartmentTeacher:
			   {
				   goToDepartmentTeacherUI(UserId);
				   break;
			   }
			   case Teacher:
			   {
				   goToTeacherUI(UserId);
				   break;
			   }
			   default:break;

			}

	}
 /** Title:goToStudentUI
  *  Description: 跳转到学生界面
  * @param studentId
 */
	private void goToStudentUI(int studentId)
	{      System.out.println("成功跳转到学生界面");
           new StudentUI2(studentId);
	}

	/**  Title:goToSchoolTeacher
	 *   Description: 跳转到学校老师界面
	 * @param schoolTeacherId
	 */
	private void goToSchoolTeacherUI(int schoolTeacherId)
	{
		//new SchoolTeacherUI(schoolTeacherId.t));
		Integer id=new Integer(schoolTeacherId);
		
		System.out.println("成功跳转到学校教务老师界面");
		new SchoolTeacherUI(id);
		
	}

	/** Title:goToDepartmentTeacherUI
	 *  Description:
	 * @param departmentTeacher
	 */
	private void goToDepartmentTeacherUI(int departmentTeacherId)
	{   new DeptTeacherUI(departmentTeacherId);
		System.out.println("成功跳转到院系教务老师界面");

	}

	/**Title:goToTeacher
	 * Description:跳转到任课老师界面
	 * @param teacherId
	 */
    private void goToTeacherUI(int teacherId)
	{  System.out.println("成功跳转到到教师界面");
       new TeacherUI(teacherId);
	}
}
