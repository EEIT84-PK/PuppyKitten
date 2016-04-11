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

public class PetRelationAction extends ActionSupport implements ServletRequestAware{
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
		List<PetRelationBean>petRBean=petService.selectRelationAll();
		List<PetBean>petBean=petService.selectAll();
		int likeMeNumber=0;
		for(int i=0;i<petRBean.size();i++){
			if(petRBean.get(i).getINT_MENID_LIKE().equals(req.getSession().getAttribute("memberID").toString())
					&& petRBean.get(i).getINT_STATUS().equals("like")
					){
				System.out.println("有人喜歡我");
				for(int j=0;j<petBean.size();j++){
					if(petBean.get(j).getPET_OWN_ID().toString().equals(petRBean.get(i).getINT_MENID_MYSELF())){
						req.getSession().setAttribute("bean", petBean.get(j));
						if (petBean.get(j).getPET_SORT_ID().startsWith("41")) {//如果抓出來的PET_SORT_ID是41開頭的話
							//用此PET_SORT_ID去找對應的PET_SORT_NAME
							PetSortCatBean Catbean = petService.selectSortCat(petBean.get(j).getPET_SORT_ID());
							req.getSession().removeAttribute("Sortbean");
							req.getSession().setAttribute("Sortbean", Catbean);
						} else {
							PetSortDogBean Dogbean = petService.selectSortDog(petBean.get(j).getPET_SORT_ID());
							req.getSession().removeAttribute("Sortbean");
							req.getSession().setAttribute("Sortbean", Dogbean);
						}

						Date now = new Date();//取得現在時間的所有秒數
						//以下為算出現在時間-資料庫抓出來的出生日的時間再轉換毫秒(/1000)-->轉換天(/60*60*24)-->轉換年(/365)-->就是年齡了
						long s = (now.getTime() - petBean.get(j).getPET_AGE().getTime()) / 1000 / (60 * 60 * 24) / 365;
						req.getSession().removeAttribute("PET_AGE");
						req.getSession().setAttribute("PET_AGE", s);
						req.getSession().removeAttribute("petBean");
						req.getSession().setAttribute("petBean", petBean.get(j));
						PetImgBean Imgbean = petService.selectId2(petBean.get(j).getPET_ID());
						req.getSession().removeAttribute("petImg");
						req.getSession().setAttribute("petImg", Imgbean.getPET_IMAGE());		
					}
				}
			}else{
				System.out.println("目前沒人喜歡我");
			}
		}
		return "success";
	}
}
