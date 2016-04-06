package _300_controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _300_model.MapBean;
import _300_model.MapService;

@WebServlet("/map/mapActionBack.controller")
public class MapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out;
		MapBean bean = new MapBean();
		MapService service = new MapService();
		StringBuilder output = new StringBuilder();
		String use=request.getParameter("use");
		try {
				if("update".equals(use)){
					bean.setMAP_ID(Integer.parseInt(request.getParameter("id")));
					bean.setMAP_KIND(request.getParameter("kind"));
					bean.setMAP_NAME(request.getParameter("name"));
					bean.setMAP_ADD(request.getParameter("address"));
					bean.setMAP_PHONE(request.getParameter("phone"));
					service.update(bean);
					out = response.getWriter();
					output.append("修改成功!");
					out.print(output);
				    out.close();
				    return;
				}else if("delete".equals(use)){
					service.delete(Integer.parseInt(request.getParameter("id")));
					out = response.getWriter();
					output.append("刪除成功!");
					out.print(output);
				    out.close();
				    return;
				}else if("insert".equals(use)){
					bean.setMAP_KIND(request.getParameter("kind"));
					bean.setMAP_NAME(request.getParameter("name"));
					bean.setMAP_PHONE(request.getParameter("phone"));
					bean.setMAP_CITY(request.getParameter("city"));
					bean.setMAP_AREA(request.getParameter("area"));
					bean.setMAP_ADD(request.getParameter("address"));
					service.insert(bean);
					out = response.getWriter();
					output.append("新增成功!");
					out.print(output);
				    out.close();
				    return;

				}	
		     
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
