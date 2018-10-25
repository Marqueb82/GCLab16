import java.util.Comparator;

class OrganizeByName implements Comparator<Country> {

	@Override
	public int compare(Country a, Country b) {
		// compares one country name to another country name--return in alphabetical
		// order
		return a.getName().compareTo(b.getName());
	}

}
