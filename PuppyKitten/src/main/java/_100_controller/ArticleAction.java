package _100_controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class ArticleAction  extends ActionSupport implements ServletRequestAware{

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		
	}
	public String execute(){
		
		
		return SUCCESS;
	}
}
