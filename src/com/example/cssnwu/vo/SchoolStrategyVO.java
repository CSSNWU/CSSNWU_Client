/**
 * @(#)SchoolStrategyVO.java     	2013-10-10 ����9:32:23
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.vo;

import com.example.cssnwu.po.SchoolStrategyPO;

/**
 *Class <code>SchoolStrategyVO.java</code> ���ӱ��ֲ���߼����SchoolStrategyVO
 *
 * @author never
 * @version 2013-10-10
 * @since JDK1.7
 */
public class SchoolStrategyVO extends VO {
	public int totalCredit;            //��ѧ��
    public int minCreditPerSemester;   //ÿѧ�����ѧ��Ҫ��
    public String creditArrangeMent;   //ѧ�ְ���
	
	public SchoolStrategyPO toPO() {
		SchoolStrategyPO schoolStrategyPO = new SchoolStrategyPO();
		//TODO VOתPO
		return schoolStrategyPO;
	}
}
