/**
 * @(#)DeptTeacherBLService.java     	2013-10-9 下午8:30:36
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.businesslogicservice.bl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.example.cssnwu.businesslogicservice.resultenum.Department;
import com.example.cssnwu.businesslogicservice.resultenum.INSERT_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.UPDATE_RESULT;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.DepartmentPlanVO;
import com.example.cssnwu.vo.StudentVO;

/**
 *Class <code>DeptTeacherBLService.java</code> 连接表现层和逻辑层和院系教务老师对象有关的接口
 *
 * @author never
 * @version 2013-10-9
 * @since JDK1.7
 */
public interface DeptTeacherBLService {
	/**
     * Title: drawDeptPlan
     * Description: 制定院系教学计划
     * @param departmentPlanVO  院系教学计划VO  
     * @return  制定计划操作是否成功（boolean）
	 * @throws RemoteException 
     */
    public INSERT_RESULT drawDeptPlan(DepartmentPlanVO departmentPlanVO) throws RemoteException;
    
    /**
     * Title: releaseCourse
     * Description:   发布课程
     * @param courseVO CourseVO
     * @return       发布课程操作结果
     * @throws RemoteException 
     */
    public INSERT_RESULT releaseCourse(CourseVO courseVO) throws RemoteException;
    
    /**
     * Title: modifyCourseInfo
     * Description: 修改课程信息
     * @param courseVO  CourseVO
     * @return  修改操作结果
     * @throws RemoteException 
     */
    public UPDATE_RESULT modifyCourseInfo(CourseVO courseVO) throws RemoteException;
    
    /**
     * Title: getDeptCourses
     * Description: 查看本院课程列表
     * @param department  院系
     * @return   本院所有课程的列表（arrayList）
     * @throws RemoteException 
     */
    public ArrayList<CourseVO> getDeptCourses(Department department) throws RemoteException;
    
    
    /**
     * Title: getCourse
     * Description:     查看本院任意课程信息
     * @param courseId  课程ID
     * @return          CourseVO
     * @throws RemoteException 
     */
    public CourseVO getCourse(int courseId) throws RemoteException;
    
    
    /**
     * Title: getStuByCourse
     * Description: 查看本院任意课程的学生列表
     * @param courseId 课程ID
     * @param department 院系
     * @return 任意课程的学生列表（ArrayList）
     * @throws RemoteException 
     */
    public ArrayList<StudentVO> getStuByCourse(int courseId,Department department) throws RemoteException;
}
