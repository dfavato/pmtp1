package projectfolder;

import java.util.TreeMap;

public class SportContainer{
	private TreeMap<int, AbstractSport> registered;
	private static final int RACE = 1;	
	private static final int SWIMMING = 2;
	private static final int WEIGHT = 3;
	private static final int JUMP = 4;
	private static final int GYMNASTICS = 5;

	public void insertSport(int id, int name){
		//it uses createSport cause the sport type may vary
		//its created a AbstractSports son, not an AbstractSport
		AbstractSport newSport = createSport(id,name);
		registered.put(id,newSport);
	}

	private AbstractSport createSport(int id, int name){
		switch(id){
			case RACE:
				Race race = new Race();
				return race;
				break;
			case SWIMMING:
				Swimming swim = new Simming();
				return swim;
				break;
			case WEIGHT:
				Weight weight = new Weight();
				return weight;
				break;
			case JUMP:
				Jump jump = new Jump();
				return jump;
				break;
			case GYMNASTICS:
				Gymnastics gym = new Gymnastics();
				return gym;
				break;
		}		
		return NULL;
	}

	public AbstractSport getSportById(int id){
		return registered.get(id);
	}
 
}