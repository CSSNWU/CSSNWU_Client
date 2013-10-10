/**
 * @(#)DepartmentPlanVO.java     	2013-10-8 下午7:37:23
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.vo;

import java.util.ArrayList;
import java.util.Date;

import com.example.cssnwu.businesslogicservice.resultenum.Department;
import com.example.cssnwu.po.DepartmentPlanPO;

/**
 *Class <code>DepartmentPlanVO.java</code> 连接表现层和逻辑层的DepartmentPlanVO
 *
 * @author never
 * @version 2013-10-8
 * @since JDK1.7
 */
public class DepartmentPlanVO extends VO {
	public Date date;                           //年份
	public Department department;               //院系
    public ArrayList<CourseVO> courseList;      //课程安排
    
	public DepartmentPlanPO toPO() {
		DepartmentPlanPO departmentPlanPO = new DepartmentPlanPO();
		
		return departmentPlanPO;
	}
}
