package projectfolder;

public class User {

	public static void main(String[] args) {
		Country.registerFromFile("paises.txt");
		Race corrida = new Race(1);
		Athlete kws = new Athlete(1, "Kawasaki", Country.getCountryById(1));
		corrida.registerResult(kws, 10.78);
		corrida.awardMedals();
		System.out.println(corrida.toString());
		Country.medalBoard();
		
	}

}
