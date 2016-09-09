package projectfolder;

public class Result implements Comparable<Result>{
	private AbstractSport sport;
	private Athlete athlete;
	private double value;
	
	public Result(AbstractSport sport, Athlete athlete, double value) {
		this.sport = sport;
		this.athlete = athlete;
		this.value = value;
	}

	public AbstractSport getSport() {
		return sport;
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
