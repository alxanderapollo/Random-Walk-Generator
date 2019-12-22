/*
 * Alex Salazar
 * 09/20
 * This class will hold NSAW and Rn^2 
 * 
 */
public class ResultObj {

	int N;// will hold NSAW
	double Rn;// will hold all the values of RN^2

	public ResultObj() {
		this.N = 0;
		this.Rn = 0;
	}

	public ResultObj(int Nsaw, double rn) {
		this.N = Nsaw;
		this.Rn = rn;
	}

	// setters
	public void setN(int n) {
		this.N = n;
	}

	public void setRn(double rn) {
		this.Rn = rn;
	}

	// getters
	public int getNsaw() {
		return this.N;
	}

	public double getRn() {
		return this.Rn;
	}

}
