package dk_service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Air_itemDAO;
import di.MvcAction;
import di.MvcForward;

public class AirItem_List implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		System.out.println(request.getParameter("air_code"));
		
		Air_itemDAO dao = new Air_itemDAO();
	      
	      request.setAttribute("data", dao.itemlist(request.getParameter("air_code")));
	      
	      
	      System.out.println("리스트 서비스 진입");
	      
	      
	      
		return null;
	}

}
