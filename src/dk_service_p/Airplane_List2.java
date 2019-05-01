package dk_service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.Airp_detailsDAO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class Airplane_List2 implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String air_code = ((SignUpDTO) session.getAttribute("mem")).getAir_code();
		
		
		request.setAttribute("data", new Airp_detailsDAO().airplanlista2(request.getParameter("ap_code"),air_code));
		
		
	
		
		return null;
		
	
	}

}
