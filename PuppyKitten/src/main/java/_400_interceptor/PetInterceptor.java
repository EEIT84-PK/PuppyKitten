package _400_interceptor;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import _400_model.PetBean;
import _400_model.PetService;

public class PetInterceptor extends AbstractInterceptor implements ServletRequestAware{
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
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx=invocation.getInvocationContext();
		Map<String, Object>session=ctx.getSession();		
		PetService petService = new PetService();
		
		HttpServletRequest request = ServletActionContext.getRequest(); // 取得HttpServletRequest
		HttpSession session2 = request.getSession(); // 取得HttpSession
		List<PetBean> petBean=null;
		if(session2.getAttribute("memberID")!=null){
			petBean=petService.selecPettId((Integer)session2.getAttribute("memberID"));
		}
		
		
		if(session2.getAttribute("loginOK")==null){			
			ctx.put("errorMsg", "尚未登入，請先登入");
			return "login";			
		}
		
		if(petBean.isEmpty()){
			req=ServletActionContext.getRequest();
			String location=req.getRequestURI();
			session.put("location", location);
			ctx.put("errorMsg", "尚未新增寵物資訊，請先新增寵物資訊");
			return "insertPet";
		}
		return invocation.invoke();
	}	
	
}
