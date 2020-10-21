package rail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class RidesAdmin {

	private ArrayList<Ride> rides;
	private int numberOfCurrentRides;

	File ridesFile;

	public RidesAdmin() throws FileNotFoundException {
		this.rides = new ArrayList<Ride>();
		numberOfCurrentRides = 0;
		ridesFile = new File("/home/vadim/Rail_IL/Rides.txt");
		readRidesFile();

	}

	// pressing 1 will go to this function: Add rides
	public void addNewRide(String departureStation, String departureTime, String destinationStation,
			String arrivalTime) {

		rides.add(new Ride(departureStation, departureTime, destinationStation, arrivalTime));
		numberOfCurrentRides++;

	}

	// sorting rides by bubble sort with method split which happens after
	// pressing 2
	public void sortRides(ArrayList<Ride> tempRides) {
		for (int i = tempRides.size() - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {

				String[] parts1 = tempRides.get(j).getDepartureTime().split(":");
				String[] parts2 = tempRides.get(j + 1).getDepartureTime().split(":");

				int hours1 = Integer.parseInt(parts1[0]);
				int minutes1 = Integer.parseInt(parts1[1]);
				int hours2 = Integer.parseInt(parts2[0]);
				int minutes2 = Integer.parseInt(parts2[1]);
				if (hours1 > hours2) {
					Ride temp = tempRides.get(j);
					tempRides.set(j, tempRides.get(j + 1));
					tempRides.set(j + 1, temp);

				}
				// sorting the occasion which the hours are equal so it compares
				// the minutes
				if (minutes1 > minutes2 && hours1 == hours2) {
					Ride temp = tempRides.get(j);
					tempRides.set(j, tempRides.get(j + 1));
					tempRides.set(j + 1, temp);

				}
			}
		}

	}

	// Case 3
	public String searchRideByDepartureTime(String departureStation, String destinationStation, String departureTime,
			String space) {
		int counter = 0;
		String time[] = departureTime.split(":");
		int hour = Integer.parseInt(time[0]);
		int minutes = Integer.parseInt(time[1]);
		ArrayList<Ride> tempRides = new ArrayList<Ride>();

		for (int i = 0; i < rides.size(); i++) {
			if (rides.get(i).getDepartureStation().equalsIgnoreCase(departureStation)) {
				if ((hour == rides.get(i).getDepartureHour() && minutes <= rides.get(i).getDepartureMinutes())
						|| (hour < rides.get(i).getDepartureHour())) {
					if (rides.get(i).getDestinationStation().equalsIgnoreCase(destinationStation)) {
						tempRides.add(rides.get(i));

						continue;
					}
					for (int j = 0; j < rides.get(i).getStopOvers().size(); j++) {
						if (rides.get(i).getStopOvers().get(j).getName().equalsIgnoreCase(destinationStation)) {
							tempRides.add(subStringRide(rides.get(i), departureStation, destinationStation));
							break;
						}

					}
					continue;

				}

			}
			for (int j = 0; j < rides.get(i).getStopOvers().size(); j++) {
				if (rides.get(i).getStopOvers().get(j).getName().equalsIgnoreCase(departureStation)) {
					if (hour <= rides.get(i).getStopOvers().get(j).getArrivalHour()
							&& minutes <= rides.get(i).getStopOvers().get(j).getArrivalMinutes()) {
						if (rides.get(i).getDestinationStation().equalsIgnoreCase(destinationStation)) {
							tempRides.add(subStringRide(rides.get(i), departureStation, destinationStation));
							break;
						}
						for (int j2 = j; j2 < rides.get(i).getStopOvers().size(); j2++) {
							if (rides.get(i).getStopOvers().get(j2).getName().equalsIgnoreCase(destinationStation)) {
								tempRides.add(subStringRide(rides.get(i), departureStation, destinationStation));
								break;
							}
						}

					}
				}
			}

		}

		sortRides(tempRides);

		return sortHelper(tempRides, space);

	}

	private Ride subStringRide(Ride ride, String departureStation, String destinationStation) {
		String departure = null;
		String destination = null;
		String departureTime = null;
		String destinationTime = null;

		for (int i = 0; i < ride.getStopOvers().size(); i++) {
			if (departureStation.equalsIgnoreCase(ride.getStopOvers().get(i).getName())) {
				departure = ride.getStopOvers().get(i).getName();
				departureTime = ride.getStopOvers().get(i).getArrivalTime();
			}
			if (ride.getDepartureStation().equalsIgnoreCase(departureStation)) {
				departure = ride.getDepartureStation();
				departureTime = ride.getDepartureTime();
			}
			if (ride.getDestinationStation().equalsIgnoreCase(destinationStation)) {
				destination = ride.getDestinationStation();
				destinationTime = ride.getArrivalTime();
			}
			if (destinationStation.equalsIgnoreCase(ride.getStopOvers().get(i).getName())) {
				destination = ride.getStopOvers().get(i).getName();
				destinationTime = ride.getStopOvers().get(i).getArrivalTime();
			}

		}

		Ride r = new Ride(departure, departureTime, destination, destinationTime);

		return r;
	}

	private String sortHelper(ArrayList<Ride> tempRides, String space) {

		StringBuffer sbRides = new StringBuffer();
		int counter = 0;
		if (tempRides.size() <= 0) {
			sbRides.append("No rides matched to the search");
			return sbRides.toString();
		}
		sbRides.append("Rides from " + tempRides.get(0).getDepartureStation() + " to "
				+ tempRides.get(0).getDestinationStation() + ":");
		sbRides.append(space);
		sbRides.append(space);
		for (int i = 0; i < tempRides.size(); i++) {

			sbRides.append(tempRides.get(i).toString());
			sbRides.append(space);
			counter++;
			if (counter == 3) {
				break;
			}
		}

		return sbRides.toString();
	}

	// 4 - Saving rides into file
	public void saveTheRidesIntoFile() throws FileNotFoundException {
		PrintWriter program = new PrintWriter(ridesFile);

		for (int i = 0; i < numberOfCurrentRides; i++) {
			program.println(rides.get(i).getDepartureStation());
			program.println(rides.get(i).getDestinationStation());
			program.println(rides.get(i).getDepartureTime());
			program.println(rides.get(i).getArrivalTime());
			if (rides.get(i).getStopOvers() != null) {
				program.println(rides.get(i).getStopOvers().size());
				for (int j = 0; j < rides.get(i).getStopOvers().size(); j++) {
					program.println(rides.get(i).getStopOvers().get(j).getName());
					program.println(rides.get(i).getStopOvers().get(j).getArrivalTime());
				}
			} else {
				program.println(0);
			}
			program.println();
		}
		program.close();

	}

	// Read Rides File
	public void readRidesFile() throws FileNotFoundException {
		Scanner scan = new Scanner(ridesFile);
		if (ridesFile.exists()) {
			while (scan.hasNext()) {
				String departureStation = scan.nextLine();
				String destinationStation = scan.nextLine();
				String departureTime = scan.nextLine();
				String arrivalTime = scan.nextLine();

				addNewRide(departureStation, departureTime, destinationStation, arrivalTime);

				int numberOfStopovers = scan.nextInt();
				scan.nextLine();
				if (numberOfStopovers != 0) {
					ArrayList<StopOver> stopovers = new ArrayList<StopOver>(numberOfStopovers);
					for (int i = 0; i < numberOfStopovers; i++) {
						String name = scan.nextLine();
						String arrivalTimeToStopover = scan.nextLine();
						stopovers.add(new StopOver(name, arrivalTimeToStopover));
					}
					addStopOver(stopovers);
				}
				scan.nextLine();
			}
			scan.close();
		}

	}

	public void addStopOver(ArrayList<StopOver> stopovers) {
		rides.get(numberOfCurrentRides - 1).addStopOver(stopovers);
	}

	public ArrayList<Ride> getRides() {
		return rides;
	}

	public int getNumberOfCurrentRides() {
		return numberOfCurrentRides;
	}

	public String toString() {

		StringBuffer sbAdmin = new StringBuffer("\nRides list: ");
		for (int i = 0; i < numberOfCurrentRides; i++) {
			sbAdmin.append("\n****************************************************");
			sbAdmin.append("\n\nRide number " + (i + 1) + ": \n");
			sbAdmin.append(rides.get(i).toString());
		}
		return sbAdmin.toString();
	}
}
