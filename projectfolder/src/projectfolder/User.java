package projectfolder;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class User {

	public static void main(String[] args) {
		SportContainer sports;

		
		sports = getSports("esportes.txt");
		System.out.println(sports.toString());
		
		
	}
	
	static SportContainer getSports(String fileAddress){
		SportContainer sports = new SportContainer();
		BufferedReader cursor = getReader(fileAddress);
		String line, name;
		int id;
		do {
			line = getLine(cursor);
			if(line != null) {
				id = Integer.parseInt(line.split(";")[0]);
				name = line.split(";")[1];
				sports.insertSport(id, name);
			}
		} while (line != null);
		return sports;
	}
	
	static CountryContainer getCountries(String fileAdress){
		CountryContainer countries = new CountryContainer();
		return countries;
	}
	
	static AthleteContainer getAthletesResults(SportContainer sports, String fileAdress){
		AthleteContainer athletes = new AthleteContainer();
		return athletes;
	}
	
	private static BufferedReader getReader(String fileAddress) {
		BufferedReader br;
		try {
			br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(fileAddress)));
			return br;
		} catch (IOException e) {
			System.err.println("Não foi possível abrir o arquivo " + fileAddress);
			return null;
		}
	}
	
	private static String getLine(BufferedReader br) {
		try {
			return br.readLine();
		} catch (IOException e) {
			System.err.println("Não foi possível ler o arquivo");
			return null;
		}
	}

}
