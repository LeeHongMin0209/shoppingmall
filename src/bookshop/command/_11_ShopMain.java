package bookshop.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.ManagerBean;
import bookshop.bean.ManagerDAO;

public class _11_ShopMain implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		ManagerBean bookList[] = null;
		List<ManagerBean[]> bookLists = new ArrayList<ManagerBean[]>();
		
		ManagerDAO bookProcess = ManagerDAO.getInstance();//DB연동
		
		//카테고리별 최신의 상품 3개씩 얻어내서 List에 저장
		for(int i=1; i<=3;i++){
			bookList = bookProcess.getBooks(i+"00",3);
			bookLists.add(bookList);
		}
		
        //해당 페이지로 보낼 내용 설정
        request.setAttribute("bookLists", bookLists);
        //사용자 화면을 의미하는 값을 설정
		request.setAttribute("type", new Integer(1));
		return "/11_shopMain.jsp";
	}
}