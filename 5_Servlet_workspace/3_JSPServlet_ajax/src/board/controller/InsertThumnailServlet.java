package board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.model.service.BoardService;
import board.model.vo.Attachment;
import board.model.vo.Board;
import common.MyFileRenamePolicy;
import member.model.vo.Member;

/**
 * Servlet implementation class InsertThumnailServlet
 */
@WebServlet("/insert.th")
public class InsertThumnailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertThumnailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
//		String title = request.getParameter("title");
		
//		System.out.println(title); // null 
		// encType="multipart/form-data” 인코딩 타입 추가
		// 인코딩 타입 지정하면 getParameter 사용불가 -> null값 발생 		
		// 	   해결 : MultipartRequest 객체
	
		// 파일 전송 요청(request)된게 있다면 if문 실행
		if(ServletFileUpload.isMultipartContent(request)) { // multipart/form-data로 전송됐는지 확인 // 내가 지금 넘어온게 멀티파트 폼데이터로 넘어왔는지 물어보는 것
			// MultipartRequest 사용법
			// 		MultipartRequest multiRequest = new MultipartRequest();
			// 사진 파일에 들어오는거에 대해 리퀘스트를 사용하는 개념
			// 
			// 매개변수 
			// 1번째 어떤 리퀘스트를 쓰는지
			// 2번째 파일 경로
			// 3번째 매개변수 받을 수 있는 최대 파일 크기, 
			// 4번째 인코딩 타입
			// 5번째 파일명 변환규칙 
			// MultipartRequest multiRequest = new MultipartRequest(HttpServletRequest, 파일저장소 경로, 파일 최대 크기, 인코딩 타입, 파일명 변환규칙);
			//		파일명 변환 규칙에 사용되는  기본 클래스 : DefaultFileRenamePolicy  - 이미 있는거 쓰겠다하면 얘를 쓰면됨
			// 			같은 이름의 파일이 존재하면 파일명 뒤에 숫자 붙임.  ex)aaa.png, aaa1.png, aaa2.png
			// 수업에서는 직접 만들어서 써볼 예정
			
			
			// 사진파일 최대 사이즈 지정
			int maxSize = 1024*1024*10; // 10Mbyte
			String root = request.getSession().getServletContext().getRealPath("/");  // getServletContext 애플리케이션 영역 // getRealPath("/") : WebContent 아래를 의미
			String savePath = root + "thumbnail_uploadFiles/";
			
			// 저장할 폴더 생성
			File f = new File(savePath);
			if(!f.exists()) { // File f가 존재하지 않으면
				f.mkdirs();	  // 폴더 생성
			}
			// 폴더 생성 안됐다. why?
			// getRealPath("/")하면 Webcontent를 가리킨다고 했는데 .. 2:27 강의
			
//			System.out.println("savePath="+savePath); // 웹페이지에서 로그인하고 글제목쓰고 작성완료 누르면 콘솔에 아래의 경로 뜸
			// D:\Dropbox\Developer\workspace\5_Servlet_workspace\3_JSPServlet\WebContent\thumbnail_uploadFiles/
			// 퍼블리싱 : 메타데이터 안에서  컴퓨터가 인지하기 좋은 경로를 찾아가는 것
			// 컴퓨터가 자기가 알아서 경로를 바꿔주는 것을 퍼블리싱이라고 함. 퍼블리싱이 경로가 바뀌는건 맞음.  
			// 재탐색이랑 좀 다름. 컴퓨터가 보는 입장에서 쓰는 기능. 빌드도 하고 서버 관여가 들어간다거나 컴퓨터가 인지하기 좋은 곳으로 ...
			// 경로 자체가 복잡하고 개발자가 지정한 경로가 아니다보니 개발에 좀 번거로움 -> 퍼블리싱 없이 모듈을 사용하겠다는게 서버옵션 체크의 serve modules without publishing
			
			// MultipartRequest 클래스의 매개변수 : 파일명 변환규칙 방법 2가지
			// 방법1 : DefaultFileRenamePolicy
//			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy()); // import 안됨. 자체 내장 클래스가 아니기에 cors 라이브러리(jars)가 있어야함
			// 	  new DefaultFileRenamePolicy() 하면 디폴트 규칙을 사용하겠다는 의미
			// 	  DefaultFileRenamePolicy() : cos 라이브러리 클래스
			// 방법2 : 사용자 정의 리네임 클래스
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy()); //
			// 위 코드에서 파일 가져옴. 파일명은 아직
			
			
			String title = multiRequest.getParameter("title");
