package _200_controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import _200_model.ShopBean;
import _200_model.ShopService;

@SuppressWarnings("serial")
public class ShopBackAction_2 extends ActionSupport implements ServletRequestAware {

	private HttpServletRequest request;
	private ShopBean shopbean;
	private int id;
	private String account;
	private String password;
	private Map<String ,Object> session;


	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	
	
	@Override
	public void validate() {
		if(shopbean.getPRO_ANIMAL()==null || shopbean.getPRO_ANIMAL().trim().length()==0){
			this.addFieldError("errorUpdateAnimal", "請選擇商品類型");
		}
		if(shopbean.getPRO_KIND()==null || shopbean.getPRO_KIND().trim().length()==0){
			this.addFieldError("errorUpdateKind", "請選擇商品種類");
		}
		if(shopbean.getPRO_NAME()==null || shopbean.getPRO_NAME().trim().length()==0){
			this.addFieldError("errorUpdateName", "請輸入商品名稱");
		}
		if(shopbean.getPRO_PROJCET()==null || shopbean.getPRO_PROJCET().trim().length()==0){
			addFieldError("errorUpdateProject", "請選擇優惠方案");
		}
		if(shopbean.getPRO_PRICE()==null ){
			this.addFieldError("errorUpdatePrice", "請輸入販售價格");
		}
		if(shopbean.getPRO_STOCK()==null ){
			this.addFieldError("errorUpdateStock", "請輸入庫存數量");			
		}
		if(shopbean.getPRO_IMAGE()==null || shopbean.getPRO_IMAGE().trim().length()==0){
			this.addFieldError("errorUpdateImage", "請上傳商品照片");
		}
	}

	public String execute() {
		ShopService service = new ShopService();
		ShopBean bean =service.update(shopbean);
		HttpSession session = request.getSession();
//		if(session!=null){
//			request.getSession().removeAttribute("updateOK");
//		}
		if(bean!=null){
			request.getSession().setAttribute("updateOK", "Update OK");
			return "success";
		}else{
			return "input";
		}
	}
}
