package projectfolder;


public class Weight extends AbstractSport {
	public static final int ID = 3;
	
	public Weight() {
		super("Levantamento de Peso", ID);
	}

	@Override
	public double calculateScore(double[] weights) {
		return this.getTotalScore(weights);
	}

	@Override
	public boolean ascendingPodium() {
		return false;
	}


}
