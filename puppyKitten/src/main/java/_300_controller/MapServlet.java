package _300_controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _300_model.MapBean;
import _300_model.MapDAO;
import _300_model.MapService;

@WebServlet("/map/mapActionBack.controller")
public class MapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out;
		try {
			MapBean bean = new MapBean();
			MapDAO dao = new MapDAO();
			System.out.println("Im Servlet");
			System.out.println("mapBean.MAP_ID:"+request.getParameter("mapBean.MAP_ID"));
			int id=Integer.parseInt(request.getParameter("mapBean.MAP_ID"));
			bean = dao.selectId(id);
			request.setAttribute("select", bean);
			
			System.out.println(bean);
			out = response.getWriter();
			StringBuilder output = new StringBuilder();
			
			output.append(bean.getMAP_NAME());
		
		     out.print(output);
		     out.close();
		     return;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
