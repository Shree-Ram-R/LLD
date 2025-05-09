package ParkingLotLLD;

public class Customer {
	
	ParkingLot parkingLot;
	private String name;
	private long phoneNumber;
	Vehicle cusVehicle;
	Tickets ticketId;
	
	public Customer(String name,long phoneNumber,int vehicleNo,int vehicleType,String color,ParkingLot parkingLot) {
		this.name=name;
		this.phoneNumber=phoneNumber;
		this.cusVehicle=new Vehicle(vehicleNo,vehicleType,color);
		this.ticketId=null;
		this.parkingLot=parkingLot;
	}
	public String getName() {
		return this.name;
	}
	public long getPhoneNumber() {
		return this.phoneNumber;
	}
	public Vehicle getVehicle() {
		return this.cusVehicle;
	}
	
	public void parkVehicle() {
		
		String floor_slot=parkingLot.findFloor(cusVehicle.getVehicleType());
		System.out.println(floor_slot);
		if(floor_slot!=null) {
			String lot_floor_slot=String.valueOf(parkingLot.getParkingLotId())+"_"+floor_slot;
			ticketId=new Tickets(lot_floor_slot);
			System.out.println("Vehicle Parked Successfull and Get your Ticket "+ticketId.getTicketId());
		}
		else System.out.println("No Slots Are Available Right Now");
	}
	public void unParkVehicle(String ticketId) {
		if(ticketId!=null) {
			 String[] ticket=ticketId.split("_");
			 boolean unParked=parkingLot.validateParkingId(ticket);
			 if(unParked) {
				 System.out.println("Vehicle Number : "+this.cusVehicle.getVehicleNo()+" color : "+this.cusVehicle.getColor()); 
				 System.out.println("Vehicle unparked Successfully!!");
			 }
			 
		}
		else {
			System.out.println("You havent Parked the vehicle Yet");
		}
	}
}
