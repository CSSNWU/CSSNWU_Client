package com.example.cssnwu.presentation.deptteacherui;

import javax.swing.*;
import java.awt.*;

/**
 * customize the default swing button mainly to complete the animation of image changing when mouse is
 * over the button
 *
 * Created by albuszheng on 12/13/13.
 */
public class MyButton extends JButton {
    private static final long serialVersionUID = 1L;

    private ImageIcon normal;
    private ImageIcon mouseOver;

    /**
     * custom constructor set the normal image and the image when mouse is over the button
     *
     * @param normalIcon
     * @param mouseOverIcon
     */
    MyButton(ImageIcon normalIcon, ImageIcon mouseOverIcon) {
        super();
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);

        this.normal = normalIcon;
        this.mouseOver = mouseOverIcon;

        this.setIcon(normal);
    }

    /**
     * over write the default constructor of JButton
     *
     * @param normalIcon
     */
    MyButton(ImageIcon normalIcon) {
        super();
        setBorderPainted(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);

        this.normal = normalIcon;
        this.mouseOver = null;

        this.setIcon(normal);
    }

    /*
    the method to set mouse-over image
     */
    public void setMouseoverIcon(ImageIcon mouseOverIcon) {
        this.mouseOver = mouseOverIcon;
    }

    @Override
    protected void paintComponent(Graphics g) {
        //when mouse enter the button change the image of the button
        if (getModel().isRollover()) {
            g.drawImage(mouseOver.getImage(), 0, 0, this);
        }
        //using the father's method to repaint.
        super.paintComponent(g);
    }
}
