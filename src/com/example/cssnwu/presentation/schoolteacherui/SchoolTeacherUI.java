package com.example.cssnwu.presentation.schoolteacherui;


import javax.swing.*;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.synth.SynthLookAndFeel;

import com.example.cssnwu.businesslogic.controller.LoginController;
import com.example.cssnwu.businesslogic.controller.SchoolTeacherController;
import com.example.cssnwu.businesslogic.controller.SystemStateController;
import com.example.cssnwu.businesslogicservice.resultenum.INSERT_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.SYSTEM_STATE;
import com.example.cssnwu.presentation.studentUI.MyPanel;
import com.example.cssnwu.presentation.studentUI.MyTable;
import com.example.cssnwu.stub.SchoolTeacherBLService_Stub;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.DepartmentPlanVO;
import com.example.cssnwu.vo.SchoolStrategyVO;
import com.example.cssnwu.vo.StudentVO;
import com.example.cssnwu.vo.TeacherVO;
import com.example.cssnwu.vo.VO;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Calendar;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


/**
 * Created with IntelliJ IDEA.
 * User: Thunder
 * Date: 13-11-21
 * Time: ����8:51
 * To change this template use File | Settings | File Templates.
 */
public class SchoolTeacherUI {
	 private int teacherId;
	 private static String synthFile="synthSkin.xml";
	 private int width;
	 private int height;
	 private JTabbedPane tabPane =null;
	 private JFrame frame=null;
	 private JPanel mainPanel=null;
	 private JPanel   stragetyPane=null;
	 private JPanel   teachInformationPane=null;
	 private JPanel  teacherViewPane=null;//�鿴��ʦ��panel
	 private JPanel  courseViewPane=null;///�鿴ȫУ�γ�
	 private JPanel studentViewPane=null;//����ѧ��panel
	 private JPanel   showPanel=null;
	 private JPanel idPanel =null;
	 private JLabel showLabel=null;
	 private JPanel stragetyInputPanel=null;//�����ѧ���ʱ��ʹ��
	 private JPanel systemStatePanel=null;///�趨ϵͳʱ��
	 private JLabel totalCreditLabel=null;
	 private JTextField totalCreditText=null;
	 private JLabel firstSeasonCreditLabel=null;
	 private JTextField firstSeasonCreditText=null;
	 private JLabel secondSeasonCreditLabel=null;
	 private JTextField secondSeasonCreditText=null;
	 private JLabel thirdSeasonCreditLabel=null;
	 private JTextField thirdSeasonCreditText=null;
	 private JLabel forthSeasonCreditLabel=null;
	 private JTextField forthSeasonCreditText=null;
	 private JLabel systemStates=null;
	 private JCheckBox releaseDepartmentPlanBox=null;
	 private JCheckBox updateDepartmentPlanBox=null;
	 private JCheckBox chooseCourseBox=null;
	 private JCheckBox dropCourseBox=null;
	 private JCheckBox releaseCourseBox=null;
	 private JCheckBox recordScoreBox=null;
	/**
	 *    below are button
	 */
	 private MyPanel teacherInfoButton=null;
	 private MyPanel stragetyButton=null;
	 private MyPanel queryTeacherButton=null;
	 private MyPanel queryCourseButton=null;
	 private MyPanel manageTransferStudentButton=null;
	 private MyPanel manageGraduateStudentButton=null;
	 private MyPanel manageNewStudentButton=null;
	 private MyPanel manageDropStudentButton=null;
	 private MyPanel loginoutButton=null;
	 private MyPanel systemStateButton=null;
	////gridbaglayout
	 private GridBagConstraints constraint1=null;
	 private GridBagConstraints constraint2=null;
	 private GridBagConstraints constraint3=null;
	 //below are some data for showInformation
	 private String[] columnNameForTeacher={"���","����","Ժϵ","���ڿγ�һ","���ڿγ̶�","���ڿγ���"};
	 private String[] columnNameForCourse={"�γ���","ʱ��","�ص�","�γ̽���","ѧ��","��ѧ��ʦ"};
	 private String[] columnNameForTransferStudent={"���","����","Ժϵ","�꼶","ѧ�ּ�","Ŀ��Ժϵ"};
	 private String[] columnNameForGraduateStudent={"���","����","Ժϵ","�꼶","ѧ�ּ�"};
	 private String[] columnNameForNewStudent={"���","����","�Ա�","Ժϵ","��ѧ���"};
	 private String[] columnNameForDropStudent={"���","����","Ժϵ","�꼶"};
	 private String[] columnNameForPlan={"ѧԺ","��һѧ��ѧ��","�ڶ�ѧ��ѧ��","����ѧ��ѧ��","����ѧ��ѧ��"};
	 private ArrayList<DepartmentPlanVO> planList=null;
	 private ArrayList<TeacherVO> teacherList=null;
	 private ArrayList<StudentVO> studentList=null;
	 private ArrayList<StudentVO> transferStudentList=null;
	 private ArrayList<StudentVO> graduateStudentList=null;
	 private ArrayList<VO> newStudentList=null;
	 private ArrayList<StudentVO> dropStudentList=null;
	 private ArrayList<CourseVO> courseList=null;
	 ////below are the MyTable for above four information
	 private MyTable teacherTable=null;
	 private MyTable planTable=null;
	 private MyTable studentTable=null;
	 private MyTable courseTable=null;
	 ///// below are the schoolTeacherController and stub
	 private SchoolTeacherController teacherController=null;
	 private LoginController loginController=null;
	 private SystemStateController stateController=null;
	 private SchoolTeacherBLService_Stub stub=null;
	 /**Title:
	  * Description:���캯��
	  * 
	  * @param id
	  */
	 public SchoolTeacherUI( int id)
		{   // init the controller
		  this.teacherId=id;
		  try {
			    teacherController=new SchoolTeacherController();
				loginController=new LoginController();
				stateController=new SystemStateController();
			} catch (RemoteException e1) {
			
				e1.printStackTrace();
			}
	      /**
	       * ���ֺ�Frame
	       */
		  frame=new JFrame();
		   //����frame�Ĵ�С
		
		  Toolkit kit=Toolkit.getDefaultToolkit();
		  Dimension screenSize=kit.getScreenSize();
		  width=screenSize.width/2;
		  height=screenSize.height/2;
		  frame.setTitle("schoolTeacherUI");
			//this.setSize(width,height);
		  frame.setSize((int)(width*1.1),(int)(height*1.5));
		  frame.setLocation(width/2,height / 2);
		  frame.setLocationByPlatform(false);
		  //this.setExtendedState(Frame.MAXIMIZED_BOTH);
		  /*
		   * ������������panel�Ļ������Ժͱ���
		   */
		  mainPanel=new JPanel();
		  mainPanel.setLayout(null);
		  //ʹ��GridBagʵ�������ʾ
			//GridBagLayout mainLayout=new GridBagLayout();
           // mainLayout.columnWeights=new double[]{1,6,4};

			//mainPanel.setLayout(mainLayout);
		  mainPanel.setSize(width,height);
            //mainPanel.add(new RoundButton("RoundButton"));
			//tabPane = new JTabbedPane();
			//����������tabbedPane�������ѡ��ı���
		  tabPane=new JTabbedPane();
		  tabPane.setTabPlacement(JTabbedPane.TOP);
		  tabPane.setBounds(0,30,(int)(width*1.1),((int)(height/1.2)));
		/*
			* ���ò��Ե�pane
		 */

			
		  stragetyButton=new MyPanel("images/SchoolTeacherUI/icon teachingstrategy normal.png");
		  stragetyButton.setBounds(110,100,200,200);
		  stragetyButton.setOpaque(false);
		  stragetyButton.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {
					
					stragetyButton.setImage("images/SchoolTeacherUI/icon teachingstrategy normal.png");
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					
					stragetyButton.setImage("images/SchoolTeacherUI/icon teachingstrategy pressed.png");
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					
					stragetyButton.setImage("images/SchoolTeacherUI/icon teachingstrategy normal.png");
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
				
					stragetyButton.setImage("images/SchoolTeacherUI/icon teachingstrategy mouse over.png");
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					
					// to do look the department plan  /// add the input panel to showPanel
					stragetyInputPanel=new JPanel();
					stragetyInputPanel.setLayout(null);
					
					/*
					 * ��ʼ����������ĸ������
					 */
					totalCreditLabel=new JLabel("��ѧ��");
					firstSeasonCreditLabel=new JLabel("��һѧ��ѧ��");
					secondSeasonCreditLabel=new JLabel("�ڶ�ѧ��ѧ��");
					thirdSeasonCreditLabel=new JLabel("����ѧ��ѧ��");
					thirdSeasonCreditLabel.setBackground(Color.BLACK);
					forthSeasonCreditLabel=new JLabel("����ѧ��ѧ��");
					totalCreditText=new JTextField(20);
					firstSeasonCreditText=new JTextField(20);
					secondSeasonCreditText=new JTextField(20);
					thirdSeasonCreditText=new JTextField(20);
					forthSeasonCreditText=new JTextField(20);
					
					
					/*
					 * �������������
					 */
					totalCreditLabel.setBounds(30,0,60,50);
					totalCreditText.setBounds(130,10,100,30);
					firstSeasonCreditLabel.setBounds(30,40,100,50);
					firstSeasonCreditText.setBounds(130,50,100,30);
					secondSeasonCreditLabel.setBounds(300,40,100,50);
					secondSeasonCreditText.setBounds(400,50,100,30);
				    thirdSeasonCreditLabel.setBounds(30,80,100,50);
				    thirdSeasonCreditText.setBounds(130,90,100,30);
				    forthSeasonCreditLabel.setBounds(300,80,100,50);
				    forthSeasonCreditText.setBounds(400,90,100,30);
				   
				    /*
				     * ���÷���ť
				     */
				   
				    JButton releaseButton=new JButton("����������");
				    releaseButton.setBounds(580,120,130,30);
				    releaseButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
						    int isWantToRealse=JOptionPane.showConfirmDialog(frame,
						    		                          "�Ƿ�ȷ�Ϸ���������",
						    		                          "ϵͳ��ʾ",
						    		                          JOptionPane.YES_NO_OPTION);
						    if(isWantToRealse==0)
						    {   Calendar ca=Calendar.getInstance();
						        ca.setTime(new java.util.Date());
						        
						    	try {
									
									SchoolStrategyVO schoolStrategyVO=new SchoolStrategyVO();
							    	schoolStrategyVO.id=ca.get(Calendar.YEAR);
							    	schoolStrategyVO.totalCredit=Integer.parseInt(totalCreditText.getText());
							    	schoolStrategyVO.minCreditPerSeason[0]=Integer.parseInt(firstSeasonCreditText.getText());
							    	schoolStrategyVO.minCreditPerSeason[1]=Integer.parseInt(secondSeasonCreditText.getText());
							    	schoolStrategyVO.minCreditPerSeason[2]=Integer.parseInt(thirdSeasonCreditText.getText());
							    	schoolStrategyVO.minCreditPerSeason[3]=Integer.parseInt(forthSeasonCreditText.getText());
							    	INSERT_RESULT result=teacherController.realseSchoolStrategy(schoolStrategyVO);
							    	//INSERT_RESULT resutlTest=stub.realseSchoolStrategy(schoolStrategyVO);
							    	if(result==INSERT_RESULT.ID�Ѿ�����)
							    	{
							    		JOptionPane.showMessageDialog(frame,"�Ѿ�����������");
							    	}
							    	if(result==INSERT_RESULT.����ɹ�)
							    	{
							    		JOptionPane.showMessageDialog(frame,"�����ɹ�");
							    	}
							    	if(result==INSERT_RESULT.�������˴���)
							    	{
                                        JOptionPane.showMessageDialog(frame,"�������˴���");
							    	}
							    	} catch (RemoteException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
						    	catch(NumberFormatException el)
						    	{
						    		JOptionPane.showMessageDialog(frame,"��������ȷ��ʽ����Ϣ");
						    	}
						    }
						}
					});
				    /**
				     * ������
				     */
				    stragetyInputPanel.add(totalCreditLabel);
				    stragetyInputPanel.add(totalCreditText);
				    stragetyInputPanel.add(firstSeasonCreditLabel);
				    stragetyInputPanel.add(firstSeasonCreditText);
				    stragetyInputPanel.add(secondSeasonCreditLabel);
				    stragetyInputPanel.add(secondSeasonCreditText);
				    stragetyInputPanel.add(thirdSeasonCreditLabel);
				    stragetyInputPanel.add(thirdSeasonCreditText);
				    stragetyInputPanel.add(forthSeasonCreditLabel);
				    stragetyInputPanel.add(forthSeasonCreditText);
				    stragetyInputPanel.add(releaseButton);
				    //stragetyInputPanel.add(totalCreditText);
				
