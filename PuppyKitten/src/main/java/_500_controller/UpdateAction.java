package _500_controller;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import _500_model.MemberBean;
import _500_model.MemberService;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport implements SessionAware {
	private MemberBean member;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MemberBean getMember() {
		return member;
	}

	public void setMember(MemberBean member) {
		this.member = member;
	}

	public void validate() {
		// 帳號驗證
		if (member.getMEM_ACCOUNT() == null || member.getMEM_ACCOUNT().trim().length() == 0) {
			this.addFieldError("MEM_ACCOUNT", "請輸入帳號");
		}
		for (int n = 0; n < member.getMEM_ACCOUNT().length(); n++) {
			char checkaccount = member.getMEM_ACCOUNT().charAt(n);
			if (checkaccount >= 65 && checkaccount <= 90 || checkaccount >= 97 && checkaccount <= 122
					|| checkaccount >= 48 && checkaccount <= 57) {

			} else {
				this.addFieldError("MEM_ACCOUNT", "輸入英文,數字");
			}
		}
		// 密碼驗證
		if (password == null || password.length() == 0) {
			this.addFieldError("password", "請輸入密碼");
		}
		if (password.length() <= 5) {
			this.addFieldError("password", "密碼至少要六碼");
		}

		// 姓名驗證
		if (member.getMEM_NAME() == null || member.getMEM_NAME().trim().length() == 0) {
			this.addFieldError("MEM_NAME", "請輸入姓名");
		}
		for (int i = 0; i < member.getMEM_NAME().length(); i++) {
			char name = member.getMEM_NAME().charAt(i);
			if (name >= 65 && name <= 90 || name >= 97 && name <= 122 || (int) name >= 19968 && (int) name <= 40623) {
			} else {
				this.addFieldError("MEM_NAME", "請輸入中,英文");
			}
		}

		// 身分證驗證
		if (member.getMEM_IDCARD() == null || member.getMEM_IDCARD().trim().length() == 0) {
			this.addFieldError("MEM_IDCARD", "請輸入身分證字號");
		}

		// e-mail驗證
		if (member.getMEM_EMAIL() == null || member.getMEM_EMAIL().trim().length() == 0) {
			this.addFieldError("MEM_EMAIL", "請輸入E-MAIL");
		}
		// 生日驗證
		if (member.getMEM_BIRTHDAY() == null) {
			this.addFieldError("MEM_BIRTHDAY", "請輸入生日");
		}
		// 地址驗證
		if (member.getMEM_ADD() == null || member.getMEM_ADD().trim().length() == 0) {
			this.addFieldError("MEM_ADD", "請輸入地址");
		}
		for (int k = 0; k < member.getMEM_ADD().length(); k++) {
			char charadd = member.getMEM_ADD().charAt(k);
			if ((int) charadd >= 19968 && (int) charadd <= 40623) {

			} else {
				this.addFieldError("MEM_ADD", "請輸入中文");

			}
		}
		// 電話驗證
		if (member.getMEM_PHONE() == null || member.getMEM_PHONE().trim().length() == 0) {
			this.addFieldError("MEM_PHONE", "請輸入電話");
		}
		if (member.getMEM_PHONE().length() <= 9) {
			this.addFieldError("MEM_PHONE", "電話至少輸入10碼");
		}
		for (int a = 0; a < member.getMEM_PHONE().length(); a++) {
			char checkphone = member.getMEM_PHONE().charAt(a);
			if (checkphone >= 48 && checkphone <= 57) {

			} else {
				this.addFieldError("MEM_PHONE", "不能輸入中文,亂碼,英文");
			}
		}

	}

	public String execute() throws Exception {
		MemberService service = new MemberService();
		service.insert(member);
		return password;

	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub

	}
}
