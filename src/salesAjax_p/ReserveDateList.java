package salesAjax_p;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BasketpaidDAO;
import db_p.BasketpaidDTO;
import di.MvcAction;
import di.MvcForward;

public class ReserveDateList implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		System.out.println("year"+year);
		System.out.println("month"+month);
		
		ArrayList<BasketpaidDTO> reserveList = new ArrayList<BasketpaidDTO>();
		
		String startday; 
		String endday;
		if(day!=null) {
			startday = year+"-"+month+"-"+day;
			endday = year+"-"+month+"-"+(Integer.parseInt(day)+1);
			reserveList = new BasketpaidDAO().dateReserveListDay(startday);
		}
		else if(day==null) {
			startday = year+"-"+month+"-"+1;
			endday = year+"-"+(Integer.parseInt(month)+1)+"-"+1;
			
			reserveList = new BasketpaidDAO().dateReserveList(startday, endday);
		}
		
		request.setAttribute("reserveList", reserveList);
		
		return null;
	}

}
