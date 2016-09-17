package projectfolder;

public class Result implements Comparable<Result>{
	private Athlete athlete;
	private double score;
	
	public Result(Athlete athlete, double score) {
		this.athlete = athlete;
		this.score = score;
	}

	public Athlete getAthlete() {
		return athlete;
	}

	public double getScore() {
		return score;
	}

	@Override
	public int compareTo(Result o) {
		int score_compare;
		score_compare = Double.compare(this.getScore(), o.getScore());
		if(score_compare == 0) {
			return this.getAthlete().getName().compareTo(o.getAthlete().getName());
		} else {
			return score_compare;
		}
	}
	
	@Override
	public String toString() {
		return this.getAthlete().getName() + " - " + this.getScore();
	}
	
	
}
