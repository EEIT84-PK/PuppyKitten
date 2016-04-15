package _500_controller;




import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.jboss.jandex.Main;

import _500_model.MemberBean;
import _500_model.MemberService;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UpdateAction extends ActionSupport implements ServletRequestAware {
	private MemberBean memberBean;
	private HttpServletRequest request;
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}
    private String date;
    
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	public MemberBean getMemberBean() {
		return memberBean;
	}

	public void setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
	}

	public void validate() {

		if (memberBean.getMEM_NAME() == null
				|| memberBean.getMEM_NAME().trim().length() == 0) {
			this.addFieldError("MEM_NAME", "請輸入姓名");
		}
		for (int i = 0; i < memberBean.getMEM_NAME().length(); i++) {
			char name = memberBean.getMEM_NAME().charAt(i);
			if (name >= 65 && name <= 90 || name >= 97 && name <= 122
					|| (int) name >= 19968 && (int) name <= 40623) {
			} else {
				this.addFieldError("MEM_NAME", "請輸入中,英文");
			}
		}

		if (memberBean.getMEM_IDCARD() == null
				|| memberBean.getMEM_IDCARD().trim().length() == 0) {
			this.addFieldError("MEM_IDCARD", "請輸入身分證字號");
		}

		if (memberBean.getMEM_EMAIL() == null
				|| memberBean.getMEM_EMAIL().trim().length() == 0) {
			this.addFieldError("MEM_EMAIL", "請輸入E-MAIL");
		}

		if (memberBean.getMEM_BIRTHDAY() == null) {
			this.addFieldError("MEM_BIRTHDAY", "請輸入生日");
		}else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			setDate(sdf.format(memberBean.getMEM_BIRTHDAY()));
		}

		if (memberBean.getMEM_ADD() == null || memberBean.getMEM_ADD().trim().length() == 0) {
			this.addFieldError("MEM_ADD", "請輸入地址");
		}
		for (
              int k = 0; k < memberBean.getMEM_ADD().length(); k++){
					char charadd = memberBean.getMEM_ADD().charAt(k);
					if ((int) charadd >= 19968 && (int) charadd <= 40623 || charadd >= 48 && charadd <= 57) {

					} else {
						this.addFieldError("MEM_ADD", "請輸入中文,數字");
					}
				}

		if (memberBean.getMEM_PHONE() == null
				|| memberBean.getMEM_PHONE().trim().length() == 0) {
			this.addFieldError("MEM_PHONE", "請輸入電話");
		}
		if (memberBean.getMEM_PHONE().length() <= 9) {
			this.addFieldError("MEM_PHONE", "電話至少輸入10碼");
		}
		for (int a = 0; a < memberBean.getMEM_PHONE().length(); a++) {
			char checkphone = memberBean.getMEM_PHONE().charAt(a);
			if (checkphone >= 48 && checkphone <= 57) {

			} else {
				this.addFieldError("MEM_PHONE", "不能輸入中文,亂碼,英文");
			}
		}
	}
	public String execute() throws Exception {
		MemberService service = new MemberService();
		
       	if (memberBean != null) {
       		service.update(memberBean);
       		HttpSession session = request.getSession();
    		MemberBean memberBean = service.selectMemberById((Integer)session.getAttribute("memberID"));
    		session.setAttribute("loginOK", memberBean.getMEM_NAME());
  
       		return SUCCESS;
		} else {
			return INPUT;
		}
	}
}
