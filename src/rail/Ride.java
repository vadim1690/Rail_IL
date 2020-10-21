package rail;

import java.util.ArrayList;

public class Ride {

	private String departureStation;
	private int departureHour;
	private int departureMinutes;
	private String destinationStation;
	private String departureTime;
	private String arrivalTime;
	private int arrivalHour;
	private int arrivalMinutes;
	private ArrayList<StopOver> stopovers;

	public Ride(String departureStation, String departureTime,
			String destinationStation, String arrivalTime) {
		setDepartureTime(departureTime);
		
		this.arrivalTime=arrivalTime;
		this.departureTime=departureTime;
		
		stopovers=new ArrayList<StopOver>();

		setArrivalTime(arrivalTime);
		setDepartureStation(departureStation);
		setDepartureTime(departureTime);
		setDestinationStation(destinationStation);
	}

	public void addStopOver(ArrayList<StopOver> stopovers) {
		this.stopovers = stopovers;

	}
	

	public int getDepartureHour() {
		return departureHour;
	}

	public int getDepartureMinutes() {
		return departureMinutes;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public int getArrivalHour() {
		return arrivalHour;
	}

	public int getArrivalMinutes() {
		return arrivalMinutes;
	}

	public void setStopovers(ArrayList<StopOver> stopovers) {
		this.stopovers = stopovers;
	}

	public String getDepartureStation() {
		return departureStation;
	}

	private void setDepartureStation(String departureStation) {
		this.departureStation = departureStation;
	}

	

	private void setDepartureTime(String departureTime) {
	String time[]=	departureTime.split(":");
	departureHour=Integer.parseInt(time[0]);
	departureMinutes=Integer.parseInt(time[1]);
	
	}

	public String getDestinationStation() {
		return destinationStation;
	}

	private void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}

	

	private void setArrivalTime(String arrivalTime) {
		String time[]=	arrivalTime.split(":");
		arrivalHour=Integer.parseInt(time[0]);
		arrivalMinutes=Integer.parseInt(time[1]);
	}

	public ArrayList<StopOver> getStopOvers() {
		return stopovers;
	}

	
	public String toString() {

		StringBuffer sbRides = new StringBuffer("Ride from departure Station:"
				+ departureStation + ", departure Time=" + departureTime + "\n"
				+ "The destination Station: " + destinationStation
				+ ", arrival Time=" + arrivalTime+"\n");
		if (stopovers.size()!=0) {
			sbRides.append("\n\nThe stopovers from " + departureStation
					+ " to " + destinationStation + ": ");
			for (int i = 0; i < stopovers.size(); i++) {
				sbRides.append("\n\nStopover number " + (i + 1) + ": ");
				sbRides.append(stopovers.get(i).toString()+"\n");
			}
		}
		return sbRides.toString();
	}

}
