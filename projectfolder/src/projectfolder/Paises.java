package projectfolder;

import java.util.HashMap;

public class Paises {
	private static HashMap<Integer, Pais> inscritos = new HashMap<>();
	
	public static Pais getPaisById(int id) {
		for (Pais pais : inscritos.values()) {
			if(pais.getId() == id) {
				return pais;
			}
		}
		return null;
	}
	
	public static void registrarPais(Pais pais) {
		if(!inscritos.containsKey(pais.getId())) {
			inscritos.put(pais.getId(), pais);
		}
	}
	
	public static void quadroMedalhas() {
		System.out.println("Quadro de medalhas\n\n");
		System.out.println("País Ouro Prata Bronze\n");
		for (Pais pais : inscritos.values()) {
			System.out.println(pais.toString() + "\n");
		}
	}
	
}
