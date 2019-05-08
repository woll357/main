package dk_service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.Air_comDAO;
import db_p.Air_comDTO;
import db_p.Air_itemDAO;
import db_p.Air_itemDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class AirCom_Detail implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		

		
	
		HttpSession session = request.getSession();
		
		
	
		Air_itemDTO dto = new Air_itemDTO();
		dto.setAp_code(request.getParameter("air_p"));
		
		Air_itemDAO dao = new Air_itemDAO();
		
	      request.setAttribute("data", dao.air_pitemlistsarch(request.getParameter("air_p"),((SignUpDTO) session.getAttribute("mem")).getAir_code()));
		
	
		request.setAttribute("id", ((SignUpDTO) session.getAttribute("mem")).getId());
		return null;
	}

}
