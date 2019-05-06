/**
 * 
 */
package hotelsell_p;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BasketItemDAO;
import db_p.BasketItemDTO;
import db_p.BasketpaidDAO;
import db_p.BasketpaidDTO;
import db_p.Hot_tempDAO;
import db_p.Room_itemDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

/**
 * @author User
 *
 */
public class HotelReserveList implements MvcAction {

	/* (non-Javadoc)
	 * @see di.MvcAction#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String hcode = ((SignUpDTO)request.getSession().getAttribute("mem")).getHcode();
		
		Room_itemDTO ridto = new Room_itemDTO();
		ridto.setHcode(hcode);
		ArrayList<Room_itemDTO> ridtos = (ArrayList<Room_itemDTO>) new Hot_tempDAO().roomlist(ridto);
		request.setAttribute("ridtos", ridtos);
		
		
		Date today = new Date();
		
		int startYear = today.getYear()+1900;
		int startMonth = today.getMonth()+1;
		int startDate = today.getDate();

		System.out.println("startYear"+startYear);
		System.out.println("startMonth"+startMonth);
		System.out.println("startDate"+startDate);
		
		today.setMonth(today.getMonth()+3);
		
		int endYear = today.getYear()+1900;
		int endMonth = today.getMonth()+1;
		int endDate = today.getDate();
		
		System.out.println("endYear"+endYear);
		System.out.println("endMonth"+endMonth);
		System.out.println("endDate"+endDate);
		
		ArrayList<String> years = new ArrayList<String>();
		
		if(startYear==endYear) {
			years.add(""+startYear);
			request.setAttribute("years", years);
		}
		else if(startYear!=endYear) {
			years.add(""+startYear);
			years.add(""+endYear);
			request.setAttribute("years", years);
		}
		
		
		
//		String bstatus = "m";
		//예약내역 확인할꺼야
		
//		new ShowHotelReserveList(request, response, hcode, bstatus);
//		request.setAttribute("mainUrl", "hotelsell/HotelReserveList.jsp");
		return null;
	}

}
