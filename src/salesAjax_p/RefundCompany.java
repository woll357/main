package salesAjax_p;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Air_comDAO;
import db_p.Air_comDTO;
import db_p.Hot_comDTO;
import db_p.Hot_tempDAO;
import di.MvcAction;
import di.MvcForward;

public class RefundCompany implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HashMap<String, String> clists = new HashMap<String, String>();
		
		ArrayList<Air_comDTO> aclist = new Air_comDAO().air_comList();
		for (Air_comDTO aa : aclist) {
			clists.put(aa.getAir_code(), aa.getAir_name());
		}
		
		ArrayList<Hot_comDTO> hclist = new Hot_tempDAO().hotelList();
		for (Hot_comDTO hh : hclist) {
			clists.put(hh.getHcode(), hh.getHname());
		}
		
		request.setAttribute("clists", clists);
		
		return null;
	}

}
