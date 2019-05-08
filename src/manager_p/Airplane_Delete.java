package manager_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Air_itemDAO;
import db_p.Air_itemDTO;
import db_p.Air_planeDAO;
import db_p.Air_planeDTO;
import di.MvcAction;
import di.MvcForward;

public class Airplane_Delete implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	
		String msg = "";
		String goUrl = "";
		
		Air_planeDTO dto = new Air_planeDTO();
		Air_itemDTO adto = new Air_itemDTO();
		adto.setAp_code(request.getParameter("ap_code"));
	
		
		dto.setAp_code(request.getParameter("ap_code"));
	
		
		if(new Air_itemDAO().airitemplanedelete(adto)) {
			msg="예약상품이 있습니다.";
			goUrl = "Airplane_List?aotcont=in";
			
		}else {
			msg = "삭제되었습니다.";
			goUrl = "Airplane_List?aotcont=in";
			new Air_planeDAO().airplanedelete(dto);
		}
		
		
	
		
		
		
		request.setAttribute("msg", msg);
		request.setAttribute("goUrl", goUrl);
		request.setAttribute("mainUrl", "air/alert.jsp");
		
		
		return null;
	}

}
