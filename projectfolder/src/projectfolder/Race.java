package projectfolder;


public class Race extends AbstractSport {
	public static final int ID = 1;
	
	public Race() {
		super("Corrida", ID);
	}

	@Override
	public double calculateScore(double[] timing) {
		return this.getLowerScore(timing);
	}

	@Override
	public boolean ascending_podium() {
		return true;
	}


}
