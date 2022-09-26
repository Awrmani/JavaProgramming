/**********************************************
Workshop #2
Course: JAC444 - Semester Winter 2022
Last Name: Valaee Asr
First Name: Arman
ID: 139550206
Section: ZBB
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature A.V.A
Date: 2022-2-6
**********************************************/
package task1;

import java.util.Scanner;


public class IncomeTax {
	
	int filingStatus;
	int intervals[][];
	double rates[];
	double taxableIncome;
	
	
	IncomeTax() {
		filingStatus = -1;
		rates = null;
		intervals = null;
		taxableIncome = 0;
	}
	
	IncomeTax(int filingStatus, int intervals[][], double rates[], double taxableIncome) {
		this.filingStatus = filingStatus;
		this.intervals = intervals;
		this.rates = rates;
		this.taxableIncome = taxableIncome;
	}
	
	int getFilingStatus() {
		return filingStatus;
	}
	
	void setFilingStatus(int status) {
		this.filingStatus = status;
	}
	
	void setTaxableIncome(double income) {
		taxableIncome = income;
	}
	
	double[] getRates() {
		return rates;
	}
	
	void setRates(double rate[]) {
		rates = rate;
	}
	
	int[][] getIntervals() {
		return intervals;
	}
	
	void setIntervals(int interval[][]) {
		intervals = interval;
	}

	
	double getIncomeTax() { // 2009 overload
		int no = -1;
		boolean exit = false;
		for (int i = 0; i < 6 && !exit; i++)
			if (taxableIncome >= intervals[filingStatus][i]) {
				if (i < 5) {
					if (taxableIncome < intervals[filingStatus][i + 1]) {
						no = i;
						exit = true;					
					}					
				}
				else {
					no = i;
					exit = true;
				}	
			}
		double rate = rates[no];
		double tax = taxableIncome * rate / 100;
		return tax;
	}
	
	double getIncomeTax(boolean year) { // 2001 overload
		int no = -1;
		boolean exit = false;
		for (int i = 0; i < 5 && !exit; i++)
			if (taxableIncome >= intervals[filingStatus][i]) {
				if (i < 4) {
					if (taxableIncome < intervals[filingStatus][i + 1]) {
						no = i;
						exit = true;					
					}					
				}
				else {
					no = i;
					exit = true;
				}	
			}
		double rate = rates[no];
		double tax = taxableIncome * rate / 100;
		return tax;
	}
	
	public static void main(String[] args) {
		int interval2009[][] = {
				{0, 8351, 33951, 82251, 171551, 372951}, 
				{0, 16701, 67901, 137051, 208851, 372951},
				{0, 8351, 33951, 68526, 104426, 186476},
				{0, 11951, 45501, 117451, 190201, 372951}
		};
		double rate2009[] = {10, 15, 25, 28, 33, 35};
		int interval2001[][] = {
				{0, 27051, 65551, 136751, 297351},
				{0, 45201, 109251, 166501, 297351},
				{0, 22601, 54626, 83251, 148676},
				{0, 36251, 93651, 151651, 297351}
		};
		double rate2001[] = {15, 27.5, 30.5, 35.5, 39.1};
		
		Scanner input = new Scanner(System.in);
		int menu = 0;
		System.out.println("1- Compute personal income Tax");
		System.out.println("2- Print the tax tables for taxable incomes (with range)");
		System.out.println("0- Exit");
		
		menu = getIntRange(0, 2);
		while (menu != 0)
		{
			if (menu == 1)
			{
				System.out.println("0 - single filer");
				System.out.println("1 - married jointly or qualifying widow(er)");
				System.out.println("2 - married separately");
				System.out.println("3 - head of household");
				System.out.print("Enter the filing status: ");
				IncomeTax tax = new IncomeTax();
				int status = getIntRange(0, 3);
				tax.setFilingStatus(status); 
				System.out.print("Enter the Taxable Income: $");
				double income = input.nextDouble();
				tax.setTaxableIncome(income);
				tax.setIntervals(interval2009);
				tax.setRates(rate2009);
				double incomeTax = tax.getIncomeTax();
				System.out.println("Your tax is: $" +  incomeTax);
				menu = 0;
			}
			else if (menu == 2)
			{
				System.out.print("Enter the amount From: $");
				double low = input.nextDouble();
				System.out.print("Enter the amount To: $");
				double high = input.nextDouble();
				
				System.out.println("2001 tax tables for taxable income from $" + low + " to $" + high);
				System.out.println("------------------------------------------------------------------------------");
				System.out.println("Taxable Income   " + "Single       " + "Married        " + "Married       " + "Head of");
				System.out.println("                               Joint        " + "Seperate       " + "House");
				System.out.println("------------------------------------------------------------------------------");
				double income = low;
				IncomeTax tax1 = new IncomeTax();
				tax1.setIntervals(interval2001);
				tax1.setRates(rate2001);
				double fieldTax = 0;
				while (income <= high)
				{
					tax1.setTaxableIncome(income);
					System.out.format("%.2f        ", income);
					for (int status = 0; status < 4; status++)
					{
						tax1.setFilingStatus(status);
						fieldTax = tax1.getIncomeTax(true);
						System.out.format("%.2f      ", fieldTax);
					}
					System.out.print("\n");
					income += 1000;
				}
				System.out.print("\n\n\n");
				System.out.println("2009 tax tables for taxable income from $" + low + " to $" + high);
				System.out.println("------------------------------------------------------------------------------");
				System.out.println("Taxable Income   " + "Single       " + "Married        " + "Married       " + "Head of");
				System.out.println("                               Joint        " + "Seperate       " + "House");
				System.out.println("------------------------------------------------------------------------------");
				income = low;
				tax1.setIntervals(interval2009);
				tax1.setRates(rate2009);
				while (income <= high)
				{
					tax1.setTaxableIncome(income);
					System.out.format("%.2f        ", income);
					for (int status = 0; status < 4; status++)
					{
						tax1.setFilingStatus(status);
						fieldTax = tax1.getIncomeTax();
						System.out.format("%.2f      ", fieldTax);
					}
					System.out.print("\n");
					income += 1000;
				}
				menu = 0;
			}
		}
	}

	
	
	public static int getIntRange(int low, int high) { 
		Scanner input = new Scanner(System.in);
		int in;
		boolean invalid = false;
		do
		{
			in = input.nextInt();
			if (in < low || in > high)
			{
				System.out.println("Invalid input! Valid range is " + low + " to " + high);
				invalid = true;
			}
		} while(invalid);
		return in;
	}
}
