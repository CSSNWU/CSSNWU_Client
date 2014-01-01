/**
 * @(#)DeptTeacherBLService_Stub.java     	2013-10-13 下午11:07:56
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.drive;

import java.rmi.RemoteException;

import com.example.cssnwu.businesslogicservice.bl.DeptTeacherBLService;
import com.example.cssnwu.businesslogicservice.resultenum.Department;
import com.example.cssnwu.stub.PrintHelper;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.DepartmentPlanVO;

/**
 *Class <code>DeptTeacherBLService_Drive.java</code> DeptTeacherBLService接口的驱动
 *
 * @author never
 * @version 2013-10-13
 * @since JDK1.7
 */
public class DeptTeacherBLService_Drive {
    public void drive(DeptTeacherBLService deptTeacherBLService) throws RemoteException {
    	if (deptTeacherBLService.getCourse(0) != null) {
    		PrintHelper.println(this.getClass().getName(), "getCourse Success");
    	}
    	
    	if (deptTeacherBLService.getDeptCourses(Department.软件学院) != null) {
    		PrintHelper.println(this.getClass().getName(), "getDeptCourses Success");
    	}
    	
    	if (deptTeacherBLService.getStuByCourse(0, Department.软件学院) !=null) {
    		PrintHelper.println(this.getClass().getName(), "getStuByCourse Success");
    	}
    	
    	PrintHelper.println(this.getClass().getName(), deptTeacherBLService.drawDeptPlan(new DepartmentPlanVO()).toString());
    	
    	PrintHelper.println(this.getClass().getName(), deptTeacherBLService.modifyCourseInfo(new CourseVO()).toString());
    	
    	PrintHelper.println(this.getClass().getName(), deptTeacherBLService.releaseCourse(new CourseVO()).toString());
    }
}
