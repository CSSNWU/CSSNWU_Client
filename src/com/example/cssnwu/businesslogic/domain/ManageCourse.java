/**
 * @(#)ManageCourse.java     	2013-10-9 下午3:05:21
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.businesslogic.domain;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import com.example.cssnwu.businesslogicservice.resultenum.ADD_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.CourseType;
import com.example.cssnwu.businesslogicservice.resultenum.DELETE_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.MANAGE_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.ManageCourseType;
import com.example.cssnwu.databaseservice.DatabaseFactory;
import com.example.cssnwu.databaseservice.DatabaseService;
import com.example.cssnwu.net.ClientLaunch;
import com.example.cssnwu.po.CoursePO;
import com.example.cssnwu.po.StudentPO;
import com.example.cssnwu.vo.CourseVO;
import com.example.cssnwu.vo.ManageCourseVO;
import com.example.cssnwu.vo.VoToPo;

/**
 *Class <code>ManageCourse.java</code> 管理课程领域对象
 *
 * @author never
 * @version 2013-10-9
 * @since JDK1.7
 */
public class ManageCourse extends DomainObject{
    private DatabaseFactory df = null;
    private DatabaseService userDatabaseService = null;
    public static ManageCourseVO manageCourseVO = new ManageCourseVO();
    private ArrayList<CourseVO> selectedList = new ArrayList<CourseVO>();   //已经选择的课程列表
    
    public ManageCourse() throws RemoteException{
    	df = ClientLaunch.getDatabaseFactory();
    	userDatabaseService = df.getUserDatabaseService();
    	
    }
    
    /**
     * Title: getSelectedCourses
     * Description:通过id获取该学生已经选择的课程列表
     * @param studentId  用户ID
     * @return
     * @throws RemoteException
     */
    public ArrayList<CourseVO> getSelectedCourses(int studentId) throws RemoteException {
    	ArrayList<CourseVO> list = new ArrayList<CourseVO>();
    	//通过id查询用户
    	StudentPO studentPO = (StudentPO) userDatabaseService.find(studentId);
    	
    	//判断用户是否存在
    	if(studentPO != null) {
    		for(CoursePO coursePO:studentPO.getCourseList()) {
    			//判断学生课程列表中本学期已经选择的课程
    			if(coursePO.getEstablishTime().equals(getNowSemester())) {
    				selectedList.add(PoToVo.transformCoursePO(coursePO));
    			}
    		}
    	} 

    	return list;
    }
    
    /**
     * Title: addStudent
     * Description:      开始管理课程时，添加将要执行操作的学生
     * @param studentId  用户ID  
     * @return           操作的结果
     * @throws RemoteException
     */
    public ADD_RESULT addStudent(int studentId) throws RemoteException {
    	//通过id查询用户
    	StudentPO studentPO = (StudentPO) userDatabaseService.find(studentId);
    	
    	//判断用户是否存在
    	if(studentPO == null) {
    		return ADD_RESULT.操作失败;
    	} else {
    		manageCourseVO.studentVO = PoToVo.transformStudentPO(studentPO);
    		getSelectedCourses(studentId);    //初始化已选课程列表
    		return ADD_RESULT.添加成功;
    	}
    }
    
    /**
     * Title: addManageType
     * Description:开始管理课程时，添加管理课程操作的类型
     * @param manageCourseType  管理课程类型
     * @return  操作的结果
     */
    public ADD_RESULT addManageType(ManageCourseType manageCourseType) {
    	//判断有木有添加执行管理操作的学生
    	if(manageCourseVO.studentVO != null) {
    		manageCourseVO.manageCourseType = manageCourseType;
    		return ADD_RESULT.添加成功;
    	} else {
    		return ADD_RESULT.操作失败;
    	}
		
	}
    
    
    /**
     * Title: addCourse
     * Description:在进行课程管理时，往将要被管理的课程列表中添加课程
     * @param courseVO
     * @return 添加课程操作的结果
     */
    public ADD_RESULT addCourse(CourseVO courseVO) {
    	//判断有木有添加执行管理操作的学生和操作类型
    	if((manageCourseVO.studentVO != null) && (manageCourseVO.manageCourseType != null)) {
    		
    		//添加课程到列表中的操作要区分操作类型
    		if(manageCourseVO.manageCourseType == ManageCourseType.select) {   //选课操作
    			
    			//判断添加的课程是否冲突
    			ADD_RESULT result = judgeSelectionCollision(courseVO);
    			if(result == ADD_RESULT.添加成功) {
    				manageCourseVO.courseList.add(courseVO);
    				selectedList.add(courseVO);
    			}
    			
    			return result;
    			
    		} else {  //如果是退课操作
    			//判断课程类型是否可以退选
    			if(courseVO.courseType == CourseType.指选课) {
    				return ADD_RESULT.课程是直选课程不可退选;
    			} else {
    				manageCourseVO.courseList.add(courseVO);
    				return ADD_RESULT.添加成功;
    			}
    		}
    		
    	} else {
    		return ADD_RESULT.操作失败;
    	}
    	
	}
    
