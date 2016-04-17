package _200_controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
import _200_model.ShopBean;
import _200_model.ShopService;

@SuppressWarnings("serial")
public class ShopBackAction_3 extends ActionSupport implements ServletRequestAware {

	private HttpServletRequest request;
	private ShopBean shopbean;
	private String use="";

	public ShopBean getShopbean() {
		return shopbean;
	}

	public void setShopbean(ShopBean shopbean) {
		this.shopbean = shopbean;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String execute() {
		if(use.equals("update")){
			return "update";
		}else{
			ShopService service = new ShopService();
			List<ShopBean> select_list = service.select(shopbean);
			request.setAttribute("select_list", select_list);
			return "success";
		}
		
		
	}
}
