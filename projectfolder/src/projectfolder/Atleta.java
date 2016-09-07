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
