package projectfolder;


public class Jump extends AbstractSport {
	
	public Jump() {
		super("Salto em altura");
	}

	@Override
	public double calculateScore(double[] jumps) {
		return this.getHigherScore(jumps);
	}

	@Override
	public boolean ascending_podium() {
		return false;
	}

}
