package dk_service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Air_planeDAO;
import db_p.Air_planeDTO;
import di.MvcAction;
import di.MvcForward;

public class Airplane_InsertReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		//비행기 등록
		Air_planeDTO dto = new Air_planeDTO();
		
		dto.setAir_code(request.getParameter("air_code"));
		dto.setAp_code(request.getParameter("ap_code"));
		
		
		new Air_planeDAO().airplaneinsert(dto);
		
		request.setAttribute("msg", "추가되었습니다.");
		request.setAttribute("goUrl", "Airplane_List?air_code="+dto.getAir_code());
		request.setAttribute("mainUrl", "air/alert.jsp");
		return null;
	}

}
