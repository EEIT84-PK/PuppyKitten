package _400_controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
		String numberStr = (String) req.getSession().getAttribute("PetNumber");// 第一次到此number有可能是0或1
																				// 如果一開始是自己傳過來就是1
		req.getSession().removeAttribute("PetNumber");// 為了避免之後要再傳值有衝突
														// 所以把原本的number從session移除
		int number = Integer.parseInt(numberStr); // 將String轉成Integer(此number為正在感興趣的對象編號)
		List<PetBean> petBean = petService.selectAll();
		
		PetRelationBean Rbean = new PetRelationBean();
		Rbean.setINT_MENID_MYSELF(req.getSession().getAttribute("memberID").toString());// 登入者的會員編號
		Rbean.setINT_MENID_LIKE(petBean.get(number).getPET_OWN_ID().toString());// 正在感興趣對象的主人編號
		Rbean.setINT_STATUS("Notlike");

		PetRelationBean RbeanInsert = petService.insert(Rbean);
		
		if(number==0){
			int checkSelf=number+1;//先確認下一筆是不是自己
			if(petBean.get(checkSelf).getPET_OWN_ID().equals(req.getSession().getAttribute("memberID"))){
				int checkNumber=number+2;
				if(checkNumber==petBean.size()){
					req.getSession().removeAttribute("end");
					req.getSession().setAttribute("end", "已經沒有可感興趣的對象");
					return "end";
				}
			}			
		}		
		
		int number2=number+1;//這邊+1是因為下一個不是自己 但是有可能超出範圍
		if(number2==petBean.size()){
			req.getSession().removeAttribute("end");
			req.getSession().setAttribute("end", "已經沒有可感興趣的對象");
			return "end";
		}
		
		if(petBean.get(number2).getPET_OWN_ID().equals(req.getSession().getAttribute("memberID"))){
			req.getSession().removeAttribute("end");
			req.getSession().setAttribute("end", "已經沒有可感興趣的對象");
			return "end";//如果最後一筆是自己直接轉到END頁面
		}
		
		number++;// 下一個要讓使用者感興趣的對象編號

		if (petBean.get(number).getPET_SORT_ID().startsWith("41")) {
			PetSortCatBean Catbean = petService.selectSortCat(petBean.get(number).getPET_SORT_ID());
			req.getSession().removeAttribute("Sortbean");
			req.getSession().setAttribute("Sortbean", Catbean);
		} else {
			PetSortDogBean Dogbean = petService.selectSortDog(petBean.get(number).getPET_SORT_ID());
			req.getSession().removeAttribute("Sortbean");
			req.getSession().setAttribute("Sortbean", Dogbean);
		}

		Date now = new Date();
		long s = (now.getTime() - petBean.get(number).getPET_AGE().getTime()) / 1000 / (60 * 60 * 24) / 365;
		req.getSession().removeAttribute("PET_AGE");
		req.getSession().setAttribute("PET_AGE", s);
		req.getSession().removeAttribute("petBean");
		req.getSession().setAttribute("petBean", petBean.get(number));
		PetImgBean Imgbean = petService.selectId2(petBean.get(number).getPET_ID());
		req.getSession().removeAttribute("petImg");
		req.getSession().setAttribute("petImg", Imgbean.getPET_IMAGE());
		req.getSession().setAttribute("PetNumber", ((Integer) number).toString());// 將此次number再丟進session給下一次用

		return "success";

	}
}
