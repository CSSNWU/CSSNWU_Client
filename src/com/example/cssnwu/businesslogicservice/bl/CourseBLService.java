/**
 * @(#)CourseBLService.java     	2013-10-5 下午1:37:33
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.businesslogicservice.bl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.example.cssnwu.businesslogicservice.resultenum.CourseType;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.StudentVO;

/**
 *Class <code>CourseBLService.java</code> 连接表现层和逻辑层和course对象有关的接口
 *
 * @author never
 * @version 2013-10-5
 * @since JDK1.7
 */
public interface CourseBLService {
	/**
	 * Title: getAllCourse
	 * Description:  获取所有的课程列表
	 * @return  课程的ArrayList
	 * @throws RemoteException 
	 */
    public ArrayList<CourseVO> getAllCourse() throws RemoteException;
    
    /**
     * Title: getCourseByType
     * Description:        获取某个类型的课程列表
     * @param courseType   课程类型
     * @return             某一类型课程的类表（ArrayList）
     * @throws RemoteException 
     */
    public ArrayList<CourseVO> getCourseByType(CourseType courseType) throws RemoteException;
    
    /**
     * Title: getCourseById
     * Description:   通过编号获取课程
     * @param id      ID
     * @return        CourseVO（为空表示不存在包含该关键字的课程）
     * @throws RemoteException 
     */
    public CourseVO getCourseById(int id) throws RemoteException;
    
    /**
     * Title: getStuByCourseId
     * Description:获取选择某门课的学生列表
     * @param courseId     课程ID
     * @return    选择某门课的学生列表（ArrayList）
     * @throws RemoteException 
     */
    public ArrayList<StudentVO> getStuByCourseId(int courseId) throws RemoteException;
    
}
