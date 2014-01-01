/**
 * @(#)SchoolStrategyVO.java     	2013-10-10 上午9:32:23
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.vo;


/**
 *Class <code>SchoolStrategyVO.java</code> 连接表现层和逻辑层的SchoolStrategyVO
 *
 * @author never
 * @version 2013-10-10
 * @since JDK1.7
 */
public class SchoolStrategyVO extends VO {
	
	public int totalCredit;            //总学分
    public int[] minCreditPerSeason = new int[4];   //每学期最低学分要求
	
}
