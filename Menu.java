import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Menu {
	static ArrayList<Lease> leaseList = new ArrayList<>();
	static ArrayList<Insurance> insuranceList = new ArrayList<>();
	static ExtraServices Type1_service = new ExtraServices("1",200);
	static ExtraServices Type2_service = new ExtraServices("2",100);

	public static void main(String[] args) {
		int sysCommand;
		Scanner nScanner = new Scanner(System.in);
		MainMenuGUI mainMenuGUI = new MainMenuGUI();
		//MainMenuGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainMenuGUI.setSize(800,600);
		mainMenuGUI.setVisible(true);
		/*do {
			System.out.println("1. Create new Lease");
			System.out.println("2. Create new Short Term Lease");
			System.out.println("3. Create new Long Term Lease");
			System.out.println("4. Display all Leases sorted by the car model year");
			System.out.println("5. Display Lease Price");
			System.out.println("6. Calculate Insurances");
			System.out.println("0. Exit");
			sysCommand = nScanner.nextInt();
			nScanner.nextLine();

			switch(sysCommand){
				case 0:
					System.out.println("Terminating the program...");
					nScanner.close();
					break;

				case 1: // Ordinary Lease - Monthly
					leaseList.add(createLease(1));
					break;

				case 2: // ShortTermLease - Daily
					leaseList.add(createLease(2));
					break;

				case 3: // LongTermLease - Yearly
					leaseList.add(createLease(3));
					break;
				case 4:
					System.out.println("1. Ascending Order");
					System.out.println("2. Descending Order");
					int order = nScanner.nextInt();
					nScanner.nextLine();
					if (order == 1){
						Collections.sort(leaseList);
					}
					else if (order == 2){
						leaseList.sort(Collections.reverseOrder());
					}
					for (Lease lease : leaseList) {
						lease.displayInfo();
					}
					break;

				case 5:
					Scanner scanner = new Scanner(System.in);
					System.out.println("Please enter car lease owner id:");
					String OwnerId = scanner.nextLine();
					String s = "Your lease cost is " + calculateCost(OwnerId) + "TL\n";
					System.out.println(s);
					break;

				case 6:
					for (Insurance i : insuranceList){
						if(i instanceof Lease){
							System.out.println("Insurance for " + ((Lease) i).getCar().getCarBrandModel()
									+ " is " + i.makeInsurance());
						}
						else if(i instanceof ExtraServices){
							System.out.println("Insurance for Service Type " + ((ExtraServices) i).getType()
									+ " is " + i.makeInsurance());
						}
						}
					System.out.println();
					break;

				default:
					System.out.println("ERROR: Invalid Command.");
					System.out.println("Please, enter a valid command.\n");
					break;
			}
		} while(sysCommand != 0);*/
	}
	public static Lease createLease(int command) {
		Scanner scanner = new Scanner(System.in);
		Lease lease;
		if(command == 2){
			lease = new ShortTermLease();
		}
		else if(command == 3){
			lease = new LongTermLease();
		}
		else{
			lease = new Lease();
		}

		System.out.println("\nLease Owner ID:");
		lease.setLeaseId(scanner.nextLine());

		boolean continueLoop = true;
		do {
			try {
				int modelYear;
				System.out.println("Model Year:");
				modelYear = scanner.nextInt();
				scanner.nextLine();
				lease.setCar(modelYear);
				continueLoop = false;
			}
			catch (InputMismatchException e){
				scanner.nextLine();
				System.out.println("\nPlease enter the model year correctly!");
			}
		}while(continueLoop);

		int modelYear = lease.getCarYear();
		for(LeasePrice l : LeasePrice.values()){
			if( (l.getLowerLimit() <= modelYear) && (modelYear < l.getUpperLimit() )){
				lease.setMonthlyCost(l.getPrice());
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

		System.out.println("Do you want extra services? yes/no");
		String temp = (scanner.nextLine()).toLowerCase();
		if(temp.equalsIgnoreCase("yes") || temp.equalsIgnoreCase("y")){
			System.out.println("Please enter type. (1 or 2)");
			String type = scanner.nextLine();
			if(type.equals("1")){
				lease.setExtraServices(Type1_service);
			}
			else if(type.equals("2")){
				lease.setExtraServices(Type2_service);
			}
			else {//if type is not valid, type is settled to type 1 by default (to the one whose cost is more)
				lease.setExtraServices(Type1_service);
			}
		}
		else if(temp.equalsIgnoreCase("no") || temp.equalsIgnoreCase("n")) {
			lease.setExtraServices(null);
		}
		String s = "\nLease created with model year as "+ lease.getCar().getCarModelYear() +"!\n";
		System.out.println(s);

		insuranceList.add(lease);
		if(lease.getExtraServices() != null){
			insuranceList.add(lease.getExtraServices());
		}
		return lease;
	}

	public static double calculateCost(String OwnerId) {
		for (Lease lease : leaseList) {
			if(OwnerId.equals(lease.getLeaseId())){
				if(lease.getExtraServices() != null){
					System.out.print("Including Extra Services ");
					return (lease.calculateTotalPrice() + lease.getExtraServices().getCost());
				}
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
