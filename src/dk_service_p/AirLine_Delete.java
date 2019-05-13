package dk_service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Air_comDAO;
import db_p.Air_comDTO;
import db_p.Air_dereDAO;
import db_p.Air_dereDTO;
import db_p.Air_itemDAO;
import db_p.Air_itemDTO;
import di.MvcAction;
import di.MvcForward;

public class AirLine_Delete implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	
		Air_itemDTO dto = new Air_itemDTO();
		dto.setAir_code(request.getParameter("air_code"));
		
		String msg = "";
		String goUrl = "";

		
		
		Air_comDTO cdto = new Air_comDTO();
		
		
		cdto.setId(request.getParameter("id"));
		
		
		
		
		if(new Air_itemDAO().aircomdelete(dto)) {
			msg = "예약상품이있습니다.";
			goUrl = "AirLine_Detail?aotcont=in";
			
		}else {
		
			msg = "삭제되었습니다.";
			goUrl = "../greensc/LogOut";
			new Air_comDAO().airlinedelete(cdto);
		}
		
		
		request.setAttribute("msg", msg);
		request.setAttribute("goUrl", goUrl );
		request.setAttribute("mainUrl", "air/alert.jsp");
		
		
		
		return null;
	}

}
