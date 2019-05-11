package dk_service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.Air_itemDAO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class Airplaneitem_Detail implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession();
		String date = request.getParameter("ddate");
		  String air_code = (((SignUpDTO) session.getAttribute("mem")).getAir_code());
		  
		  System.out.println("데이트 ㅔ이트"+date+date+date+date+date+date+date);
		  System.out.println(air_code+air_code+air_code+air_code+air_code);
		      System.out.println(request.getParameter("ap_code"));
		      
		      Air_itemDAO dao = new Air_itemDAO();
		  
	     
		
	      request.setAttribute("data", dao.air_pdate(request.getParameter("ap_code") ,air_code , date ));
	    
	    
	      
		return null;
	}

}
