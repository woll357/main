package salesAjax_p;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BasketDAO;
import db_p.BasketpaidDAO;
import db_p.BasketpaidDTO;
import di.MvcAction;
import di.MvcForward;

public class SellList implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String comcode = request.getParameter("comcode");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		System.out.println("comcode:"+comcode);
		System.out.println("year:"+year);
		System.out.println("month:"+month);
		System.out.println("day:"+day);
		
		String startday = year;
	
		
		ArrayList<BasketpaidDTO> salesList = new ArrayList<BasketpaidDTO>();
		
		if(comcode!=null) {
			
			System.out.println("회사명이 있을 때");
			
			if(comcode.substring(0, 1).equals("A")) {
		
				
				if(year!=null && month==null && day==null) {
					String endday = ""+(Integer.parseInt(year)+1);
					month="1";
					day="1";
					startday = startday+"-"+month+"-"+day;
					endday = endday+"-"+month+"-"+day;
					salesList = new BasketpaidDAO().buyListByAirComDate(comcode, startday, endday);
					
				}
				else if(year!=null && month!=null && day==null) {
					String endday = ""+(Integer.parseInt(year));
					day="1";
					startday = startday+"-"+month+"-"+day;
					endday = endday+"-"+(Integer.parseInt(month)+1)+"-"+day;
					salesList = new BasketpaidDAO().buyListByAirComDate(comcode, startday, endday);
				}
				else if(year!=null && month!=null && day!=null) {
					String endday = ""+(Integer.parseInt(year));
					startday = startday+"-"+month+"-"+day;
					endday = endday+"-"+month+"-"+(Integer.parseInt(day)+1);
					salesList = new BasketpaidDAO().buyListByAirComDateDay(comcode, startday);
				}
			}
			else if(comcode.substring(0, 1).equals("H")) {

				
				if(year!=null && month==null && day==null) {
					String endday = ""+(Integer.parseInt(year)+1);
					month="1";
					day="1";
					startday = startday+"-"+month+"-"+day;
					endday = endday+"-"+month+"-"+day;
					salesList = new BasketpaidDAO().buyListByHotComDate(comcode, startday, endday);
					
					System.out.println("여긴들어오니?");
					
				}
				else if(year!=null && month!=null && day==null) {
					String endday = ""+(Integer.parseInt(year));
					day="1";
					startday = startday+"-"+month+"-"+day;
					endday = endday+"-"+(Integer.parseInt(month)+1)+"-"+day;
					salesList = new BasketpaidDAO().buyListByHotComDate(comcode, startday, endday);
				}
				else if(year!=null && month!=null && day!=null) {
					String endday = ""+(Integer.parseInt(year));
					startday = startday+"-"+month+"-"+day;
					endday = endday+"-"+month+"-"+(Integer.parseInt(day)+1);
					salesList = new BasketpaidDAO().buyListByHotComDateDay(comcode, startday);
				}
			}
			

		}
		
		else if(comcode==null) {
			System.out.println("회사명이 없을 때");

			
			if(year!=null && month==null && day==null) {
				String endday = ""+(Integer.parseInt(year)+1);
				month="1";
				day="1";
				startday = startday+"-"+month+"-"+day;
				endday = endday+"-"+month+"-"+day;
				
				System.out.println(startday+":"+endday+"dddddddddddddddddddddddddddddddddddddd");
				
				ArrayList<BasketpaidDTO> plists = new BasketpaidDAO().buyListByDate(startday, endday);
				
				ArrayList<BasketpaidDTO> hlists = new ArrayList<BasketpaidDTO>();
				ArrayList<BasketpaidDTO> alists = new ArrayList<BasketpaidDTO>();
				
				for (BasketpaidDTO bb : plists) {
					if(bb.getcType().equals("H")) {
						hlists.add(bb);
					}
					else if(bb.getcType().equals("A")) {
						alists.add(bb);
					}
				}
				
				for (BasketpaidDTO bpdto : hlists) {
					bpdto = new BasketpaidDAO().giveSalesPercentHot(bpdto);
					salesList.add(bpdto);
				}
				
				for (BasketpaidDTO bpdto : alists) {
					bpdto = new BasketpaidDAO().giveSalesPercentAir(bpdto);
					salesList.add(bpdto);
				}
				
			}
			else if(year!=null && month!=null && day==null) {
				String endday = ""+(Integer.parseInt(year));
				day="1";
				startday = startday+"-"+month+"-"+day;
				endday = endday+"-"+(Integer.parseInt(month)+1)+"-"+day;
				
				System.out.println(startday+":"+endday+"qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
				
				ArrayList<BasketpaidDTO> plists = new BasketpaidDAO().buyListByDate(startday, endday);
				
				ArrayList<BasketpaidDTO> hlists = new ArrayList<BasketpaidDTO>();
				ArrayList<BasketpaidDTO> alists = new ArrayList<BasketpaidDTO>();
				
				for (BasketpaidDTO bb : plists) {
					if(bb.getcType().equals("H")) {
						hlists.add(bb);
					}
					else if(bb.getcType().equals("A")) {
						alists.add(bb);
					}
				}
				
				for (BasketpaidDTO bpdto : hlists) {
					bpdto = new BasketpaidDAO().giveSalesPercentHot(bpdto);
					salesList.add(bpdto);
				}
				
				for (BasketpaidDTO bpdto : alists) {
					bpdto = new BasketpaidDAO().giveSalesPercentAir(bpdto);
					salesList.add(bpdto);
				}
				
			}
			else if(year!=null && month!=null && day!=null) {
				String endday = ""+(Integer.parseInt(year));
				startday = startday+"-"+month+"-"+day;
				endday = endday+"-"+month+"-"+(Integer.parseInt(day)+1);

				
				ArrayList<BasketpaidDTO> plists = new BasketpaidDAO().buyListByDateDay(startday);
				
				ArrayList<BasketpaidDTO> hlists = new ArrayList<BasketpaidDTO>();
				ArrayList<BasketpaidDTO> alists = new ArrayList<BasketpaidDTO>();
				
				for (BasketpaidDTO bb : plists) {
					if(bb.getcType().equals("H")) {
						hlists.add(bb);
					}
					else if(bb.getcType().equals("A")) {
						alists.add(bb);
					}
				}
				
				for (BasketpaidDTO bpdto : hlists) {
					bpdto = new BasketpaidDAO().giveSalesPercentHot(bpdto);
					salesList.add(bpdto);
				}
				
				for (BasketpaidDTO bpdto : alists) {
					bpdto = new BasketpaidDAO().giveSalesPercentAir(bpdto);
					salesList.add(bpdto);
				}
			}
		}
		
		double totalSalesPrice = 0;
		double totalPrice = 0;
		for (BasketpaidDTO ss : salesList) {
			totalSalesPrice+=ss.getManagerSales();
			totalPrice+=ss.getTotalPrice();
		}
		request.setAttribute("totalPrice", new DecimalFormat("#,##0").format(totalPrice));
		request.setAttribute("totalSalesPrice", new DecimalFormat("#,##0").format(totalSalesPrice));
		request.setAttribute("salesList", salesList);
		
		
		return null;
	}

}
