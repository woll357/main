package manager_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.Air_comDAO;
import db_p.Air_comDTO;
import db_p.Air_itemDAO;
import db_p.Air_itemDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class AirLine_Delete implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	
		
		
		String msg = "";
		String goUrl = "";
		
		
		
		System.out.println(request.getParameter("air_code"));
		Air_comDTO dto = new Air_comDTO();
		
		dto.setAir_code(request.getParameter("air_code"));
		Air_itemDTO idto = new Air_itemDTO();
		idto.setAir_code(request.getParameter("air_code"));
		
		if(new Air_itemDAO().airitemdelete(idto)) {
			msg = "예약된 상품이 있습니다.";
			goUrl = "AirLine_List?partner=in";
		}else {
			msg = "삭제되었습니다.";
			goUrl = "AirLine_List?partner=in";
			new Air_comDAO().airlinedelete(dto);
		}
	
		
		
		request.setAttribute("msg", msg);
		request.setAttribute("goUrl", goUrl);
		request.setAttribute("mainUrl", "air/alert.jsp");
		
		
		return null;
	}

}
