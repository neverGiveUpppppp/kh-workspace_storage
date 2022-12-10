package com.fpj.trendeater.board.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fpj.trendeater.admin.model.vo.Admin;
import com.fpj.trendeater.board.exception.BoardException;
import com.fpj.trendeater.board.model.service.BoardService;
import com.fpj.trendeater.board.model.vo.Board;
import com.fpj.trendeater.board.model.vo.BoardQnA;
import com.fpj.trendeater.board.model.vo.PageInfo;
import com.fpj.trendeater.common.Pagination;
import com.fpj.trendeater.member.model.vo.Member;

@Controller
public class BoardController {

	@Autowired
	private BoardService bService;

/********************************** Notice(공지사항) : 조회 *************************************/

	// Notice 공지사항 조회 + 페이지네이션
	@RequestMapping("noticeList.bo") 
	public ModelAndView boardList(@RequestParam(value = "page", required = false) Integer page, ModelAndView mv) {

		// 넘겨받은 데이터 중에 currentPage가 있으면 currentPage에 받아온 currentPage값을 넣어줘야함
		int currentPage = 1; // currentPage

		if (page != null) { // page가 int라 null 못들어감. 기존 방법이랑 다르게 값 넘어온게 있는지 여부만 체크하고 싶은 상황. 기존 방법은 받아온 값 자체를
							// 체크하는 방식 : if(request.getParameter("currentPage") != null )
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
		System.out.println("pi=" + pi);
		System.out.println("list=" + list); // 항상 디버깅 찍어보기

		if (list != null) {
			// model과 ModelAndView 둘 중 하나 선택가능
			mv.addObject("list", list);
			mv.addObject("pi", pi);
			mv.setViewName("boardNoticeList");
		} else {
			throw new BoardException("게시글 전체 조회에 실패했습니다");
		}
		return mv;
	}
	
/********************************** Notice(공지사항) : 쓰기  *************************************/	
	// Notice 쓰기 by admin 
	@RequestMapping("noticeWriteView.bo")
	public String noticeWriteForm() {
		return "noticeWriteForm";
	}
	@RequestMapping("noticeWriteForm.bo")
	public String insertNotice(@ModelAttribute Board b) {

		int result = bService.insertNotice(b);
 
		if (result > 0) {
			return "redirect:noticeList.bo"; // 관리자 게시판으로 돌아가야함!
		} else {
			throw new BoardException("공지사항 등록에 실패하였습니다.");
		}
	}

	
/********************************** Notice(공지사항) : 수정  *************************************/	
	// Notice 수정
	@RequestMapping(value="noticeUpdate.bo", method=RequestMethod.GET)
	public String noticeUpdateForm() {
		return "noticeUpdateForm";
	}
	
	@RequestMapping(value="noticeUpdate.bo", method = RequestMethod.POST) 
	public String updateNotice(@ModelAttribute Board b, @RequestParam("page") int page,
									HttpSession session) {  
		
		String id = ((Admin)session.getAttribute("loginUser")).getId();
		b.setAdminId(id);
		
		int result = bService.updateNotice(b); 

		if(result > 0) {
			//model.addAttribute("board", b)...;
			// 보드 보낼 필요없음. 화면 상세보기 페이지로 가기 때문에 상세보기 페이지로 가는 bdetail.bo 이용하면 됨
			//return "redirect:bdetail.bo?bId=" + b.getBoardId() + "&page=" + page;
			
			// 리다이렉트인데 데이터보존됨
//			model.addAttribute("bId",b.getBoardId());
//			model.addAttribute("page",page);
			return "redirect:boardQna.bo";
			
		} else {
			throw new BoardException("공지사항 수정에 실패하였습니다.");
		}
	}
	
	
	
/********************************** Notice(공지사항) : 삭제  *************************************/	
	// Notice 삭제
	@RequestMapping(value="noticeDelete.bo", method=RequestMethod.POST)
	public String deleteNotice(@ModelAttribute Board b, HttpSession session) {  
			
		
		String id = ((Member)session.getAttribute("loginUser")).getEmail();
		b.setAdminId(id);
		
		int result = bService.deleteNotice(b);
		
		if(result > 0) {
			return "redirect:boardQna.bo";	// 관리자 게시판으로 돌아가야함!
		}else {
			throw new BoardException("공지사항 삭제에 실패하였습니다.");
		}
	}
	
	
	
	
	
/*********************************** Notice(공지사항) : 상세보기 **************************************************/

	@RequestMapping("noticeDetail.bo")
	public ModelAndView boardDetail(@RequestParam("bId") int bId, @RequestParam("page") int page, ModelAndView mv) {

		Board board = bService.selectBoard(bId);
		
		System.out.println("board="+board);
		
		if (board != null) {
			mv.addObject("board", board).addObject("page", page).setViewName("boardDetailView");
		} else {
			throw new BoardException("게시글 상세보기에 실패하였습니다.");
		}
		return mv;
	}

	
	

/********************************************** QnA : 조회  *******************************************************/
	// QnA : 조회 
	@RequestMapping("boardQna.bo")
	public ModelAndView qnaList(@RequestParam(value = "page", required = false) Integer page, ModelAndView mv) {

		int currentPage = 1;

		if (page != null) {
			currentPage = page;
		}

		// 페이징처리1 :총게시물수 가져오기
		int listCount = bService.getQnaListCount();
		// 페이징처리2 : 필요한 게시판 가져오기
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);

		ArrayList<BoardQnA> list = bService.getBoardQnaList(pi);
		System.out.println("pi=" + pi);
		System.out.println("list=" + list); // 항상 디버깅 찍어보기

		if (list != null) {
			mv.addObject("list", list);
			mv.addObject("pi", pi);
			mv.setViewName("boardQna");
		} else {
			throw new BoardException("문의사항 전체 조회에 실패했습니다");
		}
		return mv;
	}

/********************************************** QnA : 쓰기  *******************************************************/

