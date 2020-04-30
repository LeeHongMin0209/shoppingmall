package bookshop.command;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bookshop.bean.MemberBean;
import bookshop.bean.MemberDAO;

public class _19_RegisterPro implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		//회원가입 정보
		MemberBean member = new MemberBean();
		member.setId(request.getParameter("id"));
        member.setPasswd(request.getParameter("passwd"));
        member.setName(request.getParameter("name"));
        member.setReg_date(new Timestamp(System.currentTimeMillis()).toString());
		member.setAddress(request.getParameter("address"));
		member.setTel(request.getParameter("tel"));
        
		//회원가입처리
        MemberDAO dbPro = MemberDAO.getInstance();
        dbPro.insertMember(member);
		
		return "/19_registerPro.jsp";
	}

}
