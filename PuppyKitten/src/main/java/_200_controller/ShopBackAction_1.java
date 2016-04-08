package _200_controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import _200_model.ShopBean;
import _200_model.ShopService;

@SuppressWarnings("serial")
public class ShopBackAction_1 extends ActionSupport implements ServletRequestAware {

	private HttpServletRequest request;
	private ShopBean shopbean;


	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

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
//		List<ShopBean> list = service.selectShop(shopbean);
//		for(ShopBean bean :list){
//			System.out.println(bean+",");
//		}		
//		request.setAttribute("select", list);
		
		service.inesrt(shopbean);
		request.setAttribute("insertOK", "insertOK");
		return "success";
	}
}
