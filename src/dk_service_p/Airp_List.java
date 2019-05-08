package dk_service_p;

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
		
		HttpSession session = request.getSession();
		

		String air_code = ((SignUpDTO) session.getAttribute("mem")).getAir_code();
	
	      
	      
		Air_itemDAO dao = new Air_itemDAO();
	      
		
			
		      request.setAttribute("data", dao.air_pitemlistt(air_code ));
		      
		      
		      request.setAttribute("air_code",((SignUpDTO) session.getAttribute("mem")).getAir_code());
		      request.setAttribute("id", ((SignUpDTO) session.getAttribute("mem")).getId());
		      
		      
		     
		
		
		return null;
	}

}
