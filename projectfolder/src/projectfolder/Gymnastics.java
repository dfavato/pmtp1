package projectfolder;


public class Gymnastics extends AbstractSport {
	public static final int ID = 5;
	
	public Gymnastics() {
		super("Ginástica artística", ID);
	}

	@Override
	public double calculateScore(double[] scores) {
		return this.getAvgScore(scores);
	}

	@Override
	public boolean ascendingPodium() {
		return false;
	}

}
