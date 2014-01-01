package com.example.cssnwu.presentation.studentUI;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.*;

import com.example.cssnwu.businesslogic.controller.*;


import com.example.cssnwu.businesslogicservice.resultenum.ADD_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.DELETE_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.ManageCourseType;
import com.example.cssnwu.businesslogicservice.resultenum.SYSTEM_STATE;
import com.example.cssnwu.stub.CourseBLService_Stub;
import com.example.cssnwu.stub.ManageCourseBLService_Stub;
import com.example.cssnwu.stub.StudentBLService_Stub;
import com.example.cssnwu.vo.CourseVO;

public class StudentUI2 implements MouseListener{
	private int studentId;  //学生的Id
	private JFrame frame=null;
	private JPanel mainPanel=null;
	private JPanel contentPanel=null;   //用于放二级导航栏和showPanel
	
	private JPanel navigationBarsPanel=null;//一级导航栏panel
	private JPanel secondNavigationPanel=null;//二级导航栏panel
	private JPanel showPanel=null;

	private MyTable table=null;//List的显示
	//各种按钮
	private MyPanel home_Button=null;
	private MyPanel chooseClassButton=null;
	private MyPanel dropClassButton=null;
	private MyPanel myScoreListButton=null;
	private MyPanel myClassListButton=null;
	private MyPanel myDropoutButton=null;
	private MyPanel myInformationButton=null;//个人信息按钮
	private MyPanel secondSelectClassButton=null;   //分别是一二级导航栏按钮，内容重复
	private MyPanel secondDropClassButton=null;
	private MyPanel secondMyScoreListButton=null;
	private MyPanel secondMyClassListButton=null;
	private JButton submitButton=null;
	private JButton dropButton=null;
	/*
	 * 下列是相关数据成员
	 */
    
