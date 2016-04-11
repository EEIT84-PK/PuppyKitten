package _500_model;

import java.util.List;

public interface MemberDAO_interface {

	public void insert(MemberBean bean);
	public List<MemberBean> select(String MEM_ACCOUNT);
	public MemberBean selectMemberByAccount(String account);
	public void update(MemberBean bean);
	public MemberBean selectMemberByMemId(final Integer memberId);
}
