package board.model.vo;

import java.sql.Date;

public class MZBoard {
	
	public int boardNo;
	public int boardType;
	public String boardTitle;
	public int restaurantNo;
	public String restaurantName;
	public String restaurantAddress;
	public String restaurantPhone;
	public String restaurantIntro;
	public String restaurantContent;
	public int foodNo;
	public String foodName;
	public String foodType;
	public String userId;
	public int boardCount;
	public String boardContent;
	public Date boardDate;
	public Date modifyDate;
	public String status;			 
	
	
	
	public MZBoard() {}

	
	public MZBoard(int boardNo, int boardType, String boardTitle, int restaurantNo, String restaurantName,
			String restaurantAddress, String restaurantPhone, String restaurantIntro, String restaurantContent,
			int foodNo, String foodName, String foodType, String userId, int boardCount, String boardContent,
			Date boardDate, Date modifyDate, String status) {
		super();
		this.boardNo = boardNo;
		this.boardType = boardType;
		this.boardTitle = boardTitle;
		this.restaurantNo = restaurantNo;
		this.restaurantName = restaurantName;
		this.restaurantAddress = restaurantAddress;
		this.restaurantPhone = restaurantPhone;
		this.restaurantIntro = restaurantIntro;
		this.restaurantContent = restaurantContent;
		this.foodNo = foodNo;
		this.foodName = foodName;
		this.foodType = foodType;
		this.userId = userId;
		this.boardCount = boardCount;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}

	@Override
	public String toString() {
		return "MZBoard [boardNo=" + boardNo + ", boardType=" + boardType + ", boardTitle=" + boardTitle
				+ ", restaurantNo=" + restaurantNo + ", restaurantName=" + restaurantName + ", restaurantAddress="
				+ restaurantAddress + ", restaurantPhone=" + restaurantPhone + ", restaurantIntro=" + restaurantIntro
				+ ", restaurantContent=" + restaurantContent + ", foodNo=" + foodNo + ", foodName=" + foodName
				+ ", foodType=" + foodType + ", userId=" + userId + ", boardCount=" + boardCount + ", boardContent="
				+ boardContent + ", boardDate=" + boardDate + ", modifyDate=" + modifyDate + ", status=" + status + "]";
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getBoardType() {
		return boardType;
	}

	public void setBoardType(int boardType) {
		this.boardType = boardType;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public int getRestaurantNo() {
		return restaurantNo;
	}

	public void setRestaurantNo(int restaurantNo) {
		this.restaurantNo = restaurantNo;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantAddress() {
		return restaurantAddress;
	}

	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}

	public String getRestaurantPhone() {
		return restaurantPhone;
	}

	public void setRestaurantPhone(String restaurantPhone) {
		this.restaurantPhone = restaurantPhone;
	}

	public String getRestaurantIntro() {
		return restaurantIntro;
	}

	public void setRestaurantIntro(String restaurantIntro) {
		this.restaurantIntro = restaurantIntro;
	}

	public String getRestaurantContent() {
		return restaurantContent;
	}

	public void setRestaurantContent(String restaurantContent) {
		this.restaurantContent = restaurantContent;
	}

	public int getFoodNo() {
		return foodNo;
	}

	public void setFoodNo(int foodNo) {
		this.foodNo = foodNo;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
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
	
	

	
	
	
	
}
