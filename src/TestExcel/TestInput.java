package TestExcel;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;  

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import jxl.*; 
public class TestInput {
    public static void main(String[] args)
    {  final JFrame frame=new JFrame("Test");
       frame.setBounds(100, 100, 300, 300);
       JFileChooser chooser=new JFileChooser("File/Excel");
       JButton button=new JButton("µº»Î");
       button.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			FileDialog fd = new FileDialog(frame, "—°‘Ò", FileDialog.LOAD);
			
			fd.setVisible(true);
			try{
	    		Workbook book =Workbook.getWorkbook(new File(fd.getDirectory()+fd.getFile()));
	    		Sheet sheet=book.getSheet(0);
	    		Cell cell=sheet.getCell(0, 0);
	    		String contents=cell.getContents();
	    		System.out.println(contents);
	    		book.close();
	    		
	    	}catch(Exception el)
	    	{
	    		el.printStackTrace();
	    	}
		}
	});
       frame.add(button);
       frame.setVisible(true);
    	
    }
}
