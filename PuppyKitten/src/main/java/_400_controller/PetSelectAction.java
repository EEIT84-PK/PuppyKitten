package _400_controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;

import _400_model.PetBean;
import _400_model.PetImgBean;
import _400_model.PetService;
import _400_model.PetSortCatBean;
import _400_model.PetSortDogBean;


public class PetSelectAction extends ActionSupport implements ServletRequestAware {
	private HttpServletRequest req;	
	private PetBean petBean;
	
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

	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.req = req;

	}
	
	public String execute() {

		PetService petService = new PetService();			
		HttpSession session=req.getSession();
		List<PetBean> petBean=petService.selecPettId((Integer)session.getAttribute("memberID"));
				
		if (petBean.get(0).getPET_SORT_ID().startsWith("41")) {			
			PetSortCatBean Catbean = petService.selectSortCat(petBean.get(0).getPET_SORT_ID());			
			session.setAttribute("Sortbean", Catbean);			
		} else {			
			PetSortDogBean Dogbean = petService.selectSortDog(petBean.get(0).getPET_SORT_ID());			
			session.setAttribute("Sortbean", Dogbean);			
		}
		
		Date now=new Date();
		long s=(now.getTime()-petBean.get(0).getPET_AGE().getTime())/1000/ (60 * 60 * 24)/365;		
		session.setAttribute("PET_AGE", s);		
		PetImgBean Imgbean = petService.selectId2(petBean.get(0).getPET_ID());		
		session.setAttribute("bean", petBean.get(0));	
		session.setAttribute("petImg", Imgbean.getPET_IMAGE());
		
		return "success";
	}

	

}
