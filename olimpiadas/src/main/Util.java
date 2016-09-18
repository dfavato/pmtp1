package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Funções utilitárias que ajudam na manipulação de arquivos
 */
public class Util {
	public static BufferedReader getReader(String fileAddress) {
		BufferedReader br;
		try {
			br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(fileAddress)));
			return br;
		} catch (IOException e) {
			System.err.println("Não foi possível abrir o arquivo " + fileAddress);
			return null;
		}
	}
	
	public static String getLine(BufferedReader br) {
		try {
			return br.readLine();
		} catch (IOException e) {
			System.err.println("Não foi possível ler o arquivo");
			return null;
		}
	}

}
