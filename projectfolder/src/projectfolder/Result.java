package projectfolder;

public class Result implements Comparable<Result>{
	private Athlete athlete;
	private double value;
	
	public Result(Athlete athlete, double value) {
		this.athlete = athlete;
		this.value = value;
	}

	public Athlete getAthlete() {
		return athlete;
	}

	public double getValue() {
		return value;
	}

	@Override
	public int compareTo(Result o) {
		return Double.compare(this.getValue(), o.getValue());
	}
	
	@Override
	public String toString() {
		return this.getSport().getName() + " - " + this.getAthlete().getName() + " - " + this.getValue();
	}
	
	
}
