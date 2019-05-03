package dk_service_p;

import javax.print.DocFlavor.STRING;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.Air_itemDAO;
import db_p.Air_itemDTO;
import db_p.Air_planeDAO;
import db_p.Air_planeDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class Airplane_Delete implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	
		
		System.out.println("비행기 삭제 페이지");
		String msg = "";
		String goUrl ="";
		
		Air_planeDTO dto = new Air_planeDTO();
		
	
		dto.setAp_code(request.getParameter("ap_code"));
	
		
	
		Air_itemDTO adto = new Air_itemDTO();
		
		adto.setAp_code(request.getParameter("ap_code"));
	
		
		if(new Air_itemDAO().airplaneseatcnt(adto)) {
			msg = "예약된 상품이 있습니다.";
			goUrl ="Airplane_List?aotcont=in";
			
		}else {
			msg = "정상삭제되었습니다.";
			goUrl = "Airplane_List?aotcont=in";
			new Air_planeDAO().airplanedelete(dto);
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("goUrl", goUrl);
		request.setAttribute("mainUrl", "air/alert.jsp");
		
		
		return null;
	}

}
