/**
 * @(#)TeacherBLService.java     	2013-10-5 下午3:01:07
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.businesslogicservice.bl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.cssnwu.businesslogicservice.resultenum.UPDATE_RESULT;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.StudentVO;

/**
 *Class <code>TeacherBLService.java</code> 连接表现层和逻辑层和任课老师对象有关的接口
 *
 * @author never
 * @version 2013-10-5
 * @since JDK1.7
 */
public interface TeacherBLService {
    /**
     * Title: getStuByCourseId
     * Description:获取选择某门课的学生列表
     * @param courseId     课程ID
     * @return    选择某门课的学生列表（ArrayList）
     * @throws RemoteException 
     */
    public ArrayList<StudentVO> getStuByCourseId(int courseId) throws RemoteException;
    
    /**
     * Title: updateCourseInfo
     * Description: 任课老师填写课程信息（课程大纲、教程、参考书目）
     * @param courseVO  CourseVO
     * @return   更新操作的结果
     * @throws RemoteException 
     */
    public UPDATE_RESULT updateCourseInfo(CourseVO courseVO) throws RemoteException;
    
    /**
     * Title: registerScore
     * Description:     任课老师登记成绩
     * @param courseId  课程ID
     * @param map       学生ID和其成绩的HashMap
     * @return          更新操作的结果
     * @throws RemoteException 
     */
    public UPDATE_RESULT registerScore(int courseId,HashMap<Integer, Double> map) throws RemoteException;
    
}
