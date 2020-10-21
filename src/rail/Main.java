package rail;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner s = new Scanner(System.in);
		RidesAdmin admin = new RidesAdmin();
		String space = "\n";

		if (args.length > 0) {

			if (args[3].equalsIgnoreCase("HTML")) {
				space = "<br>";

			}
			String departureStation = args[0];
			String destinationStation = args[1];
			String departureTime = args[2];

			System.out.println(
					admin.searchRideByDepartureTime(departureStation, destinationStation, departureTime, space));
			return;
		}

		int choice;
		boolean fContinue = true;
		do {
			System.out.println("----------------------------------");
			System.out.println("Enter your choice :");
			System.out.println("1-Create new ride ");
			System.out.println("2-Show sorted rides ");
			System.out.println("3-Search train by departure time");
			System.out.println("4-Save rides into file");
			System.out.println("9-To exit");
			choice = s.nextInt();

			switch (choice) {
			case 1: {
				// Creating rides
				String departureStation;
				String departureTime;
				String destinationStation;
				String stopOver;
				String timeAtStopover;
				int answer;
				int numOfStopovers;
				String arrivalTime;
				ArrayList<StopOver> stopOvers;

				System.out.println("Enter departure station:");
				s.nextLine();
				departureStation = s.nextLine();

				System.out.println("Enter departure Time:");
				departureTime = s.nextLine();

				System.out.println("Enter destination station:");
				destinationStation = s.nextLine();

				System.out.println("Enter arrival Time:");
				arrivalTime = s.nextLine();

				System.out.println("If this ride has stopovers press 1, if not press 2");
				answer = s.nextInt();

				admin.addNewRide(departureStation, departureTime, destinationStation, arrivalTime);

				if (answer == 1) {
					System.out.println("How many stopovers this ride has? ");
					numOfStopovers = s.nextInt();
					stopOvers = new ArrayList<StopOver>(numOfStopovers);
					for (int i = 0; i < numOfStopovers; i++) {

						System.out.println("\nEnter stopover name: ");
						if (i == 0) {
							s.nextLine();
						}
						stopOver = s.nextLine();

						System.out.println("\nEnter arrival time at the stopover: ");

						timeAtStopover = s.nextLine();

						stopOvers.add(new StopOver(stopOver, timeAtStopover));

					}
					admin.addStopOver(stopOvers);

					System.out.println("The ride created successfully");
				}
				if (answer == 2) {
					System.out.println("The ride created successfully");
					break;
				}
				break;
			}
			case 2: {
				// Print all the rides
				admin.sortRides(admin.getRides());
				System.out.println(admin.toString());
				break;
			}

			case 3: {
				// Search train by departure station to the destination station
				// by departure time
				String destinationStation, departureTime, departureStation;

				System.out.println("Enter the departure station: ");
				s.nextLine();
				departureStation = s.nextLine();

				System.out.println("Enter the destination station: ");
				destinationStation = s.nextLine();

				System.out.println("Enter departure time: ");

				departureTime = s.nextLine();

				while (Integer.parseInt(departureTime.substring(0, 1)) < 0
						|| Integer.parseInt(departureTime.substring(0, 1)) > 23
						|| Integer.parseInt(departureTime.substring(3, 4)) < 0
						|| Integer.parseInt(departureTime.substring(3, 4)) > 59) {
					System.out.println("Wrong input try again");
					System.out.println("Enter departure time: ");
					s.nextLine();
					departureTime = s.nextLine();
				}

				admin.sortRides(admin.getRides());
				System.out
						.println(admin.searchRideByDepartureTime(departureStation, destinationStation, departureTime,space));

				break;
			}
			case 4: {
				// Saving rides into file
				admin.saveTheRidesIntoFile();
				System.out.println("Saving... \nThe file saved successfilly.");
				break;
			}
			case 9: {
				// When the user wants to exit by pressing 9
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
