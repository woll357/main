package manager_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.Air_itemDAO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class Airp_List implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	
		
		System.out.println(request.getParameter("air_p"));
		
			Air_itemDAO dao = new Air_itemDAO();
			
			
		      
		      request.setAttribute("data", dao.air_pitemlist());
	
		      

		
		return null;
	}

}
