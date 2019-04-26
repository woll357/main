package hmain_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.Hot_comDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class Hmain implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
	    SignUpDTO dto = new SignUpDTO();
		dto.setId("qqq");
		dto.setGrade("H");
		dto.setHcode("H1000");
	    
	    session.setAttribute("mem",dto);
	    
	    
		
		return null;
	}

}
