package hongbapProject.restaurant.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hongbapProject.restaurant.model.ResDAO;
import hongbapProject.restaurant.model.ResDTO;
import hongbapProject.restaurant.model.ResVO;

public class ResByCategoryService implements IResService {
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = null;
		session=request.getSession();
		
		String resCategory = request.getParameter("resCategory");
		System.out.println("resCategory 값 : "+resCategory);
		String strPage = request.getParameter("page");
		System.out.println("strPage값 : "+strPage);
		int page = 1;
		if(strPage != null) {
			page = Integer.parseInt(strPage);
		}
		
		ResDAO dao = ResDAO.getInstance();
		
		List<ResVO> ResList = dao.getAllResByCategory(resCategory , (page-1) * 10);
		
		System.out.println("ResList값" + ResList);
		int countNum = dao.getResCount(resCategory);
		
		ResDTO ResDTO = new ResDTO(countNum, page, ResList);
		
		request.setAttribute("ResList", ResList);
		request.setAttribute("ResDTO", ResDTO);
		request.setAttribute("resCategory", resCategory);
		
		session.setAttribute("resCategory", resCategory);
		
	}

}