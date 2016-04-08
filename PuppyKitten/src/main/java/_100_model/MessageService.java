package _100_model;

import java.util.List;

public class MessageService {
	MessageDAO_interface dao;
	
	public MessageService(){
		dao = new MessageDAO();
	}
	
	public List<MessageBean> selectId(String id){
		List<MessageBean> list=dao.selectId(id);
		return list;
	}
	public MessageBean insert(MessageBean bean){
			dao.insert(bean);
		return bean;
	} 
}
