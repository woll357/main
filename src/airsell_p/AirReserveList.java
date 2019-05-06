/**
 * 
 */
package airsell_p;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Air_itemDAO;
import db_p.Air_itemDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

/**
 * @author User
 *
 */
public class AirReserveList implements MvcAction {

	/* (non-Javadoc)
	 * @see di.MvcAction#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String air_code = ((SignUpDTO)request.getSession().getAttribute("mem")).getAir_code();
		
		Air_itemDTO aidto = new Air_itemDTO();
		aidto.setAir_code(air_code);
		ArrayList<Air_itemDTO> aidtos = new Air_itemDAO().itemlistByAir_Code(aidto);
		request.setAttribute("aidtos", aidtos);
		
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
		
		
		System.out.println("여기까진 오니?");
		
		//		String bstatus = "m";
//		//예약내역 확인할꺼야
//		
//		new ShowAirReserveList(request, response, air_code, bstatus);
//		request.setAttribute("mainUrl", "airsell/AirReserveList.jsp");
		
		return null;
	}

}
