package main;

import java.io.BufferedReader;

import athletes.Athlete;
import athletes.Country;
import athletes.CountryContainer;
import sports.AbstractSport;
import sports.SportContainer;
import athletes.Result;

/**
 * Classe principal que oferece a interação com o usuário
 */
public class User {

	public static void main(String[] args) {
		SportContainer sports = new SportContainer("esportes.txt");
		CountryContainer countries = new CountryContainer("paises.txt");
		getAthletesResults(countries, sports, "atletas.txt");
		sports.awardMedals();
		Statistics.printAll("estatisticas.txt", sports, countries);
		System.out.println("Arquivos gerados com sucesso.");
	}
	
	/**
	 * Método responsável por processar o arquivo com os resultados
	 * Crias os atletas e adciona os resultados à cada Esporte
	 * @param countries Coleção de países participantes
	 * @param sports Coleção dos Esportes disputados
	 * @param fileAddress Local do arquivo de entrada com os resultados
	 */
	private static void getAthletesResults(CountryContainer countries, SportContainer sports, String fileAddress){
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

