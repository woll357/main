package hmain_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.Room_itemDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class HroomwriteForm implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		  Room_itemDTO dtoto = new Room_itemDTO();

		  dtoto.setHcode(((SignUpDTO) session.getAttribute("mem")).getHcode());
		return null;
	}

}
