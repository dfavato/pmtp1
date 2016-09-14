package projectfolder;


public class Swimming extends AbstractSport {
	
	public Swimming() {
		super("Natação");
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
