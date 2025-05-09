package ParkingLotLLD;

public class Vehicle {
	int vehicleNo;
	int vehicleType;
	String color;
	public Vehicle(int vehicleNo,int vehicleType,String color) {
		this.vehicleNo=vehicleNo;
		this.vehicleType=vehicleType;
		this.color=color;
	}
	public int getVehicleNo() {
		return vehicleNo;
	}
	public int getVehicleType() {
		return vehicleType;
	}
	public String getColor() {
		return color;
	}
	
	
}
