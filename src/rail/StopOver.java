package rail;

public class StopOver {
	private String arrivalTime;
	private String name;

	public StopOver(String name, String arrivalTime) {
		setArrivalTime(arrivalTime);
		setName(name);
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "\nStation name:" + name + "\nStopover arrival time is "
				+ arrivalTime;
	}

}
