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

@WebServlet("/article/articleAction.controller")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out;
		StringBuilder output = new StringBuilder();
		ArticleService service = new ArticleService();
		List<ArticleBean> list=null;
		String use=request.getParameter("use");
				if("公告".equals(use)){list=service.selectPost();}
				else if("活動".equals(use)){list=service.selectActivity();}
				else if("心得".equals(use)){list=service.selectReviews();}
				else if("問題".equals(use)){list=service.selectQuestion();}
				else{list=service.selectAll();}
				for(int i=0;i<list.size();i++){
					ArticleBean data = list.get(i);
					output.append("<tr><td style='width: 50px;text-align: center;'>"+data.getART_KIND()+"</td>");
					output.append("<td style='width: 300px;text-align: center;'>"+data.getART_TITLE()+"</td>");
					output.append("<td style='width: 100px;text-align: center;'>"+data.getART_MEM_ID()+"</td>");
					output.append("<td style='width: 200px;text-align: center;'>"+data.getART_TIME()+"</td>");
					output.append("<td style='width: 50px;text-align: center;'>"+data.getART_HOT()+"</td></tr>");
				}
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
