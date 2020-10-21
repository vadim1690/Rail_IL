package rail;

public class StopOver {
	private String arrivalTime;
	private int arrivalHour;
	private int arrivalMinutes;
	private String name;

	public StopOver(String name, String arrivalTime) {
		setArrivalTime(arrivalTime);
		setName(name);
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		String[] time = arrivalTime.split(":");
		arrivalHour = Integer.parseInt(time[0]);
		arrivalMinutes = Integer.parseInt(time[1]);
		this.arrivalTime = arrivalTime;
	}

	public String getName() {
		return name;
	}

	public int getArrivalHour() {
		return arrivalHour;
	}

	public int getArrivalMinutes() {
		return arrivalMinutes;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "\nStation name:" + name + "\nStopover arrival time is " + arrivalTime;
	}

}
