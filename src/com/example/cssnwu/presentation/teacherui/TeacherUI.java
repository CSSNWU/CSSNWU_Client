package com.example.cssnwu.presentation.teacherui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Arc2D;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.cssnwu.businesslogic.controller.CourseController;
import com.example.cssnwu.businesslogic.controller.LoginController;
import com.example.cssnwu.businesslogic.controller.TeacherController;
//import com.example.cssnwu.presentation.courseui.courseUI;
import com.example.cssnwu.businesslogic.domain.Student;
import com.example.cssnwu.presentation.loginui.LoginUI;
import com.example.cssnwu.presentation.studentUI.MyPanel;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.StudentVO;

/**
 * teacher user interface frame
 * <p/>
 * Created by albuszheng on 12/13/13.
 */
public class TeacherUI implements ActionListener {
    CourseController courseController;
    TeacherController teacherController;
    LoginController loginController;
    CourseVO courseVO;

    JFrame teacherFrame;
    MyPanel mainPanel;
    JPanel navBarPanel;
    JPanel infoBarPanel;

    MyButton navHome;
    MyButton navMyCourse;
    MyButton iconMyCourse;
    MyButton navSetting;

    JLabel navTitle;
    JLabel navProfilePic;
    JLabel navUsername;
    JLabel infoBarWelcome;
    JLabel infoBarName;

    JPanel separator;

    String userName;
    int id;
    int[] scores;
    ArrayList<StudentVO> studentList=new ArrayList<StudentVO>();

