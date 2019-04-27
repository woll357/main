package manager_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.Air_itemDAO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class AirItem_List implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	
		
		
		
		Air_itemDAO dao = new Air_itemDAO();
	      
	      request.setAttribute("data", dao.itemlistm());
	      
	      
	      System.out.println("리스트 서비스 진입");
	      
	      
	      
		return null;
	}

}
