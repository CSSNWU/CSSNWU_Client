/**
 * @(#)Teacher.java     	2013-10-9 下午8:50:57
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.businesslogic.domain;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.cssnwu.businesslogicservice.resultenum.UPDATE_RESULT;
import com.example.cssnwu.databaseservice.DatabaseFactory;
import com.example.cssnwu.databaseservice.DatabaseService;
import com.example.cssnwu.net.ClientLaunch;
import com.example.cssnwu.po.CoursePO;
import com.example.cssnwu.po.PO;
import com.example.cssnwu.po.StudentPO;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.StudentVO;
import com.example.cssnwu.vo.VoToPo;

/**
 *Class <code>Teacher.java</code> 任课老师的领域类
 *
 * @author never
 * @version 2013-10-9
 * @since JDK1.7
 */
public class Teacher extends DomainObject {
	private DatabaseFactory df = null;
	private DatabaseService courseDatabaseService = null;
	

	public Teacher() throws RemoteException{
		df = ClientLaunch.getDatabaseFactory();
        courseDatabaseService = df.getCourseDatabaseService();
	}
	
    /**
     * Title: getStuByCourseId
     * Description:获取选择某门课的学生列表
     * @param courseId     课程ID
     * @return    选择某门课的学生列表（ArrayList）
     * @throws RemoteException 
     */
    public ArrayList<StudentVO> getStuByCourseId(int courseId) throws RemoteException {
        ArrayList<StudentVO> voList = new ArrayList<StudentVO>();
        
        ArrayList<PO> poList = courseDatabaseService.findAll(courseId);
        //将PO转成VO
        for(PO po:poList) {
        	StudentVO studentVO = PoToVo.transformStudentPO((StudentPO) po);
        	voList.add(studentVO);
        }
        
        return voList;
    }
    
    /**
     * Title: updateCourseInfo
     * Description: 任课老师填写课程信息（课程大纲、教程、参考书目）
     * @param courseVO  CourseVO
     * @return   更新操作的结果
     * @throws RemoteException 
     */
    public UPDATE_RESULT updateCourseInfo(CourseVO courseVO) throws RemoteException {
    	CoursePO coursePO = VoToPo.transformCourseVO(courseVO);
    	
    	//判断服务器端更新是否成功
    	if(courseDatabaseService.update(coursePO)) {
    		return UPDATE_RESULT.更新成功;
    	} else {
    		return UPDATE_RESULT.服务器端错误;
    	}
    }
    
    /**
     * Title: registerScore
     * Description:     任课老师登记成绩
     * @param courseId  课程ID
     * @param map       学生ID和其成绩的HashMap
     * @return          更新操作的结果
     * @throws RemoteException 
     */
    public UPDATE_RESULT registerScore(int courseId,HashMap<Integer, Double> map) throws RemoteException {
        //判断服务器端是否更新成功
    	if(courseDatabaseService.update(courseId, map)) {
    		return UPDATE_RESULT.更新成功;
    	} else {
    		return UPDATE_RESULT.服务器端错误;
    	}
    }
}
