package dk_service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Air_dereDAO;
import db_p.Air_dereDTO;
import di.MvcAction;
import di.MvcForward;

public class AirLine_DeleteRequest implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
	
		System.out.println("항공사 삭제 요청 진입");
		
		System.out.println(request.getParameter("code"));
		
		request.setAttribute("code", request.getParameter("code"));
		
		
		return null;
	}

}
