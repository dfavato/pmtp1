package projectfolder;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public abstract class AbstractSport {
	private int id;
	private String name;
	private LinkedList<Result> results;
	private LinkedHashSet<Result> podium;
	
	private static HashMap<Integer, AbstractSport> sports;
	
	public static final int PODIUM_SIZE = 3;

//	Class methods
	public static void registerSport(AbstractSport sport) {
		if(!sports.containsKey(sport.getId())) {
			sports.put(sport.getId(), sport);
		}
	}
	
//	Instance methods
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public LinkedList<Result> getResults() {
		return results;
	}
	public LinkedHashSet<Result> getPodium() {
		return podium;
	}
	
	public void registerResult(Athlete athlete, double value) {
		this.results.add(new Result(this, athlete, value));
	}
	
	public void addAthletePodium(Result result) {
		this.podium.add(result);
	}
	
	public AbstractSport(String line) {
		this(Integer.parseInt(line.split(";")[0]), line.split(";")[1]);
	}

	public AbstractSport(int id, String name) {
		this.id = id;
		this.name = name;
		this.results = new LinkedList<>();
		this.podium = new LinkedHashSet<>();
	}
	
	public abstract void buildPodium();
	
	public void classifyResults(boolean ascending) {
		if(ascending) {
			Collections.sort(this.getResults());
		} else {
			Collections.sort(this.getResults(), Collections.reverseOrder());
		}
	}
	
	public void awardMedals() {
		Iterator<Result> results;
		
		this.buildPodium();
		results = this.getPodium().iterator();
		for (int i = Country.GOLD; i <= Country.BRONZE; i++) {
			if(results.hasNext()) {
				results.next().getAthlete().getCountry().winMedal(i);
			}
		}
	}
	
	@Override
	public String toString() {
		String string;
		string = this.getName() + "\nResultados:\n";
		for (Result result : results) {
			string += result.toString() + "\n";
		}
		return string;
	}

}
