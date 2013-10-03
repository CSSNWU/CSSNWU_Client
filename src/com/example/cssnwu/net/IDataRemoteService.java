/**
 * @(#)IDataRemoteService.java     	2013-10-3 обнГ2:22:46
 * Copyright never.All rights reserved
 * never PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.cssnwu.net;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *Class <code>IDataRemoteService.java</code> TODO
 *
 * @author never
 * @version 2013-10-3
 * @since JDK1.7
 *
 */
public interface IDataRemoteService extends Remote{

	/**
	 * 
	 *Title: helloWorld
	 *Description:just for test RMI.
	 * @return "Hello world"
	 * @throws RemoteException
	 */
	public String helloWorld() throws RemoteException;
}
