package _400_controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import _400_model.PetBean;
import _400_model.PetImgBean;
import _400_model.PetService;

public class PetUpdate2Action extends ActionSupport implements ServletRequestAware{
	private PetBean petBean;
	private PetImgBean petImgBean = new PetImgBean();
	private File PET_IMAGE;	
	private String PET_IMAGEContentType;
	private String PET_IMAGEFileName;	
	private SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
	private String date;	
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
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public File getPET_IMAGE() {
		return PET_IMAGE;
	}

	public void setPET_IMAGE(File pET_IMAGE) {
		PET_IMAGE = pET_IMAGE;
	}

	public String getPET_IMAGEContentType() {
		return PET_IMAGEContentType;
	}

	public void setPET_IMAGEContentType(String pET_IMAGEContentType) {
		PET_IMAGEContentType = pET_IMAGEContentType;
	}

	public String getPET_IMAGEFileName() {
		return PET_IMAGEFileName;
	}

	public void setPET_IMAGEFileName(String pET_IMAGEFileName) {
		PET_IMAGEFileName = pET_IMAGEFileName;
	}

	public PetImgBean getPetImgBean() {
		return petImgBean;
	}

	public void setPetImgBean(PetImgBean petImgBean) {
		this.petImgBean = petImgBean;
	}

	public PetBean getPetBean() {
		return petBean;
	}

	public void setPetBean(PetBean petBean) {
		this.petBean = petBean;
	}

	public Map<String, String> request = new HashMap<>();

	public Map<String, String> getRequest() {
		return request;
	}

	public void setRequest(Map<String, String> request) {
		this.request = request;
	}

	public void validate() {
		System.out.println("petBean="+petBean);
		if (petBean.getPET_BODY().trim().length() == 0 || petBean.getPET_BODY().trim().length() <= 10) {
			request.put("PET_BODY", "請至少輸入10字介紹");
		}else if (petBean.getPET_BODY().trim().length()>=150){
			request.put("PET_BODY", "最多輸入150個字");
		}
	}

	public String execute() {
		if (request.isEmpty()) {
			ServletContext context = ServletActionContext.getServletContext();			
			PetService petService = new PetService();
			HttpSession session=req.getSession();
			List<PetBean> selectKing = petService.selecPettId((Integer) session.getAttribute("memberID"));
			petBean.setPET_SORT_ID(selectKing.get(0).getPET_SORT_ID());
			PetBean bean = petService.update(petBean);// 將寵物資訊新增到pet_friendship
							// Table
			if(PET_IMAGE!=null){
				File saved = new File(context.getRealPath("/_400_images/"+PET_IMAGEFileName));// 將檔案儲存到/_400_images下	
				InputStream is = null;
				OutputStream os = null;
				try {
					saved.getParentFile().mkdirs();// 確保資料夾/_400_images存在
					is = new FileInputStream(PET_IMAGE); // 讀入暫存檔案
					os = new FileOutputStream(saved); // 寫入到/_400_images下

					byte[] Img = new byte[(int) PET_IMAGE.length()];// 位元組快取記憶體
					int len=0;
					while((len=is.read(Img))!=-1){
						os.write(Img);
					}
					petImgBean.setPET_ID(petBean.getPET_ID());				
					petImgBean.setPET_IMAGE(context.getContextPath()+"/_400_images/"+PET_IMAGEFileName);			
					PetImgBean Imgbean = petService.update(petImgBean);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (os != null) {
						try {
							os.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (is != null) {
						try {
							is.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}				
			}			
			return "success";
		} else {
			return "input";
		}
	}
}
