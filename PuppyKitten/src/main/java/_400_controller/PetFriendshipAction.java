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
		List<PetRelationBean>petRBean=petService.selectRelationAll();		
		HttpSession session=req.getSession();
		List<PetBean>selectKing=petService.selecPettId((Integer)session.getAttribute("memberID"));
		System.out.println("selectKing="+selectKing.get(0).getPET_KING());
		int number = 0;// 設定初始值為抓第一筆資料
		int number2=number+1;//用來跟lise的size做比對
		int check=0;
		if (petBean.get(number).getPET_OWN_ID().equals(session.getAttribute("memberID"))) {			
			if (number2==petBean.size()) {//因為如果list.get(index)==list.size 會有錯誤				
				session.setAttribute("end", "已經沒有可感興趣的對象");
				return "end";
			} else {				
				number++;//這邊是指如果這次查的是自己 那要改成秀下一個編號的寵物
				
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
				
				for(int i=0;i<petRBean.size();i++){
					for(int j=number;j<petBean.size();j++){
						if(petRBean.get(i).getINT_MENID_MYSELF().equals(session.getAttribute("memberID").toString())
								&&petRBean.get(i).getINT_MENID_LIKE().equals(petBean.get(j).getPET_OWN_ID().toString())){							
							number++;
							break;
						}						
					}
				}				
				
				if(number==petBean.size()){					
					session.setAttribute("end", "已經沒有可感興趣的對象");
					return "end";
				}				
			}
		} else {
			
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
			
			for(int i=0;i<petRBean.size();i++){
				if(petRBean.get(i).getINT_MENID_MYSELF().equals(session.getAttribute("memberID").toString())){
					for(int j=0;j<petBean.size();j++){					
						if(petRBean.get(i).getINT_MENID_LIKE().equals(petBean.get(j).getPET_OWN_ID().toString())){							
							number++;							
							break;
						}else {
							if(session.getAttribute("memberID").toString().equals(petBean.get(j).getPET_OWN_ID().toString())){
								if(check!=1){									
									number++;
									check++;									
								}							
							}
						}					
					}
				}				
			}				
		}		

		if(number==petBean.size()){
			session.setAttribute("end", "已經沒有可感興趣的對象");
			return "end";
		}		
		
		//number有可能+2或3 如果喜歡的人連續+2 如果喜歡的人中間卡自己+3
		if(petBean.get(number).getPET_OWN_ID().equals(session.getAttribute("memberID"))){
			number++;			
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
			session.setAttribute("end", "已經沒有可感興趣的對象");
			return "end";
		}		
		
		if (petBean.get(number).getPET_SORT_ID().startsWith("41")) {//如果抓出來的PET_SORT_ID是41開頭的話
			//用此PET_SORT_ID去找對應的PET_SORT_NAME
			PetSortCatBean Catbean = petService.selectSortCat(petBean.get(number).getPET_SORT_ID());			
			session.setAttribute("Sortbean", Catbean);
		} else {
			PetSortDogBean Dogbean = petService.selectSortDog(petBean.get(number).getPET_SORT_ID());			
			session.setAttribute("Sortbean", Dogbean);
		}

		Date now = new Date();//取得現在時間的所有秒數
		//以下為算出現在時間-資料庫抓出來的出生日的時間再轉換毫秒(/1000)-->轉換天(/60*60*24)-->轉換年(/365)-->就是年齡了
		long s = (now.getTime() - petBean.get(number).getPET_AGE().getTime()) / 1000 / (60 * 60 * 24) / 365;			
		session.setAttribute("PET_AGE", s);				
		session.setAttribute("petBean", petBean.get(number));
		PetImgBean Imgbean = petService.selectId2(petBean.get(number).getPET_ID());				
		session.setAttribute("petImg", Imgbean.getPET_IMAGE());				
		session.setAttribute("PetNumber", ((Integer)number).toString());		
		return "success";
		
	}
}
