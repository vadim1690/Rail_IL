package rail;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		RidesAdmin admin = new RidesAdmin(10);

		int choice;
		boolean fContinue = true;
		do {
			System.out.println("Enter your choice :");
			System.out.println("1-New ride :");
			System.out.println("2-Show sorted rides ");
			System.out.println("9-To exit");
			choice = s.nextInt();

			switch (choice) {
			case 1: {
				String departureStation;
				String departureTime;
				String destinationStation;
				String arrivalTime;
				System.out.println("Enter departure station:");
				s.nextLine();
				departureStation = s.nextLine();

				System.out.println("Enter departure Time:");

				departureTime = s.nextLine();

				System.out.println("Enter destination station:");

				destinationStation = s.nextLine();

				System.out.println("Enter arrival Time:");

				arrivalTime = s.nextLine();

				admin.addNewRide(departureStation, departureTime, destinationStation, arrivalTime);

				break;
			}
			case 2: {
				admin.sortRides();
				for (int i = 0; i < admin.getNumberOfCurrentRides(); i++) {
					System.out.println(admin.getRides()[i].toString());

				}

				break;
			}

			case 9: {
				fContinue = false;
				break;
			}

			default: {
				System.out.println("Invalid option");
				break;
			}
			}

		} while (fContinue);
		s.close();
	}

}
