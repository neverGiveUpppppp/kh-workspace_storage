package com.kh.practice.list.music.model.vo;

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
	
//	// hashCode
//	public int hashCode() {
//		
//	}
//	// equals(Object obj
//	public boolean equals(Object obj) {
//		
//	}
//	//  compareTo(Object o)
//	public int compareTo(Object o) {
//		
//	}
	
	@Override
	public boolean equals(Object obj) {
		// 클래스 비교
		if (this == obj) {
			return true;
		}	
	    if(obj == null) {
	       return false;
	    }
	    if(getClass() != obj.getClass()) {
	       return false;
	    }
	    // 내용 비교
		Music other = (Music)obj;
		if(title == null) {
			if(other.title != null) {
				return false;
			}
		}else if (!title.equals(other.title)) {
			return false;
		}
		if(singer == null) {
			if(other.singer != null) {
				
			}
	    if(score != other.score) {
	    	return false;	
	    }
		return true;
	}
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		
		result = PRIME * result + (title == null ? 0 : title.hashCode());
		result = PRIME * result + (singer == null ? 0 : singer.hashCode());
	      
	    return result;
	}
}
