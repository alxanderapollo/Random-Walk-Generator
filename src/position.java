/*
 * Alex Salazar
 * 09/20
 * Position coordinates stored in this classs
 * 
 */
public class position {
	//global variables of x y and z represent coordinates on a plane
	int x;
	int y;
	int z;
	int t;
	
	
	//constructor for x and y 2 dimensions
	public position(int x, int y ){
		this.x = x;
		this.y = y;
	}
	//3D spaces
	public position(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	//4D spaces
	public position(int x, int y, int z, int t){
		this.x = x;
		this.y = y;
		this.z = z;
		this.t = t;
	}
	
	//setters
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setZ(int z) {
		this.z = z;
	}
	public void setJ(int t) {
		this.t = t;
	}
	
	//getters
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public int getZ() {
		return this.z;
	}
	public int getJ() {
		return this.t;
	}
	
	//prints out the results of x and y
	public String toString() {
		String temp = "X: "+this.x+" Y :" +this.y;
		return temp;
	}//end toString
	//prints out the results of x,y,z
	public String toString2() {
		String temp = "X: "+this.x+", Y :" +this.y+", Z: "+this.z;
		return temp;
	}//end the 2nd string method
	public String toString3() {
		String temp = "X: "+this.x+", Y :" +this.y+", Z: "+this.t+", T: "+this.t;
		return temp;
	}//end the 3rd string method
}//end class
