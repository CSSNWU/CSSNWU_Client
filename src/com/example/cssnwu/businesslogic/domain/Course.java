/**
 * @(#)Course.java     	2013-10-5 下午4:09:11
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.businesslogic.domain;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.example.cssnwu.businesslogicservice.resultenum.CourseType;
import com.example.cssnwu.databaseservice.DatabaseFactory;
import com.example.cssnwu.databaseservice.DatabaseService;
import com.example.cssnwu.net.ClientLaunch;
import com.example.cssnwu.po.CoursePO;
import com.example.cssnwu.po.PO;
import com.example.cssnwu.vo.CourseVO;

/**
 *Class <code>Course.java</code> Course领域类
 *
 * @author never
 * @version 2013-10-5
 * @since JDK1.7
 */
public class Course extends DomainObject{
	private DatabaseFactory df = null;
	private DatabaseService courseDatabaseService = null;


	public Course() throws RemoteException {
		df = ClientLaunch.getDatabaseFactory();
		courseDatabaseService = df.getCourseDatabaseService();		
	}

	/**
	 * Title: getAllCourse
	 * Description:  获取所有的课程列表
	 * @return  课程的ArrayList
	 * @throws RemoteException 
	 */
	public ArrayList<CourseVO> getAllCourse() throws RemoteException {
		ArrayList<CourseVO> courseVOList = new ArrayList<CourseVO>();

		//获取所有课程
		ArrayList<PO> coursePOList = courseDatabaseService.findAll();

		//po转化为vo
		for(PO po:coursePOList) {
			courseVOList.add(PoToVo.transformCoursePO((CoursePO)po));
		}


		return courseVOList;
	}

	/**
	 * Title: getCourseByType
	 * Description:        获取某个类型的课程列表
	 * @param courseType   课程类型
	 * @return             某一类型课程的类表（ArrayList）
	 * @throws RemoteException 
	 */
	public ArrayList<CourseVO> getCourseByType(CourseType courseType) throws RemoteException {
		ArrayList<CourseVO> courseVOList = new ArrayList<CourseVO>();

		//获取所有课程
		ArrayList<PO> coursePOList = courseDatabaseService.find(courseType.toString());

		//po转化为vo
		for(PO po:coursePOList) {
			courseVOList.add(PoToVo.transformCoursePO((CoursePO)po));
		}

		return courseVOList;
	}

	/**
	 * Title: getCourseById
	 * Description:   通过编号获取课程
	 * @param id      ID
	 * @return        CourseVO（为空表示不存在包含该关键字的课程）
	 * @throws RemoteException 
	 */
	public CourseVO getCourseById(int id) throws RemoteException {
		CoursePO coursePO = (CoursePO)courseDatabaseService.find(id);
		return PoToVo.transformCoursePO(coursePO);
	}
	
	
}
