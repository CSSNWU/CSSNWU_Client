/**
 * @(#)ManageCourseBLService.java     	2013-10-8 ����7:43:51
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
	 * Description:  ͨ��id��ȡ��ѧ���Ѿ�ѡ��Ŀγ��б�
	 * @param studentId    ѧ��ID
	 * @return    ��ѡ�γ̣�CourseVO�����б�ArrayList��
	 * @throws RemoteException 
	 */
    public ArrayList<CourseVO> getSelectedCourses(int studentId) throws RemoteException;
    
    /**
     * Title: addStudent
     * Description:       ��ʼ����γ�ʱ�����ִ�иò�����ѧ��
     * @param studentId   ѧ��ѧ��
     * @return  ���ѧ�������Ľ��
     * @throws RemoteException 
     */
    public ADD_RESULT addStudent(int studentId) throws RemoteException;
    
    /**
     * Title: addManageType
     * Description:     ��ʼ����γ�ʱ����ӹ���γ̲���������
     * @param manageCourseType    ����γ̵����ͣ�ManageCourseType��
     * @return   ��ӹ���γ����͵Ľ��
     */
    public ADD_RESULT addManageType(ManageCourseType manageCourseType);
 
    /**
     * Title: addCourse
     * Description:   �ڽ��пγ̹���ʱ������Ҫ������Ŀγ��б�����ӿγ�
     * @param courseVO   CourseVO
     * @return  ��ӿγ̵Ľ��
     */
    public ADD_RESULT addCourse(CourseVO courseVO);  
    
    /**
     * Title: deleteCourse
     * Description:  �ڽ��пγ̹���ʱ���ӽ�Ҫ����Ŀγ��б���ɾ���γ�
     * @param courseVO  CourseVO
     * @return ɾ���γ̵Ľ��
     */
    public DELETE_RESULT deleteCourse(CourseVO courseVO);
    
    /**
     * Title: endManage
     * Description: �����γ̹���������������ύ������
     * @param manageCourseVO    ManageCourseVO
     * @return    �ύ��������γ̲����Ľ��
     * @throws RemoteException 
     */
    public MANAGE_RESULT endManage(ManageCourseVO manageCourseVO) throws RemoteException;
}
