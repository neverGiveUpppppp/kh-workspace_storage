package common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy {
	// implements : 인터페이스 사용 명령어
	// import : FileRenamePolicy 
	// MyFileRenamePolicy 빨간줄 툴팁에서 add unimplements Method로 @Override 추가
	
	@Override
	public File rename(File originFile) {
		
		// 바꿀 이름에 날짜+시간을 사용하면 파일명 거의 안겹침
		// 정말 우연의 일치로 동시에 넣는 사람을 위해서 랜덤값까지 추가
		
		// 시간+날짜
		long currentTime = System.currentTimeMillis();
		
		// 랜덤 숫자 뽑기
		int ranNum = (int)(Math.random() * 100000);
		
		// 확장자명 가져오기
		String name = originFile.getName(); // 오리진은 파일명을 뜻함(?) 강의 3:39
		String ext = null; // 확장자명 일단 null로 세팅
		
		// 확장자만 파일명에서 추출하고 싶다면?
		// 문자열 맨 뒤에서 앞으로 .까지 추출
		
		int dot = name.lastIndexOf("."); // 가장 마지막 인덱스에 있는 .을 가져와라 // 문장에 .이 여러개 있어도 문장 가장 마지막 .을 가져오라는 뜻
		// .이 없는 파일을 위해
		if(dot == -1) { // substring()메소드가 값이 없으면 -1 반환이기에 if조건을 -1로 설정
			ext = "";
		}else {
			ext = name.substring(dot); // 파일명이 22.05.08 점심.png라면 .PNG로 나올 것임
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String fileName = sdf.format(new Date(currentTime)) + ranNum + ext; // 그떄 시간 형식을 맞춰주고 ...  // Date는 util 임포트
				
		File newFile = new File(originFile.getParent(),fileName); // getParent : 내 앞(부모)까지		
		
		// 강의 시간 3:49
		// .. 얘네둘이 해서 저장까지 됨
		return newFile;
		
	} 
	
	
	
	
	
	
	

}



