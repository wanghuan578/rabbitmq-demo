package service.business.rpc.message;

import org.apache.thrift.TException;

import service.business.idl.thrift.CommonNull;
import service.business.rpc.minicore.SL_RPC_CommHead;
import service.business.rpc.minicore.SL_RPC_ProtocolFactory;
import service.business.rpc.minicore.SL_RPC_Seda_EventType;




public class SRM_LogoutRequest {

	public SRM_LogoutRequest(){
		
		SL_RPC_ProtocolFactory<CommonNull> factory = new SL_RPC_ProtocolFactory<CommonNull>(new CommonNull(), 1024, SL_RPC_CommHead.Size());

		try 
		{
			factory.GetBuilder().GetBody().write(factory.GetBuilder().GetTProtocol());
		} 
		catch (TException e) 
		{
			System.out.println("SRM_LogoutRequest Error: "+e.getMessage());
		}
		
		factory.GetBuilder().GetHead().SetType(SL_RPC_Seda_EventType.MT_RPC_SEDA_EVENT_LOGOUT_REQ);
		//factory.GetBuilder().GetHead().SetSource(BusinessManager.Instance().GetLocalUserInfo().GetUserID());
		//factory.GetBuilder().GetHead().SetAttach1(BusinessManager.Instance().GetGloableData().GetRoomInfo().GetRoomID());
		
		factory.GetBuilder().Serialize();
		
		//SL_RPC_SocketControlHandler.Instance().Put_DataEx(factory.GetBuilder().GetBuffer());
	}
}