	// QnA : 쓰기
	@RequestMapping("boardQnaWriteView.bo")
	public String boardQnaWriteForm() {
		return "boardQnaWriteForm";
	}
	
	@RequestMapping("boardQnaWriteForm.bo")
	public String insertBoardQna(@ModelAttribute BoardQnA b) {

		System.out.println(b);
//		  b.setQnaTitle("qnaTitle"); 
//		  b.setQnaContent("qnaContent"); 세터를 따로 지정해서 값을 주었기 때문에 저 값이 저장된것
//		  파람은 단일, 모델어트리뷰트는 복수 저장할 때 사용.
//		  모델어트리뷰트는 뷰의 파라미터값과 vo클래스의 필드명(정확히는 세터명)이 같은 것을 매핑함.
//		 @ModelAttribute BoardQnA b로 받아오면서 뷰의 name속성 파라미터랑 vo 클래스의 필드명(세터명)이랑 같아서 
//		  자연스럽게 받아올 수 있었지만 세터를 새로 지정하고 거기에 "qnaTitle" 스트링값을 새로 주었기 때문에 저값이 db에 저장된 것

		int result = bService.insertBoardQna(b);
		System.out.println(result);
 
		if (result > 0) {
			return "redirect:boardQna.bo";
		} else {
			throw new BoardException("문의사항 등록에 실패하였습니다.");
		}
	}
	
	
/********************************************** QnA : 수정  *******************************************************/
	
	// QnA : 수정
	@RequestMapping("boardQnaUpdateView.bo")
	public String boardUpdateForm() {
		return "boardQnaUpdateForm";
	}
	
