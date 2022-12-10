package common;

import board.model.vo.PageInfo;

public class Pagination {

	
	public static PageInfo getPageInfo(int currentPage, int listCount) {
		
		int pageLimit = 10;
		int maxPage;
		int startPage;
		int endPage;
		int boardLimit = 5;
		
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		// 여분 게시물의 페이지수(maxPage) 처리 방법 3가지
				// 방법1 : 마지막페이지 = 총 게시물 수 / 한 페이지 보일 최대 게시글 수 +1 + if문(나머지 없이 몫만 떨어질 경우)
				// 방법2 : 강제 형변환 (int)  + (double)  + ceil()
				// 방법3 : 강제 형변환 (int) + (double) + listCount / boardLimit +0.9
				
				
				// 방법1 : 마지막페이지 = 총 게시물 수 / 한 페이지 보일 최대 게시글 수 +1 + if문(나머지 없이 몫만 떨어질 경우)
				// 97개의 게시물이니 최대 10페이지 나옴. 9개 10개씩 꽉차고 7개 담아서 총10페이지
				// 9 나누기 10 = 9...7  나머지
				// listCount(총개수)로 boardLimit로 나눠야함.
				// 둘을 나누면 몫이 나오고 두 값이 int기에 반환도 int값으로 반환됨
				
//					maxPage = listCount/boardLimit + 1; // +1 하는건  나머지가 없이 딱 떨어지면 식이 안맞음
				// +1에 조건문 나머지가 없을시를 넣어서 해도 됨
				
				// 나머지가 1이라도 있으면 올림해야함. 남은 1개의 게시글을 위해서.
				// 나머지가 나와야함. 9.7 12.3 소수점이 나오게 하고 싶다. 그럼 둘중 하나를 형변환 시키면 됨
				
				
				// 방법2 : 강제 형변환 (int)  + (double)  + ceil()
//				maxPage = (int)Math.ceil((double)listCount/boardLimit); // 하나가 소수점이라 둘을 계산하면 소수점이 나옴. 10.0 이런식으로
				// ceil로 올림을 추가하므로써 나머지가 1이라도 있으면 게시판 +1구현
				// int형변환한 이유 : maxPage가 인트라 다시 인트로 형변환 해준 것
				// 다른 방법 : 다른거를 더해서 사용. 많이 복잡함.
				// maxPage = (int)Math.ceil((double)listCount/boardLimit); 
				
				// 방법3 : 강제 형변환 (int) + (double) + listCount / boardLimit +0.9
				// (int)((double)listCount/boardLimit + 0.9); 올림할 수 있는 최소값이 0.9 
				// 내가 올림을 해야하는 최소값이 0.1
				// 한 페이지를 더해줘야하는 가장 최소값 0.1
				// 이 최소값 마저도 올려줄려면 더할 수 있는 값은 0.9
				// ex) 121개의 게시물이면 12.1이고 
				// 12.1 + 0.9하면 13.0
				// 12.9 + 0.9하면 13.8
				// 다시 (int) 형변환 과정에서 소수점은 어차피 짤리므로 자연스럽게 나머지 페이스도 처리 가능
		
		
		startPage = (currentPage - 1)/pageLimit * pageLimit + 1;
				// 수열 만들어서 n값을 만들고 ... 현재값을 통해서 n값을 만들 수 있었음 강의 11:04
		
		endPage = startPage + pageLimit - 1;
		if(maxPage < endPage) {		// maxPage가 endPage보다 작을 경우가 있음. 
			endPage = maxPage;		// 이럴 때는 maxPage를 endPage 안으로 집어 넣으면 된다
		}
		
		
		// 데이터가 많아서 객체에 하나로 담아 전송할 것임
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, maxPage, startPage, endPage, boardLimit);
		
		
		return pi;
	}
	
}
