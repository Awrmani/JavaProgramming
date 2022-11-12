/**********************************************
Workshop #6
Course: JAC444 - Semester Winter 2022
Last Name: Valaee Asr
First Name: Arman
ID: 139550206
Section: ZBB
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature A.V.A
Date: 2022-3-22
**********************************************/

package task2;

import java.util.Scanner;

public class Processor implements ArrayProcessor {
	final static ArrayProcessor max = (array)-> {
		double max = -999999999;
		for (int i = 0; i < array.length; i++)
			if (array[i] > max)
				max = array[i];
		return max;
	};
	
	final static ArrayProcessor min = (array)-> {
		double min = 1999999999;
		for (int i = 0; i < array.length; i++)
			if (array[i] < min)
				min = array[i];
		return min;
	};
	
	final static ArrayProcessor sum = (array)-> {
		double sum = 0;
		for (int i = 0; i < array.length; i++)
			sum += array[i];
		return sum;
	};
	
	final static ArrayProcessor avg = (array)-> {
		double avg = 0;
		for (int i = 0; i < array.length; i++)
			avg += array[i];
		avg = avg / array.length;
		return avg;
	};
	
	static ArrayProcessor cnt;
	public static ArrayProcessor counter(double value) {
			cnt = (array)-> {
			int count = 0;
			for (int i = 0; i < array.length; i++)
				if (value == array[i])
					++count;
			return count;
		};
		return cnt;
	}
	
	public static void main(String[] args) {
		double arr[] = new double[10];
		System.out.print("Enter an array of doubles (Enter 10 numbers): ");
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 10; i++) 
			arr[i] = in.nextDouble();
		
		System.out.print("Maximum Value: " + max.apply(arr));
		System.out.print("\nMinimum Value: " + min.apply(arr));
		System.out.print("\nSum Value: " + sum.apply(arr));
		System.out.print("\nAverage Value: " + avg.apply(arr));
		System.out.print("\n-------------------------------------------------------------------");
		System.out.print("\nEnter a number to see the number of occurences in the array: ");
		double value = in.nextDouble();
		ArrayProcessor count = counter(value);
		System.out.print("\nOcurrences of " + value + ": "); 
		System.out.printf("%.0f", cnt.apply(arr));
	}

	@Override
	public double apply(double[] array) {
		// TODO Auto-generated method stub
		return 0;
	}
}