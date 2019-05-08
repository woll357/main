package airsell_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BasketpaidDAO;
import db_p.BasketpaidDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;
import payment_p.ChangeBstatus;

public class BoardingReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {

		String air_code = ((SignUpDTO)request.getSession().getAttribute("mem")).getAir_code();
		
		String basketID = request.getParameter("basketID");
		
		
		String bstatus = "p";
		new ChangeBstatus(basketID, bstatus);

		request.setAttribute("msg", "보딩 완료");
		request.setAttribute("mainUrl", "airsell/alert.jsp");
		request.setAttribute("goUrl", "AirReserveList?aotcont=in");
		
		return null;
	}

}
