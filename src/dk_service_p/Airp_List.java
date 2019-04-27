package dk_service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.Air_itemDAO;
import di.MvcAction;
import di.MvcForward;

public class Airp_List implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		
		System.out.println(request.getParameter("air_code"));
			System.out.println(request.getParameter("id"));
			Air_itemDAO dao = new Air_itemDAO();
			
			
		      request.setAttribute("data", dao.air_pitemlistt(request.getParameter("air_code")));
		      
		      
		      request.setAttribute("air_code",request.getParameter("air_code"));
		      request.setAttribute("id", request.getParameter("id"));
		      
		      
		      System.out.println("항공편 리스트 진입");
		
		
		return null;
	}

}
