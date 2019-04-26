package dk_service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Air_itemDAO;
import di.MvcAction;
import di.MvcForward;

public class Airp_List implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println(request.getParameter("air_p"));
			
			Air_itemDAO dao = new Air_itemDAO();
		      
		      request.setAttribute("data", dao.air_pitemlist());
		      
		      
		      System.out.println("항공편 리스트 진입");
		
		
		return null;
	}

}
