package _100_controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _100_model.MessageBean;
import _100_model.MessageDAO;
import _100_model.MessageService;

@WebServlet("/message/replyAction.controller")
public class ReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out;
		StringBuilder output = new StringBuilder();
		MessageBean bean = new MessageBean();
		MessageService MSGservice = new MessageService();
		String time =request.getParameter("time").substring(request.getParameter("time").length()-19);
		List<MessageBean> MSGlist = MSGservice.selectTime(time);
		bean.setMSG_ID(MSGlist.get(0).getMSG_ID());
		bean.setMSG_ART_ID(MSGlist.get(0).getMSG_ART_ID());
		bean.setMSG_MEM_ID(MSGlist.get(0).getMSG_MEM_ID());
		bean.setMSG_BODY(MSGlist.get(0).getMSG_BODY());
		System.out.println("REPLY:"+request.getParameter("reply"));
		bean.setMSG_REBODY(request.getParameter("reply"));
		bean.setMSG_TIME(MSGlist.get(0).getMSG_TIME());
		MSGservice.update(bean);
				output.append("<p style='color:#400000'>回覆成功</p>");
				out = response.getWriter();
				out.print(output);
			    out.close();
			    return;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
