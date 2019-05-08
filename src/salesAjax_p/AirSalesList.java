package salesAjax_p;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BasketpaidDAO;
import db_p.BasketpaidDTO;
import di.MvcAction;
import di.MvcForward;

public class AirSalesList implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String ccode = request.getParameter("ccode");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		System.out.println("ccode:"+ccode);
		System.out.println("year:"+year);
		System.out.println("month:"+month);
		System.out.println("day:"+day);
		
		String startday = year;
	
		
		ArrayList<BasketpaidDTO> salesList = new ArrayList<BasketpaidDTO>();
		
		if(ccode!=null) {
			
			System.out.println("방코드가 있을 때");
			
			if(year!=null && month==null && day==null) {
				String endday = ""+(Integer.parseInt(year)+1);
				month="1";
				day="1";
				startday = startday+"-"+month+"-"+day;
				endday = endday+"-"+month+"-"+day;
				
				System.out.println("연"+startday+":"+endday);
				
				salesList = new BasketpaidDAO().buyListByccodeDate(ccode, startday, endday);
				
			}
			else if(year!=null && month!=null && day==null) {
				String endday = ""+(Integer.parseInt(year));
				day="1";
				startday = startday+"-"+month+"-"+day;
				endday = endday+"-"+(Integer.parseInt(month)+1)+"-"+day;
				
				System.out.println("연월"+startday+":"+endday);
				
				salesList = new BasketpaidDAO().buyListByccodeDate(ccode, startday, endday);
			}
			else if(year!=null && month!=null && day!=null) {
				String endday = ""+(Integer.parseInt(year));
				startday = startday+"-"+month+"-"+day;
				endday = endday+"-"+month+"-"+(Integer.parseInt(day)+1);
				
				System.out.println("연월일"+startday+":"+endday);
				salesList = new BasketpaidDAO().buyListByccodeDateDay(ccode, startday);
			}
				

		}
		
		else if(ccode==null) {
			System.out.println("방코드가 없을 때");

			if(year!=null && month==null && day==null) {
				String endday = ""+(Integer.parseInt(year)+1);
				month="1";
				day="1";
				startday = startday+"-"+month+"-"+day;
				endday = endday+"-"+month+"-"+day;
				
				System.out.println("연"+startday+":"+endday);
				salesList = new BasketpaidDAO().buyListAirDate(startday, endday);
				
				
			}
			else if(year!=null && month!=null && day==null) {
				String endday = ""+(Integer.parseInt(year));
				day="1";
				startday = startday+"-"+month+"-"+day;
				endday = endday+"-"+(Integer.parseInt(month)+1)+"-"+day;
				
				System.out.println("연월"+startday+":"+endday);
				salesList = new BasketpaidDAO().buyListAirDate(startday, endday);
				
				
			}
			else if(year!=null && month!=null && day!=null) {
				String endday = ""+(Integer.parseInt(year));
				startday = startday+"-"+month+"-"+day;
				endday = endday+"-"+month+"-"+(Integer.parseInt(day)+1);

				System.out.println("연월일"+startday+":"+endday);
				salesList = new BasketpaidDAO().buyListAirDateDay(startday);
				
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
