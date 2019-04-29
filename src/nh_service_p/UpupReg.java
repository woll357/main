package nh_service_p;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import db_p.SignUpDAO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class UpupReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String path = request.getRealPath("/img");
		path = "D:\\mainWork\\mainProj\\WebContent\\img";

		try {
			MultipartRequest mm = new MultipartRequest(request, path, 10 * 1024 * 1024, "utf-8",
					new DefaultFileRenamePolicy());

			HttpSession session = request.getSession();
			SignUpDTO dto = new SignUpDTO();
			dto.setId(((SignUpDTO) session.getAttribute("mem")).getId());
			dto.setGrade(mm.getParameter("grade"));

			if (new SignUpDAO().chkApply(dto)) {
				request.setAttribute("msg", "이미 신청하셨습니다.");
				request.setAttribute("mainUrl", "greensc/alert.jsp");
				request.setAttribute("goUrl", "Appbss");
			} else {

				if (new SignUpDAO().chkempty(dto)) {
					request.setAttribute("msg", "관계자는 예약하실 수 없습니다. 예약내역을 환불하여 주세요.");
					request.setAttribute("mainUrl", "greensc/alert.jsp");
					request.setAttribute("goUrl", "Appbss");
				} else {

					if (mm.getParameter("grade").equals("M")) {

						dto.setBnum(mm.getParameter("bnum"));
						dto.setGrade(mm.getParameter("grade"));
					} else if (mm.getParameter("grade").equals("A")) {

						dto.setCrn(mm.getParameter("crn"));
						dto.setGrade(mm.getParameter("grade"));
						dto.setAir_name(mm.getParameter("air_name"));
						dto.setAir_codecom(mm.getParameter("air_codecom"));
						dto.setImg(mm.getFilesystemName("img"));
					} else {

						dto.setCrn(mm.getParameter("crn"));
						dto.setGrade(mm.getParameter("grade"));
						dto.setHname(mm.getParameter("hname"));
						dto.setHinfo(mm.getParameter("hinfo"));
						dto.setHimg(mm.getFilesystemName("himg"));
					}

					new SignUpDAO().upupGrade(dto);
					request.setAttribute("msg", "신청이 완료되었습니다.");
					request.setAttribute("mainUrl", "greensc/alert.jsp");
					request.setAttribute("goUrl", "Appbss");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
