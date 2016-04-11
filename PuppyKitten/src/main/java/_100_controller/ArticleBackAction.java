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
	private String use="";
	public ArticleBean getBean() {
		return bean;
	}
	public void setBean(ArticleBean bean) {
		this.bean = bean;
	}
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	
	public String execute(){
		
		ArticleService service = new ArticleService();
		List<ArticleBean> list;
		if(use.equals("kind")){
			list = service.selectAllKind();
		}else if(use.equals("time")){
			list = service.selectAllTime();
		}else if(use.equals("hot")){
			list = service.selectAllHot();
		}else{
			list = service.selectAll();
		}
		
		req.setAttribute("select", list);
		
		return SUCCESS;
	}
	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.req=req;
	}
	

}
