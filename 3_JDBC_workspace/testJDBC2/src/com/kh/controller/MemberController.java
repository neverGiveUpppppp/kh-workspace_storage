package com.kh.controller;


import java.util.ArrayList;

import com.kh.model.DAO.MemberDAO;
import com.kh.model.service.MemberService;
import com.kh.model.vo.Member;
import com.kh.view.MemberMenu;

public class MemberController {
	private MemberMenu menu = new MemberMenu();
	private MemberDAO dao = new MemberDAO();
	private MemberService mService = new MemberService();
	
	// 메뉴1. 새회원 등록
	public int insertMember() {

		Member mem = menu.insertMember();  // 자동완성 시, 반환타입이 Member로 자동적으로 채워짐
		// 
		
		int result = mService.insertMember(mem); //  뷰에서 사용자에게 받은 회원정보를 dao로 넘기는 코드 
		// int타입이 반환될 것
		// 무조건 인트타입이 반환되지는 않는다. 
		// 이유 : dao.insertMember(mem)의 임무는 1번 멤버추가->int반환 
		// 2번 잘 추가됬는지  확인을 위해 select Member(Memeber 조회)할거라면 반환값은 resultset으로 받아서 Member로 바꿔서 가져올 거기에 멤버타입으로 반환받게 된다
		// 3번 : select *(전체정보 조회) 조회하고나면 반환값이 ArrayList<Member>가 됨. 즉, 멤버타입의 ArrayList가 반환타입						
		// 인서트한다고 해서 반환값이 무조건 int가 아님. 하는거에 따라서 반환값이 달라진다는 것이 포인트
		
		
//		int result = mDAO.insertMember(mem, conn); // 인서트멤버에 빨간줄 났던 이유 : DAO의 메소드인 insertMember(Member mem)에서
		   //인자를 하나만 받아서임. 보내는 곳은 2개(mem,con)인데 받는 곳에서 mem만 받았어서 에러발생
		if(result>0) {
			menu.displaySuccess(result + "개의 행이 추가되었습니다");  
		}else {
			menu.displayError("데이터 삽입 실패");
		}
		return result;
	}
	
	// 메뉴2. 모든 회원 조회
	public void selectAll() {
		// 전체 회원 조회라 별도로 더 받아올 값이 없기에 바로 Service로 연결 
		ArrayList<Member> list = mService.selectAll();
		
		if(!list.isEmpty()) {
//			menu.selectAll(list); // 숙제로 내가 한 코드
			menu.displayMember(list); // 모범답안
		}else {
			menu.displayError("데이터 조회 실패");
		}
	}	
	
	
	// 메뉴3. 특정 조건 회원 조회 
	public void selectMember() {
		int sel = menu.selectMember(); 			// 어떤거에 대해서 검색할지 뷰에서 사용자로부터 번호를 받아와서 검색할 것임
		
		ArrayList<Member> list = null;
		switch(sel) {
		case 1: 
				String id = menu.inputMemberId();
				list = mService.selectMemberId(id);	// 패턴만 맞아도 값을 가져올 것임. 패턴 하나만 맞아도  된다고 했고 여러명일 수 있기에 
				break;								// ArrayList
		case 2: 
				char gen = menu.inputGender();		
				list = mService.selectGender(gen);	// ArrayList
			break;									// list를 받을려면 서비스에서 반환타입이 arraylist여야하니 바꿔줄 것
		case 0: return; // 메인 메뉴(view)로 돌아가는 것
		}
		
		if( !list.isEmpty() ) {
			menu.displayMember(list);
		}else {
			menu.displayError("조회 결과가 없습니다");
		}
		
	}
	
	
	// 메뉴4. 회원 정보 수정
	public void updateMember() {
		// 정보 수정해야하니 수정을 뭘로 할지 값을 받아오자. 이따가 수정을 어디할지도 쿼리문에서 지정해줘야함
		
		String memberId = menu.inputMemberId(); // 받아온 아이디가 존재하는지 확인절차 필요. db에서 확인해야하니 service에 연결
		int check = mService.checkMember(memberId);
		
		if(check != 1) {
			menu.displayError("입력한 아이디가 존재하지 않습니다");
		}else {
			int sel = menu.updateMember();
			
			if(sel == 0) {
				return; // 메뉴로 돌아갈 수 있게 리턴
			}
			
			// 어떤 값으로 쓸건지 지정해줘야함
			String input = menu.inputUpdate(); // 어떤 값으로 수정을 받을껀지 메소드로 받아올 것임
			int result = mService.updateMember(sel, input, memberId);
			 
			if(result > 0) {
				menu.displaySuccess(result + "개의 행이 수정되었습니다");
			}else {
				menu.displayError("데이터 수정 중 오류 발생");
			}
		}
	}
	
	
	
	
	// 메뉴5. 회원 탈퇴
	public void deleteMember() {
		// 누구를 삭제할지 아이디를 받아와야한다
		String id = menu.inputMemberId(); // 삭제할 아이디 입력 받기
		
		
		//입력받은 아이디와 일치하는 회원 아이디가 있는지 확인
		//있다면 정말 삭제할 것인지 한번 더 묻기 // 삭제하지 않겠다고 하면 메인 메뉴로 돌아감		
		int check = mService.checkMember(id); // ex) 중복아이디가 없으면 0이 저장되고, 1개면  1이 저장된다. 0 또는 1일 것임 
		
		// 내가 쓴 코드
//		if(check != 1) {
//			menu.displayError("입력한 아이디가 존재하지 않습니다");
//		}else {
//			menu.displaySuccess("아이디 확인 완료");
//			char yn = menu.checkDelete();
//			if(yn == 'Y') {
//				int result = mService.deleteMember(id);
//				menu.displaySuccess("삭제 완료");
//			}else if(yn == 'N'){
//				System.out.println("삭제를 중단하였습니다");
//			}else {
//				System.out.println("잘못 입력하셨습니다");
//				return ;	// 메뉴로 돌아가기
//			}
//		}
			
		// 모범 답안
		if(check == 1) {
			char yn = menu.checkDelete();
			if (yn == 'N') {
				return;
			}
			int result = mService.deleteMember(id);
			
			if(result > 0) {
				menu.displaySuccess(result + "개의 행이 삭제되었습니다");
			}else {
				menu.displayError("데이터 삭제 과정 중 오류 발생");
			}
		}else {
			menu.displayError("입력한 아이디가 존재하지 않습니다");
		}
		
		
	}

	public void exitProgram() {
		mService.exitProgram();
		
	}
	

	
	
	
	

	
}




