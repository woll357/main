package salesAjax_p;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Air_comDAO;
import db_p.Air_comDTO;
import db_p.BasketpaidDAO;
import db_p.BasketpaidDTO;
import db_p.Hot_comDTO;
import db_p.Hot_tempDAO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class AirReserveList implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String air_code = ((SignUpDTO)request.getSession().getAttribute("mem")).getAir_code();
		Air_comDTO adto = new Air_comDTO();
		adto.setAir_code(air_code);
		adto = new Air_comDAO().serarchByAirCode(adto);
		
		String ccode = request.getParameter("ccode");
		System.out.println("ccode뭐나와?2222222222222"+ccode);
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		System.out.println("year"+year);
		System.out.println("month"+month);
		
		ArrayList<BasketpaidDTO> reserveList = new ArrayList<BasketpaidDTO>();
		
		String startday; 
		String endday;
		if(ccode!=null) {
			if(day!=null) {
				startday = year+"-"+month+"-"+day;
				endday = year+"-"+month+"-"+(Integer.parseInt(day)+1);
				reserveList = new BasketpaidDAO().reserveListByAirCcodeDate(ccode, startday, endday);
			}
			else if(day==null) {
				startday = year+"-"+month+"-"+1;
				endday = year+"-"+(Integer.parseInt(month)+1)+"-"+1;
				
				reserveList = new BasketpaidDAO().reserveListByAirCcodeDate(ccode, startday, endday);
			}
		}
		else if(ccode==null) {
			if(day!=null) {
				startday = year+"-"+month+"-"+day;
				endday = year+"-"+month+"-"+(Integer.parseInt(day)+1);
				reserveList = new BasketpaidDAO().reserveListByAirDate(adto.getAir_name(), startday, endday);
			}
			else if(day==null) {
				startday = year+"-"+month+"-"+1;
				endday = year+"-"+(Integer.parseInt(month)+1)+"-"+1;
				
				reserveList = new BasketpaidDAO().reserveListByAirDate(adto.getAir_name(), startday, endday);
			}
		}
		
		request.setAttribute("reserveList", reserveList);
		return null;
	}

}
