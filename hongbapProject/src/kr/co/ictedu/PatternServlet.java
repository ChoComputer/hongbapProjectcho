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
// *.do 嚥∽옙 占쎌삜占쎌뿺 占쎈솭占쎄쉘占쏙옙 .do嚥∽옙 占쎄국占쎄돌占쎈뮉 占쎌젔占쎈꺗雅뚯눘�꺖�몴占� 筌뤴뫀紐� 占쎌삜占쎈툡占쎌긿占쎈빍占쎈뼄. 
// 占쎌넇占쎌삢占쎌쁽 占쎈솭占쎄쉘占쏙옙 /�몴占� �뜮�눊�� 占쎌삂占쎄쉐占쎈�占쎈빍占쎈뼄. 
@WebServlet("*.do")
public class PatternServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatternServlet() { 
        super();
      
        // TODO Auto-generated constructor stub
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
	
	// 筌띾슣鍮� 占쎌뒄筌ｏ옙 筌롫뗄苑뚳옙諭�(get, post) 占쎄맒�꽴占� 占쎈씨占쎌뵠 筌ｌ꼶�봺占쎈릭野껓옙 筌띾슢諭얏�⑨옙 占쎈뼟占쎈뼄筌롳옙
	// 筌롫뗄苑뚳옙諭� 占쎈릭占쎄돌�몴占� 占쎈쐭 筌띾슢諭억옙堉깍옙苑� 占쎌뒄筌ｏ옙占쎈립占쎈뼄. 
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// 占쎄퐣�뜮袁⑸뮞 占쎌깈�빊�뮇�뱽 占쎌맄占쎈퉸 筌뤴뫀諭� 占쎄퐣�뜮袁⑸뮞占쎌쁽�뙴�슦�굨占쎌뱽 獄쏆룇�뱽 占쎈땾 占쎌뿳占쎈뮉
		// 占쎌뵥占쎄숲占쎈읂占쎌뵠占쎈뮞�몴占� 占쎄문占쎄쉐占쎈�占쎈빍占쎈뼄.
		//IBoardService sv = null;
		IUserService usv = null;
		IResService rsv = null;
		IBoardService bsv = null;
		IAttachService asv = null;
		
		// 占쎈퉸占쎈뼣 嚥≪뮇彛낉옙�뱽 占쎈뼄占쎈뻬占쎈립 占쎈츟占쎈퓠 占쎄퐜占쎈선揶쏉옙 .jsp 占쎈솁占쎌뵬 筌뤿굞臾�/野껋럥以� 筌욑옙占쎌젟
		String ui = null;
		
		// doGet占쎈퓠 占쎌뿳占쎈쐲 筌뤴뫀諭� �굜遺얜굡�몴占� 揶쏉옙占쎌죬占쎌긿占쎈빍占쎈뼄.
		// 占쎄쉭占쎈�� 占쎈쾺占쎈뮉 甕곤옙(占쎄쉭占쎈�� 占쎄땀占쎌삢揶쏆빘猿쒐몴占� 占쎈뮞占쎄쾿�뵳���뱜�뵳�슦肉됵옙苑뚳옙�뮉 獄쏅뗀以� session筌뤿굞臾띰옙�몵嚥∽옙
		// 占쎈쿈 占쎈땾 占쎌뿳占쎈�占쎈뮉占쎈쑓 占쎄퐣�뜮袁⑸뮞占쎄돌 �뚢뫂�뱜嚥▲끇�쑎占쎈뮉 占쎌쁽獄쏉옙 �굜遺얜굡占쎌뵬占쎄퐣 占쎄문占쎄쉐占쎌뵠 占쎈툧 占쎈┷占쎈선 占쎌뿳占쎈선占쎄퐣
		// 占쎄쉭占쎈�∽옙�뵠占쎌뵬占쎈뮉 占쎄땀占쎌삢揶쏆빘猿쒐몴占� 占쎈쾺疫뀐옙 占쎌맄占쎈퉸 占쎄퐨占쎈섧占쎈릭�⑨옙 占쎈섯占쎈선占쎌궎占쎈뮉野껉낮�빍占쎈뼄.)
		HttpSession session=null;
		session = request.getSession();
		
