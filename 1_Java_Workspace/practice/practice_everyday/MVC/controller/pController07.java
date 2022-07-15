
package MVC.controller;
import MVC.model.DAO.pModelDAO07;
import MVC.model.vo.pModelVo07;
import MVC.view.pView07;

import java.util.ArrayList;


public class pController07 {

//	controller : Model과 View를 연결해주는 다리역할
//	 넘겨받은 데이터를 가공시키는 역할
//	어떤 뷰에 출력할지를 결정	

	private pModelDAO07 pmDAO = new pModelDAO07();
	private pView07 pV07 = new pView07();
	
	 
	// 메뉴1.전체 사원 정보 조회
	public void selectAll() {
		ArrayList<pModelVo07> al = pmDAO.selectAll();
		if(al.isEmpty()) {
			System.out.println("조회 결과가 없습니다");
		}else {
			pV07.selectAll(al);
		}
			
	}
		
		
	
		
}
