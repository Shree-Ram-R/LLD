package ParkingLotLLD;

public class ParkingSlots {
	int slotNo;
	int slotType;
	boolean isAvailable;
	public ParkingSlots(int slotNo,int slotType) {
		this.slotNo=slotNo;
		this.slotType=slotType;
		this.isAvailable=true;
	}
	public int getslotNo() {
		return this.slotNo;
	}
	public int getSlotType() { 
		return this.slotType;
	}
	public boolean getIsAvailable() {
		return this.isAvailable;
	}
	
	
}
