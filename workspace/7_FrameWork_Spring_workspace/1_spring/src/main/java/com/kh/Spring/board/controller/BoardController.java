package com.kh.Spring.board.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.kh.Spring.board.exception.BoardException;
import com.kh.Spring.board.model.service.BoardService;
import com.kh.Spring.board.model.vo.Board;
import com.kh.Spring.board.model.vo.PageInfo;
import com.kh.Spring.board.model.vo.Reply;
import com.kh.Spring.common.Pagination;
import com.kh.Spring.member.model.vo.Member;

@Controller
public class BoardController {

	
	@Autowired
	private BoardService bService;
	
	
	// 게시물 조회 + 페이지네이션
	@RequestMapping("blist.bo") // menubar.jsp의 게시판 버튼의 url주소
	public ModelAndView boardList(@RequestParam(value="page", required=false) Integer page, ModelAndView mv) {
		
		// 넘겨받은 데이터 중에 currentPage가 있으면 currentPage에 받아온 currentPage값을 넣어줘야함
		int currentPage = 1; // currentPage
		
		if(page != null ) { // page가 int라 null 못들어감. 기존 방법이랑 다르게 값 넘어온게 있는지 여부만 체크하고 싶은 상황. 기존 방법은 받아온 값 자체를 체크하는 방식 : if(request.getParameter("currentPage") != null )
		// string으로 받아오면 파싱을 해야되는게 귀찮. 래퍼클래스 Integer 사용하면 모두 해결됨 
			currentPage = page;
		}
		
		// 페이징처리1 :총게시물수 가져오기
		int listCount = bService.getListCount(); 
		// 계산에 필요한 2가지가 갖춰짐 : currentPage, listCount
		
		// 페이징처리2 : 필요한 게시판 가져오기
		// PageInfo와 Pagination이 필요한 이유 : 강의 11:07 
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		
		ArrayList<Board> list = bService.getBoardList(pi);
//		System.out.println(pi);
//		System.out.println(list); 항상 디버깅 찍어보기
		
		if(list != null) {
		// model과 ModelAndView 둘 중 하나 선택가능
			mv.addObject("list",list);
			mv.addObject("pi",pi);
			mv.setViewName("boardListView");
		}else {
			throw new BoardException("게시글 전체 조회에 실패했습니다");
		}
		return mv;
	}
	
	
/*********************************** 게시판 : 글쓰기 ***********************************/	
	
	// 게시판 글쓰기 뷰 불러오기
	@RequestMapping("binsertView.bo")
	public String boardInsertForm() {
		return "boardInsertForm";
	}
	
	
	// 게시판 글쓰기
	@RequestMapping("binsert.bo")
	public String insertBoard(@ModelAttribute Board b, @RequestParam("uploadFile") MultipartFile uploadFile, HttpServletRequest request) {
		// 리퀘스트파램에 받아오는 uploadFile속성은 첨부파일 name속성의 이름
		// 메소드에서 멀티파트파일을 사용할거긴한데, 필드로 올려야하는건 @Autowired 올리는게 맞는데
		// ...은 객체로 만들져서 들어오기 때문에 @Autowired 할 필요가 없는 것 강의3:24
		// 필드에 들어간다는건 객체가 들어간 상태...
//		System.out.println(b);
//		System.out.println(uploadFile);
		
		
		if(uploadFile != null && !uploadFile.isEmpty()) { // 미연의 사고방지를 위한 if조건문
			// jar파일 자체에 잘못이나 인터넷이 안좋다거나 하면 분명 null뜨는 경우가 생김. 만약의 상황의 대비한 if+null조건문 강의 3:31
			// 파일이 들어오면 저장하면 됨
			String renameFileName = saveFile(uploadFile, request); // 여기 request는 HttpServletRequest가 맞음
			
			b.setOriginalFileName(uploadFile.getOriginalFilename());
			b.setRenameFileName(renameFileName);
		}
		
		int result = bService.insertBoard(b);
		
		if(result > 0) {
			return "redirect:blist.bo";
		} else {
			throw new BoardException("게시글 등록에 실패하였습니다.");
		}
	}
	
