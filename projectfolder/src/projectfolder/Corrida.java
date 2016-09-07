package projectfolder;

import java.util.Iterator;

public class Corrida extends AbstractEsporte {
	
	public Corrida(int id) {
		super(id, "Corrida");
	}

	@Override
	public void formarPodio() {
		//TODO e se o atleta tiver mais de 3 corridas? Quais considerar? E se um atleta tiver os 3 melhores tempos?
		Iterator<Resultado> resultados;
		int contador_podio = 0;
		
		resultados = this.getResultados().iterator();
		this.classificarResultados(true); //true = ascendente -> do menor para o maior
		do {
			if(resultados.hasNext()) {
				this.addAtletaPodio(resultados.next());
				contador_podio++;
			}
		} while (resultados.hasNext() && contador_podio < TAMANHO_PODIO);
	}


}
