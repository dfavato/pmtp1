package sports;

import java.io.BufferedReader;
import java.util.TreeMap;

import main.Util;

/**
 * Classe responsável por guradar os Esportes disputados
 */
public class SportContainer{
	private TreeMap<Integer, AbstractSport> registered;
	
	/**
	 * Cria uma coleção de Esportes vazia
	 */
	public SportContainer() {
		registered = new TreeMap<>();
	}
	
	/**
	 * Cria uma coleção de Esportes e preenche com os registros do
	 * arquivo passado como parâmetros
	 * @param fileAddress local do arquivo que armazena os registros dos Esportes
	 */
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
	

	/**
	 * Insere um Esporte na coleção
	 * @param id do Esporte
	 * @param name nome do Esporte
	 */
	public void insertSport(int id, String name){
		//Como o Esporte pode variar a função createSporte é usada na inicialização
		AbstractSport newSport = createSport(id);
		registered.put(id,newSport);
	}
	
	/**
	 * Distribui as medalhas para cada um dos Esportes da coleção
	 */
	public void awardMedals() {
		for (AbstractSport sport : registered.values()) {
			sport.awardMedals();
		}
	}

	/**
	 * Cria um descendente de AbstractSport dependendo do id informada
	 * @param id do Esporte a ser criado
	 * @param name nome do Esporte a ser criado
	 * @return um descendente de AbstractSport
	 */
	private AbstractSport createSport(int id){
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

	/**
	 * @param id do Esporte
	 * @return o Esporte com o id informado
	 */
	public AbstractSport getSportById(int id){
		return registered.get(id);
	}
	
	/**
	 * Imprime todos os Esportes da coleção
	 */
	@Override
	public String toString() {
		String string = "";
		for (AbstractSport sport : registered.values()) {
			string += sport.toString() + "\n";
		}
		return string;
	}
 
}