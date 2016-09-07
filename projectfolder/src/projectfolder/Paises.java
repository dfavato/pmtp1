package projectfolder;

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
