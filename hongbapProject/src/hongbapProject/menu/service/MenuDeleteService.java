package hongbapProject.menu.service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hongbapProject.menu.model.MenuDAO;

public class MenuDeleteService implements IMenuService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = null;
		session = request.getSession();
		
		String strResId =(String)request.getAttribute("resId");
		
		if(strResId!=null) {
			int resId = Integer.parseInt(strResId);
			
			MenuDAO mdao =MenuDAO.getInstance();
			
			mdao.menuDelete(resId);
			
			System.out.println("메뉴 삭제 성공");
			
		}else {
			System.out.println("메뉴 삭제 실패");
		}
		
		
		
		
	
	}

}
