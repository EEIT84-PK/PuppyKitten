package _400_controller;

import java.util.ArrayList;
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

public class PetLikeAction extends ActionSupport implements ServletRequestAware {
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
		HttpSession session = req.getSession();
		String numberStr = (String) session.getAttribute("PetNumber");
		session.removeAttribute("PetNumber");// 為了避免之後要再傳值有衝突
												// 所以把原本的number從session移除
		int number = Integer.parseInt(numberStr); // 將String轉成Integer(此number為正在感興趣的對象編號)
		List<PetBean> petBean = petService.selectAll();
		PetRelationBean Rbean = new PetRelationBean();
		Rbean.setINT_MENID_MYSELF(session.getAttribute("memberID").toString());// 登入者的會員編號
		Rbean.setINT_MENID_LIKE(petBean.get(number).getPET_OWN_ID().toString());// 正在感興趣對象的主人編號
		Rbean.setINT_STATUS("like");

		PetRelationBean RbeanInsert = petService.insert(Rbean);
		List<PetBean> selectKing = petService.selecPettId((Integer) session.getAttribute("memberID"));
		List<PetRelationBean> check = new ArrayList<PetRelationBean>();
		List<PetRelationBean> check2 = new ArrayList<PetRelationBean>();
		number++;		
		while (number < petBean.size()) {
			if (petBean.get(number).getPET_KING().equals(selectKing.get(0).getPET_KING())
					&& !petBean.get(number).getPET_SEX().equals(selectKing.get(0).getPET_SEX())) { // 如果是同類而且非同性的話
				check = petService.selectId(session.getAttribute("memberID").toString(),
						petBean.get(number).getPET_OWN_ID().toString(), "like");
				check2 = petService.selectId(session.getAttribute("memberID").toString(),
						petBean.get(number).getPET_OWN_ID().toString(), "Notlike");
				/*
				 * check=找喜歡人的人是自己 被喜歡的人是這次的人 狀態為喜歡 check2=找喜歡人的人是自己 被喜歡的人是這次的人
				 * 狀態為不喜歡
				 */
				if (!check.isEmpty() || !check2.isEmpty()) {
					number++;// 跳下一筆
					check.clear();
					check2.clear();
					if (number == petBean.size()) {
						session.setAttribute("end", "已經沒有可感興趣的對象");
						return "end";
					}
				} else {
					break;// 離開迴圈
				}
			} else if ((!(petBean.get(number).getPET_KING().equals(selectKing.get(0).getPET_KING())))
					|| (petBean.get(number).getPET_KING().equals(selectKing.get(0).getPET_KING())
							&& petBean.get(number).getPET_SEX().equals(selectKing.get(0).getPET_SEX()))) {// 如果是非同類或者同類同性的話
				number++;// 跳下一筆

				if (number == petBean.size()) {
					session.setAttribute("end", "已經沒有可感興趣的對象");
					return "end";
				} else {
					// 但是有可能下一筆是自己，所以再跳下一筆
					if (petBean.get(number).getPET_OWN_ID().toString()
							.equals(session.getAttribute("memberID").toString())) {
						number++;
					}
				}
				if (number == petBean.size()) {
					session.setAttribute("end", "已經沒有可感興趣的對象");
					return "end";
				}
			}
		}

		if (number == petBean.size()) {
			session.setAttribute("end", "已經沒有可感興趣的對象");
			return "end";
		}

		if (petBean.get(number).getPET_SORT_ID().startsWith("41")) {
			PetSortCatBean Catbean = petService.selectSortCat(petBean.get(number).getPET_SORT_ID());
			session.setAttribute("Sortbean", Catbean);
		} else {
			PetSortDogBean Dogbean = petService.selectSortDog(petBean.get(number).getPET_SORT_ID());
			session.setAttribute("Sortbean", Dogbean);
		}

		Date now = new Date();
		long s = (now.getTime() - petBean.get(number).getPET_AGE().getTime()) / 1000 / (60 * 60 * 24) / 365;
		session.setAttribute("PET_AGE", s);
		session.setAttribute("petBean", petBean.get(number));
		PetImgBean Imgbean = petService.selectId2(petBean.get(number).getPET_ID());
		session.setAttribute("petImg", Imgbean.getPET_IMAGE());
		session.setAttribute("PetNumber", ((Integer) number).toString());// 將此次number再丟進session給下一次用

		return "success";

	}
}
