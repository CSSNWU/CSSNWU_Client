/**
 * @(#)TeacherBLService.java     	2013-10-5 ����3:01:07
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
 *Class <code>TeacherBLService.java</code> ���ӱ��ֲ���߼�����ο���ʦ�����йصĽӿ�
 *
 * @author never
 * @version 2013-10-5
 * @since JDK1.7
 */
public interface TeacherBLService {
    /**
     * Title: getStuByCourseId
     * Description:��ȡѡ��ĳ�ſε�ѧ���б�
     * @param courseId     �γ�ID
     * @return    ѡ��ĳ�ſε�ѧ���б�ArrayList��
     * @throws RemoteException 
     */
    public ArrayList<StudentVO> getStuByCourseId(int courseId) throws RemoteException;
    
    /**
     * Title: updateCourseInfo
     * Description: �ο���ʦ��д�γ���Ϣ���γ̴�١��̡̳��ο���Ŀ��
     * @param courseVO  CourseVO
     * @return   ���²����Ľ��
     * @throws RemoteException 
     */
    public UPDATE_RESULT updateCourseInfo(CourseVO courseVO) throws RemoteException;
    
    /**
     * Title: registerScore
     * Description:     �ο���ʦ�Ǽǳɼ�
     * @param courseId  �γ�ID
     * @param map       ѧ��ID����ɼ���HashMap
     * @return          ���²����Ľ��
     * @throws RemoteException 
     */
    public UPDATE_RESULT registerScore(int courseId,HashMap<Integer, Double> map) throws RemoteException;
    
}
