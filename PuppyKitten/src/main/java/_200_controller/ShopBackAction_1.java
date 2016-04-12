package _200_controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import _200_model.ShopBean;
import _200_model.ShopService;

@SuppressWarnings("serial")
public class ShopBackAction_1 extends ActionSupport implements ServletRequestAware {

	private HttpServletRequest request;
	private ShopBean shopbean;
	private Map<String ,Object> session;

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
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
			this.addFieldError("errorInsertAnimal", "請選擇商品類型");
		}
		if(shopbean.getPRO_KIND()==null || shopbean.getPRO_KIND().trim().length()==0){
			this.addFieldError("errorInsertKind", "請選擇商品種類");
		}
		if(shopbean.getPRO_NAME()==null || shopbean.getPRO_NAME().trim().length()==0){
			this.addFieldError("errorInsertName", "請輸入商品名稱");
		}
		if(shopbean.getPRO_PROJCET()==null || shopbean.getPRO_PROJCET().trim().length()==0){
			addFieldError("errorInsertProject", "請選擇優惠方案");
		}
		if(shopbean.getPRO_PRICE()==null ){
			this.addFieldError("errorInsertPrice", "請輸入指定價格");
		}
		if(shopbean.getPRO_BUY1()==null ){
			this.addFieldError("errorInsert_Buy1", "請輸入指定數量");
		}
		if(shopbean.getPRO_BUY2()==null ){
			this.addFieldError("errorInsert_Buy2", "請輸入贈送數量");
		}
		if(shopbean.getPRO_STOCK()==null ){
			this.addFieldError("errorInsertStock", "請輸入庫存數量");			
		}
		if(shopbean.getPRO_IMAGE()==null || shopbean.getPRO_IMAGE().trim().length()==0){
			this.addFieldError("errorInsertImage", "請上傳商品照片");
		}
	}

	public String execute() {
		ShopService service = new ShopService();
		ShopBean bean =service.inesrt(shopbean);
		HttpSession session=request.getSession();
//		if(session!=null){
//			request.getSession().removeAttribute("insertOK");
//		}
		if(bean!=null){
			request.getSession().setAttribute("insertOK", "Insert OK");
			return "success";	
		}else{
			return "input";
		}
	}
}
