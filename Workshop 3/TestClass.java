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

package task1;

import java.util.Scanner;

public class TestClass {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Triangle Side 1: ");
		double side1 = getSide();
		System.out.print("Enter Triangle Side 2: ");
		double side2 = getSide();
		System.out.print("Enter Triangle Side 3: ");
		double side3 = getSide();
		Triangle triangle = new Triangle(side1, side2, side3);
		//System.out.println("Triangle created - " + side1 + " " + side2 + " " + side3);
		System.out.print("Enter the color for the triangle: ");
		String color = null; 
		color = input.nextLine();
		if (color != null)
			triangle.setColor(color);
		
		try
		{
			System.out.print("Is the triangle filled? (true/false) ");
			boolean filled = input.nextBoolean();			
			triangle.setFilled(filled);
		}
		catch(Exception e)
		{
			System.out.print("\nInvalid boolean! Setting filled to FALSE!");
			triangle.setFilled(false);
		}
		
		System.out.println("\n\nTriangle created - " + side1 + " " + side2 + " " + side3);
		System.out.println("Triangle Area: " + triangle.getArea());
		System.out.println("Triangle Perimeter: " + triangle.getPerimeter());
		System.out.println("Triangle Color: " + triangle.getColor());
		if (triangle.isFilled())
			System.out.println("Triangle is filled");
		else
			System.out.println("Triangle is not filled");
	}
	
	public static double getSide() {
		Scanner input = new Scanner(System.in);
		double side;
		boolean flag = false;
		do {
			flag = false;
			side = input.nextDouble();
			if (side <= 0)
			{
				System.out.print("Invalid input! Please enter a positive value: ");
				flag = true;
			}
		} while(flag);
		
		return side;
	}
}
