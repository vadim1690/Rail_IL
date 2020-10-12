package rail_browser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import rail.Ride;

public class Main_browser {

	public static void main(String[] args) throws FileNotFoundException {
		File ridesForBrowser = new File("/home/rivka/Rail_IL/Rides_For_Browser.txt");
		ArrayList<Ride> rides = new ArrayList<Ride>();
		Scanner scan = new Scanner(ridesForBrowser);

		if (ridesForBrowser.exists()) {
			while (scan.hasNext()) {

				String departureStation = scan.nextLine();
				String destinationStation = scan.nextLine();
				String departureTime = scan.nextLine();
				String arrivalTime = scan.nextLine();
				
				
				rides.add(new Ride(departureStation, departureTime, destinationStation, arrivalTime));
				scan.nextLine();
				}
							
			}
			scan.close();

		String departureStation = args[0];
		String destinationStation = args[1];
		String departureTime = args[2];
		
		System.out.println(searchRideByDepartureTime(rides, departureStation, destinationStation, departureTime));

	}

	public static String searchRideByDepartureTime(ArrayList<Ride> rides, String departureStation,
			String destinationStation, String departureTime) {
		StringBuffer sbDeparture = new StringBuffer("Rides from " + departureStation + " to " + destinationStation
				+ " arrives after " + departureTime + "  :");
		int countRides = 0;
		String partsRideTime[], partsRequestedTime[];
		for (int i = 0; i < rides.size(); i++) {
			if (rides.get(i) != null && countRides < 3) {
				if (rides.get(i).getDepartureStation().equalsIgnoreCase(departureStation)
						&& rides.get(i).getDestinationStation().equalsIgnoreCase(destinationStation)) {

					partsRideTime = rides.get(i).getArrivalTime().split(":");
					partsRequestedTime = departureTime.split(":");

					int hoursRideTime = Integer.parseInt(partsRideTime[0]);
					int minutesRideTime = Integer.parseInt(partsRideTime[1]);
					int hoursRequestedTime = Integer.parseInt(partsRequestedTime[0]);
					int minutesRequestedTime = Integer.parseInt(partsRequestedTime[1]);

					// Finding suitable ride
					if (hoursRideTime > hoursRequestedTime) {
						sbDeparture.append("<br>****************************************************");
						sbDeparture.append("<br>" + rides.get(i).toString() + "\n");
						countRides++;
					}

					// Finding suitable ride
					if (hoursRideTime == hoursRequestedTime && minutesRideTime <= minutesRequestedTime) {
						sbDeparture.append("<br>****************************************************");
						sbDeparture.append("<br>" + rides.get(i).toString() + "\n");
						countRides++;
					}
				}
			}
		}
				
			
		
		if (countRides == 0) {
			return "** No rides **";
		} else
			return sbDeparture.toString();
	}

}
