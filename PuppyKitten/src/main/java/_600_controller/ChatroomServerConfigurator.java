package _600_controller;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.*;

public class ChatroomServerConfigurator extends ServerEndpointConfig.Configurator {
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
		System.out.println("12313213123"+((HttpSession)request.getHttpSession()).getAttribute("id"));
		sec.getUserProperties().put("id", ((HttpSession)request.getHttpSession()).getAttribute("id"));
		if (((HttpSession) request.getHttpSession()).getAttribute("loginOK") == null
				&& ((HttpSession) request.getHttpSession()).getAttribute("backLoginOK") == null) {
			sec.getUserProperties().put("username", "訪客");
		} else if(((HttpSession) request.getHttpSession()).getAttribute("backLoginOK") == null){
			sec.getUserProperties().put("username",
					((HttpSession) request.getHttpSession()).getAttribute("loginOK").toString());
		}else{
			sec.getUserProperties().put("username", "管理員");
		}

	}

}
