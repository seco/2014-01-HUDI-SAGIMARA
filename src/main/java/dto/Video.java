package dto;

public class Video extends BaseModel{
	private String videoId;
	private String videoLink;
	private String videoDate;
	
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public String getVideoLink() {
		return videoLink;
	}
	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}
	public String getVideoDate() {
		return videoDate;
	}
	public void setVideoDate(String videoDate) {
		this.videoDate = videoDate;
	}

}
