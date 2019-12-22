/*
	Written by alex salazar
	09/20
	Purpose: To simulate a random walk
	possible dimensions 2d, 3d, 4d 
	each with their respective move functions(2,3,4)d
	objects created take no paramters
	generate functions only recieve steps input
*/

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class SAW {

	// Receives walk parameters
	public SAW() {

	}

	// return an object of the type result object which will hold all values of nSaw
	// and RN^2
	ResultObj generate2DSaw(int steps) {

		// store initial positions for 2D
		int current_x = 0;
		int current_y = 0;

		// end to end values
		int endToEnd_X = 0;
		int endToEnd_Y = 0;

		// inilize containers
		ArrayList<position> arrList;
		HashMap<String, Integer> map;

		map = new HashMap<String, Integer>();
		arrList = new ArrayList<position>();

		ResultObj one = new ResultObj();

		position inital;

		// 2d
		// represents the origin = "0,0";
		// put the origin in the map and the initial postion object in the map
		map.put("0,0", arrList.addPosition(inital = new position(current_x, current_y)));

		int random;
		// range for the random threads
		// max = 4; //at most we want 0-3
		// condition # of passed steps
		for (int i = 0; i < steps; i++) {

			// 1.Create position object(coordinate)
			// and assign temp coordinates
			position tempCoordinates = new position(inital.x, inital.y);

			// 2. move on the board - get random step
			// pass the random value w/ 0-4 range and current coordniate position
			tempCoordinates = move2D(random = ThreadLocalRandom.current().nextInt(0, 4), tempCoordinates); // retrive
																											// random
																											// pos

			// 3.check the returned values from the randomwalks
			// create unique id for the coordinate
			String temp = Integer.toString(tempCoordinates.x) + "," + Integer.toString(tempCoordinates.y);

			// 4.check to see if it exists in the map already
			if (map.containsKey(temp) == true) {
				break;
			} // end if
			else {
				map.put(temp, arrList.addPosition(tempCoordinates));
				// otherwise add the new coordniates and update initial with the new values
				inital.x = tempCoordinates.x;
				inital.y = tempCoordinates.y;

			} // end else

			// update x for end to end square distance
			endToEnd_X = inital.x;
			endToEnd_Y = inital.y;
			// reset temp to an empty string
			temp = "";

		} // end for loop

		// if a succesful walk
		// increment nsaw
		// sum end to end
		if (map.size() == (steps + 1)) {
			one.N++;
			one.Rn = (Math.pow(endToEnd_X, 2) + Math.pow(endToEnd_Y, 2));
		}

		// if the walk is not a success return an empty nsaw and rn^2
		map.clear();
		arrList.clear();

		return one;

	}// end generate saw
		// move method for 2D

	position move2D(int val, position current) {
		// cases description
		// possible 2d moves cases
		// 0 --> means we go up one so x, y+1
		// 1 --> means we go right one so x+1, y
		// 2 --> means we go down one so x, y-1
		// 3 --> means we go left one so x-1, y

		int temp_x;
		int temp_y;

		position obj;

		if (val == 0) {
			// two temp varaibles to hold x and y current positions
			// 1. get current position and create the object to be sent back
			obj = new position(temp_x = current.x, temp_y = current.y + 1);
			// 3. reset temp val
			temp_y = 0;
			// 4. return the position
			return obj;
		} // end if
		else if (val == 1) {
			// two temp varaibles to hold x and y current positions
			// 1. get current position and create the object to be sent back
			obj = new position(temp_x = current.x + 1, temp_y = current.y);
			// 3. reset temp val
			temp_x = 0;
			// 4. return the position
			return obj;
		} // end else if
		else if (val == 2) {
			// two temp varaibles to hold x and y current positions
			// 1. get current position and create the object to be sent back
			obj = new position(temp_x = current.x, temp_y = current.y - 1);
			// 3. reset temp val
			temp_y = 0;
			// 4. return the position
			return obj;
		} // end else if
		else {
			// two temp varaibles to hold x and y postions
			// 1. get current position and create the object to be sent back
			obj = new position(temp_x = current.x - 1, temp_y = current.y);
			// 3. reset temp val
			temp_x = 0;
			// 4. return the position
			return obj;
		} // end else
	}// end 2D method

	// generate 3D
	ResultObj generate3DSaw(int steps) {
		// num_of_Steps = steps;

		// store initial positions for 2D
		int current_x = 0;
		int current_y = 0;
		int current_z = 0;

		// end to end values
		int endToEnd_X = 0;
		int endToEnd_Y = 0;
		int endToEnd_Z = 0;

		// Initialize containers
		ArrayList<position> arrList;
		HashMap<String, Integer> map;

		map = new HashMap<String, Integer>();
		arrList = new ArrayList<position>();

		ResultObj one = new ResultObj();

		// store the initial position
		position inital;

		// 3D this is the initial position to uniquely identify the origin

		// store the origins
		map.put("0,0,0", arrList.addPosition(inital = new position(current_x, current_y, current_z)));
		// min value for random

		int random;
		// range for the random threads
		// at most we want 0-5 gives us 6 possible choices for
		// our random selector.
		// condition # of passed steps
		for (int i = 0; i < steps; i++) {

			// 1.Create position object(coordinate)
			// and assign temp coordinates
			position tempCoordinates = new position(inital.x, inital.y, inital.z);

			// 2. move on the board - get random step
			// pass the random value and current coordinate position
			// 0-5 possibilities
			// random = ThreadLocalRandom.current().nextInt(0, 6);
			tempCoordinates = move3D(random = ThreadLocalRandom.current().nextInt(0, 6), tempCoordinates); // retieve
																											// random
																											// pos

			// 3.check the returned values from the randomwalks
			// create unique id for the coordinate (x,y,z)
			String temp = Integer.toString(tempCoordinates.x) + "," + Integer.toString(tempCoordinates.y) + ","
					+ Integer.toString(tempCoordinates.z);

			// 4.check to see if it exists in the map already
			if (map.containsKey(temp) == true) {
				break;
			} // end if
			else {
				map.put(temp, arrList.addPosition(tempCoordinates));
				// otherwise add the new coordniates and update initial with the new values
				inital.x = tempCoordinates.x;
				inital.y = tempCoordinates.y;
				inital.z = tempCoordinates.z;
			} // end else

			// update x for end to end square distance
			endToEnd_X = inital.x;
			endToEnd_Y = inital.y;
			endToEnd_Z = inital.z;

			// reset temp to an empty string
			temp = "";

		} // end for loop

		// if a successful walk
		// increment nSaw
		// sum end to end
		if (map.size() == (steps + 1)) {
			one.N++;
			one.Rn = (Math.pow(endToEnd_X, 2) + Math.pow(endToEnd_Y, 2) + Math.pow(endToEnd_Z, 2));
		}

		// if the walk is not a success return an empty nsaw and rn^2
		map.clear();
		arrList.clear();

		return one;
	}// end move3D

	position move3D(int val, position current) {

		// cases description
		// possible 3D moves cases
		// 0 --> means we go up one so x, y+1
		// 1 --> means we go right one so x+1, y
		// 2 --> means we go down one so x, y-1
		// 3 --> means we go left one so x-1, y
		// 4 --> means we go into the board one so z+1
		// 5 --> means we go out of the board one z-1

		int temp_x;
		int temp_y;
		int temp_z;

		position obj;

		if (val == 0) {
			// two temp varaibles to hold x and y current positions
			// 1. get current position and create the object to be sent back
			obj = new position(temp_x = current.x, temp_y = current.y + 1, temp_z = current.z);
			// 3. reset temp val
			temp_y = 0;
			// 4. return the position
			return obj;
		} // end if
		else if (val == 1) {
			// two temp varaibles to hold x and y current positions
			// 1. get current position and create the object to be sent back
			// +1 to go right one
			obj = new position(temp_x = current.x + 1, temp_y = current.y, temp_z = current.z);
			// 3. reset temp val
			temp_x = 0;
			// 4. return the position
			return obj;
		} // end else if
		else if (val == 2) {
			// two temp varaibles to hold x and y current positions
			// 1. get current position and create the object to be sent back
			// -1 to go down one
			obj = new position(temp_x = current.x, temp_y = current.y - 1, temp_z = current.z);
			// 3. reset temp val
			temp_y = 0;
			// 4. return the position
			return obj;
		} // end else if
		else if (val == 3) {
			// two temp varaibles to hold x and y postions
			// 1. get current position and create the object to be sent back
			// -1 to go down one
			obj = new position(temp_x = current.x - 1, temp_y = current.y, temp_z = current.z);
			// 3. reset temp val
			temp_x = 0;
			// 4. return the position
			return obj;
		} // end elseif
		else if (val == 4) {
			// move z in the postive direction
			// 1. get current position
			// -1 to go down one
			// 2.create the object to be sent back
			obj = new position(temp_x = current.x, temp_y = current.y, temp_z = current.z + 1);
			// 3. reset temp val
			temp_z = 0;
			// 4. return the position
			return obj;
		} else { // if anything but 4,then its most certainly a 5
			// move z in the negative direction
			// 1. get current position
			// -1 to go down one
			// 2.create the object to be sent back
			obj = new position(temp_x = current.x, temp_y = current.y, temp_z = current.z - 1);
			// 3. reset temp val
			temp_z = 0;
			// 4. return the position
			return obj;
		} // end else if
	}// end move3D
		// generate 4D and move it

	ResultObj generate4DSaw(int steps) {
		// num_of_Steps = steps;

		// store initial positions for 2D
		int current_x = 0;
		int current_y = 0;
		int current_z = 0;
		int current_t = 0;

		// end to end values
		int endToEnd_X = 0;
		int endToEnd_Y = 0;
		int endToEnd_Z = 0;
		int endToEnd_T = 0;

		// Initialize containers
		ArrayList<position> arrList;
		HashMap<String, Integer> map;

		map = new HashMap<String, Integer>();
		arrList = new ArrayList<position>();

		ResultObj one = new ResultObj();

		// store the initial position
		position inital;

		// 3D this is the initial position to uniquely identify the origin

		map.put("0,0,0,0", arrList.addPosition(inital = new position(current_x, current_y, current_z, current_t)));
		// min value for random
		// at most we want 0-7 gives us 7 possible choices for
		int random;
		// range for the random threads

		// our random selector.
		// condition # of passed steps
		for (int i = 0; i < steps; i++) {

			// 1.Create position object(coordinate)
			// and assign temp coordinates
			position tempCoordinates;

			// 2. move on the board - get random step
			// pass the random value and current coordinate position
			// min = 0, max = 6 0-5 possibilities
			tempCoordinates = move3D(random = ThreadLocalRandom.current().nextInt(0, 8),
					tempCoordinates = new position(inital.x, inital.y, inital.z, inital.t)); // retieve random pos

			// 3.check the returned values from the randomwalks
			// create unique id for the coordinate (x,y,z)
			String temp;
			// temp =
			// Integer.toString(tempCoordinates.x)+","+Integer.toString(tempCoordinates.y)+","+Integer.toString(tempCoordinates.z)+","+Integer.toString(tempCoordinates.t);

			// 4.check to see if it exists in the map already
			if (map.containsKey(temp = Integer.toString(tempCoordinates.x) + "," + Integer.toString(tempCoordinates.y)
					+ "," + Integer.toString(tempCoordinates.z) + "," + Integer.toString(tempCoordinates.t)) == true) {
				break;
			} // end if
			else {
				map.put(temp, arrList.addPosition(tempCoordinates));
				// otherwise add the new coordniates and update initial with the new values
				inital.x = tempCoordinates.x;
				inital.y = tempCoordinates.y;
				inital.z = tempCoordinates.z;
				inital.t = tempCoordinates.t;
			} // end else

			// update x for end to end square distance
			endToEnd_X = inital.x;
			endToEnd_Y = inital.y;
			endToEnd_Z = inital.z;
			endToEnd_T = inital.t;
			// System.out.println("X: "+endToEnd_X+ " Y: "+endToEnd_Y );

			// reset temp to an empty string
			temp = "";

		} // end for loop

		// if a successful walk
		// increment nSaw
		// sum end to end
		if (map.size() == (steps + 1)) {
			one.N++;
			one.Rn = (Math.pow(endToEnd_X, 2) + Math.pow(endToEnd_Y, 2) + Math.pow(endToEnd_Z, 2)
					+ Math.pow(endToEnd_T, 2));
		}
		// check
		// if the walk is not a success return an empty nsaw and rn^2
		map.clear();
		arrList.clear();

		return one;
	}// end generate4D

	position move4D(int val, position current) {

		// cases description
		// possible 3D moves cases
		// 0 --> means we go up one so x, y+1
		// 1 --> means we go right one so x+1, y
		// 2 --> means we go down one so x, y-1
		// 3 --> means we go left one so x-1, y
		// 4 --> means we go into the board one so z+1
		// 5 --> means we go out of the board one z-1
		// 6 --> means we go in to the board one t+1
		// 7 --> means we go out of the board one t-1

		int temp_x;
		int temp_y;
		int temp_z;
		int temp_t;

		position obj;

		if (val == 0) {
			// pos y direction
			// 1. get current position and create the object to be sent back
			// +1 to go up one
			obj = new position(temp_x = current.x, temp_y = current.y + 1, temp_z = current.z, temp_t = current.t);
			// 3. reset temp val
			temp_y = 0;
			// 4. return the position
			return obj;
		} // end if
		else if (val == 1) {
			// two temp varaibles to hold x and y current positions
			// 1. get current position
			// +1 to go right one
			// 2.create the object to be sent back
			obj = new position(temp_x = current.x + 1, temp_y = current.y, temp_z = current.z, temp_t = current.t);
			// 3. reset temp val
			temp_x = 0;
			// 4. return the position
			return obj;
		} // end else if
		else if (val == 2) {
			// two temp varaibles to hold x and y current positions
			// 1. get current position and create the object to be sent back
			// -1 to go down one
			obj = new position(temp_x = current.x, temp_y = current.y - 1, temp_z = current.z, temp_t = current.t);
			// 3. reset temp val
			temp_y = 0;
			// 4. return the position
			return obj;
		} // end else if
		else if (val == 3) {
			// two temp varaibles to hold x and y postions
			// 1. get current position
			// -1 to go down one
			// 2.create the object to be sent back
			obj = new position(temp_x = current.x - 1, temp_y = current.y, temp_z = current.z, temp_t = current.t);
			// 3. reset temp val
			temp_x = 0;
			// 4. return the position
			return obj;
		} // end elseif
		else if (val == 4) {
			// move z in the postive direction

			// 1. get current position
			// -1 to go down one
			// 2.create the object to be sent back
			obj = new position(temp_x = current.x, temp_y = current.y, temp_z = current.z + 1, temp_t = current.t);
			// 3. reset temp val
			temp_z = 0;
			// 4. return the position
			return obj;

		} else if (val == 5) { // if anything but 4,then its most certainly a 5
			// move z in the negative direction
			// 1. get current position
			// -1 to go down one
			// 2.create the object to be sent back
			obj = new position(temp_x = current.x, temp_y = current.y, temp_z = current.z - 1, temp_t = current.t);
			// 3. reset temp val
			temp_z = 0;
			// 4. return the position
			return obj;
		} // end else if
		else if (val == 6) { // if anything but 4,then its most certainly a 5
			// move z in the negative direction
			// 1. get current position
			// -1 to go down one
			// 2.create the object to be sent back
			obj = new position(temp_x = current.x, temp_y = current.y, temp_z = current.z, temp_t = current.t + 1);
			// 3. reset temp val
			temp_t = 0;
			// 4. return the position
			return obj;
		} // end else if
		else { // if anything but 4,then its most certainly a 5
				// move z in the negative direction
				// 1. get current position
				// -1 to go down on
				// 2.create the object to be sent back
			obj = new position(temp_x = current.x, temp_y = current.y, temp_z = current.z, temp_t = current.t - 1);
			// 3. reset temp val
			temp_t = 0;
			// 4. return the position
			return obj;
		} // end else
	}// end move4D
}// end Class
