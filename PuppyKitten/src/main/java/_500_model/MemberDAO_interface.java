package _500_model;

import java.util.List;

public interface MemberDAO_interface {

	public void insert(MemberBean bean);

	public List<MemberBean> select(String MEM_ACCOUNT);

}