					showPanel.removeAll();
					showPanel.setLayout(new BorderLayout());
					JScrollPane jp=new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
					jp.setViewportView(stragetyInputPanel);
					stragetyInputPanel.setPreferredSize(new Dimension(showPanel.getWidth(),250));
					stragetyInputPanel.revalidate();
					showPanel.add(jp);
			     	showPanel.revalidate();
					showPanel.repaint();
				}
			});
			/*
			 * ���÷���ϵͳ״̬�İ�ť
			 */
			systemStateButton=new MyPanel("images/SchoolTeacherUI/icon teachinginfo normal.png");
			systemStateButton.setBounds(300,100,200,200);
			systemStateButton.setOpaque(false);
			systemStateButton.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
				
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
			
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
				
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
				
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					
					systemStatePanel=new JPanel();
					systemStatePanel.setLayout(null);
					systemStates=new JLabel("�趨ϵͳ״̬");
					releaseDepartmentPlanBox=new JCheckBox("����Ժϵ��ѧ�ƻ�");
					updateDepartmentPlanBox=new JCheckBox("�޸�Ժϵ��ѧ�ƻ�");
					releaseCourseBox=new JCheckBox("�����γ�");
					chooseCourseBox=new JCheckBox("ѧ��ѡ��");
					dropCourseBox=new JCheckBox("ѧ���˿�");
					recordScoreBox=new JCheckBox("¼��ɼ�");
					systemStates.setBounds(30,20,100,40);
					releaseDepartmentPlanBox.setBounds(20,60,130,30);
					updateDepartmentPlanBox.setBounds(160,60,130,30);
					releaseCourseBox.setBounds(300,60,100,30);
					chooseCourseBox.setBounds(400,60,100,30);
					dropCourseBox.setBounds(500,60,100,30);
					recordScoreBox.setBounds(600,60,100,30);
					//////////////�����ݿ��õ�ǰ״̬
					try {
						releaseDepartmentPlanBox.setSelected(stateController.checkCurrentSystemState(SYSTEM_STATE.releaseDepartmentPlan));
						updateDepartmentPlanBox.setSelected(stateController.checkCurrentSystemState(SYSTEM_STATE.updateDepartmentPlan));
						releaseCourseBox.setSelected(stateController.checkCurrentSystemState(SYSTEM_STATE.releaseCourse));
						chooseCourseBox.setSelected(stateController.checkCurrentSystemState(SYSTEM_STATE.chooseCourse));
						dropCourseBox.setSelected(stateController.checkCurrentSystemState(SYSTEM_STATE.dropCourse));
						recordScoreBox.setSelected(stateController.checkCurrentSystemState(SYSTEM_STATE.recordScore));
					} catch (RemoteException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					JButton setSystemstateButton=new JButton("�趨ϵͳ״̬");
					setSystemstateButton.setBounds(580,100,130, 30);
					setSystemstateButton.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
							
							/*
							 * �������趨ϵͳ״̬
							 */
								if(JOptionPane.showConfirmDialog(frame,"�Ƿ�ȷ�����ô�״̬")==JOptionPane.YES_OPTION)
						    	try {
									stateController.setCurrentSystemState(SYSTEM_STATE.releaseDepartmentPlan,
											                          releaseDepartmentPlanBox.isSelected());
									stateController.setCurrentSystemState(SYSTEM_STATE.updateDepartmentPlan,
	  			 						  updateDepartmentPlanBox.isSelected());
									stateController.setCurrentSystemState(SYSTEM_STATE.chooseCourse,
	  			                          chooseCourseBox.isSelected());
									stateController.setCurrentSystemState(SYSTEM_STATE.dropCourse,
	  			                          dropCourseBox.isSelected());
									stateController.setCurrentSystemState(SYSTEM_STATE.recordScore,
	  									  recordScoreBox.isSelected());
						    	} catch (RemoteException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
						    	
						    	
						   
						    	
							}
						});
					systemStatePanel.add(systemStates);
					systemStatePanel.add(releaseDepartmentPlanBox);
					systemStatePanel.add(updateDepartmentPlanBox);
					systemStatePanel.add(releaseCourseBox);
					systemStatePanel.add(chooseCourseBox);
					systemStatePanel.add(dropCourseBox);
					systemStatePanel.add(recordScoreBox);
					systemStatePanel.add(setSystemstateButton);
					//////////////////////
					showPanel.removeAll();
					showPanel.setLayout(new BorderLayout());
					JScrollPane jp=new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
					jp.setViewportView(systemStatePanel);
					systemStatePanel.setPreferredSize(new Dimension(showPanel.getWidth(),150));
					systemStatePanel.revalidate();
					showPanel.add(jp);
					showPanel.revalidate();
					showPanel.repaint();
					
				}
			});
			stragetyPane=new MyPanel("strategybackground.png");
			stragetyPane.setLayout(null);
			stragetyPane.add(systemStateButton);
			stragetyPane.add(stragetyButton);

			 /*
			  * ����ͼƬ����
			  */
			teachInformationPane=new MyPanel("strategybackground.png");/////////////////////////////////////////////////////TODO:
			teachInformationPane.setLayout(null);
			teacherInfoButton=new MyPanel("images/SchoolTeacherUI/icon teachinginfo normal.png");
			//RoundButton teacherInfoButton=new RoundButton(teacherInfoIcon1);        ///TODO:����ͼƬδ��ȫ��á�
			teacherInfoButton.setBounds(100,50,200,200);
			teacherInfoButton.setOpaque(false);
			teacherInfoButton.addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent e) {
				     try {
//						planList=teacherController.getDepartmentPlans();
				    	planList=teacherController.getDepartmentPlans(); 
//				    	planList=stub.getDepartmentPlans();
						planTable=new MyTable(planList,columnNameForPlan);
						showPanel.removeAll();
						showPanel.setLayout(new BorderLayout());
						showPanel.add(new JScrollPane(planTable));
						planTable.revalidate();
					
						
						
						showPanel.revalidate();
						showPanel.repaint();
						
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
				
					teacherInfoButton.setImage("images/SchoolTeacherUI/icon teachinginfo pressed.png");
				}

				@Override
				public void mouseReleased(MouseEvent e) {
				
					teacherInfoButton.setImage("images/SchoolTeacherUI/icon teachinginfo normal.png");
				}

				@Override
				public void mouseEntered(MouseEvent e) {
				
					teacherInfoButton.setImage("images/SchoolTeacherUI/icon teachinginfo mouse_over.png");
				}

				@Override
				public void mouseExited(MouseEvent e) {
				
					teacherInfoButton.setImage("images/SchoolTeacherUI/icon teachinginfo normal.png");
				}
				
			});
			
            
			teachInformationPane.add(teacherInfoButton);
			
			/*
			 * �鿴ȫУ��ʦ(��ɾ������panel                
			 */
			teacherViewPane=new MyPanel("strategybackground.png");
			teacherViewPane.setBounds(500,500,300,300);
			teacherViewPane.setLayout(null);
			/*
			 * ���ӹ�����ʦ�İ�ť
			 */
			queryTeacherButton=new MyPanel("images/SchoolTeacherUI/icon teachinginfo normal.png");
			
			queryTeacherButton.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
			         
					queryTeacherButton.setImage("images/SchoolTeacherUI/icon teachinginfo normal.png");
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
				
					//queryTeacherButton.setImage("images/SchoolTeacherUI/icon teachinginfo pressed.png");
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
				
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
				
