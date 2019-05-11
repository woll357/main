package manager_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.Air_itemDAO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class Airplaneitem_Modify implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
	
		String date = request.getParameter("ddate");

		  
	
		      Air_itemDAO dao = new Air_itemDAO();
		  
	     
		
	      request.setAttribute("data", dao.air_pdatem(request.getParameter("ap_code") , date ));
	    
	    
	      
		return null;
	}

}
