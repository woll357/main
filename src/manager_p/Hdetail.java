package manager_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Hot_comDTO;
import db_p.Hot_tempDAO;
import db_p.Room_itemDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class Hdetail implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Hot_comDTO dto = new Hot_comDTO();
		dto.setHcode(request.getParameter("hcode"));
			
		Hot_comDTO dto2 = new Hot_tempDAO().detail2(dto);
		
		request.setAttribute("dto",dto2);
		
		  Room_itemDTO dtoto = new Room_itemDTO();

		  dtoto.setHcode(request.getParameter("hcode"));
		
		request.setAttribute("roomdata", new Hot_tempDAO().roomlist(dtoto));
		
		
		return null;
	}

}
