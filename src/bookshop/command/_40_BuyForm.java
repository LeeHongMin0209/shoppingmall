package bookshop.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.BuyDAO;
import bookshop.bean.CartBean;
import bookshop.bean.CartDAO;
import bookshop.bean.MemberBean;
import bookshop.bean.MemberDAO;



public class _40_BuyForm implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String buyer = request.getParameter("buyer");
		
		List<CartBean> cartLists = null;
		List<String> accountLists = null;
		MemberBean member= null;
		int count = 0;

		//해당 buyer의 장바구니 목록의 수를 얻어냄
		CartDAO bookProcess = CartDAO.getInstance();
        count = bookProcess.getListCount(buyer);
		
		if(count > 0){//장바구니 목록이 있으면 수행
			//구매에 필요한 해당 buyer의 장바구니 목록을 얻어냄
			cartLists = bookProcess.getCart(buyer, count);
			request.setAttribute("cartLists", cartLists);
		}
		
		//구매에 필요한 buyer의 정보를 얻어냄
		MemberDAO memberProcess = MemberDAO.getInstance();
		member = memberProcess.getMember(buyer);
		
		//구매에 필요한 결제 계좌를 얻어냄
		BuyDAO buyProcess = BuyDAO.getInstance();
		accountLists = buyProcess.getAccount();
	
		request.setAttribute("member", member);
		request.setAttribute("accountLists", accountLists);
		request.setAttribute("type", new Integer(1));
		return "/40_buyForm.jsp";
	}
}
