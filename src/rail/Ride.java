package rail;

public class Ride {

	private String departureStation;
	private String departureTime;
	private String destinationStation;
	private String arrivalTime;
	private StopOver[] stopovers;

	public Ride(String departureStation, String departureTime,
			String destinationStation, String arrivalTime) {

		setArrivalTime(arrivalTime);
		setDepartureStation(departureStation);
		setDepartureTime(departureTime);
		setDestinationStation(destinationStation);
	}

	public void addStopOver(StopOver[] stopovers) {
		this.stopovers = stopovers;

	}

	public String getDepartureStation() {
		return departureStation;
	}

	private void setDepartureStation(String departureStation) {
		this.departureStation = departureStation;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	private void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getDestinationStation() {
		return destinationStation;
	}

	private void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	private void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public StopOver[] getStopOvers() {
		return stopovers;
	}

	@Override
	/*
	 * public String toString() { return + "\nStopovers: " + "\n" +
	 * Arrays.toString(stopovers) ; }
	 */
	public String toString() {

		StringBuffer sbRides = new StringBuffer("Ride from departure Station:"
				+ departureStation + ", departure Time=" + departureTime + "\n"
				+ "The destination Station: " + destinationStation
				+ ", arrival Time=" + arrivalTime);
		if (stopovers != null) {
			sbRides.append("\n\nThe stopovers from " + departureStation
					+ " to " + destinationStation + ": ");
			for (int i = 0; i < stopovers.length; i++) {
				sbRides.append("\n\nStopover number " + (i + 1) + ": ");
				sbRides.append(stopovers[i].toString());
			}
		}
		return sbRides.toString();
	}

}
