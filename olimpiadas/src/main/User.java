package main;

import athletes.CountryContainer;
import sports.SportContainer;
import athletes.Result;


public class User {

	public static void main(String[] args) {
		SportContainer sports = new SportContainer("esportes.txt");
		CountryContainer countries = new CountryContainer("paises.txt");
		Result.getAthletesResults(countries, sports, "atletas.txt");
		sports.awardMedals();
		Estatistica.printAll("estatisticas.txt", sports, countries);
	}
}
