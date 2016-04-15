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

public class PetRelationNotLikeAction extends ActionSupport implements ServletRequestAware{
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
		HttpSession session=req.getSession();		
		PetRelationBean Rbean = new PetRelationBean();
		Rbean.setINT_MENID_MYSELF(req.getSession().getAttribute("memberID").toString());// 登入者的會員編號
		Rbean.setINT_MENID_LIKE(req.getParameter("PET_OWN_ID").toString());// 正在感興趣對象的主人編號
		Rbean.setINT_STATUS("Notlike");

		List<PetRelationBean>RSelect=petService.selectId(session.getAttribute("memberID").toString(), 
				req.getParameter("PET_OWN_ID").toString(),"Notlike");
		
		if(RSelect.isEmpty()){
			PetRelationBean RbeanInsert = petService.insert(Rbean);
		}
		
		List<PetBean> petBean = petService.selectAll();
		
		List<PetAllBean> list = new ArrayList<PetAllBean>();
		List<PetRelationBean> petRBean = petService.selectRelationAll();
		for (int i = 0; i < petRBean.size(); i++) {
			if (petRBean.get(i).getINT_MENID_LIKE().equals(session.getAttribute("memberID").toString())
					&& petRBean.get(i).getINT_STATUS().equals("like")) {
				List<PetRelationBean>RSelect2=petService.selectId(session.getAttribute("memberID").toString(),
						petRBean.get(i).getINT_MENID_MYSELF(), "like");
				if(RSelect2.isEmpty()){
					for (int j = 0; j < petBean.size(); j++) {
						if (petRBean.get(i).getINT_MENID_MYSELF()
								.equals(petBean.get(j).getPET_OWN_ID().toString())) {
							PetAllBean petAllBean = new PetAllBean();
							petAllBean.setPET_ID(petBean.get(j).getPET_ID().toString());// 將喜歡自己的人的PET_ID放入petAllBean
							petAllBean.setPET_OWN_ID(petBean.get(j).getPET_OWN_ID().toString());
							petAllBean.setPET_NAME(petBean.get(j).getPET_NAME().toString());
							petAllBean.setPET_WEIGHT(petBean.get(j).getPET_WEIGHT().toString());
							petAllBean.setPET_KING(petBean.get(j).getPET_KING().toString());
							petAllBean.setPET_SEX(petBean.get(j).getPET_SEX().toString());
							petAllBean.setPET_BODY(petBean.get(j).getPET_BODY().toString());
							if (petBean.get(j).getPET_OWN_ID().toString()
									.equals(petRBean.get(i).getINT_MENID_MYSELF())) {
								if (petBean.get(j).getPET_SORT_ID().startsWith("41")) {
									PetSortCatBean Catbean = petService
											.selectSortCat(petBean.get(j).getPET_SORT_ID());
									petAllBean.setPET_SORT_NAME(Catbean.getPET_SORT_NAME());

								} else {
									PetSortDogBean Dogbean = petService
											.selectSortDog(petBean.get(j).getPET_SORT_ID());
									petAllBean.setPET_SORT_NAME(Dogbean.getPET_SORT_NAME());
								}

								Date now = new Date();
								long PET_AGE = (now.getTime() - petBean.get(j).getPET_AGE().getTime()) / 1000
										/ (60 * 60 * 24) / 365;
								petAllBean.setPET_AGE(PET_AGE);
								PetImgBean Imgbean = petService.selectId2(petBean.get(j).getPET_ID());
								petAllBean.setPET_IMAGE(Imgbean.getPET_IMAGE());
								
								for(int q=0;q<petRBean.size();q++){
									if(session.getAttribute("memberID").toString().equals(petRBean.get(q).getINT_MENID_MYSELF())
											&&petRBean.get(q).getINT_MENID_LIKE().equals(petRBean.get(i).getINT_MENID_MYSELF())
											&&petRBean.get(q).getINT_STATUS().equals("Notlike")
											){
										petAllBean.setPET_CHECK(1);
									}
								}
								
								list.add(petAllBean);		
								
							}
						}
					}					
				}
			}
		}
		
		if(!list.isEmpty()){
			session.setAttribute("list", list);			
			session.removeAttribute("noOne");
		}else{
			session.removeAttribute("list");			
			session.setAttribute("noOne", "目前沒人喜歡你");
		}
		
		return "success";
	}
}
