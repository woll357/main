package dk_service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.Air_itemDAO;
import db_p.Air_planeDAO;
import di.MvcAction;
import di.MvcForward;

public class Airplane_List implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		System.out.println("비행기 목록 진입");
		
		System.out.println(request.getParameter("air_code"));
		
		request.setAttribute("data", new Air_planeDAO().airplanelist(request.getParameter("air_code")));
		
		
		  request.setAttribute("dd", request.getParameter("air_code"));
		
		return null;
	}

}
