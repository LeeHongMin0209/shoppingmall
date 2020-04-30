package bookshop.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bookshop.bean.MemberBean;
import bookshop.bean.MemberDAO;

public class _17_ModifyPro implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		//수정할 회원 정보
		MemberBean member = new MemberBean();
		member.setId(request.getParameter("id"));
        member.setPasswd(request.getParameter("passwd"));
        member.setName(request.getParameter("name"));
		member.setAddress(request.getParameter("address"));
		member.setTel(request.getParameter("tel"));
		
		//수정할 회원 정보를 가지고 수정 처리 후 성공여부 반환
		MemberDAO manager = MemberDAO.getInstance();
		int check = manager.updateMember(member);
		
		request.setAttribute("check", new Integer(check));
		return "/17_modifyPro.jsp";
	}
}