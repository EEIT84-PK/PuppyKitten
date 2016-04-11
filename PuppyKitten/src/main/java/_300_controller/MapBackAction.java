package _300_controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
import _300_model.MapBean;
import _300_model.MapService;

@SuppressWarnings("serial")
public class MapBackAction extends ActionSupport implements ServletRequestAware {
	// 宣告區
	private MapBean mapBean;
	private HttpServletRequest req;

	public MapBean getMapBean() {
		return mapBean;
	}

	public void setMapBean(MapBean mapBean) {
		this.mapBean = mapBean;
	}

	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.req = req;

	}

	public String execute() {
		System.out.println(mapBean.getClass());
		MapService service = new MapService();
		List<MapBean> list = service.select(mapBean);
		req.setAttribute("select", list);

		return "success";
	}

}
