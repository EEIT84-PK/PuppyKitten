package _100_controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _100_model.ArticleBean;
import _100_model.ArticleService;
import _100_model.MessageBean;
import _100_model.MessageService;

@WebServlet("/article/articleBodyAction.controller")
public class ArticleBodyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out;
		ArticleBean bean = new ArticleBean();
		HttpSession session = request.getSession();
		StringBuilder output = new StringBuilder();
		ArticleService service = new ArticleService();
		bean.setART_TITLE(request.getParameter("title"));
		 List<ArticleBean> list =service.selectByTitle(bean.getART_TITLE());
		 bean=list.get(0);
		 bean.setART_HOT(Integer.parseInt(request.getParameter("hot"))+1);
		 service.update(bean);

				output.append("<h1 style='font-size:40px'>"+list.get(0).getART_TITLE()+"</h1>");
				if(list.get(0).getART_IMG()!=null){
					output.append("<img src='"+list.get(0).getART_IMG()+"' width='300px;'>");
				}
				output.append("<h1>"+list.get(0).getART_BODY()+"</h1>");
				session.setAttribute("articleID", list.get(0).getART_ID());
				MessageService MSGservice = new MessageService();
				String id=list.get(0).getART_ID().toString();
				List<MessageBean> MSGlist = MSGservice.selectId(id);
				for(int i = 0;i<MSGlist.size();i++){
					
					output.append("<div style='background:rgba(250, 235, 215, 0.4);'><h3 style='font-size:24px;background:rgba(255, 255, 215, 0.4);'>"+MSGlist.get(i).getMSG_MEM_ID()+"</h3>");
					output.append("<h3 style='font-size:20px;'>"+MSGlist.get(i).getMSG_BODY()+"</h3></div>");
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
