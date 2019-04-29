package manager_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.Air_itemDAO;
import db_p.Air_itemDTO;
import db_p.Air_planeDAO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class Airplane_List2 implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	//	HttpSession session = request.getSession();
		
		System.out.println("비행기 찾기 목록 진입");
		
		/*
		 * Air_itemDTO dto = new Air_itemDTO();
		 * dto.setAir_name(request.getParameter("air_name"));
		 */
		
		//System.out.println(((SignUpDTO) session.getAttribute("mem")).getAir_code());
		
		request.setAttribute("data", new Air_itemDAO().airplanedetailm(request.getParameter("air_name")));
		
		
		 // request.setAttribute("dd", ((SignUpDTO) session.getAttribute("mem")).getAir_code());
		
		return null;
	}

}
