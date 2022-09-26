/**********************************************
Workshop #4
Course: JAC444 - Semester Winter 2022
Last Name: Valaee Asr
First Name: Arman
ID: 139550206
Section: ZBB
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature A.V.A
Date: 2022-2-20
**********************************************/

package task1;

import java.io.*;
import java.util.Scanner;

public class Hangman {
	
	int count = 0;
	String word, buffer = "";
	boolean visible[] = { false };
	public boolean complete = false;
	String wordle = null;

	Hangman() {
		word = "hello";
	}
	
	void readFile() {
		String text = null;
		try(BufferedReader br = new BufferedReader(new FileReader("hangman.txt"))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    text = sb.toString();
		} catch (FileNotFoundException e) {
			System.out.println("NO FILE");
		} catch (IOException e) {
			e.printStackTrace ();
		}
		text = text.toLowerCase();
		// Randomly choose a word
		int rand = (int) (Math.random() * text.lastIndexOf(32));
		int pos1 = text.indexOf(32, rand);
		int pos2 = text.indexOf(32, pos1 + 1);
		word = text.substring(pos1 + 1, pos2);
		visible = new boolean[word.length()];
		System.out.println("Our word is: " + word);
	}
	
	void resetWordDisplay() {
		wordle = "";
		complete = true;
		for (int i = 0; i < word.length(); i++)
			if (visible[i])
				wordle += word.charAt(i);
			else {
				wordle += '*';
				complete = false;
			}
	}
	
	void play() {
		Scanner reader = new Scanner(System.in);
		boolean found = false;
		boolean exit = false;
		resetWordDisplay();
		System.out.print("Guess a Letter in word " + wordle + " >");
		char input = reader.next().charAt(0);
		for (int i = 0; i < word.length() && !exit; i++) {
			if (input == word.charAt(i) && !visible[i]) {
				visible[i] = true;
				found = true;
			}
			else if (visible[i] && !found && word.charAt(i) == input) {
				System.out.println(input + " is already in the word!");
				exit = true;
			}			
		}
		if (!found && !exit)
		{
			if (buffer.contains(String.valueOf(input)))
				System.out.println("You have already tried " + input + ", try a new letter!");
			else {
				System.out.println(input + " is not in the word!");
				buffer += input;
				++count;
			}
		}
		else
			resetWordDisplay();
	}
	
	boolean getComplete() {
		return complete;
	}
	
	int getMissed() {
		return count;
	}
	
	String getWord() {
		return word;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int menu = -1;
		do {
			System.out.println("1- Play Hangman");
			System.out.println("0- Exit");
			System.out.print("Please Enter an option from menu: ");
			menu = getIntRange(0, 1);
			System.out.println("\n--------------------------------------\n");
			if (menu == 1) {
				Hangman hangman = new Hangman();
				hangman.readFile();
				do {
					hangman.play();
				} while (!hangman.getComplete());
				System.out.println("The word is " + hangman.getWord() + "!");
				System.out.println("You missed " + hangman.getMissed() + " time!");
				System.out.println("\n--------------------------------------\n");
			}
		} while (menu == 1);
		System.out.print("Thank you for playing!");
	}
	
	public static int getIntRange(int low, int high) { 
		Scanner input = new Scanner(System.in);
		int in;
		boolean invalid = false;
		do
		{
			invalid = false;
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
