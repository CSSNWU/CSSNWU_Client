/**
 * @(#)ManageCourse.java     	2013-10-9 ����3:05:21
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.businesslogic.domain;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import com.example.cssnwu.businesslogicservice.resultenum.ADD_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.CourseType;
import com.example.cssnwu.businesslogicservice.resultenum.DELETE_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.MANAGE_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.ManageCourseType;
import com.example.cssnwu.databaseservice.DatabaseFactory;
import com.example.cssnwu.databaseservice.DatabaseService;
import com.example.cssnwu.net.ClientLaunch;
import com.example.cssnwu.po.CoursePO;
import com.example.cssnwu.po.StudentPO;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.ManageCourseVO;
import com.example.cssnwu.vo.VoToPo;

/**
 *Class <code>ManageCourse.java</code> ����γ��������
 *
 * @author never
 * @version 2013-10-9
 * @since JDK1.7
 */
public class ManageCourse extends DomainObject{
    private DatabaseFactory df = null;
    private DatabaseService userDatabaseService = null;
    public static ManageCourseVO manageCourseVO = new ManageCourseVO();
    private ArrayList<CourseVO> selectedList = new ArrayList<CourseVO>();   //�Ѿ�ѡ��Ŀγ��б�
    
    public ManageCourse() throws RemoteException{
    	df = ClientLaunch.getDatabaseFactory();
    	userDatabaseService = df.getUserDatabaseService();
    	
    }
    
    /**
     * Title: getSelectedCourses
     * Description:ͨ��id��ȡ��ѧ���Ѿ�ѡ��Ŀγ��б�
     * @param studentId  �û�ID
     * @return
     * @throws RemoteException
     */
    public ArrayList<CourseVO> getSelectedCourses(int studentId) throws RemoteException {
    	ArrayList<CourseVO> list = new ArrayList<CourseVO>();
    	//ͨ��id��ѯ�û�
    	StudentPO studentPO = (StudentPO) userDatabaseService.find(studentId);
    	
    	//�ж��û��Ƿ����
    	if(studentPO != null) {
    		for(CoursePO coursePO:studentPO.getCourseList()) {
    			//�ж�ѧ���γ��б��б�ѧ���Ѿ�ѡ��Ŀγ�
    			if(coursePO.getEstablishTime().equals(getNowSemester())) {
    				selectedList.add(PoToVo.transformCoursePO(coursePO));
    			}
    		}
    	} 

    	return list;
    }
    
    /**
     * Title: addStudent
     * Description:      ��ʼ����γ�ʱ����ӽ�Ҫִ�в�����ѧ��
     * @param studentId  �û�ID  
     * @return           �����Ľ��
     * @throws RemoteException
     */
    public ADD_RESULT addStudent(int studentId) throws RemoteException {
    	//ͨ��id��ѯ�û�
    	StudentPO studentPO = (StudentPO) userDatabaseService.find(studentId);
    	
    	//�ж��û��Ƿ����
    	if(studentPO == null) {
    		return ADD_RESULT.����ʧ��;
    	} else {
    		manageCourseVO.studentVO = PoToVo.transformStudentPO(studentPO);
    		getSelectedCourses(studentId);    //��ʼ����ѡ�γ��б�
    		return ADD_RESULT.��ӳɹ�;
    	}
    }
    
    /**
     * Title: addManageType
     * Description:��ʼ����γ�ʱ����ӹ���γ̲���������
     * @param manageCourseType  ����γ�����
     * @return  �����Ľ��
     */
    public ADD_RESULT addManageType(ManageCourseType manageCourseType) {
    	//�ж���ľ�����ִ�й��������ѧ��
    	if(manageCourseVO.studentVO != null) {
    		manageCourseVO.manageCourseType = manageCourseType;
    		return ADD_RESULT.��ӳɹ�;
    	} else {
    		return ADD_RESULT.����ʧ��;
    	}
		
	}
    
    
    /**
     * Title: addCourse
     * Description:�ڽ��пγ̹���ʱ������Ҫ������Ŀγ��б�����ӿγ�
     * @param courseVO
     * @return ��ӿγ̲����Ľ��
     */
    public ADD_RESULT addCourse(CourseVO courseVO) {
    	//�ж���ľ�����ִ�й��������ѧ���Ͳ�������
    	if((manageCourseVO.studentVO != null) && (manageCourseVO.manageCourseType != null)) {
    		
    		//��ӿγ̵��б��еĲ���Ҫ���ֲ�������
    		if(manageCourseVO.manageCourseType == ManageCourseType.select) {   //ѡ�β���
    			
    			//�ж���ӵĿγ��Ƿ��ͻ
    			ADD_RESULT result = judgeSelectionCollision(courseVO);
    			if(result == ADD_RESULT.��ӳɹ�) {
    				manageCourseVO.courseList.add(courseVO);
    				selectedList.add(courseVO);
    			}
    			
    			return result;
    			
    		} else {  //������˿β���
    			//�жϿγ������Ƿ������ѡ
    			if(courseVO.courseType == CourseType.ָѡ��) {
    				return ADD_RESULT.�γ���ֱѡ�γ̲�����ѡ;
    			} else {
    				manageCourseVO.courseList.add(courseVO);
    				return ADD_RESULT.��ӳɹ�;
    			}
    		}
    		
    	} else {
    		return ADD_RESULT.����ʧ��;
    	}
    	
	}
    
