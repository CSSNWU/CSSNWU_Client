/**
 * @(#)Teacher.java     	2013-10-9 ����8:50:57
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.businesslogic.domain;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.cssnwu.businesslogicservice.resultenum.UPDATE_RESULT;
import com.example.cssnwu.databaseservice.DatabaseFactory;
import com.example.cssnwu.databaseservice.DatabaseService;
import com.example.cssnwu.net.ClientLaunch;
import com.example.cssnwu.po.CoursePO;
import com.example.cssnwu.po.PO;
import com.example.cssnwu.po.StudentPO;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.StudentVO;
import com.example.cssnwu.vo.VoToPo;

/**
 *Class <code>Teacher.java</code> �ο���ʦ��������
 *
 * @author never
 * @version 2013-10-9
 * @since JDK1.7
 */
public class Teacher extends DomainObject {
	private DatabaseFactory df = null;
	private DatabaseService courseDatabaseService = null;
	

	public Teacher() throws RemoteException{
		df = ClientLaunch.getDatabaseFactory();
        courseDatabaseService = df.getCourseDatabaseService();
	}
	
    /**
     * Title: getStuByCourseId
     * Description:��ȡѡ��ĳ�ſε�ѧ���б�
     * @param courseId     �γ�ID
     * @return    ѡ��ĳ�ſε�ѧ���б�ArrayList��
     * @throws RemoteException 
     */
    public ArrayList<StudentVO> getStuByCourseId(int courseId) throws RemoteException {
        ArrayList<StudentVO> voList = new ArrayList<StudentVO>();
        
        ArrayList<PO> poList = courseDatabaseService.findAll(courseId);
        //��POת��VO
        for(PO po:poList) {
        	StudentVO studentVO = PoToVo.transformStudentPO((StudentPO) po);
        	voList.add(studentVO);
        }
        
        return voList;
    }
    
    /**
     * Title: updateCourseInfo
     * Description: �ο���ʦ��д�γ���Ϣ���γ̴�١��̡̳��ο���Ŀ��
     * @param courseVO  CourseVO
     * @return   ���²����Ľ��
     * @throws RemoteException 
     */
    public UPDATE_RESULT updateCourseInfo(CourseVO courseVO) throws RemoteException {
    	CoursePO coursePO = VoToPo.transformCourseVO(courseVO);
    	
    	//�жϷ������˸����Ƿ�ɹ�
    	if(courseDatabaseService.update(coursePO)) {
    		return UPDATE_RESULT.���³ɹ�;
    	} else {
    		return UPDATE_RESULT.�������˴���;
    	}
    }
    
    /**
     * Title: registerScore
     * Description:     �ο���ʦ�Ǽǳɼ�
     * @param courseId  �γ�ID
     * @param map       ѧ��ID����ɼ���HashMap
     * @return          ���²����Ľ��
     * @throws RemoteException 
     */
    public UPDATE_RESULT registerScore(int courseId,HashMap<Integer, Double> map) throws RemoteException {
        //�жϷ��������Ƿ���³ɹ�
    	if(courseDatabaseService.update(courseId, map)) {
    		return UPDATE_RESULT.���³ɹ�;
    	} else {
    		return UPDATE_RESULT.�������˴���;
    	}
    }
}
