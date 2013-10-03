/**
 * @(#)ClientLaunch.java     	2013-10-3 下午2:45:20
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.net;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Class <code>ClientLaunch.java</code> test in Client,the client calls a remote method
 * on a remote object,and returns the results. 
 *
 * @author never
 * @version 2013-10-3
 * @since JDK1.7
 */
public class ClientLaunch {
	
	private static  IDataRemoteService iDataRemoteService;
	
	
	/**
	 * Title: main
	 * Description:start the program
	 */
	public static void main(String[] args){
		while(iDataRemoteService==null){
			init();
		}
	}

	/**
	 * Title: init
	 * Description:Connect to RMI
	 */
	public static void init(){
		try {
			setIDataRemoteService((IDataRemoteService)Naming.lookup("rmi://localhost:8888/IDataRemoteService"));

			System.out.println("连接成功~~");

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Title: getiDataRemoteService
	 * Description:Singlton; only exist one IDataRemoteService while the program is running
	 * @return IDataRemoteService 
	 */
	
	public static IDataRemoteService getiDataRemoteService() {
		if(iDataRemoteService!=null)
			return iDataRemoteService;
		init();
		return iDataRemoteService;
	}
	
    /**
     * Title: setIDataRemoteService
     * Description:set the IDataRemoteService
     * @param remote IDataRemoteService
     */
	public static  void setIDataRemoteService(IDataRemoteService remote) {
		iDataRemoteService = remote;
	}


}
