package projectfolder;

import java.util.Iterator;

public class Race extends AbstractSport {
	
	public Race(int id) {
		super(id, "Corrida");
	}

	@Override
	public void buildPodium() {
		//TODO e se o atleta tiver mais de 3 corridas? Quais considerar? E se um atleta tiver os 3 melhores tempos?
		Iterator<Result> results;
		int count_podium = 0;
		
		results = this.getResults().iterator();
		this.classifyResults(true); //true = ascendente -> do menor para o maior
		do {
			if(results.hasNext()) {
				this.addAthletePodium(results.next());
				count_podium++;
			}
		} while (results.hasNext() && count_podium < PODIUM_SIZE);
	}


}
