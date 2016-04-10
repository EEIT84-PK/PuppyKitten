package _100_controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import _100_model.ArticleBean;
import _100_model.ArticleService;

public class ArticleBackAction extends ActionSupport implements ServletRequestAware{
	
	private ArticleBean bean;
	private HttpServletRequest req;

	public ArticleBean getBean() {
		return bean;
	}
	public void setBean(ArticleBean bean) {
		this.bean = bean;
	}
	
	
	public String execute(){
		ArticleService service = new ArticleService();
		List<ArticleBean> list = service.selectAll();
		req.setAttribute("select", list);
		
		return SUCCESS;
	}
	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.req=req;
	}
	

}
