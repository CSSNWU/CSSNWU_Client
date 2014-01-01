package com.example.cssnwu.presentation.deptteacherui;

import com.example.cssnwu.businesslogic.controller.CourseController;
import com.example.cssnwu.businesslogic.controller.DeptTeacherController;
import com.example.cssnwu.businesslogic.controller.LoginController;
import com.example.cssnwu.businesslogic.domain.User;
import com.example.cssnwu.businesslogicservice.resultenum.CourseType;
import com.example.cssnwu.presentation.loginui.LoginUI;
import com.example.cssnwu.presentation.studentUI.MyPanel;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.DepartmentPlanVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * User interface frame of department teacher, completing all activities of the department teacher
 * Created by albuszheng on 11/22/13.
 */
public class DeptTeacherUI implements ActionListener {
    DeptTeacherController deptTeacherController;
    CourseController courseController;
    LoginController loginController;

    JFrame deptTeacherFrame;
    MyPanel mainPanel;
    JPanel navBarPanel;
    JPanel secondaryNavBarPanel;
    JPanel infoBarPanel;

    MyButton navHome;
    MyButton navAnnounceCourse;
    MyButton navModifyCourse;
    MyButton navTeachingPlan;
    MyButton navSetting;

    JLabel navTitle;
    JLabel navProfilePic;
    JLabel navUsername;
    JLabel infoBarWelcome;
    JLabel infoBarName;

    MyButton iconAnnounceCourse;
    MyButton iconModifyCourse;
    MyButton iconTeachingPlan;

    JPanel separator;

    String userName;
    int userId;

