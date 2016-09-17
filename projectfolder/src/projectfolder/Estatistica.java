package projectfolder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Estatistica {
	
	public static void print(AbstractSport sport) {
		PrintWriter pw = new PrintWriter(createOutputFile(sport));
		pw.println(sport.toString());
	}
	
	public static void print(CountryContainer countries) {
		PrintWriter pw = new PrintWriter(createOutputFile());
		pw.println(countries.toString());
	}
	
	private static FileOutputStream createOutputFile(AbstractSport sport) {
		FileOutputStream file;
		String fileName;
		fileName = "estatistica-1-" + sport.getId() + ".txt"; 
		try {
			file = new FileOutputStream(fileName);
			return file;
		} catch (IOException e) {
			System.err.println("Não foi possível criar o arquivo.");
			return null;
		}	
	}
	
	private static FileOutputStream createOutputFile() {
		FileOutputStream file;
		String fileName;
		fileName = "estatistica-2.txt"; 
		try {
			file = new FileOutputStream(fileName);
			return file;
		} catch (IOException e) {
			System.err.println("Não foi possível criar o arquivo.");
			return null;
		}	
	}

}
