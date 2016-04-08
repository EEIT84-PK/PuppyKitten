package _500_controller;

import com.opensymphony.xwork2.ActionSupport;

import _500_model.MemberBean;
import _500_model.MemberService;

@SuppressWarnings("serial")
public class InsertAction extends ActionSupport {
	private MemberBean bean;
	private String password;
	private String checkpassword;
	private String account;
	private String checkcode;
	private String use;

	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
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
	public String getCheckcode() {
		return checkcode;
	}
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	// 驗證
	public void validate() {
		// 帳號驗證
		if (bean.getMEM_ACCOUNT() == null || bean.getMEM_ACCOUNT().trim().length() == 0) {
			this.addFieldError("MEM_ACCOUNT", "請輸入帳號");
		}
		for (int n = 0; n < bean.getMEM_ACCOUNT().length(); n++) {
			char checkaccount = bean.getMEM_ACCOUNT().charAt(n);
			if (checkaccount >= 65 && checkaccount <= 90|| checkaccount >= 97 && checkaccount <= 122
					||checkaccount >= 48 && checkaccount <= 57) {

			} else {
				this.addFieldError("MEM_ACCOUNT", "輸入英文,數字");
			}
		}
		// 密碼驗證
		if (password == null || password.trim().length() == 0) {
			this.addFieldError("password", "請輸入密碼");
		}
		if (password.length() <= 5) {
			this.addFieldError("password", "密碼至少要六碼");
		}
		if (checkpassword == null || checkpassword.trim().length() == 0) {
			this.addFieldError("checkpassword", "請輸入確認密碼");
		}
		if (password.length() != checkpassword.length()) {
			this.addFieldError("checkpassword", "密碼跟確認密碼需一致");
		}
		// 姓名驗證
		if (bean.getMEM_NAME() == null || bean.getMEM_NAME().trim().length() == 0) {
			this.addFieldError("MEM_NAME", "請輸入姓名");
		}
		for (int i = 0; i < bean.getMEM_NAME().length(); i++) {
			char name = bean.getMEM_NAME().charAt(i);
			System.out.println("name" + bean.getMEM_NAME());
			if (name >= 65 && name <= 90 || name >= 97 && name <= 122 || (int) name >= 19968 && (int) name <= 40623) {
			} else {
				this.addFieldError("MEM_NAME", "請輸入中,英文");
			}
		}

		// 身分證驗證
		if (bean.getMEM_IDCARD() == null || bean.getMEM_IDCARD().trim().length() == 0) {
			this.addFieldError("MEM_IDCARD", "請輸入身分證字號");
		}

		// e-mail驗證
		if (bean.getMEM_EMAIL() == null || bean.getMEM_EMAIL().trim().length() == 0) {
			this.addFieldError("MEM_EMAIL", "請輸入E-MAIL");
		}
		// 生日驗證
		if (bean.getMEM_BIRTHDAY() == null) {
			this.addFieldError("MEM_BIRTHDAY", "請輸入生日");
		}
		// 地址驗證
		if (bean.getMEM_ADD() == null || bean.getMEM_ADD().trim().length() == 0) {
			this.addFieldError("MEM_ADD", "請輸入地址");
		}
		for (int k = 0; k < bean.getMEM_ADD().length(); k++) {
			char charadd = bean.getMEM_ADD().charAt(k);
			System.out.println("charardd" + bean.getMEM_ADD());
			if ((int) charadd >= 19968 && (int) charadd <= 40623) {

			} else {
				this.addFieldError("MEM_ADD", "請輸入中文");

			}
		}
		// 電話驗證
		if (bean.getMEM_PHONE() == null || bean.getMEM_PHONE().trim().length() == 0) {
			this.addFieldError("MEM_PHONE", "請輸入電話");
		}
		if (bean.getMEM_PHONE().length()<=9) {
			this.addFieldError("MEM_PHONE", "電話至少輸入10碼");
		}
		for (int a = 0; a < bean.getMEM_PHONE().length(); a++) {
			System.out.println("bean.getMEM_PHONE" + bean.getMEM_PHONE());
			char checkphone = bean.getMEM_PHONE().charAt(a);
			if (checkphone >= 48 && checkphone <= 57) {

			} else {
				this.addFieldError("MEM_PHONE", "不能輸入中文,亂碼,英文");
			}
		}
	}

	// 執行 並呼叫model
	public String execute() throws Exception {

		MemberService service = new MemberService();
		bean.setMEM_PASSWORD(password.getBytes());
		String sum="";
		if(use.equals("寄送驗證碼")){
			for(int i=0;i<4;i++){
				Integer a=(int)(Math.random()*9)+1;
				String x =a.toString();			
				sum+=x;
			}
			setCheckcode(sum);
			service.sendemail(bean.getMEM_EMAIL(),bean.getMEM_NAME(),checkcode);
			System.out.println("寄信成功");

			
			return INPUT;
		}else{
			service.insert(bean);
			return SUCCESS;
		}
			
	}
}
