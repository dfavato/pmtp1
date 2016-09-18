package main;

import java.io.BufferedReader;

import athletes.Athlete;
import athletes.AthleteContainer;
import athletes.Country;
import athletes.CountryContainer;
import sports.AbstractSport;
import sports.SportContainer;


public class User {

	public static void main(String[] args) {
		SportContainer sports = getSports("esportes.txt");
		CountryContainer countries = getCountries("paises.txt");
		getAthletesResults(countries, sports, "atletas.txt");

		
		sports.awardMedals();
		
		Estatistica.printAll("estatisticas.txt", sports, countries);
		
		
	}
	
	static SportContainer getSports(String fileAddress){
		SportContainer sports = new SportContainer();
		BufferedReader cursor = Util.getReader(fileAddress);
		String line, name;
		int id;
		do {
			line = Util.getLine(cursor);
			if(line != null) {
				id = Integer.parseInt(line.split(";")[0]);
				name = line.split(";")[1];
				sports.insertSport(id, name);
			}
		} while (line != null);
		return sports;
	}
	
	static CountryContainer getCountries(String fileAddress){
		CountryContainer countries = new CountryContainer();
		BufferedReader cursor = Util.getReader(fileAddress);
		String line, name;
		int id;
		do {
			line = Util.getLine(cursor);
			if(line != null) {
				id = Integer.parseInt(line.split(";")[0]);
				name = line.split(";")[1];
				countries.insertCountry(id, name);
			}
		} while (line != null);
		return countries;
	}
	
	static AthleteContainer getAthletesResults(CountryContainer countries, SportContainer sports, String fileAddress){
		AthleteContainer athletes = new AthleteContainer();
		Athlete athlete;
		BufferedReader cursor = Util.getReader(fileAddress);
		String line, name, results;
		int idAthlete, idCountry, idSport;
		Country country;
		AbstractSport sport;
		double scores[];
		do {
			line = Util.getLine(cursor);
			if(line != null) {
				idAthlete = Integer.parseInt(line.split(";")[0]);
				idCountry = Integer.parseInt(line.split(";")[1]);
				idSport = Integer.parseInt(line.split(";")[2]);
				name = line.split(";")[3];
				results = line.split(";")[4];
				
				sport = sports.getSportById(idSport);
				country = countries.getCountryById(idCountry);
				
				athlete = athletes.insertAthlete(idAthlete, name, country);
				scores = parseResults(results.split("\\|"));
				sport.insertCompetitorResult(athlete, scores);
			}
		} while (line != null);
		return athletes;
	}
	
	
	private static double[] parseResults(String[] line) {
		int i = 0;
		double results[] = new double[line.length];
		for (String s : line) {
			results[i] = Double.parseDouble(s.replace(',', '.'));
			i++;
		}
		return results;
	}

}