		// 占쎌넇占쎌삢占쎌쁽 占쎈솭占쎄쉘占쎈퓠占쎄퐣 占쎌넇占쎌삢占쎌쁽�몴占� 占쎈７占쎈맙占쎈립 雅뚯눘�꺖揶쏅�れ뱽 揶쏉옙占쎌죬占쎌궎疫뀐옙 占쎌맄占쎈퉸占쎄퐣
		// 占쎈툡占쎌삋 �굜遺얜굡�몴占� 占쎄텢占쎌뒠占쎈�占쎈빍占쎈뼄.
		// 嚥≪뮇類꾬옙�깈占쎈뮞占쎈뱜 8181 占쎈츟占쎌벥 uri 占쎈솭占쎄쉘占쎌뱽 占쎌삜占쎈툡占쎌궎占쎈뮉 筌롫뗄苑뚳옙諭�!
		String uri = request.getRequestURI();
		System.out.println("uri : "+ uri);
		
		
		// �굜�꼷�꼧占쎌뵠 占쎈툡占쎈빒 占쎄텢占쎌뒠占쎌쁽揶쏉옙 占쎌넇占쎌뵥占쎈막 占쎈땾 占쎌뿳占쎈즲嚥∽옙 .jsp 占쎌넅筌롫똻肉�
		// 癰귨옙占쎈땾占쎈퓠 占쎈뼖疫뀐옙 占쎌쁽�뙴�슢占쏙옙 筌〓씭�뮉 out.print(); 占쎄텢占쎌뒠占쎌뱽 占쎌맄占쎈립
		// 占쎄텢占쎌읈 餓ο옙�뜮占�
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// jsp 占쎈솁占쎌뵬占쎌뵠 html 占쎌굨占쎈뻼占쎌몵嚥∽옙 占쎌뵠�뙴�뫁堉깍옙議� 占쎌뿳占쎌벉占쎌뱽 占쎈르占쎌젻雅뚯눖�뮉 �굜遺얜굡
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
			//占쎄쉭占쎈�∽옙肉됵옙苑� 嚥≪뮄�젃占쎌뵥 占쎈연�겫占� 占쎌넇占쎌뵥
			
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
				
			//野껊슣�뻻占쎈솇
		} else if(uri.equals("/hongbapProject/res/resDetail.do")) {
				rsv = new ResInfoService();
				rsv.excute(request, response);
				
				asv = new AttachPagingService();
				asv.execute(request, response);
				
				ui = "/res/stroeMain.jsp";
				
		} else if(uri.contentEquals("/hongbapProject/resDelete.do")) {
				rsv = new ResDeleteService();
				rsv.excute(request, response);
				ui= "/hongbapProject/hongbapMain/resList.do";
		
		} else if(uri.contentEquals("/hongbapProject/resUpdate.do")) {
				rsv = new ResUpdateService();
				rsv.excute(request, response);
				ui = "/hongbapProject/res/resDetail.do";
		
		} else if(uri.contentEquals("/hongbapProject/resInsert.do")) {
				rsv = new ResInsertService();
				rsv.excute(request, response);
				ui="/hongbapMain/hongbapMain.jsp";
				
				
		// res 컨트롤러 끝	
		
		
				
				
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
				
				
		} else if(uri.contentEquals("/hongbapProject/attachDelete.do")) {
				asv = new AttachDeleteService();
				asv.execute(request, response);
				ui = "/hongbapProject/res/resDetail.do";
				
				
				
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
		
		// 占쎈７占쎌뜖占쎈굡 嚥≪뮇彛낉옙占� 鈺곌퀗援붻눧紐꾩뵠 筌뤴뫀紐� 占쎌삂占쎈짗占쎈립 占쎈츟占쎈퓠 占쎈뼄占쎈뻬占쎈�占쎈빍占쎈뼄.
		// RequestDispatcher�몴占� 占쎄텢占쎌뒠占쎈퉸 占쎈７占쎌뜖占쎈뎃占쎌뱽 占쎈릭筌롳옙
		// request, response�몴占� jsp占쎈읂占쎌뵠筌욑옙占쎈퓠 占쎌읈占쎈뼎占쎈막 占쎈땾 占쎌뿳占쎈뮸占쎈빍占쎈뼄.
		// 筌뤴뫀�쑞 2獄쎻뫗�뻼占쏙옙 占쎈뮞占쎄쾿�뵳���뱜�뵳�슦�뱽 占쎈쾺筌욑옙 占쎈륫疫뀐옙 占쎈르�눧紐꾨퓠
		// �뚢뫂�뱜嚥▲끇�쑎占쎈뼊占쎈퓠占쎄퐣 �빊�뮆�젾占쎈퓠 占쎈툡占쎌뒄占쎈립 占쎈쑓占쎌뵠占쎄숲�몴占� 獄쏆룇釉섓옙�꽘占쎈뼄
		// 占쎈７占쎌뜖占쎈굡嚥∽옙 .jsp占쎈퓠 占쎌읈占쎈뼎占쎈�占쎈빍占쎈뼄.
		
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
		
	}
	
	

}
