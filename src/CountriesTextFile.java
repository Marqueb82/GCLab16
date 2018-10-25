import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountriesTextFile {

	private static Path filePath = Paths.get("file-countryFolder/countries/myCountries.txt");
	Country country;

	CountriesTextFile() {
	}

	public List<Country> showCountries() throws IOException {

		try {
			List<String> lines = Files.readAllLines(filePath);
			List<Country> countries = new ArrayList<>();
			for (String line : lines) {
				String[] parts = line.split("\t\t");
				Country c = new Country();
				c.setName(parts[0]);
				c.setPopulation(Integer.parseInt(parts[1]));
				countries.add(c);
			}
			return countries;
		} catch (NoSuchFileException ex) {
			return new ArrayList<>();
		} catch (IOException ex) {
			ex.printStackTrace();
			return new ArrayList<>();
		}

	}

	public void addToFile(Country country) throws IOException {

		if (Files.notExists(filePath)) {
			Files.createFile(filePath);
		}

		String line = country.getName() + "\t\t" + country.getPopulation();
		List<String> lines = Arrays.asList(line);
		Files.write(filePath, lines, StandardOpenOption.APPEND);
	}

	public void rewriteFile(List<String> items) throws IOException {
		if (Files.notExists(filePath)) {
			Files.createFile(filePath);
		}

		// ** Example of rewriting a whole file
		Files.write(filePath, items, StandardOpenOption.TRUNCATE_EXISTING);
	}

}
