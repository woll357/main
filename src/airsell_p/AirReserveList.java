/**
 * 
 */
package airsell_p;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Air_itemDAO;
import db_p.Air_itemDTO;
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
public class AirReserveList implements MvcAction {

	/* (non-Javadoc)
	 * @see di.MvcAction#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String air_code = ((SignUpDTO)request.getSession().getAttribute("mem")).getAir_code();
		String bstatus = "m";
		//예약내역 확인할꺼야
		
		new ShowAirReserveList(request, response, air_code, bstatus);
		request.setAttribute("mainUrl", "airsell/AirReserveList.jsp");
		
		return null;
	}

}
