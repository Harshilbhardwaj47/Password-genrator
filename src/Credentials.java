package passwordgenrator;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Credentials implements Day {
	private static String fname;
	private static String sname;
	private static String fpin;

	Credentials() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your first name");
		fname = in.next();
		System.out.println("Enter your second name");
		sname = in.next();

		// System.out.println(pin(fname));
		fpin = pin(fname).substring(2, 6).toUpperCase();
		showinfo();

	}

	public static String pin(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");

			byte[] messageDigest = md.digest(input.getBytes());

			BigInteger no = new BigInteger(1, messageDigest);

			String hastext = no.toString(16);

			while (hastext.length() < 64) {
				hastext = "0" + hastext;
			}
			return hastext;

		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public static void showinfo() {
		System.out.println(sname.substring(0, 3).toLowerCase() + "@" + fname.substring(3, 4).toUpperCase() + fpin
				+ day.toString().substring(2, 4).toLowerCase());
	}
}
