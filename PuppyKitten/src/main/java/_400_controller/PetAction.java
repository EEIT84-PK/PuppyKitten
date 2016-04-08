package _400_controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import _400_model.PetBean;
import _400_model.PetImgBean;
import _400_model.PetService;

public class PetAction extends ActionSupport {
	private PetBean petBean;
	private PetImgBean petImgBean = new PetImgBean();
	private File PET_IMAGE;	
	private String PET_IMAGEContentType;
	private String PET_IMAGEFileName;	
	
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
		System.out.println("petBean"+petBean.getPET_AGE());
		if (petBean.getPET_NAME().trim().length() == 0) {
			request.put("PET_NAME", "請輸入寵物名字");
		}else{
			for(int i=0;i<petBean.getPET_NAME().length();i++){
				char check=petBean.getPET_NAME().charAt(i);
				System.out.println("check"+check);
				if(check>=65&&check<=90||check>=97&&check<=122||(int)check>=19968 &&(int)check<=40623){					
				}else{
					request.put("PET_NAME", "只能輸入中文和英文");
				}
			}
		}
		if (petBean.getPET_AGE() == null) {
			request.put("PET_AGE", "請選擇寵物出生年月日");
		}			
		
		if (petBean.getPET_WEIGHT() == null) {
			request.put("PET_WEIGHT", "請輸入寵物體重");
		}
		if (petBean.getPET_KING().trim().length() == 0) {
			request.put("PET_KING", "請選擇寵物種類");
		}
		if (petBean.getPET_SORT_ID().trim().length() == 0) {
			request.put("PET_SORT_ID", "請選擇寵物品種");
		}
		if (PET_IMAGE == null) {
			request.put("PET_IMAGE", "請上傳一張寵物照片");
		}
//		else{
//			if(PET_IMAGEContentType.equals("image/png")||PET_IMAGEContentType.equals("image/gif")||PET_IMAGEContentType.equals("image/jpeg")||PET_IMAGEContentType.equals("image/pjpeg")){
//								
//			}else{
//				request.put("PET_IMAGE", "只能上傳png,gif,jpeg,pjpeg等副檔的照片");
//			}
		
		if (petBean.getPET_BODY().trim().length() == 0 || petBean.getPET_BODY().trim().length() <= 50) {
			request.put("PET_BODY", "請至少輸入50字介紹");
		}else if (petBean.getPET_BODY().trim().length()>=150){
			request.put("PET_BODY", "最多輸入150個字");
		}
	}

	public String execute() {
		if (request.isEmpty()) {
			ServletContext context = ServletActionContext.getServletContext();
			PetService petService = new PetService();
			PetBean bean = petService.insert(petBean);// 將寵物資訊新增到pet_friendship
							// Table
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
				petImgBean.setPET_ID(bean.getPET_ID());				
				petImgBean.setPET_IMAGE(context.getContextPath()+"/_400_images/"+PET_IMAGEFileName);				
				PetImgBean Imgbean = petService.insert(petImgBean);
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
						HttpServletRequest request = ServletActionContext.getRequest(); // 取得HttpServletRequest
						HttpSession session = request.getSession(); // 取得HttpSession						
						//看看有沒有來源網頁 如果有就重導到原來的網頁
						try {
							String location = (String) session.getAttribute("location");
							System.out.println("location(LoginHandler)=" + location);
							if (location != null) {
								session.removeAttribute("location");
								HttpServletResponse response = ServletActionContext
										.getResponse();
								response.sendRedirect(location);
								return null;
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
			
			return "success";
		} else {
			return "input";
		}
	}
}
