package kr.co.ictedu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

import hongbapProject.attach.service.AttachDeleteService;
import hongbapProject.attach.service.AttachPagingService;
import hongbapProject.attach.service.AttachWriteService;
import hongbapProject.attach.service.IAttachService;
import hongbapProject.board.service.BoardDeleteService;
import hongbapProject.board.service.BoardDetailService;
import hongbapProject.board.service.BoardPagingService;
import hongbapProject.board.service.BoardUpdateService;
import hongbapProject.board.service.BoardWriteService;
import hongbapProject.board.service.IBoardService;
import hongbapProject.menu.service.IMenuService;
import hongbapProject.menu.service.MenuInsertService;
import hongbapProject.restaurant.service.IResService;
import hongbapProject.restaurant.service.ResByCategoryService;
import hongbapProject.restaurant.service.ResDeleteService;
import hongbapProject.restaurant.service.ResInfoService;
import hongbapProject.restaurant.service.ResInsertService;
import hongbapProject.restaurant.service.ResRandomService;
import hongbapProject.restaurant.service.ResUpdateService;
import kr.co.ictedu.service.IUserService;
import kr.co.ictedu.service.UserDeletService;
import kr.co.ictedu.service.UserInfoService;
import kr.co.ictedu.service.UserJoinService;
import kr.co.ictedu.service.UserLoginService;
import kr.co.ictedu.service.UserUpdateService;


/**
 * Servlet implementation class PatternServlet
 */

