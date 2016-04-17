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
		String id=request.getParameter("id");
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/_600_websocket_back.jsp");
						
		
	}
}






