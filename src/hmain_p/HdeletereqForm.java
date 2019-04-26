package hmain_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.Hot_comDTO;
import db_p.Room_itemDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class HdeletereqForm implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub


		Hot_comDTO dto2 = new Hot_comDTO();
		
		
		HttpSession session = request.getSession();
	      dto2.setId(((SignUpDTO) session.getAttribute("mem")).getId());
		
		
		  Room_itemDTO dtoto = new Room_itemDTO();

		  dtoto.setHcode(((SignUpDTO) session.getAttribute("mem")).getHcode());
		
		return null;
	}

}
