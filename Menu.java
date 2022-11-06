import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Menu {

	public static void main(String[] args) {
        int carModelYear;
		ArrayList<Lease> leaseList = new ArrayList<Lease>();
		int index = -1;
		int sysCommand;
		Scanner nScanner = new Scanner(System.in);
		
		do {
			System.out.println("1. Create new Lease");
			System.out.println("2. Create new Lease with Model Year");
			System.out.println("3. Display all Leases");
			System.out.println("0. Exit");
			sysCommand = nScanner.nextInt();
			nScanner.nextLine();

			switch(sysCommand){
				case 0:
					System.out.println("Terminating the program...");
					nScanner.close();
					break;

				case 1:
					leaseList.add(new Lease());
					index += 1;
					System.out.println("Brand and Model:");
					leaseList.get(index).setCar(nScanner.nextLine());

					System.out.println("Lease Starts:");
					leaseList.get(index).setLeaseStart(nScanner.nextInt());
					nScanner.nextLine();
					
					System.out.println("Lease Ends: ");
					leaseList.get(index).setLeaseEnd(nScanner.nextInt());
					nScanner.nextLine();
					
					System.out.println("Monthly Cost: ");
					leaseList.get(index).setMonthlyCost(nScanner.nextInt());
					nScanner.nextLine();

					System.out.println("\nLease created!\n");
					break;

				case 2:
					System.out.println("Model Year:");
					carModelYear = nScanner.nextInt();
					nScanner.nextLine();
					leaseList.add(new Lease(carModelYear));
					index += 1;

					System.out.println("Brand and Model:");
					leaseList.get(index).setCar(nScanner.nextLine());

					System.out.println("Lease Starts:");
					leaseList.get(index).setLeaseStart(nScanner.nextInt());
					nScanner.nextLine();
					
					System.out.println("Lease Ends: ");
					leaseList.get(index).setLeaseEnd(nScanner.nextInt());
					nScanner.nextLine();
					
					System.out.println("Monthly Cost: ");
					leaseList.get(index).setMonthlyCost(nScanner.nextInt());
					nScanner.nextLine();

					System.out.println("\nLease created with model year as "+ carModelYear +"!\n");
					break;

				case 3:
					Iterator<Lease> iter = leaseList.iterator();
					while (iter.hasNext()) {
						iter.next().displayInfo();
					}
					System.out.println("");
					break;
				
				default: 
					System.out.println("ERROR: Invalid Command.");
					System.out.println("Please, enter a valid command.");
					System.out.println("");
					break;
			}
		} while(sysCommand != 0);
	}
}