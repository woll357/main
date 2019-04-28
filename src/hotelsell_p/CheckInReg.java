package hotelsell_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BasketItemDTO;
import db_p.BasketpaidDTO;
import db_p.BuyDTO;
import di.MvcAction;
import di.MvcForward;
import payment_p.ChangeBstatus;

public class CheckInReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String hcode = "H1000";
		
		String basketID = request.getParameter("basketID");
		String bstatus = "p";
		new ChangeBstatus(basketID, bstatus);

		bstatus = "m";
		new ShowHotelReserveList(request, response, hcode, bstatus);
		
		return null;
	}

}
