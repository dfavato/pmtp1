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
		return Double.compare(this.getScore(), o.getScore());
	}
	
	@Override
	public String toString() {
		return this.getAthlete().getName() + " - " + this.getScore();
	}
	
	
}
