/**
 * @(#)SchoolTeacher.java     	2013-10-10 上午10:35:06
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
 *Class <code>SchoolTeacher.java</code> 学校教务老师的领域类
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
	 * Description:输入整体框架策略
	 * @param schoolStrategyVO  SchoolStrategyVO
	 * @return           插入操作的结果
	 * @throws RemoteException 
	 */
	public INSERT_RESULT realseSchoolStrategy(SchoolStrategyVO schoolStrategyVO) throws RemoteException {
		//通过ID查看是否已存在
		if(strategyDatabaseService.find(schoolStrategyVO.id) != null) {
			return INSERT_RESULT.ID已经存在;
		} else {
			//判断插入操作是否成功
			if(strategyDatabaseService.insert(VoToPo.transformSchoolStrategyVO(schoolStrategyVO))) {
				return INSERT_RESULT.插入成功;
			} else {
				return INSERT_RESULT.服务器端错误;
			}
		}
	}

	/**
	 * Title: modifySchoolStrategy
	 * Description:修改整体框架策略
	 * @param schoolStrategyVO   SchoolStrategyVO
	 * @return       更新操作的结果
	 * @throws RemoteException 
	 */
	public UPDATE_RESULT modifySchoolStrategy(SchoolStrategyVO schoolStrategyVO) throws RemoteException {
		//判断更新是否成功
		if(strategyDatabaseService.update(VoToPo.transformSchoolStrategyVO(schoolStrategyVO))) {
			return UPDATE_RESULT.更新成功;
		} else {
			return UPDATE_RESULT.服务器端错误;
		}
	}

	/**
	 * Title: getSchoolStrategy
	 * Description: 查看整体框架策略
	 * @return  SchoolStrategyVO
	 * @throws RemoteException 
	 */
	public SchoolStrategyVO getSchoolStrategy() throws RemoteException {
		SchoolStrategyVO schoolStrategyVO = null;
		//获取本学期的教学计划
		ArrayList<PO> list = strategyDatabaseService.find(ManageCourse.getNowSemester());

		if(list.size() > 0) {
			schoolStrategyVO = PoToVo.transformSchoolStrategyPO((SchoolStrategyPO)list.get(0));
		}

		return schoolStrategyVO;
	}

	/**
	 * Title: getDepartmentPlans
	 * Description:  查看各院系教学计划
	 * @return  教学计划的列表（ArrayList）
	 * @throws RemoteException 
	 */
	public ArrayList<DepartmentPlanVO> getDepartmentPlans() throws RemoteException {
		ArrayList<DepartmentPlanVO> departmentPlanVOList = new ArrayList<DepartmentPlanVO>(); 

		//获取所有院系计划
		ArrayList<PO> deptmentPlanList = deptPlanDatabaseService.findAll();

		//po转为VO
		for(PO po:deptmentPlanList) {
			DepartmentPlanVO departmentPlanVO = PoToVo.transformDepartPlanPO((DepartmentPlanPO)po);
			departmentPlanVOList.add(departmentPlanVO); 
		}

		return departmentPlanVOList;
	}

	/**
	 * Title: getTeachers
	 * Description: 查看教师统计信息
	 * @return 任课老师的列表（ArrayList）
	 * @throws RemoteException 
	 */
	public ArrayList<TeacherVO> getTeachers() throws RemoteException {
		ArrayList<TeacherVO> teacherVOList = new ArrayList<TeacherVO>(); 

		//获取所有任课老师信息
		ArrayList<PO> teacherPOList = teacherDatabaseService.findAll();

		//po转为VO
		for(PO po:teacherPOList) {
			teacherVOList.add(PoToVo.transformTeacherPO((TeacherPO)po)); 
		}

		return teacherVOList;
	}

	/**
	 * Title: getCourses
	 * Description:查看课程统计信息
	 * @return   课程的列表（ArrayList）
	 * @throws RemoteException 
	 */
	public ArrayList<CourseVO> getCourses() throws RemoteException {
		ArrayList<CourseVO> courseVOList = new ArrayList<CourseVO>(); 

		//获取所有课程信息
		ArrayList<PO> coursePOList = courseDatabaseService.findAll();

		//po转为VO
		for(PO po:coursePOList) {
			courseVOList.add(PoToVo.transformCoursePO((CoursePO)po)); 
		}

		return courseVOList;
	}


	/**
	 * Title: getTransferStudents
	 * Description: 查看学生准入准出信息
	 * @return 学生的列表（ArrayList）
	 * @throws RemoteException 
	 */
	public ArrayList<StudentVO> getTransferStudents() throws RemoteException {
		return getTargetStudents(StudentType.Transfer.toString());
	}

	/**
	 * Title: getGraduateStudents
	 * Description:查看学生毕业资格统计
	 * @return  学生的列表（ArrayList）
	 * @throws RemoteException 
	 */
	public ArrayList<StudentVO> getGraduateStudents() throws RemoteException {
		return getTargetStudents(StudentType.Graduate.toString());
	}

	/**
	 * Title: getStayDownStudents
	 * Description:查看留级的学生统计信息
	 * @return  学生的列表（ArrayList）
	 * @throws RemoteException 
	 */
	public ArrayList<StudentVO> getStayDownStudents() throws RemoteException {
		return getTargetStudents(StudentType.StayDown.toString());
	}

	/**
	 * Title: getDropStudents
	 * Description:查看退学的学生统计信息
	 * @return 学生的列表（ArrayList）
	 * @throws RemoteException 
	 */
	public ArrayList<StudentVO> getDropStudents() throws RemoteException {
         return getTargetStudents(StudentType.Drop.toString());
	}
	/**
	 * Title: addNewStudent
	 * Description:增加新的学生
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

		//获取所有符合要求的学生信息
		ArrayList<PO> studentPOList = studentDatabaseService.find(key);
		if(studentPOList==null)
		{
			System.out.println("is null");
		}
        System.out.println(studentPOList.size());
		//po转为VO
		if(!studentPOList.isEmpty())
		{  for(PO po:studentPOList) {
			studentVOList.add(PoToVo.transformStudentPO((StudentPO)po)); 
		   }
		}

		return studentVOList;
	}
}

