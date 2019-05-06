package salesAjax_p;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BasketpaidDAO;
import db_p.BasketpaidDTO;
import di.MvcAction;
import di.MvcForward;

public class HotSalesList implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String rcode = request.getParameter("rcode");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		System.out.println("rcode:"+rcode);
		System.out.println("year:"+year);
		System.out.println("month:"+month);
		System.out.println("day:"+day);
		
		String startday = year;
	
		
		ArrayList<BasketpaidDTO> salesList = new ArrayList<BasketpaidDTO>();
		
		if(rcode!=null) {
			
			System.out.println("방코드가 있을 때");
			
			if(year!=null && month==null && day==null) {
				String endday = ""+(Integer.parseInt(year)+1);
				month="1";
				day="1";
				startday = startday+"-"+month+"-"+day;
				endday = endday+"-"+month+"-"+day;
				salesList = new BasketpaidDAO().buyListByRcodeDate(rcode, startday, endday);
				
			}
			else if(year!=null && month!=null && day==null) {
				String endday = ""+(Integer.parseInt(year));
				day="1";
				startday = startday+"-"+month+"-"+day;
				endday = endday+"-"+(Integer.parseInt(month)+1)+"-"+day;
				salesList = new BasketpaidDAO().buyListByRcodeDate(rcode, startday, endday);
			}
			else if(year!=null && month!=null && day!=null) {
				String endday = ""+(Integer.parseInt(year));
				startday = startday+"-"+month+"-"+day;
				endday = endday+"-"+month+"-"+(Integer.parseInt(day)+1);
				salesList = new BasketpaidDAO().buyListByRcodeDate(rcode, startday, endday);
			}
				

		}
		
		else if(rcode==null) {
			System.out.println("방코드가 없을 때");

			if(year!=null && month==null && day==null) {
				String endday = ""+(Integer.parseInt(year)+1);
				month="1";
				day="1";
				startday = startday+"-"+month+"-"+day;
				endday = endday+"-"+month+"-"+day;
				
				salesList = new BasketpaidDAO().buyListBHotDate(startday, endday);
				
				
			}
			else if(year!=null && month!=null && day==null) {
				String endday = ""+(Integer.parseInt(year));
				day="1";
				startday = startday+"-"+month+"-"+day;
				endday = endday+"-"+(Integer.parseInt(month)+1)+"-"+day;
				
				salesList = new BasketpaidDAO().buyListBHotDate(startday, endday);
				
				
			}
			else if(year!=null && month!=null && day!=null) {
				String endday = ""+(Integer.parseInt(year));
				startday = startday+"-"+month+"-"+day;
				endday = endday+"-"+month+"-"+(Integer.parseInt(day)+1);

				salesList = new BasketpaidDAO().buyListBHotDate(startday, endday);
				
			}
		}
		
		double totalSalesPrice = 0;
		double totalPrice = 0;
		for (BasketpaidDTO ss : salesList) {
			totalSalesPrice+=ss.getComSales();
			totalPrice+=ss.getTotalPrice();
		}
		request.setAttribute("totalPrice", totalPrice);
		request.setAttribute("totalSalesPrice", totalSalesPrice);
		request.setAttribute("salesList", salesList);
		
		return null;
	}

}
