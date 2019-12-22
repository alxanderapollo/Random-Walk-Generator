/*
Written by Alex Salazar
09/20
	Thread object class
	the purpose: this class is a list of instructions made to be carried by each thread
	this class recvies three paramters when an instance is created
	1. the degree that gets chosen --> d 0,1,2 means 2d,3d,or 4d
	2. num of steps to be carried out  -->s
	3. the number of walks  --> w

	Here any succesfful walk that is returned its data is split into an object to be sent
	to the main class to be appeneded to the appropriate varaible for storage.
*/
public class myThreads extends Thread {

	// total end square distance
	private int endtoend;
	// total number of self avoiding walks
	private int N_SAW;
	// param sent to choose the degree
	private int degreeChosen;
	private int num_of_steps;
	private int num_of_walks;

	public myThreads(int d, int s, int w) {
		this.degreeChosen = d; // degree
		this.num_of_steps = s; // steps
		this.num_of_walks = w; // walks
	}

	public void run() {

		if (degreeChosen == 0) {
			// number of walks per thread = 10000

			for (int walks = 0; walks < num_of_walks; walks++) {
				// 1.Creates a saw object, in this case our 2D one
				// ->Create containers
				SAW obj1 = new SAW();
				ResultObj one = new ResultObj();
				// send the steps
				one = obj1.generate2DSaw(num_of_steps);

				// 2.Count number of successful walks
				// object returned will be empty if the walk was unsuccessful
				N_SAW += one.N;
				endtoend += one.Rn;

				// reset object parameters
				one.N = 0;
				one.Rn = 0;
			} // end for

		} // end if

		else if (degreeChosen == 1) {
			// pick 3D
			// number of walks per thread = 100000

			for (int walks = 0; walks < num_of_walks; walks++) {
				// 1.Creates a saw object, in this case our 2D one
				// ->Create containers
				SAW obj1 = new SAW();
				ResultObj one = new ResultObj();
				// send the steps
				one = obj1.generate3DSaw(num_of_steps);

				// 2.Count number of successful walks
				// object return will be empty if the walk was unsuccessful
				N_SAW += one.N;
				endtoend += one.Rn;

				// reset object parameters
				one.N = 0;
				one.Rn = 0;

			} // end for
		} // end else if
		else {
			// pick 4D

			for (int walks = 0; walks < num_of_walks; walks++) {
				// 1.Creates a saw object, in this case our 2D one
				// ->Create containers
				SAW obj1 = new SAW();
				ResultObj one = new ResultObj();
				// send the steps
				one = obj1.generate4DSaw(num_of_steps);

				// 2.Count number of successful walks
				// object return will be empty if the walk was unsuccessful
				N_SAW += one.N;
				endtoend += one.Rn;

				// reset object parameters
				one.N = 0;
				one.Rn = 0;

			} // end for
		} // end else
	}// end run method

	public double nSawTot() {
		// return nsaw
		return N_SAW;
	}

	public double endToendTo() {
		// return end to end
		return endtoend;
	}
}// end class
