package rail;

public class Ride {

	private String departureStation;
	private String departureTime;
	private String destinationStation;
	private String arrivalTime;

	public Ride(String departureStation, String departureTime, String destinationStation, String arrivalTime) {

		setArrivalTime(arrivalTime);
		setDepartureStation(departureStation);
		setDepartureTime(departureTime);
		setDestinationStation(destinationStation);
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

	@Override
	public String toString() {
		return "Ride from departure Station:" + departureStation + ", departure Time=" + departureTime + "\n"
				+ "The destination Station: " + destinationStation + ", arrival Time=" + arrivalTime + "\n";
	}

}
