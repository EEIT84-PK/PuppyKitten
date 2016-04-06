package _100_controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import _100_model.ArticleBean;
import _100_model.ArticleService;

@SuppressWarnings("serial")
public class ArticleAction  extends ActionSupport implements ServletRequestAware{
	
	private ArticleBean bean;
	private HttpServletRequest req;
	
	public ArticleBean getBean() {
		return bean;
	}
	public void setBean(ArticleBean bean) {
		this.bean = bean;
	}
	public HttpServletRequest getReq() {
		return req;
	}
	public void setReq(HttpServletRequest req) {
		this.req = req;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.req=req;
	}
	@SuppressWarnings("unused")
	public String execute(){
		ArticleService service= new ArticleService();
		List<ArticleBean> list=null;
			list = service.selectAll();
		List<ArticleBean> sort=null;
			sort = service.selectSort();
		req.setAttribute("select",list);
		req.setAttribute("sort",list);
		return SUCCESS;
	}
}
