/************************************************************

Description: SL_Seda_EventQueue.

Author: wanghuan. 2013-01-20.

Boxin Technology Corporated Corporation. All Rights Reserved.

*************************************************************/

package service.business.rpc.minicore;

public class SL_RPC_Seda_EventType {

	public static final int MT_RPC_SEDA_EVENT_LOGINSERVER_CONNECTTED 				= 1;
	public static final int MT_RPC_SEDA_EVENT_ROOMGATE_CONNECTTED 					= 2;
	public static final int MT_RPC_SEDA_EVENT_HELLO_NOTIFY    						= 10; 
	public static final int MT_RPC_SEDA_EVENT_KEEPLIVE_REQ							= 11;
	public static final int MT_RPC_SEDA_EVENT_KEEPLIVE_RESP							= 12;
	public static final int MT_RPC_SEDA_EVENT_KICKUSER_NOTIFY						= 13;
	public static final int MT_RPC_SEDA_EVENT_LOGOUT_REQ							= 14;
	public static final int MT_RPC_SEDA_EVENT_BIGGIFT_NOTIFY						= 16;
	public static final int MT_RPC_SEDA_EVENT_SIEGE_NOTIFY							= 21;
	public static final int MT_RPC_SEDA_EVENT_BALANCE_CHANGE_NOTIFY					= 25;
	public static final int MT_RPC_SEDA_EVENT_SITEMICUSERLIST_REQ					= 31;
	public static final int MT_RPC_SEDA_EVENT_SITEMICUSERLIST_RESP					= 32;
	public static final int MT_RPC_SEDA_EVENT_SITEMIC_UP_NOTIFY						= 33;
	public static final int MT_RPC_SEDA_EVENT_SITEMIC_DOWN_NOTIFY					= 34;
	public static final int MT_RPC_SEDA_EVENT_LOGIN_REQ    							= 100;
	public static final int MT_RPC_SEDA_EVENT_LOGIN_RESP    						= 102;
	public static final int MT_RPC_SEDA_EVENT_TEMP_LOGIN_REQ    					= 106;
	public static final int MT_RPC_SEDA_EVENT_GET_BALANCE_NOTIFY    				= 112;
	public static final int MT_RPC_SEDA_EVENT_UPDATE_RESOURCE_REQ    				= 113;
	public static final int MT_RPC_SEDA_EVENT_UPDATE_RESOURCE_RESP    				= 114;
	public static final int MT_RPC_SEDA_EVENT_ROOMGATE_REQ    						= 600;
	public static final int MT_RPC_SEDA_EVENT_ROOMGATE_LOGIN_RESP    				= 601;
	public static final int MT_RPC_SEDA_EVENT_UPDATE_USERINFO_REQ 					= 605;
	public static final int MT_RPC_SEDA_EVENT_UPDATE_USERINFO_RESP 					= 606;
	public static final int MT_RPC_SEDA_EVENT_ENTERROOM_REQ							= 2000;
	public static final int MT_RPC_SEDA_EVENT_ENTERROOM_RESP						= 2001;
	public static final int MT_RPC_SEDA_EVENT_ENTER_ROOM_NOTIFY						= 2002;
	public static final int MT_RPC_SEDA_EVENT_LEAVE_ROOM_REQ						= 2003;
	public static final int MT_RPC_SEDA_EVENT_LEAVE_ROOM_RESP						= 2004;
	public static final int MT_RPC_SEDA_EVENT_LEAVE_ROOM_NOTIFY						= 2005;
	public static final int MT_RPC_SEDA_EVENT_CHECK_PASSWARD_RESP					= 2007;
	public static final int MT_RPC_SEDA_EVENT_ROOMINFO_NOTIFY						= 2009;
	public static final int MT_RPC_SEDA_EVENT_SERVICE_IP_NOTIFY						= 2011;
	public static final int MT_RPC_SEDA_EVENT_USERLIST_NOTIFY						= 2014;
	public static final int MT_RPC_SEDA_EVENT_MIC_LIST_NOTIFY						= 2016;
	public static final int MT_RPC_SEDA_EVENT_SPECIAL_LIST_NOTIFY					= 2021;
	public static final int MT_RPC_SEDA_EVENT_MEDIA_UP_NOTIFY						= 2038;
	public static final int MT_RPC_SEDA_EVENT_MEDIA_DOWN_NOTIFY						= 2044;
	public static final int MT_RPC_SEDA_EVENT_SENDCHAT_REQ							= 2048;
	public static final int MT_RPC_SEDA_EVENT_SENDCHAT_RESP							= 2049;
	public static final int MT_RPC_SEDA_EVENT_CHAT_NOTIFY 							= 2050;
	public static final int MT_RPC_SEDA_EVENT_GIFT_REQ								= 2054;
	public static final int MT_RPC_SEDA_EVENT_GIFT_RESP 							= 2055;
	public static final int MT_RPC_SEDA_EVENT_GIFT_NOTIFY 							= 2056;
	public static final int MT_RPC_SEDA_EVENT_ADD_ROOM_MANAGER_LIST_NOTIFY 			= 2083;
	public static final int MT_RPC_SEDA_EVENT_ROLE_PERMISSION_REQ					= 2136;
	public static final int MT_RPC_SEDA_EVENT_ROLE_PERMISSION_RESP					= 2137;
}
