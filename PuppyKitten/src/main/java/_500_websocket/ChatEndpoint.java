package _500_websocket;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/chatEndpoint.chat")
public class ChatEndpoint{
	static Set<Session> users = Collections.synchronizedSet(new HashSet<Session>());

	@OnOpen
	public void handleOpen(Session userSession) throws IOException{
		
		
		users.add(userSession);
		userSession.getBasicRemote().sendText(buildJsonData("System", "系統連接成功!"));
		
			userSession.getBasicRemote().sendText(buildJsonData("System", "訪客,您好!"));
		
		
	}
	
	@OnMessage
	public void handleMessage(String message, Session userSession) throws IOException{
			Iterator<Session> iterator =users.iterator();
			while(iterator.hasNext()){
				iterator.next().getBasicRemote().sendText(buildJsonData("訪客", message));
			}
		}
	
	
	
	@OnClose
	public void handleClose(Session userSession){
		users.remove(userSession);
	}
	private String buildJsonData(String username,String message){
		JsonObject json= Json.createObjectBuilder().add("message",username+":"+message).build();
		StringWriter sWriter = new StringWriter();
		try(JsonWriter jWriter=Json.createWriter(sWriter)){jWriter.write(json);}

		return sWriter.toString();
	}
	
}
