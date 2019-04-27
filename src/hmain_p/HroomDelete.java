package hmain_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Room_itemDTO;
import di.MvcAction;
import di.MvcForward;

public class HroomDelete implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		Room_itemDTO dto = new Room_itemDTO();
		
		dto.setRcode(request.getParameter("rcode"));
		
		request.setAttribute("dto",dto);
		return null;
	}

}
