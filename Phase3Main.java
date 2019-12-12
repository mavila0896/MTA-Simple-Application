import java.io.*;
import java.util.*;

public class Phase3Main {
	public static void main(String[] args) {
		// The input and output filename set at input.txt & output.txt for the following tasks ahead of themselves.
		//The .txt files will be able to operate its tasks for the program. Store, delete, and modify.
	    String inputFile = "input.txt";
	    String outputFile = "output.txt";

	    // Run through the provided flags and perform appropriate action
	    for (int i=0 ; i < args.length ; i++) {

	        // Argument flag found
	        if (args[i].startsWith("-")) {
	            String argument = args[i].toLowerCase();
	            switch (argument) {

	                //-i set the following argument to input filename and increments
	                case "-i":
	                    inputFile = args[++i];
	                    break;

	                //-o set the following argument to output filename and increments
	                case "-o":
	                    outputFile = args[++i];
	                    break;
	                //-p will force the program to output the output.txt file for the user.    
	                case "-p":
	                    System.out.print("output.txt");
	                    break;
	                    
	                //-h will store the data into a HashMap
	                case "-h":
	                	break;

	                //-help display the usage
	                case "-help":
	                    System.out.println("Usage: java main [-i filename] [-o filename]");
	                    System.out.println("    -i filename:  Input text file name needed (eg. -i input.txt)");
	                    System.out.println("    -o filename:  output text file name needed (eg. -o output.txt)");
	                    System.out.println("    -p :  No file exists (output.txt). Please have an output.txt avaliable!");
	                    return;

	                // Case invalid flags are received, display prompt for help
	                default:
	                    System.err.println("Invalid Flag: Type -help for valid flags");
	                    return;
	            }
	        }
	    }
	    Phase3GUI mainProgram = new Phase3GUI();
	}
}
