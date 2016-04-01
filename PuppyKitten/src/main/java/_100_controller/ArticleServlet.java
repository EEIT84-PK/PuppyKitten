package _100_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _100_model.ArticleBean;
import _100_model.ArticleService;

@WebServlet("/article/articleAction.controller")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/plain; charset=UTF-8");
		ArticleBean bean = new ArticleBean();
		ArticleService service = new ArticleService();
		List<ArticleBean> list=null;
		String use=request.getParameter("use");
				if("公告".equals(use)){
					
					list=service.selectPost();
					request.setAttribute("select",list);
				    return;
				}else if("活動".equals(use)){
					list=service.selectActivity();
					request.setAttribute("select",list);
				    return;
				}else if("心得".equals(use)){
					list=service.selectReviews();
					request.setAttribute("select",list);
				    return;
				}else if("問題".equals(use)){
					list=service.selectQuestion();
					request.setAttribute("select",list);
				    return;
				}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
