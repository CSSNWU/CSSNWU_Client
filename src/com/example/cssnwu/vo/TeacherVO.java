/**
 * @(#)TeacherVO.java     	2013-10-5 下午11:04:57
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.vo;

import java.util.ArrayList;

import com.example.cssnwu.businesslogicservice.resultenum.Department;

/**
 *Class <code>TeacherVO.java</code> 连接表现层和逻辑层的TeacherVO
 *
 * @author never
 * @version 2013-10-5
 * @since JDK1.7
 */
public class TeacherVO extends UserVO{
	public Department department;                //院系（部门）
    public ArrayList<Integer> courseList;       //开课课程编号列表
}
