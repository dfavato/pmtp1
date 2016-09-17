package projectfolder;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Estatistica {
	
	public static void printAll(String fileName, SportContainer sports, CountryContainer countries) {
		BufferedReader br = Util.getReader(fileName);
		String line;
		int sportId;
		do {
			line = Util.getLine(br);
			if(line != null && line.contains(";")) {
				sportId = Integer.parseInt(line.split(";")[1]);
				print(sports.getSportById(sportId));
			} else {
				print(countries);
			}
		} while (line != null);
	}
	
	private static void print(AbstractSport sport) {
		PrintWriter pw = new PrintWriter(createOutputFile(sport));
		pw.print(sport.toString());
		pw.close();
	}
	
	private static void print(CountryContainer countries) {
		PrintWriter pw = new PrintWriter(createOutputFile());
		pw.print(countries.toString());
		pw.close();
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
