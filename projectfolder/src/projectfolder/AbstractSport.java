package projectfolder;

import java.util.TreeMap;

public abstract class AbstractSport {
	private String name;
	private TreeMap<double, Athlete> registered;
	public static final int PODIUM_SIZE = 3;
	
	public void AbstractSport(String name){
		this.name = name;
	}

	public abstract double calculateScore();
	
	public double getLowerScore(double[] scores){
		int lower = scores[0];
		for(int i=1; i<scores.lenght; i++) if(lower>scores[i]) lower = scores[i];
		return lower;
	}

	public double getHigherScore(double[] scores){
		int greater = scores[0];
		for(int i=1; i<scores.lenght; i++) if(greater<scores[i]) greater = scores[i];
		return greater;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}	

	public void awardMedals() {
		//pegar os três primeiros de registered e dá medalhas pros paises
	}	
	
	@Override
	public String toString() {
		//(?)
	}
}
