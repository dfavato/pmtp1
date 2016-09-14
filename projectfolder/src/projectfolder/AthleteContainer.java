package projectfolder;

import java.util.TreeMap;

public class AthleteContainer{
	private TreeMap<Integer, Athlete> registered;

	public void insertAthlete(int id, String name, Country country){
		Athlete newAthlete = new Athlete(id,name,country);
		registered.put(id,newAthlete);
	}
	public Athlete getAthleteById(int id){
		return registered.get(id);
	}
}