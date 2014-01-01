/**
 * @(#)TeacherBLService_Drive.java     	2013-10-13 下午11:01:17
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.drive;

import java.rmi.RemoteException;
import java.util.HashMap;

import com.example.cssnwu.businesslogicservice.bl.TeacherBLService;
import com.example.cssnwu.stub.DataHelper;
import com.example.cssnwu.stub.PrintHelper;

/**
 *Class <code>TeacherBLService_Drive.java</code> TeacherBLService接口的驱动
 *
 * @author never
 * @version 2013-10-13
 * @since JDK1.7
 */
public class TeacherBLService_Drive {
    public void drive(TeacherBLService teacherBLService) throws RemoteException {
    	if (teacherBLService.getStuByCourseId(0) != null) {
    		PrintHelper.println(this.getClass().getName(), "getStuByCourseId Success");
    	}
    	
    	PrintHelper.println(this.getClass().getName(), teacherBLService.updateCourseInfo(new DataHelper().courseVOs.get(0)).toString());
        
    	HashMap<Integer, Double> map = new HashMap<Integer, Double>();
    	map.put(1001, 90.0);
    	map.put(1002, 85.0);
     	PrintHelper.println(this.getClass().getName(), teacherBLService.registerScore(0, map).toString());
    }
}
