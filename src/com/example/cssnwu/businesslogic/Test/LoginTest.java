package com.example.cssnwu.businesslogic.Test;

import java.rmi.RemoteException;

import com.example.cssnwu.businesslogic.controller.LoginController;
import com.example.cssnwu.businesslogicservice.resultenum.UserType;

public class LoginTest {
	public static void main(String[] args)
	{    try {
		   	   LoginController controller=new LoginController();
		   	   System.out.println("���Ե�½");
		       System.out.println(controller.login(121250213,null,UserType.Student));
		       System.out.println(controller.login(121250213,"1", UserType.Student));   
		       System.out.println(controller.login(121250213, "123",UserType.Student));   ///����������󣬵����γ���
               
		       /**
		        *     �û���������
		        */
		       System.out.println(controller.login(1000,"082203",UserType.Student));
		       System.out.println(controller.login(500,"1", UserType.SchoolTeacher));//��½�ɹ�
		 	} catch (RemoteException e) {
	
		 		e.printStackTrace();
		 	}
		
			}
	

}
