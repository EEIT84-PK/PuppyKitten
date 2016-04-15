package _400_controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import _400_model.PetBean;
import _400_model.PetImgBean;
import _400_model.PetService;
import _400_model.PetSortCatBean;
import _400_model.PetSortDogBean;

public class PetUpdateAction extends ActionSupport implements ServletRequestAware{	
	private HttpServletRequest req;		
	private PetBean petBean;	
	private SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
	private String date;
		
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public PetBean getPetBean() {
		return petBean;
	}

	public void setPetBean(PetBean petBean) {
		this.petBean = petBean;
	}

	public HttpServletRequest getReq() {
		return req;
	}

	public void setReq(HttpServletRequest req) {
		this.req = req;
	}

	public void setServletRequest(HttpServletRequest req) {
		this.req = req;
	}	
	public String execute(){
		PetService petService=new PetService();
		HttpSession session=req.getSession();		
		List<PetBean> selectKing = petService.selecPettId((Integer) session.getAttribute("memberID"));
		this.setDate(sFormat.format(selectKing.get(0).getPET_AGE()));
		if (selectKing.get(0).getPET_SORT_ID().startsWith("41")) {			
			PetSortCatBean Catbean = petService.selectSortCat(selectKing.get(0).getPET_SORT_ID());			
			session.setAttribute("Sortbean", Catbean);			
		} else {			
			PetSortDogBean Dogbean = petService.selectSortDog(selectKing.get(0).getPET_SORT_ID());			
			session.setAttribute("Sortbean", Dogbean);			
		}
		session.setAttribute("petBean", selectKing.get(0));
		session.setAttribute("date", date);
		return "success";
	}
}
