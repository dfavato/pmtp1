package athletes;

import java.io.BufferedReader;

import main.Util;
import sports.AbstractSport;
import sports.SportContainer;

public class Result implements Comparable<Result>{
	private Athlete athlete;
	private double score;
	
	public Result(Athlete athlete, double score) {
		this.athlete = athlete;
		this.score = score;
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
				scores = parseResults(results.split("\\|"));
				sport.insertCompetitorResult(athlete, scores);
			}
		} while (line != null);
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

	public Athlete getAthlete() {
		return athlete;
	}

	public double getScore() {
		return score;
	}

	@Override
	public int compareTo(Result o) {
		int scoreCompare;
		scoreCompare = Double.compare(this.getScore(), o.getScore());
		if(scoreCompare == 0) {
			return this.getAthlete().getName().compareTo(o.getAthlete().getName());
		} else {
			return scoreCompare;
		}
	}
	
	@Override
	public String toString() {
		return this.getAthlete().getName() + " - " + this.getScore();
	}
	
	
}
