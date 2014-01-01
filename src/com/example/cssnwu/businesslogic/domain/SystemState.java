package com.example.cssnwu.businesslogic.domain;

import java.rmi.RemoteException;

import com.example.cssnwu.businesslogicservice.resultenum.SYSTEM_STATE;
import com.example.cssnwu.databaseservice.DatabaseFactory;
import com.example.cssnwu.databaseservice.DatabaseService;
import com.example.cssnwu.net.ClientLaunch;

public class SystemState extends DomainObject{
	private DatabaseFactory df = null;
	private DatabaseService userDatabaseService = null;
	public SystemState() throws RemoteException
	{   df = ClientLaunch.getDatabaseFactory();
		userDatabaseService= df.getUserDatabaseService();
  
		
	}
	
	/**
     * Title:checkCurrentSystemState
     * Description: ��鵱ǰϵͳ״̬���Լ���Ƿ��ܽ�����������
     * @param state
     * @return
     */
    public boolean  checkCurrentSystemState(SYSTEM_STATE state) throws RemoteException
    {   boolean isCurrentState=false;
        
    	return userDatabaseService.checkSystemState(state);
    }
    public boolean setCurrentSystemState(SYSTEM_STATE state,boolean isUseful) throws RemoteException
    {
    	return userDatabaseService.setSystemState(state,isUseful);
    }

}
