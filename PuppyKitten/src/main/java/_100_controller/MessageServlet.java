package _100_controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import _100_model.ArticleBean;
import _100_model.ArticleService;
import _100_model.MessageBean;
import _100_model.MessageService;

@WebServlet("/message/messageAction.controller")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out;
		HttpSession session = request.getSession();
		StringBuilder output = new StringBuilder();
		MessageService service = new MessageService();
		MessageBean bean = new MessageBean();
		if(session.getAttribute("loginOK")!=null){
			bean.setMSG_MEM_ID("會員("+session.getAttribute("loginOK").toString()+")");
		}else{
			bean.setMSG_MEM_ID("訪客("+(request.getParameter("name"))+")");
		}
		bean.setMSG_ART_ID(session.getAttribute("articleID").toString());
		bean.setMSG_BODY(((request.getParameter("area"))));

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = sdf.format(date);
		bean.setMSG_TIME(dateString);
		if(bean.getMSG_BODY()==null||bean.getMSG_BODY().trim().length()==0){
			output.append("<p style='color:#400000'>留言失敗,請輸入內容</p>");
		}else{
			service.insert(bean);
			output.append("<p style='color:#400000'>留言成功</p>");
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
