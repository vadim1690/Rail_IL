package testing;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import rail.RidesAdmin;

public class searchRideByDepartureTimeTest {

	@Test
	public void test() throws FileNotFoundException {
		RidesAdmin testRides = new RidesAdmin();

		String departure = "Tel_aviv";
		String destination = "Beer_sheva";
		String time = "12:00";
		String space = "\n";

		String res = testRides.searchRideByDepartureTime(departure, destination, time, space);
		String expected = "Rides from Tel_Aviv to Beer_Sheva:\n" + "\n"
				+ "Ride from departure Station:Tel_Aviv, departure Time=12:00\n"
				+ "The destination Station: Beer_Sheva, arrival Time=16:50\n" + "\n"
				+ "Ride from departure Station:Tel_Aviv, departure Time=12:12\n"
				+ "The destination Station: Beer_Sheva, arrival Time=18:00\n" + "\n"
				+ "Ride from departure Station:Tel_Aviv, departure Time=12:30\n"
				+ "The destination Station: Beer_Sheva, arrival Time=14:10\n" + "\n"

		;

		assertEquals(expected, res);
	}

}
