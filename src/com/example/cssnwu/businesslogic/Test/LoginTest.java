package com.example.cssnwu.businesslogic.Test;

import java.rmi.RemoteException;

import com.example.cssnwu.businesslogic.controller.LoginController;
import com.example.cssnwu.businesslogicservice.resultenum.UserType;

public class LoginTest {
	public static void main(String[] args)
	{    try {
		   	   LoginController controller=new LoginController();
		   	   System.out.println("测试登陆");
		       System.out.println(controller.login(121250213,null,UserType.Student));
		       System.out.println(controller.login(121250213,"1", UserType.Student));   
		       System.out.println(controller.login(121250213, "123",UserType.Student));   ///三次密码错误，第三次超出
               
		       /**
		        *     用户名不存在
		        */
		       System.out.println(controller.login(1000,"082203",UserType.Student));
		       System.out.println(controller.login(500,"1", UserType.SchoolTeacher));//登陆成功
		 	} catch (RemoteException e) {
	
		 		e.printStackTrace();
		 	}
		
			}
	

}
