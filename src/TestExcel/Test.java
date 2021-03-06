package TestExcel;
import java.io.*;    
import jxl.*;    
import jxl.write.*;    
 
public class Test {
	
  
	  
	    public static void main(String[] args) {   
	        try {   
	            //open file.   
	            WritableWorkbook book = Workbook.createWorkbook(new File("File/Excel/Test.xls"));   
	               
	            //create Sheet named "Sheet_1". 0 means this is 1st page.   
	            WritableSheet sheet = book.createSheet("Sheet_1", 0);   
	               
	            //define cell column and row in Label Constructor, and cell content write "test".   
	            //cell is 1st-Column,1st-Row. value is "test".   
	            Label label = new Label(0, 0, "test");   
	            //add defined cell above to sheet instance.   
	            sheet.addCell(label);   
	               
	            //create cell using add numeric. WARN:necessarily use integrated package-path, otherwise will be throws path-error.   
	            //cell is 2nd-Column, 1st-Row. value is 789.123.   
	            jxl.write.Number number = new jxl.write.Number(1, 0, 789.123);   
	            //add defined cell above to sheet instance.   
	            sheet.addCell(number);   
	               
	            //add defined all cell above to case.   
	            book.write();   
	            //close file case.   
	            book.close();   
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        }   
	    }   
	}  

