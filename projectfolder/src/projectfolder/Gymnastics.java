package projectfolder;


public class Gymnastics extends AbstractSport {
	
	public Gymnastics() {
		super("Ginástica artística");
	}

	@Override
	public double calculateScore(double[] scores) {
		return this.getAvgScore(scores);
	}

	@Override
	public boolean ascending_podium() {
		return false;
	}

}
