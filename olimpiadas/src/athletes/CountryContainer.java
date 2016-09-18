package athletes;

import java.io.BufferedReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeMap;

import main.Util;

/**
 * Classe que gurda todos os Países participantes em uma coleção
 */
public class CountryContainer{
	private TreeMap<Integer, Country> registered;
	
	public CountryContainer(){
		this.registered = new TreeMap<>();
	}
	
	/**
	 * Cria uma coleção de Países e preenche as informações a partir de um arquivo
	 * @param fileAddress local do arquivo de entrada
	 */
	public CountryContainer(String fileAddress){
		this();
		BufferedReader cursor = Util.getReader(fileAddress);
		String line, name;
		int id;
		do {
			line = Util.getLine(cursor);
			if(line != null) {
				id = Integer.parseInt(line.split(";")[0]);
				name = line.split(";")[1];
				this.insertCountry(id, name);
			}
		} while (line != null);
	}

	public void insertCountry(int id, String name){
		Country newCountry = new Country(name);
		registered.put(id,newCountry);
	}
	public Country getCountryById(int id){
		return registered.get(id);
	}
	
	@Override
	/*
	 * Imprime o quadro de medalhas.
	 */
	public String toString() {
		LinkedList<Country> countries = new LinkedList<>(this.registered.values());
		Collections.sort(countries, Collections.reverseOrder());
		String string = "Quadro de medalhas\n\n";
		string += "País       Ouro       Prata      Bronze\n";
		for (Country country : countries) {
			string += country.toString() + "\n";
		}
		return string;
	}
	
}