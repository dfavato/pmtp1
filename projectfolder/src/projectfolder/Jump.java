package projectfolder;

import java.util.Iterator;

public class Jump extends AbstractSport {
	
	public Jump() {
		super("Salto em altura");
	}

	@Override
	public double calculateScore(double[] jumps) {
		return this.getHigherScore(jumps);
	}

}
