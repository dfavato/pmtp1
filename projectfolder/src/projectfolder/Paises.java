package projectfolder;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Paises {
	private HashMap<Integer, Pais> inscritos = new HashMap<>();
	
	public Pais getPaisById(int id) {
		for (Pais pais : inscritos.values()) {
			if(pais.getId() == id) {
				return pais;
			}
		}
		return null;
	}
	
	public void registrarFromFile(String file) {
		BufferedReader br;
		String line;
		try {
			br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(file)));
			do {
				line = br.readLine();
				if (line != null) {
					registrarPais(new Pais(line));
				}
			} while (line != null);
			br.close();
		} catch (IOException e) {
			System.err.println("Não foi possível abrir o arquivo " + file);
		}
		
	}
	
	public void registrarPais(Pais pais) {
		if(!inscritos.containsKey(pais.getId())) {
			inscritos.put(pais.getId(), pais);
		}
	}
	
	public void quadroMedalhas() {
		System.out.println("Quadro de medalhas\n");
		System.out.println("País Ouro Prata Bronze");
		for (Pais pais : inscritos.values()) {
			System.out.println(pais.toString());
		}
	}
}
