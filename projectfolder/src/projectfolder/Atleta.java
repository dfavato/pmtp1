package projectfolder;

public class Atleta {
	private int id;
	private Pais pais;
	private String nome;
	
	public Atleta(int id, String nome, Pais pais) {
		this.id = id;
		this.nome = nome;
		this.pais = pais;
	}
	
	public Atleta(String line) {
		this(
				Integer.parseInt(line.split(";")[0]), 					//Atleta id
				line.split(";")[3],										//Atleta nome
				Pais.getPaisById(Integer.parseInt(line.split(";")[1]))	//Pais
			);
	}

	public int getId() {
		return id;
	}

	public Pais getPais() {
		return pais;
	}

	public String getNome() {
		return nome;
	}
}
