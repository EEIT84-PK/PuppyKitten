package _400_controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import _400_model.PetBean;
import _400_model.PetImgBean;
import _400_model.PetService;
import _400_model.PetSortCatBean;
import _400_model.PetSortDogBean;

public class PetSelectAction extends ActionSupport implements ServletRequestAware {
	private HttpServletRequest req;

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
		PetBean bean = petService.selectId(4001);

		if (bean.getPET_SORT_ID().startsWith("41")) {
			PetSortCatBean Catbean = petService.selectSortCat(bean.getPET_SORT_ID());
			req.setAttribute("Sortbean", Catbean);
			System.out.println(Catbean.getPET_SORT_NAME());
		} else {
			PetSortDogBean Dogbean = petService.selectSortDog(bean.getPET_SORT_ID());
			req.setAttribute("Sortbean", Dogbean);
			System.out.println(Dogbean.getPET_SORT_NAME());
		}
		Date now=new Date();
		long s=(now.getTime()-bean.getPET_AGE().getTime())/1000/ (60 * 60 * 24)/365;
		req.setAttribute("PET_AGE", s);
		
		System.out.println("bean.getPET_AGE().getTime()="+bean.getPET_AGE().getTime());
		
		PetImgBean Imgbean = petService.selectId2(4001);
		req.setAttribute("bean", bean);
		System.out.println("Imgbean.getPET_IMAGE()="+Imgbean.getPET_IMAGE());
		
				req.setAttribute("petImg", Imgbean.getPET_IMAGE());
		
		return "success";
	}

}
