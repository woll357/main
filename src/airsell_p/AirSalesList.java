package airsell_p;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Air_itemDAO;
import db_p.Air_itemDTO;
import db_p.Hot_tempDAO;
import db_p.Room_itemDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class AirSalesList implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String air_code = ((SignUpDTO)request.getSession().getAttribute("mem")).getAir_code();

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
		ArrayList<Air_itemDTO> ailists = new ArrayList<Air_itemDTO>();
		
		Air_itemDTO aidto = new Air_itemDTO();
		aidto.setAir_code(air_code);
		ailists = new Air_itemDAO().itemlistByAir_Code(aidto);
		
		request.setAttribute("ailists", ailists);
		request.setAttribute("mainUrl", "airsell/AirSalesList.jsp");
		
		
//		String bstatus = "p";
//		
//		new ShowAirSalesList(request, response, air_code, bstatus);
//		
//		request.setAttribute("mainUrl", "airsell/AirSalesList.jsp");
		return null;
	}

}
