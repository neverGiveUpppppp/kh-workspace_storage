package com.kh.practice.list.music.controller;

import java.util.ArrayList;
import java.util.List;

import com.kh.practice.list.music.model.vo.Music;

public class MusicController {
	
	private List<Music> list = new ArrayList<Music>(); // 지네릭스 : 데이터타입 한정
	// List가 인터페이스라 객체생성불가해서 상속을 통해 ArrayList로 객체생성
	
	// 리스트 마지막에 값 저장 메소드
	public boolean addList(Music music) { // Music m = new Music(title, singer) 인자가 두개지만 Music데이터타입의 music안에 title,singer 데이터 두개를 가지고 있게된다
		// 단순히 레퍼런스변수를 넘긴 것. 다형성,상속개념 들어간거x
		boolean b = list.add(music); // add(object o)의 반환타입 boolean
		return b;
	}
	// 리스트 첫 번째에 값 저장 메소드
	public int addAtZero(Music music) {
		list.add(0, music); // add() 반환타입이  void이므로  반환할게 없지만, 일단 잘 들어왔다는 의미로 1을 반환을 하게 되는거고
		return 1;			// 뒤에 가면 항상 view와 controller 사이에서 값을 주고 받는 일이 생기기 때문에
	}						// 잘 들어갔다라는 의미로 던져주는겁니다
	// 모든 리스트를 반환하는 메소드
	public List printAll() {
		return list;
	}
	// 곡 명을 검색하는 메소드
	public Music searchMusic(String title) {
		// 곡 전체를 다 돌아야해서 for문 사용
		// list에 인덱스에 존재하기에 for문 가능
		// ArrayList 안에 Music객체가 담겨있음. 지네릭<Music>때문에 알수있음
		// List의 Music 객체 안에는 데이터인 곡명 title을 가지고 비교해야한다
		// 리스트 안에 뮤직객체 안에 
		Music findMusic = null;
		for(int i=0; i<list.size();i++) {// list에는 length가 없으니 .size로 크기를 센다
//	로직		list.get(i); // get(int index) // i번째 Music 객체
//	발전		list.get(i).getTitle() // .getTitle(): getter에서 곡명 title을 뽑아오는 코드 추가
			if(list.get(i).getTitle().equals(title)) {
				findMusic = list.get(i);
				break;
			}
		}	
		return findMusic;
	}
	// 곡 명으로 찾아 삭제하는 메소드
	public Music removeMusic(String title) {
		Music removeMusic = null;
		for(int i=0; i<list.size();i++) {
			if(list.get(i).getTitle().equals(title)) {
				removeMusic = list.get(i);
				break;
			}
		}
		return removeMusic;
	}
	// 곡 명으로 찾아 내용을 수정하는 메소드
	public Music setMusic(String title, Music music) {
		Music setMusic = null;
		for(int i=0; i<list.size();i++) {
			if(list.get(i).getTitle().equals(title)) {
				setMusic = list.get(i);
				break;
			}
		}
		return setMusic;
	}
//	// 곡 명 오름차순 정렬하는 메소드
//	public int ascTitle() {
//		return
//	}
//	// 가수 명을 내림차순 정렬하는 메소드
//	public int descSinger() {
//		return
//	}
	
	
	
	
	
}
