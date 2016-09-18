package main;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import athletes.CountryContainer;
import sports.AbstractSport;
import sports.SportContainer;

/**
 * Classe responsável por processar as Estatísticas solicitadas
 */
public class Statistics {
	
	/**
	 * Imprime nos arquivos todas as Estatísticas solicitadas no arquivo de entrada
	 * @param fileName local do Arquivo que possui as chamadas das Estatísticas
	 * @param sports coleção de Esportes disputados
	 * @param countries coleção dos Países participantes
	 */
	public static void printAll(String fileName, SportContainer sports, CountryContainer countries) {
		BufferedReader br = Util.getReader(fileName);
		String line;
		int sportId;
		do {
			line = Util.getLine(br);
			if(line != null && line.contains(";")) {
				sportId = Integer.parseInt(line.split(";")[1]);
				print(sports.getSportById(sportId));
			} else {
				print(countries);
			}
		} while (line != null);
	}
	
	/**
	 * Imprime as estatísticas de um Esporte específico no arquivo
	 * @param sport Esporte cujas Estatísticas devem ser impressas
	 */
	private static void print(AbstractSport sport) {
		PrintWriter pw = new PrintWriter(createOutputFile(sport));
		pw.print(sport.toString());
		pw.close();
	}
	
	/**
	 * Imprime o quadro de medalhas em um arquivo de saída
	 * @param countries coleção de Países participantes
	 */
	private static void print(CountryContainer countries) {
		PrintWriter pw = new PrintWriter(createOutputFile());
		pw.print(countries.toString());
		pw.close();
	}
	
	/**
	 * Cria o arquivo de saída para Estatísticas de um Esporte
	 * @param sport Esporte que será impresso
	 * @return o Arquivo criado
	 */
	private static FileOutputStream createOutputFile(AbstractSport sport) {
		FileOutputStream file;
		String fileName;
		fileName = "estatistica-1-" + sport.getId() + ".txt"; 
		try {
			file = new FileOutputStream(fileName);
			return file;
		} catch (IOException e) {
			System.err.println("Não foi possível criar o arquivo.");
			return null;
		}	
	}
	
	/**
	 * Cria o arquivo de sáida para impressão do Quadro de Medalhas
	 * @return o arquivo criado
	 */
	private static FileOutputStream createOutputFile() {
		FileOutputStream file;
		String fileName;
		fileName = "estatistica-2.txt"; 
		try {
			file = new FileOutputStream(fileName);
			return file;
		} catch (IOException e) {
			System.err.println("Não foi possível criar o arquivo.");
			return null;
		}	
	}

}
