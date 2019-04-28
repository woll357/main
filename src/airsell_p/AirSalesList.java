package airsell_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import di.MvcAction;
import di.MvcForward;

public class AirSalesList implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String hcode = "A1000";
		String bstatus = "p";
		
		new ShowAirSalesList(request, response, hcode, bstatus);
		
		
		return null;
	}

}
