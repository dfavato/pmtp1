package projectfolder;

import java.io.Serializable;

public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private int ouro;
	private int prata;
	private int bronze;
	
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
