package _500_controller;
import com.opensymphony.xwork2.ActionSupport;

import _500_model.MemberBean;
import _500_model.MemberService;

@SuppressWarnings("serial")
public class InsertAction extends ActionSupport {
	private MemberBean bean;
	private String password;
	private String checkpassword;

	public MemberBean getBean() {
		return bean;
	}
	public void setBean(MemberBean bean) {
		this.bean = bean;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCheckpassword() {
		return checkpassword;
	}
	public void setCheckpassword(String checkpassword) {
		this.checkpassword = checkpassword;
	}
	
	
	//驗證
	public void validate(){
		
	}
	
	//執行 並呼叫model
	public String execute() {

		MemberService service = new MemberService();
		bean.setMEM_PASSWORD(password.getBytes());
		service.insert(bean);

		return SUCCESS;
	}
}
