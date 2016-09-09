package projectfolder;

import java.util.Iterator;

public class Race extends AbstractSport {
	
	public Race() {
		super("Corrida");
	}

	@Override
	public double calculateScore(double[] timing) {
		return getLowerScore(timing);
	}


}
