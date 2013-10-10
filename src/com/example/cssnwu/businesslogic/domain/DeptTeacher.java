/**
 * @(#)DeptTeacher.java     	2013-10-9 下午10:32:57
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.businesslogic.domain;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.example.cssnwu.businesslogicservice.resultenum.Department;
import com.example.cssnwu.businesslogicservice.resultenum.INSERT_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.UPDATE_RESULT;
import com.example.cssnwu.databaseservice.DatabaseFactory;
import com.example.cssnwu.databaseservice.DatabaseService;
import com.example.cssnwu.net.ClientLaunch;
import com.example.cssnwu.po.CoursePO;
import com.example.cssnwu.po.PO;
import com.example.cssnwu.po.StudentPO;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.DepartmentPlanVO;
import com.example.cssnwu.vo.StudentVO;
import com.example.cssnwu.vo.VoToPo;

/**
 *Class <code>DeptTeacher.java</code> 院系教务老师领域类
 *
 * @author never
 * @version 2013-10-9
 * @since JDK1.7
 */
public class DeptTeacher extends DomainObject {
	private DatabaseFactory df = null;
	private DatabaseService courseDatabaseService = null;
	private DatabaseService deptPlanDatabaseService = null;

	public DeptTeacher() throws RemoteException{
		df = ClientLaunch.getDatabaseFactory();
        courseDatabaseService = df.getCourseDatabaseService();
        deptPlanDatabaseService = df.getDeptPlanDatabaseService();
	}
	
	/**
     * Title: drawDeptPlan
     * Description: 制定院系教学计划
     * @param departmentPlanVO  院系教学计划VO  
     * @return  制定计划操作是否成功（boolean）
	 * @throws RemoteException 
     */
    public INSERT_RESULT drawDeptPlan(DepartmentPlanVO departmentPlanVO) throws RemoteException {
    	//判断该编号是否已经使用
    	if(deptPlanDatabaseService.find(departmentPlanVO.id) != null) {
    		return INSERT_RESULT.ID已经存在;
    	}
    	//判断插入是否成功
    	if(deptPlanDatabaseService.insert(departmentPlanVO.toPO())) {
    		return INSERT_RESULT.插入成功;
    	} else {
    		return INSERT_RESULT.服务器端错误;
    	}
    }
    
    /**
     * Title: releaseCourse
     * Description:   发布课程
     * @param courseVO CourseVO
     * @return       发布课程操作结果
     * @throws RemoteException 
     */
    public INSERT_RESULT releaseCourse(CourseVO courseVO) throws RemoteException {
    	//根据课程编号判断是否已经存在该课程
    	if(courseDatabaseService.find(courseVO.id) != null ) {
    		return INSERT_RESULT.ID已经存在;
    	}
    	
    	//判断插入是否成功
    	if(courseDatabaseService.insert(VoToPo.transformCourseVO(courseVO))) {
    		return INSERT_RESULT.插入成功;
    	} else {
    		return INSERT_RESULT.服务器端错误;
    	}
    }
    
    /**
     * Title: modifyCourseInfo
     * Description: 修改课程信息
     * @param courseVO  CourseVO
     * @return  修改操作结果
     * @throws RemoteException 
     */
    public UPDATE_RESULT modifyCourseInfo(CourseVO courseVO) throws RemoteException {
    	CoursePO coursePO = VoToPo.transformCourseVO(courseVO);
    	
    	//判断服务器端更新是否成功
    	if(courseDatabaseService.update(coursePO)) {
    		return UPDATE_RESULT.更新成功;
    	} else {
    		return UPDATE_RESULT.服务器端错误;
    	}
    }
    
    /**
     * Title: getDeptCourses
     * Description: 查看本院课程列表
     * @param department  院系
     * @return   本院所有课程的列表（arrayList）
     * @throws RemoteException 
     */
    public ArrayList<CourseVO> getDeptCourses(Department department) throws RemoteException {
        ArrayList<CourseVO> voList = new ArrayList<CourseVO>();
        
        ArrayList<PO> poList = courseDatabaseService.find(department.toString());
        //将PO转成VO
        for(PO po:poList) {
        	CourseVO studentVO = PoToVo.transformCoursePO((CoursePO)po);
        	voList.add(studentVO);
        }
        
        return voList;
    }
    
    /**
     * Title: getCourse
     * Description:     查看本院任意课程信息
     * @param courseId  课程ID
     * @return          CourseVO
     * @throws RemoteException 
     */
    public CourseVO getCourse(int courseId) throws RemoteException {
    	CoursePO coursePO = (CoursePO) courseDatabaseService.find(courseId);
    	return PoToVo.transformCoursePO(coursePO);
    }
    
    /**
     * Title: getStuByCourse
     * Description: 查看本院任意课程的学生列表
     * @param courseId 课程ID
     * @param department 院系
     * @return 任意课程的学生列表（ArrayList）
     * @throws RemoteException 
     */
    public ArrayList<StudentVO> getStuByCourse(int courseId,Department department) throws RemoteException {
        ArrayList<StudentVO> voList = new ArrayList<StudentVO>();
        
        ArrayList<PO> poList = courseDatabaseService.findAll(courseId);
        //将PO转成VO
        for(PO po:poList) {
        	//判断院系
        	if(((StudentPO)po).getDepartment() == department) {
        		StudentVO studentVO = PoToVo.transformStudentPO((StudentPO) po);
            	voList.add(studentVO);
        	}
        }
        return voList;
    }
}
