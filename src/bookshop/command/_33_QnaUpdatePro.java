package bookshop.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.QnaBean;
import bookshop.bean.QnaDAO;

public class _33_QnaUpdatePro implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int qna_id =  Integer.parseInt(request.getParameter("qna_id"));
		String qna_content = request.getParameter("qna_content");
		
		//수정에 필요한 정보구성
		QnaBean qna = new QnaBean();
		qna.setQna_id(qna_id);
		qna.setQna_content(qna_content);
		
		//qna수정
		QnaDAO qnaProcess = QnaDAO.getInstance();
		int check = qnaProcess.updateArticle(qna);
		
		request.setAttribute("check", new Integer(check));
		return "/33_qnaReplyUpdatePro.jsp";
	}
}