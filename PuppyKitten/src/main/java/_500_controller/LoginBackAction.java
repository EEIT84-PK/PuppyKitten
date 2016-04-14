package _500_controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginBackAction extends ActionSupport implements ServletRequestAware{
	
	
	private HttpServletRequest req;

	public String execute(){
		HttpSession session=req.getSession();
		session.setAttribute("backLoginOK", "管理員");
		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.req=req;
		
	}
}
