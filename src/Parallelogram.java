/**
 * The Parallelogram class simulates a parallelogram
 */
public class Parallelogram {
	//create private fields for x and y coordinates
	private double[] x = new double[4];
	private double[] y = new double[4];
	
	/**
	 * The constructor loops through inputted coordinates
	 * and assigns them to the first 3 postitons in the x
	 * and y arrays. It then calls the setFourthPoint method
	 * to assign the fourth coordinates into the x and y
	 * arrays.
	 * @param xInputs
	 * @param yInputs
	 */
	public Parallelogram(int[] xInputs, int[] yInputs){
		for (int i = 0; i < 3; i++) {
			x[i] = xInputs[i];
			y[i] = yInputs[i];
		}
		setFourthPoint();
	}
	/**
	 * The getAreaP method checks that a Parallelogram can be created
	 * with the given points and returns the area of the Paralellogram
	 * if it can be created successfully. If the points do not make
	 * a Parallelogram, it returns -1.
	 * @return area The area of the Parallelogram
	 */
	public double getAreaP() {
		double area = -1;
		//Check that all points do not have same x or y value
		if (((x[0] == x[1])&&(x[0] == x[2]))||((y[0] == y[1])&&(y[0] == y[2])))
			return area;
		
		//Check that no two points are the same
		else if (((x[0] == x[1])&&(y[0] == y[2]))||((x[0] == x[2])&&(y[0]== y[2]))||((x[1] == x[2])&&(y[1] == y[2])))
			return area;
		
		//Check that points do not form a straight line
		else if (((y[0] - y[1]) / (x[0] - x[1])) == ((y[1] - y[2]) / (x[1] - x[2])))
			return area;
		
		else {
		  //Calculate area
		  area = ((x[0]*(y[1]-y[2]))+(x[1]*(y[2]-y[0]))+(x[2]*(y[0]-y[1])));
		  area = Math.abs(area);
		}
		return area;
	}
	/**
	 * The setFourthPoint method calculates the fourth
	 * coordinate pair and assigns it to the x and y arrays
	 */
	private void setFourthPoint() {
		x[3] = x[0] + (x[2] - x[1]);
		y[3] = y[0] + (y[2] - y[1]);
	}
	/**
	 * The toString method returns a warning message if
	 * the Parallelogram cannot be created and returns an empty string
	 * if the Parallelogram is valid.
	 * @return a warning message if the Parallelogram is invalid,
	 * or an empty string if the Parallelogram is valid
	 */
	public String toString() {
		if (getAreaP() < 0)
			  return "Parallelogram with verices [" 
				      + x[0] + ", " + y[0] + "], [" 
					  + x[1] + ", " + y[1] + "], [ "
					  + x[2] + ", " + y[2] + "], ["
					  + x[3] + ", " + y[3] + "] "
					  + "cannnot be created.\n";
			else 
			  return "";
	}
}