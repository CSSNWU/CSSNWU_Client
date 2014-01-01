/**
 * @(#)SchoolTeacherBLService_Stub.java     	2013-10-13 上午11:39:21
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.example.cssnwu.businesslogicservice.bl.SchoolTeacherBLService;
import com.example.cssnwu.businesslogicservice.resultenum.INSERT_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.UPDATE_RESULT;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.DepartmentPlanVO;
import com.example.cssnwu.vo.SchoolStrategyVO;
import com.example.cssnwu.vo.StudentVO;
import com.example.cssnwu.vo.TeacherVO;
import com.example.cssnwu.vo.VO;

/**
 *Class <code>SchoolTeacherBLService_Stub.java</code> SchoolTeacherBLService接口的桩.
 *
 * @author never
 * @version 2013-10-13
 * @since JDK1.7
 */
public class SchoolTeacherBLService_Stub implements SchoolTeacherBLService {

	/* (non-Javadoc)
	 * Title: realseSchoolStrategy
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.SchoolTeacherBLService#realseSchoolStrategy(com.example.cssnwu.vo.SchoolStrategyVO)
	 */
	@Override
	public INSERT_RESULT realseSchoolStrategy(SchoolStrategyVO schoolStrategyVO)
			throws RemoteException {
		if (schoolStrategyVO.id == 2001) {
			return INSERT_RESULT.插入成功;
		} else {
			return INSERT_RESULT.ID已经存在;
		}
	}

	/* (non-Javadoc)
	 * Title: modifySchoolStrategy
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.SchoolTeacherBLService#modifySchoolStrategy(com.example.cssnwu.vo.SchoolStrategyVO)
	 */
	@Override
	public UPDATE_RESULT modifySchoolStrategy(SchoolStrategyVO schoolStrategyVO)
			throws RemoteException {
		if (schoolStrategyVO.id == 2001) {
			return UPDATE_RESULT.更新成功;
		} else {
			return UPDATE_RESULT.服务器端错误;
		}
	}

	/* (non-Javadoc)
	 * Title: getSchoolStrategy
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.SchoolTeacherBLService#getSchoolStrategy()
	 */
	@Override
	public SchoolStrategyVO getSchoolStrategy() throws RemoteException {
		return new DataHelper().schoolStrategyVO;
	}

	/* (non-Javadoc)
	 * Title: getDepartmentPlans
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.SchoolTeacherBLService#getDepartmentPlans()
	 */
	@Override
	public ArrayList<DepartmentPlanVO> getDepartmentPlans()
			throws RemoteException {
		return new DataHelper().departmentPlanVOs;
	}

	/* (non-Javadoc)
	 * Title: getTeachers
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.SchoolTeacherBLService#getTeachers()
	 */
	@Override
	public ArrayList<TeacherVO> getTeachers() throws RemoteException {
		return new DataHelper().teacherVOs;
	}

	/* (non-Javadoc)
	 * Title: getCourses
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.SchoolTeacherBLService#getCourses()
	 */
	@Override
	public ArrayList<CourseVO> getCourses() throws RemoteException {
		return new DataHelper().courseVOs;
	}

	/* (non-Javadoc)
	 * Title: getTransferStudents
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.SchoolTeacherBLService#getTransferStudents()
	 */
	@Override
	public ArrayList<StudentVO> getTransferStudents() throws RemoteException {
		ArrayList<StudentVO> studentVOs = new ArrayList<StudentVO>();
		studentVOs.add(new DataHelper().studentVOs.get(0));
		studentVOs.add(new DataHelper().studentVOs.get(1));
		return studentVOs;
	}

	/* (non-Javadoc)
	 * Title: getGraduateStudents
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.SchoolTeacherBLService#getGraduateStudents()
	 */
	@Override
	public ArrayList<StudentVO> getGraduateStudents() throws RemoteException {
		ArrayList<StudentVO> studentVOs = new ArrayList<StudentVO>();
		studentVOs.add(new DataHelper().studentVOs.get(2));
		studentVOs.add(new DataHelper().studentVOs.get(3));
		return studentVOs;
	}

	/* (non-Javadoc)
	 * Title: getStayDownStudents
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.SchoolTeacherBLService#getStayDownStudents()
	 */
	@Override
	public ArrayList<StudentVO> getStayDownStudents() throws RemoteException {
		ArrayList<StudentVO> studentVOs = new ArrayList<StudentVO>();
		studentVOs.add(new DataHelper().studentVOs.get(4));
		studentVOs.add(new DataHelper().studentVOs.get(5));
		return studentVOs;
	}

	/* (non-Javadoc)
	 * Title: getDropStudents
	 * Description:
	 * @see com.example.cssnwu.businesslogicservice.bl.SchoolTeacherBLService#getDropStudents()
	 */
	@Override
	public ArrayList<StudentVO> getDropStudents() throws RemoteException {
		ArrayList<StudentVO> studentVOs = new ArrayList<StudentVO>();
		studentVOs.add(new DataHelper().studentVOs.get(6));
		studentVOs.add(new DataHelper().studentVOs.get(7));
		return studentVOs;
	}

	@Override
	public boolean addNewStudent(ArrayList<VO> list) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