//			System.out.println("title="+title);
			String content =  multiRequest.getParameter("content");
			String writer =  ((Member)request.getSession().getAttribute("loginUser")).getUserId();
			
			
			
			// 사진 가져오기
			ArrayList<String> saveFiles = new ArrayList<String>();	 // 변경된 파일명을 저장할 ArrayList
			ArrayList<String> originFiles = new ArrayList<String>(); // 본래 파일명을 저장할 ArrayList
			
			Enumeration<String> files = multiRequest.getFileNames(); // // getFileNames()의 반환타입 :Enumeration // Enumeration, Iterator의 구버젼. Iterator의 업글버젼이 ListIterator
//			System.out.println(files); // java.util.Hashtable$Enumerator@22b346d 
			// 해쉬 주소값이 나오는데 안에 값을 보기 위해 while문 사용
			while(files.hasMoreElements()) { // 엘리먼트가 더 있다면
//				System.out.println(files.nextElement()); // thumbnailImg4,3,2,1 뜸 <- thumbnailWriteForm의  폼에서 name값들

				// ... 제네릭 설정 강의 4:36
				String name = files.nextElement(); // 전송 순서 역순
				
				if(multiRequest.getFilesystemName(name) != null ) {
//					System.out.println(multiRequest.getFilesystemName(name));	// 2022050916414376024975.png // 변경된 파일명
//					System.out.println(multiRequest.getOriginalFileName(name)); // 11.png					  // 원본 파일명
				// getFilesystemName() : 변경된 파일명 
				// getOriginalFileName() : 원본 파일명 
				// 위의 둘로 값을 받아서 ArrayList<String> saveFiles,originFiles 변수에 저장
						
					saveFiles.add(multiRequest.getFilesystemName(name));	// 복수파일이면 역순으로 저장됨
					originFiles.add(multiRequest.getOriginalFileName(name));
				
				}
				
			}
			// 잘 저장됐는지 확인
			// nextElement()가 전송 순서 역순으로 가져오니 기억
			System.out.println("insertServlet saveFiles : " + saveFiles);	// [2022050916464463036466.png, 2022050916464462218341.jpg]
			System.out.println("insertServlet originFiles : " + originFiles);// [flower3.PNG, flower2.PNG, flower1.PNG]
			
			Board b = new Board();
			b.setBoardContent(content);
			b.setBoardTitle(title);
			b.setBoardWriter(writer);
			b.setBoardType(2);
			b.setCategory("10"); // insertBoard 쿼리문 그대로 사용할거라 쿼리문에 null이 나지 않게 임의값을 넣어줌
			// 파일은 역순으로 들어가있는 걸 기억해둘 것
			
			ArrayList<Attachment> fileList = new ArrayList<>();
			for(int i = originFiles.size() -1; i >= 0; i--) { // 파일이 역순이라 for문도 역순으로 
				Attachment a = new Attachment();
				a.setFilePath(savePath);
				a.setOriginName(originFiles.get(i));
				a.setChangeName(saveFiles.get(i));
				
				// 거꾸로 들어가 있기에
				if(i == originFiles.size()-1) { // originFiles 사이즈보다 1이 작은 것 만큼의 숫자랑 인덱스랑 같다면
					a.setFileLevel(0); // 썸네일
				}else {
					a.setFileLevel(1); // 내용 사진
				}
				
				fileList.add(a);
			}
			
			System.out.println("insertServlet fileList : " + fileList);
			
			// db로 보내기
			int result = new BoardService().insertFile(b,fileList);
			
			if(result == fileList.size() + 1) { // +1이 들어가있는 이유 : 보드도 제대로 전제하에 +1 반환할테니 ... 강의 5:24
				response.sendRedirect("list.th");
			}else {
				request.setAttribute("msg", "사진 게시판 조회에 실패했습니다");
				request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);

				// 실패하면 파일 작동 삭제 되게끔 for문
				for (int i = 0; i < saveFiles.size(); i++) {
					File failFile = new File(savePath + saveFiles.get(i));
					failFile.delete();
				}
				
				
			
			}
				
		}
		
	
	}
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
