package dk_service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.Air_planeDAO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class Airplane_Insert implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println("비행기기기기기ㅣ 고고고고");
		
		HttpSession session = request.getSession();
		System.out.println(((SignUpDTO) session.getAttribute("mem")).getAir_code());
		
		request.setAttribute("dto", ((SignUpDTO) session.getAttribute("mem")).getAir_code());
		
//		System.out.println("비행기 떴다 떳다 비행기~");
//		
//		System.out.println(request.getParameter("air_code"));
//		
//		request.setAttribute("dto", request.getParameter("air_code"));
		

		return null;
	}

}