@WebServlet("*.do")
public class PatternServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatternServlet() { 
        super();
      
       
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doRequest(request, response);
	}
	
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		IUserService usv = null;
		IResService rsv = null;
		IBoardService bsv = null;
		IAttachService asv = null;
		IMenuService msv = null;
		
	
		String ui = null;
		
		
		HttpSession session=null;
		session = request.getSession();
		
		
		String uri = request.getRequestURI();
		System.out.println("uri : "+ uri);
		
		
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(uri.equals("/hongbapProject/join.do")) {
			usv= new UserJoinService();
			usv.execute(request, response);
			
			ui="/user/userLogin.jsp";
		}else if(uri.equals("/hongbapProject/logout.do")) {
			session.invalidate();
			ui = "/user/userLogin.jsp"; // 占쎈뼄占쎈뻻 筌욌뜄揆占쎈퉸癰귣똻�쁽. 
		
		} else if(uri.equals("/hongbapProject/login.do")) {
			usv = new UserLoginService();
			usv.execute(request, response);
			
			
			String result = (String)session.getAttribute("login");
			System.out.println("result : "+result);
					
			
			
			
			if(result!=null&&result.equals("fail")){
				session.invalidate();
				ui="/user/userLogin.jsp";
			} else {
				ui="/hongbapMain/hongbapMain.jsp";
			}
			
			} else if(uri.equals("/hongbapProject/user/userUpdate.do")) {
				usv = new UserUpdateService();
				usv.execute(request, response);
				ui = "/userinfo.do";
				
				
			} else if(uri.equals("/hongbapProject/user/userDelete.do")) {
				usv = new UserDeletService();
				usv.execute(request, response);
				session.invalidate();
				ui = "/user/userLogin.jsp";
				
			} else if(uri.equals("/hongbapProject/userinfo.do")) {
				usv = new UserInfoService();
				usv.execute(request, response);
				ui = "/user/userStatus.jsp";
				
				
			// user 컨트롤러 끝
		
				
		} else if(uri.equals("/hongbapProject/hongbapMain/resList.do")) {
				rsv = new ResByCategoryService();
				rsv.excute(request, response);
				
				// 레스토랑 상세 페이지에서 발급됐던 세션 지워주는 로직 필요
				session.removeAttribute("resId");
				ui="/res/resList.jsp";
			
				
				
		} else if(uri.equals("/hongbapProject/randompick.do")) {
				rsv = new ResRandomService();
				rsv.excute(request, response);
				ui = "/res/randomPick.jsp";
				
		
		} else if(uri.equals("/hongbapProject/res/resDetail.do")) {
				rsv = new ResInfoService();
				rsv.excute(request, response);
				
				asv = new AttachPagingService();
				asv.execute(request, response);
				
				ui = "/res/stroeMain.jsp";
				
		} else if(uri.contentEquals("/hongbapProject/resDelete.do")) {
				rsv = new ResDeleteService();
				rsv.excute(request, response);
				String resCategory=(String)session.getAttribute("resCategory");
				ui= "/hongbapMain/resList.do?resCategory="+resCategory;
		
		} else if(uri.contentEquals("/hongbapProject/resUpdate.do")) {
				rsv = new ResUpdateService();
				rsv.excute(request, response);
				ui = "/hongbapProject/res/resDetail.do";
		
		} else if(uri.contentEquals("/hongbapProject/resInsert.do")) {
				rsv = new ResInsertService();
				rsv.excute(request, response);
				ui="/hongbapMain/hongbapMain.jsp";
				
				
		// res 컨트롤러 끝	
		
		
		}else if(uri.contentEquals("/hongbapProject/res/menuInsert.do")) {
				msv = new MenuInsertService();
				msv.execute(request, response);
				String strResId = (String)request.getParameter("resId");
				
				if(strResId==null) {
					System.out.println("레스토랑ID(GET)받기 실패");
				}
				int resId = Integer.parseInt(strResId);
				request.setAttribute("resId", resId);
				
				ui = "/res/resDetail.do?resId="+resId+"";
				
		} else if(uri.contentEquals("/hongbapProject/res/attachWrite.do")) {
				asv = new AttachWriteService();
				asv.execute(request, response);
				
				String strResId = (String)request.getParameter("resId");
				
				if(strResId==null) {
					System.out.println("레스토랑ID 세션 받기 실패");
				}
				int resId = Integer.parseInt(strResId);
				request.setAttribute("resId", resId);
				
				ui = "/res/resDetail.do?resId="+resId+"";
				
				
		} else if(uri.contentEquals("/hongbapProject/res/attachDelete.do")) {
				asv = new AttachDeleteService();
				asv.execute(request, response);
				int resId = (Integer)session.getAttribute("resId");
				ui = "/res/resDetail.do?resId="+resId+"";
				
				
				
				
		// attach 컨트롤러 끝
				
		} else if(uri.equals("/hongbapProject/boardWrite.do")) {

			bsv = new BoardWriteService();
			bsv.execute(request, response);
			ui = "/board/boardSelect.do";

					
			
		} else if(uri.equals("/hongbapProject/boardUpdate.do")) {
			
			System.out.println("boardUpdate.do 들어왔니?");
			bsv = new BoardDetailService();
			bsv.execute(request, response);
			ui = "/board/boardUpdate.jsp";
			
		} else if(uri.equals("/hongbapProject/boardUpdateOk.do")) {
			System.out.println("boardUpdateOk 들어갔니?");
			
			bsv = new BoardUpdateService();
			bsv.execute(request, response);
			
			ui = "/boardDetail.do";
			
		} else if(uri.equals("/hongbapProject/board/boardDelete.do")) {
			
			bsv = new BoardDeleteService();
			bsv.execute(request, response);
			ui="/board/boardSelect.do";
			
			
		} else if(uri.equals("/hongbapProject/boardDetail.do")) {
			System.out.println("디테일 컨트롤러 진입");
			bsv = new BoardDetailService();
			bsv.execute(request, response);
			ui = "/board/boardDetail.jsp";
			
			
			
		} else if(uri.equals("/hongbapProject/board/boardSelect.do")) {
			
			bsv = new BoardPagingService();
			bsv.execute(request, response);
			ui = "/board/boardList.jsp";

			
			
		
		}else {
		
		}
		
		
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
		
	}
	
	

}
