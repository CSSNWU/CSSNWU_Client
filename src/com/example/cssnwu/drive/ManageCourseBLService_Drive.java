/**
 * @(#)ManageCourseBLService_Stub.java     	2013-10-13 下午11:19:26
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.drive;

import com.example.cssnwu.businesslogicservice.bl.ManageCourseBLService;
import com.example.cssnwu.stub.PrintHelper;
import com.example.cssnwu.vo.CourseVO;

/**
 *Class <code>ManageCourseBLService_Drive.java</code> ManageCourseBLService接口的驱动
 *
 * @author never
 * @version 2013-10-13
 * @since JDK1.7
 */
public class ManageCourseBLService_Drive {
    public void drive(ManageCourseBLService manageCourseBLService) {
    	PrintHelper.println(this.getClass().getName(), manageCourseBLService.addCourse(new CourseVO()).toString());
    	
    	
    }
}
