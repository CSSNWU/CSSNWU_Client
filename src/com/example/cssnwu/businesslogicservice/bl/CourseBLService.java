/**
 * @(#)CourseBLService.java     	2013-10-5 ����1:37:33
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
 *Class <code>CourseBLService.java</code> ���ӱ��ֲ���߼����course�����йصĽӿ�
 *
 * @author never
 * @version 2013-10-5
 * @since JDK1.7
 */
public interface CourseBLService {
	/**
	 * Title: getAllCourse
	 * Description:  ��ȡ���еĿγ��б�
	 * @return  �γ̵�ArrayList
	 * @throws RemoteException 
	 */
    public ArrayList<CourseVO> getAllCourse() throws RemoteException;
    
    /**
     * Title: getCourseByType
     * Description:        ��ȡĳ�����͵Ŀγ��б�
     * @param courseType   �γ�����
     * @return             ĳһ���Ϳγ̵����ArrayList��
     * @throws RemoteException 
     */
    public ArrayList<CourseVO> getCourseByType(CourseType courseType) throws RemoteException;
    
    /**
     * Title: getCourseById
     * Description:   ͨ����Ż�ȡ�γ�
     * @param id      ID
     * @return        CourseVO��Ϊ�ձ�ʾ�����ڰ����ùؼ��ֵĿγ̣�
     * @throws RemoteException 
     */
    public CourseVO getCourseById(int id) throws RemoteException;
    
    /**
     * Title: getStuByCourseId
     * Description:��ȡѡ��ĳ�ſε�ѧ���б�
     * @param courseId     �γ�ID
     * @return    ѡ��ĳ�ſε�ѧ���б�ArrayList��
     * @throws RemoteException 
     */
    public ArrayList<StudentVO> getStuByCourseId(int courseId) throws RemoteException;
    
}
