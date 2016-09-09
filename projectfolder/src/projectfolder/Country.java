package projectfolder;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Country {
	private int id;
	private String name;
	private int gold;
	private int silver;
	private int bronze;
	
	private static HashMap<Integer, Country> registered = new HashMap<>();
	
	public static final int GOLD = 1;
	public static final int SILVER = 2;
	public static final int BRONZE = 3;
	
//	Class methods
	public static Country getCountryById(int id) {
		for (Country country : registered.values()) {
			if(country.getId() == id) {
				return country;
			}
		}
		return null;
	}
	
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
	
	public static void registerCountry(Country country) {
		if(!registered.containsKey(country.getId())) {
			registered.put(country.getId(), country);
		}
	}
	
	public static void medalBoard() {
		System.out.println("Quadro de medalhas\n");
		System.out.println("País Ouro Prata Bronze");
		for (Country country : registered.values()) {
			System.out.println(country.toString());
		}
	}
	
//	Instance methods
	public Country(int id, String strName) {
		this.id = id;
		this.name = strName;
		setGold(0);
		setSilver(0);
		setBronze(0);
	}
	
	public Country(String line) {
		this(Integer.parseInt(line.split(";")[0]), line.split(";")[1]);
	}
	
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public int getSilver() {
		return silver;
	}
	public void setSilver(int silver) {
		this.silver = silver;
	}
	public int getBronze() {
		return bronze;
	}
	public void setBronze(int bronze) {
		this.bronze = bronze;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public int winMedal(int type) {
		int medals = 0;
		switch (type) {
		case GOLD:
			medals = this.getGold();
			medals++;
			this.setGold(medals);
			break;
		case SILVER:
			medals = this.getSilver();
			medals++;
			this.setSilver(medals);
			break;
		case BRONZE:
			medals = this.getBronze();
			medals++;
			this.setBronze(medals);
			break;
		default:
			break;
		}
		return medals;
	}
	
	@Override
	public String toString() {
		return this.getName() + " " + this.getGold() + " " +
				this.getSilver() + " " + this.getBronze();
	}
		
}