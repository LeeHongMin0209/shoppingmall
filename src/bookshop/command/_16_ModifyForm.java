package bookshop.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.MemberBean;
import bookshop.bean.MemberDAO;

public class _16_ModifyForm implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");

		//회원 정보를 수정하기 위한 정보를 얻어냄
		MemberDAO manager = MemberDAO.getInstance();
		MemberBean m = manager.getMember(id,passwd); 
		
		request.setAttribute("m",m);
		request.setAttribute("id", id);
		request.setAttribute("type", new Integer(1));
		return "/16_modifyForm.jsp";
	}
}