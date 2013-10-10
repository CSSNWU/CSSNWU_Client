/**
 * @(#)SchoolTeacherBLService.java     	2013-10-10 ����1:01:00
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
 *Class <code>SchoolTeacherBLService.java</code> ���ӱ��ֲ���߼����ѧУ������ʦ�����йصĽӿ�
 *
 * @author never
 * @version 2013-10-10
 * @since JDK1.7
 */
public interface SchoolTeacherBLService {
	/**
	 * Title: realseSchoolStrategy
	 * Description:���������ܲ���
	 * @param schoolStrategyVO  SchoolStrategyVO
	 * @return           ��������Ľ��
	 * @throws RemoteException 
	 */
    public INSERT_RESULT realseSchoolStrategy(SchoolStrategyVO schoolStrategyVO) throws RemoteException;
    
    /**
     * Title: modifySchoolStrategy
     * Description:�޸������ܲ���
     * @param schoolStrategyVO   SchoolStrategyVO
     * @return       ���²����Ľ��
     * @throws RemoteException 
     */
    public UPDATE_RESULT modifySchoolStrategy(SchoolStrategyVO schoolStrategyVO) throws RemoteException;
    
    /**
     * Title: getSchoolStrategy
     * Description: �鿴�����ܲ���
     * @return  SchoolStrategyVO
     * @throws RemoteException 
     */
    public SchoolStrategyVO getSchoolStrategy() throws RemoteException;
    
    /**
     * Title: getDepartmentPlans
     * Description:  �鿴��Ժϵ��ѧ�ƻ�
     * @return  ��ѧ�ƻ����б�ArrayList��
     * @throws RemoteException 
     */
    public ArrayList<DepartmentPlanVO> getDepartmentPlans() throws RemoteException;
    
    /**
     * Title: getTeachers
     * Description: �鿴��ʦͳ����Ϣ
     * @return �ο���ʦ���б�ArrayList��
     * @throws RemoteException 
     */
    public ArrayList<TeacherVO> getTeachers() throws RemoteException;
    
    /**
     * Title: getCourses
     * Description:�鿴�γ�ͳ����Ϣ
     * @return   �γ̵��б�ArrayList��
     * @throws RemoteException 
     */
    public ArrayList<CourseVO> getCourses() throws RemoteException;
    
    /**
     * Title: getTransferStudents
     * Description: �鿴ѧ��׼��׼����Ϣ
     * @return ѧ�����б�ArrayList��
     * @throws RemoteException 
     */
    public ArrayList<StudentVO> getTransferStudents() throws RemoteException;
    
    /**
     * Title: getGraduateStudents
     * Description:�鿴ѧ����ҵ�ʸ�ͳ��
     * @return  ѧ�����б�ArrayList��
     * @throws RemoteException 
     */
    public ArrayList<StudentVO> getGraduateStudents() throws RemoteException;
    
    /**
     * Title: getStayDownStudents
     * Description:�鿴������ѧ��ͳ����Ϣ
     * @return  ѧ�����б�ArrayList��
     * @throws RemoteException 
     */
    public ArrayList<StudentVO> getStayDownStudents() throws RemoteException;
    
    /**
     * Title: getDropStudents
     * Description:�鿴��ѧ��ѧ��ͳ����Ϣ
     * @return ѧ�����б�ArrayList��
     * @throws RemoteException 
     */
    public ArrayList<StudentVO> getDropStudents() throws RemoteException;
}
