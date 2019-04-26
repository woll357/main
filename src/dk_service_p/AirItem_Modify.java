package dk_service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Air_itemDAO;
import db_p.Air_itemDTO;
import di.MvcAction;
import di.MvcForward;

public class AirItem_Modify implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("AirItem_Modify 진입");
		
		System.out.println(request.getParameter("ccode"));
		
		Air_itemDTO dto = new Air_itemDTO();
		
		dto.setCcode(request.getParameter("ccode"));
		
		Air_itemDAO dao = new Air_itemDAO();
		
		request.setAttribute("dto", dao.itemdetail(dto));
		
		
		return null;
	}

}
