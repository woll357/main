package dk_service_p;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import aacommon_p.Common;
import db_p.Air_comDAO;
import db_p.Air_comDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class AirLine_ModifyFm implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
	System.out.println(" AirLine_ModifyFm 페이지 진입");
	System.out.println(" 항공사가 수정이 되는 페이지");
		
		String path = request.getRealPath("/img");
		//path = "C:\\apache-tomcat-8.5.38\\webapps\\mainProj\\img";
		path = new Common().getPath();
		
		try {
			MultipartRequest mm = new MultipartRequest(
					request,
					path,
					10*1024*1024,
					"utf-8",
					new DefaultFileRenamePolicy()
					);
		      
		      Air_comDTO dto = new Air_comDTO();
		      

			
			if(mm.getParameter("img")!=null) {
				
				  dto.setImg(mm.getParameter("img"));
			}else {
				dto.setImg(mm.getFilesystemName("img"));
			}
			
			dto.setId(((SignUpDTO) session.getAttribute("mem")).getId());
			
			String msg = "";
			String goUrl = "aircom_detail";
			
			
			if(new Air_comDAO().aircommodify(dto)) {
				msg = "수정되었습니다.";
				goUrl = "AirLine_Detail?id="+dto.getId();
				
			}
//			else if((mm.getParameter("img")==null)){
//				File ff = new File(path+"\\"+dto.getImg());
//				ff.delete();
//			}
			
			request.setAttribute("msg", msg);
			request.setAttribute("goUrl", goUrl);
			request.setAttribute("mainUrl", "air/alert.jsp");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;

		
	}

}
