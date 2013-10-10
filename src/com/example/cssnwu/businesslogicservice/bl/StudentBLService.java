/**
 * @(#)StudentBLService.java     	2013-10-5 下午3:00:45
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.businesslogicservice.bl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.example.cssnwu.businesslogicservice.resultenum.TRANSFER_RESULT;
import com.example.cssnwu.vo.CourseVO;


/**
 *Class <code>StudentBLService.java</code> 连接表现层和逻辑层和学生对象有关的接口
 *
 * @author never
 * @version 2013-10-5
 * @since JDK1.7
 */
public interface StudentBLService {
	/**
	 * Title: getCourses
	 * Description:       通过ID获取该学生的课程列表
	 * @param studentId   学生ID
	 * @return            学生的课程列表（ArrayList）
	 * @throws RemoteException 
	 */
    public ArrayList<CourseVO> getCourses(int studentId) throws RemoteException;
    
    /**
     * Title: getTransferInfo
     * Description: 查看准入准出信息
     * @param studentId  学生ID
     * @return    准入准出信息结果
     * @throws RemoteException 
     */
    public TRANSFER_RESULT getTransferInfo(int studentId) throws RemoteException;
    
    
    /**
     * Title: getCoursesBySemester
     * Description: 根据学期查看学生课程
     * @param studentId 学生ID
     * @param semester 学期
     * @return     课程的列表（ArrayList）
     * @throws RemoteException 
     */
    public ArrayList<CourseVO> getCoursesBySemester(int studentId,String semester) throws RemoteException;
    
    
}
