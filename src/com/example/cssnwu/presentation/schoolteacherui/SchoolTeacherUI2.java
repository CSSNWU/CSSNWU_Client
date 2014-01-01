package com.example.cssnwu.presentation.schoolteacherui;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;

import com.example.cssnwu.businesslogic.controller.SchoolTeacherController;
import com.example.cssnwu.presentation.studentUI.MyPanel;
import com.example.cssnwu.stub.SchoolTeacherBLService_Stub;
/**
 * Created with IntelliJ IDEA.
 * User: Thunder
 * Date: 13-12-4
 * Time: 下午7:44
 * To change this template use File | Settings | File Templates.
 */
public class SchoolTeacherUI2 implements MouseListener{
	int teacherId;
	//UI  component
	JFrame frame=null;
	JPanel mainPanel=null;
	MyPanel navigationBarsPanel=null;
    MyPanel secondnavigationBarsPanel=null;

    MyPanel homeButton=null;

	MyPanel teachingstrategyButton=null;
	MyPanel teachingInformationButton=null;
	//逻辑层调用对象
	SchoolTeacherController controller=null;
	SchoolTeacherBLService_Stub stub=null;
	public SchoolTeacherUI2(int id)
	{     //设置老师的Id
		  teacherId=id;
          stub=new SchoolTeacherBLService_Stub();
        /*try{
          controller=new SchoolTeacherController();
		}catch(RemoteException el)
		{
			el.printStackTrace();
		}*/
		frame=new JFrame();
		frame.setTitle("教学系统");
		//设置frame的大小
		int width=800;
		int height=600;
		frame.setSize(width,height);
		frame.setLocation(width/2,height/2);
		//设置mainPanle的布局
		mainPanel=new JPanel();
		mainPanel.setLayout(null);
		//设置一级导航栏
		navigationBarsPanel=new MyPanel("images/SchoolTeacherUI/nav-bar.png");
		navigationBarsPanel.setLayout(null);
		navigationBarsPanel.setBounds(0,0,800,50);
		//按钮的设置
		homeButton=new MyPanel("images/SchoolTeacherUI/home normal.png");
		homeButton.setOpaque(false);
		//主页
	    homeButton.setBounds(200,15,23,32);
        //学校策略
        teachingstrategyButton=new MyPanel("images/SchoolTeacherUI/teachingstrategy normal.png");
		teachingstrategyButton.setOpaque(false);
		teachingstrategyButton.setBounds(240,15,100,40);

		//教学信息
		teachingInformationButton=new MyPanel("images/SchoolTeacherUI/teachinginfo normal.png");
		teachingInformationButton.setOpaque(false);
		teachingInformationButton.setBounds(360,15,74,40);
		//加到一级导航栏上
		navigationBarsPanel.add(homeButton);
		navigationBarsPanel.add(teachingstrategyButton);
		navigationBarsPanel.add(teachingInformationButton);
		//下边是设置contentPanel


        //将组件加到frame上
		frame.add(navigationBarsPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
