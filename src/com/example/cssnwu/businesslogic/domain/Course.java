/**
 * @(#)Course.java     	2013-10-5 ����4:09:11
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
 *Class <code>Course.java</code> Course������
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
	 * Description:  ��ȡ���еĿγ��б�
	 * @return  �γ̵�ArrayList
	 * @throws RemoteException 
	 */
	public ArrayList<CourseVO> getAllCourse() throws RemoteException {
		ArrayList<CourseVO> courseVOList = new ArrayList<CourseVO>();

		//��ȡ���пγ�
		ArrayList<PO> coursePOList = courseDatabaseService.findAll();

		//poת��Ϊvo
		for(PO po:coursePOList) {
			courseVOList.add(PoToVo.transformCoursePO((CoursePO)po));
		}


		return courseVOList;
	}

	/**
	 * Title: getCourseByType
	 * Description:        ��ȡĳ�����͵Ŀγ��б�
	 * @param courseType   �γ�����
	 * @return             ĳһ���Ϳγ̵����ArrayList��
	 * @throws RemoteException 
	 */
	public ArrayList<CourseVO> getCourseByType(CourseType courseType) throws RemoteException {
		ArrayList<CourseVO> courseVOList = new ArrayList<CourseVO>();

		//��ȡ���пγ�
		ArrayList<PO> coursePOList = courseDatabaseService.find(courseType.toString());

		//poת��Ϊvo
		for(PO po:coursePOList) {
			courseVOList.add(PoToVo.transformCoursePO((CoursePO)po));
		}

		return courseVOList;
	}

	/**
	 * Title: getCourseById
	 * Description:   ͨ����Ż�ȡ�γ�
	 * @param id      ID
	 * @return        CourseVO��Ϊ�ձ�ʾ�����ڰ����ùؼ��ֵĿγ̣�
	 * @throws RemoteException 
	 */
	public CourseVO getCourseById(int id) throws RemoteException {
		CoursePO coursePO = (CoursePO)courseDatabaseService.find(id);
		return PoToVo.transformCoursePO(coursePO);
	}
	
	
}
