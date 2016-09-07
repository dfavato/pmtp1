package projectfolder;

public class User {

	public static void main(String[] args) {
		Pais.registrarFromFile("paises.txt");
		Corrida corrida = new Corrida(1);
		Atleta kws = new Atleta(1, "Kawasaki", Pais.getPaisById(1));
		corrida.registrarResultado(kws, 10.78);
		corrida.atribuirMedalhas();
		System.out.println(corrida.toString());
		Pais.quadroMedalhas();
		
	}

}
