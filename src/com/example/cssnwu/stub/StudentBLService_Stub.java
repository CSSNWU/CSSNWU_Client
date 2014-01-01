/**
 * @(#)StudentBLService_Stub.java     	2013-10-11 上午10:45:03
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.example.cssnwu.businesslogicservice.bl.StudentBLService;
import com.example.cssnwu.businesslogicservice.resultenum.TRANSFER_RESULT;
import com.example.cssnwu.po.CoursePO;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.VoToPo;

/**
 *Class <code>StudentBLService_Stub.java</code> StudentBLService接口的桩
 *
 * @author never
 * @version 2013-10-11
 * @since JDK1.7
 */
public class StudentBLService_Stub implements StudentBLService {

	/* (non-Javadoc)
	 * Title: getCourses
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.StudentBLService#getCourses(int)
	 */
	@Override
	public ArrayList<CourseVO> getCourses(int studentId) throws RemoteException {
		ArrayList<CourseVO> courseVOs = new ArrayList<CourseVO>();
		if(studentId == 1001) {
			for(int i=0;i<8;i++) {
				courseVOs.add(new DataHelper().courseVOs.get(i));
			}
		}
		return courseVOs;
	}
	/////////////////////////////////////////////////////zhangtian 13.11.26
	////////////返回PO的getCourse方法
	public ArrayList<CoursePO> getCoursesOfPO(int studentId) throws RemoteException{
		ArrayList<CoursePO> coursePOs=new ArrayList<CoursePO>();
		if(studentId == 1001) {
			for(int i=0;i<8;i++) {
				coursePOs.add(VoToPo.transformCourseVO(new DataHelper().courseVOs.get(i)));
			}
		}
		return  coursePOs;
	}
	
	
	
	
	
	
	
	
	
	//////////////////////////////////////////////////////////////////////

	/* (non-Javadoc)
	 * Title: getTransferInfo
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.StudentBLService#getTransferInfo(int)
	 */
	@Override
	public TRANSFER_RESULT getTransferInfo(int studentId)
			throws RemoteException {
		if(studentId == 1001) {
			return TRANSFER_RESULT.可以转院;
		} else {
			return TRANSFER_RESULT.准出学分不够;
		}

	}

	/* (non-Javadoc)
	 * Title: getCoursesBySemester
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.StudentBLService#getCoursesBySemester(int, java.lang.String)
	 */
	@Override
	public ArrayList<CourseVO> getCoursesBySemester(int studentId,
			String semester) throws RemoteException {
		ArrayList<CourseVO> courseVOs = new ArrayList<CourseVO>();
		if(studentId == 1001) {
			for(int i=0;i<10;i++) {
		        courseVOs.add(new DataHelper().courseVOs.get(i));
			}
		}
		return courseVOs;
	}
	////////////////////////////////////////////////张天  2013.11.26

	public ArrayList<CoursePO> getCoursesBySemesterOfPO(int studentId,
			String semester) throws RemoteException {
		ArrayList<CoursePO> coursePOs = new ArrayList<CoursePO>();
		if(studentId == 1001) {
			for(int i=0;i<10;i++) {
		        coursePOs.add(VoToPo.transformCourseVO(new DataHelper().courseVOs.get(i)));
			}
		}
		return coursePOs;
	}
	
	
	
	
	
	/////////////////////////////////////////////////////

}
