package com.example.cssnwu.businesslogicservice.bl;

import java.rmi.RemoteException;

import com.example.cssnwu.businesslogicservice.resultenum.SYSTEM_STATE;

public interface SystemStateBLService {
	/**
     * Title:checkCurrentSystemState
     * Description: 检查当前系统状态，以检查是否能进行相依操作
     * @param state
     * @return
	 * @throws RemoteException 
     */
    public boolean  checkCurrentSystemState(SYSTEM_STATE state) throws RemoteException;
}
