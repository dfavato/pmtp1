package projectfolder;

public class Country {
	private String name;
	private int gold = 0;
	private int silver = 0;
	private int bronze = 0;	
	
	public static final int GOLD = 1;
	public static final int SILVER = 2;
	public static final int BRONZE = 3;

//	Instance methods
	public Country(String strName) {
		this.name = strName;
	}
	
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public int getSilver() {
		return silver;
	}
	public void setSilver(int silver) {
		this.silver = silver;
	}
	public int getBronze() {
		return bronze;
	}
	public void setBronze(int bronze) {
		this.bronze = bronze;
	}
	public String getName() {
		return name;
	}
	
	public int winMedal(int type) {
		int medals = 0;
		switch (type) {
		case GOLD:
			medals = this.getGold();
			medals++;
			this.setGold(medals);
			break;
		case SILVER:
			medals = this.getSilver();
			medals++;
			this.setSilver(medals);
			break;
		case BRONZE:
			medals = this.getBronze();
			medals++;
			this.setBronze(medals);
			break;
		default:
			break;
		}
		return medals;
	}
	
	@Override
	public String toString() {
		return String.format("%-10s %-10d %-10d %-10d", this.getName(), this.getGold(), this.getSilver(), this.getBronze());
	}
		
}