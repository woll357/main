package salesAjax_p;

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

public class HotReserveList implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String hcode = ((SignUpDTO)request.getSession().getAttribute("mem")).getHcode();
		Hot_comDTO hdto = new Hot_comDTO();
		hdto.setHcode(hcode);
		hdto = new Hot_tempDAO().hotelDetailByhcode(hdto);
		
		String rcode = request.getParameter("rcode");
		System.out.println("rcode뭐나와?2222222222222"+rcode);
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		System.out.println("year"+year);
		System.out.println("month"+month);
		
		ArrayList<BasketpaidDTO> reserveList = new ArrayList<BasketpaidDTO>();
		
		String startday; 
		String endday;
		if(rcode!=null) {
			if(day!=null) {
				startday = year+"-"+month+"-"+day;
				endday = year+"-"+month+"-"+(Integer.parseInt(day)+1);
				reserveList = new BasketpaidDAO().reserveListByHotRcodeDateDay(rcode, startday);
			}
			else if(day==null) {
				startday = year+"-"+month+"-"+1;
				endday = year+"-"+(Integer.parseInt(month)+1)+"-"+1;
				
				reserveList = new BasketpaidDAO().reserveListByHotRcodeDate(rcode, startday, endday);
			}
		}
		else if(rcode==null) {
			if(day!=null) {
				startday = year+"-"+month+"-"+day;
				endday = year+"-"+month+"-"+(Integer.parseInt(day)+1);
				reserveList = new BasketpaidDAO().reserveListByHotDateDay(hdto.getHname(), startday);
			}
			else if(day==null) {
				startday = year+"-"+month+"-"+1;
				endday = year+"-"+(Integer.parseInt(month)+1)+"-"+1;
				
				reserveList = new BasketpaidDAO().reserveListByHotDate(hdto.getHname(), startday, endday);
			}
		}
		
		
		
		request.setAttribute("reserveList", reserveList);
		return null;
	}

}
