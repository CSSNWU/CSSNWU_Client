/**
 * @(#)SchoolTeacher.java     	2013-10-10 ����10:35:06
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.businesslogic.domain;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.example.cssnwu.businesslogicservice.resultenum.INSERT_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.StudentType;
import com.example.cssnwu.businesslogicservice.resultenum.UPDATE_RESULT;
import com.example.cssnwu.databaseservice.DatabaseFactory;
import com.example.cssnwu.databaseservice.DatabaseService;
import com.example.cssnwu.net.ClientLaunch;
import com.example.cssnwu.po.CoursePO;
import com.example.cssnwu.po.DepartmentPlanPO;
import com.example.cssnwu.po.PO;
import com.example.cssnwu.po.SchoolStrategyPO;
import com.example.cssnwu.po.StudentPO;
import com.example.cssnwu.po.TeacherPO;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.DepartmentPlanVO;
import com.example.cssnwu.vo.SchoolStrategyVO;
import com.example.cssnwu.vo.StudentVO;
import com.example.cssnwu.vo.TeacherVO;
import com.example.cssnwu.vo.VO;
import com.example.cssnwu.vo.VoToPo;

/**
 *Class <code>SchoolTeacher.java</code> ѧУ������ʦ��������
 *
 * @author never
 * @version 2013-10-10
 * @since JDK1.7
 */
public class SchoolTeacher extends DomainObject {
	private DatabaseFactory df = null;
	private DatabaseService strategyDatabaseService = null;
	private DatabaseService deptPlanDatabaseService = null;
	private DatabaseService teacherDatabaseService = null;
	private DatabaseService studentDatabaseService = null;
	private DatabaseService courseDatabaseService = null;

	public SchoolTeacher() throws RemoteException {
		df = ClientLaunch.getDatabaseFactory();
		strategyDatabaseService = df.getSchoolStrategyDatabaseService();
		deptPlanDatabaseService = df.getDeptPlanDatabaseService();
		teacherDatabaseService = df.getTeacherDatabaseService();
		studentDatabaseService = df.getStudentDatabaseService();
		courseDatabaseService = df.getCourseDatabaseService();
	}

	/**
	 * Title: realseSchoolStrategy
	 * Description:���������ܲ���
	 * @param schoolStrategyVO  SchoolStrategyVO
	 * @return           ��������Ľ��
	 * @throws RemoteException 
	 */
	public INSERT_RESULT realseSchoolStrategy(SchoolStrategyVO schoolStrategyVO) throws RemoteException {
		//ͨ��ID�鿴�Ƿ��Ѵ���
		if(strategyDatabaseService.find(schoolStrategyVO.id) != null) {
			return INSERT_RESULT.ID�Ѿ�����;
		} else {
			//�жϲ�������Ƿ�ɹ�
			if(strategyDatabaseService.insert(VoToPo.transformSchoolStrategyVO(schoolStrategyVO))) {
				return INSERT_RESULT.����ɹ�;
			} else {
				return INSERT_RESULT.�������˴���;
			}
		}
	}

	/**
	 * Title: modifySchoolStrategy
	 * Description:�޸������ܲ���
	 * @param schoolStrategyVO   SchoolStrategyVO
	 * @return       ���²����Ľ��
	 * @throws RemoteException 
	 */
	public UPDATE_RESULT modifySchoolStrategy(SchoolStrategyVO schoolStrategyVO) throws RemoteException {
		//�жϸ����Ƿ�ɹ�
		if(strategyDatabaseService.update(VoToPo.transformSchoolStrategyVO(schoolStrategyVO))) {
			return UPDATE_RESULT.���³ɹ�;
		} else {
			return UPDATE_RESULT.�������˴���;
		}
	}

	/**
	 * Title: getSchoolStrategy
	 * Description: �鿴�����ܲ���
	 * @return  SchoolStrategyVO
	 * @throws RemoteException 
	 */
	public SchoolStrategyVO getSchoolStrategy() throws RemoteException {
		SchoolStrategyVO schoolStrategyVO = null;
		//��ȡ��ѧ�ڵĽ�ѧ�ƻ�
		ArrayList<PO> list = strategyDatabaseService.find(ManageCourse.getNowSemester());

		if(list.size() > 0) {
			schoolStrategyVO = PoToVo.transformSchoolStrategyPO((SchoolStrategyPO)list.get(0));
		}

		return schoolStrategyVO;
	}

