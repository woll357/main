package dk_service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.Air_itemDAO;
import db_p.Air_planeDAO;
import db_p.Air_planeDTO;
import db_p.Airp_detailsDAO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class Airplane_InsertReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		//비행기 등록
		
		String msg= "";
		String goUrl = "";
		String air_code = ((SignUpDTO) session.getAttribute("mem")).getAir_code();		
		
		Air_planeDTO dto = new Air_planeDTO();
		
		
		
		dto.setAir_code(air_code);
		dto.setAp_code(request.getParameter("ap_code"));
		dto.setAir_ty(request.getParameter("air_ty"));
		
		
		
		
		
		
		if(new Air_planeDAO().apvalidity2(request.getParameter("ap_code"))) {		
			
			
			msg = "있는 비행기입니다.";
			goUrl = "Airplane_Insert?air_code"+dto.getAir_code();
			
			
		}else {
			
			msg = "추가되었습니다.";
			goUrl = "Airplane_List?air_code="+dto.getAir_code()+"&aotcont=in";
			
			new Air_planeDAO().airplaneinsert(dto);
		}
		
		
		
		
		
		
		
		
		
		
		request.setAttribute("msg", msg);
		request.setAttribute("goUrl", goUrl);
		request.setAttribute("mainUrl", "air/alert.jsp");
		return null;
		
		
		
		
		
		
		
	}

}
