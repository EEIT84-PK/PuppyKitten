package _500_interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthenticationInterceptor extends AbstractInterceptor{
	public String intercept(ActionInvocation invocation)throws Exception{
		ActionContext ctx=invocation.getInvocationContext();
	    Map<String,Object> session=ctx.getSession();
	    String username=(String) session.get("account");
	    if(username==null){
	    	HttpServletRequest request=ServletActionContext.getRequest();
	    	String location=request.getRequestURI();
	    	session.put("location", location);
	    	ctx.put("session", "未登入");
	    	return "input";
	    }else{
	    	return invocation.invoke();
	    }
	}

}