	/**
	 * Title: getDepartmentPlans
	 * Description:  �鿴��Ժϵ��ѧ�ƻ�
	 * @return  ��ѧ�ƻ����б�ArrayList��
	 * @throws RemoteException 
	 */
	public ArrayList<DepartmentPlanVO> getDepartmentPlans() throws RemoteException {
		ArrayList<DepartmentPlanVO> departmentPlanVOList = new ArrayList<DepartmentPlanVO>(); 

		//��ȡ����Ժϵ�ƻ�
		ArrayList<PO> deptmentPlanList = deptPlanDatabaseService.findAll();

		//poתΪVO
		for(PO po:deptmentPlanList) {
			DepartmentPlanVO departmentPlanVO = PoToVo.transformDepartPlanPO((DepartmentPlanPO)po);
			departmentPlanVOList.add(departmentPlanVO); 
		}

		return departmentPlanVOList;
	}

	/**
	 * Title: getTeachers
	 * Description: �鿴��ʦͳ����Ϣ
	 * @return �ο���ʦ���б�ArrayList��
	 * @throws RemoteException 
	 */
	public ArrayList<TeacherVO> getTeachers() throws RemoteException {
		ArrayList<TeacherVO> teacherVOList = new ArrayList<TeacherVO>(); 

		//��ȡ�����ο���ʦ��Ϣ
		ArrayList<PO> teacherPOList = teacherDatabaseService.findAll();

		//poתΪVO
		for(PO po:teacherPOList) {
			teacherVOList.add(PoToVo.transformTeacherPO((TeacherPO)po)); 
		}

		return teacherVOList;
	}

	/**
	 * Title: getCourses
	 * Description:�鿴�γ�ͳ����Ϣ
	 * @return   �γ̵��б�ArrayList��
	 * @throws RemoteException 
	 */
	public ArrayList<CourseVO> getCourses() throws RemoteException {
		ArrayList<CourseVO> courseVOList = new ArrayList<CourseVO>(); 

		//��ȡ���пγ���Ϣ
		ArrayList<PO> coursePOList = courseDatabaseService.findAll();

		//poתΪVO
		for(PO po:coursePOList) {
			courseVOList.add(PoToVo.transformCoursePO((CoursePO)po)); 
		}

		return courseVOList;
	}


	/**
	 * Title: getTransferStudents
	 * Description: �鿴ѧ��׼��׼����Ϣ
	 * @return ѧ�����б�ArrayList��
	 * @throws RemoteException 
	 */
	public ArrayList<StudentVO> getTransferStudents() throws RemoteException {
		return getTargetStudents(StudentType.Transfer.toString());
	}

	/**
	 * Title: getGraduateStudents
	 * Description:�鿴ѧ����ҵ�ʸ�ͳ��
	 * @return  ѧ�����б�ArrayList��
	 * @throws RemoteException 
	 */
	public ArrayList<StudentVO> getGraduateStudents() throws RemoteException {
		return getTargetStudents(StudentType.Graduate.toString());
	}

	/**
	 * Title: getStayDownStudents
	 * Description:�鿴������ѧ��ͳ����Ϣ
	 * @return  ѧ�����б�ArrayList��
	 * @throws RemoteException 
	 */
	public ArrayList<StudentVO> getStayDownStudents() throws RemoteException {
		return getTargetStudents(StudentType.StayDown.toString());
	}

	/**
	 * Title: getDropStudents
	 * Description:�鿴��ѧ��ѧ��ͳ����Ϣ
	 * @return ѧ�����б�ArrayList��
	 * @throws RemoteException 
	 */
	public ArrayList<StudentVO> getDropStudents() throws RemoteException {
         return getTargetStudents(StudentType.Drop.toString());
	}
	/**
	 * Title: addNewStudent
	 * Description:�����µ�ѧ��
	 * @return
	 */
	public boolean addNewStudent(ArrayList<VO> list) throws RemoteException
	{        
		for(VO studentVO:list)
		{
	       studentDatabaseService.insert(VoToPo.transformStudentVO(((StudentVO)studentVO)));
	 
		}
		return true;
	}
	public ArrayList<StudentVO> getTargetStudents(String key) throws RemoteException {
		ArrayList<StudentVO> studentVOList = new ArrayList<StudentVO>();

		//��ȡ���з���Ҫ���ѧ����Ϣ
		ArrayList<PO> studentPOList = studentDatabaseService.find(key);
		if(studentPOList==null)
		{
			System.out.println("is null");
		}
        System.out.println(studentPOList.size());
		//poתΪVO
		if(!studentPOList.isEmpty())
		{  for(PO po:studentPOList) {
			studentVOList.add(PoToVo.transformStudentPO((StudentPO)po)); 
		   }
		}

		return studentVOList;
	}
}

