/************************************************************

Description: SL_RPC_MainStageHandler.

Author: wanghuan. 2013-01-20.

Boxin Technology Corporated Corporation. All Rights Reserved.

*************************************************************/

package service.business.rpc.minicore;

import java.io.IOException;
//import service.business.manager.BusinessManager;
//import service.business.manager.RoomServer_LocalUserInfor;


public class SL_RPC_MainStageHandler {

	private SL_RPC_ByteBuffer m_Event = null;
	
	private SL_RPC_ProtocolFactory<Object> m_ProtocolFactory = null;
	
	public SL_RPC_MainStageHandler(SL_RPC_ByteBuffer event){
		
		if(SL_RPC_State.SL_RPC_SOCKETSTATE_ROOMGATESERVER_CONNECTTING < SL_RPC_SocketControlHandler.Instance().GetState())
		{
			byte [] arrPasswd = new byte[16];

			//RoomServer_LocalUserInfor info = BusinessManager.Instance().GetLocalUserInfo();
			
			//String session_key = info.GetSessionKey();
			
			//if(null != session_key){
				
			//	System.arraycopy(session_key.getBytes(), 0, arrPasswd, 0, 16);
			//}
			
			SL_RPC_ByteBuffer tmp = event;
			
			byte[] decoded_event = null;
			
			try 
			{
				decoded_event = new SL_RPC_DataEncapsulater().decrypt(event.GetBytes(), 5, (tmp.ReadI32() - 0), new String(arrPasswd));
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
			m_Event = new SL_RPC_ByteBuffer(decoded_event, decoded_event.length);
		}
		else
		{
			m_Event = event;
		}
		
		m_ProtocolFactory = new SL_RPC_ProtocolFactory<Object>(m_Event);
	}
	
	public int Initialize(){
		
		Analysis();
		
		return 0;
	}
	
	public boolean Analysis(){
		
		return m_ProtocolFactory.GetParser().Message_Parser();
	}
	
	private SL_RPC_ByteBuffer GetEvent(){
		
		return m_Event;
	}
	
	private SL_RPC_CommHead GetEventHead(){
		
		return m_ProtocolFactory.GetParser().GetHead();
	}
	
	public int handle_message(){
		
		int main_stage = SL_RPC_SocketControlHandler.Instance().GetState();
		
		switch(main_stage){
		
		case SL_RPC_State.SL_RPC_SOCKETSTATE_LOGINSERVER_CONNECTTING:
		case SL_RPC_State.SL_RPC_SOCKETSTATE_LOGINSERVER_CONNECTED:
		case SL_RPC_State.SL_RPC_SOCKETSTATE_LOGINSERVER_LOGIN:
		case SL_RPC_State.SL_RPC_SOCKETSTATE_LOGINSERVER_LOGIN_SUCCESSED:{
			
			SL_RPC_LoginServerHandler handler = new SL_RPC_LoginServerHandler(GetEvent(),  GetEventHead());
			
			handler.do_message();
		}
			break;
			
		case SL_RPC_State.SL_RPC_SOCKETSTATE_ROOMGATESERVER_CONNECTTING:
		case SL_RPC_State.SL_RPC_SOCKETSTATE_ROOMGATESERVER_CONNECTED:
		case SL_RPC_State.SL_RPC_SOCKETSTATE_ROOMGATESERVER_LOGIN:
		case SL_RPC_State.SL_RPC_SOCKETSTATE_ROOMGATESERVER_LOGIN_SUCCESSED:{
			
			SL_RPC_RoomGateHandler handler = new SL_RPC_RoomGateHandler(GetEvent(), GetEventHead());
			
			handler.do_message();
		}
			break;
			
		default:
			System.out.println("SL_RPC_MainStageHandler - handle_message Undefined State");
			break;
		}
		
		return 0;
	}
}
