package _400_controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;

import _400_model.PetBean;
import _400_model.PetImgBean;
import _400_model.PetService;
import _400_model.PetSortCatBean;
import _400_model.PetSortDogBean;

public class PetFriendshipAction extends ActionSupport implements ServletRequestAware {
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
		List<PetBean> petBean = petService.selectAll();// 先將所有寵物資訊抓出來放到petBean內		
		int number = 0;// 設定初始值為抓第一筆資料		
		
		if (petBean.get(number).getPET_OWN_ID().equals(req.getSession().getAttribute("memberID"))) {
			int number2=number+1;//用來跟lise的size做比對
			if (number2==petBean.size()) {//因為如果list.get(index)==list.size 會有錯誤
				req.getSession().removeAttribute("end");
				req.getSession().setAttribute("end", "已經沒有可感興趣的對象");
				return "end";
			} else {				
				number++;//這邊是指如果這次查的是自己 那要改成秀下一個編號的寵物

				if (petBean.get(number).getPET_SORT_ID().startsWith("41")) {//如果抓出來的PET_SORT_ID是41開頭的話
					//用此PET_SORT_ID去找對應的PET_SORT_NAME
					PetSortCatBean Catbean = petService.selectSortCat(petBean.get(number).getPET_SORT_ID());
					req.getSession().removeAttribute("Sortbean");
					req.getSession().setAttribute("Sortbean", Catbean);
				} else {
					PetSortDogBean Dogbean = petService.selectSortDog(petBean.get(number).getPET_SORT_ID());
					req.getSession().removeAttribute("Sortbean");
					req.getSession().setAttribute("Sortbean", Dogbean);
				}

				Date now = new Date();//取得現在時間的所有秒數
				//以下為算出現在時間-資料庫抓出來的出生日的時間再轉換毫秒(/1000)-->轉換天(/60*60*24)-->轉換年(/365)-->就是年齡了
				long s = (now.getTime() - petBean.get(number).getPET_AGE().getTime()) / 1000 / (60 * 60 * 24) / 365;
				req.getSession().removeAttribute("PET_AGE");
				req.getSession().setAttribute("PET_AGE", s);
				req.getSession().removeAttribute("petBean");
				req.getSession().setAttribute("petBean", petBean.get(number));
				PetImgBean Imgbean = petService.selectId2(petBean.get(number).getPET_ID());
				req.getSession().removeAttribute("petImg");
				req.getSession().setAttribute("petImg", Imgbean.getPET_IMAGE());				
				req.getSession().setAttribute("PetNumber", ((Integer)number).toString());//傳過去number=1
				return "success";
			}

		} else {			
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
			req.getSession().setAttribute("PetNumber", ((Integer)number).toString());//傳過去number=0
			return "success";
		}
	}
}
