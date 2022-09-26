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

package task2;

import java.lang.Math;

public class Craps {

	public static void main(String[] args) {
		boolean flag = true;
		do
		{
			int dice1 = (int) (Math.random() * 6 + 1);
			int dice2 = (int) (Math.random() * 6 + 1);
			int sum = dice1 + dice2;
			System.out.println("You rolled " + dice1 + " + " + dice2 + " = " + sum);
			if (sum == 2 || sum == 3 || sum == 12)
			{
				System.out.print("Craps, Better Luck Next Time, You lost!");
				flag = false;
			}
			else if (sum == 7 || sum == 11)
			{
				System.out.print("Congratulations, You won!");
				flag = false;
			}
			else
			{
				System.out.println("Point is (established) set to " + sum);
				int point = sum;
				boolean flag1 = true;
				do
				{
					dice1 = (int) (Math.random() * 6 + 1);
					dice2 = (int) (Math.random() * 6 + 1);
					sum = dice1 + dice2;
					System.out.println("You rolled " + dice1 + " + " + dice2 + " = " + sum);
					if (sum == 7)
					{
						System.out.print("Craps, Better Luck Next Time, You lost!");
						flag1 = false;
					}
					else if (sum == point)
					{
						System.out.print("Congratulations, You won!");
						flag1 = false;
					}
						
				} while(flag1);
				flag = false;
			}
			
		} while(flag);

	}

}
