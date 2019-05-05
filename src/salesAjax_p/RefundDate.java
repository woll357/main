package salesAjax_p;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import di.MvcAction;
import di.MvcForward;

public class RefundDate implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		int yearLimit = 10;
		
		Date today = new Date();
		int startYear = today.getYear()-yearLimit+1900;
		int endYear = today.getYear()+yearLimit+1900;
		
		ArrayList<String> years = new ArrayList<String>();
		
		for (int i = startYear; i <= endYear; i++) {
			years.add(""+i);
		}
		
		request.setAttribute("years", years);
		return null;
		
	}

}
