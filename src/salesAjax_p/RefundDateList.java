package salesAjax_p;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BasketDAO;
import db_p.BasketpaidDAO;
import db_p.BasketpaidDTO;
import di.MvcAction;
import di.MvcForward;

public class RefundDateList implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		
		String start = year+"-"+month+"-1";
		String end = year+"-"+(Integer.parseInt(month)+1)+"-1";
		
		ArrayList<BasketpaidDTO> refundLists = new BasketpaidDAO().dateRefundList(start, end);
		
		request.setAttribute("refundLists", refundLists);
		return null;
	}

}
