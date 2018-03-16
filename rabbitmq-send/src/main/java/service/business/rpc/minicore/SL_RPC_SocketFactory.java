/************************************************************

Description: SL_RPC_SocketFactory.

Author: wanghuan. 2013-01-20.

Boxin Technology Corporated Corporation. All Rights Reserved.

*************************************************************/

package service.business.rpc.minicore;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;


public class SL_RPC_SocketFactory {
	
	private Map<Integer, Socket> m_TmpClient = null;
	
	private Map<Integer, Socket> m_RegisteredClient = null;
	
	private int m_CurrentServer = SL_RPC_ServerType.SL_RPC_SERVER_TYPE_NONE;
	
	public SL_RPC_SocketFactory(){
		
		m_TmpClient = new HashMap<Integer, Socket>();
		
		m_RegisteredClient = new HashMap<Integer, Socket>();
		
		m_TmpClient.put(SL_RPC_ServerType.SL_RPC_SERVER_TYPE_LOGIN, (Socket)null);
		
		m_TmpClient.put(SL_RPC_ServerType.SL_RPC_SERVER_TYPE_ROOMGATE, (Socket)null);
		
		m_RegisteredClient.put(SL_RPC_ServerType.SL_RPC_SERVER_TYPE_LOGIN, (Socket)null);
		
		m_RegisteredClient.put(SL_RPC_ServerType.SL_RPC_SERVER_TYPE_ROOMGATE, (Socket)null);
	}
	
	public void SetCurrentServer(int type){
		
		m_CurrentServer = type;
	}
	
	public int GetCurrentServer(){
		
		return m_CurrentServer;
	}
	
	public void Socket_Close(int server_type){
	
		Socket s = null;
		
		if(SL_RPC_IdentityType.TYPE_TEMP_USER_LOGIN == 1){
		
			s = m_TmpClient.get(server_type);
		}
		else
		{
			s = m_RegisteredClient.get(server_type);
		}
		
		if(null != s){
			
			if(s.isConnected()){
				
				try 
				{	
					s.close();
					
					s = null;
					
					if(SL_RPC_IdentityType.TYPE_TEMP_USER_LOGIN == 1){
					
						m_TmpClient.put(server_type, s);
					}
					else
					{
						m_RegisteredClient.put(server_type, s);
					}
				} 
				catch (IOException e) 
				{	
					e.printStackTrace();
				}
			}
		}
	}

				
}
