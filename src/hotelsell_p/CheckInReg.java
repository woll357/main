package hotelsell_p;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BasketItemDAO;
import db_p.BasketItemDTO;
import db_p.BasketpaidDTO;
import db_p.BuyDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;
import payment_p.ChangeBstatus;

public class CheckInReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String hcode = ((SignUpDTO)request.getSession().getAttribute("mem")).getHcode();
		
		String basketID = request.getParameter("basketID");
		String bstatus = "p";

		new ChangeBstatus(basketID, bstatus);

		request.setAttribute("msg", "체크인 완료");
		request.setAttribute("mainUrl", "hotelsell/alert.jsp");
		request.setAttribute("goUrl", "HotelReserveList?hotcont=in");
		return null;
	}

}
