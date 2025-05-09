package ParkingLotLLD;

import java.util.*;

public class Floor {
	int floorNo;
	 List<ParkingSlots> slots=new ArrayList<>();
	public Floor(int floorNo) {
		this.floorNo=floorNo;
//		this.slots=new ArrayList<>();
	}
	public int getFloorNo() {
		return this.floorNo;
	}
	public void addSlot(int slotType) {
		slots.add(new ParkingSlots(slots.size()+1,slotType));
	}
	
    public void createParkingLotSlots(int noOfSlots) {
    	
    	slots.add(new ParkingSlots(1,3));
    	slots.add(new ParkingSlots(2,1));
    	slots.add(new ParkingSlots(3,1));
    	for(int i=3;i<noOfSlots;i++) {
    		slots.add(new ParkingSlots(i+1,2));
    	}
    	
    	
		
	}
	public int findSlots(int vehicleType) {
		System.out.println(slots);
		for(ParkingSlots slot:slots) {
			if(slot.getSlotType()==vehicleType && slot.getIsAvailable()) {
				slot.isAvailable=false;
				return slot.getslotNo();
			}
			
		}
		 return -1;
		
	}
	public boolean unPark(Integer slotNo ) {
		slots.get(slotNo-1).isAvailable=true;
		return true;
		
	}
	public String displaySlots() {
		for(ParkingSlots slot:slots) {
			System.out.println("Slot No : "+slot.getslotNo()+" SlotType : "+slot.getSlotType()+" Status : "+slot.isAvailable);
		}
		return "";
	}
}

