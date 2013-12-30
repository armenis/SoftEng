package Prog;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Announce {

	public void writeFile(String str){
		
		try{
			BufferedWriter OutFile = new BufferedWriter(new FileWriter("Announcements.txt",true));
			OutFile.write(str + "\r\n");
			OutFile.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		
	}
	
	public BufferedReader readFile(){
		try{
			BufferedReader File = new BufferedReader(new FileReader("Announcements.txt"));
			return File;
		}catch(IOException ioe){
			ioe.printStackTrace();
			
		}
		return null;

	}


}
