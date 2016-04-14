package _500_controller;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import _500_model.MemberBean;
import _500_model.MemberService;

public class SelectAction extends ActionSupport implements ServletRequestAware {

	private MemberBean bean;
	private HttpServletRequest request;
    private String password;
    private String Date;
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}
    
	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MemberBean getBean() {
		return bean;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setBean(MemberBean bean) {
		this.bean = bean;
	}
	

	public String execute() {
		MemberService service = new MemberService();
		HttpSession session = request.getSession();
		List<MemberBean> list = service.selectMemberById((Integer)session.getAttribute("memberID"));
		session.setAttribute("bean", list.get(0));
		
		return SUCCESS;
	}

}
