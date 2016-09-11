package projectfolder;

import java.util.Iterator;

public class Swimming extends AbstractSport {
	
	public Swimming() {
		super("Natação");
	}

	@Override
	public double calculateScore(double[] timing) {
		return this.getLowerScore(timing);
	}


}
