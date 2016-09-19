package sports;

import java.util.Collections;
import java.util.LinkedList;

import athletes.Athlete;
import athletes.Country;
import athletes.Result;

/**
 * Classe abstrata para implementação de um Esporte
 */
public abstract class AbstractSport {
	private int id;
	private String name;
	private LinkedList<Result> results;
	
	/**
	 * Método necessário para que o resultado de um Esporte seja calculado corretamente
	 * depende do tipo de Esporte disputado
	 * @param scores um vetor de doubles com cada um dos resultados alcançados por um atleta
	 * @return a medida de resumo que será utilizada para contrução da classificação do atleta no Esporte
	 */
	public abstract double calculateScore(double scores[]);
	
	/**
	 * Alguns Esportes são baseados no MENOR resultado (Corrida), enquanto outros no MAIOR (Salto em Altura)
	 * @return se o Esporte classifica os atletas por resultados Crescente ou Decrescentemente
	 */
	public abstract boolean ascendingPodium();
	
	public AbstractSport(String name, int id){
		this.name = name;
		this.id = id;
		this.results = new LinkedList<>();
	}

	/**
	 * Insere o resultado de um Atleta na lista de Resultados desse Esporte
	 * @param athlete Atleta responsável pelo resultado
	 * @param scores resultados Individuais obtidos pelo Atleta
	 */
	public void insertCompetitorResult(Athlete athlete, double scores[]){
		double score;
		score = calculateScore(scores);
		Result newResult = new Result(athlete,score);
		results.addLast(newResult);
	}

	public String getName() {
		return name;
	}
	public int getId() {
		return this.id;
	}

	/**
	 * Distribui as medalhas para os países dos 3 primeiros classificados
	 */
	public void awardMedals() {
		Result result; 
		Athlete athlete;
		if (this.ascendingPodium()) {
			Collections.sort(this.results);
		} else {
			Collections.sort(this.results, Collections.reverseOrder());
		}
		for(int i=Country.GOLD;i<=Country.BRONZE;i+=1){
			result = results.get(i);
			athlete = result.getAthlete();
			athlete.getCountry().winMedal(i);
		}
	}	
	
	//Métodos que resumem os resultados individuais em uma medida única utilizada na classificação
	public double getLowerScore(double[] scores){
		double lower = scores[0];
		for(int i=1; i<scores.length; i++) if(lower>scores[i]) lower = scores[i];
		return lower;
	}

	public double getHigherScore(double[] scores){
		double greater = scores[0];
		for(int i=1; i<scores.length; i++) if(greater<scores[i]) greater = scores[i];
		return greater;
	}

	public double getAvgScore(double[] scores){
		double sum = 0;
		for(int i=0; i<scores.length; i++) sum = sum + scores[i];
		return sum/scores.length;
	}

	public double getTotalScore(double[] scores){
		double sum = 0;
		for(int i=0; i<scores.length; i++) sum = sum + scores[i];
		return sum;	
	}

	@Override
	public String toString() {
		String string = "";
		string += this.getName() + "\n\n";
		for (Result result : results) {
			string += result.toString();
		}
		return string;
	}
}
