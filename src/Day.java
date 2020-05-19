package passwordgenrator;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public interface Day {
	static DayOfWeek day = day();

	public static DayOfWeek day() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your Birth-Month");
		int mm = in.nextInt();
		System.out.println("Enter your Birth-Date");
		int dd = in.nextInt();
		System.out.println("Enter your Birth-Year");
		int yy = in.nextInt();

		in.close();
		LocalDate dt = LocalDate.of(yy, mm, dd);
		DayOfWeek day = dt.getDayOfWeek();
		return day;
	}
}
