/************************************************************

Description: SL_RPC_RoomGateHandler

Author: wanghuan. 2013-01-20 

Boxin Technology Corporated Corporation. All Rights Reserved.

************************************************************/

package service.business.rpc.minicore;

public class SL_RPC_RoomGateHandler {

	private SL_RPC_ByteBuffer m_Event = null;
	
	private SL_RPC_CommHead m_EventHead = null;
	
	public SL_RPC_RoomGateHandler(SL_RPC_ByteBuffer event, SL_RPC_CommHead event_head){
		
		m_Event = event;
		
		m_EventHead = event_head;
	}
	
	private SL_RPC_CommHead GetEventHead(){
		
		return m_EventHead;
	}
	
	private SL_RPC_ByteBuffer GetEvent(){
	
		return m_Event;
	}
	
	public void do_message(){
		
		switch(GetEventHead().GetType())
		{
		case SL_RPC_Seda_EventType.MT_RPC_SEDA_EVENT_HELLO_NOTIFY: {
			
			SL_RPC_SocketControlHandler.Instance().SetState(SL_RPC_State.SL_RPC_SOCKETSTATE_ROOMGATESERVER_CONNECTED);
		
			GetEventHead().SetType(SL_RPC_Seda_EventType.MT_RPC_SEDA_EVENT_ROOMGATE_CONNECTTED);
			
			SL_RPC_Seda_Event event = new SL_RPC_Seda_Event(GetEvent(), GetEventHead());
			
			SL_RPC_Seda_Stage.Instance().PushEvent(event);
		}
			break;
			
		case SL_RPC_Seda_EventType.MT_RPC_SEDA_EVENT_ROOMGATE_LOGIN_RESP:{
			
			SL_RPC_SocketControlHandler.Instance().SetState(SL_RPC_State.SL_RPC_SOCKETSTATE_ROOMGATESERVER_LOGIN_SUCCESSED);
			
			SL_RPC_SocketControlHandler.Instance().GetRoomGateHandler().KeepAlive_Start();

			SL_RPC_Seda_Event event = new SL_RPC_Seda_Event(GetEvent(), GetEventHead());
			
			SL_RPC_Seda_Stage.Instance().PushEvent(event);
		}
			break;
			
		
		default:{
			
			SL_RPC_Seda_Event event = new SL_RPC_Seda_Event(GetEvent(), GetEventHead());
			
			SL_RPC_Seda_Stage.Instance().PushEvent(event);
		}
			break;
			
			
		}
	}
}
