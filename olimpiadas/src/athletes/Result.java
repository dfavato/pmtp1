package athletes;

/**
 *Classe responsável por armazenar as informações de Resultados dos atletas
 */
public class Result implements Comparable<Result>{
	private Athlete athlete;
	private double score;
	
	/**
	 * Construtor, liga um Atleta a seu resultado
	 * @param athlete responsável pelo resultado obtido em uma prova
	 * @param score valor do resultado
	 */
	public Result(Athlete athlete, double score) {
		this.athlete = athlete;
		this.score = score;
	}
	
	/**
	 * Método auxiliar que transforma os resultados informados no arquivo em 
	 * um arranjo de Double
	 * @param line linha que contém as String com os resultados
	 * @return os resultados como um arranjo de Double
	 */
	public static double[] parseResults(String[] line) {
		int i = 0;
		double results[] = new double[line.length];
		for (String s : line) {
			results[i] = Double.parseDouble(s.replace(',', '.'));
			i++;
		}
		return results;
	}

	/**
	 * @return Atleta responsável pelo resultado
	 */
	public Athlete getAthlete() {
		return athlete;
	}

	/**
	 * @return valor do resultado do Atleta
	 */
	public double getScore() {
		return score;
	}

	/**
	 * Método para classificar os resultados de acordo com:
	 * 1 - Valor do resultado
	 * 2 - Nome do Atleta
	 */
	@Override
	public int compareTo(Result o) {
		int scoreCompare;
		scoreCompare = Double.compare(this.getScore(), o.getScore());
		if(scoreCompare == 0) {
			return this.getAthlete().getName().compareTo(o.getAthlete().getName());
		} else {
			return scoreCompare;
		}
	}
	
	/**
	 * Retornar um string formatado com o nome do Atleta e o resultado
	 */
	@Override
	public String toString() {
		return this.getAthlete().getName() + " - " + this.getScore();
	}
	
	
}
