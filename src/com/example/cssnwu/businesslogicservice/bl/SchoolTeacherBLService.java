/**
 * @(#)SchoolTeacherBLService.java     	2013-10-10 上午1:01:00
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.businesslogicservice.bl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.example.cssnwu.businesslogicservice.resultenum.INSERT_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.UPDATE_RESULT;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.DepartmentPlanVO;
import com.example.cssnwu.vo.SchoolStrategyVO;
import com.example.cssnwu.vo.StudentVO;
import com.example.cssnwu.vo.TeacherVO;

/**
 *Class <code>SchoolTeacherBLService.java</code> 连接表现层和逻辑层和学校教务老师对象有关的接口
 *
 * @author never
 * @version 2013-10-10
 * @since JDK1.7
 */
public interface SchoolTeacherBLService {
	/**
	 * Title: realseSchoolStrategy
	 * Description:输入整体框架策略
	 * @param schoolStrategyVO  SchoolStrategyVO
	 * @return           插入操作的结果
	 * @throws RemoteException 
	 */
    public INSERT_RESULT realseSchoolStrategy(SchoolStrategyVO schoolStrategyVO) throws RemoteException;
    
    /**
     * Title: modifySchoolStrategy
     * Description:修改整体框架策略
     * @param schoolStrategyVO   SchoolStrategyVO
     * @return       更新操作的结果
     * @throws RemoteException 
     */
    public UPDATE_RESULT modifySchoolStrategy(SchoolStrategyVO schoolStrategyVO) throws RemoteException;
    
    /**
     * Title: getSchoolStrategy
     * Description: 查看整体框架策略
     * @return  SchoolStrategyVO
     * @throws RemoteException 
     */
    public SchoolStrategyVO getSchoolStrategy() throws RemoteException;
    
    /**
     * Title: getDepartmentPlans
     * Description:  查看各院系教学计划
     * @return  教学计划的列表（ArrayList）
     * @throws RemoteException 
     */
    public ArrayList<DepartmentPlanVO> getDepartmentPlans() throws RemoteException;
    
    /**
     * Title: getTeachers
     * Description: 查看教师统计信息
     * @return 任课老师的列表（ArrayList）
     * @throws RemoteException 
     */
    public ArrayList<TeacherVO> getTeachers() throws RemoteException;
    
    /**
     * Title: getCourses
     * Description:查看课程统计信息
     * @return   课程的列表（ArrayList）
     * @throws RemoteException 
     */
    public ArrayList<CourseVO> getCourses() throws RemoteException;
    
    /**
     * Title: getTransferStudents
     * Description: 查看学生准入准出信息
     * @return 学生的列表（ArrayList）
     * @throws RemoteException 
     */
    public ArrayList<StudentVO> getTransferStudents() throws RemoteException;
    
    /**
     * Title: getGraduateStudents
     * Description:查看学生毕业资格统计
     * @return  学生的列表（ArrayList）
     * @throws RemoteException 
     */
    public ArrayList<StudentVO> getGraduateStudents() throws RemoteException;
    
    /**
     * Title: getStayDownStudents
     * Description:查看留级的学生统计信息
     * @return  学生的列表（ArrayList）
     * @throws RemoteException 
     */
    public ArrayList<StudentVO> getStayDownStudents() throws RemoteException;
    
    /**
     * Title: getDropStudents
     * Description:查看退学的学生统计信息
     * @return 学生的列表（ArrayList）
     * @throws RemoteException 
     */
    public ArrayList<StudentVO> getDropStudents() throws RemoteException;
}
