	package fifteenpuzzle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;

public class Solver {
	public static void main(String[] args) {
//		System.out.println("number of arguments: " + args.length);
//		for (int i = 0; i < args.length; i++) {
//			System.out.println(args[i]);
//		}

		if (args.length < 2) {
			System.out.println("File names are not specified");
			System.out.println("usage: java " + MethodHandles.lookup().lookupClass().getName() + " input_file output_file");
			return;
		}
		
		
		// TODO
		File input = new File(args[0]);
		// solve...

		ArrayList<MoveMade> allMovesMade = new ArrayList<MoveMade>();

		allMovesMade = SolverIterative.solve(input.toString());

		File output = new File(args[1]);

		try {
		output.createNewFile();
		} catch (IOException e){
			System.out.println("An IO Exception occured when creating file");
		}

		try {
			FileWriter fWriter = new FileWriter(output);
			for (int i = 0; i < allMovesMade.size(); i++){
			fWriter.write(allMovesMade.get(i).fileString());
			}
			fWriter.close();
		//	System.out.println("Wrote in file");
		} catch (IOException e){
			System.out.println("An IO Exception occured when writing to file");
		}



	}
}
