/**
 * @(#)StubClient.java     	2013-10-13 下午9:33:12
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.stub;

import java.rmi.RemoteException;
import java.util.HashMap;

import com.example.cssnwu.businesslogicservice.bl.CourseBLService;
import com.example.cssnwu.businesslogicservice.bl.DeptTeacherBLService;
import com.example.cssnwu.businesslogicservice.bl.ManageCourseBLService;
import com.example.cssnwu.businesslogicservice.bl.SchoolTeacherBLService;
import com.example.cssnwu.businesslogicservice.bl.StudentBLService;
import com.example.cssnwu.businesslogicservice.bl.TeacherBLService;
import com.example.cssnwu.businesslogicservice.resultenum.CourseType;
import com.example.cssnwu.businesslogicservice.resultenum.Department;
import com.example.cssnwu.businesslogicservice.resultenum.ManageCourseType;
import com.example.cssnwu.databaseservice.DatabaseFactory;
import com.example.cssnwu.databaseservice.DatabaseService;
import com.example.cssnwu.po.PO;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.DepartmentPlanVO;

/**
 *Class <code>StubClient.java</code> 测试桩
 *
 * @author never
 * @version 2013-10-13
 * @since JDK1.7
 */
public class StubClient {
    public static void main(String args[]) throws RemoteException {
    	StubClient stubClient = new StubClient();
    	stubClient.testDBFactory();
    	stubClient.testDBService();
    	stubClient.testCourse();
    	stubClient.testDeptTeacher();
    	stubClient.testManageCourse();
    	stubClient.testSchoolTeacher();
    	stubClient.testStudent();
    	stubClient.testTeacher();
    }
    
    public void testDBFactory() throws RemoteException {
    	PrintHelper.println(this.getClass().getName(), "TestDBFactory");
    	DatabaseFactory databaseFactory = new DatabaseFactory_Stub();
    	databaseFactory.getCourseDatabaseService().init();
    }
    
    public void testDBService() throws RemoteException {
    	PrintHelper.println(this.getClass().getName(), "testDBService");
    	DatabaseService databaseService = new DatabaseService_Stub();
    	databaseService.find(0);
    	databaseService.find("test");
    	databaseService.delete(new PO());
    	databaseService.findAll();
    	databaseService.findAll(0);
    	databaseService.finish();
    	databaseService.init();
    	databaseService.insert(new PO());
    	databaseService.load();
    	databaseService.save();
    	databaseService.update(new PO());
    }
    
    public void testCourse() throws RemoteException {
    	PrintHelper.println(this.getClass().getName(), "testCourse");
    	CourseBLService courseBLService = new CourseBLService_Stub();
    	PrintHelper.println(this.getClass().getName(), courseBLService.getAllCourse().size() + "");
    	PrintHelper.println(this.getClass().getName(), courseBLService.getCourseById(0).courseName);
    	PrintHelper.println(this.getClass().getName(), courseBLService.getCourseByType(CourseType.公选课).size() +"");
    	PrintHelper.println(this.getClass().getName(), courseBLService.getCourseByType(CourseType.指选课).size() +"");
    	PrintHelper.println(this.getClass().getName(), courseBLService.getStuByCourseId(0).size() +"");
    	PrintHelper.println(this.getClass().getName(), courseBLService.getStuByCourseId(1).size() +"");
    }
    
    public void testDeptTeacher() throws RemoteException {
    	PrintHelper.println(this.getClass().getName(), "testDeptTeacher");
    	DeptTeacherBLService deptTeacherBLService = new DeptTeacherBLService_Stub();
    	PrintHelper.println(this.getClass().getName(), deptTeacherBLService.getCourse(0).courseName);
    	PrintHelper.println(this.getClass().getName(), deptTeacherBLService.getDeptCourses(Department.软件学院).size() + "");
    	PrintHelper.println(this.getClass().getName(), deptTeacherBLService.getStuByCourse(0, Department.软件学院).size() + "");
    	PrintHelper.println(this.getClass().getName(), deptTeacherBLService.getStuByCourse(1, Department.软件学院).size() + "");
    	PrintHelper.println(this.getClass().getName(), deptTeacherBLService.modifyCourseInfo(new CourseVO()).toString());
    	PrintHelper.println(this.getClass().getName(), deptTeacherBLService.releaseCourse(new CourseVO()).toString());
    	PrintHelper.println(this.getClass().getName(), deptTeacherBLService.drawDeptPlan(new DepartmentPlanVO()).toString());
    }
    
    public void testManageCourse() throws RemoteException {
    	PrintHelper.println(this.getClass().getName(), "testManageCourse");
    	ManageCourseBLService manageCourseBLService = new ManageCourseBLService_Stub();
    	PrintHelper.println(this.getClass().getName(), manageCourseBLService.getSelectedCourses(1001).size() + "");
    	PrintHelper.println(this.getClass().getName(), manageCourseBLService.addCourse(new CourseVO()).toString());
    	PrintHelper.println(this.getClass().getName(), manageCourseBLService.addManageType(ManageCourseType.select).toString());
    	PrintHelper.println(this.getClass().getName(), manageCourseBLService.addStudent(1001).toString());
       
    }
    
    public void testSchoolTeacher() throws RemoteException {
    	PrintHelper.println(this.getClass().getName(), "testSchoolTeacher");
    	SchoolTeacherBLService schoolTeacherBLService = new SchoolTeacherBLService_Stub();
    	PrintHelper.println(this.getClass().getName(), schoolTeacherBLService.getCourses().size() + "");
    	PrintHelper.println(this.getClass().getName(), schoolTeacherBLService.getDepartmentPlans().size() + "");
    	PrintHelper.println(this.getClass().getName(), schoolTeacherBLService.getDropStudents().size() + "");
    	PrintHelper.println(this.getClass().getName(), schoolTeacherBLService.getTeachers().size() + "");
    }
    
    public void testStudent() throws RemoteException {
    	PrintHelper.println(this.getClass().getName(), "testStudent");
    	StudentBLService studentBLService = new StudentBLService_Stub();
    	PrintHelper.println(this.getClass().getName(), studentBLService.getCourses(1001).size() + "");
    	PrintHelper.println(this.getClass().getName(), studentBLService.getCourses(1000).size() + "");
    	PrintHelper.println(this.getClass().getName(), studentBLService.getCoursesBySemester(1001, "20131").size() + "");
    	PrintHelper.println(this.getClass().getName(), studentBLService.getCoursesBySemester(1000, "20131").size() + "");
    	PrintHelper.println(this.getClass().getName(), studentBLService.getTransferInfo(1001).toString());
    	
    }
    
    public void testTeacher() throws RemoteException {
    	PrintHelper.println(this.getClass().getName(), "testTeacher");
    	TeacherBLService teacherBLService = new TeacherBLService_Stub();
    	PrintHelper.println(this.getClass().getName(), teacherBLService.getStuByCourseId(0).size() + "");
    	PrintHelper.println(this.getClass().getName(), teacherBLService.getStuByCourseId(1).size() + "");
    	PrintHelper.println(this.getClass().getName(), teacherBLService.registerScore(0, new HashMap<Integer, Double>()).toString());
    	PrintHelper.println(this.getClass().getName(), teacherBLService.updateCourseInfo(new CourseVO()).toString());
    }
}
