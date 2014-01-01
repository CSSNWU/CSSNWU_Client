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
	private int studentId;  //ѧ����Id
	private JFrame frame=null;
	private JPanel mainPanel=null;
	private JPanel contentPanel=null;   //���ڷŶ�����������showPanel
	
	private JPanel navigationBarsPanel=null;//һ��������panel
	private JPanel secondNavigationPanel=null;//����������panel
	private JPanel showPanel=null;

	private MyTable table=null;//List����ʾ
	//���ְ�ť
	private MyPanel home_Button=null;
	private MyPanel chooseClassButton=null;
	private MyPanel dropClassButton=null;
	private MyPanel myScoreListButton=null;
	private MyPanel myClassListButton=null;
	private MyPanel myDropoutButton=null;
	private MyPanel myInformationButton=null;//������Ϣ��ť
	private MyPanel secondSelectClassButton=null;   //�ֱ���һ������������ť�������ظ�
	private MyPanel secondDropClassButton=null;
	private MyPanel secondMyScoreListButton=null;
	private MyPanel secondMyClassListButton=null;
	private JButton submitButton=null;
	private JButton dropButton=null;
	/*
	 * ������������ݳ�Ա
	 */
    
    private String[] columName={"�γ���","ʱ��","�ص�","�γ̽���","ѧ��","�γ���ʦ"};
    private String[] columnNameForGrade={"�γ���","�γ̽���","ѧ��","�ɼ�"};
    private ArrayList<CourseVO> classList=new ArrayList<CourseVO>();//ѡ���б�
	private ArrayList<CourseVO> selectedList=new ArrayList<CourseVO>();//��ѡδȷ���Ŀα�
	private ArrayList<CourseVO> myCourseList=new ArrayList<CourseVO>();//�ҵĿγ�
	private MyTable classTable=null;
	private MyTable myCourseTable=null;
	private MyTable dropCourseTable=null;
	/*
	 * ������һЩboolֵ
	 */
	private boolean isFirstCheckSelectedClassList=true;//���ڼ�¼�Ƿ��ǵ�һ�ε����ѡδȷ���γ��б�
	private boolean isFirstSelectedClass=true;//���ڼ�¼�Ƿ��һ�ε��ѡ��νڿΡ�
	private boolean isSubmitButtonAble=false;//���ڼ�¼�ύѡ�ογ̵İ�ť�Ƿ����
	private boolean isDropButtonAble=false;//���ڼ�¼��ѡ�γ̵İ�ť�Ƿ����
	/*
	 * �߼���ĵ��ö���
	 */
	private StudentController studentController=null;
	private StudentBLService_Stub studentStub=null;////�Լ�����ʹ��
	private	CourseBLService_Stub courseStub=null;   ///����
	//private	Login
	private	ManageCourseBLService_Stub manageCourseStub=null;//
	private ManageCourseController manageCourseController=null;
    private CourseController courseController=null;
    private LoginController loginController=null;
    private SystemStateController systemController=null;
	public StudentUI2(int id)
	{  //studentId=Id;
	   
	   studentStub=new StudentBLService_Stub();     ////���ɲ���
	   courseStub=new CourseBLService_Stub();      /////���ɲ���
	   
       studentId=id;
      /**
       * //��ʼ���߼����StudentController����
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
         * Frame�Ĳ������
         */
        frame=new JFrame("��ѧϵͳ");
        //����������Frame�Ĵ�С
	    int width=800;
	    int height=600;
	   
	    frame.setTitle("StudentUI");
	    frame.setSize(width,height);
	    frame.setLocation(width/8+100,height/6);
	    frame.setLocationByPlatform(false);
	   
	 /*
	  * ����mainpanel�Ĳ��ֺʹ�С
	  */
	    mainPanel=new JPanel();
	    mainPanel.setLayout(null);
	    /*
	     * ����һ�������������ݺͲ���Լ��
	     */
	    navigationBarsPanel=new MyPanel("images/StudentUI/nav-bar.png");
	    navigationBarsPanel.setLayout(null);
	    navigationBarsPanel.setBounds(0,0,800,50);
	   //navigationBarsPanel.setBackground(Color.RED);
	   /*
	    * ��ť������
	    */
	    home_Button=new MyPanel("images/StudentUI/home normal.png");
	    home_Button.setOpaque(false);
	    //��ҳ
	    home_Button.setBounds(200,15,23,32);
	    
	    chooseClassButton=new MyPanel("images/StudentUI/selectcourse normal.png");
	    //ѡ��
	    chooseClassButton.setOpaque(false);
	    chooseClassButton.setBounds(240,15,33,31);
	   
	    dropClassButton=new MyPanel("images/StudentUI/unenrollcourse normal.png");
	    //dropClassButton.add
	    //�˿�
	    dropClassButton.setOpaque(false);
	    dropClassButton.setBounds(290, 15, 33, 31);
	    
	    myScoreListButton=new MyPanel("images/StudentUI/mygrades normal.png");
	    //�ҵĳɼ�
	    myScoreListButton.setOpaque(false);
	    myScoreListButton.setBounds(340,15,65,31);
	   
	    myClassListButton=new MyPanel("images/StudentUI/courselist normal.png");
	    //�ҵĿγ�
	    myClassListButton.setOpaque(false);
	    myClassListButton.setBounds(420,15,65,31);
	    //�ǳ���ť
	    myDropoutButton=new MyPanel("images/StudentUI/setting.png");
	    myDropoutButton.setOpaque(false);
	    myDropoutButton.setBounds(751,15,21,31);
	    //������Ϣ��ť
	    myInformationButton=new MyPanel("images/StudentUI/profile.png");
	    myInformationButton.setOpaque(false);
	    myInformationButton.setBounds(700,15,23,23);
	   
	    /*
	     * �ӵ�panel��
	     */
	    navigationBarsPanel.add(home_Button);
	    navigationBarsPanel.add(chooseClassButton);
	    navigationBarsPanel.add(dropClassButton);
	    navigationBarsPanel.add(myScoreListButton);
	    navigationBarsPanel.add(myClassListButton);
	    navigationBarsPanel.add(myDropoutButton);
	    navigationBarsPanel.add(myInformationButton);
	   /*
	    * �±���contentPanel������
	   */
		contentPanel=new MyPanel("images/StudentUI/background.jpg");
		contentPanel.setBounds(0,50,800,600);
		contentPanel.setLayout(null);
		
		//���ö���������
		secondNavigationPanel=new JPanel();////����ͼƬ
		secondNavigationPanel.setLayout(null);
		secondNavigationPanel.setBounds(10,30,770,300);
		//���ð�ť
		secondSelectClassButton=new MyPanel("images/StudentUI/icon selectcourse normal.png");
        secondSelectClassButton.setBounds(100,100,101,170);
        
        secondDropClassButton=new MyPanel("images/StudentUI/icon unenrollcourse normal.png");
        secondDropClassButton.setBounds(230,100,101,170);
        
        secondMyScoreListButton=new MyPanel("images/StudentUI/icon mygrades normal.png");
        secondMyScoreListButton.setBounds(360,100,101,170);
        
        secondMyClassListButton=new MyPanel("images/StudentUI/icon courselist normal.png");
        secondMyClassListButton.setBounds(490,100,101,170);
        
        //������Щ��ť
        secondNavigationPanel.add(secondSelectClassButton);
        secondNavigationPanel.add(secondDropClassButton);
        secondNavigationPanel.add( secondMyScoreListButton);
        secondNavigationPanel.add(secondMyClassListButton);
        
       
        //showPanle
        showPanel=new JPanel();
        showPanel.setBounds(0,310,800,200);
        showPanel.setLayout(new BorderLayout());
	   //contetnPanel �������������
        contentPanel.add(secondNavigationPanel);
        contentPanel.add(showPanel);
        
       
        //��2��panel������panel��
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
		 * �����ҳ�水ť
		 */
		  if((x>200)&&(x<230)&&(y>30)&&(y<65))  
		    { 
			   submitButton=null;
			   dropButton=null;
			
			   contentPanel.removeAll();
		       secondNavigationPanel=new JPanel();////����ͼƬ
		       secondNavigationPanel.setLayout(null);
		       secondNavigationPanel.setBounds(10,30,770,300);
		       /*
		        * ���ð�ť
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
			 * ������Щ��ť
			 */
		       secondNavigationPanel.add(secondSelectClassButton);
		       secondNavigationPanel.add(secondDropClassButton);
		       secondNavigationPanel.add( secondMyScoreListButton);
		       secondNavigationPanel.add(secondMyClassListButton);


		       //showPanle
		       showPanel=new JPanel();
		       showPanel.setBounds(0,310,800,200);
		       showPanel.setLayout(new BorderLayout());
		       //contetnPanel �������������
		       contentPanel.add(secondNavigationPanel);
		       contentPanel.add(showPanel);
		       contentPanel.revalidate();
		       contentPanel.repaint();

		    }
		/**
		 * ���ѡ��
		 */
		if((x>240)&&(x<280)&&(y>30)&&(y<70))
		   {  /*
		        *���ö���������
		        */
			   isSubmitButtonAble=true;   //����˰�ť��Ч
			   isDropButtonAble=false;   //�˰�ť��Ч��
			   secondNavigationPanel.removeAll();
			 ///////:TODO:   ϵͳ״̬��ʵ��
			   try {
				   if(systemController.checkCurrentSystemState(SYSTEM_STATE.chooseCourse))
				   {
					   MyPanel testSecondSelectClassButton=new MyPanel("images/StudentUI/selectcourse normal.png");
					   testSecondSelectClassButton.setBounds(0,0,33,31);
				
					   secondNavigationPanel.setBounds(0, 0,800,50);
					   secondNavigationPanel.add(testSecondSelectClassButton);
				   try {
					   ///classList=courseStub.getAllCourse();////////  ���ɲ���
					   classList=courseController.getAllCourse();//��ÿγ��б�
					   System.out.println(" classList=courseController.getAllCourse();//��ÿγ��б�" + classList.size());
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
				   	    * ��������������
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
				       submitButton=new JButton("ѡ��");
				       submitButton.setIcon(new ImageIcon("images/button submit.png"));
				       submitButton.addActionListener(new ActionListener() {
				    	   	@Override
				    	   	public void actionPerformed(ActionEvent e) {
				    	   		/*
				    	   		 * ��ʼ��manageCourseController�ĸ��ַ���
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

				    	   		if(classTable.getSelectedItem()!=null)  //���û�ѡ����һ�ڿ�
				    	   		{  	int result=JOptionPane.showConfirmDialog(mainPanel, "�Ƿ�ȷ��ѡ����Щ�γ�","����",JOptionPane.YES_NO_CANCEL_OPTION);
				    	   			if(result==JOptionPane.OK_OPTION)  //�û�ȷ��ѡ��˽ڿΣ����¿γ̱�������Ϣ
				    	   			{
				    	   				ADD_RESULT add_result = manageCourseController.addCourse(classTable.getSelectedItem());//����
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
										selectedList.add(classTable.getSelectedItem());//����
										//�����Ǵ��б���ɾ�������ʾ
										classList.remove(classTable.getSelectedItem());
										//��ʱ�Ժ�ѡ�Σ���ʾ��ѡ�γ��б�����
										classTable=new MyTable(classList,columName);
										showPanel.removeAll();
										showPanel.add(new JScrollPane(classTable));
										showPanel.revalidate();
										showPanel.repaint();
									}
							  	}///////////////////////////
							 }else{
								JOptionPane.showMessageDialog(mainPanel,"����ѡ��һ�ſγ�");
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
                       * �����ظ�������⣬�������������İ�ť�Ƿ��һ�ε��״̬ȫ��Ϊtrue
                       */
                      isFirstSelectedClass=true;
                      isFirstCheckSelectedClassList=true;
		    }else{
					JOptionPane.showMessageDialog(frame,"�ֽ׶β���ѡ��");
				}
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}         
			/*
			 * �����ظ�������⣬�������������İ�ť�Ƿ��һ�ε��״̬ȫ��Ϊtrue
			 */
			   isFirstSelectedClass=true;
			   isFirstCheckSelectedClassList=true;   
			
		}
		/*
		 * ��ѡ�γ�
		 */
		if((x>290)&&(x<330)&&(y>36)&&(y<70))
		{        //��ñ�ѧ���Ŀγ��б�
			isSubmitButtonAble=false;   //����˰�ť��Ч
			isDropButtonAble=true;   //�˰�ť��Ч��
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
					
					}//���ѧ���Ŀγ��б�
				 /*
				  * ���ö���������
				  */
				 secondNavigationPanel.removeAll();
				 secondNavigationPanel.setBounds(0, 0,800,50);
				 secondNavigationPanel.revalidate();
				 secondNavigationPanel.repaint();
				 
				 /*
				  * ��ʾѧ�����пγ��б�
				  */
				 dropCourseTable=new MyTable(myCourseList,columName);
				 showPanel.removeAll();
				 showPanel.setBounds(0, 100,800, 350);
				 showPanel.add(new JScrollPane(dropCourseTable));
				 showPanel.revalidate();
				 showPanel.repaint();
				
				 dropButton=new JButton("�˿�");
				 dropButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							boolean isSuccessfulDrop=false;
							if(dropCourseTable.getSelectedItem()!=null)
							{      int result=JOptionPane.showConfirmDialog(mainPanel, "�Ƿ�ȷ����ѡ��ڿ�",
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
								JOptionPane.showMessageDialog(mainPanel, "����ѡ��һ�ſγ�");
							}
						}
					});
				    dropButton.setBounds(600,460,174,38);
				    contentPanel.add(dropButton);
				    contentPanel.revalidate();
					contentPanel.repaint();
            }else{
            	JOptionPane.showMessageDialog(frame,"�ֽ׶β����˿�");
            }
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    }
	/*
	 * ����ҵĳɼ�
	 */
		if((x>340)&&(x<410)&&(y>35)&&(y<70))
		{     try {
				myCourseList=studentController.getCourses(studentId);
				//myCourseList=studentStub.getCourses(studentId);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("RemoteException in get CoursePO in dropClass Button Action");

		}//���ѧ���Ŀγ��б�
			//���ö���������
			  secondNavigationPanel.removeAll();
			  secondNavigationPanel.setBounds(0, 0,800,50);
			  secondNavigationPanel.revalidate();
			  secondNavigationPanel.repaint();

			/*
			 * ��ʾѧ�����пγ��б�
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
		  * ����ҵĿγ��б�ť
		  */
		if((x>420)&&(x<490)&&(y>35)&&(y<60))  
		{     try {
					myCourseList=studentController.getCourses(studentId);
					//myCourseList=studentStub.getCourses(studentId);
			  } catch (RemoteException e1) {
				// TODO Auto-generated catch block
				   e1.printStackTrace();
				   System.out.println("RemoteException in get CoursePO in dropClass Button Action");

			  }//���ѧ���Ŀγ��б�
				//���ö���������
				secondNavigationPanel.removeAll();
				secondNavigationPanel.setBounds(0, 0,800,50);
				secondNavigationPanel.revalidate();
				secondNavigationPanel.repaint();

				//��ʾѧ�����пγ��б�
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
		 * ����ǳ�
		 */
		if((x>750)&&(x<769)&&(y>30)&&(y<65))
		{       
			  int isWantLoginout=JOptionPane.showConfirmDialog(frame,"�Ƿ�ȷ���˳�", "ϵͳ��ʾ",
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
		  * ���homeButton
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
			  
		 }//�ͷ�Button
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
