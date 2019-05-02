package hmain_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Hold_tableDTO;
import db_p.Hot_tempDAO;
import db_p.Room_itemDTO;
import di.MvcAction;
import di.MvcForward;

public class HnoresList implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Hold_tableDTO dto = new Hold_tableDTO();
		
		 dto.setRcode(request.getParameter("rcode")); 
		/* dto.setNo(Integer.parseInt(request.getParameter("no"))); */
		
		
		request.setAttribute("data", new Hot_tempDAO().noreslist(dto));
		
		return null;
	}

}
