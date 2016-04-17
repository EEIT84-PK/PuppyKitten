package _100_model;


import java.util.List;

public interface MessageDAO_interface {

	public void insert(MessageBean bean);
	public void update(MessageBean bean);
	public List<MessageBean> selectId(String id);
	public List<MessageBean> selectTime(String time);
	

}