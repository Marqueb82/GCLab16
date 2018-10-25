import java.util.Comparator;

class OrganizeByPopulation implements Comparator<Country> {

	@Override
	public int compare(Country a, Country b) {
		// compare one country population to another country population--return based on
		// population size
		return b.getPopulation() - a.getPopulation();
	}

}
