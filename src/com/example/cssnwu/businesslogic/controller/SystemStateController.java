package com.example.cssnwu.businesslogic.controller;

import java.rmi.RemoteException;

import com.example.cssnwu.businesslogic.domain.SystemState;
import com.example.cssnwu.businesslogicservice.bl.SystemStateBLService;
import com.example.cssnwu.businesslogicservice.resultenum.SYSTEM_STATE;

public class SystemStateController implements SystemStateBLService {
    private SystemState systemState=null;
    public SystemStateController() throws RemoteException
    {
    	 systemState=new SystemState();
    }
    
	@Override
	public boolean checkCurrentSystemState(SYSTEM_STATE state)throws RemoteException {
		// TODO Auto-generated method stub
		return systemState.checkCurrentSystemState(state);
	}
	public boolean setCurrentSystemState(SYSTEM_STATE state,boolean isUseful) throws RemoteException
	{ 
		return systemState.setCurrentSystemState(state, isUseful);
	}
	

}
