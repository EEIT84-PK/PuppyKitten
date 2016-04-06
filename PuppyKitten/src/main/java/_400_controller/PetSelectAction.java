package _400_controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import _400_model.PetBean;
import _400_model.PetImgBean;
import _400_model.PetService;

public class PetSelectAction extends ActionSupport implements ServletRequestAware{
	private HttpServletRequest req;
	
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
	
	public String execute(){
		PetService petService = new PetService();
		PetBean bean= petService.selectId(4000001);
		PetImgBean Imgbean=petService.selectId2(4000001);
		req.setAttribute("bean", bean);
		req.setAttribute("Imgbean", Imgbean);
		return "success";		
	}

	
}
