/**
 * The Triangle class simulates a triangle
 */
public class Triangle {
	//create private fields for x and y coordinates
	private double[] x = new double[3];
	private double[] y = new double[3];
	
	/**
	 * The constructor loops through the inputted x and
	 * y arrays and assigns them to the x and y fields of
	 * the class.
	 * @param xInputs the x coordinates for the triangle
	 * @param yInputs the y coordinates for the triangle
	 */
	public Triangle(int[] xInputs, int[] yInputs) {
		for (int i = 0; i < 3; i++) {
			x[i] = xInputs[i];
			y[i] = yInputs[i];
			
		}
	}
	/**
	 * The getAreaT method checks that a triangle can be created
	 * with the given points and returns the area of the triangle
	 * if it can be creted successfully. If the points do not make
	 * a triangle, it returns -1.
	 * @return area The area of the triangle
	 */
	public double getAreaT() {
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
		  area *= (0.5);
		}
		return area;
	}
	/**
	 * The toString method returns a warning message if
	 * the triangle cannot be created and returns an empty string
	 * if the triangle is valid.
	 * @return a warning message if the triangle is invalid,
	 * or an empty string if the triangle is valid
	 */
	public String toString() {
		if (getAreaT() < 0)
		  return "Triangle with verices [" + x[0] + ", " + y[0] + "], [" 
				  + x[1] + ", " + y[1] + "], [ "
				  + x[2] + ", " + y[2] + "] "
				  + "cannnot be created.\n";
		else 
		  return "";
	}
}