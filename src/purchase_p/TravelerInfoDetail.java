package purchase_p;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.TravelerInfoDAO;
import db_p.TravelerInfoDTO;
import di.MvcAction;
import di.MvcForward;

public class TravelerInfoDetail implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String basketID = request.getParameter("basketID");
		
		ArrayList<TravelerInfoDTO> tdtos = new ArrayList<TravelerInfoDTO>();
		
		TravelerInfoDTO tdto = new TravelerInfoDTO();
		tdto.setBasketID(basketID);
		
		tdtos = new TravelerInfoDAO().TravelerInfoListByBasketID(tdto);
		
		System.out.println(tdtos.size());
		
		request.setAttribute("tdtos",tdtos);
		request.setAttribute("mainUrl", "purchase/TravelerInfoDetail.jsp");
		
		
		return null;
	}

}
