/**
 * @(#)ManageCourseBLService_Stub.java     	2013-10-13 下午12:08:16
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.example.cssnwu.businesslogicservice.bl.ManageCourseBLService;
import com.example.cssnwu.businesslogicservice.resultenum.ADD_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.DELETE_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.MANAGE_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.ManageCourseType;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.ManageCourseVO;

/**
 *Class <code>ManageCourseBLService_Stub.java</code> ManageCourseBLService接口的桩.
 *
 * @author never
 * @version 2013-10-13
 * @since JDK1.7
 */
public class ManageCourseBLService_Stub implements ManageCourseBLService {

	/* (non-Javadoc)
	 * Title: getSelectedCourses
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.ManageCourseBLService#getSelectedCourses(int)
	 */
	@Override
	public ArrayList<CourseVO> getSelectedCourses(int studentId)
			throws RemoteException {
		return null;
//		return new DataHelper().studentVOs.get(0).courseList;
	}

	/* (non-Javadoc)
	 * Title: addStudent
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.ManageCourseBLService#addStudent(int)
	 */
	@Override
	public ADD_RESULT addStudent(int studentId) throws RemoteException {
		if (studentId == 1000) {
			return ADD_RESULT.添加成功;
		} else {
			return ADD_RESULT.操作失败;
		}
	}

	/* (non-Javadoc)
	 * Title: addManageType
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.ManageCourseBLService#addManageType(com.example.cssnwu.businesslogicservice.resultenum.ManageCourseType)
	 */
	@Override
	public ADD_RESULT addManageType(ManageCourseType manageCourseType) {
		if (manageCourseType == ManageCourseType.select) {
			return ADD_RESULT.添加成功;
		} else {
			return ADD_RESULT.操作失败;
		}
	}

	/* (non-Javadoc)
	 * Title: addCourse
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.ManageCourseBLService#addCourse(com.example.cssnwu.vo.CourseVO)
	 */
	@Override
	public ADD_RESULT addCourse(CourseVO courseVO) {
		if (courseVO.id == 0) {
			return ADD_RESULT.添加成功;
		} else {
			return ADD_RESULT.操作失败;
		}
	}

	/* (non-Javadoc)
	 * Title: deleteCourse
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.ManageCourseBLService#deleteCourse(com.example.cssnwu.vo.CourseVO)
	 */
	@Override
	public DELETE_RESULT deleteCourse(CourseVO courseVO) {
		if (courseVO.id == 0) {
			return DELETE_RESULT.删除成功;
		} else {
			return DELETE_RESULT.删除失败;
		}
	}

	/* (non-Javadoc)
	 * Title: endManage
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.ManageCourseBLService#endManage(com.example.cssnwu.vo.ManageCourseVO)
	 */
//	@Override
//	public MANAGE_RESULT endManage(ManageCourseVO manageCourseVO)
//			throws RemoteException {
//         if (manageCourseVO.id == 10) {
//        	 return MANAGE_RESULT.操作成功;
//         } else {
//        	 return MANAGE_RESULT.服务器端错误;
//         }
//              
//	}

	@Override
	public MANAGE_RESULT endManage() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
