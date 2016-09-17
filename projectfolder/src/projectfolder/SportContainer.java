package projectfolder;

import java.util.TreeMap;

public class SportContainer{
	private TreeMap<Integer, AbstractSport> registered;
	
	public SportContainer() {
		registered = new TreeMap<>();
	}

	public void insertSport(int id, String name){
		//it uses createSport cause the sport type may vary
		//its created a AbstractSports son, not an AbstractSport
		AbstractSport newSport = createSport(id,name);
		registered.put(id,newSport);
	}
	
	public void awardMedals() {
		for (AbstractSport sport : registered.values()) {
			sport.awardMedals();
		}
	}

	private AbstractSport createSport(int id, String name){
		switch(id){
			case Race.ID:
				Race race = new Race();
				return race;
			case Swimming.ID:
				Swimming swim = new Swimming();
				return swim;
			case Weight.ID:
				Weight weight = new Weight();
				return weight;
			case Jump.ID:
				Jump jump = new Jump();
				return jump;
			case Gymnastics.ID:
				Gymnastics gym = new Gymnastics();
				return gym;
		}		
		return null;
	}

	public AbstractSport getSportById(int id){
		return registered.get(id);
	}
	
	@Override
	public String toString() {
		String string = "";
		for (AbstractSport sport : registered.values()) {
			string += sport.toString() + "\n";
		}
		return string;
	}
 
}