package ParkingLotLLD;

import java.util.*;

public class ParkingLot{
	Floor floor;
	int parkingLotId;
	 List<Floor> floors=new ArrayList<>();
	
	public ParkingLot(int parkingLotId) {
		this.parkingLotId=parkingLotId;
//		this.floors=new ArrayList<>();
	}
	public int getParkingLotId() {
		return this.parkingLotId;
	}
	public void addFloor() {
		floors.add(new Floor(floors.size()));
	}
	public void addFloorSlot(int floorNo,int slotType) {
		floors.get(floorNo).addSlot(slotType);
	}
	public void createParkingLotFloors(int noOfFloors,int noOFSlots) {
		
		for(int i=0;i<noOfFloors;i++) {
			floors.add(new Floor(i));
		}
		for(Floor floor:floors) {
			floor.createParkingLotSlots(noOFSlots);
			System.out.println("Floor No : "+floor.getFloorNo()+"\n ");
			floor.displaySlots();
		}
	}
	public String findFloor(int vehicleType) {
		System.out.println(floors);
		for(Floor floor:floors) {
			int slotNo=floor.findSlots(vehicleType);
			if(slotNo!=-1) {
				return (String.valueOf(floor.getFloorNo())+"_"+String.valueOf(slotNo));
			}
			
		}
		return null;
		
		
	}
	public boolean validateParkingId(String[] ticket) {
		if(this.parkingLotId==Integer.valueOf(ticket[0])) {
			boolean unParked=floors.get(Integer.valueOf(ticket[1])).unPark(Integer.valueOf(ticket[2]));
			 return unParked;
		}
		return false;

	}
}

