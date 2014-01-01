/**
 * @(#)Client.java     	2013-10-11 下午12:24:06
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.drive;

import java.rmi.RemoteException;

import com.example.cssnwu.businesslogic.controller.CourseController;
import com.example.cssnwu.businesslogic.controller.DeptTeacherController;
import com.example.cssnwu.businesslogic.controller.ManageCourseController;
import com.example.cssnwu.businesslogic.controller.SchoolTeacherController;
import com.example.cssnwu.businesslogic.controller.StudentController;
import com.example.cssnwu.businesslogic.controller.TeacherController;
import com.example.cssnwu.businesslogicservice.bl.CourseBLService;
import com.example.cssnwu.businesslogicservice.bl.DeptTeacherBLService;
import com.example.cssnwu.businesslogicservice.bl.ManageCourseBLService;
import com.example.cssnwu.businesslogicservice.bl.SchoolTeacherBLService;
import com.example.cssnwu.businesslogicservice.bl.StudentBLService;
import com.example.cssnwu.businesslogicservice.bl.TeacherBLService;

/**
 *Class <code>Client.java</code> 驱动测试启动类.
 *
 * @author never
 * @version 2013-10-11
 * @since JDK1.7
 */
public class Client {
    public static void main(String arg[]) throws RemoteException {
    	StudentBLService studentBLService = new StudentController();
    	new StudentBLService_Drive().drive(studentBLService);
    	
    	CourseBLService courseBLService = new CourseController();
    	new CourseBLService_Drive().drive(courseBLService);
    	
    	TeacherBLService teacherBLService = new TeacherController();
    	new TeacherBLService_Drive().drive(teacherBLService);
    	
    	DeptTeacherBLService deptTeacherBLService = new DeptTeacherController();
    	new DeptTeacherBLService_Drive().drive(deptTeacherBLService);
    	
    	SchoolTeacherBLService schoolTeacherBLService = new SchoolTeacherController();
    	new SchoolTeacherBLService_Drive().drive(schoolTeacherBLService);
    
    	ManageCourseBLService manageCourseBLService = new ManageCourseController();
    	new ManageCourseBLService_Drive().drive(manageCourseBLService);
    }
}
