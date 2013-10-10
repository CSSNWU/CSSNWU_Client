/**
 * @(#)DeptTeacher.java     	2013-10-9 ����10:32:57
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.businesslogic.domain;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.example.cssnwu.businesslogicservice.resultenum.Department;
import com.example.cssnwu.businesslogicservice.resultenum.INSERT_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.UPDATE_RESULT;
import com.example.cssnwu.databaseservice.DatabaseFactory;
import com.example.cssnwu.databaseservice.DatabaseService;
import com.example.cssnwu.net.ClientLaunch;
import com.example.cssnwu.po.CoursePO;
import com.example.cssnwu.po.PO;
import com.example.cssnwu.po.StudentPO;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.DepartmentPlanVO;
import com.example.cssnwu.vo.StudentVO;
import com.example.cssnwu.vo.VoToPo;

/**
 *Class <code>DeptTeacher.java</code> Ժϵ������ʦ������
 *
 * @author never
 * @version 2013-10-9
 * @since JDK1.7
 */
public class DeptTeacher extends DomainObject {
	private DatabaseFactory df = null;
	private DatabaseService courseDatabaseService = null;
	private DatabaseService deptPlanDatabaseService = null;

	public DeptTeacher() throws RemoteException{
		df = ClientLaunch.getDatabaseFactory();
        courseDatabaseService = df.getCourseDatabaseService();
        deptPlanDatabaseService = df.getDeptPlanDatabaseService();
	}
	
	/**
     * Title: drawDeptPlan
     * Description: �ƶ�Ժϵ��ѧ�ƻ�
     * @param departmentPlanVO  Ժϵ��ѧ�ƻ�VO  
     * @return  �ƶ��ƻ������Ƿ�ɹ���boolean��
	 * @throws RemoteException 
     */
    public INSERT_RESULT drawDeptPlan(DepartmentPlanVO departmentPlanVO) throws RemoteException {
    	//�жϸñ���Ƿ��Ѿ�ʹ��
    	if(deptPlanDatabaseService.find(departmentPlanVO.id) != null) {
    		return INSERT_RESULT.ID�Ѿ�����;
    	}
    	//�жϲ����Ƿ�ɹ�
    	if(deptPlanDatabaseService.insert(departmentPlanVO.toPO())) {
    		return INSERT_RESULT.����ɹ�;
    	} else {
    		return INSERT_RESULT.�������˴���;
    	}
    }
    
    /**
     * Title: releaseCourse
     * Description:   �����γ�
     * @param courseVO CourseVO
     * @return       �����γ̲������
     * @throws RemoteException 
     */
    public INSERT_RESULT releaseCourse(CourseVO courseVO) throws RemoteException {
    	//���ݿγ̱���ж��Ƿ��Ѿ����ڸÿγ�
    	if(courseDatabaseService.find(courseVO.id) != null ) {
    		return INSERT_RESULT.ID�Ѿ�����;
    	}
    	
    	//�жϲ����Ƿ�ɹ�
    	if(courseDatabaseService.insert(VoToPo.transformCourseVO(courseVO))) {
    		return INSERT_RESULT.����ɹ�;
    	} else {
    		return INSERT_RESULT.�������˴���;
    	}
    }
    
    /**
     * Title: modifyCourseInfo
     * Description: �޸Ŀγ���Ϣ
     * @param courseVO  CourseVO
     * @return  �޸Ĳ������
     * @throws RemoteException 
     */
    public UPDATE_RESULT modifyCourseInfo(CourseVO courseVO) throws RemoteException {
    	CoursePO coursePO = VoToPo.transformCourseVO(courseVO);
    	
    	//�жϷ������˸����Ƿ�ɹ�
    	if(courseDatabaseService.update(coursePO)) {
    		return UPDATE_RESULT.���³ɹ�;
    	} else {
    		return UPDATE_RESULT.�������˴���;
    	}
    }
    
    /**
     * Title: getDeptCourses
     * Description: �鿴��Ժ�γ��б�
     * @param department  Ժϵ
     * @return   ��Ժ���пγ̵��б�arrayList��
     * @throws RemoteException 
     */
    public ArrayList<CourseVO> getDeptCourses(Department department) throws RemoteException {
        ArrayList<CourseVO> voList = new ArrayList<CourseVO>();
        
        ArrayList<PO> poList = courseDatabaseService.find(department.toString());
        //��POת��VO
        for(PO po:poList) {
        	CourseVO studentVO = PoToVo.transformCoursePO((CoursePO)po);
        	voList.add(studentVO);
        }
        
        return voList;
    }
    
    /**
     * Title: getCourse
     * Description:     �鿴��Ժ����γ���Ϣ
     * @param courseId  �γ�ID
     * @return          CourseVO
     * @throws RemoteException 
     */
    public CourseVO getCourse(int courseId) throws RemoteException {
    	CoursePO coursePO = (CoursePO) courseDatabaseService.find(courseId);
    	return PoToVo.transformCoursePO(coursePO);
    }
    
    /**
     * Title: getStuByCourse
     * Description: �鿴��Ժ����γ̵�ѧ���б�
     * @param courseId �γ�ID
     * @param department Ժϵ
     * @return ����γ̵�ѧ���б�ArrayList��
     * @throws RemoteException 
     */
    public ArrayList<StudentVO> getStuByCourse(int courseId,Department department) throws RemoteException {
        ArrayList<StudentVO> voList = new ArrayList<StudentVO>();
        
        ArrayList<PO> poList = courseDatabaseService.findAll(courseId);
        //��POת��VO
        for(PO po:poList) {
        	//�ж�Ժϵ
        	if(((StudentPO)po).getDepartment() == department) {
        		StudentVO studentVO = PoToVo.transformStudentPO((StudentPO) po);
            	voList.add(studentVO);
        	}
        }
        return voList;
    }
}
