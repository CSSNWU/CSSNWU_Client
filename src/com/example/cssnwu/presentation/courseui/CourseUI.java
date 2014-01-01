package com.example.cssnwu.presentation.courseui;

import com.example.cssnwu.businesslogic.controller.CourseController;
import com.example.cssnwu.vo.CourseVO;

import javax.swing.*;

/**
 * Created by albuszheng on 12/14/13.
 */
public class CourseUI extends JPanel{
    protected CourseVO course;
    protected boolean editable;

    protected JPanel infoPanel;
    protected JPanel teacherPanel;

    protected JButton submitButton;

    protected JLabel courseNameLabel;
    protected JTextField courseNameTextField;
    protected JLabel courseTypeLabel;
    protected JList courseTypeList;
    protected JLabel courseInfoLabel;
    protected JTextField courseInfoTextField;
    protected JLabel courseTimeLabel;
    protected JTextField courseTimeTextField;
    protected JLabel courseLocationLabel;
    protected JTextField courseLocationTextField;
    protected JLabel courseCreditLabel;
    protected JTextField courseCreditTextField;
    protected JLabel courseScore;
    protected JLabel establishTimeLabel;
    protected JTextField establishTimeTextField;

    /**
     * constructor default course page which cannot be edit
     * @param vo
     */
    public CourseUI(CourseVO vo){
        super();

        this.course=vo;
        this.courseNameLabel=new JLabel(this.course.courseName);
        this.courseTypeLabel=new JLabel(this.course.courseType.toString());
        this.courseInfoLabel=new JLabel(this.course.courseIntro);
        String[] tempTime=this.course.courseTime.split("/");
        this.courseTimeLabel=new JLabel(tempTime[0]+"  "+tempTime[1]+"½Ú");
        String[] tempLoc=this.course.courseLocation.split("/");
        this.courseLocationLabel=new JLabel(tempLoc[0]+"  "+tempLoc[1]);
        this.establishTimeLabel=new JLabel(this.course.establishTime);
        this.courseCreditLabel=new JLabel(Double.toString(this.course.credit));

        this.setSize(800,550);
    }

    /**
     * constructor course page which can be edited or not
      * @param vo
     * @param editable
     */
    public CourseUI(CourseVO vo,boolean editable){
        this.editable=editable;
        this.course=vo;
        if(!editable){
        }else{
            this.course=vo;
            this.courseNameLabel=new JLabel(this.course.courseName);
            this.courseTypeLabel=new JLabel(this.course.courseType.toString());
            this.courseInfoTextField=new JTextField(this.course.courseIntro);

        }
    }

    /**
     * constructor when announcing a new course
     */
    public CourseUI(){}
}
