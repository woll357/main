package dk_service_p;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import aacommon_p.Common;
import db_p.Air_comDAO;
import db_p.Air_tempDAO;
import db_p.Air_tempDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class airTempHomeReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		System.out.println("진입");
		
		String path = request.getRealPath("/img");
		
		path = new Common().getPath();
		
		try {
			MultipartRequest mm = new MultipartRequest(
					request,
					path,
					10*1024*1024,
					"utf-8",
					new DefaultFileRenamePolicy()
					);
			
			Air_tempDTO dto = new Air_tempDTO();
			dto.setId(((SignUpDTO) session.getAttribute("mem")).getId());
			dto.setCrn(mm.getParameter("crn"));
			dto.setImg(mm.getParameter("img"));
			dto.setAir_name(mm.getParameter("air_name"));
			dto.setGrade(mm.getFilesystemName("grade"));
			
			new Air_tempDAO().write(dto);
		
//			System.out.println(dto.getBid());
			
			/*
			 * request.setAttribute("dto", dto);
			 */
			request.setAttribute("msg", "작성되었습니다");
			request.setAttribute("mainUrl", "air/alert.jsp");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

}
