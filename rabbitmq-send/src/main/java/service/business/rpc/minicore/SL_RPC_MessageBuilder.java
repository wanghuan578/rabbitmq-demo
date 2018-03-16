/************************************************************

Description: SL_RPC_MessageBuilder<TMessageBody>.

Author: wanghuan. 2013-01-20.

Boxin Technology Corporated Corporation. All Rights Reserved.

*************************************************************/

package service.business.rpc.minicore;

import org.apache.thrift.protocol.TProtocol;


public class SL_RPC_MessageBuilder<TMessageBody>{
	
	private SL_RPC_CommHead m_head = null;
	
	private TMessageBody m_body = null;
	
	private SL_RPC_ByteBuffer m_outProtocol = null;
	
	private TProtocol m_TProtocol = null;
	
	public SL_RPC_MessageBuilder(TMessageBody concrate_body, int buff_size, int offset){
		
		m_head = new SL_RPC_CommHead();
		
		m_body = concrate_body;
		
		m_outProtocol = new SL_RPC_ByteBuffer(buff_size);
		
		m_TProtocol = new SL_RPC_Thrift_BinaryProtocol(m_outProtocol, offset);
	}

	public SL_RPC_CommHead GetHead(){
		
		return m_head;
	}
	
	public TMessageBody GetBody(){
		
		return m_body;
	}

	public TProtocol GetTProtocol(){
		
		return m_TProtocol;
	}
	
	public SL_RPC_ByteBuffer GetBuffer(){
		
		return m_outProtocol;
	}
	
	public boolean Serialize(){
	
		int end = m_outProtocol.Length();
		
		m_outProtocol.WriteBufferBegin(0);
		
		m_outProtocol.WriteI32(end);
		m_outProtocol.WriteI16(m_head.GetFlag());
		m_outProtocol.WriteI16(m_head.GetType());
		m_outProtocol.WriteI32(m_head.GetSequence());
		m_outProtocol.WriteI32(m_head.GetSource());
		m_outProtocol.WriteI32(m_head.GetDestination());
		m_outProtocol.WriteI32(m_head.GetCheckSum());
		m_outProtocol.WriteI32(m_head.GetAttach1());
		m_outProtocol.WriteI32(m_head.GetAttach2());
		m_outProtocol.WriteI32(m_head.GetAttach3());
		m_outProtocol.WriteI32(m_head.GetAttach4());
		
		m_outProtocol.WriteBufferBegin(end);
		
		return true;
	}
}
