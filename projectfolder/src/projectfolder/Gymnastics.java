package projectfolder;

import java.util.Iterator;

public class Gymnastics extends AbstractSport {
	
	public Gymnastics() {
		super("Ginástica artística");
	}

	@Override
	public double calculateScore(double[] scores) {
		return getHigherScore(scores);
	}

}
