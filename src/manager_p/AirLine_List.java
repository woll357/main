package manager_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Air_comDAO;
import db_p.Air_comDTO;
import di.MvcAction;
import di.MvcForward;

public class AirLine_List implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		Air_comDTO dto = new Air_comDTO();
		
		//new Air_comDAO().airlinelist();
		
		request.setAttribute("data",new Air_comDAO().airlinelist());
		
		
		return null;
	}

}
