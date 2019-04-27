package manager_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Air_comDAO;
import db_p.Air_comDTO;
import db_p.Air_itemDAO;
import db_p.Air_itemDTO;
import di.MvcAction;
import di.MvcForward;

public class AirLine_Delete implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		System.out.println("항공사 삭제 페에지");
		
		Air_comDTO dto = new Air_comDTO();
		
		dto.setId(request.getParameter("id"));
		
		
		new Air_comDAO().airlinedelete(dto);
		
		request.setAttribute("msg", "삭제되었습니다.");
		request.setAttribute("goUrl", "AirLine_List");
		request.setAttribute("mainUrl", "air/alert.jsp");
		
		
		return null;
	}

}
