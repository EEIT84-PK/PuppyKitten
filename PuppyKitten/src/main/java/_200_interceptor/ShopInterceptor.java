package _200_interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ShopInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// 1.這個攔截器取出session裡面的username判斷此user是否登入過
		
		
		// 2.如果沒登入過 就導到 登入頁面 請求先登入
		
		
		// 3.如果登入過繼續下一個攔截器或下一個Action的execute()方法
		
		return null;
	}

}
