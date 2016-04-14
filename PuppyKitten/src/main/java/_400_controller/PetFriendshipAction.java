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
		List<PetRelationBean> petRBean = petService.selectRelationAll();
		HttpSession session = req.getSession();
		List<PetBean> selectKing = petService.selecPettId((Integer) session.getAttribute("memberID"));
		int number = 0;// 設定初始值為抓第一筆資料
		int number2 = number + 1;// 用來跟lise的size做比對
		List<PetRelationBean> check = new ArrayList<PetRelationBean>();
		List<PetRelationBean> check2 = new ArrayList<PetRelationBean>();
		if (petBean.get(number).getPET_OWN_ID().toString().equals(session.getAttribute("memberID").toString())) {// 如果第一筆為自己
			if (number2 == petBean.size()) { // 如果只有自己一個寵物資訊，代表沒有可感興趣的對象
				session.setAttribute("end", "已經沒有可感興趣的對象");
				return "end";
			} else {
				number++;// 跳下一筆
			}

			while (number < petBean.size()) {
				if (petBean.get(number).getPET_KING().equals(selectKing.get(0).getPET_KING())
						&& (!(petBean.get(number).getPET_SEX().equals(selectKing.get(0).getPET_SEX())))) { // 如果是同類而且非同性的話
					check = petService.selectId(session.getAttribute("memberID").toString(),
							petBean.get(number).getPET_OWN_ID().toString(), "like");
					check2 = petService.selectId(session.getAttribute("memberID").toString(),
							petBean.get(number).getPET_OWN_ID().toString(), "Notlike");
					/*
					 * check=找喜歡人的人是自己 被喜歡的人是這次的人 狀態為喜歡 check2=找喜歡人的人是自己
					 * 被喜歡的人是這次的人 狀態為不喜歡
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
					}
				}
			}
		} else {// 如果第一筆不是自己
			while (number < petBean.size()) {
				if (petBean.get(number).getPET_KING().equals(selectKing.get(0).getPET_KING())
						&& (!(petBean.get(number).getPET_SEX().equals(selectKing.get(0).getPET_SEX())))) { // 如果是同類而且非同性的話
					check = petService.selectId(session.getAttribute("memberID").toString(),
							petBean.get(number).getPET_OWN_ID().toString(), "like");
					check2 = petService.selectId(session.getAttribute("memberID").toString(),
							petBean.get(number).getPET_OWN_ID().toString(), "Notlike");
					/*
					 * check=找喜歡人的人是自己 被喜歡的人是這次的人 狀態為喜歡 check2=找喜歡人的人是自己
					 * 被喜歡的人是這次的人 狀態為不喜歡
					 */
					if ((!(check.isEmpty())) || (!(check2.isEmpty()))) {
						number++;// 跳下一筆
						check.clear();
						check2.clear();

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
		}

		if (petBean.get(number).getPET_SORT_ID().startsWith("41")) {// 如果抓出來的PET_SORT_ID是41開頭的話
			// 用此PET_SORT_ID去找對應的PET_SORT_NAME
			PetSortCatBean Catbean = petService.selectSortCat(petBean.get(number).getPET_SORT_ID());
			session.setAttribute("Sortbean", Catbean);
		} else {
			PetSortDogBean Dogbean = petService.selectSortDog(petBean.get(number).getPET_SORT_ID());
			session.setAttribute("Sortbean", Dogbean);
		}

		Date now = new Date();// 取得現在時間的所有秒數
		// 以下為算出現在時間-資料庫抓出來的出生日的時間再轉換毫秒(/1000)-->轉換天(/60*60*24)-->轉換年(/365)-->就是年齡了
		long s = (now.getTime() - petBean.get(number).getPET_AGE().getTime()) / 1000 / (60 * 60 * 24) / 365;
		session.setAttribute("PET_AGE", s);
		session.setAttribute("petBean", petBean.get(number));
		PetImgBean Imgbean = petService.selectId2(petBean.get(number).getPET_ID());
		session.setAttribute("petImg", Imgbean.getPET_IMAGE());
		session.setAttribute("PetNumber", ((Integer) number).toString());
		return "success";

	}
}
