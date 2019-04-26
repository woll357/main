package manager_p;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Air_dereDAO;
import db_p.Air_dereDTO;
import di.MvcAction;
import di.MvcForward;

public class Air_DeleteRequestList implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println("항공사 삭제 신청 목록 페이지");
		
		Air_dereDTO dto = new Air_dereDTO();
		
		ArrayList<Air_dereDTO> res= new Air_dereDAO().requestlist();
		request.setAttribute("data",res);
		
		for (Air_dereDTO aa : res) {
			System.out.println(aa.getRequsetdate());
		}
		
		
		return null;
	}

}