    /**
     * constructor of the frame
     * complete the default home page of teacher user interface frame
     *
     * @param id
     */
    public TeacherUI(int id) {
        teacherFrame = new JFrame("Teacher");
        int width = 815;
        int height = 637;
        teacherFrame.setSize(width, height);
        teacherFrame.setLayout(null);
        teacherFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.id = id;

/*
make connection to the server to do further jobs
 */
        try {
            teacherController = new TeacherController();
            courseController = new CourseController();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        mainPanel = new MyPanel("images/TeacherUI/background.jpg");
        mainPanel.setLayout(null);
        mainPanel.setSize(width, height);
        mainPanel.setVisible(true);
        mainPanel.setLocation(0, 0);

        navBarPanel = new JPanel();
        int navHeight = 50;
        navBarPanel.setLayout(null);
        navBarPanel.setSize(width, navHeight);
        navBarPanel.setBackground(new Color(56, 90, 154));
        navBarPanel.setLocation(0, 0);
        navBarPanel.setVisible(true);

        navHome = new MyButton(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/home mouse_over.png"));
        navHome.setMouseoverIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/home mouse_over.png"));
        navHome.setPressedIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/home pressed.png"));
        navHome.setBackground(null);
        navHome.setLocation(213, 18);
        navHome.setSize(23, 32);
        navHome.setVisible(true);
        navHome.addActionListener(this);

        navMyCourse = new MyButton(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/mycourse.png"));
        navMyCourse.setMouseoverIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/mycourse mouse_over.png"));
        navMyCourse.setPressedIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/mycourse pressed.png"));
        navMyCourse.setBackground(null);
        navMyCourse.setLocation(262, 18);
        navMyCourse.setSize(64, 30);
        navMyCourse.setVisible(true);
        navMyCourse.addActionListener(this);

        navTitle = new JLabel();
        navTitle.setIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/NUWEAS.png"));
        navTitle.setBackground(new Color(56, 90, 154));
        navTitle.setSize(155, 19);
        navTitle.setLocation(15, 15);

        navProfilePic = new JLabel();
        navProfilePic.setIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/profile.png"));
        navProfilePic.setBackground(new Color(56, 90, 154));
        navProfilePic.setSize(22, 22);
        navProfilePic.setLocation(760, 16);

        navSetting = new MyButton(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/setting.png"), new ImageIcon("images/TeacherUI/setting.png"));
        navSetting.setBackground(new Color(56, 90, 154));
        navSetting.setLocation(670, 18);
        navSetting.setSize(22, 22);
        navSetting.addActionListener(this);

        navUsername = new JLabel(userName);
        navUsername.setBackground(new Color(56, 90, 154));
        navUsername.setLocation(690, 18);

        navBarPanel.add(navTitle);
        navBarPanel.add(navHome);
        navBarPanel.add(navMyCourse);
        navBarPanel.add(navSetting);
        navBarPanel.add(navUsername);
        navBarPanel.add(navProfilePic);
        navBarPanel.repaint();

        separator = new JPanel();
        separator.setBackground(new Color(193, 192, 192));
        separator.setSize(800, 2);
        separator.setLocation(0, 399);

        infoBarPanel = new JPanel();
        infoBarPanel.setBackground(new Color(255, 255, 255));
        infoBarPanel.setLocation(0, 400);
        infoBarPanel.setSize(800, 200);
        infoBarPanel.setLayout(null);

        infoBarName = new JLabel(userName);
        infoBarName.setLocation(428, 28);
        infoBarName.setBackground(new Color(255, 255, 255));

        infoBarWelcome = new JLabel(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/welcome.png"));
        infoBarWelcome.setSize(155, 28);
        infoBarWelcome.setBackground(new Color(255, 255, 255));

        infoBarPanel.add(infoBarWelcome);
        infoBarPanel.add(infoBarName);
        infoBarName.repaint();

        iconMyCourse = new MyButton(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/icon mycourse.png"));
        iconMyCourse.setMouseoverIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/icon mycourse mouse_over.png"));
        iconMyCourse.setPressedIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/icon mycourse pressed.png"));
        iconMyCourse.setLocation(74, 143);
        iconMyCourse.setSize(103, 176);
        iconMyCourse.addActionListener(this);

        mainPanel.add(navBarPanel);
        mainPanel.add(iconMyCourse);
        mainPanel.add(separator);
        mainPanel.add(infoBarPanel);
        mainPanel.repaint();

        teacherFrame.add(mainPanel);
        teacherFrame.repaint();
        teacherFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == iconMyCourse || e.getSource() == navMyCourse) {
            /*
            jump to the course management page of the frame, but should first choose the course id to determine
            the target course.
            teacher cannot edit most of the course info because those are department teacher's job to do, but
            teacher can edit course information and also register student's grates.
             */
            try {
                String tarCourseId = JOptionPane.showInputDialog(mainPanel, "请输入目标课程ID");
                courseVO = courseController.getCourseById(Integer.parseInt(tarCourseId));
                if (courseVO == null) {
                    JOptionPane.showMessageDialog(mainPanel, "对不起，未找到该课程。请重新选择。");
                } else {


                    navMyCourse.setIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/mycourse mouse_over.png"));
                    navHome.setIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/home normal.png"));
                    navBarPanel.repaint();

                    mainPanel.removeAll();
                    mainPanel.add(navBarPanel);
                    mainPanel.repaint();

                    final JLabel courseIDLabel = new JLabel(Integer.toString(courseVO.id));
                    JLabel courseNameLabel = new JLabel(courseVO.courseName);
                    JLabel courseTypeLabel = new JLabel(courseVO.courseType.toString());
                    final JTextArea courseInfoTextField = new JTextArea(courseVO.courseIntro);
                    String[] tempTime = courseVO.courseTime.split("/");
                    JLabel courseTimeLabel = new JLabel(tempTime[0] + "  " + tempTime[1] + "节");
                    String[] tempLoc = courseVO.courseLocation.split("/");
                    JLabel courseLocationLabel = new JLabel(tempLoc[0] + "  " + tempLoc[1]);
                    JLabel courseCredit = new JLabel(Double.toString(courseVO.credit));

                    JButton submitButton = new JButton(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/button submit normal.png"));
                    submitButton.setPressedIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/button submit.png"));
                    submitButton.setContentAreaFilled(false);
                    submitButton.setBorderPainted(false);
                    submitButton.setSize(174, 38);
                    submitButton.setLocation(17, 548);
                    submitButton.setFocusPainted(false);
                    /*
                    do the communication to finish management
                     */
                    submitButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            courseVO.courseIntro = courseInfoTextField.getText();
                            try {
                                teacherController.updateCourseInfo(courseVO);
                            } catch (RemoteException ex) {
                                JOptionPane.showMessageDialog(mainPanel, "网络通信错误！", "warning!!", JOptionPane.ERROR_MESSAGE);
                                ex.printStackTrace();
                            }
                        }
                    });

                    /*
                    jump to the score input page
                     */
                    JButton registerScores = new JButton(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/register score normal.png"));
                    registerScores.setPressedIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/register score.png"));
                    registerScores.setContentAreaFilled(true);
                    registerScores.setBackground(new Color(56, 90, 154));
                    registerScores.setBorderPainted(false);
                    registerScores.setSize(174, 38);
                    registerScores.setLocation(224, 548);
                    registerScores.setFocusPainted(false);
                    registerScores.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            mainPanel.removeAll();
                            mainPanel.add(navBarPanel);
                            mainPanel.repaint();

                            studentList=new ArrayList<StudentVO>();

//                            try {
//                                studentList = courseController.getStuByCourseId(Integer.parseInt(courseIDLabel.getText()));
//                            } catch (RemoteException e1) {
//                                e1.printStackTrace();
//                                studentList = null;
//                            }
//
//                            if (studentList != null) {
//                                Object[][] tableContain=new Object[studentList.size()][2];
//
//                                String[] columnNames={"学生","成绩"};
//
//                                //initialize the table data for register scores
//                                for (int i=0;i<studentList.size();i++){
//                                    tableContain[i][0]=studentList.get(i).userName;
//                                    tableContain[i][1]=0+"";
//                                }
//
//                                JScrollPane scrollPane=new JScrollPane();
//                                scrollPane.createVerticalScrollBar();
//
//                                final JTable scoreTable=new JTable(tableContain,columnNames);
//                                scoreTable.setBackground(new Color(242,242,242));
//                                scoreTable.setFont(new Font("Microsoft YaHei UI",0,14));
//                                scoreTable.setSize(382,418);
//                                scoreTable.setVisible(true);
//
//                                scrollPane.add(scoreTable);
//                                scrollPane.setSize(382,481);
//                                scrollPane.setLocation(18,110);
//                                scrollPane.setVisible(true);
                            JLabel studentIDLabel=new JLabel("学生学号");
                            final JTextField studentIDTextField=new JTextField();
                            JLabel scoreLabel=new JLabel("成绩");
                            final JTextField scoreTextField=new JTextField();

                            studentIDLabel.setFont(new Font("Microsoft YaHei UI",0,19));
                            studentIDLabel.setSize(154,25);
                            studentIDLabel.setLocation(18,110);
                            studentIDTextField.setSize(154,25);
                            studentIDTextField.setLocation(204,110);
                            studentIDTextField.setFont(new Font("Microsoft YaHei UI",0,14));

                            scoreLabel.setFont(new Font("Microsoft YaHei UI",0,19));
                            scoreLabel.setSize(77,25);
                            scoreLabel.setLocation(18,180);
                            scoreTextField.setFont(new Font("Microsoft YaHei UI",0,14));
                            scoreTextField.setSize(154,25);
                            scoreTextField.setLocation(204,180);

                                JButton submitButtonScore = new JButton(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/button submit normal.png"));
                                submitButtonScore.setPressedIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/button submit.png"));
                                submitButtonScore.setContentAreaFilled(false);
                                submitButtonScore.setBorderPainted(false);
                                submitButtonScore.setSize(174, 38);
                                submitButtonScore.setLocation(17, 548);
                                submitButtonScore.setFocusPainted(false);
                                submitButtonScore.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
//                                        scores=new int[studentList.size()];
//
//                                        //transfer data to the server
//                                        try{
//                                            for(int i=0;i<studentList.size();i++){
//                                                Integer id=studentList.get(i).id;
//                                                HashMap<Integer,Double> map=new HashMap<Integer, Double>();
//                                                map.put(id,(Double)scoreTable.getValueAt(i,1));
//                                                teacherController.registerScore(Integer.parseInt(courseIDLabel.getText()),map);
//                                            }
//                                        }catch (RemoteException re){
//                                            JOptionPane.showInternalConfirmDialog(mainPanel, "网络通信错误", "Warning!!", JOptionPane.OK_CANCEL_OPTION);
//                                            re.printStackTrace();
//                                        }
                                        for (int i=0;i<studentList.size();i++){}
                                        Integer studentID = Integer.parseInt(studentIDTextField.getText());
                                        double score = Double.parseDouble(scoreTextField.getText());
                                        try {
                                            HashMap<Integer, Double> map = new HashMap<Integer, Double>();
                                            map.put(studentID, score);
//                                        teacherController.registerScore(Integer.parseInt(courseIDLabel.getText()),new HashMap<Integer, Double>(studentID,(float)score));
                                            System.out.print(teacherController.registerScore(Integer.parseInt(courseIDLabel.getText()), map));
                                        } catch (RemoteException re) {
                                            re.printStackTrace();
                                        }
                                    }
                                });
//
                                mainPanel.add(submitButtonScore);
//                                mainPanel.add(scrollPane);
//                                mainPanel.repaint();
                                mainPanel.add(scoreLabel);
                                mainPanel.add(scoreTextField);
                                mainPanel.add(studentIDLabel);
                                mainPanel.add(studentIDTextField);
                            }
//                        }
                    });


                    courseNameLabel.setLocation(18, 115);
                    courseNameLabel.setSize(154, 25);
                    courseNameLabel.setFont(new Font("Microsoft YaHei UI", 0, 19));

                    courseIDLabel.setLocation(180, 115);
                    courseIDLabel.setSize(154, 25);
                    courseIDLabel.setFont(new Font("Microsoft YaHei UI", 0, 19));

                    courseTimeLabel.setLocation(18, 162);
                    courseTimeLabel.setSize(154, 25);
                    courseTimeLabel.setFont(new Font("Microsoft YaHei UI", 0, 19));

                    courseLocationLabel.setLocation(321, 162);
                    courseLocationLabel.setSize(154, 25);
                    courseLocationLabel.setFont(new Font("Microsoft YaHei UI", 0, 19));

                    courseCredit.setLocation(18, 212);
                    courseCredit.setSize(154, 25);
                    courseCredit.setFont(new Font("Microsoft YaHei UI", 0, 19));

                    courseTypeLabel.setLocation(18, 272);
                    courseTypeLabel.setSize(154, 25);
                    courseTypeLabel.setFont(new Font("Microsoft YaHei UI", 0, 19));

                    courseInfoTextField.setLocation(18, 332);
                    courseInfoTextField.setSize(607, 180);
                    courseInfoTextField.setFont(new Font("Microsoft YaHei UI", 0, 19));

                    mainPanel.add(courseNameLabel);
                    mainPanel.add(courseIDLabel);
                    mainPanel.add(courseTimeLabel);
                    mainPanel.add(courseLocationLabel);
                    mainPanel.add(courseCredit);
                    mainPanel.add(courseTypeLabel);
                    mainPanel.add(courseInfoTextField);
                    mainPanel.add(submitButton);
                    mainPanel.add(registerScores);
                    mainPanel.repaint();

                    mainPanel.repaint();
                }
            } catch (RemoteException ex) {
                JOptionPane.showInternalConfirmDialog(mainPanel, "网络通信错误", "Warning!!", JOptionPane.OK_CANCEL_OPTION);
                ex.printStackTrace();
            }
        } else if (e.getSource() == navHome) {
            /*
            jump back to the home page
             */
            mainPanel.removeAll();

            navMyCourse.setIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/mycourse.png"));
            navHome.setIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/home mouse_over.png"));
            navBarPanel.repaint();

            mainPanel.add(navBarPanel);
            mainPanel.add(infoBarPanel);
            mainPanel.add(iconMyCourse);
            mainPanel.repaint();
        } else if (e.getSource() == navSetting) {
            /*
            logout
            jump back to login page
             */
            try {
                loginController = new LoginController();
                loginController.logout(id);
                new LoginUI();
                teacherFrame.dispose();
            } catch (RemoteException re) {
                JOptionPane.showMessageDialog(mainPanel, "网络通信错误！", "Warning!!", JOptionPane.ERROR_MESSAGE);
                re.printStackTrace();
            }
        }
    }

}