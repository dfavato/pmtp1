package sports;

import java.io.BufferedReader;
import java.util.TreeMap;

import main.Util;

public class SportContainer{
	private TreeMap<Integer, AbstractSport> registered;
	
	public SportContainer() {
		registered = new TreeMap<>();
	}
	
	public SportContainer (String fileAddress){
		this();
		BufferedReader cursor = Util.getReader(fileAddress);
		String line, name;
		int id;
		do {
			line = Util.getLine(cursor);
			if(line != null) {
				id = Integer.parseInt(line.split(";")[0]);
				name = line.split(";")[1];
				this.insertSport(id, name);
			}
		} while (line != null);
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