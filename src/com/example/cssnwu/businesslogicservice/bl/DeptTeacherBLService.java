/**
 * @(#)DeptTeacherBLService.java     	2013-10-9 ����8:30:36
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
 *Class <code>DeptTeacherBLService.java</code> ���ӱ��ֲ���߼����Ժϵ������ʦ�����йصĽӿ�
 *
 * @author never
 * @version 2013-10-9
 * @since JDK1.7
 */
public interface DeptTeacherBLService {
	/**
     * Title: drawDeptPlan
     * Description: �ƶ�Ժϵ��ѧ�ƻ�
     * @param departmentPlanVO  Ժϵ��ѧ�ƻ�VO  
     * @return  �ƶ��ƻ������Ƿ�ɹ���boolean��
	 * @throws RemoteException 
     */
    public INSERT_RESULT drawDeptPlan(DepartmentPlanVO departmentPlanVO) throws RemoteException;
    
    /**
     * Title: releaseCourse
     * Description:   �����γ�
     * @param courseVO CourseVO
     * @return       �����γ̲������
     * @throws RemoteException 
     */
    public INSERT_RESULT releaseCourse(CourseVO courseVO) throws RemoteException;
    
    /**
     * Title: modifyCourseInfo
     * Description: �޸Ŀγ���Ϣ
     * @param courseVO  CourseVO
     * @return  �޸Ĳ������
     * @throws RemoteException 
     */
    public UPDATE_RESULT modifyCourseInfo(CourseVO courseVO) throws RemoteException;
    
    /**
     * Title: getDeptCourses
     * Description: �鿴��Ժ�γ��б�
     * @param department  Ժϵ
     * @return   ��Ժ���пγ̵��б�arrayList��
     * @throws RemoteException 
     */
    public ArrayList<CourseVO> getDeptCourses(Department department) throws RemoteException;
    
    
    /**
     * Title: getCourse
     * Description:     �鿴��Ժ����γ���Ϣ
     * @param courseId  �γ�ID
     * @return          CourseVO
     * @throws RemoteException 
     */
    public CourseVO getCourse(int courseId) throws RemoteException;
    
    
    /**
     * Title: getStuByCourse
     * Description: �鿴��Ժ����γ̵�ѧ���б�
     * @param courseId �γ�ID
     * @param department Ժϵ
     * @return ����γ̵�ѧ���б�ArrayList��
     * @throws RemoteException 
     */
    public ArrayList<StudentVO> getStuByCourse(int courseId,Department department) throws RemoteException;
}
