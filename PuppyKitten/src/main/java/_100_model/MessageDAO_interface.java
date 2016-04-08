package _100_model;

import java.util.List;

public interface MessageDAO_interface {

	public void insert(MessageBean bean);
	public List<MessageBean> selectId(String id);

}