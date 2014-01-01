/**
 * @(#)TeacherBLService_Stub.java     	2013-10-11 下午12:07:03.
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.cssnwu.businesslogicservice.bl.TeacherBLService;
import com.example.cssnwu.businesslogicservice.resultenum.UPDATE_RESULT;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.StudentVO;

/**
 *Class <code>TeacherBLService_Stub.java</code> TeacherBLService接口的桩.
 *
 * @author never
 * @version 2013-10-11
 * @since JDK1.7
 */
public class TeacherBLService_Stub implements TeacherBLService {

	/* (non-Javadoc)
	 * Title: getStuByCourseId
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.TeacherBLService#getStuByCourseId(int)
	 */
	@Override
	public ArrayList<StudentVO> getStuByCourseId(int courseId)
			throws RemoteException {
		ArrayList<StudentVO> studentVOs = new ArrayList<StudentVO>();
		if (courseId == 1) {
			for (int i = 0; i < 5; i++) {
				studentVOs.add(new DataHelper().studentVOs.get(i));
			}
			
		}
		return studentVOs;
	}

	/* (non-Javadoc)
	 * Title: updateCourseInfo
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.TeacherBLService#updateCourseInfo(com.example.cssnwu.vo.CourseVO)
	 */
	@Override
	public UPDATE_RESULT updateCourseInfo(CourseVO courseVO)
			throws RemoteException {
		if (courseVO.id == 0) {
			return UPDATE_RESULT.更新成功;
		} else {
			return UPDATE_RESULT.服务器端错误;
		}
	}

	/* (non-Javadoc)
	 * Title: registerScore
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.TeacherBLService#registerScore(int, java.util.HashMap)
	 */
	@Override
	public UPDATE_RESULT registerScore(int courseId,
			HashMap<Integer, Double> map) throws RemoteException {
		if (courseId == 0) {
			return UPDATE_RESULT.更新成功;
		} else {
			return UPDATE_RESULT.服务器端错误;
		}
		
	}

}
