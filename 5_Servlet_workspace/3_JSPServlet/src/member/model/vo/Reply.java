package member.model.vo;

import java.sql.Date;

public class Reply {

	
	// 댓글은 보드 상세보기에서 볼 수 있음
	private int replyId;
	private String replyContent;
	private int refBoardId;
	private String replyWriter;
	private String nickName;
	private Date createDate;
	private Date modifyDate;
	private String status;		// 댓글 삭제여부

	
	
	public Reply() {}



	public Reply(int replyId, String replyContent, int refBoardId, String replyWriter, String nickName, Date createDate,
			Date modifyDate, String status) {
		super();
		this.replyId = replyId;
		this.replyContent = replyContent;
		this.refBoardId = refBoardId;
		this.replyWriter = replyWriter;
		this.nickName = nickName;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}



	public int getReplyId() {
		return replyId;
	}



	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}



	public String getReplyContent() {
		return replyContent;
	}



	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}



	public int getRefBoardId() {
		return refBoardId;
	}



	public void setRefBoardId(int refBoardId) {
		this.refBoardId = refBoardId;
	}



	public String getReplyWriter() {
		return replyWriter;
	}



	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}



	public String getNickName() {
		return nickName;
	}



	public void setNickName(String nickName) {
		this.nickName = nickName;
	}



	public Date getCreateDate() {
		return createDate;
	}



	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}



	public Date getModifyDate() {
		return modifyDate;
	}



	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", replyContent=" + replyContent + ", refBoardId=" + refBoardId
				+ ", replyWriter=" + replyWriter + ", nickName=" + nickName + ", createDate=" + createDate
				+ ", modifyDate=" + modifyDate + ", status=" + status + "]";
	}
	
	
	
	
	
	
	
	
}