    private String[] columName={"课程名","时间","地点","课程介绍","学分","课程老师"};
    private String[] columnNameForGrade={"课程名","课程介绍","学分","成绩"};
    private ArrayList<CourseVO> classList=new ArrayList<CourseVO>();//选课列表
	private ArrayList<CourseVO> selectedList=new ArrayList<CourseVO>();//已选未确定的课表
	private ArrayList<CourseVO> myCourseList=new ArrayList<CourseVO>();//我的课程
	private MyTable classTable=null;
	private MyTable myCourseTable=null;
	private MyTable dropCourseTable=null;
	/*
	 * 下面是一些bool值
	 */
	private boolean isFirstCheckSelectedClassList=true;//用于记录是否是第一次点击已选未确定课程列表。
	private boolean isFirstSelectedClass=true;//用于记录是否第一次点击选择次节课。
	private boolean isSubmitButtonAble=false;//用于记录提交选课课程的按钮是否可用
	private boolean isDropButtonAble=false;//用于记录退选课程的按钮是否可用
	/*
	 * 逻辑层的调用对象
	 */
	private StudentController studentController=null;
	private StudentBLService_Stub studentStub=null;////自己测试使用
	private	CourseBLService_Stub courseStub=null;   ///测试
	//private	Login
	private	ManageCourseBLService_Stub manageCourseStub=null;//
	private ManageCourseController manageCourseController=null;
    private CourseController courseController=null;
    private LoginController loginController=null;
    private SystemStateController systemController=null;
	public StudentUI2(int id)
	{  //studentId=Id;
	   
	   studentStub=new StudentBLService_Stub();     ////集成测试
	   courseStub=new CourseBLService_Stub();      /////集成测试
	   
       studentId=id;
      /**
       * //初始化逻辑层的StudentController对象
       */
     try {
		studentController=new StudentController();
		manageCourseController=new ManageCourseController();
		courseController=new CourseController();
		loginController=new LoginController();
		systemController=new SystemStateController();
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
        
        /**
         * Frame的布局设计
         */
        frame=new JFrame("教学系统");
        //以下是设置Frame的大小
	    int width=800;
	    int height=600;
	   
	    frame.setTitle("StudentUI");
	    frame.setSize(width,height);
	    frame.setLocation(width/8+100,height/6);
	    frame.setLocationByPlatform(false);
	   
	 /*
	  * 处理mainpanel的布局和大小
	  */
	    mainPanel=new JPanel();
	    mainPanel.setLayout(null);
	    /*
	     * 设置一级导航栏的内容和布局约束
	     */
	    navigationBarsPanel=new MyPanel("images/StudentUI/nav-bar.png");
	    navigationBarsPanel.setLayout(null);
	    navigationBarsPanel.setBounds(0,0,800,50);
	   //navigationBarsPanel.setBackground(Color.RED);
	   /*
	    * 按钮的设置
	    */
	    home_Button=new MyPanel("images/StudentUI/home normal.png");
	    home_Button.setOpaque(false);
	    //主页
	    home_Button.setBounds(200,15,23,32);
	    
	    chooseClassButton=new MyPanel("images/StudentUI/selectcourse normal.png");
	    //选课
	    chooseClassButton.setOpaque(false);
	    chooseClassButton.setBounds(240,15,33,31);
	   
	    dropClassButton=new MyPanel("images/StudentUI/unenrollcourse normal.png");
	    //dropClassButton.add
	    //退课
	    dropClassButton.setOpaque(false);
	    dropClassButton.setBounds(290, 15, 33, 31);
	    
	    myScoreListButton=new MyPanel("images/StudentUI/mygrades normal.png");
	    //我的成绩
	    myScoreListButton.setOpaque(false);
	    myScoreListButton.setBounds(340,15,65,31);
	   
	    myClassListButton=new MyPanel("images/StudentUI/courselist normal.png");
	    //我的课程
	    myClassListButton.setOpaque(false);
	    myClassListButton.setBounds(420,15,65,31);
	    //登出按钮
	    myDropoutButton=new MyPanel("images/StudentUI/setting.png");
	    myDropoutButton.setOpaque(false);
	    myDropoutButton.setBounds(751,15,21,31);
	    //个人信息按钮
	    myInformationButton=new MyPanel("images/StudentUI/profile.png");
	    myInformationButton.setOpaque(false);
	    myInformationButton.setBounds(700,15,23,23);
	   
	    /*
	     * 加到panel上
	     */
	    navigationBarsPanel.add(home_Button);
	    navigationBarsPanel.add(chooseClassButton);
	    navigationBarsPanel.add(dropClassButton);
	    navigationBarsPanel.add(myScoreListButton);
	    navigationBarsPanel.add(myClassListButton);
	    navigationBarsPanel.add(myDropoutButton);
	    navigationBarsPanel.add(myInformationButton);
	   /*
	    * 下便是contentPanel的设置
	   */
		contentPanel=new MyPanel("images/StudentUI/background.jpg");
		contentPanel.setBounds(0,50,800,600);
		contentPanel.setLayout(null);
		
		//设置二级导航栏
		secondNavigationPanel=new JPanel();////无需图片
		secondNavigationPanel.setLayout(null);
		secondNavigationPanel.setBounds(10,30,770,300);
		//设置按钮
		secondSelectClassButton=new MyPanel("images/StudentUI/icon selectcourse normal.png");
        secondSelectClassButton.setBounds(100,100,101,170);
        
        secondDropClassButton=new MyPanel("images/StudentUI/icon unenrollcourse normal.png");
        secondDropClassButton.setBounds(230,100,101,170);
        
        secondMyScoreListButton=new MyPanel("images/StudentUI/icon mygrades normal.png");
        secondMyScoreListButton.setBounds(360,100,101,170);
        
        secondMyClassListButton=new MyPanel("images/StudentUI/icon courselist normal.png");
        secondMyClassListButton.setBounds(490,100,101,170);
        
        //加入这些按钮
        secondNavigationPanel.add(secondSelectClassButton);
        secondNavigationPanel.add(secondDropClassButton);
        secondNavigationPanel.add( secondMyScoreListButton);
        secondNavigationPanel.add(secondMyClassListButton);
        
       
        //showPanle
        showPanel=new JPanel();
        showPanel.setBounds(0,310,800,200);
        showPanel.setLayout(new BorderLayout());
	   //contetnPanel 加入二级导航栏
        contentPanel.add(secondNavigationPanel);
        contentPanel.add(showPanel);
        
       
        //将2个panel加入主panel中
		mainPanel.add(navigationBarsPanel);
		mainPanel.add(contentPanel);
		///mainPanel.add(showPanel,constraint3);
		//add mainPanel to Frame and set the basic information of Frame
		frame.add(mainPanel);
		frame.addMouseListener(this);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	    }
	    @Override
 	    public void mouseClicked(MouseEvent e) {
		  // TODO Auto-generated method stub
		  int x=e.getX();
		  int y=e.getY();
		/*
		 * 点击主页面按钮
		 */
		  if((x>200)&&(x<230)&&(y>30)&&(y<65))  
		    { 
			   submitButton=null;
			   dropButton=null;
			
			   contentPanel.removeAll();
		       secondNavigationPanel=new JPanel();////无需图片
		       secondNavigationPanel.setLayout(null);
		       secondNavigationPanel.setBounds(10,30,770,300);
		       /*
		        * 设置按钮
		        */
		       secondSelectClassButton=new MyPanel("images/StudentUI/icon selectcourse normal.png");
		       secondSelectClassButton.setBounds(100,100,101,170);

		       secondDropClassButton=new MyPanel("images/StudentUI/icon unenrollcourse normal.png");
		       secondDropClassButton.setBounds(230,100,101,170);

		       secondMyScoreListButton=new MyPanel("images/StudentUI/icon mygrades normal.png");
		       secondMyScoreListButton.setBounds(360,100,101,170);

		       secondMyClassListButton=new MyPanel("images/StudentUI/icon courselist normal.png");
		       secondMyClassListButton.setBounds(490,100,101,170);

			/*
			 * 加入这些按钮
			 */
		       secondNavigationPanel.add(secondSelectClassButton);
		       secondNavigationPanel.add(secondDropClassButton);
		       secondNavigationPanel.add( secondMyScoreListButton);
		       secondNavigationPanel.add(secondMyClassListButton);


		       //showPanle
		       showPanel=new JPanel();
		       showPanel.setBounds(0,310,800,200);
		       showPanel.setLayout(new BorderLayout());
		       //contetnPanel 加入二级导航栏
		       contentPanel.add(secondNavigationPanel);
		       contentPanel.add(showPanel);
		       contentPanel.revalidate();
		       contentPanel.repaint();

		    }
		/**
		 * 点击选课
		 */
		if((x>240)&&(x<280)&&(y>30)&&(y<70))
		   {  /*
		        *设置二级导航栏
		        */
			   isSubmitButtonAble=true;   //点击此按钮有效
			   isDropButtonAble=false;   //此按钮无效中
			   secondNavigationPanel.removeAll();
			 ///////:TODO:   系统状态的实现
			   try {
				   if(systemController.checkCurrentSystemState(SYSTEM_STATE.chooseCourse))
				   {
					   MyPanel testSecondSelectClassButton=new MyPanel("images/StudentUI/selectcourse normal.png");
					   testSecondSelectClassButton.setBounds(0,0,33,31);
				
					   secondNavigationPanel.setBounds(0, 0,800,50);
					   secondNavigationPanel.add(testSecondSelectClassButton);
				   try {
					   ///classList=courseStub.getAllCourse();////////  集成测试
					   classList=courseController.getAllCourse();//获得课程列表
					   System.out.println(" classList=courseController.getAllCourse();//获得课程列表" + classList.size());
				   } catch (RemoteException e1) {
					   // TODO Auto-generated catch block
					   e1.printStackTrace();
					   System.out.println("RemoteException in get chooseButton Action");
				   }
  
				   	   classTable=new MyTable(classList,columName);
        
				   	   showPanel.removeAll();
				   	   showPanel.setBounds(0, 100,800, 350);
				   	   showPanel.add(new JScrollPane(classTable));
				   	   showPanel.revalidate();
				   	   showPanel.repaint();
				   	   /*
				   	    * 增加三级导航栏
				   	    */
				      if(dropButton!=null)
				      	{
				    	  contentPanel.remove(dropButton);
				    	  dropButton=null;
				      	}
				      if(submitButton!=null)
				        {
				    	  contentPanel.remove(submitButton);
				    	  submitButton=null;
				        }	
				       submitButton=new JButton("选课");
				       submitButton.setIcon(new ImageIcon("images/button submit.png"));
				       submitButton.addActionListener(new ActionListener() {
				    	   	@Override
				    	   	public void actionPerformed(ActionEvent e) {
				    	   		/*
				    	   		 * 初始化manageCourseController的各种方法
				    	   		 */
				    	   		try{  
				    	   			manageCourseController.addStudent(studentId);
						            manageCourseController.addManageType(ManageCourseType.select);
						            //manageCourseStub.addStudent(studentId);
				    	   			//manageCourseStub.addManageType(ManageCourseType.select);
				    	   		    }catch (RemoteException el)
				    	   			{
				    	   			el.printStackTrace();
				    	   			}

				    	   		if(classTable.getSelectedItem()!=null)  //当用户选定了一节课
				    	   		{  	int result=JOptionPane.showConfirmDialog(mainPanel, "是否确认选择这些课程","提醒",JOptionPane.YES_NO_CANCEL_OPTION);
				    	   			if(result==JOptionPane.OK_OPTION)  //用户确认选择此节课，更新课程表，存入信息
				    	   			{
				    	   				ADD_RESULT add_result = manageCourseController.addCourse(classTable.getSelectedItem());//方法
				    	   				///ADD_RESULT add_resultTest= manageCourseStub.addCourse(classTable.getSelectedItem());
									if(MessageHandler.handleMessage(add_result, frame))
									{
										try {
											manageCourseController.endManage();
											///manageCourseStub.endManage();//////
										} catch (RemoteException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}// todo:
										// manageCourseController.endManage();
										selectedList.add(classTable.getSelectedItem());//测试
										//下列是从列表中删除此项并显示
										classList.remove(classTable.getSelectedItem());
										//此时以后选课，显示已选课程列表按键。
										classTable=new MyTable(classList,columName);
										showPanel.removeAll();
										showPanel.add(new JScrollPane(classTable));
										showPanel.revalidate();
										showPanel.repaint();
									}
							  	}///////////////////////////
							 }else{
								JOptionPane.showMessageDialog(mainPanel,"请先选中一门课程");
							  }
						  }
				      });
				      submitButton.setBounds(600,460,174,38);
                      contentPanel.add(submitButton);
                      contentPanel.revalidate();
                      contentPanel.repaint();
                      secondNavigationPanel.revalidate();
                      secondNavigationPanel.repaint();
                      //contentPanel.revalidate();
                      //contentPanel.repaint();
                      /*
                       * 由于重复点击问题，将二级导航栏的按钮是否第一次点击状态全设为true
                       */
                      isFirstSelectedClass=true;
                      isFirstCheckSelectedClassList=true;
		    }else{
					JOptionPane.showMessageDialog(frame,"现阶段不能选课");
				}
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}         
			/*
			 * 由于重复点击问题，将二级导航栏的按钮是否第一次点击状态全设为true
			 */
			   isFirstSelectedClass=true;
			   isFirstCheckSelectedClassList=true;   
			
		}
		/*
		 * 退选课程
		 */
		if((x>290)&&(x<330)&&(y>36)&&(y<70))
		{        //获得本学生的课程列表
			isSubmitButtonAble=false;   //点击此按钮有效
			isDropButtonAble=true;   //此按钮无效中
			if(submitButton!=null)
			{
				contentPanel.remove(submitButton);
				submitButton=null;
			}
			if(dropButton!=null)
			{
				contentPanel.remove(dropButton);
				dropButton=null;
			}
			try {
				if(systemController.checkCurrentSystemState(SYSTEM_STATE.dropCourse))
				{
				 try {
						myCourseList=studentController.getCourses(studentId);
						//myCourseList=studentStub.getCourses(studentId);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						System.out.println("RemoteException in get CoursePO in dropClass Button Action");
					
					}//获得学生的课程列表
				 /*
				  * 设置二级导航栏
				  */
				 secondNavigationPanel.removeAll();
				 secondNavigationPanel.setBounds(0, 0,800,50);
				 secondNavigationPanel.revalidate();
				 secondNavigationPanel.repaint();
				 
				 /*
				  * 显示学生已有课程列表
				  */
				 dropCourseTable=new MyTable(myCourseList,columName);
				 showPanel.removeAll();
				 showPanel.setBounds(0, 100,800, 350);
				 showPanel.add(new JScrollPane(dropCourseTable));
				 showPanel.revalidate();
				 showPanel.repaint();
				
				 dropButton=new JButton("退课");
				 dropButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							boolean isSuccessfulDrop=false;
							if(dropCourseTable.getSelectedItem()!=null)
							{      int result=JOptionPane.showConfirmDialog(mainPanel, "是否确认退选这节课",
									               null, JOptionPane.OK_CANCEL_OPTION);
								   if(result==JOptionPane.OK_OPTION)
								   {   
									 try {
											manageCourseController.addStudent(studentId);
											manageCourseController.addManageType(ManageCourseType.quit);
				                            DELETE_RESULT r = manageCourseController.deleteCourse(dropCourseTable.getSelectedItem());
				                            //manageCourseStub.addStudent(studentId);
				                            //manageCourseStub.addManageType(ManageCourseType.quit);
				                            //DELETE_RESULT rTest=manageCourseStub.deleteCourse(dropCourseTable.getSelectedItem());
				                            
				                            if(MessageHandler.handleMessage(r,frame))
				                            {
				                        	   isSuccessfulDrop=true;
				                            }
				                            manageCourseController.endManage();
				                            ///manageCourseStub.endManage();
				                            } catch (RemoteException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									if(isSuccessfulDrop)
									{
										myCourseList.remove(dropCourseTable.getSelectedItem());
										dropCourseTable=new MyTable(myCourseList,columName);
										showPanel.removeAll();
										showPanel.add(new JScrollPane(dropCourseTable));
										showPanel.revalidate();
										showPanel.repaint();
									}
				              }
							}else{
								JOptionPane.showMessageDialog(mainPanel, "请先选中一门课程");
							}
						}
					});
				    dropButton.setBounds(600,460,174,38);
				    contentPanel.add(dropButton);
				    contentPanel.revalidate();
					contentPanel.repaint();
            }else{
            	JOptionPane.showMessageDialog(frame,"现阶段不能退课");
            }
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    }
	/*
	 * 点击我的成绩
	 */
		if((x>340)&&(x<410)&&(y>35)&&(y<70))
		{     try {
				myCourseList=studentController.getCourses(studentId);
				//myCourseList=studentStub.getCourses(studentId);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("RemoteException in get CoursePO in dropClass Button Action");

		}//获得学生的课程列表
			//设置二级导航栏
			  secondNavigationPanel.removeAll();
			  secondNavigationPanel.setBounds(0, 0,800,50);
			  secondNavigationPanel.revalidate();
			  secondNavigationPanel.repaint();

			/*
			 * 显示学生已有课程列表
			 */
			  dropCourseTable=new MyTable(myCourseList,columnNameForGrade);
			  showPanel.removeAll();
			  showPanel.setBounds(0, 100,800, 350);
			  showPanel.add(new JScrollPane(dropCourseTable));
			  showPanel.revalidate();
			  showPanel.repaint();
			  if(submitButton!=null)
			  {  
				  contentPanel.remove(submitButton);
				  submitButton=null;
			  }
			  if(dropButton!=null)
			  {
				  contentPanel.remove(dropButton);
				  dropButton=null;
			  }
			  contentPanel.revalidate();
			  contentPanel.repaint();
		    
			}
		 /*
		  * 点击我的课程列表按钮
		  */
		if((x>420)&&(x<490)&&(y>35)&&(y<60))  
		{     try {
					myCourseList=studentController.getCourses(studentId);
					//myCourseList=studentStub.getCourses(studentId);
			  } catch (RemoteException e1) {
				// TODO Auto-generated catch block
				   e1.printStackTrace();
				   System.out.println("RemoteException in get CoursePO in dropClass Button Action");

			  }//获得学生的课程列表
				//设置二级导航栏
				secondNavigationPanel.removeAll();
				secondNavigationPanel.setBounds(0, 0,800,50);
				secondNavigationPanel.revalidate();
				secondNavigationPanel.repaint();

				//显示学生已有课程列表
				dropCourseTable=new MyTable(myCourseList,columName);
				showPanel.removeAll();
				showPanel.setBounds(0, 100,800, 350);
				showPanel.add(new JScrollPane(dropCourseTable));
				showPanel.revalidate();
				showPanel.repaint();
				if(submitButton!=null)
				{  
					contentPanel.remove(submitButton);
					submitButton=null;
				}
				if(dropButton!=null)
				{
					contentPanel.remove(dropButton);
					dropButton=null;
				}
					contentPanel.revalidate();
					contentPanel.repaint();
				}
		/*
		 * 点击登出
		 */
		if((x>750)&&(x<769)&&(y>30)&&(y<65))
		{       
			  int isWantLoginout=JOptionPane.showConfirmDialog(frame,"是否确定退出", "系统提示",
					                          JOptionPane.YES_NO_OPTION);
			  if(isWantLoginout==0)
			  {    
				    try {
						loginController.logout(studentId);
						
						frame.dispose();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				   
			  }
		}
	}
		
	
	@Override
	public void mousePressed(MouseEvent e) {
		
		 int x=e.getX();
		 int y=e.getY();
		 /*
		  * 点击homeButton
		  */
		 if((x>200)&&(x<230)&&(y>30)&&(y<65))
		 {    home_Button.setImage("images/StudentUI/home pressed.png");
			  contentPanel.removeAll();
			  contentPanel.add(secondNavigationPanel);
			  contentPanel.add(showPanel);
		  }
		 if((x>240)&&(x<280)&&(y>30)&&(y<70))
		 {    chooseClassButton.setImage("images/StudentUI/selectcourse pressed.png");
		 }
         if((x>290)&&(x<330)&&(y>36)&&(y<70))
         {
			 dropClassButton.setImage("images/StudentUI/unenrollcourse pressed.png");
	     }
		 if((x>420)&&(x<490)&&(y>35)&&(y<60))
		 {
			myClassListButton.setImage("images/StudentUI/courselist pressed.png");
		 }
		 if((x>340)&&(x<410)&&(y>35)&&(y<70))
		 {
			myScoreListButton.setImage("images/StudentUI/mygrades pressed.png");
		 }
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		int x=e.getX();
		int y=e.getY();
		if((x>200)&&(x<230)&&(y>30)&&(y<65))
		 {    home_Button.setImage("images/StudentUI/home normal.png");
			  
		 }//释放Button
		if((x>240)&&(x<280)&&(y>30)&&(y<70))
		{     chooseClassButton.setImage("images/StudentUI/selectcourse normal.png");
		}
		if((x>290)&&(x<330)&&(y>38)&&(y<70))
		{
			 dropClassButton.setImage("images/StudentUI/unenrollcourse normal.png");
		}
		if((x>420)&&(x<490)&&(y>35)&&(y<60))
		{
			 myClassListButton.setImage("images/StudentUI/courselist normal.png");
		}
		if((x>340)&&(x<410)&&(y>35)&&(y<70))
		{
			myScoreListButton.setImage("images/StudentUI/mygrades normal.png");
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
		/*int x=e.getX();
		int y=e.getY();
		if((x>200)&&(x<230)&&(y>30)&&(y<65))
		 {    home_Button.setImage("images/StudentUI/home mouse_over.png");
			  
		 }
		if((x>240)&&(x<280)&&(y>30)&&(y<70))
		{       chooseClassButton.setImage("images/StudentUI/selectcourse mouse_over.png");
		        
			
		}*/
				
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		/*int x=e.getX();
		int y=e.getY();
		if((x>200)&&(x<230)&&(y>30)&&(y<65))
		 {    home_Button.setImage("images/StudentUI/home normal.png");
			  
		 }
		if(((x>240)&&(x<280)&&(y>30)&&(y<70)))
		{       chooseClassButton.setImage("images/StudentUI/selectcourse normal.png");
		        
			
		}*/
	}
}
