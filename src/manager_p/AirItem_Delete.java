package manager_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Air_itemDAO;
import db_p.Air_itemDTO;
import di.MvcAction;
import di.MvcForward;

public class AirItem_Delete implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		//상품 삭제
		Air_itemDTO dto = new Air_itemDTO();
		
		String msg = "";
		String goUrl = "";
		
		dto.setCcode(request.getParameter("ccode"));
		
		Air_itemDAO dao = new Air_itemDAO();
		
		if(new Air_itemDAO().airseatcntdetail(dto)) {
			
			msg = "예약 상품이 있습니다.";
			goUrl = "AirItem_Detail?ccode="+dto.getCcode();
			
		}else {
			
			msg ="삭제되었습니다.";
			goUrl = "AirItem_List?partner=in";
			dao.delete(dto);
			
		}
		
		request.setAttribute("msg",  msg);
		request.setAttribute("goUrl", goUrl);
		request.setAttribute("mainUrl", "air/alert.jsp");
		
		
		return null;
	}

}
