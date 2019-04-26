package dk_service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.Air_itemDAO;
import db_p.Air_itemDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class Airp_List implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		
		
			System.out.println(request.getParameter("air_p"));
		
			
			
			HttpSession session = request.getSession();

			System.out.println(((SignUpDTO) session.getAttribute("mem")).getAir_code());
			
			
			Air_itemDTO dto = new Air_itemDTO();
			dto.setAir_code((((SignUpDTO) session.getAttribute("mem")).getAir_code()));
			
			Air_itemDAO dao = new Air_itemDAO();

		      
			  request.setAttribute("data", dao.air_pitemlist(dto));
			  
		 //     request.setAttribute("data", dao.air_pitemlist());
		      
		      
		      System.out.println("항공편 리스트 진입");
		
		
		return null;
	}

}