	// 사용자 정의 메소드
	public String saveFile(MultipartFile file, HttpServletRequest request) { // HttpServletRequest으로 Request영역 호출
	
		// 파일 저장 구조 : 파일 저장소가 따로있고 실제로 파일이 저장되는 곳. 이름, 타입 등이 db에 저장되는거였음
		// 프로젝트파일의 저장소 위치 : webapp - resource - buploadFiles
		
		String root = request.getSession().getServletContext().getRealPath("resources"); // application영역으로 가는 코드. 어플영역은 웹앱(웹컨텐트) 아래를 말함
		// request.getSession().getServletContext().getRealPath("resources") -> webapp폴더 아래 resources폴더를 의미함
		// 서블릿컨텍스트까지가 webapp이고 겟리얼패스가 리소스까지 경로를 받아오는 것
		System.out.println("업로드파일 root:"+root);
		String savePath = root + "\\buploadFiles";

		// 업로드된 파일, 파일저장소에 저장
		File folder = new File(savePath);
		if(!folder.exists()) {
			folder.mkdirs(); // 저장할 폴더 생성
		}
		// 저장할 파일명을 변경해야함. 원래는 리네임 규약만들었으나 지금은 그렇게까지는 하지 않겠음. 수업에서
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		// 파일명 랜덤값 만들어서 겹치지 않게 해야하나 이번 수업 때는 생략. 필요하면 jspServlet쪽에 찾아보기를 
		String originFileName = file.getOriginalFilename();
		String renameFileName = sdf.format(new Date(System.currentTimeMillis())) + originFileName.substring(originFileName.lastIndexOf("."));
		
		System.out.println("originFileName = "+originFileName);
		System.out.println("renameFileName = "+renameFileName);
		
		String renamePath = folder + "\\" + renameFileName;
		
		try {
			// https://dev-gorany.tistory.com/123 : 멀티파일 관련 참조자료
			// 단일파일이 아닌 복수파일 업로드 내용포함
			file.transferTo(new File(renamePath)); // 새로만든 파일을 저정소에 저장 : .transferTo()
			// 겟오리지널파일네임을 사용하면 원래 가지고 있던 파일에 대한 본파일명을 가지고 있으나
			// 리네임된 것 만으로는 업로파일만으로는 못찾음. 세이브파일도 관여하기 때문에 
			// 리네임 파일 네임 컬럼에 넣어야하기 때문에 리네임파일네임을 반환시켜야함. 그래서 리턴타입을 str로 변경 강의 4:42 6.9
			
			// renameFileName 반환하는 이유 
			// saveFile 메소드에서 바뀐이름 파일 정의하고 있음. insertBoard에서 집어 넣게 되는 거니까
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return renameFileName;
	}
	
	
	
/************************************ 뷰 데이터  ************************************/	
	
	// 뷰로 데이터 넘기기 : Model & ModelAndView
	// Model은 데이터를 담는 것 : addAttribute
	// ModelAndView는 말 그래도 model과 view를 합쳐놓은 것이기 때문에 데이터도 담고 어느 뷰로 갈지도 넣어놓은 객체 : addObject,setViewName
	
	
//	뷰로 데이터 넘기기 : Model & ModelAndView
//
//		Model은 데이터를 담는 것
//		ModelAndView는 말 그래도 model과 view를 합쳐놓은 것이기 때문에 데이터도 담고 어느 뷰로 갈지도 넣어놓은 객체
//			 1)Model : addAttribute
//			 2)ModelAndView : addObject, setViewName
//
//	 뷰에서 데이터 받기 : @RequestParam & @ModelAttribute
//
//	 	1)@RequestParam
//	 	2)@ModelAttribute	
	
	
/************************************ 게시판 : 상세보기 ************************************/
	
//	// 게시판 상세보기 : 불러오기
//	@RequestMapping("bdetail.bo")
//	public String boardDetail(@RequestParam("bId") int bId,
//							  @RequestParam("page") String page, Model model) {
// 방법1:Model 방식								  
		// Model 사용 이유 : 뷰로 데이터 넘겨줄 때 model을 넘겨주는 방식으로 넘겨주기 위함
		// ModelAndView랑 Model 두개가 뷰로 데이터를 넘길 수 있음.
		// ModelAndView는 객체로 만들어서 보내고, 
		// 뷰의 이름도  넣어 줄 수 있고 마지막엔 mv에 데이터와 뷰 정보가 들어있어서 mv자체로 리턴해서 데이터와  페이지를 넘겨줄 수 있다는 점
		
		// 뷰로 데이터 넘기기 : Model & ModelAndView
		// Model은 데이터를 담는 것 : addAttribute
		// ModelAndView는 말 그래도 model과 view를 합쳐놓은 것이기 때문에 데이터도 담고 어느 뷰로 갈지도 넣어놓은 객체 : addObject,setViewName
		
		
//		Board b = new Board();
//		b.setBoardId(bId);
//		b = bService.boardDetail(b);
//		 
//		if(b !=null) {
//		     model.addAttribute("board",b);
//		     model.addAttribute("page",page);
//		}else {
//		    throw new BoardException("게시물 상세 조회에 실패하였습니다.");
//		}
//		
//		return "boardDetailView";
//	}
// 방법2:ModelAndView 방식	
//	@RequestMapping("bdetail.bo")
//    public ModelAndView selectBoard(@RequestParam("bId") int bId, ModelAndView mv) {
//       Board b = new Board();
//       b.setBoardId(bId);
//       
//       b = bService.selectBoard(b);
//       
//       if(b !=null) {
//          mv.addObject("board",b);
//          mv.setViewName("boardDetailView");
//       }else {
//          throw new BoardException("게시물 상세 조회에 실패하였습니다.");
//       }
//       return mv;
//    }
	
// 게시판 상세보기 
	// 강사님 모범답안
	// 모델 모델앤뷰 둘 다 괜찮. 여기서는 모델앤뷰로 진행
	@RequestMapping("bdetail.bo")
	public ModelAndView boardDetail (@RequestParam("bId") int bId, @RequestParam("page") int page, ModelAndView mv) {
		
		Board board = bService.selectBoard(bId);
		
		if(board != null) {
			mv.addObject("board",board).addObject("page",page).setViewName("boardDetailView");
		} else {
			throw new BoardException ("게시글 상세보기에 실패하였습니다.");
		}
		 return mv;
	}
	
	
	
/*************************************** 게시판 : 수정 + 파일 ***************************************/	
	
	
	@RequestMapping("bupView.bo")
	public String boardUpdateForm(@ModelAttribute Board b, @RequestParam("page") int page, Model model) {
		model.addAttribute("board", b).addAttribute("page", page);
		return "boardUpdateForm";
	}
	
	@RequestMapping("bupdate.bo") // boardUpdateForm.jsp에서 수정하기버튼의 url blist.bo
	public String updateBoard(@ModelAttribute Board b, @RequestParam("page") int page, // 페이지 보드아이디, 변경이름이니까 페이지, 보드
							  @RequestParam("reloadFile") MultipartFile reloadFile, 
							  HttpServletRequest request, Model model) { 	
		
		// <input type="file" value="???">
		// 파일이 실제 컴터 파일에 접근하는거라 보안상 value속성을 넣는 것을 막아두었기에 사용불가
		
		
		if(reloadFile != null && !reloadFile.isEmpty()) { // 조건문 의미 : reloadFile이 새로 업로드 파일이 존재한다면
			// 새로운 파일 업로드가 있으면 기존 파일이 필요할까? no
			// 새파일 업로드할 때는 기존 파일이 필요없다는 의미니 기존파일을 삭제해야함. 여기서 말하는 삭제는 webapp- resources - buploadFiles폴더에서 삭제한다는 의미
			
			if(b.getRenameFileName() != null) {
				deleteFile(b.getRenameFileName(),request); // 새롭게 파일을 집어넣을거면이라 기존파일 기존파일이 없는데 지울 필요가 없는 경우를 고려
			}
			// 강의 3:35 6.10
			String renameFileName = saveFile(reloadFile, request); 
			b.setOriginalFileName(reloadFile.getOriginalFilename());
			b.setRenameFileName(renameFileName);
				System.out.println(renameFileName);
				System.out.println(b);
				System.out.println(reloadFile);
				System.out.println(model);
		}
		
		int result = bService.updateBoard(b); 
		// 해당글이 보드랑 페이지 가지고 있었음
		if(result > 0) {
			//model.addAttribute("board", b)...;
			// 보드 보낼 필요없음. 화면 상세보기 페이지로 가기 때문에 상세보기 페이지로 가는 bdetail.bo 이용하면 됨
			//return "redirect:bdetail.bo?bId=" + b.getBoardId() + "&page=" + page;
			
			// 리다이렉트인데 데이터보존됨
			model.addAttribute("bId",b.getBoardId());
			model.addAttribute("page",page);
			return "redirect:bdetail.bo";
			
		} else {
			throw new BoardException("게시글 수정에 실패하였습니다.");
		}
	}
	// 위의 deleteFile() 메소드
	public void deleteFile(String fileName, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\buploadFiles";
		
		File f = new File(savePath + "\\" + fileName);
		if(f.exists()) { // 파일이 존재하는지 확인하고 삭제. 없는 파일삭제하라면 에러발생하기 때문
			f.delete();
		}
	}
	
	
	
/*************************************** 게시판 삭제 + 파일 ***************************************/	
	
	
	
	
	@RequestMapping("bdelete.bo")
	public String deleteBoard(@RequestParam("bId") int bId, 
							  @RequestParam("renameFileName") String renameFileName, HttpServletRequest request) {
		// boardDetailView
		// 어디서 접근해서 삭제할지도 지정해야하니 HttpServletRequest도 추가
	
		if(!renameFileName.equals("")) { // renameFileName이 비어있지 않다면
			deleteFile(renameFileName, request); // renameFileName을 넘겨준다, 어디서 삭제할 것인가:request
		}
		
		int result = bService.deleteBoard(bId);
		
		if(result > 0) {
			return "redirect:blist.bo";
		}else {
			throw new BoardException("회원 삭제에 실패하였습니다.");
		}
	}
	


	

/*********************************** 댓글  ***********************************/		
	
	
	// 댓글 쓰기 : insert
	// 댓글 저장에 성공했으면 success 반환, 실패했으면 에러 발생 : 댓글 등록에 실패하였습니다.
	// view에서 success를 반환받으면 댓글 등록 창에 적은 댓글은 지우기
//	@RequestMapping("addReply.bo")
//	public String addReply(@RequestParam("replyContent") String replyContent, 
//							@RequestParam("refBoardId") int refBoardId) {
//
//		Reply reply = new Reply();
//		reply.setReplyContent(replyContent);
//		reply.setRefBoardId(refBoardId);
//		
//		int result = bService.addReply(reply);
//		
//		if(result > 0) {
//			return "";
//		}else {
//			throw new BoardException("회원 삭제에 실패하였습니다.");
//		}
//		
//	}
	@RequestMapping("addReply.bo")
	@ResponseBody
	public String addReply(@ModelAttribute Reply r, HttpSession session) {
			// 누가 썼는지 알아야하기 때문에 모델어트리뷰트나 HttpSession을 통해서 가져올 수 있음
		String id = ((Member)session.getAttribute("loginUser")).getId(); // session영역에서 로그인 중인 유저의 id정보를 얻어서 vo Member타입으로 형변환
		r.setReplyWriter(id);
		
		int result = bService.insertReply(r);
		
		if(result > 0) {
			return "success";	// "success"를 str으로 넘기고 있기에 view이름이 아니라는걸 알려주기 위하여 @ResponseBody 어노테이션 필요
		}else {
			throw new BoardException("댓글 등록에 실패하였습니다.");
		}
	}
	
	// 댓글 가져오기 : 방법1 JSON 사용 
//	@RequestMapping(value="rList.bo", produces="application/json; charset=UTF-8")
//	@ResponseBody
//	public String getReplyList(@RequestParam("bId")int bId){
//		ArrayList<Reply> list = bService.selectReplyList (bId);
//		System.out.println("댓글가져오기 list : "+ list);
//		
//		
//		// 
//		JSONArray jArr = new JSONArray();
//		// 제이슨 어레이에 제이슨오브젝트가 담길 것임
//		for(Reply r : list) {
//			JSONObject job = new JSONObject();
//			job.put("replyId", r.getReplyId());
//			job.put("replyContent", r.getReplyContent());
//			job.put("replyWriter", r.getReplyWriter());
//			job.put("nickName", r.getNickName());
//			job.put("replyCreateDate", r.getReplyCreateDate());
//			job.put("replyModifyDate", r.getReplyModifyDate());
//			job.put("replyStatus", r.getReplyStatus());
//			
//			jArr.put(job);
//			
//		}
//		
//		// @ResponseBody 필요
//		// 이유 : 리턴이 스트링인데 뷰리졸버가 뷰파일로 바꺼요
//		// 뷰리졸버에게 뷰에대한 경로를 넘기지 않고 데이터로 담아서 보낼 수 있게 인지시켜야함
//
//		return jArr.toString();
//	}
	
	// 댓글 가져오기 : 방법2 GSON 사용 
	@RequestMapping("rList.bo")
	public void getReplyList(@RequestParam("bId")int bId, HttpServletResponse response){
		ArrayList<Reply> list = bService.selectReplyList (bId);
		System.out.println("댓글가져오기 list : "+ list);
		
		response.setContentType("application/json; charset=UTF-8");
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		try {
			gson.toJson (list, response.getWriter());
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	

/*********************************************** Top-N 분석  * @return ***********************************************/			
	
	
	// Top-N 분석 : select
//////////////////// 방법1 : JSON ////////////////////////////////////////////////////
//	@RequestMapping(value="topList.bo", produces="application/json; charset=UTF-8")
//	@ResponseBody
//	public String topList() {
//		ArrayList<Board> list =	bService.topList();
//		
//		// 웹페이지첨부파일 부분을 뷰에 보낼 것
//		JSONArray jArr = new JSONArray();
//		// 제이슨 어레이에 제이슨오브젝트가 담길 것임
//		for(Board b : list) {
//			JSONObject job = new JSONObject();
//			job.put("boardId",b.getBoardId());
//			job.put("boardTitle", b.getBoardTitle());
//			job.put("boardContent", b.getBoardContent());
//			job.put("nickName", b.getNickName());
//			job.put("boardModifyDate", b.getBoardModifyDate());
//			job.put("boardCount", b.getBoardCount());
//			job.put("originalFileName", b.getOriginalFileName());
//			
//			jArr.put(job);
//		}
//		return jArr.toString(); // 이렇게 리턴하면 뷰이름으로 인식하니 메소드 서두에 @ResponseBody 어노테이션을 넣어줘야함
//		
//		
////////////////////방법2 : GSON ////////////////////////////////////////////////////
		
	@RequestMapping("topList.bo")
	public void topList(HttpServletResponse response) {
		ArrayList<Board> list =	bService.topList();	
		
		System.out.println(list);
		
		response.setContentType("application/json; charset=UTF-8");
		try {
			new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(list, response.getWriter());
			
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}







