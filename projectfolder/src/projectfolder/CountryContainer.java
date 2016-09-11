package projectfolder;

public class CountryContainer{
	private TreeMap<int, Country> registered;

	public void insertCountry(int id, int name){
		Country newCountry = new Country(id,name);
		registered.put(id,newCountry);
	}
	public Country getCountryById(int id){
		return registered.get(id);
	}
}