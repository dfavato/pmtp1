package projectfolder;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Pais {
	private int id;
	private String nome;
	private int ouro;
	private int prata;
	private int bronze;
	
	private static HashMap<Integer, Pais> inscritos = new HashMap<>();
	
//	Class methods
	public static Pais getPaisById(int id) {
		for (Pais pais : inscritos.values()) {
			if(pais.getId() == id) {
				return pais;
			}
		}
		return null;
	}
	
	public static void registrarFromFile(String file) {
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
	
	public static void registrarPais(Pais pais) {
		if(!inscritos.containsKey(pais.getId())) {
			inscritos.put(pais.getId(), pais);
		}
	}
	
	public static void quadroMedalhas() {
		System.out.println("Quadro de medalhas\n");
		System.out.println("País Ouro Prata Bronze");
		for (Pais pais : inscritos.values()) {
			System.out.println(pais.toString());
		}
	}
	
//	Instance methods
	public Pais(int id, String nome) {
		this.id = id;
		this.nome = nome;
		setOuro(0);
		setPrata(0);
		setBronze(0);
	}
	
	public Pais(String line) {
		this(Integer.parseInt(line.split(";")[0]), line.split(";")[1]);
	}
	
	public int getOuro() {
		return ouro;
	}
	public void setOuro(int ouro) {
		this.ouro = ouro;
	}
	public int getPrata() {
		return prata;
	}
	public void setPrata(int prata) {
		this.prata = prata;
	}
	public int getBronze() {
		return bronze;
	}
	public void setBronze(int bronze) {
		this.bronze = bronze;
	}
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		return this.getNome() + " " + this.getOuro() + " " +
				this.getPrata() + " " + this.getBronze();
	}
		
}
