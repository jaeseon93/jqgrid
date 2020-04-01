package co.jessie.jqgrid;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.api.ha.HaInfo;


@WebServlet("/jqgridStartMain.do")
public class JqGridController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public JqGridController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO
		PrintWriter out = null;
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		ArrayList<JqgridVO> list = new ArrayList<JqgridVO>();
		JqueryDao dao = new JqueryDao();
//		JqgridVO vo = new JqgridVO();
		
		String quotZero = request.getParameter("param");
		System.out.println(quotZero);
		
//		Map<String, Object> castMap = new HashMap<String, Object>();
//		castMap = JsonUtil.JsonToMap(quotZero);
//		list = dao.select();
		
		HashMap<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("rows", list);
		out = response.getWriter();
		
		System.out.println(resMap);
		System.out.println(JsonUtil.HashMapToJson(resMap).toString());
		
		out.write(JsonUtil.HashMapToJson(resMap).toString());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
}
