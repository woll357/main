package dk_service_p;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import db_p.Air_comDAO;
import db_p.Air_comDTO;
import di.MvcAction;
import di.MvcForward;

public class AirLine_Modify implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		// TODO Auto-generated method stub
		System.out.println("항공사  수정 페이지");
		
		Air_comDTO dto = new Air_comDTO();
		

		dto.setId(request.getParameter("id"));
	
		
		Air_comDAO dao = new Air_comDAO() ;
		
		request.setAttribute("dto", dao.comdetail(dto));
		
		
		return null;
	}

}
