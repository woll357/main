package nh_service_p;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import aacommon_p.Common;
import db_p.CenterDAO;
import db_p.CenterDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class QnaWriteReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
			
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			HttpSession session = request.getSession();
			

			
			String path = request.getRealPath("/img");
			path = new Common().getPath();
			
			try {
				MultipartRequest mm = new MultipartRequest(request, path, 10 * 1024 * 1024, "utf-8",
						new DefaultFileRenamePolicy());
				
				CenterDTO dto = new CenterDTO();
				dto.setTitle(mm.getParameter("title"));
				dto.setId(((SignUpDTO) session.getAttribute("mem")).getId());
				dto.setContent(mm.getParameter("content"));
				dto.setImg(mm.getFilesystemName("img"));


				int num = new CenterDAO().qnaWrite(dto);
		         
		        request.setAttribute("msg", "작성되었습니다.");
		        request.setAttribute("goUrl", "QnaDetail?num="+num+"&no=1&center=in");
		        request.setAttribute("mainUrl", "greensc/alert.jsp");
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			

	        
	        
	         
	     
		return null;
	}

}
