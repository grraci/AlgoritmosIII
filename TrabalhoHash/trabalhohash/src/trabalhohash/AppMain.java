package trabalhohash;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AppMain {
	static RobinHoodHash<String, String> rhhash;
	static OrderedList<String> odlist;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    //System.getProperty("user.dir"))
		prepareFile("files/routes.txt");
		
		System.out.println("Tempo para encontrar o elemento na hashtable:");
		long startTime = System.nanoTime();
		rhhash.get("R31");
		long stopTime = System.nanoTime();
		System.out.println(stopTime - startTime);
		
		System.out.println("\nTempo para encontrar o elemento na Lista Encadeada ordenada:");
		long startTime2 = System.nanoTime();
		odlist.find("R31");
		long stopTime2 = System.nanoTime();
		System.out.println(stopTime2 - startTime2);
	}
	
	static void prepareFile(String dir){
		try {
			readFile(dir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void readFile(String filename) throws IOException {
		Scanner reader = new Scanner(new FileReader(filename));	
		String currentLine = reader.nextLine();
		
		rhhash = new RobinHoodHash<>();
		odlist = new OrderedList<>();
		
		while (reader.hasNextLine()) {
			currentLine = reader.nextLine();
			String [] infos = currentLine.split(",");
			String objData = "";
			for(int i = 1; i < infos.length; i++)
				objData += infos[i];
		
			rhhash.put(infos[0], objData);
			odlist.add(infos[0]);
		}
		reader.close();
	}
}
