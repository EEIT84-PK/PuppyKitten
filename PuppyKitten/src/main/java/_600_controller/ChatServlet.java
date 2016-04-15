package _600_controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ChatServlet.controller")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = response.getWriter();
		HttpSession session = request.getSession();
		String username;
		System.out.println(session);
		if(session.getAttribute("loginOK")==null){
			username="訪客";
		}else{
			username = session.getAttribute("loginOK").toString();
		}
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/_600_websocket_back.jsp");
			
		printWriter.println("<html>");
		printWriter.println(	"<head><title>客服中心</title></head>");
		printWriter.println(	"<body>");
		printWriter.println(     	"<center>");
		printWriter.println(			"<textarea id='area' readonly='readonly' rows='10' cols='45'></textarea><br>");
		printWriter.println(            "<input type='text' id='text' size='50' /><input id='sendmsg' type='button' value='送出' />");
		printWriter.println(     	"</center>");
		printWriter.println(	"</body>");
		printWriter.println("</html>");					
		
	}
}






