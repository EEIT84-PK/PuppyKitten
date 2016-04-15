package _400_controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import _400_model.PetAllBean;
import _400_model.PetBean;
import _400_model.PetImgBean;
import _400_model.PetRelationBean;
import _400_model.PetService;
import _400_model.PetSortCatBean;
import _400_model.PetSortDogBean;

public class PetRelationDeleteAction extends ActionSupport implements ServletRequestAware{
	private HttpServletRequest req;

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
		PetService petService = new PetService();		
		List<PetRelationBean> petRBean = petService.selectRelationAll();
		HttpSession session=req.getSession();
		PetRelationBean Rbean = new PetRelationBean();
		Rbean.setINT_MENID_MYSELF(session.getAttribute("memberID").toString());// 登入者的會員編號
		Rbean.setINT_MENID_LIKE(req.getParameter("PET_OWN_ID").toString());// 正在感興趣對象的主人編號
		Rbean.setINT_STATUS("like");
		PetRelationBean RDelete=petService.delete(Rbean);
		
		List<PetRelationBean> RBean = petService.selectRelationAll();
		List<PetBean> petBean = petService.selectAll();
		List<PetAllBean> list = new ArrayList<PetAllBean>();
		for (int i = 0; i < RBean.size(); i++) {
			if (RBean.get(i).getINT_MENID_MYSELF().equals(session.getAttribute("memberID").toString())
					&& RBean.get(i).getINT_STATUS().equals("like")) {
				List<PetRelationBean> RSelect = petService.selectId(RBean.get(i).getINT_MENID_LIKE(),
						session.getAttribute("memberID").toString(), "like");
				if (!RSelect.isEmpty()) {
					for (int j = 0; j < petBean.size(); j++) {
						if (petBean.get(j).getPET_OWN_ID().toString().equals(RBean.get(i).getINT_MENID_LIKE())) {
							PetAllBean petAllBean = new PetAllBean();
							petAllBean.setPET_ID(petBean.get(j).getPET_ID().toString());// 將喜歡自己的人的PET_ID放入petAllBean
							petAllBean.setPET_OWN_ID(petBean.get(j).getPET_OWN_ID().toString());
							petAllBean.setPET_NAME(petBean.get(j).getPET_NAME().toString());
							petAllBean.setPET_WEIGHT(petBean.get(j).getPET_WEIGHT().toString());
							petAllBean.setPET_KING(petBean.get(j).getPET_KING().toString());
							petAllBean.setPET_SEX(petBean.get(j).getPET_SEX().toString());
							petAllBean.setPET_BODY(petBean.get(j).getPET_BODY().toString());

							if (petBean.get(j).getPET_SORT_ID().startsWith("41")) {
								PetSortCatBean Catbean = petService.selectSortCat(petBean.get(j).getPET_SORT_ID());
								petAllBean.setPET_SORT_NAME(Catbean.getPET_SORT_NAME());

							} else {
								PetSortDogBean Dogbean = petService.selectSortDog(petBean.get(j).getPET_SORT_ID());
								petAllBean.setPET_SORT_NAME(Dogbean.getPET_SORT_NAME());
							}

							Date now = new Date();
							long PET_AGE = (now.getTime() - petBean.get(j).getPET_AGE().getTime()) / 1000
									/ (60 * 60 * 24) / 365;
							petAllBean.setPET_AGE(PET_AGE);
							PetImgBean Imgbean = petService.selectId2(petBean.get(j).getPET_ID());
							petAllBean.setPET_IMAGE(Imgbean.getPET_IMAGE());
							list.add(petAllBean);

						}
					}
				}
			}
		}
		if(!list.isEmpty()){
			session.removeAttribute("noOne");
			session.setAttribute("list", list);
		}else{
			session.removeAttribute("list");
			session.removeAttribute("list2");
			session.setAttribute("noOne", "目前沒有互相感興趣的對象");
		}
		
		return "success";
	}
}
