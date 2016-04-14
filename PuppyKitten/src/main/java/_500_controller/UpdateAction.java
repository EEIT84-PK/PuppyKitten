package _500_controller;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import _500_model.MemberBean;
import _500_model.MemberService;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UpdateAction extends ActionSupport implements SessionAware {
	private MemberBean bean;
	private String password;
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MemberBean getbean() {
		return bean;
	}

	public void setMember(MemberBean bean) {
		this.bean = bean;
	}

	public void validate() {
	
	
	
		if (bean.getMEM_NAME() == null || bean.getMEM_NAME().trim().length() == 0) {
			this.addFieldError("MEM_NAME", "請輸入姓名");
		}
		for (int i = 0; i < bean.getMEM_NAME().length(); i++) {
			char name = bean.getMEM_NAME().charAt(i);
			if (name >= 65 && name <= 90 || name >= 97 && name <= 122 || (int) name >= 19968 && (int) name <= 40623) {
			} else {
				this.addFieldError("MEM_NAME", "請輸入中,英文");
			}
		}

		
		if (bean.getMEM_IDCARD() == null || bean.getMEM_IDCARD().trim().length() == 0) {
			this.addFieldError("MEM_IDCARD", "請輸入身分證字號");
		}

	
		if (bean.getMEM_EMAIL() == null || bean.getMEM_EMAIL().trim().length() == 0) {
			this.addFieldError("MEM_EMAIL", "請輸入E-MAIL");
		}
		
		if (bean.getMEM_BIRTHDAY() == null) {
			this.addFieldError("MEM_BIRTHDAY", "請輸入生日");
		}
		
		if (bean.getMEM_ADD() == null || bean.getMEM_ADD().trim().length() == 0) {
			this.addFieldError("MEM_ADD", "請輸入地址");
		}
		for (int k = 0; k < bean.getMEM_ADD().length(); k++) {
			char charadd = bean.getMEM_ADD().charAt(k);
			if ((int) charadd >= 19968 && (int) charadd <= 40623) {

			} else {
				this.addFieldError("MEM_ADD", "請輸入中文");

			}
		}
		
		if (bean.getMEM_PHONE() == null || bean.getMEM_PHONE().trim().length() == 0) {
			this.addFieldError("MEM_PHONE", "請輸入電話");
		}
		if (bean.getMEM_PHONE().length() <= 9) {
			this.addFieldError("MEM_PHONE", "電話至少輸入10碼");
		}
		for (int a = 0; a < bean.getMEM_PHONE().length(); a++) {
			char checkphone = bean.getMEM_PHONE().charAt(a);
			if (checkphone >= 48 && checkphone <= 57) {

			} else {
				this.addFieldError("MEM_PHONE", "不能輸入中文,亂碼,英文");
			}
		}

	}

	public String execute() throws Exception {
		MemberService service = new MemberService();
	    service.update(bean);
		if(bean!=null){
			 return SUCCESS;
		}else{
			return INPUT;
		}
	   

	}
	

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub

	}
}
