package sports;


public class Swimming extends AbstractSport {
	public static final int ID = 2;
	
	public Swimming() {
		super("Natação", ID);
	}

	@Override
	public double calculateScore(double[] timing) {
		return this.getLowerScore(timing);
	}

	@Override
	public boolean ascendingPodium() {
		return true;
	}


}
