package dk_service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Air_itemDAO;
import db_p.Air_itemDTO;
import di.MvcAction;
import di.MvcForward;

public class AirItem_InsertReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		//항공편 등록 INSERT
		Air_itemDTO dto = new Air_itemDTO();
		
		dto.setAp_code(request.getParameter("ap_code"));
		dto.setDdateStr(request.getParameter("ddate"));
		dto.setDarea(request.getParameter("darea"));
		dto.setCarea(request.getParameter("carea"));
		dto.setMoney(Integer.parseInt(request.getParameter("money")));
		dto.setTotseatcnt(Integer.parseInt(request.getParameter("totseatcnt")));
		dto.setFlightclass(request.getParameter("flightclass"));
		
		
		new Air_itemDAO().insert(dto);
		
		request.setAttribute("msg", "작성되었습니다");
		request.setAttribute("goUrl", "AirHomeMain");
		request.setAttribute("mainUrl", "air/alert.jsp");
		
		
		return null;
	}

}
