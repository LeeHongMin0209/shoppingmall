package bookshop.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.CartBean;
import bookshop.bean.CartDAO;

public class _35_CartList implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String buyer = request.getParameter("buyer");
		 
		List<CartBean> cartLists = null;
		int count = 0;

		//해당 buyer의 장바구니 목록의 수를 얻어냄
		CartDAO bookProcess = CartDAO.getInstance();
		count = bookProcess.getListCount(buyer);
		
		if(count > 0){//해당 buyer의 장바구니 목록이 있으면 수행
			//해당 buyer의 장바구니 목록을 얻어냄
			cartLists = bookProcess.getCart(buyer, count);
			request.setAttribute("cartLists", cartLists);
		}
		
		request.setAttribute("count", new Integer(count));
		request.setAttribute("type", new Integer(1));
		return "/35_cartList.jsp";
	}
}