    /**
     * The constructor of the class, complete the default home page of department teacher's user interface
     *
     * @param id
     */
    public DeptTeacherUI(int id) {
        this.userId = id;

        deptTeacherFrame = new JFrame("Teacher");
        int width = 815;
        int height = 637;
        deptTeacherFrame.setSize(width, height);
        deptTeacherFrame.setLayout(null);

        try {
            deptTeacherController = new DeptTeacherController();
            courseController = new CourseController();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        /*
        main container of all possible components
         */
        mainPanel = new MyPanel("images/DeptTeacherUI/background.jpg");
        mainPanel.setLayout(null);
        mainPanel.setSize(width, height);
        mainPanel.setVisible(true);
        mainPanel.setLocation(0, 0);

        navBarPanel = new JPanel();
        int navHeight = 50;
        navBarPanel.setLayout(null);
        navBarPanel.setVisible(true);
        navBarPanel.setSize(width, navHeight);
        navBarPanel.setBackground(new Color(56, 90, 154));
        navBarPanel.setLocation(0, 0);

        navHome = new MyButton(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/home mouse_over.png"));
        navHome.setMouseoverIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/home mouse_over.png"));
        navHome.setPressedIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/home pressed.png"));
        navHome.setBackground(null);
        navHome.setLocation(213, 18);
        navHome.setSize(23, 32);
        navHome.setVisible(true);
        navHome.addActionListener(this);

        navAnnounceCourse = new MyButton(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/announce course.png"));
        navAnnounceCourse.setMouseoverIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/announce course mouse_over.png"));
        navAnnounceCourse.setPressedIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/announce course pressed.png"));
        navAnnounceCourse.setLocation(262, 18);
        navAnnounceCourse.setSize(65, 31);
        navAnnounceCourse.setVisible(true);
        navAnnounceCourse.addActionListener(this);

        navModifyCourse = new MyButton(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/modify course.png"));
        navModifyCourse.setMouseoverIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacher/modify course mouse_over.png"));
        navModifyCourse.setPressedIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/modify course pressed.png"));
        navModifyCourse.setLocation(351, 18);
        navModifyCourse.setSize(65, 31);
        navModifyCourse.setVisible(true);
        navModifyCourse.addActionListener(this);

        navTeachingPlan = new MyButton(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/teaching plan.png"));
        navTeachingPlan.setMouseoverIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/teaching plan mouse_over.png"));
        navTeachingPlan.setPressedIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/teaching plan pressed.png"));
        navTeachingPlan.setLocation(440, 18);
        navTeachingPlan.setSize(65, 31);
        navTeachingPlan.setVisible(true);
        navTeachingPlan.addActionListener(this);

        navTitle = new JLabel();
        navTitle.setIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/NUWEAS.png"));
        navTitle.setBackground(new Color(56, 90, 154));
        navTitle.setSize(155, 19);
        navTitle.setVisible(true);
        navTitle.setLocation(15, 15);

        navProfilePic = new JLabel();
        navProfilePic.setIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/profile.png"));
        navProfilePic.setBackground(new Color(56, 90, 154));
        navProfilePic.setSize(22, 22);
        navProfilePic.setVisible(true);
        navProfilePic.setLocation(760, 16);

        navSetting = new MyButton(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/setting.png"), new ImageIcon("images/TeacherUI/setting.png"));
        navSetting.setBackground(new Color(56, 90, 154));
//        navSetting.setIcon(new ImageIcon("image/TeacherUI/setting.png"));
        navSetting.setLocation(670, 18);
        navSetting.setSize(22, 22);
        navSetting.setVisible(true);
        navSetting.addActionListener(this);

        navUsername = new JLabel(userName);
        navUsername.setBackground(new Color(56, 90, 154));
        navUsername.setVisible(true);
        navUsername.setLocation(690, 18);

        navBarPanel.add(navTitle);
        navBarPanel.add(navHome);
        navBarPanel.add(navAnnounceCourse);
        navBarPanel.add(navModifyCourse);
        navBarPanel.add(navTeachingPlan);
        navBarPanel.add(navSetting);
        navBarPanel.add(navUsername);
        navBarPanel.add(navProfilePic);

        separator = new JPanel();
        separator.setBackground(new Color(193, 192, 192));
        separator.setSize(800, 2);
        separator.setVisible(true);
        separator.setLocation(0, 399);

        infoBarPanel = new JPanel();
        infoBarPanel.setBackground(new Color(255, 255, 255));
        infoBarPanel.setLocation(0, 400);
        infoBarPanel.setSize(800, 200);
        infoBarPanel.setVisible(true);
        infoBarPanel.setLayout(null);

        infoBarName = new JLabel(userName);
        infoBarName.setLocation(428, 28);
        infoBarName.setVisible(true);
        infoBarName.setBackground(new Color(255, 255, 255));

        infoBarWelcome = new JLabel(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/welcome.png"));
        infoBarWelcome.setSize(155, 28);
        infoBarWelcome.setVisible(true);
        infoBarWelcome.setBackground(new Color(255, 255, 255));

        infoBarPanel.add(infoBarWelcome);
        infoBarPanel.add(infoBarName);

        iconAnnounceCourse = new MyButton(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/icon announce course.png"));
        iconAnnounceCourse.setMouseoverIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/icon announce course mouse_over"));
        iconAnnounceCourse.setPressedIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/icon announce course pressed"));
        iconAnnounceCourse.setLocation(73, 148);
        iconAnnounceCourse.setSize(102, 171);
        iconAnnounceCourse.setVisible(true);
        iconAnnounceCourse.setFocusPainted(false);
        iconAnnounceCourse.addActionListener(this);

        iconModifyCourse = new MyButton(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/icon modify course.png"));
        iconModifyCourse.setMouseoverIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/icon modify course mouse_over.png"));
        iconModifyCourse.setPressedIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/icon modify course pressed.png"));
        iconModifyCourse.setLocation(237, 148);
        iconModifyCourse.setSize(102, 171);
        iconModifyCourse.setVisible(true);
        iconModifyCourse.addActionListener(this);

        iconTeachingPlan = new MyButton(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/icon teaching plan.png"));
        iconTeachingPlan.setMouseoverIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/icon teaching plan mouse_over.png"));
        iconTeachingPlan.setPressedIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/icon teacher plan pressed"));
        iconTeachingPlan.setLocation(397, 148);
        iconTeachingPlan.setSize(102, 171);
        iconTeachingPlan.setVisible(true);
        iconTeachingPlan.addActionListener(this);

        mainPanel.add(iconAnnounceCourse);
        mainPanel.add(iconModifyCourse);
        mainPanel.add(iconTeachingPlan);
        mainPanel.add(infoBarPanel);
        mainPanel.add(separator);
        mainPanel.add(navBarPanel);
        mainPanel.repaint();

        secondaryNavBarPanel = new JPanel();
        secondaryNavBarPanel.setBackground(new Color(242, 242, 242));
        secondaryNavBarPanel.setLocation(0, 50);
        secondaryNavBarPanel.setSize(800, 40);

        deptTeacherFrame.add(mainPanel);
        deptTeacherFrame.setVisible(true);
        deptTeacherFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        deptTeacherFrame.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
        back to home page
         */
        if (e.getSource() == navHome) {
            mainPanel.removeAll();
            mainPanel.add(navBarPanel);
            mainPanel.add(iconTeachingPlan);
            mainPanel.add(iconModifyCourse);
            mainPanel.add(iconAnnounceCourse);
            mainPanel.add(infoBarPanel);
            mainPanel.add(separator);
            mainPanel.repaint();
        } else {
        /*
         jump to the page of announcing new course
         */
            if (e.getSource() == navAnnounceCourse || e.getSource() == iconAnnounceCourse) {
                mainPanel.removeAll();
                mainPanel.add(navBarPanel);

                navHome.setIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/home normal.png"));
                navModifyCourse.setIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/modify course.png"));
                navTeachingPlan.setIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/teaching plan.png"));
                navAnnounceCourse.setIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/announce course mouse_over.png"));
                navBarPanel.repaint();
                mainPanel.repaint();

                final JTextField courseID=new JTextField("请输入课程号");
                courseID.setColumns(10);
                courseID.setFont(new Font("Microsoft YaHei UI",0,14));
                courseID.setLocation(17,155);
                courseID.setSize(154,25);

                final JTextField courseName = new JTextField("请输入课程名称");
                courseName.setColumns(10);
                courseName.setFont(new Font("Microsoft YaHei UI", 0, 14));
                courseName.setLocation(224, 115);
                courseName.setSize(154, 22);
                courseName.setVisible(true);

                final JTextField courseDept = new JTextField("开课院系");
                courseDept.setColumns(10);
                courseDept.setVisible(true);
                courseDept.setFont(new Font("Microsoft YaHei UI", 0, 14));
                courseDept.setLocation(17, 162);
                courseDept.setSize(154, 22);

                final JTextField courseTimeWeek = new JTextField("上课时间（周几）");
                courseTimeWeek.setColumns(10);
                courseTimeWeek.setVisible(true);
                courseTimeWeek.setFont(new Font("Microsoft YaHei UI", 0, 14));
                courseTimeWeek.setLocation(17, 212);
                courseTimeWeek.setSize(154, 22);

                JLabel courseTimeDi = new JLabel("第");
                JLabel courseTimeZhi = new JLabel("至");
                JLabel courseTimeJie = new JLabel("节");
                final JTextField courseTimeStart = new JTextField(3);
                final JTextField courseTimeEnd = new JTextField(3);
                courseTimeDi.setLocation(244, 212);
                courseTimeDi.setSize(20, 22);
                courseTimeDi.setVisible(true);
                courseTimeZhi.setLocation(294, 212);
                courseTimeZhi.setSize(20, 22);
                courseTimeZhi.setVisible(true);
                courseTimeJie.setLocation(344, 212);
                courseTimeJie.setSize(20, 22);
                courseTimeJie.setVisible(true);
                courseTimeStart.setLocation(264, 212);
                courseTimeStart.setSize(20, 22);
                courseTimeStart.setVisible(true);
                courseTimeEnd.setLocation(314, 212);
                courseTimeEnd.setSize(20, 22);
                courseTimeEnd.setVisible(true);
                courseTimeDi.setFont(new Font("Microsoft YaHei UI", 0, 19));
                courseTimeZhi.setFont(new Font("Microsoft YaHei UI", 0, 19));
                courseTimeJie.setFont(new Font("Microsoft YaHei UI", 0, 19));
                courseTimeStart.setFont(new Font("Microsoft YaHei UI", 0, 14));
                courseTimeStart.setFont(new Font("Microsoft YaHei UI", 0, 14));

                final JTextField courseLoc = new JTextField("上课地点");
                courseLoc.setFont(new Font("Microsoft YaHei UI", 0, 14));
                courseLoc.setColumns(10);
                courseLoc.setVisible(true);
                courseLoc.setSize(154, 22);
                courseLoc.setLocation(472, 212);

                final JTextField establishTime = new JTextField("开课时间");
                establishTime.setFont(new Font("Microsoft YaHei UI", 0, 14));
                establishTime.setLocation(17, 260);
                establishTime.setColumns(10);
                establishTime.setSize(154, 22);
                establishTime.setVisible(true);

                final JTextField courseCredit = new JTextField("学分");
                courseCredit.setFont(new Font("Microsoft YaHei UI", 0, 14));
                courseCredit.setColumns(10);
                courseCredit.setVisible(true);
                courseCredit.setSize(154, 22);
                courseCredit.setLocation(17, 310);

                final JList<CourseType> courseTypeJList = new JList<CourseType>();
                CourseType[] types = new CourseType[2];
                types[0] = CourseType.指选课;
                types[1] = CourseType.公选课;
                courseTypeJList.setListData(types);
                courseTypeJList.setVisible(true);
                courseTypeJList.setFont(new Font("Microsoft YaHei UI", 0, 14));
                courseTypeJList.setLocation(17, 367);
                courseTypeJList.setToolTipText("请选择课程类型");
                courseTypeJList.setDropMode(DropMode.USE_SELECTION);
                courseTypeJList.setVisible(true);
                courseTypeJList.setSize(154, 44);

                final String[] tempId = new String[1];

                JButton addTeacher = new JButton("添加任课老师");
                addTeacher.setFont(new Font("Microsoft YaHei UI", 0, 19));
                addTeacher.setFocusPainted(true);
                addTeacher.setBorderPainted(false);
                addTeacher.setContentAreaFilled(false);
                addTeacher.setVisible(true);
                addTeacher.setSize(154, 23);
                addTeacher.setLocation(17, 424);
                addTeacher.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String temp = JOptionPane.showInputDialog("如有多名任课老师请将ID用\"/\"分开：");
                        tempId[0] = temp;
                    }
                });

                JButton submitButton = new JButton(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/button submit normal.png"));
                submitButton.setPressedIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/button submit.png"));
                submitButton.setContentAreaFilled(false);
                submitButton.setBorderPainted(false);
                submitButton.setFocusPainted(false);
                submitButton.setSize(174, 38);
                submitButton.setLocation(17, 548);
                submitButton.setVisible(true);
                submitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CourseVO newCourse = new CourseVO();
                        newCourse.id=Integer.parseInt(courseID.getText());
                        newCourse.courseName = courseName.getText();
                        newCourse.courseType = courseTypeJList.getSelectedValue();
                        newCourse.courseLocation = courseLoc.getText();
                        newCourse.credit = Integer.parseInt(courseCredit.getText());
                        newCourse.courseTime = courseTimeWeek.getText() + "/" + courseTimeStart.getText() + "~" + courseTimeEnd.getText();
                        newCourse.establishTime = establishTime.getText();
                        String[] temp = tempId[0].split("/");
                        //the process of teachers who will teach the course
                        ArrayList<Integer> courseTeacherIDs = new ArrayList<Integer>();
                        ArrayList<String> courseTeacherNames = new ArrayList<String>();
                        for (String s : temp) {
                            Integer id = Integer.parseInt(s);
                            String name = null;
                            try {
                                User tempUser = new User();
                                name = tempUser.findName(id);
                            } catch (RemoteException ex) {
                                JOptionPane.showMessageDialog(null, "网络通信错误！", "Warning!!", JOptionPane.ERROR_MESSAGE);
                                ex.printStackTrace();
                            }
                            courseTeacherIDs.add(id);
                            courseTeacherNames.add(name);
                        }
                        try {
                            deptTeacherController.releaseCourse(newCourse);
                        } catch (RemoteException ex) {
                            JOptionPane.showMessageDialog(null, "网络通信错误！", "Warning!!", JOptionPane.ERROR_MESSAGE);
                            ex.printStackTrace();
                        }
                    }
                });

                mainPanel.add(submitButton);
                mainPanel.add(courseName);
                mainPanel.add(courseCredit);
                mainPanel.add(courseDept);
                mainPanel.add(courseLoc);
                mainPanel.add(courseTimeDi);
                mainPanel.add(courseTimeEnd);
                mainPanel.add(courseTimeJie);
                mainPanel.add(courseTimeStart);
                mainPanel.add(courseTimeWeek);
                mainPanel.add(courseTimeZhi);
                mainPanel.add(courseTypeJList);
                mainPanel.add(addTeacher);
                mainPanel.repaint();

            } else if (e.getSource() == navModifyCourse || e.getSource() == iconModifyCourse) {
                /*
                jump to course modifying page
                the basic layout is similar to the announcing page
                but read the information already
                 */
                int tarId = Integer.parseInt(JOptionPane.showInputDialog(null, "请输入目标课程ID"));
                CourseVO tarCourse = null;
                try {
                    tarCourse = deptTeacherController.getCourse(tarId);
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(null, "网络通信错误！", "Warning!!", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }

                mainPanel.removeAll();
                mainPanel.add(navBarPanel);
                mainPanel.repaint();

                navHome.setIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/home normal.png"));
                navModifyCourse.setIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/modify course mouse_over.png"));
                navAnnounceCourse.setIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/announce course.png"));
                navTeachingPlan.setMouseoverIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/teaching plan.png"));
                navBarPanel.repaint();
                mainPanel.repaint();

                final JLabel courseID=new JLabel(tarCourse.id+" ");
                courseID.setFont(new Font("Microsoft YaHei UI",0,14));
                courseID.setLocation(17,155);
                courseID.setSize(154,25);

                final JTextField courseName = new JTextField(tarCourse.courseName);
                courseName.setColumns(10);
                courseName.setFont(new Font("Microsoft YaHei UI", 0, 14));
                courseName.setLocation(224, 115);
                courseName.setSize(154, 25);

                JTextField courseDept = new JTextField("开课院系");
                courseDept.setColumns(10);
                courseDept.setFont(new Font("Microsoft YaHei UI", 0, 14));
                courseDept.setLocation(17, 162);
                courseDept.setSize(154, 25);

                String[] timeTemp = tarCourse.courseTime.split("/");
                final JTextField courseTimeWeek = new JTextField(timeTemp[0]);
                courseTimeWeek.setColumns(10);
                courseTimeWeek.setFont(new Font("Microsoft YaHei UI", 0, 14));
                courseTimeWeek.setLocation(17, 212);
                courseTimeWeek.setSize(154, 25);

                JLabel courseTimeDi = new JLabel("第");
                JLabel courseTimeZhi = new JLabel("至");
                JLabel courseTimeJie = new JLabel("节");
                final JTextField courseTimeStart = new JTextField(timeTemp[1].split("-")[0]);
                final JTextField courseTimeEnd = new JTextField(timeTemp[1].split("-")[1]);
                courseTimeDi.setLocation(244, 212);
                courseTimeDi.setSize(20, 22);
                courseTimeZhi.setLocation(294, 212);
                courseTimeZhi.setSize(20, 22);
                courseTimeJie.setLocation(344, 212);
                courseTimeJie.setSize(20, 22);
                courseTimeStart.setLocation(264, 212);
                courseTimeStart.setSize(20, 22);
                courseTimeEnd.setLocation(314, 212);
                courseTimeEnd.setSize(20, 22);
                courseTimeDi.setFont(new Font("Microsoft YaHei UI", 0, 19));
                courseTimeZhi.setFont(new Font("Microsoft YaHei UI", 0, 19));
                courseTimeJie.setFont(new Font("Microsoft YaHei UI", 0, 19));
                courseTimeStart.setFont(new Font("Microsoft YaHei UI", 0, 14));
                courseTimeStart.setFont(new Font("Microsoft YaHei UI", 0, 14));

                final JTextField courseLoc = new JTextField(tarCourse.courseLocation);
                courseLoc.setFont(new Font("Microsoft YaHei UI", 0, 14));
                courseLoc.setColumns(10);
                courseLoc.setSize(154, 25);
                courseLoc.setLocation(472, 212);

                final JTextField establishTime = new JTextField(tarCourse.establishTime);
                establishTime.setFont(new Font("Microsoft YaHei UI", 0, 14));
                establishTime.setLocation(17, 260);
                establishTime.setColumns(10);
                establishTime.setSize(154, 25);

                JLabel courseCreditLabel = new JLabel("学分：");
                courseCreditLabel.setFont(new Font("Microsoft YaHei UI", 0, 14));
                courseCreditLabel.setLocation(17,310);
                courseCreditLabel.setSize(154,25);

                final JTextField courseCredit = new JTextField(tarCourse.credit + "");
                courseCredit.setFont(new Font("Microsoft YaHei UI", 0, 14));
                courseCredit.setColumns(10);
                courseCredit.setSize(74, 25);
                courseCredit.setLocation(97, 310);

                final JList<CourseType> courseTypeJList = new JList<CourseType>();
                CourseType[] types = new CourseType[2];
                types[0] = CourseType.指选课;
                types[1] = CourseType.公选课;
                courseTypeJList.setListData(types);
                courseTypeJList.setFont(new Font("Microsoft YaHei UI", 0, 14));
                courseTypeJList.setLocation(17, 367);
                courseTypeJList.setToolTipText("请选择课程类型");
                courseTypeJList.setDropMode(DropMode.USE_SELECTION);
                courseTypeJList.setVisible(true);
                courseTypeJList.setSize(154, 44);

                final String[] tempId = new String[1];

                JButton addTeacher = new JButton("添加任课老师");
                addTeacher.setFont(new Font("Microsoft YaHei UI", 0, 19));
                addTeacher.setFocusPainted(true);
                addTeacher.setBorderPainted(false);
                addTeacher.setContentAreaFilled(false);
                addTeacher.setLocation(23, 424);
                addTeacher.setSize(154, 25);
                addTeacher.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String temp = JOptionPane.showInputDialog("如有多名任课老师请将ID用\"/\"分开：");
                        tempId[0] = temp;
                    }
                });

                JButton submitButton = new JButton(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/button submit normal.png"));
                submitButton.setPressedIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/button submit.png"));
                submitButton.setContentAreaFilled(false);
                submitButton.setBorderPainted(false);
                submitButton.setFocusPainted(false);
                submitButton.setLocation(17, 548);
                submitButton.setSize(174, 38);
                submitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CourseVO newCourse = new CourseVO();
                        newCourse.courseName = courseName.getText();
                        newCourse.courseType = courseTypeJList.getSelectedValue();
                        newCourse.courseLocation = courseLoc.getText();
                        newCourse.credit = Integer.parseInt(courseCredit.getText());
                        String time = courseTimeWeek.getText() + "/" + courseTimeStart.getText() + "-" + courseTimeEnd.getText();
                        newCourse.courseTime = time;
                        newCourse.establishTime = establishTime.getText();
                        String[] temp = tempId[0].split("/");
                        ArrayList<Integer> courseTeacherIDs = new ArrayList<Integer>();
                        ArrayList<String> courseTeacherNames = new ArrayList<String>();
                        for (String s : temp) {
                            Integer id = Integer.parseInt(s);
                            String name = null;
                            try {
                                User tempUser = new User();
                                name = tempUser.findName(id);
                            } catch (RemoteException ex) {
                                JOptionPane.showMessageDialog(null, "网络通信错误！", "Warning!!", JOptionPane.ERROR_MESSAGE);
                                ex.printStackTrace();
                            }
                            courseTeacherIDs.add(id);
                            courseTeacherNames.add(name);
                        }
                        try {
                            JOptionPane.showMessageDialog(null, deptTeacherController.releaseCourse(newCourse).toString());
                        } catch (RemoteException ex) {
                            JOptionPane.showMessageDialog(null, "网络通信错误！", "Warning!!", JOptionPane.ERROR_MESSAGE);
                            ex.printStackTrace();
                        }
                    }
                });

                mainPanel.add(submitButton);
                mainPanel.add(courseName);
                mainPanel.add(courseCredit);
                mainPanel.add(courseDept);
                mainPanel.add(courseLoc);
                mainPanel.add(courseTimeDi);
                mainPanel.add(courseTimeEnd);
                mainPanel.add(courseTimeJie);
                mainPanel.add(courseTimeStart);
                mainPanel.add(courseTimeWeek);
                mainPanel.add(courseTimeZhi);
                mainPanel.add(courseTypeJList);
                mainPanel.add(addTeacher);
                mainPanel.add(courseCreditLabel);
                mainPanel.repaint();

            } else if (e.getSource() == navTeachingPlan || e.getSource() == iconTeachingPlan) {
                /*
                jump to the page of submitting teaching plan of the department
                 */
                mainPanel.removeAll();
                mainPanel.add(navBarPanel);
                mainPanel.repaint();

                navHome.setIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/home normal.png"));
                navTeachingPlan.setIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/teaching plan mouse_over.png"));
                navAnnounceCourse.setIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/announce course.png"));
                navModifyCourse.setIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/DeptTeacherUI/modify course.png"));
                navBarPanel.repaint();

                JTextField deptName = new JTextField("开课院系");
                deptName.setFont(new Font("Microsoft YaHei UI", 0, 14));
                deptName.setColumns(10);
                deptName.setSize(154, 25);
                deptName.setLocation(17, 61);

                JTextArea teachingPlan = new JTextArea();
                teachingPlan.setColumns(20);
                teachingPlan.setRows(15);
                teachingPlan.setSize(690, 320);
                teachingPlan.setLocation(17, 110);
                teachingPlan.setFont(new Font("Microsoft YaHei UI", 0, 14));
                JScrollPane scrollPane = new JScrollPane(teachingPlan);
                scrollPane.setLocation(17, 110);

                JLabel firstTerm = new JLabel("第一学年");
                firstTerm.setFont(new Font("Microsoft YaHei UI", 0, 14));
                firstTerm.setLocation(17, 450);
                firstTerm.setSize(65, 22);
                JLabel secondTerm = new JLabel("第二学年");
                secondTerm.setFont(new Font("Microsoft YaHei UI", 0, 14));
                secondTerm.setLocation(400, 450);
                secondTerm.setSize(65, 22);
                JLabel thirdTerm = new JLabel("第三学年");
                thirdTerm.setFont(new Font("Microsoft YaHei UI", 0, 14));
                thirdTerm.setLocation(17, 500);
                thirdTerm.setSize(65, 22);
                JLabel fourthTerm = new JLabel("第四学年");
                fourthTerm.setFont(new Font("Microsoft YaHei UI", 0, 14));
                fourthTerm.setLocation(400, 500);
                fourthTerm.setSize(65, 22);

                final JTextField firstCredit = new JTextField(5);
                firstCredit.setFont(new Font("Microsoft YaHei UI", 0, 14));
                firstCredit.setLocation(150, 450);
                firstCredit.setSize(154, 22);
                final JTextField secondCredit = new JTextField(5);
                secondCredit.setFont(new Font("Microsoft YaHei UI", 0, 14));
                secondCredit.setLocation(495, 450);
                secondCredit.setSize(154, 22);
                final JTextField thirdCredit = new JTextField(5);
                thirdCredit.setFont(new Font("Microsoft YaHei UI", 0, 14));
                thirdCredit.setLocation(150, 500);
                thirdCredit.setSize(154, 22);
                final JTextField fourthCredit = new JTextField(5);
                fourthCredit.setFont(new Font("Microsoft YaHei UI", 0, 14));
                fourthCredit.setLocation(495, 500);
                fourthCredit.setSize(154, 22);

                JButton submitButton = new JButton(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/button submit normal.png"));
                submitButton.setPressedIcon(new ImageIcon("C:/Users/never/Desktop/CSSNWU_Client/images/TeacherUI/button submit.png"));
                submitButton.setContentAreaFilled(false);
                submitButton.setBorderPainted(false);
                submitButton.setFocusPainted(false);
                submitButton.setSize(174, 38);
                submitButton.setLocation(17, 550);
                submitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DepartmentPlanVO newPlan = new DepartmentPlanVO();
//                        newPlan.department=;
                        newPlan.minCreditPerSeason = new int[4];
                        int oCredit = Integer.parseInt(firstCredit.getText());
                        int tCredit = Integer.parseInt(secondCredit.getText());
                        int thCredit = Integer.parseInt(thirdCredit.getText());
                        int fCredit = Integer.parseInt(fourthCredit.getText());
                        newPlan.minCreditPerSeason[0] = oCredit;
                        newPlan.minCreditPerSeason[1] = tCredit;
                        newPlan.minCreditPerSeason[2] = thCredit;
                        newPlan.minCreditPerSeason[3] = fCredit;
                        try {
                            deptTeacherController.drawDeptPlan(newPlan);
                        } catch (RemoteException ex) {
                            JOptionPane.showMessageDialog(null, "网络通信错误！", "Warning!!", JOptionPane.ERROR_MESSAGE);
                            ex.printStackTrace();
                        }
                    }
                });
                mainPanel.add(deptName);
                mainPanel.add(teachingPlan);
                mainPanel.add(firstCredit);
                mainPanel.add(firstTerm);
                mainPanel.add(secondCredit);
                mainPanel.add(secondTerm);
                mainPanel.add(thirdCredit);
                mainPanel.add(thirdTerm);
                mainPanel.add(fourthCredit);
                mainPanel.add(fourthTerm);
                mainPanel.add(submitButton);
                mainPanel.repaint();

            } else if (e.getSource() == navSetting) {
                /*
                logout
                jump back to login page
                 */
                try {
                    loginController = new LoginController();
                    loginController.logout(userId);
                    new LoginUI();
                    deptTeacherFrame.dispose();
                } catch (RemoteException re) {
                    JOptionPane.showMessageDialog(null, "网络通信错误！", "Warning!!", JOptionPane.ERROR_MESSAGE);
                    re.printStackTrace();
                }
            }
        }
    }

}

