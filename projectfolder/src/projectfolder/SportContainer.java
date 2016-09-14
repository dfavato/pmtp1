package projectfolder;

import java.util.TreeMap;

public class SportContainer{
	private TreeMap<Integer, AbstractSport> registered;
	private static final int RACE = 1;	
	private static final int SWIMMING = 2;
	private static final int WEIGHT = 3;
	private static final int JUMP = 4;
	private static final int GYMNASTICS = 5;

	public void insertSport(int id, String name){
		//it uses createSport cause the sport type may vary
		//its created a AbstractSports son, not an AbstractSport
		AbstractSport newSport = createSport(id,name);
		registered.put(id,newSport);
	}

	private AbstractSport createSport(int id, String name){
		switch(id){
			case RACE:
				Race race = new Race();
				return race;
			case SWIMMING:
				Swimming swim = new Swimming();
				return swim;
			case WEIGHT:
				Weight weight = new Weight();
				return weight;
			case JUMP:
				Jump jump = new Jump();
				return jump;
			case GYMNASTICS:
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