	@RequestMapping("boardQnaUpdateForm.bo") 
	public String updateBoardQna(@ModelAttribute BoardQnA b, @RequestParam("page") int page,
									HttpSession session) {  
		
		String id = ((Member)session.getAttribute("loginUser")).getEmail();
		b.setEmailId(id);
		
		int result = bService.updateBoardQna(b); 

		if(result > 0) {
			//model.addAttribute("board", b)...;
			// 보드 보낼 필요없음. 화면 상세보기 페이지로 가기 때문에 상세보기 페이지로 가는 bdetail.bo 이용하면 됨
			//return "redirect:bdetail.bo?bId=" + b.getBoardId() + "&page=" + page;
			
			// 리다이렉트인데 데이터보존됨
//			model.addAttribute("bId",b.getBoardId());
//			model.addAttribute("page",page);
			return "redirect:boardQna.bo";
			
		} else {
			throw new BoardException("문의사항 수정에 실패하였습니다.");
		}
	}
	
	
/********************************************** QnA : 삭제  *******************************************************/
	
	// QnA : 삭제
	@RequestMapping("boardQnaDeleteForm.bo")
	public String deleteBoard(@ModelAttribute BoardQnA b, HttpSession session) {  
			
		
		String id = ((Member)session.getAttribute("loginUser")).getEmail();
		b.setEmailId(id);
		
		int result = bService.deleteBoardQna(b);
		
		if(result > 0) {
			return "redirect:boardQna.bo";
		}else {
			throw new BoardException("QnA 삭제에 실패하였습니다.");
		}
	}
	
	
	
	
	

	/*********************************** 댓글 ***********************************/

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
//	@RequestMapping("addReply.bo")
//	@ResponseBody
//	public String addReply(@ModelAttribute Reply r, HttpSession session) {
//			// 누가 썼는지 알아야하기 때문에 모델어트리뷰트나 HttpSession을 통해서 가져올 수 있음
//		String id = ((Member)session.getAttribute("loginUser")).getId(); // session영역에서 로그인 중인 유저의 id정보를 얻어서 vo Member타입으로 형변환
//		r.setReplyWriter(id);
//		
//		int result = bService.insertReply(r);
//		
//		if(result > 0) {
//			return "success";	// "success"를 str으로 넘기고 있기에 view이름이 아니라는걸 알려주기 위하여 @ResponseBody 어노테이션 필요
//		}else {
//			throw new BoardException("댓글 등록에 실패하였습니다.");
//		}
//	}
//	
//	// 댓글 가져오기 : 방법1 JSON 사용 
////	@RequestMapping(value="rList.bo", produces="application/json; charset=UTF-8")
////	@ResponseBody
////	public String getReplyList(@RequestParam("bId")int bId){
////		ArrayList<Reply> list = bService.selectReplyList (bId);
////		System.out.println("댓글가져오기 list : "+ list);
////		
////		
////		// 
////		JSONArray jArr = new JSONArray();
////		// 제이슨 어레이에 제이슨오브젝트가 담길 것임
////		for(Reply r : list) {
////			JSONObject job = new JSONObject();
////			job.put("replyId", r.getReplyId());
////			job.put("replyContent", r.getReplyContent());
////			job.put("replyWriter", r.getReplyWriter());
////			job.put("nickName", r.getNickName());
////			job.put("replyCreateDate", r.getReplyCreateDate());
////			job.put("replyModifyDate", r.getReplyModifyDate());
////			job.put("replyStatus", r.getReplyStatus());
////			
////			jArr.put(job);
////			
////		}
////		
////		// @ResponseBody 필요
////		// 이유 : 리턴이 스트링인데 뷰리졸버가 뷰파일로 바꺼요
////		// 뷰리졸버에게 뷰에대한 경로를 넘기지 않고 데이터로 담아서 보낼 수 있게 인지시켜야함
////
////		return jArr.toString();
////	}
//	
//	// 댓글 가져오기 : 방법2 GSON 사용 
//	@RequestMapping("rList.bo")
//	public void getReplyList(@RequestParam("bId")int bId, HttpServletResponse response){
//		ArrayList<Reply> list = bService.selectReplyList (bId);
//		System.out.println("댓글가져오기 list : "+ list);
//		
//		response.setContentType("application/json; charset=UTF-8");
//		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
//		try {
//			gson.toJson (list, response.getWriter());
//		} catch (JsonIOException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	
//	
//	

}
