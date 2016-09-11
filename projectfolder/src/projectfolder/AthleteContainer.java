package projectfolder;

public class AthleteContainer{
	private TreeMap<int, Athlete> registered;

	public void insertAthlete(int id, int name, Country country){
		Athlete newAthlete = new Athlete(id,name,country);
		registered.put(id,newAthlete);
	}
	public Athlete getAthleteById(int id){
		return registered.get(id);
	}
}