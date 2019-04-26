package hmain_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		
		HttpSession session = request.getSession();
	      dto.setId(((SignUpDTO) session.getAttribute("mem")).getId());
	     
	      

		
		Hot_comDTO dto2 = new Hot_tempDAO().detail(dto);

		request.setAttribute("dto",dto2);
	
		System.out.println("디테일 서비스 진입");
		String id = request.getParameter("hcode");
		System.out.println(id);
		
		
		  Room_itemDTO dtoto = new Room_itemDTO();

		  dtoto.setHcode(((SignUpDTO) session.getAttribute("mem")).getHcode());
		
		request.setAttribute("roomdata", new Hot_tempDAO().roomlist(dtoto));
		System.out.println("룸리스트 서비스 진입");
		return null;
	}

}
