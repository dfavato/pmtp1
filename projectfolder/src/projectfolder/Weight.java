package projectfolder;


public class Weight extends AbstractSport {
	
	public Weight() {
		super("Levantamento de Peso");
	}

	@Override
	public double calculateScore(double[] weights) {
		return this.getTotalScore(weights);
	}

	@Override
	public boolean ascending_podium() {
		return false;
	}


}
