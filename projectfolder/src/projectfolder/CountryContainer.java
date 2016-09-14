package projectfolder;

import java.util.TreeMap;

public class CountryContainer{
	private TreeMap<Integer, Country> registered;
	
	public CountryContainer(){
		this.registered = new TreeMap<>();
	}

	public void insertCountry(int id, String name){
		Country newCountry = new Country(name);
		registered.put(id,newCountry);
	}
	public Country getCountryById(int id){
		return registered.get(id);
	}
	
	public void medalBoard() {
		System.out.println("Quadro de medalhas\n");
		System.out.println("País Ouro Prata Bronze");
		for (Country country : registered.values()) {
			System.out.println(country.toString());
		}
	}
	
	@Override
	public String toString() {
		String string = "";
		for (Country country : registered.values()) {
			string += country.toString() + "\n";
		}
		return string;
	}
	
/*
	public static void registerFromFile(String file) {
		BufferedReader br;
		String line;
		try {
			br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(file)));
			do {
				line = br.readLine();
				if (line != null) {
					registerCountry(new Country(line));
				}
			} while (line != null);
			br.close();
		} catch (IOException e) {
			System.err.println("Não foi possível abrir o arquivo " + file);
		}
	}
*/	
	
	
}