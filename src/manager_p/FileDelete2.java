package manager_p;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import db_p.Hot_comDTO;
import db_p.Hot_tempDAO;
import db_p.Room_itemDTO;
import di.MvcAction;
import di.MvcForward;

public class FileDelete2 implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String path = request.getRealPath("/img");
		//path = "C:\\d\\mainWork\\mainProj\\WebContent\\img";
		path = "D:\\mainWork\\mainProj\\WebContent\\img";
		
		try {
			MultipartRequest mm = new MultipartRequest(
					request,
					path,
					10*1024*1024,
					"utf-8",
					new DefaultFileRenamePolicy()
					);
			Room_itemDTO dto = new Room_itemDTO();
			
			dto.setRcode(mm.getParameter("rcode"));
			dto.setHcode(mm.getParameter("hcode"));
			dto.setRkind(mm.getParameter("rkind"));
			dto.setRcnt(Integer.parseInt(mm.getParameter("rcnt")));
			dto.setPcnt(Integer.parseInt(mm.getParameter("pcnt")));
			dto.setWifi(mm.getParameter("wifi"));
			dto.setMoney(Integer.parseInt(mm.getParameter("money")));
			dto.setWmoney(Integer.parseInt(mm.getParameter("wmoney")));
			dto.setMorning(mm.getParameter("morning"));
			
			
			
			Room_itemDTO dto2 = new Hot_tempDAO().filedelete2(dto);
			
			if(dto2!=null) {
				File ff = new File(path+"\\"+dto2.getRimg());
				ff.delete();
			}
			else {
				dto.setRimg(mm.getParameter("rimg"));
			}		
			
			request.setAttribute("dto", dto);
				
			request.setAttribute("mainUrl", "manager/HroomModiForm.jsp");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}

}
