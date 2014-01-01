package com.example.cssnwu.presentation.schoolteacherui;

import java.awt.*;

import java.awt.geom.*;
import javax.swing.*;
/**
 * Created with IntelliJ IDEA.
 * User: Thunder
 * Date: 13-11-21
 * Time: ����9:38
 * To change this template use File | Settings | File Templates.
 */



public class RoundButton extends JButton {
	/**Title:
	 * Description:���캯��
	 * @param label
	 */
	public RoundButton(String label) {
		super(label);


   /*
    *  ��Щ�����Ѱ�ť��չΪһ��Բ������һ����Բ��
    */
		Dimension size = getPreferredSize();
		size.width = size.height = Math.max(size.width,
				size.height);
		setPreferredSize(size);


		/*
		 * �������ʹJButton�������������������ǻ�һ��Բ�ı�����
		 */
		setContentAreaFilled(false);
	}
	/**Title:
	 * Description:���캯��
	 * @param icon
	 */
	public RoundButton(Icon icon)
	{
		super(icon);
		/*
		 *  ��Щ�����Ѱ�ť��չΪһ��Բ������һ����Բ��
		 */
		Dimension size = getPreferredSize();
		size.width = size.height = Math.max(size.width,
				size.height);
		setPreferredSize(size);


		/*
		 *	 �������ʹJButton�������������������ǻ�һ��Բ�ı�����
		 */
		setContentAreaFilled(false);
	}

	@Override
	public void setPressedIcon(Icon pressedIcon) {
		setContentAreaFilled(false);
		super.setPressedIcon(pressedIcon);    //To change body of overridden methods use File | Settings | File Templates.
	}

	// ��Բ�ı����ͱ�ǩ
	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) {

// �����ѡһ����������ɫ��ΪԲ�ΰ�ť�������
			g.setColor(Color.lightGray);
		} else {
			g.setColor(getBackground());
		}
		setContentAreaFilled(false);
		g.fillOval(0, 0, getSize().width-1,
				getSize().height-1);

//������ûửһ����ǩ�ͽ�����Ρ�
		super.paintComponent(g);
	}

    /**Title:paintBorder
     * Description:	// �ü򵥵Ļ�����ť�ı߽硣
     * 
     */

	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		g.drawOval(0, 0, getSize().width-1,
				getSize().height-1);
	}


	/*
	 * ������¼�
	 */
	Shape shape;
	public boolean contains(int x, int y) {

// �����ť�ı��С������һ���µ���״����
		if (shape == null ||
				!shape.getBounds().equals(getBounds())) {
			shape = new Ellipse2D.Float(0, 0,
					getWidth(), getHeight());
		}
		return shape.contains(x, y);
	}


}