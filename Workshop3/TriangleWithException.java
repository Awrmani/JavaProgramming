/**********************************************
Workshop #3
Course: JAC444 - Semester Winter 2022
Last Name: Valaee Asr
First Name: Arman
ID: 139550206
Section: ZBB
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature A.V.A
Date: 2022-2-13
**********************************************/

package task2;

import java.lang.Math;

public class TriangleWithException extends GeometricObject {

	double side1 = 1.0, side2 = 1.0, side3 = 1.0;
	
	public TriangleWithException() {
		
	}
	
	public TriangleWithException(double side1, double side2, double side3) throws TriangleException {
		if ((side1 + side2) <= side3 || (side2 + side3) <= side1 || (side1 + side3) <= side2)
			throw new TriangleException("A Triangle with the given sides cannot exist!");
		else
		{
			this.side1 = side1;
			this.side2 = side2;
			this.side3 = side3;
			System.out.println("Triangle " + side1 + " - " + side2 + " - " + side3 + " Created!");
		}
	}
	
	public double getSide1() {
		return side1;
	}
	
	public double getSide2() {
		return side2;
	}
	
	public double getSide3() {
		return side3;
	}

	public double getArea() {
		double s = (side1 + side2 + side3) / 2;
		return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
	}
	
	public double getPerimeter() {
		return side1 + side2 + side3;
	}
}
