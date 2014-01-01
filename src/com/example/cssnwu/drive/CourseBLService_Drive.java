/**
 * @(#)CourseBLService_Drive.java     	2013-10-13 下午10:52:05
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.drive;

import java.rmi.RemoteException;

import com.example.cssnwu.businesslogicservice.bl.CourseBLService;
import com.example.cssnwu.businesslogicservice.resultenum.CourseType;
import com.example.cssnwu.stub.PrintHelper;

/**
 *Class <code>CourseBLService_Drive.java</code> CourseBLService接口的驱动
 *
 * @author never
 * @version 2013-10-13
 * @since JDK1.7
 */
public class CourseBLService_Drive {
    public void drive(CourseBLService courseBLService) throws RemoteException {
    	if (courseBLService.getAllCourse() != null) {
    		PrintHelper.println(this.getClass().getName(), "getAllCourse Success");
    	}
    	
    	if (courseBLService.getCourseById(0) != null) {
    		PrintHelper.println(this.getClass().getName(), "getCourseById Success");
    	}
    	
    	if (courseBLService.getCourseByType(CourseType.公选课) != null) {
    		PrintHelper.println(this.getClass().getName(), "getCourseByType Success");
    	}
    	
    	if (courseBLService.getStuByCourseId(0) !=null) {
    		PrintHelper.println(this.getClass().getName(), "getStuByCourseId Success");
    	}
    	
    }
}
