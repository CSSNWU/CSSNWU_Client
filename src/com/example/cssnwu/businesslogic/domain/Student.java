/**
 * @(#)Student.java     	2013-10-9 下午3:06:14
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.businesslogic.domain;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.example.cssnwu.businesslogicservice.resultenum.TRANSFER_RESULT;
import com.example.cssnwu.databaseservice.DatabaseFactory;
import com.example.cssnwu.databaseservice.DatabaseService;
import com.example.cssnwu.net.ClientLaunch;
import com.example.cssnwu.po.CoursePO;
import com.example.cssnwu.po.StudentPO;
import com.example.cssnwu.vo.CourseVO;

/**
 *Class <code>Student.java</code> 学生的领域类
 *
 * @author never
 * @version 2013-10-9
 * @since JDK1.7
 */
public class Student extends DomainObject {
	private DatabaseFactory df = null;
	private DatabaseService studentDatabaseService = null;

	public Student() throws RemoteException{
		df = ClientLaunch.getDatabaseFactory();
		studentDatabaseService = df.getStudentDatabaseService();
	}

	/**
	 * Title: getCourses
	 * Description:       通过ID获取该学生的课程列表
	 * @param studentId   学生ID
	 * @return            学生的课程列表（ArrayList）
	 * @throws RemoteException 
	 */
	public ArrayList<CourseVO> getCourses(int studentId) throws RemoteException {
		ArrayList<CourseVO> voList = new ArrayList<CourseVO>();

		//通过ID查询学生
		StudentPO studentPO = (StudentPO) studentDatabaseService.find(studentId);

		//PO转化为VO
		for(CoursePO coursePO:studentPO.getCoursePOList()) {
			voList.add(PoToVo.transformCoursePO(coursePO));
			System.out.println(coursePO.getScore());
		}

		return voList;
	}

	/**
	 * Title: getCoursesBySemester
	 * Description: 根据学期查看学生课程
	 * @param studentId 学生ID
	 * @param semester 学期
	 * @return     课程的列表（ArrayList）
	 * @throws RemoteException 
	 */
	public ArrayList<CourseVO> getCoursesBySemester(int studentId,String semester) throws RemoteException {
		ArrayList<CourseVO> voList = new ArrayList<CourseVO>();

		//通过ID查询学生
		StudentPO studentPO = (StudentPO) studentDatabaseService.find(studentId);

		//PO转化为VO
//		for(CoursePO coursePO:studentPO.getCourseList()) {
//			//判断学期是否符合
//			if(coursePO.getEstablishTime().equals(semester)) {
//				voList.add(PoToVo.transformCoursePO(coursePO));
//			}
//		}

		return voList;
	}
	
	
    /**
     * Title: getTransferInfo
     * Description: 查看准入准出信息
     * @param studentId  学生ID
     * @return    准入准出信息结果
     * @throws RemoteException 
     */
    public TRANSFER_RESULT getTransferInfo(int studentId) throws RemoteException {
    	//通过ID查询学生
		StudentPO studentPO = (StudentPO) studentDatabaseService.find(studentId);
		
		//TODO 判断准入准出策略的逻辑
		return null;
    	
    }
}
