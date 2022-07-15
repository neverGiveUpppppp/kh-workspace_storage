package notice.model.vo;

import java.sql.Date;

public class MZNotice {
	private int noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private String noticeWriter;
	private int noticeCount;
	private Date noticeDate;
	private String status;
	
	public MZNotice() {}

	public MZNotice(int noticeNo, String noticeTitle, String noticeContent, String noticeWriter, int noticeCount,
			Date noticeDate, String status) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeWriter = noticeWriter;
		this.noticeCount = noticeCount;
		this.noticeDate = noticeDate;
		this.status = status;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public String getNoticeWriter() {
		return noticeWriter;
	}

	public int getNoticeCount() {
		return noticeCount;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public String getStatus() {
		return status;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}

	public void setNoticeCount(int noticeCount) {
		this.noticeCount = noticeCount;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MZNotice [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ ", noticeWriter=" + noticeWriter + ", noticeCount=" + noticeCount + ", noticeDate=" + noticeDate
				+ ", status=" + status + "]";
	}
	
	
	
}
