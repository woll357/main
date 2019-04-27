package dk_service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.Air_planeDAO;
import db_p.Air_planeDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class Airplane_InsertReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		//비행기 등록
		Air_planeDTO dto = new Air_planeDTO();
		
		dto.setAir_code(((SignUpDTO) session.getAttribute("mem")).getAir_code());
		dto.setAp_code(request.getParameter("ap_code"));
		
		
		new Air_planeDAO().airplaneinsert(dto);
		
		request.setAttribute("msg", "추가되었습니다.");
		request.setAttribute("goUrl", "Airplane_List?air_code="+dto.getAir_code());
		request.setAttribute("mainUrl", "air/alert.jsp");
		return null;
	}

}
