/**
 * @(#)StudentBLService_Drive.java     	2013-10-11 下午12:18:03
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.drive;

import java.rmi.RemoteException;

import com.example.cssnwu.businesslogicservice.bl.StudentBLService;
import com.example.cssnwu.stub.PrintHelper;

/**
 *Class <code>StudentBLService_Drive.java</code> StudentBLService接口的驱动
 *
 * @author never
 * @version 2013-10-11
 * @since JDK1.7
 */
public class StudentBLService_Drive {
    public void drive(StudentBLService studentBLService) throws RemoteException {
    	if (studentBLService.getCourses(1001) != null) {
    		PrintHelper.println(this.getClass().getName(), "getCourse Success");
    	}
    	
    	if (studentBLService.getCoursesBySemester(1001, "20131") !=null) {
    		PrintHelper.println(this.getClass().getName(), "getCoursesBySemester Success");
    	}
    	
    	PrintHelper.println(this.getClass().getName(), studentBLService.getTransferInfo(1001).toString());
    	
    }
    
}
