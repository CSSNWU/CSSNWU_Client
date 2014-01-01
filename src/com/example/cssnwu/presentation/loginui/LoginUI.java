package com.example.cssnwu.presentation.loginui;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.synth.SynthLookAndFeel;
import com.example.cssnwu.presentation.studentUI.*;

import com.example.cssnwu.businesslogic.controller.LoginController;
import com.example.cssnwu.businesslogicservice.resultenum.LOGIN_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.UserType;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.rmi.RemoteException;

/**
 * Created with IntelliJ IDEA.
 * User: Thunder
 * Date: 13-11-20
 * Time: ����10:38
 * To change this template use File | Settings | File Templates.
 */
public class LoginUI implements ActionListener{
	private static String synthFile="synthSkin.xml";
	private static String[] userType=new String[]{"ѧУ����Ա","ѧԺ����Ա","�ον�ʦ","ѧ��"};

	private JFrame frame=null;
	private JPanel panel=null;
	private JTextField userNameField=null;
	private JPasswordField passwordField=null;
	private JComboBox typeChooser=null;
	private JLabel passwordLabel=null;   // for password hint;
	private TextField passwordField2=null;

	private LoginController controller=null;  //��½�����controller
	private LoginManager manager=null;  //���ڴ����ʶ��½������Ϣ������ת����ͬ�����档
	/**
	 * Description:���캯��
	 * @param args
	 */
	
	public LoginUI() 
	{   //��ʼ��controller
		/*try {
		   controller=new LoginController();
		} catch (RemoteException e1) {
			
			e1.printStackTrace();
			System.out.println("remoteException in create a LoginController");
		}*/
		
		
	    manager=new LoginManager();//��ʼ��manage
		frame=new JFrame("Test");

           //����Frame�Ĵ�С

		int width;
		int height;
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		width=screenSize.width/2;
		height=screenSize.height/2;
		 frame.setTitle("UI");

		frame.setSize(width,height);
		frame.setLocation(width / 2, height / 2);
		frame.setLocationByPlatform(false);

		panel=new MyPanel("images/LoginUI/background.jpg");
		panel.setLayout(null);
		panel.setSize(width,height);
		/*
		 * ����panel�ı���
		 */

		panel.setLocation(0,0);
		JLabel label=new JLabel("Test");
		panel.add(label);
		JButton button=new JButton();
		button.setIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/LoginUI/button1.png"));
		button.setPressedIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/LoginUI/button2.png"));
		button.setLocation((int)(width/1.5),(int)(height/1.5));

		button.setSize(171,35);
		button.addActionListener(this);
		panel.add(button);
		/*
		 *  add a textField to input the username
		 */
		userNameField=new JTextField("�������û���");
		userNameField.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
			
				userNameField.setText("");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
		
				
			}
			
		});

		userNameField.setBounds((int)(width/1.5),(int)(height/3.8), 171, 35);
		userNameField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userNameField.setText("");
			}
		});
        
        passwordLabel=new JLabel("����������");
	    passwordLabel.setBounds((int)(width/1.5),(int)(height/2.5),171,35);
        /////////////////////////////
		//fot test
//		passwordField2=new TextField("����������");
//		passwordField2.
//		passwordField2.setBounds((int)(width/1.5),(int)(height/2.5),171,35);
		
		///////////////////////////////////
		
        passwordField=new JPasswordField("����������");
	    passwordField.setEchoChar((char) 0);
	    passwordField.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
			
                     passwordField.setText("");
                     passwordField.setEchoChar('*');
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
	    	
	    });
	   
	    
		passwordField.setBounds((int)(width/1.5),(int)(height/2.5),171,35);
		/*
		 * below is a JCombbox to choose type of user
		 */
		typeChooser=new JComboBox(userType);
		typeChooser.setBounds((int)(width/1.5),(int)(height/1.9),171,35);

		panel.add(userNameField);
		panel.add(passwordField);
		panel.add(typeChooser);
		frame.add(panel);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
        ///////////////////////
		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean isLogined=false;
          try{

			  int  userId=Integer.parseInt(userNameField.getText());
			  String password=passwordField.getText();
			  String type=(String)typeChooser.getSelectedItem();
			  System.out.println(type);
			  isLogined=manager.Login(userId,password,type);
               

		  }catch(NumberFormatException e1)
		  {
			  JOptionPane.showMessageDialog(panel,"����������ȷ��ʽ�������Ϣ");
		  }
		catch(RemoteException el)
		{
			el.printStackTrace();
		}
		if(isLogined)
		{
			LoginUI.this.frame.dispose();
		}
		  
		
	}

}

