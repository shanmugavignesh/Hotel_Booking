package servlet;

public class book {

	public void Book(){
		if(n < rooms) {
			rooms = rooms - n;
			orderid = "OD" + id;
			
			db.insertOrder(orderid, cusid, name, location);
			id = id + 1;
			System.out.println("Booking succussful!\n");
			
		}
		else if(rooms == 0) {
			System.out.println("All rooms are booked!");
		}
		else {
			System.out.print("invalid input!\n");
		}
	}
}
