/**
 * @(#)DatabaseFactory_Stub.java     	2013-10-11 上午10:37:47
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.stub;

import java.rmi.RemoteException;

import com.example.cssnwu.databaseservice.DatabaseFactory;
import com.example.cssnwu.databaseservice.DatabaseService;

/**
 *Class <code>DatabaseFactory_Stub.java</code> DatabaseFactory接口的桩
 *
 * @author never
 * @version 2013-10-11
 * @since JDK1.7
 */
@SuppressWarnings("serial")
public class DatabaseFactory_Stub implements DatabaseFactory {

	/* (non-Javadoc)
	 * Title: getCourseDatabaseService
	 * Description:
	 * @see com.example.cssnwu.databaseservice.DatabaseFactory#getCourseDatabaseService()
	 */
	@Override
	public DatabaseService getCourseDatabaseService() throws RemoteException {
		PrintHelper.println(this.getClass().getName(), "getCourseDatabaseService Succeed!");
		
		DatabaseService databaseService = new DatabaseService_Stub();
		return databaseService;
	}

	/* (non-Javadoc)
	 * Title: getDeptPlanDatabaseService
	 * Description:
	 * @see com.example.cssnwu.databaseservice.DatabaseFactory#getDeptPlanDatabaseService()
	 */
	@Override
	public DatabaseService getDeptPlanDatabaseService() throws RemoteException {
		PrintHelper.println(this.getClass().getName(), "getDeptPlanDatabaseService Succeed!");
		
		DatabaseService databaseService = new DatabaseService_Stub();
		return databaseService;
	}

	/* (non-Javadoc)
	 * Title: getSchoolStrategyDatabaseService
	 * Description:
	 * @see com.example.cssnwu.databaseservice.DatabaseFactory#getSchoolStrategyDatabaseService()
	 */
	@Override
	public DatabaseService getSchoolStrategyDatabaseService()
			throws RemoteException {
		PrintHelper.println(this.getClass().getName(), "getSchoolStrategyDatabaseService Succeed!");

		DatabaseService databaseService = new DatabaseService_Stub();
		return databaseService;
	}

	/* (non-Javadoc)
	 * Title: getUserDatabaseService
	 * Description:
	 * @see com.example.cssnwu.databaseservice.DatabaseFactory#getUserDatabaseService()
	 */
	@Override
	public DatabaseService getUserDatabaseService() throws RemoteException {
		PrintHelper.println(this.getClass().getName(), "getUserDatabaseService Succeed!");

		DatabaseService databaseService = new DatabaseService_Stub();
		return databaseService;
	}

	/* (non-Javadoc)
	 * Title: getStudentDatabaseService
	 * Description:
	 * @see com.example.cssnwu.databaseservice.DatabaseFactory#getStudentDatabaseService()
	 */
	@Override
	public DatabaseService getStudentDatabaseService() throws RemoteException {
		PrintHelper.println(this.getClass().getName(), "getStudentDatabaseService Succeed!");

		DatabaseService databaseService = new DatabaseService_Stub();
		return databaseService;
	}

	/* (non-Javadoc)
	 * Title: getTeacherDatabaseService
	 * Description:
	 * @see com.example.cssnwu.databaseservice.DatabaseFactory#getTeacherDatabaseService()
	 */
	@Override
	public DatabaseService getTeacherDatabaseService() throws RemoteException {
		PrintHelper.println(this.getClass().getName(), "getTeacherDatabaseService Succeed!");

		DatabaseService databaseService = new DatabaseService_Stub();
		return databaseService;
	}

}
