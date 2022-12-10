package board.model.vo;

public class Pagination {
	
	private int boardCount;	 // 총 게시물 수
	private int currentPage; // cp
	private int pageLimit;
	private int boardLimit;
	private int lastPage;
	private int startPage;
	private int endPage;

	
	public Pagination() {}


	public Pagination(int boardCount, int currentPage, int pageLimit, int boardLimit, int lastPage, int startPage,
			int endPage) {
		super();
		this.boardCount = boardCount;
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.boardLimit = boardLimit;
		this.lastPage = lastPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}


	@Override
	public String toString() {
		return "Pagination [boardCount=" + boardCount + ", currentPage=" + currentPage + ", pageLimit=" + pageLimit
				+ ", boardLimit=" + boardLimit + ", lastPage=" + lastPage + ", startPage=" + startPage + ", endPage="
				+ endPage + "]";
	}


	public int getBoardCount() {
		return boardCount;
	}


	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public int getPageLimit() {
		return pageLimit;
	}


	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}


	public int getBoardLimit() {
		return boardLimit;
	}


	public void setBoardLimit(int boardLimit) {
		this.boardLimit = boardLimit;
	}


	public int getLastPage() {
		return lastPage;
	}


	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}


	public int getStartPage() {
		return startPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	
	
	
	
}
