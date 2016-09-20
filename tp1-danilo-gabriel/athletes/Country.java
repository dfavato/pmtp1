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
	
	public String getName() {
		return this.name;
	}
	
	public int getMedal(int type) {
		switch (type) {
		case GOLD:
			return this.gold;
		case SILVER:
			return this.silver;
		case BRONZE:
			return this.bronze;
		default:
			return 0;
		}
	}
	
	private int addMedal(int type) {
		switch (type) {
		case GOLD:
			this.gold++;
			break;
		case SILVER:
			this.silver++;
			break;
		case BRONZE:
			this.bronze++;
			break;
		}
		return this.getMedal(type);
	}
	
	/**
	 * Adciona medalhas para delegação de determinado País.
	 * @param type 0 = Ouro, 1 = Prata, 2 = Bronze
	 * @return o número de medalhas daquele tipo que o País possui
	 */
	public int winMedal(int type) {
		return this.addMedal(type);
	}
	
	@Override
	public String toString() {
		return String.format("%-10s %-10d %-10d %-10d", this.getName(), this.getMedal(GOLD), this.getMedal(SILVER), this.getMedal(BRONZE));
	}

	/**
	 * Método que ordena os Países no quadro de medalhas de acordo
	 * com o número e o tipo de medalhas
	 */
	@Override
	public int compareTo(Country o) {
		int compare;
		compare = this.getMedal(GOLD) - o.getMedal(GOLD);
		if(compare == 0) {
			compare = this.getMedal(SILVER) - o.getMedal(SILVER);
			if(compare == 0) {
				compare = this.getMedal(BRONZE) - o.getMedal(BRONZE);
				if(compare == 0){
					compare = this.getName().compareTo(o.getName());
				}
			}
		}
		return compare;
	}
		
}