/**
 * @(#)DatabaseService_Stub.java     	2013-10-11 上午10:19:09
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.cssnwu.businesslogicservice.resultenum.SYSTEM_STATE;
import com.example.cssnwu.databaseservice.DatabaseService;
import com.example.cssnwu.po.PO;

/**
 *Class <code>DatabaseService_Stub.java</code> DatabaseService接口的桩
 *
 * @author never
 * @version 2013-10-11
 * @since JDK1.7
 */
@SuppressWarnings("serial")
public class DatabaseService_Stub implements DatabaseService{

	/* (non-Javadoc)
	 * Title: find
	 * Description:测试find方法
	 * @see com.example.cssnwu.databaseservice.DatabaseService#find(int)
	 */
	@Override
	public PO find(int id) throws RemoteException {
		PrintHelper.println(this.getClass().getName(), "find Succeed!");
		
		PO po = new PO();
		return po;
	}

	/* (non-Javadoc)
	 * Title: find
	 * Description:
	 * @see com.example.cssnwu.databaseservice.DatabaseService#find(java.lang.String)
	 */
	@Override
	public ArrayList<PO> find(String key) throws RemoteException {
		PrintHelper.println(this.getClass().getName(), "find Succeed!");
		
		ArrayList<PO> poList = new ArrayList<PO>();
		for(int i=0;i<10;i++) {
			poList.add(new PO());
		}
		return poList;
	}

	/* (non-Javadoc)
	 * Title: findAll
	 * Description:
	 * @see com.example.cssnwu.databaseservice.DatabaseService#findAll()
	 */
	@Override
	public ArrayList<PO> findAll() throws RemoteException {
		PrintHelper.println(this.getClass().getName(), "find Succeed!");
		
		ArrayList<PO> poList = new ArrayList<PO>();
		for(int i=0;i<10;i++) {
			poList.add(new PO());
		}
		return poList;
	}

	/* (non-Javadoc)
	 * Title: findAll
	 * Description:
	 * @see com.example.cssnwu.databaseservice.DatabaseService#findAll(int)
	 */
	@Override
	public ArrayList<PO> findAll(int id) throws RemoteException {
		PrintHelper.println(this.getClass().getName(), "find Succeed!");
		
		ArrayList<PO> poList = new ArrayList<PO>();
		for(int i=0;i<10;i++) {
			poList.add(new PO());
		}
		return poList;
	}

	/* (non-Javadoc)
	 * Title: update
	 * Description:
	 * @see com.example.cssnwu.databaseservice.DatabaseService#update(com.example.cssnwu.po.PO)
	 */
	@Override
	public boolean update(PO po) throws RemoteException {
		PrintHelper.println(this.getClass().getName(), "update Succeed!");
		
		return false;
	}

	/* (non-Javadoc)
	 * Title: update
	 * Description:
	 * @see com.example.cssnwu.databaseservice.DatabaseService#update(com.example.cssnwu.po.PO, java.lang.String, java.lang.Object)
	 */
	@Override
	public boolean update(PO po, String attr, Object value)
			throws RemoteException {
		PrintHelper.println(this.getClass().getName(), "update Succeed!");
		
		return false;
	}

	/* (non-Javadoc)
	 * Title: update
	 * Description:
	 * @see com.example.cssnwu.databaseservice.DatabaseService#update(int, java.util.HashMap)
	 */
	@Override
	public boolean update(int id, HashMap<Integer, Double> map)
			throws RemoteException {
		PrintHelper.println(this.getClass().getName(), "update Succeed!");
		
		return false;
	}

	/* (non-Javadoc)
	 * Title: insert
	 * Description:
	 * @see com.example.cssnwu.databaseservice.DatabaseService#insert(com.example.cssnwu.po.PO)
	 */
	@Override
	public boolean insert(PO po) throws RemoteException {
		PrintHelper.println(this.getClass().getName(), "insert Succeed!");
		
		return false;
	}

	/* (non-Javadoc)
	 * Title: delete
	 * Description:
	 * @see com.example.cssnwu.databaseservice.DatabaseService#delete(com.example.cssnwu.po.PO)
	 */
	@Override
	public boolean delete(PO po) throws RemoteException {
		PrintHelper.println(this.getClass().getName(), "delete Succeed!");
		
		return false;
	}

	/* (non-Javadoc)
	 * Title: load
	 * Description:
	 * @see com.example.cssnwu.databaseservice.DatabaseService#load()
	 */
	@Override
	public void load() throws RemoteException {
		PrintHelper.println(this.getClass().getName(), "load Succeed!");
		
	}

	/* (non-Javadoc)
	 * Title: save
	 * Description:
	 * @see com.example.cssnwu.databaseservice.DatabaseService#save()
	 */
	@Override
	public void save() throws RemoteException {
		PrintHelper.println(this.getClass().getName(), "save Succeed!");
		
	}

	/* (non-Javadoc)
	 * Title: init
	 * Description:
	 * @see com.example.cssnwu.databaseservice.DatabaseService#init()
	 */
	@Override
	public void init() throws RemoteException {
		PrintHelper.println(this.getClass().getName(), "init Succeed!");
		
	}

	/* (non-Javadoc)
	 * Title: finish
	 * Description:
	 * @see com.example.cssnwu.databaseservice.DatabaseService#finish()
	 */
	@Override
	public void finish() throws RemoteException {
		PrintHelper.println(this.getClass().getName(), "finish Succeed!");
		
	}

	@Override
	public boolean checkSystemState(SYSTEM_STATE system_state)
			throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setSystemState(SYSTEM_STATE system_state, boolean isUseful)
			throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
