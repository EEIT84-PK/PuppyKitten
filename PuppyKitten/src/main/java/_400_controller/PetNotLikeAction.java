package _400_controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import _400_model.PetBean;
import _400_model.PetImgBean;
import _400_model.PetRelationBean;
import _400_model.PetService;
import _400_model.PetSortCatBean;
import _400_model.PetSortDogBean;

public class PetNotLikeAction extends ActionSupport implements ServletRequestAware{
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

	public String execute() {
		PetService petService = new PetService();
		HttpSession session=req.getSession();
		String numberStr = (String) req.getSession().getAttribute("PetNumber");		
		session.removeAttribute("PetNumber");// 為了避免之後要再傳值有衝突
														// 所以把原本的number從session移除
		int number = Integer.parseInt(numberStr); // 將String轉成Integer(此number為正在感興趣的對象編號)
		List<PetBean> petBean = petService.selectAll();		
				
		PetRelationBean Rbean = new PetRelationBean();
		Rbean.setINT_MENID_MYSELF(session.getAttribute("memberID").toString());// 登入者的會員編號
		Rbean.setINT_MENID_LIKE(petBean.get(number).getPET_OWN_ID().toString());// 正在感興趣對象的主人編號
		Rbean.setINT_STATUS("Notlike");

		PetRelationBean RbeanInsert = petService.insert(Rbean);
		List<PetBean>selectKing=petService.selecPettId((Integer)session.getAttribute("memberID"));
		if(number==0){
			int checkSelf=number+1;//先確認下一筆是不是自己
			if(petBean.get(checkSelf).getPET_OWN_ID().equals(session.getAttribute("memberID"))){
				int checkNumber=checkSelf+1;
				if(checkNumber==petBean.size()){
					session.removeAttribute("end");
					session.setAttribute("end", "已經沒有可感興趣的對象");
					return "end";
				}
			}			
		}				
		
		for(int q=number;q<petBean.size();q++){
			if(!petBean.get(number).getPET_KING().equals(selectKing.get(0).getPET_KING())
					||petBean.get(number).getPET_KING().equals(selectKing.get(0).getPET_KING())							
					&&petBean.get(number).getPET_SEX().equals(selectKing.get(0).getPET_SEX())
					){
				number++;
			}else{
				break;
			}
		}
		
		int check2=number+1;
		if(check2==petBean.size()){
			session.removeAttribute("end");
			session.setAttribute("end", "已經沒有可感興趣的對象");
			return "end";
		}
		
		number++;// 下一個要讓使用者感興趣的對象編號
		
		for(int q=number;q<petBean.size();q++){
			if(!petBean.get(number).getPET_KING().equals(selectKing.get(0).getPET_KING())
					||petBean.get(number).getPET_KING().equals(selectKing.get(0).getPET_KING())							
					&&petBean.get(number).getPET_SEX().equals(selectKing.get(0).getPET_SEX())
					){
				number++;
			}else{
				break;
			}
		}
		
		int check=number;
		if(check==petBean.size()){
			session.removeAttribute("end");
			session.setAttribute("end", "已經沒有可感興趣的對象");
			return "end";
		}
		
		if(petBean.get(number).getPET_OWN_ID().equals(req.getSession().getAttribute("memberID"))){
			number++;			
			if(number==petBean.size()){
				session.removeAttribute("end");
				session.setAttribute("end", "已經沒有可感興趣的對象");
				return "end";
			}
		}
		
		for(int q=number;q<petBean.size();q++){
			if(!petBean.get(number).getPET_KING().equals(selectKing.get(0).getPET_KING())
					||petBean.get(number).getPET_KING().equals(selectKing.get(0).getPET_KING())							
					&&petBean.get(number).getPET_SEX().equals(selectKing.get(0).getPET_SEX())
					){
				number++;
			}else{
				break;
			}
		}
		
		if(number==petBean.size()){
			session.removeAttribute("end");
			session.setAttribute("end", "已經沒有可感興趣的對象");
			return "end";
		}
		
		if (petBean.get(number).getPET_SORT_ID().startsWith("41")) {
			PetSortCatBean Catbean = petService.selectSortCat(petBean.get(number).getPET_SORT_ID());
			session.removeAttribute("Sortbean");
			session.setAttribute("Sortbean", Catbean);
		} else {
			PetSortDogBean Dogbean = petService.selectSortDog(petBean.get(number).getPET_SORT_ID());
			session.removeAttribute("Sortbean");
			session.setAttribute("Sortbean", Dogbean);
		}

		Date now = new Date();
		long s = (now.getTime() - petBean.get(number).getPET_AGE().getTime()) / 1000 / (60 * 60 * 24) / 365;
		session.removeAttribute("PET_AGE");
		session.setAttribute("PET_AGE", s);
		session.removeAttribute("petBean");
		session.setAttribute("petBean", petBean.get(number));
		PetImgBean Imgbean = petService.selectId2(petBean.get(number).getPET_ID());
		session.removeAttribute("petImg");
		session.setAttribute("petImg", Imgbean.getPET_IMAGE());
		session.setAttribute("PetNumber", ((Integer) number).toString());// 將此次number再丟進session給下一次用

		return "success";

	}
}
