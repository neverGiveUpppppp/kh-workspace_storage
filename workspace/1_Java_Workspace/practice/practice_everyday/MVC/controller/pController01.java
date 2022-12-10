package MVC.controller;
import java.util.ArrayList;

import MVC.model.vo.pModelVo01;

public class pController01 {

	public void firstR() {
		
//		ArrayList list = new ArrayList();
		ArrayList<pModelVo01> list = new ArrayList<pModelVo01>(3); // 지네릭스 : 데이터타입 한정
		
		System.out.println(list); // 결과값 : []
								  // 리스트 자체가 대괄호 자동생성
		// 1. add(E e):boolean : 추가
		list.add(new pModelVo01("1번", 1));
		list.add(new pModelVo01("2번", 2));
		list.add(new pModelVo01("3번", 3));
		System.out.println(list);
		System.out.println("리스트 길이 : "+list.size());
//		list.add("hi",0);
		
		// 2. add(int index, E elemnet) : 자리 지정 추가
		list.add(0, new pModelVo01("0번",0));
		System.out.println(list);
		System.out.println("리스트 길이 : "+list.size());
		list.add(0, new pModelVo01("===",0));
		System.out.println(list);
		System.out.println(list.size());
		
		// 3.  remove(int index):E : 삭제
		list.remove(0);
		System.out.println(list);
		pModelVo01 a = list.remove(0); // .remove()의 삭제한 반환값  확인용 변수 
		System.out.println(a);
		System.out.println(list);
		System.out.println(list.size());
		
		
		//4 remove(Object o):boolean 
		
		pModelVo01 pm = new pModelVo01("1번",1);
		list.remove(pm);
		System.out.println(list); // 주소값이 다르기에 삭제 안한 것
		
		ArrayList<String> remve = new ArrayList<String>();
		remve.add("ㄱ");
		remve.add("ㄴ");
		remve.add("ㄷ");
		System.out.println(remve); // [ㄱ, ㄴ, ㄷ]
		System.out.println(remve.remove(new String("ㄷ")));
		System.out.println(remve); // [ㄱ, ㄴ]
		
		// set(int index, E e)
		// 해당 인덱스번호의 내용을 교체
		list.set(0, new pModelVo01("2번",2));
		list.set(2, new pModelVo01("2번",2));
		System.out.println(list); // [2번(2점), 2번(2점), 2번(2점)]
		
		// get(int index):E
		list.get(0);
		pModelVo01 tmp = list.get(0);
		System.out.println(tmp); // 2번(2점)
		
		System.out.println("==========================");
		// contains(Object) : boolean
		list.contains(new pModelVo01("2번",2));
		System.out.println(list);
		System.out.println(list.contains(new pModelVo01("2번",2)));
		System.out.println(remve.contains(new String("ㄴ")));
		
		// indexOf: int 
		// 해당 인덱스 번호 반환
		remve.add("ㄷ");		
		remve.add("ㄹ");		
		remve.add("ㅎ");		
		int aa = remve.indexOf(new String("ㅎ"));
		int aaa = list.indexOf(new pModelVo01("2번",2));
		System.out.println(aaa);
		
		// clear():void
		// isEmpty():boolean
		list.clear();
		remve.clear();
		System.out.println(list);
		System.out.println(remve);
		System.out.println(list.isEmpty());
		System.out.println(remve.isEmpty());
		
	}
	
}
