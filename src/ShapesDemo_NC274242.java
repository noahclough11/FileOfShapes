

/*Noah Clough
  NC274242
  nclough@albany.edu
  ICSI 201
  Spring 2023
  
  This program will process an inputted file, 
  create shape objects based on the inputs,
  and find the largest shape.
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ShapesDemo_NC274242 {
  public static void main(String[] args) throws IOException 
  {
	  //Declare variables
	  int[] xInputs = new int[3];
	  int[] yInputs = new int[3];
	  String line;
	  char charLine;
	  double greatestArea = 0;
	  boolean greatestAreaIsTriangle = true;
	  
	  //Open and read the shapes file
	  FileReader myFileReader = new FileReader("shapes.txt");
	  BufferedReader shapes = new BufferedReader(myFileReader);
	  
	  //Read the first line of the file and then loop
	  //through each line until the end of the file
	  line = shapes.readLine();
	  while (line != null ) {
		 
		 //Split the line into individual numbers
		 String[] coords = line.split(" ");
		 
		 //Loop through the numbers and assign them
		 //into the x and y arrays as integers
		 int j = 0;
		 for (int i = 0; i < 6; i++) {
			 
			 xInputs[j] = Integer.parseInt(coords[i]);
			 i++;
			 yInputs[j] = Integer.parseInt(coords[i]);
			 j++;
		 }
		 
		 //Read the next line, convert it to char
		 //and determine if the shape is triangle or
		 //parallelogram
		 line = shapes.readLine();
		 charLine = line.charAt(0);
		 if (charLine == 'T') {
			 
			 //Triangle section
			 
			 //If the area of the triangle is greater than
			 //the current greatest area
			 if( greatestArea < makeTri(xInputs, yInputs, greatestArea))
			 {
				 // Assign the new greatest area and that it
				 // belongs to a triangle
				 greatestAreaIsTriangle = true;
			     greatestArea = makeTri(xInputs, yInputs, greatestArea);
			 }
		 } else if (charLine == 'P') {
			 
			 //Parallelogram section
			 
			 //If the area of the parallelogram is greater than
			 //the current greatest area
			 if(greatestArea < makePara(xInputs, yInputs, greatestArea))
			 {
				 // Assign the new greatest area and that it
				 // belongs to a parallelogram
				 greatestAreaIsTriangle = false;
			     greatestArea = makePara(xInputs, yInputs, greatestArea);
			 }
		 }
		 //Read the next line of the file
		 line = shapes.readLine();	 
	  }
	  
	  //Close the data file
	  shapes.close();
	  myFileReader.close();
	  
	  //Output the value of the greatest area and
	  //whether it is a triangle or a parallelogram
	  if (greatestAreaIsTriangle)
		  System.out.printf("\nThe biggest shape in the file \"shapes.txt\" is the triangle with an area of %.2f \n",
				  greatestArea);
	  else 
		  System.out.printf("\nThe biggest shape in the file \"shapes.txt\" is the parallelogram with an area of %.2f \n",
				  greatestArea);
		  
  }
  /**
   * The makeTri method creates a new Triangle object with
   * the provided x and y coordinates. It then calls the 
   * toString method of the Triangle class, which outputs
   * a warning message if the triangle cannot be created
   * and outputs nothing if the triangle is created successfully.
   * It then compares the current greatest area to the area
   * of the created triangle (which is -1 if the triangle is
   * not created). If the area is bigger than the greatest area,
   * it is assigned to the tempGreatestArea variable and returned.
   * If not, the previous greatest value is returned.
   * 
   * @param xInputs the x coordinates of the triangle to be created
   * @param yInputs the y coordinates of the triangle to be created
   * @param tempGreatestArea the current greatest area of the shapes
   * which have been created.
   * @return the value in the tempGreatestArea variable.
   */
  public static double makeTri(int[] xInputs, int[] yInputs, double tempGreatestArea) {
	  Triangle tri = new Triangle(xInputs, yInputs);
	  System.out.print(tri.toString());
	  
	  if (tri.getAreaT() > tempGreatestArea)
		  tempGreatestArea = tri.getAreaT();
	  
	  return tempGreatestArea;
	  
  }
  /**
   * The makePara method creates a new Parallelogram object with
   * the provided x and y coordinates. It then calls the 
   * toString method of the Parallelogram class, which outputs
   * a warning message if the Parallelogram cannot be created
   * and outputs nothing if the Parallelogram is created successfully.
   * It then compares the current greatest area to the area
   * of the created Parallelogram (which is -1 if the triangle is
   * not created). If the area is bigger than the greatest area,
   * it is assigned to the tempGreatestArea variable and returned.
   * If not, the previous greatest value is returned.
   * 
   * @param xInputs the x coordinates of the Parallelogram to be created
   * @param yInputs the y coordinates of the Parallelogram to be created
   * @param tempGreatestArea the current greatest area of the shapes
   * which have been created.
   * @return the value in the tempGreatestArea variable.
   */
  public static double makePara(int[] xInputs, int[] yInputs, double tempGreatestArea) {
	  Parallelogram para = new Parallelogram(xInputs, yInputs);
	  System.out.print(para.toString());
	  if (para.getAreaP() > tempGreatestArea)
		  tempGreatestArea = para.getAreaP();
	  
	  return tempGreatestArea;
  }
}