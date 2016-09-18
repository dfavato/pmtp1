package athletes;

/**
 * Classe responsável por gerir as informações dos Países
 */
public class Country implements Comparable<Country>{
	private String name;
	private int gold = 0;
	private int silver = 0;
	private int bronze = 0;	
	
	public static final int GOLD = 0;
	public static final int SILVER = 1;
	public static final int BRONZE = 2;

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
	
	/**
	 * Adciona medalhas para delegação de determinado País.
	 * @param type 1 = Ouro, 2 = Prata, 3 = Bronze
	 * @return o número de medalhas daquele tipo que o País possui
	 */
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

	/**
	 * Método que ordena os Países no quadro de medalhas de acordo
	 * com o número e o tipo de medalhas
	 */
	@Override
	public int compareTo(Country o) {
		int compare;
		compare = this.getGold() - o.getGold();
		if(compare == 0) {
			compare = this.getSilver() - o.getSilver();
			if(compare == 0) {
				compare = this.getBronze() - o.getBronze();
			}
		}
		return compare;
	}
		
}