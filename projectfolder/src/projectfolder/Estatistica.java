package projectfolder;

import java.io.FileOutputStream;

public class Estatistica {
	private int type;
	private AbstractSport sport;
	
	public Estatistica(int type, AbstractSport sport) {
		this.type = type;
		this.sport = sport;
	}
	
	public Estatistica(int type, int idSport, SportContainer sports) {
		this(type, sports.getSportById(idSport));
	}
	
	public int getType() {
		return this.type;
	}
	
	public AbstractSport getSport() {
		return this.sport;
	}
	
	private FileOutputStream createOutputFile() {
		FileOutputStream file;
		file = new FileOutputStream("estatistica-" + this.getType() + "-" + this.getSport().getId());
	}

}
