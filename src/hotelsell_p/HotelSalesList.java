package hotelsell_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import di.MvcAction;
import di.MvcForward;

public class HotelSalesList implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String hcode = "H1000";
		String bstatus = "p";
		
		new ShowHotelSalesList(request, response, hcode, bstatus);
		
		return null;
	}

}
