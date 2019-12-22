/*
 * Written By Alex Salazar
 * 15042189
 * 09/21
 *  Main file of the program
 * last updated 9/27
 *
*/

import java.io.IOException;

public class Main {

	// appends all the data and dumps it on the screen once the program has officaly
	// finished.
	private static String printOut = "";

	// run threads is reponsible for creating thread objects
	// parameters for the threads are degree, steps, and number of walks
	public void runThreads(int degree, int steps) {

		double endtoend_total = 0; // total end square distance
		double N_SAW_Tot = 0;// total number of self avoiding walks
		double F_SAW_n; // f_SAW(N)
		int N_threads = 1000;// total number of threads
		int N_Walks = 100000; // total number of walks 10^5

		long startTime = System.currentTimeMillis();

		// Create threads
		myThreads thread_array[] = new myThreads[N_threads];
		for (int i = 0; i < N_threads; i++) {
			// create an instance of the threads class
			thread_array[i] = new myThreads(degree, steps, N_Walks);
			// will run everything in the run method of the threads class
			thread_array[i].start();
		}

		for (int i = 0; i < N_threads; i++) {
			try {
				thread_array[i].join();
			} catch (Exception e) {
				e.printStackTrace();
			} // end try catch block
		} // end for

		for (int i = 0; i < N_threads; i++) {
			N_SAW_Tot += thread_array[i].nSawTot();
			// retrive endto end values
			endtoend_total += thread_array[i].endToendTo();
		}
		long endTime = System.currentTimeMillis();

		// print results
		double rnSquared = (endtoend_total / N_SAW_Tot); // calculate RN^2
		F_SAW_n = (N_SAW_Tot / (N_threads * N_Walks)); // calculate FSAW
		// append all information
		printOut += "\n" + steps + "      " + rnSquared + "       " + F_SAW_n + "          "
				+ ((endTime - startTime) / 1000) + " secs";
	}

	public static void run2D() {

		// select number of steps
		int steps = 41; // when the program is done it will have run 30 steps 10 --> 40

		printOut += "2D print out ";
		printOut += "\nNsteps |" + "Rn^2                    |" + "Fsaw(N)" + "           |totalTime";

		for (int i = 10; i < steps; i++) {
			Main one = new Main();
			one.runThreads(0, i);// sends degree 0 which means 2D, and i represents the Step #
		} // end for
			// print data
		System.out.println(printOut);
		printOut = "";
	}// end 2D

	public static void run3D() {

		// select number of steps
		int steps = 41;

		printOut += "3D print out ";
		printOut += "\nNsteps |" + "Rn^2                    |" + "Fsaw(N)" + "           |totalTime";

		for (int i = 10; i < steps; i++) {
			Main two = new Main();

			two.runThreads(1, i); // 1 means 3D
		} // end for
		System.out.println(printOut);
		printOut = "";// clear the print out
	}// end 3D

	public static void run4D() {

		// select number of steps
		int steps = 41;

		printOut += "4D print out ";
		printOut += "\nNsteps |" + "Rn^2                    |" + "Fsaw(N)" + "           |totalTime";

		for (int i = 10; i < steps; i++) {
			Main three = new Main();

			three.runThreads(2, i);
		} // end for
		System.out.println(printOut);
		printOut = "";
	}// end 4D

	public static void main(String[] alex) throws IOException {

		// runs 2D
		run2D();

		// runs 3D
		// run3D();

		// runs 4D
		// run4D();
	}// end main
}// end main
