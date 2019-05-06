package salesAjax_p;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import di.MvcAction;
import di.MvcForward;

public class ReserveDate implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
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

		return null;
	}

}
