package MVC.controller;
import java.util.ArrayList;
import MVC.model.vo.pModelVo05;
public class pController05 {
	
	// List
	// ArrayList
	public void pList() {
		
		ArrayList<pModelVo05> al = new ArrayList<>();
		
		// API문서의 메소드 안에 무엇이 오는지 설명
		// Element e :제네릭에 지정 받은 타입을 그대로 쓰겠다. 
		// Object o : 안에 뭘 받아올지 모르니까 다 받을 수 있게 오브젝트로 쓰겠다. 엘레멘트로 타입을 지정할 필요가 없다
		
		// 1-1. // add(E e):boolean
		al.add(new pModelVo05("과일",5000));
		al.add(new pModelVo05("스낵 ",1500));
		System.out.println(al.add(new pModelVo05("껌",1500))); // true
		System.out.println(al); // [과일[5000원], 과자[1500원]]
		
		// 1-2. add(int index, E element):void
		al.add(3, new pModelVo05("쌀",50000)); // 마지막3번이 아닌 더 뒤4로 하니 길이 에러
		System.out.println(al); // [과일[5000원], 스낵 [1500원], 껌[1500원], 쌀[50000원]] 
//		System.out.println(al.add(3, new pModelVo05("믈",500))); // void 즉 없는 값을 출력하라해서 에러
		
		// 2. size()
		System.out.println(al.size()); // 4
		
		al.add(new pModelVo05("계란",6000)); // 자동 길이추가
		System.out.println(al); // [과일[5000원], 스낵 [1500원], 껌[1500원], 쌀[50000원], 계란[6000원]]
		
		
		// 3.remove()
		// remove(int index):E
		// remove(Object o):boolean
		System.out.println("=====remove=====");
		al.remove(0); // 과일 삭제
		System.out.println(al.remove(0)); // 스낵 [1500원] // 스낵삭제
		System.out.println(al); // 껌[1500원], 쌀[50000원], 계란[6000원]]
		
		al.remove(new pModelVo05("껌",1500)); // 작동x. 모델에서 오버라이딩 안했기 때문
		System.out.println(al); // [껌[1500원], 쌀[50000원], 계란[6000원]]
		// 모델 오버라이딩 후 			// [쌀[50000원], 계란[6000원]]
		
		System.out.println(al.remove(new pModelVo05("쌀",50000))); // true // 쌀 삭제
		
		pModelVo05 pm = new pModelVo05("계란",6000);
		System.out.println(al.remove(pm)); // true
		System.out.println(al); // []
		al.add(new pModelVo05("물",500));
		al.add(new pModelVo05("요거트",1000));
		System.out.println(al); // [물[500원], 요거트[1000원]]
		
		// 4. set()
		// set(int index, E e):E
		// == replace 대체
		System.out.println(al.set(1, new pModelVo05("커피",1500))); // 요거트[1000원]  // 바꿔진 엘리먼트값 출력
		al.set(1, new pModelVo05("커피",1500)); 				
		System.out.println(al); // [물[500원], 커피[1500원]]
		
		
		// 5. get() 
		// get(int index):E
		System.out.println(al.get(1)); // 커피[1500원]
		System.out.println(al.get(0)); // 물[500원]
		
		// 6. contains(Object) : boolean
		// 해당 객체를 포함한지 true/false반환
		System.out.println(al.contains(new pModelVo05("물",500))); // true
		System.out.println(al.contains(new pModelVo05("물",0))); // false
		
		
		// 7. indexOf(Object o): int 
		// 해당 객체의 인덱스번호 반환
		// 해당 값이 없을경우 -1 반환
		System.out.println(al.indexOf(new pModelVo05("물",500))); // 0
		System.out.println(al.indexOf(new pModelVo05("커피",1500))); // 1
		System.out.println(al.indexOf(new pModelVo05("커피",500))); // -1 // 없을경우-1반환
		
		
		// 8. equals(Object o):boolean
		// 지정된 객체와 목록이 같은지 비교
		System.out.println(al);  // [물[500원], 커피[1500원]]
		System.out.println(al.equals(new pModelVo05("물",500))); // false //[물[500원], 커피[1500원]]와 비교해서 false
		System.out.println(al.equals(new pModelVo05("커피",1500))); //al인 [물[500원], 커피[1500원]]와 비교 하니 false
		
		System.out.println(new pModelVo05("물",500).equals(new pModelVo05("물",500))); // true
		System.out.println(new pModelVo05("커피",1500).equals(new pModelVo05("커피",1500))); // true

		
		
		// 9. clear()
		// clear():void
		al.clear();
		System.out.println(al); // []
		
		// 10. isEmpty():boolean
		System.out.println(al.isEmpty()); // true
		
		
		
		System.out.println("=====ArrayList<string>=====");
		
		ArrayList<String> aList = new ArrayList<>();
		aList.add(new String("인내"));
		aList.add(new String("노력"));
		System.out.println(aList.remove(new String("인내")));
		System.out.println(aList);
//		aList.equals(new String("인내"));
		System.out.println(aList.equals(new String("인내")));
		
		
	}	
		
}
