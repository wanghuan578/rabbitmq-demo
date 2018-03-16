package service.business.rpc.minicore;



public class SL_RPC_UpdateServerHandler {

	private SL_RPC_ByteBuffer m_Message = null;
	
	private SL_RPC_ProtocolFactory<Object> m_ProtocolFactory = null;
	
	public SL_RPC_UpdateServerHandler(SL_RPC_ByteBuffer buff){
	
		m_Message = buff;
		
		m_ProtocolFactory = new SL_RPC_ProtocolFactory<Object>(m_Message);
		
		Analysis();
	}
	
	public boolean Analysis(){
		
		return m_ProtocolFactory.GetParser().Message_Parser();
	}
	
	private SL_RPC_ByteBuffer GetEvent(){
		
		return m_Message;
	}
	
	private SL_RPC_CommHead GetEventHead(){
		
		return m_ProtocolFactory.GetParser().GetHead();
	}
	
	public int handle_message(){
		
		int ret = 0;
		
		switch(GetEventHead().GetType()){
		
		case SL_RPC_Seda_EventType.MT_RPC_SEDA_EVENT_HELLO_NOTIFY: {
			
			//BusinessManager.Instance().CheckUpdateVersion(LoginServer_UpdateType.UPDATE_IN_RUNNING);
		}
			break;
		
		case SL_RPC_Seda_EventType.MT_RPC_SEDA_EVENT_UPDATE_RESOURCE_RESP:{
			
			SL_RPC_SocketControlHandler.Instance().Destory(SL_RPC_ServerType.SL_RPC_SERVER_TYPE_UPDATE);
			
			GetEventHead().SetType(SL_RPC_Seda_EventType.MT_RPC_SEDA_EVENT_UPDATE_RESOURCE_RESP);
			
			SL_RPC_Seda_Event event = new SL_RPC_Seda_Event(GetEvent(), GetEventHead());

			SL_RPC_Seda_Stage.Instance().PushEvent(event);
		}
			break;
			
		default:
			break;
		}
		return ret;
	}
}
