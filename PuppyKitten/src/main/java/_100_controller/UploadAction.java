package _100_controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import _100_model.ArticleBean;
import _100_model.ArticleService;

@SuppressWarnings("serial")
public class UploadAction extends ActionSupport implements ServletRequestAware{
	private ArticleBean bean;
	private File img;
	private String imgContentType;
	private String imgFileName;
	private HttpServletRequest req;
	
	public File getImg() {
		return img;
	}
	public void setImg(File img) {
		this.img = img;
	}
	public String getImgContentType() {
		return imgContentType;
	}
	public void setImgContentType(String imgContentType) {
		this.imgContentType = imgContentType;
	}
	public String getImgFileName() {
		return imgFileName;
	}
	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}
	public ArticleBean getBean() {
		return bean;
	}
	public void setBean(ArticleBean bean) {
		this.bean = bean;
	}
	@Override
	public String execute()throws Exception{
		ArticleService service = new ArticleService();
		HttpSession session = req.getSession();
		bean.setART_MEM_ID(session.getAttribute("loginOK").toString());
		String path=null;
		if(img!=null){
			ServletContext context = ServletActionContext.getServletContext();
			String dir=context.getRealPath("/upload/"+imgFileName);
			path =context.getContextPath()+"/upload/"+imgFileName;
			FileOutputStream out= new FileOutputStream(dir);
			FileInputStream input = new FileInputStream(img);
			byte[] buffer = new byte[(int)img.length()];
			int len = 0;
			while((len= input.read(buffer))!=-1){
				out.write(buffer, 0, len);
			}
			out.close();
			input.close();
			
		}
		String string = bean.getART_BODY();
		String newString = "";
		   String[] bodys = string.split("\n");
	        for(String body : bodys) {
	        	newString+=body+"<br>";
	        }
		bean.setART_BODY(newString);
		bean.setART_HOT(0);
		bean.setART_TIME(new Date());
		bean.setART_IMG(path);
		
		service.insert(bean);
		req.setAttribute("insert","新增成功!");
		return SUCCESS;
	}
	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.req=req;
		
	}
}
