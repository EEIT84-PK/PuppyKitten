package _500_model;

import java.util.Arrays;
import java.util.List;

public class MemberService {
	MemberDAO_interface dao;
	
	public MemberService(){
		dao= new MemberDAO();
	}
	
	public MemberBean insert(MemberBean bean){
		dao.insert(bean);
		return bean;
	}
	
	public MemberBean login(String account,String password){
		List<MemberBean> list=dao.select(account);
		for(MemberBean bean:list){		
			byte[] pass=bean.getMEM_PASSWORD();
			byte[] temp=password.getBytes();
			if(Arrays.equals(pass, temp)){
				return bean;	
			}
		}
		return null;
		
	}
}
