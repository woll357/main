package dk_service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.Air_itemDAO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class Airp_List2 implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		
		System.out.println(request.getParameter("air_p"));
		
		System.out.println(((SignUpDTO) session.getAttribute("mem")).getAir_code());
		
		Air_itemDAO dao = new Air_itemDAO();
	      
		 request.setAttribute("dtt", ((SignUpDTO) session.getAttribute("mem")).getAir_code());      
		
	      request.setAttribute("dto", dao.air_pitemlist3(request.getParameter("air_p"), ((SignUpDTO) session.getAttribute("mem")).getAir_code()));      
	     
	      
	   
	      
		return null;
	}

}
