/**
 * @(#)DepartmentPlanVO.java     	2013-10-8 ����7:37:23
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.vo;

import java.util.ArrayList;
import java.util.Date;

import com.example.cssnwu.businesslogicservice.resultenum.Department;
import com.example.cssnwu.po.DepartmentPlanPO;

/**
 *Class <code>DepartmentPlanVO.java</code> ���ӱ��ֲ���߼����DepartmentPlanVO
 *
 * @author never
 * @version 2013-10-8
 * @since JDK1.7
 */
public class DepartmentPlanVO extends VO {
	public Date date;                           //���
	public Department department;               //Ժϵ
    public ArrayList<CourseVO> courseList;      //�γ̰���
    
	public DepartmentPlanPO toPO() {
		DepartmentPlanPO departmentPlanPO = new DepartmentPlanPO();
		
		return departmentPlanPO;
	}
}
