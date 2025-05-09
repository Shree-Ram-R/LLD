package ParkingLotLLD;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ParkingLot parkingLot=null;
		List<Customer> customerList=new ArrayList<>();
		
		System.out.println("****Main Menu****\n");
		int wish=0;
		do {
			showMainMenu();
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				 parkingLot.addFloor();
				 System.out.println("Floor has been Added Successfully!!");
				 break;
			case 2:
				 System.out.println("Enter the floor number You need to add slot");
				 int floorNo=sc.nextInt();
				 showSlotType();
				 int slotType=sc.nextInt();
				 parkingLot.addFloorSlot(floorNo,slotType);
				 System.out.println("ParkingSlot has been Added Successfully!!");
				 break;
			case 3:
			    System.out.println("***Enter the Customer Details***");
			    sc.nextLine(); // Clear buffer after menu input

			    System.out.println("Name           :");
			    String name = sc.nextLine();

			    System.out.println("Phone Number   :");
			    long phoneNumber = Long.parseLong(sc.nextLine());  // Use nextLine to avoid InputMismatch

			    System.out.println("Vehicle Number :");
			    int vehicleNo = Integer.parseInt(sc.nextLine());  // Same here

			    System.out.println("For Vehicle Type press 1 for Bike . 2 for Car . 3 for Truck");
			    System.out.println("Vehicle Type   :");
			    int vehicleType = Integer.parseInt(sc.nextLine());  // and here

			    System.out.println("Color          :");
			    String color = sc.nextLine();

			    
			    customerList.add(new Customer(name, phoneNumber, vehicleNo, vehicleType, color,parkingLot));
			    customerList.get(customerList.size()-1).parkVehicle();
			    break;

			case 4:
				
				System.out.println("Enter the ticket Id : ");
				String ticket=sc.next();
				boolean flag=false;
				for(Customer cus:customerList) {
					if(cus.ticketId.getTicketId().equals(ticket)) {
						flag=true;
						cus.unParkVehicle(cus.ticketId.getTicketId());
					}
					
				}
				if(flag==false) System.out.println("Invalid Ticket!!");
				 
				 break;
			
			case 5:
			    System.out.println("Enter the ParkinngLotId :");
			    int parkingLotId = sc.nextInt();
			    System.out.println("Enter the noOfFloors :");
			    int noOfFloors = sc.nextInt();
			    System.out.println("Enter the noOfSlots :");
			    int noOfSlots = sc.nextInt();

			    parkingLot = createParkingLot(parkingLotId, noOfFloors, noOfSlots); 
			    break;

				
		    default:
		    	break;
			}
			System.out.println("Do you still wanna  continue press 1 or else -1 for exit");
			wish=sc.nextInt();			
			
			
		}while(wish==1);
		
		System.out.println("Exiting.......");
		sc.close();

	}
	private static ParkingLot createParkingLot(int parkingLotId, int noOfFloors, int noOfSlots) {
		ParkingLot parkingLot=new ParkingLot(parkingLotId);
		parkingLot.createParkingLotFloors(noOfFloors, noOfSlots);
		System.out.println("\nParking Lot Has been created successfully!!");
		return parkingLot;
		
	}
	public static void showMainMenu() {
		System.out.println("Function       		 Key");
		System.out.println("Add Floor        	  1 ");
		System.out.println("Add Slot        	  2 ");
		System.out.println("Park Vehicle     	  3 ");
		System.out.println("Unpark Vehicle  	  4 ");
		System.out.println("Create Parking Lot	  5 ");
		System.out.println("Exit             	  0 ");
	}
	public static void showSlotType() {
		System.out.println("Slot Type         Key");
		System.out.println("Bike               1 ");
		System.out.println("Car                2 ");
		System.out.println("Truck              3 ");
	}
	
	

}
