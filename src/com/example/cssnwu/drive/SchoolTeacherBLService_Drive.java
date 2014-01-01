/**
 * @(#)SchoolTeacherBLService_Drive.java     	2013-10-13 下午11:14:05
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.drive;

import java.rmi.RemoteException;

import com.example.cssnwu.businesslogicservice.bl.SchoolTeacherBLService;
import com.example.cssnwu.stub.PrintHelper;
import com.example.cssnwu.vo.SchoolStrategyVO;

/**
 *Class <code>SchoolTeacherBLService_Drive.java</code> SchoolTeacherBLService接口的驱动
 *
 * @author never
 * @version 2013-10-13
 * @since JDK1.7
 */
public class SchoolTeacherBLService_Drive {
    public void drive(SchoolTeacherBLService schoolTeacherBLService) throws RemoteException {
    	PrintHelper.println(this.getClass().getName(), schoolTeacherBLService.realseSchoolStrategy(new SchoolStrategyVO()).toString());
    	
    	PrintHelper.println(this.getClass().getName(), schoolTeacherBLService.modifySchoolStrategy(new SchoolStrategyVO()).toString());
        
    	if (schoolTeacherBLService.getCourses() != null) {
    		PrintHelper.println(this.getClass().getName(), "getCourses Success");
    	}
    	
    	if (schoolTeacherBLService.getDepartmentPlans() != null) {
    		PrintHelper.println(this.getClass().getName(), "getDepartmentPlans Success");
    	}
    	
    	if (schoolTeacherBLService.getTeachers() != null) {
    		PrintHelper.println(this.getClass().getName(), "getTeachers Success");
    	}
    	
    	if (schoolTeacherBLService.getDropStudents() != null) {
    		PrintHelper.println(this.getClass().getName(), "getDropStudents Success");
    	}
    }
}