    /**
     * Title: deleteCourse
     * Description:  在进行课程管理时，从将要管理的课程列表中删除课程
     * @param courseVO  CourseVO
     * @return 删除课程的结果
     */
    public DELETE_RESULT deleteCourse(CourseVO courseVO) {
    	//判断有木有添加执行管理操作的学生和操作类型
    	if((manageCourseVO.studentVO != null) && (manageCourseVO.manageCourseType != null)) {
    			manageCourseVO.courseList.remove(courseVO);
    			selectedList.remove(courseVO);
    			return DELETE_RESULT.删除成功;
    			
    	} else {
    		return DELETE_RESULT.删除失败;
    	}
    }
    
    /**
     * Title: endManage
     * Description: 结束课程管理操作，将请求提交服务器
     * @param vo    ManageCourseVO
     * @return    提交结束管理课程操作的结果
     * @throws RemoteException 
     */
    public MANAGE_RESULT endManage(ManageCourseVO vo) throws RemoteException {
    	//通过id查询该用户
    	StudentPO studentPO = (StudentPO) userDatabaseService.find(manageCourseVO.studentVO.id);
    	//判断用户是否存在
    	if(studentPO == null) {
    		return MANAGE_RESULT.用户不存在;
    	} else {
    		//更新studentPO中的课程列表
    		//判断管理课程类型
    	    if(manageCourseVO.manageCourseType == ManageCourseType.select) {   //选课操作
    	        for(CourseVO courseVO:manageCourseVO.courseList) {
    	        	studentPO.getCourseList().add(VoToPo.transformCourseVO(courseVO));
    	        }
    	    } else {   //退选操作                  
    	    	for(CourseVO courseVO:manageCourseVO.courseList) {           
    	        	studentPO.getCourseList().remove(VoToPo.transformCourseVO(courseVO));
    	        }
    	    }
    	    
    	    //提交数据库
    	    if(userDatabaseService.update(studentPO)) {
    	    	manageCourseVO = null;
    	    	return MANAGE_RESULT.操作成功;
    	    } else {
    	    	return MANAGE_RESULT.服务器端错误;
    	    }
    	}
    }
    
    /**
     * Title: getNowSemester
     * Description: 获取现在时间所在的学期
     * @return String(年份+ 1【上学期】 OR 2【下学期】)
     */
    public static String getNowSemester() {
    	String nowTime = null;
    	
    	//获取现在时间
    	Calendar calendar = Calendar.getInstance();
    	
    	//获取年份
    	int nowYear = calendar.get(Calendar.YEAR);
    	
    	//获取学期(此处可能需要根据学校制定的时间确定)
    	int nowMonth = calendar.get(Calendar.MONTH);
    	if(nowMonth >= 8) {
    		nowTime = nowYear + "1";
    	} else {
    		nowTime = (nowYear-1) + "2";
    	}
    	
    	return nowTime;
    }
    
    /**
     * Title: judgeSelectionCollision
     * Description:       选课时判断选择的课程是否和已有课程是否冲突。
     * @param courseVO    CourseVO
     * @return            操作的结果
     */
    public ADD_RESULT judgeSelectionCollision(CourseVO courseVO) {
    	// TODO Auto-generated method stub
    	return ADD_RESULT.添加成功;
    }
   

}
