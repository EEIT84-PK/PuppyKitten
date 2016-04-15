package _100_controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _100_model.ArticleService;


@WebServlet("/article/articleBackAction.controller")
public class ArticleBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out;
		ArticleService service = new ArticleService();
		StringBuilder output = new StringBuilder();

		service.delete(Integer.parseInt(request.getParameter("id")));
		out = response.getWriter();
		output.append("刪除成功!");
		out.print(output);
		out.close();
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
