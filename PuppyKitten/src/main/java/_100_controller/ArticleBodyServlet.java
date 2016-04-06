package _100_controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _100_model.ArticleBean;
import _100_model.ArticleService;

@WebServlet("/article/articleBodyAction.controller")
public class ArticleBodyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out;
		ArticleBean bean = new ArticleBean();
		StringBuilder output = new StringBuilder();
		ArticleService service = new ArticleService();
		bean.setART_TITLE(request.getParameter("title"));
		 List<ArticleBean> list =service.selectByTitle(bean.getART_TITLE());
				output.append("<h1 style='font-size:40px'>"+list.get(0).getART_TITLE()+"</h1>");
				if(list.get(0).getART_IMG()!=null){
					output.append("<img src='"+list.get(0).getART_IMG()+"' width='300px;'>");
				}
				output.append("<h1>"+list.get(0).getART_BODY()+"</h1>");
				
				out = response.getWriter();
				out.print(output);
			    out.close();
			    return;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
