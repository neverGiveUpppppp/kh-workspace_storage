package member.model.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import member.model.vo.Member;
import member.model.vo.MemberException;

public class MemberDAO {

	
	// 웹싸이트 회원 로그인
	public Member selectMember(SqlSession session, Member m) throws MemberException {

		// 강의 9시
		// select에 관련된 것 사용할 것. selectList나 selectOne 둘 중 하나 사용할 것임
		// 리절트셋에서 반환되는 행이 몇개이냐에 따라 selectOne과  selectList 분류
		// selectOne : 행이 0 or 1개 
		// selectList 행이 여러개
		
		// selectOne의 인자 내용&순서) ( 연결할 쿼리문 지정, 
		// 연결할 쿼리문이 loginMember. mapper.xml의 id값을 selectOne인자로 넣으면 된다
		// 쿼리문 위치 : 어느 매퍼에 있는 쿼리인지도 명시해줘야함. 그것이 namespace속성
		// id="쿼리 pk (위치)"
		// namespace="매퍼 pk (위치)"
		
		// SqlSession클래스 메소드의 인자
		// selectOne,selectList
		// 첫번째 인자(arg1) : 연결할 쿼리문 지정
		// 두번째 인자(arg1) : 쿼리에 보낼 데이터 지정. 어떤 데이터를 보낼지 지정
		
		// 인자 1개짜리 메소드 사용할 때 :위치홀더 없을 때(jdbc로 보면 stmt 사용할 때)
		// 인자 2개짜리 메소드 사용할 때 :위치홀더 있을 때(jdbc로 보면 pstmt 사용할 때)
//		session.selectOne("memberMaper.loginMemeber", m);
//		session.selectOne("memberMaper.loginMemeber", m.getUserId(), m.getUserPwd()); - 셀렉트원 인자가 1개인데 인자 2,3개 이렇게 보내기 불가능 그래서 하나에 담아서 보내야만함
		
		// 쿼리문의 위치홀더 : 유저아이디,유저 비번 채워줘야함
		// 서비스에서 받아온 vo의 Member m의 정보(userId,pwd)를 selectOne 조회해야하는데 
		// 이를 vo 객체or컬렉션에 담아서 보내야함
		// 셀렉트원 인자가 1개인데 인자 2,3개 이렇게 보내기 불가능 그래서 하나에 담아서 보내야만함
		
		// 강의시간 9:44
		// mybatis, execute,update 할 필요 없이 알아서 보내주고 결과값을 받아옴
		
		// 리절트셋 반환 받았으니 이 값을 활용할 수 있도록 원하는 타입으로 데이터처리 해야함. ex) int -> Member m으로
		
		// 리절트 타입을 지정하고 데이터를 멤버 객체에 담는데 select문에 컬럼이 *가 아닌 지정 컬럼이면 개별적으로 몇개만 있으면 알아서 데이터를 담는다



		
		Member member = session.selectOne("memberMapper.loginMember", m); // <mapper namespace="memberMapper">와 config.xml의 매퍼태그 설정이랑 연결되어있음
		System.out.println(member);
		
		// 예외 강제 발생 시켜보자
		if(member == null) {
			session.close(); // 에러가 났을 때의 클로즈. 자원반납해주기 위해
			throw new MemberException("로그인  실패"); // throw : 예외 처리 코드
		}
		return member;
	}

	
	
	
	// 회원가입
	public void insertMember(SqlSession session, Member m) throws MemberException {
		
		int result = session.insert("memberMapper.insertMember", m); // 인자 1개? 2개? 어떤거 써야할까? 2개짜리. (쿼리문 id, 뷰에서 받아온 회원가입 정보)
		// (member-mapper.xml의 insert태그의 id속성값, 뷰에서 받아온 데이터)
		
		if(result <= 0) {
			session.rollback();
			session.close();
			throw new MemberException("회원가입 실패"); // 예외처리 코드
		}
	}



	// 내정보보기 수정
	public void updateMember(SqlSession session, Member m) throws MemberException {
		
		int result = session.update("memberMapper.updateMember", m);
		// member-mapper.xml로 가서 updateMember쿼리용 태그 생성하고 쿼리문 작성해야함
		
		if(result <= 0) {
			session.rollback();	// 실패했다고 뜰거니까 롤백하고 닫아줘야함
			session.close();
		throw new MemberException("회원정보 수정 실패하였습니다.");
		}
	}



	// 비번 수정
	public void updatePwd(SqlSession session, HashMap<String, String> map) throws MemberException {

		int result = session.update("memberMapper.updatePwd",map); // db에 보낼 값이 있으니 인자2개
		// member-mapper.xml에 update태그 생성 및 update 쿼리문 작성해야함
		
		if(result <= 0) {
			session.rollback();	// 실패했다고 뜰거니까 롤백하고 닫아줘야함
			session.close();
		throw new MemberException("회원정보 수정 실패하였습니다.");
		}
	}



	// 회원 탈퇴
	public void deleteMember(SqlSession session, String userId) throws MemberException {

		// session.delete도 가능하지만 update로 해볼것임
		int result = session.update("memberMapper.deleteMember",userId); // status만 바꿀꺼니 2번쨰 인자 필요없다? 누구꺼를 바꿀지가 필요하니까 2번쨰 인자에 userId 필요
		
		if(result <= 0) {
			session.rollback();	// 실패했다고 뜰거니까 롤백하고 닫아줘야함
			session.close();
		throw new MemberException("회원정보 수정 실패하였습니다.");
		}
		
	}
	
	

	
	
	

}












