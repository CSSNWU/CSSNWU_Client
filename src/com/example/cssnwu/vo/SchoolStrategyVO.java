/**
 * @(#)SchoolStrategyVO.java     	2013-10-10 上午9:32:23
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.vo;

import com.example.cssnwu.po.SchoolStrategyPO;

/**
 *Class <code>SchoolStrategyVO.java</code> 连接表现层和逻辑层的SchoolStrategyVO
 *
 * @author never
 * @version 2013-10-10
 * @since JDK1.7
 */
public class SchoolStrategyVO extends VO {
	public int totalCredit;            //总学分
    public int minCreditPerSemester;   //每学期最低学分要求
    public String creditArrangeMent;   //学分安排
	
	public SchoolStrategyPO toPO() {
		SchoolStrategyPO schoolStrategyPO = new SchoolStrategyPO();
		//TODO VO转PO
		return schoolStrategyPO;
	}
}
