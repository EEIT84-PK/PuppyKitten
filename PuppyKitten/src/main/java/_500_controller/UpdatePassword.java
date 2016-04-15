package _500_controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import javassist.compiler.ast.Member;

import org.apache.struts2.interceptor.SessionAware;

import _500_model.MemberBean;
import _500_model.MemberService;

import com.opensymphony.xwork2.ActionSupport;

public class UpdatePassword extends ActionSupport implements SessionAware {
	private MemberBean bean;
	private String password;
	private String checkpassword;
	private HttpServletRequest request;
	private String check;

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

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

	public void validate() {
		
		
		if (password == null || password.trim().length() == 0) {
			this.addFieldError("password", "請輸入舊密碼");
		}
		if (password.length() <= 5) {
			this.addFieldError("password", "密碼至少要六碼");
		}
		if (checkpassword == null || checkpassword.trim().length() == 0) {
			this.addFieldError("checkpassword", "請輸入新密碼");
		}
		if (check.length() != checkpassword.length()) {
			this.addFieldError("check", "新密碼跟確認碼需一致");
		}
	}

	public String execute() throws Exception {
		MemberService memberService = new MemberService();
		
	if(bean!=null){
		HttpSession session = request.getSession();
		MemberBean bean = memberService
				.selectMemberById((Integer) session.getAttribute("memberID"));
		bean.setMEM_PASSWORD(password.getBytes());
	
		return SUCCESS;

	}else{
		return INPUT;
	}
	}
	@Override
	public void setSession(Map<String, Object> arg0) {

	}
}