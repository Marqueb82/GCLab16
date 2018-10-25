import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CountriesApp {
	// static scanner object
	private static Scanner scnr = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// GCLab16
		CountriesTextFile theCountries = new CountriesTextFile();
		List<Country> countries = theCountries.showCountries();
		int userSelection;
		String startPrompt = "Enter menu number: ";
		String menuPrompt = "Your selection: ";

		System.out.println("Welcome to the Countries Maintenance Application\n");

		do {
			System.out.println("1 - See the list of countries");
			System.out.println("2 - Add a country");
			System.out.println("3 - Exit\n");

			userSelection = FileValidator.userMenuChoice(scnr, startPrompt);

			switch (userSelection) {
			case 1:
				System.out.println("How would you like to view the list?");
				System.out.println("1 - unordered");
				System.out.println("2 - alphabetically");
				System.out.println("3 - numerically by population\n");
				int listSelection = FileValidator.userMenuChoice(scnr, menuPrompt);
				if (listSelection == 1) {
					displayCountries(countries);
				} else if (listSelection == 2) {
					alphabetizeCountries(countries);
				} else if (listSelection == 3) {
					numericOrganizeCountries(countries);
				}
				break;
			case 2:
				addCountry(scnr, theCountries);
				break;
			case 3:
				System.out.println("Thank you");
				System.exit(0);
			}
		} while (userSelection != 3);

	}

	/**
	 * @param countries
	 * @see prints countries based on population size
	 */
	private static void numericOrganizeCountries(List<Country> countries) {
		int i = 0;
		Collections.sort(countries, new OrganizeByPopulation()); // called sort method with OrganizeByPopulation--sort
																	// class
		for (Country c : countries) {
			i++;
			System.out.println(i + ". " + c.getName() + " pop is " + c.getPopulation());
		}
	}

	/**
	 * @param countries
	 * @see prints list in alphabetical order base on country name
	 */
	private static void alphabetizeCountries(List<Country> countries) {
		int i = 0;
		Collections.sort(countries, new OrganizeByName()); // called sort method with OrganizeByName--sort class
		for (Country c : countries) {
			i++;
			System.out.println(i + ". " + c.getName() + " pop is " + c.getPopulation());
		}
	}

	/**
	 * @param scnr
	 * @param theCountries
	 * @throws IOException
	 */
	private static void addCountry(Scanner scnr, CountriesTextFile theCountries) throws IOException {
		System.out.println("\nEnter name of country");
		String name = FileValidator.getCountryMatchToRegex(scnr);
		System.out.println("Enter population of country");
		int population = FileValidator.countryPopulationCheck(scnr);
		Country c = new Country(name, population);

		theCountries.addToFile(c);
	}

	/**
	 * @param countries
	 * @see displays txt file list
	 */
	private static void displayCountries(List<Country> countries) {
		int i = 0;
		for (Country c : countries) {
			i++;
			System.out.println(i + ". " + c.getName() + " pop is " + c.getPopulation());
		}
	}

}
