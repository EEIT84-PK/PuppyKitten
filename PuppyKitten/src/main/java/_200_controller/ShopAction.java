package _200_controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import _200_model.ShopBean;
import _200_model.ShopService;

@SuppressWarnings("serial")
public class ShopAction extends ActionSupport implements ServletRequestAware {

	private HttpServletRequest request;
	private ShopBean shopbean;

	public void setRequest(HttpServletRequest request) {
		this.request = request;
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
		List<ShopBean> list = service.selectShop(shopbean);
		request.setAttribute("select", list);
		return "success";
	}
}
