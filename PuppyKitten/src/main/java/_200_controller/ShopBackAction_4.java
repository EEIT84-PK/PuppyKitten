package _200_controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import _200_model.ShopBean;
import _200_model.ShopService;

public class ShopBackAction_4 extends ActionSupport implements ServletRequestAware {

	private HttpServletRequest request;
	private ShopBean shopbean;


	public ShopBean getShopbean() {
		return shopbean;
	}

	public void setShopbean(ShopBean shopbean) {
		this.shopbean = shopbean;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String execute() {
		ShopService service = new ShopService();
		int id = service.delete(shopbean.getPRO_ID());
		if (id != 0) {
			request.setAttribute("delete_OK", "刪除成功");
			return "success";
		} else {
			return "input";
		}
	}

}
