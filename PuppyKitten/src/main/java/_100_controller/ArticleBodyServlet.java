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
		ArticleService ARTservice = new ArticleService();
		HttpSession session = request.getSession();
		StringBuilder output = new StringBuilder();
		bean.setART_TITLE(request.getParameter("title"));
		 List<ArticleBean> ARTlist =ARTservice.selectByTitle(bean.getART_TITLE());
		 bean=ARTlist.get(0);
		 bean.setART_HOT(Integer.parseInt(request.getParameter("hot"))+1);
		 ARTservice.update(bean);
				output.append("<h1 style='font-size:40px'>"+bean.getART_TITLE()+"</h1>");
				if(bean.getART_IMG()!=null){
					output.append("<img src='"+bean.getART_IMG()+"' width='300px;'>");
				}
				output.append("<p>"+bean.getART_BODY()+"</p>");
				session.setAttribute("articleID", bean.getART_ID());
				MessageService MSGservice = new MessageService();
				String id=bean.getART_ID().toString();
				List<MessageBean> MSGlist = MSGservice.selectId(id);
				for(int i = 0;i<MSGlist.size();i++){
					output.append("<div style='background:rgba(250, 235, 215, 0.4);'><div style='background:rgba(255, 255, 215, 0.4);'><b style='font-size:24px;'>"+MSGlist.get(i).getMSG_MEM_ID()+" </b><b style='font-size:18px;'> "+MSGlist.get(i).getMSG_TIME()+"</b></div>");
					output.append("<p style='font-size:20px;'>"+MSGlist.get(i).getMSG_BODY()+"</p>");
					if(MSGlist.get(i).getMSG_REBODY()!=null){
						output.append("<p style='font-size:16px;right:10px;'>回覆:"+MSGlist.get(i).getMSG_REBODY()+"</p>");
					}
					
					if(bean.getART_MEM_ID().equals(session.getAttribute("loginOK"))&&MSGlist.get(i).getMSG_REBODY()==null){
						output.append("<input /><input class='reply' type='button' value='回覆'/></div>");
					}
					
					
				}
				out = response.getWriter();
				out.print(output);
			    out.close();
			    return;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
