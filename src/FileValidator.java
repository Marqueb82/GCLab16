import java.util.InputMismatchException;
import java.util.Scanner;

public class FileValidator {

	/**
	 * 
	 * @param scnr
	 * @param prompt
	 * @return returns validated int value for user menu selection
	 */
	public static int userMenuChoice(Scanner scnr, String prompt) {
		System.out.println(prompt);
		try {
			int num = scnr.nextInt();
			while (num < 0 || num > 3) {
				System.out.println("Choice are 1, 2 or 3. Re-enter: ");
				num = scnr.nextInt();
			}
			scnr.nextLine();
			return num;
		} catch (InputMismatchException e) {
			System.out.println("Use 1, 2 or 3 for menu selection");
			scnr.nextLine();
			return userMenuChoice(scnr, prompt);
		}
	}

	/**
	 * 
	 * @param scnr
	 * @return returns validated string based on regex
	 */
	public static String getCountryMatchToRegex(Scanner scnr) {
		boolean isValid = false;
		String input;
		String regex = "[A-Za-z]{4,20}";
		String regexTwo = "[A-Za-z ]{4,20}";
		do {
			input = scnr.nextLine();

			if (input.matches(regex) || input.matches(regexTwo)) {
				isValid = true;
			} else {
				System.out.println("Input must match the appropriate format.");
				isValid = false;
			}

		} while (!isValid);
		return input;
	}

	/**
	 * 
	 * @param scnr
	 * @return returns validated value which can be used for country population
	 */
	public static int countryPopulationCheck(Scanner scnr) {
		try {
			int num = scnr.nextInt();
			while (num < 0 || num > 2147483647) {
				System.out.println("Population must be positive and no more than 2147483647");
				num = scnr.nextInt();
			}
			scnr.nextLine();
			return num;
		} catch (InputMismatchException e) {
			System.out.println("Please enter valid value for population");
			scnr.nextLine();
			return countryPopulationCheck(scnr);
		}
	}

}
