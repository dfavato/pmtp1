package projectfolder;

import java.util.Collections;
import java.util.LinkedList;

public abstract class AbstractSport {
	private String name;
	private LinkedList<Result> results;
	public static final int PODIUM_SIZE = 3;
	
	public AbstractSport(String name){
		this.name = name;
	}

	public void insertCompetitorResult(Athlete athlete, double score){
		Result newResult = new Result(athlete,score);
		results.addLast(newResult);
	}

	public abstract double calculateScore();

	public String getName() {
		return name;
	}	

	public void awardMedals() {
		Result result; 
		Athlete athlete;
		Collections.sort(this.results);
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
		//(?)
		return this.toString();
	}
}
