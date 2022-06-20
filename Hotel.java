package servlet;

public class Hotel {
	public String getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}
	public String getHotel_name() {
		return hotel_name;
	}
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getContact_num() {
		return contact_num;
	}
	public void setContact_num(long contact_num) {
		this.contact_num = contact_num;
	}
	public int getRooms() {
		return rooms;
	}
	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	public int getTotal_rooms() {
		return total_rooms;
	}
	public void setTotal_rooms(int total_rooms) {
		this.total_rooms = total_rooms;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	private String hotel_id;
	private String hotel_name;
	private String location;
	private long contact_num;
	private int rooms;
	private int total_rooms;
	private int price;
	Hotel(String hotel_id, String hotel_name, String location, long contact_num, int rooms, int total_rooms, int price){
		this.hotel_id = hotel_id;
		this.hotel_name = hotel_name;
		this.location = location;
		this.contact_num = contact_num;
		this.rooms = rooms;
		this.total_rooms = total_rooms;
		this.price = price;
	}

}
