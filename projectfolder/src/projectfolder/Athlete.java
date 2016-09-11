package projectfolder;

public class Athlete {
	private int id;
	private Country country;
	private String name;
	
	public Athlete(int id, String name, Country country) {
		this.id = id;
		this.name = name;
		this.country = country;
	}
/*	
	public Athlete(String line) {
		this(
				Integer.parseInt(line.split(";")[0]), 					//Atleta id
				line.split(";")[3],										//Atleta nome
				Country.getCountryById(Integer.parseInt(line.split(";")[1]))	//Pais
			);
	}
*/
	public int getId() {
		return id;
	}

	public Country getCountry() {
		return country;
	}

	public String getName() {
		return name;
	}
}
