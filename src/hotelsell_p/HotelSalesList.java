package hotelsell_p;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Hot_tempDAO;
import db_p.Room_itemDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class HotelSalesList implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String hcode = ((SignUpDTO)request.getSession().getAttribute("mem")).getHcode();

		
		int yearLimit = 10;
		
		Date today = new Date();
		int startYear = today.getYear()-yearLimit+1900;
		int todayYear = today.getYear()+1900;
		ArrayList<String> years = new ArrayList<String>();
		
		for (int i = startYear; i <= todayYear; i++) {
			years.add(""+i);
		}
		
		request.setAttribute("years", years);

		//방 목록 설정
		ArrayList<Room_itemDTO> rlists = new ArrayList<Room_itemDTO>();
		
		Room_itemDTO ridto = new Room_itemDTO();
		ridto.setHcode(hcode);
		rlists = (ArrayList<Room_itemDTO>) new Hot_tempDAO().roomlist(ridto);
		
		request.setAttribute("rlists", rlists);
		

		request.setAttribute("mainUrl", "hotelsell/HotelSalesList.jsp");
		
		//		String bstatus = "p";
//		
//		new ShowHotelSalesList(request, response, hcode, bstatus);

		
		return null;
	}

}
