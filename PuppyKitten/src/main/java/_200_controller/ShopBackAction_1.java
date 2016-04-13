package _200_controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
import _200_model.ShopBean;
import _200_model.ShopService;

public class ShopBackAction_1 extends ActionSupport implements ServletRequestAware {

	private HttpServletRequest request;
	private ShopBean shopbean;
	private Map<String, Object> session;
	private File PRO_IMAGE;
	private String PRO_IMAGEFileName;
	private String PRO_IMAGEContentType;



	public String getPRO_IMAGEFileName() {
		return PRO_IMAGEFileName;
	}

	public void setPRO_IMAGEFileName(String pRO_IMAGEFileName) {
		PRO_IMAGEFileName = pRO_IMAGEFileName;
	}

	public String getPRO_IMAGEContentType() {
		return PRO_IMAGEContentType;
	}

	public void setPRO_IMAGEContentType(String pRO_IMAGEContentType) {
		PRO_IMAGEContentType = pRO_IMAGEContentType;
	}

	public File getPRO_IMAGE() {
		return PRO_IMAGE;
	}

	public void setPRO_IMAGE(File pRO_IMAGE) {
		PRO_IMAGE = pRO_IMAGE;
	}

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

		if (shopbean.getPRO_ANIMAL() == null || shopbean.getPRO_ANIMAL().trim().length() == 0) {
			this.addFieldError("errorInsertAnimal", "請選擇商品類型");
		}
		if (shopbean.getPRO_KIND() == null || shopbean.getPRO_KIND().trim().length() == 0) {
			this.addFieldError("errorInsertKind", "請選擇商品種類");
		}
		if (shopbean.getPRO_NAME() == null || shopbean.getPRO_NAME().trim().length() == 0) {
			this.addFieldError("errorInsertName", "請輸入商品名稱");
		}
		if (shopbean.getPRO_PROJECT() == null || shopbean.getPRO_PROJECT().trim().length() == 0) {
			addFieldError("errorInsertProject", "請選擇優惠方案");
		}
		if (shopbean.getPRO_PRICE() == null) {
			this.addFieldError("errorInsertPrice", "請輸入指定價格");
		}
//		if (shopbean.getPRO_BUY1() == null) {
//			this.addFieldError("errorInsert_Buy1", "請輸入指定數量");
//		}
//		if (shopbean.getPRO_BUY2() == null) {
//			this.addFieldError("errorInsert_Buy2", "請輸入贈送數量");
//		}
		if (shopbean.getPRO_STOCK() == null) {
			this.addFieldError("errorInsertStock", "請輸入庫存數量");
		}
		if (PRO_IMAGE == null || PRO_IMAGE.length() == 0) {
			this.addFieldError("errorInsertImage", "請上傳商品照片");
		}
	}
	@Override
	public String execute() {
		ShopService service = new ShopService();
		File saved = new File(ServletActionContext.getServletContext().getRealPath("/_200_images/"+PRO_IMAGEFileName));
		InputStream inStream =null;
		OutputStream outStream=null;
		
		try {
			saved.getParentFile().mkdirs();
			inStream = new FileInputStream(PRO_IMAGE);
			outStream = new FileOutputStream(saved);

			byte[] b = new byte[(int) PRO_IMAGE.length()];
			int len = 0;
			while ((len = inStream.read(b)) != -1)
				outStream.write(b,0,len);				
			shopbean.setPRO_IMAGE(ServletActionContext.getServletContext().getContextPath()+"/_200_images/"+PRO_IMAGEFileName);
			ShopBean bean = service.insert(shopbean);
			if (bean != null) {
				request.setAttribute("insertOK", "Insert OK");
				return "success";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			if(outStream!=null){
				try {
					outStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(inStream!=null){
				try {
					inStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "input";
	}

//	public String upload() throws IOException {
//		File saved = new File(ServletActionContext.getServletContext().getRealPath("upload",FileName));
//		
//		InputStream inStream =null;
//		OutputStream outStream=null;
//		try {
//			saved.getParentFile().mkdirs();
//			inStream = new FileInputStream(PRO_IMAGE);
//			outStream = new FileOutputStream(saved);
//
//			byte[] b = new byte[1024];
//			int len = 0;
//			while ((len = inStream.read(b)) != -1)
//				outStream.write(b, 0, len);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}finally {
//			if(outStream!=null){
//				outStream.close();
//			}
//			if(inStream!=null){
//				inStream.close();
//			}
//		}
//		return "list";
//	}
}
