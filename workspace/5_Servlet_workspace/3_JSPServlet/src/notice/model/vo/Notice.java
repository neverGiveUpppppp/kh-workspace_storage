package notice.model.vo;

import java.sql.Date;

public class Notice {
	
	private int noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private String noticeWriter;
	private String nickName;
	private int noticeCount;
	private Date noticeDate;
	private String status;
	
	


	public Notice() {}

	public Notice(int noticeNo, String noticeTitle, String noticeContent, String noticeWriter, String nickName,
			int noticeCount, Date noticeDate, String status) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeWriter = noticeWriter;
		this.nickName = nickName;
		this.noticeCount = noticeCount;
		this.noticeDate = noticeDate;
		this.status = status;
	}

	
	
	
	public int getNoticeNo() {
		return noticeNo;
	}




	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}




	public String getNoticeTitle() {
		return noticeTitle;
	}




	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}




	public String getNoticeContent() {
		return noticeContent;
	}




	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}




	public String getNoticeWriter() {
		return noticeWriter;
	}




	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}




	public String getNickName() {
		return nickName;
	}




	public void setNickName(String nickName) {
		this.nickName = nickName;
	}




	public int getNoticeCount() {
		return noticeCount;
	}




	public void setNoticeCount(int noticeCount) {
		this.noticeCount = noticeCount;
	}




	public Date getNoticeDate() {
		return noticeDate;
	}




	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}






	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ ", noticeWriter=" + noticeWriter + ", nickName=" + nickName + ", noticeCount=" + noticeCount
				+ ", noticeDate=" + noticeDate + ", status=" + status + "]";
	}
	
	
	
}
