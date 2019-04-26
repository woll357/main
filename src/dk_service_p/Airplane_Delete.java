package dk_service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Air_planeDAO;
import db_p.Air_planeDTO;
import di.MvcAction;
import di.MvcForward;

public class Airplane_Delete implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println(request.getParameter("ap_code"));
		System.out.println("비행기 삭제 페이지");
		System.out.println(request.getParameter("ap_code"));
		
		Air_planeDTO dto = new Air_planeDTO();
		
	
		
		dto.setAp_code(request.getParameter("ap_code"));
	
		new Air_planeDAO().airplanedelete(dto);
		/* Airplane_List?air_code=A1000 */
		
		request.setAttribute("msg", "삭제되었습니다.");
		request.setAttribute("goUrl", "AirHomeMain");
		request.setAttribute("mainUrl", "air/alert.jsp");
		
		
		return null;
	}

}
