/**
 * @(#)CourseBLService_Stub.java     	2013-10-13 上午11:21:26
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.example.cssnwu.businesslogicservice.bl.CourseBLService;
import com.example.cssnwu.businesslogicservice.resultenum.CourseType;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.StudentVO;

/**
 *Class <code>CourseBLService_Stub.java</code> CourseBLService接口的桩
 *
 * @author never
 * @version 2013-10-13
 * @since JDK1.7
 */
public class CourseBLService_Stub implements CourseBLService{

	/* (non-Javadoc)
	 * Title: getAllCourse
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.CourseBLService#getAllCourse()
	 */
	@Override
	public ArrayList<CourseVO> getAllCourse() throws RemoteException {
		return new DataHelper().courseVOs;
	}

	/* (non-Javadoc)
	 * Title: getCourseByType
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.CourseBLService#getCourseByType(com.example.cssnwu.businesslogicservice.resultenum.CourseType)
	 */
	@Override
	public ArrayList<CourseVO> getCourseByType(CourseType courseType)
			throws RemoteException {
		ArrayList<CourseVO> courseVOs = new ArrayList<CourseVO>();
		if (courseType == CourseType.公选课) {
			courseVOs = new DataHelper().courseVOs;
		}
		return courseVOs;
	}

	/* (non-Javadoc)
	 * Title: getCourseById
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.CourseBLService#getCourseById(int)
	 */
	@Override
	public CourseVO getCourseById(int id) throws RemoteException {
		return new DataHelper().courseVOs.get(id);
	}

	/* (non-Javadoc)
	 * Title: getStuByCourseId
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.CourseBLService#getStuByCourseId(int)
	 */
	@Override
	public ArrayList<StudentVO> getStuByCourseId(int courseId)
			throws RemoteException {
		ArrayList<StudentVO> studentVOs = new ArrayList<StudentVO>();
	    if (courseId == 0) {
	    	studentVOs = new DataHelper().studentVOs;
	    }
		return studentVOs;
	}

}
