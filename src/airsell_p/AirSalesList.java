package airsell_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class AirSalesList implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String air_code = ((SignUpDTO)request.getSession().getAttribute("mem")).getAir_code();
		String bstatus = "p";
		
		new ShowAirSalesList(request, response, air_code, bstatus);
		
		request.setAttribute("mainUrl", "airsell/AirSalesList.jsp");
		return null;
	}

}
