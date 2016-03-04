import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class Loader {
	
    //game level
    int currentLevel = 0;
    String filePath = null;
    
    public Loader(String filePath){
	
	this.filePath = filePath;
    }
    
    public int load(){
	
	File inputFile;
	BufferedReader inputReader;
	
	try{
	    inputFile = new File(filePath);
	    inputReader = new BufferedReader(new FileReader(inputFile));	
	    
	    this.currentLevel = inputReader.read();
	    
	    inputReader.close();
	} catch(Exception e){
	    e.printStackTrace();
	}

	return this.currentLevel;
    }
    
    
    /*
     * File that we want to output
     * Create a new file based on file path ... test.txt
     * Give our bufferedWriter a new fileWriter on our output file, which is a file
     * Write the text to the file
     * And then close the BufferedWriter
     */
    public void save(int level){
	
	File outputFile;
	BufferedWriter outputWriter;
	
	try{
	    outputFile = new File(filePath); 
	    outputWriter = new BufferedWriter(new FileWriter(outputFile));
	    
	    outputWriter.write(level);
	    
	    outputWriter.close();
	    
	}catch (Exception e){
	    e.printStackTrace();
	}	
    }
    
    /*
     * Read file, and filepath the file that we are reading from test.txt
     * BufferedReader reads from new FileReader
     * Read the line from fileText (So text from the file)
     * Print lines
     * Close inputReader
     * If exception produce error message
     */

}
