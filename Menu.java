import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		String carBrandModel;
        int leaseStart;
        int leaseEnd;
        int monthlyCost;
		Lease[] leaseList = new Lease[99];
		int indexLease = 0;
		int sysCommand;
		Scanner nScanner=new Scanner(System.in);
		
		do {
		System.out.println("1. Create new Lease");
		System.out.println("2. Display all Leases");
		System.out.println("0. Exit");
		sysCommand = nScanner.nextInt();
		nScanner.nextLine();
		
		if((sysCommand < 0) || (sysCommand > 2)) {
			System.out.println("ERROR: Invalid Command.");
			System.out.println("Please, enter a valid command.");
			System.out.println("");
		}
		if(sysCommand == 1){
			System.out.println("Brand and Model:");
			carBrandModel = nScanner.nextLine();

			System.out.println("Lease Starts:");
			leaseStart = nScanner.nextInt();
			nScanner.nextLine();
			
			System.out.println("Lease Ends: ");
			leaseEnd = nScanner.nextInt();
			nScanner.nextLine();
			
			System.out.println("Monthly Cost: ");
			monthlyCost = nScanner.nextInt();
			nScanner.nextLine();
			
			leaseList[indexLease] = new Lease(carBrandModel, leaseStart, leaseEnd, monthlyCost);
			indexLease++;
			
			System.out.println("\nLease created!\n");
		}
		else if(sysCommand== 2){
			for(int i = 0; i < leaseList.length; i++) {
				if(leaseList[i] == null) {
					break;
				}
				leaseList[i].displayInfo();	
			}
			System.out.println("");
		}
		else if(sysCommand== 0){
			System.out.println("Terminating the program...");
		}
		} while(sysCommand != 0);
	}
}