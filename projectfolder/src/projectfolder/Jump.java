package projectfolder;


public class Jump extends AbstractSport {
	public static final int ID = 4;
	
	public Jump() {
		super("Salto em altura", ID);
	}

	@Override
	public double calculateScore(double[] jumps) {
		return this.getHigherScore(jumps);
	}

	@Override
	public boolean ascendingPodium() {
		return false;
	}

}
