package main;

import java.io.BufferedReader;

import athletes.Athlete;
import athletes.Country;
import athletes.CountryContainer;
import sports.AbstractSport;
import sports.SportContainer;
import athletes.Result;


public class User {

	public static void main(String[] args) {
		SportContainer sports = new SportContainer("esportes.txt");
		CountryContainer countries = new CountryContainer("paises.txt");
		getAthletesResults(countries, sports, "atletas.txt");
		sports.awardMedals();
		Estatistica.printAll("estatisticas.txt", sports, countries);
		System.out.println("Arquivos gerados com sucesso.");
	}
	
	public static void getAthletesResults(CountryContainer countries, SportContainer sports, String fileAddress){
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
				athlete = new Athlete(idAthlete, name, country);
				scores = Result.parseResults(results.split("\\|"));
				sport.insertCompetitorResult(athlete, scores);
			}
		} while (line != null);
	}
}

