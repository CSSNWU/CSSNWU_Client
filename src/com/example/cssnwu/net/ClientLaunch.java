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

import com.example.cssnwu.databaseservice.DatabaseFactory;

/**
 * Class <code>ClientLaunch.java</code> test in Client,the client calls a remote method
 * on a remote object,and returns the results. 
 *
 * @author never
 * @version 2013-10-3
 * @since JDK1.7
 */
public class ClientLaunch {
	public static final String IP = "127.0.0.1";            //ip地址
	public static final int PORT = 8888;                    //端口号
	private static  DatabaseFactory databaseFactory;
	
	
	/**
	 * Title: main
	 * Description:start the program
	 * @throws RemoteException 
	 */
	public static void main(String[] args) throws RemoteException{
		
		while(databaseFactory==null){
			init();
		}
		

	}

	/**
	 * Title: init
	 * Description:Connect to RMI
	 */
	public static void init(){
		try {
			setDatabaseFactory((DatabaseFactory)Naming.lookup("rmi://" + IP + ":" + PORT + "/cssnwu"));

			System.out.println("连接成功~~");

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Title: getDatabaseFactory
	 * Description:Singlton; only exist one DatabaseFactory while the program is running
	 * @return DatabaseFactory 
	 */
	
	public static DatabaseFactory getDatabaseFactory() {
		if(databaseFactory != null)
			return databaseFactory;
		init();
		return databaseFactory;
	}
	
    /**
     * Title: setDatabaseFactory
     * Description:set the DatabaseFactory
     * @param remote DatabaseFactory
     */
	public static  void setDatabaseFactory(DatabaseFactory remote) {
		databaseFactory = remote;
	}


}
