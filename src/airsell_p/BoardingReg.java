package airsell_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;
import payment_p.ChangeBstatus;

public class BoardingReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String air_code = ((SignUpDTO)request.getSession().getAttribute("mem")).getAir_code();
		
		String basketID = request.getParameter("basketID");
		String bstatus = "p";
		new ChangeBstatus(basketID, bstatus);

		bstatus = "m";
		new ShowAirReserveList(request, response, air_code, bstatus);
		
		
		return null;
	}

}
