package board.model.vo;

import java.sql.Date;

public class Attachment {
	
	
	// 사진 데이터 받아줄 model.vo Attachment
	private int fileId;			// 식별자 용도로 쓰이는 변수
	private int boardId;		// 파일 아이디의 부모역할(FK) // 이 파일이 어떤 보드 파일로 들어가는지 구분하기 위해 이 필드를 사용
	private String originName;	// 사용자가 지정한 원본 파일 이름
	private String changeName;	// 서버에 여러 사용자가 같은 파일명으로 저장할 수 있으니 중복안되게 서버에 저장되는 파일명
	private String filePath;	// 파일이 서버 내에 어디에 저장되는지에 대한 경로
	private Date uploadDate;
	private int fileLevel;		// 사진이 썸네일인지 내용에 들어가는 사진인지를 구분해주기 위한 변수
	private int downloadeCount;
	private String status;		// 사진 삭제 여부
	
	
	public Attachment() {}


	public Attachment(int fileId, int boardId, String originName, String changeName, String filePath, Date uploadDate,
			int fileLevel, int downloadeCount, String status) {
		super();
		this.fileId = fileId;
		this.boardId = boardId;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
		this.fileLevel = fileLevel;
		this.downloadeCount = downloadeCount;
		this.status = status;
	}



	public int getFileId() {
		return fileId;
	}




	public void setFileId(int fileId) {
		this.fileId = fileId;
	}




	public int getBoardId() {
		return boardId;
	}




	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}




	public String getOriginName() {
		return originName;
	}




	public void setOriginName(String originName) {
		this.originName = originName;
	}




	public String getChangeName() {
		return changeName;
	}




	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}




	public String getFilePath() {
		return filePath;
	}




	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}




	public Date getUploadDate() {
		return uploadDate;
	}




	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}




	public int getFileLevel() {
		return fileLevel;
	}




	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
	}




	public int getDownloadeCount() {
		return downloadeCount;
	}




	public void setDownloadeCount(int downloadeCount) {
		this.downloadeCount = downloadeCount;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	@Override
	public String toString() {
		return "Attachment [fileId=" + fileId + ", boardId=" + boardId + ", originName=" + originName + ", changeName="
				+ changeName + ", filePath=" + filePath + ", uploadDate=" + uploadDate + ", fileLevel=" + fileLevel
				+ ", downloadeCount=" + downloadeCount + ", status=" + status + "]";
	}
	
	
	
	
	
	
	
	
}
