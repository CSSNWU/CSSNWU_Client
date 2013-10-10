/**
 * @(#)ManageCourseBLService.java     	2013-10-8 下午7:43:51
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.businesslogicservice.bl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.example.cssnwu.businesslogicservice.resultenum.ADD_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.DELETE_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.MANAGE_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.ManageCourseType;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.ManageCourseVO;

/**
 *Class <code>ManageCourseBLService.java</code> TODO
 *
 * @author never
 * @version 2013-10-8
 * @since JDK1.7
 */
public interface ManageCourseBLService {
	/**
	 * Title: getSelectedCourses
	 * Description:  通过id获取该学生已经选择的课程列表
	 * @param studentId    学生ID
	 * @return    已选课程（CourseVO）的列表（ArrayList）
	 * @throws RemoteException 
	 */
    public ArrayList<CourseVO> getSelectedCourses(int studentId) throws RemoteException;
    
    /**
     * Title: addStudent
     * Description:       开始管理课程时，添加执行该操作的学生
     * @param studentId   学生学号
     * @return  添加学生操作的结果
     * @throws RemoteException 
     */
    public ADD_RESULT addStudent(int studentId) throws RemoteException;
    
    /**
     * Title: addManageType
     * Description:     开始管理课程时，添加管理课程操作的类型
     * @param manageCourseType    管理课程的类型（ManageCourseType）
     * @return   添加管理课程类型的结果
     */
    public ADD_RESULT addManageType(ManageCourseType manageCourseType);
 
    /**
     * Title: addCourse
     * Description:   在进行课程管理时，往将要被管理的课程列表中添加课程
     * @param courseVO   CourseVO
     * @return  添加课程的结果
     */
    public ADD_RESULT addCourse(CourseVO courseVO);  
    
    /**
     * Title: deleteCourse
     * Description:  在进行课程管理时，从将要管理的课程列表中删除课程
     * @param courseVO  CourseVO
     * @return 删除课程的结果
     */
    public DELETE_RESULT deleteCourse(CourseVO courseVO);
    
    /**
     * Title: endManage
     * Description: 结束课程管理操作，将请求提交服务器
     * @param manageCourseVO    ManageCourseVO
     * @return    提交结束管理课程操作的结果
     * @throws RemoteException 
     */
    public MANAGE_RESULT endManage(ManageCourseVO manageCourseVO) throws RemoteException;
}
