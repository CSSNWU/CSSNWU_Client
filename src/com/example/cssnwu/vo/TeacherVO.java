/**
 * @(#)TeacherVO.java     	2013-10-5 ����11:04:57
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.vo;

import java.util.ArrayList;

import com.example.cssnwu.businesslogicservice.resultenum.Department;

/**
 *Class <code>TeacherVO.java</code> ���ӱ��ֲ���߼����TeacherVO
 *
 * @author never
 * @version 2013-10-5
 * @since JDK1.7
 */
public class TeacherVO extends UserVO{
	public Department department;                //Ժϵ�����ţ�
    public ArrayList<Integer> courseList;       //���ογ̱���б�
}
