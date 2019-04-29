package dk_service_p;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.Air_itemDAO;
import db_p.Air_itemDTO;
import db_p.LocationinfoDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class AirItem_InsertReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		
		
		//항공편 등록 INSERT
		Air_itemDTO dto = new Air_itemDTO();
		
		String darea = request.getParameter("darea");
		String ddate = request.getParameter("ddate");
		String carea = request.getParameter("carea");
		
	
		
		System.out.println("equest.getParameter(\"ddate\")equest.getParameter(\"ddate\")equest.getParameter(\"ddate\")equest.getParameter(\"ddate\")"+request.getParameter("ddate"));
		
		
		
		dto.setAp_code(request.getParameter("ap_code"));
		dto.setDdateStr(ddate);
		dto.setDarea(darea);
		dto.setImg("..");
		dto.setAir_code(((SignUpDTO) session.getAttribute("mem")).getAir_code());
		dto.setCarea(carea);
		dto.setMoney(Integer.parseInt(request.getParameter("money")));
		dto.setTotseatcnt(Integer.parseInt(request.getParameter("totseatcnt")));
		dto.setFlightclass(request.getParameter("flightclass"));
		
		
		
		
		 LocationinfoDTO ldto = new LocationinfoDTO();
		
		ldto.setCarea(carea);
		ldto.setDarea(darea);
		
		
		System.out.println(carea);
		System.out.println(darea);
		
		ldto = new Air_itemDAO().makea_time(ldto);
		
		System.out.println("시간ㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴ"+ldto.getLeadtime());
		
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date a_time = new Date();
		
		try {
			a_time = sdf.parse(ddate);
			
			
			a_time.setMinutes(a_time.getMinutes()+ldto.getLeadtime());
			
			dto.setA_time(a_time);
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Air_itemDAO().insert(dto);
		
		request.setAttribute("msg", "작성되었습니다");
		request.setAttribute("goUrl", "AirHomeMain");
		request.setAttribute("mainUrl", "air/alert.jsp");
		
		
		return null;
	}

}
