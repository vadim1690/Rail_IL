package rail;

public class RidesAdmin {

	private Ride[] rides;
	private int numberOfCurrentRides;

	public RidesAdmin(int maxNumberOfRides) {
		this.rides = new Ride[maxNumberOfRides];
		numberOfCurrentRides = 0;

	}

	// pressing 1 will go to this function
	public boolean addNewRide(String departureStation, String departureTime,
			String destinationStation, String arrivalTime) {
		if (numberOfCurrentRides >= rides.length) {
			return false;
		}
		rides[numberOfCurrentRides++] = new Ride(departureStation,
				departureTime, destinationStation, arrivalTime);

		return true;

	}

	// sorting rides by bubble sort with method split which happens after
	// pressing 2
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
				// sorting the occasion which the hours are equal so it compares
				// the minutes
				if (minutes1 > minutes2 && hours1 == hours2) {
					Ride temp = rides[j];
					rides[j] = rides[j + 1];
					rides[j + 1] = temp;

				}
			}
		}

	}

	public String searchRideByArrivalTime(String departureStation,
			String destinationStation, String arrivalTime) {
		StringBuffer sbArrive = new StringBuffer("Rides from "
				+ departureStation + " to " + destinationStation
				+ " arrives till: " + arrivalTime);
		int countRides = 0;
		for (int i = 0; i < rides.length; i++) {
			if (rides[i] != null && countRides < 3) {
				if (rides[i].getDepartureStation().equals(departureStation)
						&& rides[i].getDestinationStation().equals(
								destinationStation)) {

					String[] parts1 = rides[i].getArrivalTime().split(":");
					String[] parts2 = arrivalTime.split(":");

					int hours1 = Integer.parseInt(parts1[0]);
					int minutes1 = Integer.parseInt(parts1[1]);
					int hours2 = Integer.parseInt(parts2[0]);
					int minutes2 = Integer.parseInt(parts2[1]);

					if (hours1 < hours2) {
						sbArrive.append("\n****************************************************");
						sbArrive.append("\n" + rides[i].toString() + "\n");
						countRides++;

					}
					if (hours1 == hours2 && minutes1 <= minutes2) {
						sbArrive.append("\n****************************************************");
						sbArrive.append("\n" + rides[i].toString() + "\n");
						countRides++;

					}

				}
			}
		}
		if (countRides == 0) {
			return "** No rides **";
		} else
			return sbArrive.toString();
	}

	public String searchRideByDepartureTime(String departureStation,
			String destinationStation, String departureTime) {
		StringBuffer sbDeparture = new StringBuffer("Rides from "
				+ departureStation + " to " + destinationStation
				+ " arrives after: " + departureTime);
		int countRides = 0;
		for (int i = 0; i < rides.length; i++) {
			if (rides[i] != null && countRides < 3) {
				if (rides[i].getDepartureStation().equals(departureStation)
						&& rides[i].getDestinationStation().equals(
								destinationStation)) {

					String[] parts1 = rides[i].getArrivalTime().split(":");
					String[] parts2 = departureTime.split(":");

					int hours1 = Integer.parseInt(parts1[0]);
					int minutes1 = Integer.parseInt(parts1[1]);
					int hours2 = Integer.parseInt(parts2[0]);
					int minutes2 = Integer.parseInt(parts2[1]);

					if (hours1 > hours2) {
						sbDeparture
								.append("\n****************************************************");
						sbDeparture.append("\n" + rides[i].toString() + "\n");
						countRides++;
					}
					if (hours1 == hours2 && minutes1 <= minutes2) {
						sbDeparture
								.append("\n****************************************************");
						sbDeparture.append("\n" + rides[i].toString() + "\n");
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

	public void addStopOver(StopOver[] stopovers) {
		rides[numberOfCurrentRides - 1].addStopOver(stopovers);
	}

	public Ride[] getRides() {
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
			sbAdmin.append(rides[i].toString());
		}
		return sbAdmin.toString();
	}
}
