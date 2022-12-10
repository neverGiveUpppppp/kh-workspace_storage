package MVC.model.vo;


public class Music {


	private String title;
	private String singer;
	
	public Music() {}
	public Music(String title, String singer) {
		this.title = title;
		this.singer = singer;
	}
	
	
	// setter & getter
	public void setTitle(String title) {
		this.title = title;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getTitle() {
		return title;
	}
	public String getSinger() {
		return singer;
	}
	
	
	//toString
	@Override
	public String toString() {
		return singer+" - " +title;
	}
		
	
	
}
