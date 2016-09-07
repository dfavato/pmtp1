package projectfolder;

public class Resultado implements Comparable<Resultado>{
	private AbstractEsporte esporte;
	private Atleta atleta;
	private double valor;
	
	public Resultado(AbstractEsporte esporte, Atleta atleta, double valor) {
		this.esporte = esporte;
		this.atleta = atleta;
		this.valor = valor;
	}

	public AbstractEsporte getEsporte() {
		return esporte;
	}

	public Atleta getAtleta() {
		return atleta;
	}

	public double getValor() {
		return valor;
	}

	@Override
	public int compareTo(Resultado o) {
		return Double.compare(this.getValor(), o.getValor());
	}
	
	@Override
	public String toString() {
		return this.getEsporte().getNome() + " - " + this.getAtleta().getNome() + " - " + this.getValor();
	}
	
	
}
