package salesAjax_p;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BasketpaidDAO;
import db_p.BasketpaidDTO;
import db_p.Hot_comDTO;
import db_p.Hot_tempDAO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class HotSalesList implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String hcode = ((SignUpDTO)request.getSession().getAttribute("mem")).getHcode();
		Hot_comDTO hdto = new Hot_comDTO();
		hdto.setHcode(hcode);
		hdto = new Hot_tempDAO().hotelDetailByhcode(hdto);
		
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
				salesList = new BasketpaidDAO().buyListByRcodeDate(rcode, startday, endday, hdto.getHname());
				
			}
			else if(year!=null && month!=null && day==null) {
				String endday = ""+(Integer.parseInt(year));
				day="1";
				startday = startday+"-"+month+"-"+day;
				endday = endday+"-"+(Integer.parseInt(month)+1)+"-"+day;
				salesList = new BasketpaidDAO().buyListByRcodeDate(rcode, startday, endday, hdto.getHname());
			}
			else if(year!=null && month!=null && day!=null) {
				String endday = ""+(Integer.parseInt(year));
				startday = startday+"-"+month+"-"+day;
				endday = endday+"-"+month+"-"+(Integer.parseInt(day)+1);
				salesList = new BasketpaidDAO().buyListByRcodeDateDay(rcode, startday, hdto.getHname());
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
				
				salesList = new BasketpaidDAO().buyListHotDate(startday, endday, hdto.getHname());
				
				
			}
			else if(year!=null && month!=null && day==null) {
				String endday = ""+(Integer.parseInt(year));
				day="1";
				startday = startday+"-"+month+"-"+day;
				endday = endday+"-"+(Integer.parseInt(month)+1)+"-"+day;
				
				salesList = new BasketpaidDAO().buyListHotDate(startday, endday, hdto.getHname());
				
				
			}
			else if(year!=null && month!=null && day!=null) {
				String endday = ""+(Integer.parseInt(year));
				startday = startday+"-"+month+"-"+day;
				endday = endday+"-"+month+"-"+(Integer.parseInt(day)+1);

				salesList = new BasketpaidDAO().buyListHotDateDay(startday, hdto.getHname());
				
			}
		}
		
		int totalSalesPrice = 0;
		int totalPrice = 0;
		for (BasketpaidDTO ss : salesList) {
			totalSalesPrice+=ss.getComSales();
			totalPrice+=ss.getTotalPrice();
		}
		request.setAttribute("totalPrice", new DecimalFormat("#,##0").format(totalPrice));
		request.setAttribute("totalSalesPrice", new DecimalFormat("#,##0").format(totalSalesPrice));
		request.setAttribute("salesList", salesList);
		
		return null;
	}

}
