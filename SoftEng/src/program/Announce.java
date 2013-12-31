package program;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Announce {

	public void writeFile(String str){
		
		try{
			BufferedWriter outFile = new BufferedWriter(new FileWriter("Announcements.txt",true));
			outFile.write(str + "\r\n");
			outFile.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		
	}
	
	public BufferedReader readFile(){
		try{
			BufferedReader file = new BufferedReader(new FileReader("Announcements.txt"));
			return file;
		}catch(IOException ioe){
			ioe.printStackTrace();
			
		}
		return null;

	}


}
