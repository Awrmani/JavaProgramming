/**********************************************
Workshop #1
Course:JAC444 - Winter 2022
Last Name: Valaee Asr
First Name: Arman
ID: 139550206
Section: ZBB
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature A.V.A
Date: 2022-1-30
**********************************************/

package workshop1;

import java.util.Scanner;

public class MaxLocation {
	
	int rowPos = 0;
	int columnPos = 0;
	double maxValue = -999999999;
	public MaxLocation()
	{
		
	}
	
	public double maxVal(double[][] mat)
	{
		int row = mat.length;
		int column = mat[0].length;
		
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < column; j++)
			{
				if (mat[i][j] > maxValue)
				{
					maxValue = mat[i][j];
					rowPos = i;
					columnPos = j;
				}
			}
		}
		return maxValue;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int row, column;
		double maxValue = 0;
		
		System.out.print("Enter the number of rows and columns in the array: ");
		row = input.nextInt();
		column = input.nextInt();
		double matrix1[][] = new double[row][column];
		System.out.print("Enter the array: \n");
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < column; j++)
			{
				matrix1[i][j] = input.nextDouble();
			}
		}
		MaxLocation ml = new MaxLocation();
		maxValue = ml.maxVal(matrix1);
		int rPos = ml.rowPos;
		int cPos = ml.columnPos;
		System.out.println("Largest elemenet: " + maxValue + "\nAt location: (" + rPos + ", " + cPos + ")");
	}

}
