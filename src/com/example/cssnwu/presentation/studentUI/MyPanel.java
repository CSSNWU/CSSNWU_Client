package com.example.cssnwu.presentation.studentUI;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Thunder
 * Date: 13-11-24
 * Time: 下午9:12
 * To change this template use File | Settings | File Templates.
 */
public class MyPanel extends JPanel
{   private Image image;//图片
   /**
    * 构造方法  
    * 
    * @param fileName 图片的路径
     */
	public MyPanel(String fileName)
	{    super();
		try {
			image = ImageIO.read(new File("C:/Users/never/Desktop/CSSNWU_Client/"+fileName));
			//Image image = new ImageIcon(this.getClassLoader().getResource(new File(fileName))).getImage();
		} catch (Exception ex) {
			ex.printStackTrace();
		}//防止有文件不存在的



	}
    /**  
     *   Title :
     *   description:构造函数
     * @param layout  
     * @param fileName
     */
	public MyPanel(LayoutManager layout, String fileName) {
		super(layout);    //To change body of overridden methods use File | Settings | File Templates.
		try {
			image = ImageIO.read(new File("C:/Users/never/Desktop/CSSNWU_Client/"+fileName));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
     /**
      * 
      */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);    //To change body of overridden methods use File | Settings | File Templates.
		g.drawImage(image,0,0,this);
	}
	/**
	 * Title: setImage
	 * Description:为myPanel设置图片
	 * @param fileName
	 */
    public void setImage(String fileName)
	{     try {
		    image = ImageIO.read(new File("C:/Users/never/Desktop/CSSNWU_Client/"+fileName));
	    } catch (Exception ex) {
		     ex.printStackTrace();
	      }
		 repaint();
	}

}
