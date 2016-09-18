package athletes;

import java.util.TreeMap;

public class AthleteContainer{
	private TreeMap<Integer, Athlete> registered;
	
	public AthleteContainer() {
		this.registered = new TreeMap<>();
	}

	public Athlete insertAthlete(int id, String name, Country country){
		Athlete newAthlete = new Athlete(id,name,country);
		registered.put(id,newAthlete);
		return newAthlete;
	}
	public Athlete getAthleteById(int id){
		return registered.get(id);
	}
	
	@Override
	public String toString() {
		String string = "";
		for (Athlete athlete : registered.values()) {
			string += athlete.toString() + "\n";
		}
		return string;
	}
}