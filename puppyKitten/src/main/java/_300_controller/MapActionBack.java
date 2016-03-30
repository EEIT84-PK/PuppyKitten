package _300_controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import _300_model.MapBean;
import _300_model.MapService;

@SuppressWarnings("serial")
public class MapActionBack extends ActionSupport implements ServletRequestAware{
	//宣告區
		private String choose;
		private MapBean mapBean;
		private HttpServletRequest req;
		
		public MapBean getMapBean() {
			return mapBean;
		}
		public void setMapBean(MapBean mapBean) {
			this.mapBean = mapBean;
		}
		public HttpServletRequest getReq() {
			return req;
		}
		public void setReq(HttpServletRequest req) {
			this.req = req;
		}
		public String getChoose() {
			return choose;
		}
		public void setChoose(String choose) {
			this.choose = choose;
		}
		@Override
		public void setServletRequest(HttpServletRequest req) {
			this.req=req;
			
		}
		
		public String execute(){
			MapService service = new MapService();
			if("查詢".equals(choose)) {
				List<MapBean> list = service.select(mapBean);
				req.setAttribute("select", list);
				System.out.println("execute查詢");
			} else if("修改".equals(choose)){
				System.out.println("修改");
			}
			
			return "success";
		}
		
}