    /**
     * Title: deleteCourse
     * Description:  �ڽ��пγ̹���ʱ���ӽ�Ҫ����Ŀγ��б���ɾ���γ�
     * @param courseVO  CourseVO
     * @return ɾ���γ̵Ľ��
     */
    public DELETE_RESULT deleteCourse(CourseVO courseVO) {
    	//�ж���ľ�����ִ�й��������ѧ���Ͳ�������
    	if((manageCourseVO.studentVO != null) && (manageCourseVO.manageCourseType != null)) {
    			manageCourseVO.courseList.remove(courseVO);
    			selectedList.remove(courseVO);
    			return DELETE_RESULT.ɾ���ɹ�;
    			
    	} else {
    		return DELETE_RESULT.ɾ��ʧ��;
    	}
    }
    
    /**
     * Title: endManage
     * Description: �����γ̹���������������ύ������
     * @param vo    ManageCourseVO
     * @return    �ύ��������γ̲����Ľ��
     * @throws RemoteException 
     */
    public MANAGE_RESULT endManage(ManageCourseVO vo) throws RemoteException {
    	//ͨ��id��ѯ���û�
    	StudentPO studentPO = (StudentPO) userDatabaseService.find(manageCourseVO.studentVO.id);
    	//�ж��û��Ƿ����
    	if(studentPO == null) {
    		return MANAGE_RESULT.�û�������;
    	} else {
    		//����studentPO�еĿγ��б�
    		//�жϹ���γ�����
    	    if(manageCourseVO.manageCourseType == ManageCourseType.select) {   //ѡ�β���
    	        for(CourseVO courseVO:manageCourseVO.courseList) {
    	        	studentPO.getCourseList().add(VoToPo.transformCourseVO(courseVO));
    	        }
    	    } else {   //��ѡ����                  
    	    	for(CourseVO courseVO:manageCourseVO.courseList) {           
    	        	studentPO.getCourseList().remove(VoToPo.transformCourseVO(courseVO));
    	        }
    	    }
    	    
    	    //�ύ���ݿ�
    	    if(userDatabaseService.update(studentPO)) {
    	    	manageCourseVO = null;
    	    	return MANAGE_RESULT.�����ɹ�;
    	    } else {
    	    	return MANAGE_RESULT.�������˴���;
    	    }
    	}
    }
    
    /**
     * Title: getNowSemester
     * Description: ��ȡ����ʱ�����ڵ�ѧ��
     * @return String(���+ 1����ѧ�ڡ� OR 2����ѧ�ڡ�)
     */
    public static String getNowSemester() {
    	String nowTime = null;
    	
    	//��ȡ����ʱ��
    	Calendar calendar = Calendar.getInstance();
    	
    	//��ȡ���
    	int nowYear = calendar.get(Calendar.YEAR);
    	
    	//��ȡѧ��(�˴�������Ҫ����ѧУ�ƶ���ʱ��ȷ��)
    	int nowMonth = calendar.get(Calendar.MONTH);
    	if(nowMonth >= 8) {
    		nowTime = nowYear + "1";
    	} else {
    		nowTime = (nowYear-1) + "2";
    	}
    	
    	return nowTime;
    }
    
    /**
     * Title: judgeSelectionCollision
     * Description:       ѡ��ʱ�ж�ѡ��Ŀγ��Ƿ�����пγ��Ƿ��ͻ��
     * @param courseVO    CourseVO
     * @return            �����Ľ��
     */
    public ADD_RESULT judgeSelectionCollision(CourseVO courseVO) {
    	// TODO Auto-generated method stub
    	return ADD_RESULT.��ӳɹ�;
    }
   

}
