package rail;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RidesAdmin {

	private Ride[] rides;
	private int numberOfCurrentRides;

	public RidesAdmin(int maxNumberOfRides) {

		this.rides = new Ride[maxNumberOfRides];

		numberOfCurrentRides = 0;
	}

	public boolean addNewRide(String departureStation, String departureTime, String destinationStation,
			String arrivalTime) {
		if (numberOfCurrentRides >= rides.length) {
			return false;
		}
		rides[numberOfCurrentRides++] = new Ride(departureStation, departureTime, destinationStation, arrivalTime);

		return true;

	}

	public Ride[] getRides() {
		return rides;
	}

	private void setRides(Ride[] rides) {
		this.rides = rides;
	}

	public int getNumberOfCurrentRides() {
		return numberOfCurrentRides;
	}

	private void setNumberOfCurrentRides(int numberOfCurrentRides) {
		this.numberOfCurrentRides = numberOfCurrentRides;
	}

	public void sortRides() {
		for (int i = numberOfCurrentRides - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {

				String[] parts1 = rides[j].getDepartureTime().split(":");
				String[] parts2 = rides[j + 1].getDepartureTime().split(":");

				int hours1 = Integer.parseInt(parts1[0]);
				int minutes1 = Integer.parseInt(parts1[1]);
				int hours2 = Integer.parseInt(parts2[0]);
				int minutes2 = Integer.parseInt(parts2[1]);
				if (hours1 > hours2) {
					Ride temp = rides[j];
					rides[j] = rides[j + 1];
					rides[j + 1] = temp;

				}
				if (minutes1 > minutes2 && hours1 == hours2) {
					Ride temp = rides[j];
					rides[j] = rides[j + 1];
					rides[j + 1] = temp;

				}
			}
		}

	}

	/*
	 * public String printAllRides() {
	 * 
	 * return Arrays.toString(rides); }
	 */

}
