package projectfolder;

public class Race extends AbstractSport {
	public Race() {
		super("Corrida");
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
