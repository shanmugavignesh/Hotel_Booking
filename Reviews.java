package servlet;

public class Reviews {
	
	private String hotel_id;
	private String username;
	private String comments;
	private String ratings;
	Reviews(String hotel_id, String username, String comments, String ratings){
		this.hotel_id = hotel_id;
		this.username = username;
		this.comments = comments;
		this.ratings = ratings;
	}
	public String getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getRatings() {
		return ratings;
	}
	public void setRatings(String ratings) {
		this.ratings = ratings;
	}
}
