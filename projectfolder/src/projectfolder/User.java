package projectfolder;

public class User {

	public static void main(String[] args) {
		SportsContainer sports = new SportsContainer();
		CountryContainer countries = new CountryContainer();
		AthleteContainer athletes = new AthleteContainer();
		getSports(sports,"esportes.txt");
		getCountries(countries,"paises.txt");
		getAthletesResults(athletes,sports,"atletas.txt");
		AbstractSport sport;
		for(int i=0; i<5; i++){
			sport = sports.getSportById(i);
			sport.awardMedals();
		}
		//abrir arquivo de estatisticas e gerar os dados
	}
	public void getSports(SportsContainer sports, String fileAdress){
		//
	}
	public void getCountries(CountryContainer countries ,String fileAdress){
		//
	}
	public void getAthletesResults(AthleteContainer athletes, SportsContainer sports, String fileAdress){
		//
	}

}
