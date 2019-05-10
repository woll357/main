package manager_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.Air_comDAO;
import db_p.Air_itemDAO;
import db_p.Air_itemDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class Airp_Detail implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	
		HttpSession session = request.getSession();
		

		Air_itemDTO dto = new Air_itemDTO();
		dto.setAir_p(request.getParameter("air_p"));
		dto.setDdateStr2(request.getParameter("ddate"));

		
		
		   request.setAttribute("air_p", request.getParameter("air_p"));
		   
		   
		   System.out.println("asmkldaskdjlaksjdkl"+request.getParameter("air_p"));
		   System.out.println(request.getParameter("ddate"));
		   
		Air_itemDAO dao = new Air_itemDAO();
		
		request.setAttribute("dto", dao.air_pdetailm(dto));
		
		return null;
		
	}

}



