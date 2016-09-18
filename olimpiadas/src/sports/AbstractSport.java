package sports;

import java.util.Collections;
import java.util.LinkedList;

import athletes.Athlete;
import athletes.Result;

public abstract class AbstractSport {
	private int id;
	private String name;
	private LinkedList<Result> results;
	
	public abstract double calculateScore(double scores[]);
	public abstract boolean ascendingPodium();
	
	public AbstractSport(String name, int id){
		this.name = name;
		this.id = id;
		this.results = new LinkedList<>();
	}

	public void insertCompetitorResult(Athlete athlete, double scores[]){
		double score;
		score = calculateScore(scores);
		Result newResult = new Result(athlete,score);
		results.addLast(newResult);
	}

	public String getName() {
		return name;
	}
	public int getId() {
		return this.id;
	}

	public void awardMedals() {
		Result result; 
		Athlete athlete;
		if (this.ascendingPodium()) {
			Collections.sort(this.results);
		} else {
			Collections.sort(this.results, Collections.reverseOrder());
		}
		for(int i=0;i<3;i+=1){
			result = results.get(i);
			athlete = result.getAthlete();
			athlete.getCountry().winMedal(i+1);
		}
	}	
	
	public double getLowerScore(double[] scores){
		double lower = scores[0];
		for(int i=1; i<scores.length; i++) if(lower>scores[i]) lower = scores[i];
		return lower;
	}

	public double getHigherScore(double[] scores){
		double greater = scores[0];
		for(int i=1; i<scores.length; i++) if(greater<scores[i]) greater = scores[i];
		return greater;
	}

	public double getAvgScore(double[] scores){
		double sum = 0;
		for(int i=0; i<scores.length; i++) sum = sum + scores[i];
		return sum/scores.length;
	}

	public double getTotalScore(double[] scores){
		double sum = 0;
		for(int i=0; i<scores.length; i++) sum = sum + scores[i];
		return sum;	
	}

	@Override
	public String toString() {
		String string = "";
		string += this.getName() + "\n\n";
		for (Result result : results) {
			string += String.format("%-10s %.2f\n", result.getAthlete().getName(), result.getScore());
		}
		return string;
	}
}
