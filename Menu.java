import java.util.Scanner;
import java.util.ArrayList;

public class Menu {

	public static void main(String[] args) {
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
					createLease(leaseList, index, sysCommand);
					break;

				case 2:
					System.out.println("Model Year:");
					leaseList.add(new Lease(nScanner.nextInt()));
					nScanner.nextLine();
					index += 1;
					createLease(leaseList, index, sysCommand);
					break;

				case 3:
					for (Lease lease : leaseList) {
						lease.displayInfo();
					}
					break;

				default:
					System.out.println("ERROR: Invalid Command.");
					System.out.println("Please, enter a valid command.\n");
					break;
			}
		} while(sysCommand != 0);
	}
	public static void createLease(ArrayList<Lease> list, int index, int command) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Brand and Model:");
		list.get(index).setCar(scanner.nextLine());

		System.out.println("Lease Starts:");
		list.get(index).setLeaseStart(scanner.nextInt());
		scanner.nextLine();

		System.out.println("Lease Ends: ");
		list.get(index).setLeaseEnd(scanner.nextInt());
		scanner.nextLine();
					
		System.out.println("Monthly Cost: ");
		list.get(index).setMonthlyCost(scanner.nextInt());
		scanner.nextLine();

		String s = "\nLease created!\n\n";
		if(command == 2){
			s = "\nLease created with model year as "+ list.get(index).getCar().getCarModelYear() +"!\n";
		}
		System.out.println(s);
	}
}