//					queryTeacherButton.setImage("images/SchoolTeacherUI/icon teachinginfo mouse_over.png");
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					
				   	try {
					
				   		teacherList=teacherController.getTeachers();
				   		//teacherList=stub.getTeachers();
						teacherTable=new MyTable(teacherList, columnNameForTeacher);
						showPanel.removeAll();
						showPanel.setLayout(new BorderLayout());
						showPanel.add(new JScrollPane(teacherTable));
						showPanel.revalidate();
						showPanel.repaint();
					} catch (RemoteException e1) {
						
						e1.printStackTrace();
					}
				}
			});
			queryTeacherButton.setOpaque(false);
			queryTeacherButton.setBounds(100,100,200,200);
			teacherViewPane.add(queryTeacherButton);
			
			JButton addTeacherButton=new JButton("������ʦ");
			addTeacherButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				
				      	
				}
			});
			addTeacherButton.setBounds(300,100,100,30);
			//teacherViewPane.add(addTeacherButton);
			
			JButton deleteTeacherButton=new JButton("ɾ����ʦ");
			deleteTeacherButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				
					
				}
			});
			deleteTeacherButton.setBounds(500,100,100,30);
			//teacherViewPane.add(deleteTeacherButton);
			
			
			
			
			/*
			 * �鿴ȫУ�γ̵�panel
			 */
			courseViewPane=new MyPanel("strategybackground.png");
			courseViewPane.setLayout(null);
			courseViewPane.setBounds(500,500,300,300);
			/*
			 * ���ò鿴�γ̵�button
			 */
			queryCourseButton=new MyPanel("images/SchoolTeacherUI/icon teachinginfo normal.png");
			queryCourseButton.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
				
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
				
					try {
						//courseList=stub.getCourses();
						courseList=teacherController.getCourses();
						courseTable=new MyTable(courseList, columnNameForCourse);
						showPanel.removeAll();
						showPanel.setLayout(new BorderLayout());
						JScrollPane jp=new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
						jp.setViewportView(courseTable);
					
						showPanel.add(jp);
						showPanel.revalidate();
						showPanel.repaint();
						
					} catch (RemoteException e1) {
						
						e1.printStackTrace();
					}
				}
			});
			queryCourseButton.setOpaque(false);
			queryCourseButton.setBounds(100,100,200,200);
			courseViewPane.add(queryCourseButton);
			
			
			
			
			/*
			 * ����ȫУѧ����panel
			 */
			 studentViewPane=new MyPanel("strategybackground.png");
			 studentViewPane.setBounds(0,0,300,300);              ////////////////////////////////////////////
			 studentViewPane.setLayout(null);
			 /*
			  * ����������ť
			  */
			 manageTransferStudentButton=new MyPanel("images/SchoolTeacherUI/major change(1).png");
			 manageTransferStudentButton.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
		
					manageTransferStudentButton.setImage("images/SchoolTeacherUI/major change(1).png");
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
				
					manageTransferStudentButton.setImage("images/SchoolTeacherUI/major change pressed(1).png");
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
				
					manageTransferStudentButton.setImage("images/SchoolTeacherUI/major change(1).png");
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
				
					manageTransferStudentButton.setImage("images/SchoolTeacherUI/major change mouse_over(1).png");
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					
				   	try {
					    //transferStudentList=stub.getTransferStudents();
						transferStudentList=teacherController.getTransferStudents();
						studentTable=new MyTable(transferStudentList, columnNameForTransferStudent);
						showPanel.removeAll();
						showPanel.setLayout(new BorderLayout());
						showPanel.add(new JScrollPane(studentTable));
						showPanel.revalidate();
						showPanel.repaint();
						
					} catch (RemoteException e1) {
						
						e1.printStackTrace();
					}
				}
			});
			 manageTransferStudentButton.setBounds(100,100,200,200);
			 manageTransferStudentButton.setOpaque(false);
			 studentViewPane.add(manageTransferStudentButton);
			 /*
			  * ���ù����ҵѧ���İ�ť
			  */
			 manageGraduateStudentButton=new MyPanel("images/SchoolTeacherUI/graduation.png");
			 manageGraduateStudentButton.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
				
					manageGraduateStudentButton.setImage("images/SchoolTeacherUI/graduation.png");
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
				
					manageGraduateStudentButton.setImage("images/SchoolTeacherUI/graduation pressed.png");
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					
					manageGraduateStudentButton.setImage("images/SchoolTeacherUI/graduation.png");
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					
					manageGraduateStudentButton.setImage("images/SchoolTeacherUI/graduate mouse_over.png");
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					
					try {
//						graduateStudentList=stub.getGraduateStudents()
						graduateStudentList=teacherController.getGraduateStudents();
						studentTable=new MyTable(graduateStudentList,columnNameForGraduateStudent);
						
						showPanel.removeAll();
						showPanel.setLayout(new BorderLayout());
						showPanel.add(new JScrollPane(studentTable));
						showPanel.revalidate();
						showPanel.repaint();
						
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}
			});
			 manageGraduateStudentButton.setBounds(250,100,200,200);
			 manageGraduateStudentButton.setOpaque(false);
			 studentViewPane.add(manageGraduateStudentButton);
			 
			 
			 /*
			  * ��������ѧ���Ĵ���ť
			  */
			 manageNewStudentButton=new MyPanel("images/SchoolTeacherUI/add student.png");
			 manageNewStudentButton.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					
					manageNewStudentButton.setImage("images/SchoolTeacherUI/add student.png");
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					
					manageNewStudentButton.setImage("images/SchoolTeacherUI/add student pressed.png");
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
				
					manageNewStudentButton.setImage("images/SchoolTeacherUI/add student.png");
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					
					manageNewStudentButton.setImage("images/SchoolTeacherUI/add student mouse_over.png");
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
				 	
						FileDialog fd = new FileDialog(frame, "ѡ��", FileDialog.LOAD);
						
						fd.setVisible(true);
						try{
				    		Workbook book =Workbook.getWorkbook(new File(fd.getDirectory()+fd.getFile()));
				    		
							studentTable=new MyTable(book,columnNameForNewStudent,"ѧ��");
							showPanel.removeAll();
							showPanel.setLayout(new BorderLayout());
							showPanel.add(new JScrollPane(studentTable));
							
							showPanel.revalidate();
							showPanel.repaint();
							/*
							 * д�����ݿ�
							 */
							newStudentList=WorkBookHandler.handleWorkBook(book);
							teacherController.addNewStudent(newStudentList);
				    		
				    	} catch (RemoteException e1) {
					
						e1.printStackTrace();
					}
					catch(Exception el)
			    	{
			    		el.printStackTrace();
			    	}
				}
			});
			 manageNewStudentButton.setBounds(400,100,200,200);
			 manageNewStudentButton.setOpaque(false);
			 studentViewPane.add(manageNewStudentButton);
			 
			 /*
			  * ������ѧ��ѧ������ť
			  */
			 manageDropStudentButton=new MyPanel("images/SchoolTeacherUI/xueji change.png");
			 manageDropStudentButton.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					manageDropStudentButton.setImage("images/SchoolTeacherUI/xueji change normal.png");
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					manageDropStudentButton.setImage("images/SchoolTeacherUI/xueji change pressed.png");
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					manageDropStudentButton.setImage("images/SchoolTeacherUI/xueji change.png");
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					manageDropStudentButton.setImage("images/SchoolTeacherUI/xueji change mouse_over.png");
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					
					try {
//						  dropStudentList=stub.getDropStudents();
						  dropStudentList=teacherController.getDropStudents();
						  studentTable=new MyTable(dropStudentList,columnNameForDropStudent);
						  showPanel.removeAll();
						  showPanel.setLayout(new BorderLayout());
						  showPanel.add(new JScrollPane(studentTable));
						  showPanel.revalidate();
						  showPanel.repaint();
						} catch (RemoteException e1) {
						
						e1.printStackTrace();
					}	
				}
			});
			 manageDropStudentButton.setBounds(550,100,200,200);
			 manageDropStudentButton.setOpaque(false);
			 studentViewPane.add(manageDropStudentButton);
			 /*
			  *  is achieved in string way
			  */
			 tabPane.addTab("���������ܲ���",stragetyPane);
			 tabPane.addTab("�����ѧ��Ϣ",teachInformationPane);
			 tabPane.addTab("�����ʦ",teacherViewPane);
			 tabPane.addTab("����ѧ��",studentViewPane);
			 tabPane.addTab("����γ�",courseViewPane);
			 tabPane.setSelectedIndex(0);
			/*
			 * ��tabPane��Ӽ���
			 */
			 tabPane.addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
				
				    showPanel.removeAll();
				    showPanel.add(showLabel);
				}
			});
			/*
			 * ���齨��Լ����
			 */
			 constraint1=new GridBagConstraints();
			 constraint1.fill=GridBagConstraints.BOTH;
			 constraint1.weighty=5.0;
			 constraint1.gridx=0;
			 constraint1.gridy=1;
          
			 mainPanel.add(tabPane);
			 constraint2=new GridBagConstraints();
			 constraint2.fill=GridBagConstraints.BOTH;
			 constraint2.weighty=3.0;
			 constraint2.gridx=0;
			 constraint2.gridy=2;
			 /*
			  * ������ʾ����panel
			  */
			 showPanel=new JPanel();
			 showPanel.setBounds(0,350,(int)(width*1.1),((int)(height/2)));
			
			 Font front=new Font("���Ĳ���",Font.BOLD,30);
			
         
			 showLabel=new JLabel("WELCOME! ����ʦ",JLabel.CENTER);
		  	 showLabel.setFont(front);
		  	 //showLabel.setBounds(100,100,100,100);
		  	 showPanel.add(showLabel);
		  
			/*
			 * ����IdPanel����ʾ
			 */

		  	 idPanel =new MyPanel("nav bar.png");
		  	 idPanel.setBounds(0,0,(int)(width*1.1),30);
		  	 idPanel.setLayout(null);
		  	 constraint3=new GridBagConstraints();
		  	 constraint3.fill=GridBagConstraints.BOTH;
		  	 constraint3.fill=GridBagConstraints.BOTH;
		  	 constraint3.weighty=0.5;
		  	 constraint3.gridx=0;
		  	 constraint3.gridy=0;
			/*
			 * ���õǳ���ť
			 */
		  	 loginoutButton=new MyPanel("images/StudentUI/setting.png");
		  	 loginoutButton.setOpaque(false);
		  	 loginoutButton.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
				
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
				
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
				
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
				
					int result=JOptionPane.showConfirmDialog(frame,"�Ƿ�ȷ���ǳ�");
					if(result==JOptionPane.YES_OPTION)
					{   try {
						loginController.logout(teacherId);
						frame.dispose();
					} catch (RemoteException e1) {
						
						e1.printStackTrace();
					}
					}
				}
			});
			loginoutButton.setBounds(700,0,40,40);
			idPanel.add(loginoutButton);
			mainPanel.add(idPanel);
			mainPanel.add(showPanel);
			frame.add(mainPanel);
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
       }
}	