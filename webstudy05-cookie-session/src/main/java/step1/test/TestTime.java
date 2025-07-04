package step1.test;

import java.util.Date;

public class TestTime {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date.toString());
		System.out.println(date.toString().replace(" ", "-"));
	}
}
