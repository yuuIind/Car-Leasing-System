import java.util.Scanner;
import java.util.ArrayList;

public class Menu {
	static ArrayList<Lease> leaseList = new ArrayList<Lease>();

	public static void main(String[] args) {
		int sysCommand;
		Scanner nScanner = new Scanner(System.in);
		
		do {
			System.out.println("1. Create new Lease");
			System.out.println("2. Create new Lease with Model Year");
			System.out.println("3. Display all Leases");
			System.out.println("4. Display Lease Price");
			System.out.println("0. Exit");
			sysCommand = nScanner.nextInt();
			nScanner.nextLine();

			switch(sysCommand){
				case 0:
					System.out.println("Terminating the program...");
					nScanner.close();
					break;

				case 1:
					leaseList.add(createLease(1));
					break;

				case 2:
					leaseList.add(createLease(2));
					break;

				case 3:
					for (Lease lease : leaseList) {
						lease.displayInfo();
					}
					break;

				case 4:
					/*System.out.println("Lease price table\n");
					for(LeasePrice l : LeasePrice.values()){
						System.out.println("\tCars with model year between "
						+ l.getLowerLimit() + " and " + ((l.getUpperLimit() != -1) ? (l.getUpperLimit()-1):"above")
						+ ": $" + l.getPrice() + " per month\n");
					}*/
					Scanner scanner = new Scanner(System.in);
					System.out.println("Please enter car lease owner id:");
					String OwnerId = scanner.nextLine();
					String s = "Your lease cost is " + calculateCost(OwnerId) + "TL\n";
					System.out.println(s);
					break;

				default:
					System.out.println("ERROR: Invalid Command.");
					System.out.println("Please, enter a valid command.\n");
					break;
			}
		} while(sysCommand != 0);
	}
	public static Lease createLease(int command) {
		Scanner scanner = new Scanner(System.in);
		Lease lease = new Lease();

		System.out.println("Lease Owner ID:");
		lease.setLeaseId(scanner.nextLine());

		if(command == 2){
			System.out.println("Model Year:");
			int modelYear = scanner.nextInt();
			scanner.nextLine();
			lease.setCar(modelYear);
			for(LeasePrice l : LeasePrice.values()){
				if( (l.getLowerLimit() <= modelYear) && (modelYear < l.getUpperLimit() )){
					lease.setMonthlyCost(l.getPrice());
				}
			}
		}

		System.out.println("Brand and Model:");
		lease.setCar(scanner.nextLine());

		System.out.println("Lease Starts:");
		lease.setLeaseStart(scanner.nextInt());
		scanner.nextLine();

		System.out.println("Lease Ends: ");
		lease.setLeaseEnd(scanner.nextInt());
		scanner.nextLine();

		if(command == 1) {
			System.out.println("Monthly Cost: ");
			lease.setMonthlyCost(scanner.nextInt());
			scanner.nextLine();
		}

		String s = "\nLease created!\n\n";
		if(command == 2){
			s = "\nLease created with model year as "+ lease.getCar().getCarModelYear() +"!\n";
		}
		System.out.println(s);

		return lease;
	}

	public static int calculateCost(String OwnerId) {
		for (Lease lease : leaseList) {
			if(OwnerId.equals(lease.getLeaseId())){
				return lease.calculateTotalPrice();
			}
		}
		return 0;
	}
}

enum LeasePrice {
	UPTO2003(1950,2003, 500),
	UPTO2009(2003, 2009, 1000),
	UPTO2012(2009, 2012, 1500),
	UPTO2018(2012, 2018, 2000),
	UPTO2022(2018, 2022, 2500),
	UPTO2027(2022,-1,3000);

	private final int lowerLimit;
	private final int upperLimit;
	private final int price;
	LeasePrice(int lowerLimit, int upperLimit, int price){
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
		this.price = price;
	}

	public int getLowerLimit() {
		return lowerLimit;
	}

	public int getUpperLimit() {
		return upperLimit;
	}

	public int getPrice() {
		return price;
	}
}
