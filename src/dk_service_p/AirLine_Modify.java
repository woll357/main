package dk_service_p;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import db_p.Air_comDAO;
import db_p.Air_comDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class AirLine_Modify implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		
		
		Air_comDTO dto = new Air_comDTO();
		

		dto.setId(((SignUpDTO) session.getAttribute("mem")).getId());
	
		
		Air_comDAO dao = new Air_comDAO() ;
		
		request.setAttribute("dto", dao.comdetail(dto));
		
		
		
		
		return null;
	}

}
