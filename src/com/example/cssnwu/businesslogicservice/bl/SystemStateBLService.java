package com.example.cssnwu.businesslogicservice.bl;

import java.rmi.RemoteException;

import com.example.cssnwu.businesslogicservice.resultenum.SYSTEM_STATE;

public interface SystemStateBLService {
	/**
     * Title:checkCurrentSystemState
     * Description: ��鵱ǰϵͳ״̬���Լ���Ƿ��ܽ�����������
     * @param state
     * @return
	 * @throws RemoteException 
     */
    public boolean  checkCurrentSystemState(SYSTEM_STATE state) throws RemoteException;
}
