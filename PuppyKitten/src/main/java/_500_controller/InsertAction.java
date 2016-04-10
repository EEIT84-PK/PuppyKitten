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
		if(bean.getMEM_ACCOUNT()==null||bean.getMEM_ACCOUNT().trim().length()==0){
			this.addFieldError("MEM_ACCOUNT", "請輸入帳號");
		}
		if(password==null||password.trim().length()==0){
			this.addFieldError("password", "請輸入密碼");
		}
		if(bean.getMEM_NAME()==null||bean.getMEM_NAME().trim().length()==0){
			this.addFieldError("MEM_NAME", "請輸入姓名");
		}
		if(bean.getMEM_IDCARD()==null||bean.getMEM_IDCARD().trim().length()==0){
			this.addFieldError("MEM_IDCARD", "請輸入身分證字號");
		}
		if(bean.getMEM_EMAIL()==null||bean.getMEM_EMAIL().trim().length()==0){
			this.addFieldError("MEM_EMAIL", "請輸入E-MAIL");
		}
		if(bean.getMEM_BIRTHDAY()==null){
			this.addFieldError("MEM_BIRTHDAY", "請輸入生日");
		}
		if(bean.getMEM_ADD()==null||bean.getMEM_ADD().trim().length()==0){
			this.addFieldError("MEM_ADD", "請輸入地址");
		}
		if(bean.getMEM_PHONE()==null||bean.getMEM_PHONE().trim().length()==0){
			this.addFieldError("MEM_PHONE", "請輸入電話");
		}
	}
	
	
	//執行 並呼叫model
	public String execute() {

		MemberService service = new MemberService();
		bean.setMEM_PASSWORD(password.getBytes());
		service.insert(bean);

		return SUCCESS;
	}
}
