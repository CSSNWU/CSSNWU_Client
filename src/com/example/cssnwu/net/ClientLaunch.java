/**
 * @(#)ClientLaunch.java     	2013-10-3 下午2:45:20
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.net;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.example.cssnwu.databaseservice.DatabaseFactory;
import com.example.cssnwu.databaseservice.DatabaseService;
import com.example.cssnwu.po.PO;
import com.example.cssnwu.presentation.loginui.LoginUI;
import com.example.cssnwu.presentation.studentUI.StudentUI2;

/**
 * Class <code>ClientLaunch.java</code> test in Client,the client calls a remote method
 * on a remote object,and returns the results. 
 *
 * @author never
 * @version 2013-10-3
 * @since JDK1.7
 */
public class ClientLaunch {
	public static boolean isDebug=true;////////////
	public static  String IP = "192.168.253.149";            //ip地址
	public static final int PORT = 9999;                    //端口号
	private static  DatabaseFactory databaseFactory;
	
	
	/**
	 * Title: main
	 * Description:start the program.
	 * @throws RemoteException 
	 */
	public static void main(String[] args) throws RemoteException{
		
		while(databaseFactory==null) {
			init();
	        
			DatabaseService courseDatabaseService = databaseFactory.getCourseDatabaseService();
//	        /if (courseDatabaseService.insert(new PO())) {
//	        	System.out.println("Success");
//	        } else {
//	        	System.out.println("Fail");
//	        }
	        LoginUI test=new LoginUI();
		}
		

	}

	/**
	 * Title: init.
	 * Description:Connect to RMI
	 */
	public static void init(){
		try {
			BufferedReader br=new BufferedReader(new FileReader(new File("D://File/IPFile.txt")));
			IP=br.readLine();
			setDatabaseFactory((DatabaseFactory)Naming.lookup("rmi://" + IP + ":" + PORT + "/cssnwu"));

			System.out.println("连接成功~~");

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Title: getDatabaseFactory.
	 * Description:Singlton; only exist one DatabaseFactory while the program is running
	 * @return DatabaseFactory 
	 */
	
	public static DatabaseFactory getDatabaseFactory() {
		if(databaseFactory != null) {
			return databaseFactory;
		}
			
		init();
		return databaseFactory;
	}
	
    /**
     * Title: setDatabaseFactory.
     * Description:set the DatabaseFactory
     * @param remote DatabaseFactory
     */
	public static  void setDatabaseFactory(DatabaseFactory remote) {
		databaseFactory = remote;
	}


}
