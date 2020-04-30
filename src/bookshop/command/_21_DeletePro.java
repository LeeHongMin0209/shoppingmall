package bookshop.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.MemberDAO;


public class _21_DeletePro implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String passwd  = request.getParameter("passwd");
		
		//사용자가 입력한 id, passwd를 가지고 회원정보 삭제 후 성공여부 반환
		MemberDAO manager = MemberDAO.getInstance();
		int check = manager.deleteMember(id,passwd);
		
		request.setAttribute("check", new Integer(check));  
		return "/21_deletePro.jsp";
	}
}