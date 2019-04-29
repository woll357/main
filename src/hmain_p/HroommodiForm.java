package hmain_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Hot_tempDAO;
import db_p.Room_itemDTO;
import di.MvcAction;
import di.MvcForward;

public class HroommodiForm implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		
		Room_itemDTO dto = new Room_itemDTO();
		
		dto.setRcode(request.getParameter("rcode"));
		
		Room_itemDTO dto2 = new Hot_tempDAO().roomdetail(dto);
		
		request.setAttribute("dto",dto2);
		
		System.out.println("방수정 서비스 진입");
		
		
		return null;
	}

}
