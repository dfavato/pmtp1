package athletes;

public class Result implements Comparable<Result>{
	private Athlete athlete;
	private double score;
	
	public Result(Athlete athlete, double score) {
		this.athlete = athlete;
		this.score = score;
	}
	
	public static double[] parseResults(String[] line) {
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
