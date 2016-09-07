package projectfolder;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public abstract class AbstractEsporte {
	private int id;
	private String nome;
	private LinkedList<Resultado> resultados;
	private LinkedHashSet<Resultado> podio;
	
	private static HashMap<Integer, AbstractEsporte> esportes;
	
	public static final int TAMANHO_PODIO = 3;

//	Class methods
	public static void registrarEsporte(AbstractEsporte esporte) {
		if(!esportes.containsKey(esporte.getId())) {
			esportes.put(esporte.getId(), esporte);
		}
	}
	
//	Instance methods
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public LinkedList<Resultado> getResultados() {
		return resultados;
	}
	public LinkedHashSet<Resultado> getPodio() {
		return podio;
	}
	
	public void registrarResultado(Atleta atleta, double valor) {
		this.resultados.add(new Resultado(this, atleta, valor));
	}
	
	public void addAtletaPodio(Resultado resultado) {
		this.podio.add(resultado);
	}
	
	public AbstractEsporte(String line) {
		this(Integer.parseInt(line.split(";")[0]), line.split(";")[1]);
	}

	public AbstractEsporte(int id, String nome) {
		this.id = id;
		this.nome = nome;
		this.resultados = new LinkedList<>();
		this.podio = new LinkedHashSet<>();
	}
	
	public abstract void formarPodio();
	
	public void classificarResultados(boolean ascending) {
		if(ascending) {
			Collections.sort(this.getResultados());
		} else {
			Collections.sort(this.getResultados(), Collections.reverseOrder());
		}
	}
	
	public void atribuirMedalhas() {
		Iterator<Resultado> resultados;
		
		this.formarPodio();
		resultados = this.getPodio().iterator();
		for (int i = Pais.OURO; i <= Pais.BRONZE; i++) {
			if(resultados.hasNext()) {
				resultados.next().getAtleta().getPais().ganharMedalha(i);
			}
		}
	}
	
	@Override
	public String toString() {
		String string;
		string = this.getNome() + "\nResultados:\n";
		for (Resultado resultado : resultados) {
			string += resultado.toString() + "\n";
		}
		return string;
	}

}
