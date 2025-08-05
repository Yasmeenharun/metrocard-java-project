package MetroCard;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String [] args) {
    	try {
    	BufferedReader br = new BufferedReader(new FileReader("input2.txt"));
    	String line;
    	while((line=br.readLine())!=null){
    		CommandProcessor.process(line);
    	}
    	br.close();
    }catch (IOException e) {
    	e.printStackTrace();
    }
    	}
}
