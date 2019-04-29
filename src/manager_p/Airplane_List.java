package manager_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.Air_itemDAO;
import db_p.Air_planeDAO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class Airplane_List implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	//	HttpSession session = request.getSession();
		
		System.out.println("비행기 목록 진입");
		
		//System.out.println(((SignUpDTO) session.getAttribute("mem")).getAir_code());
		
		request.setAttribute("ddd", new Air_itemDAO().airplanlistm());
		
		
		//  request.setAttribute("dd", ((SignUpDTO) session.getAttribute("mem")).getAir_code());
		
		return null;
	}

}
