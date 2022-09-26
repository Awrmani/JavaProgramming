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

package task2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LetterOccurence {
	String filename = null;
	String text = null;
	
	LetterOccurence() {}
	
	void readFile() {
		try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    text = sb.toString();
		} catch (FileNotFoundException e) {
			System.out.println("Wrong File Name");
		} catch (IOException e) {
			e.printStackTrace ();
		}
	}
	
	void printOccurences() {
		int CNT = 0;
		for (int ASCII = 65; ASCII < 123; ASCII++) {
			for (int i = 0; i < text.length(); i++) {
				if(text.charAt(i) == ASCII)
					++CNT;
			}
			System.out.println("Number of letter " + (char) ASCII + "'s: " + CNT);
			CNT = 0;
			if (ASCII == 90)
				ASCII += 6;
		}
	}
	
	void setFileName(String filename) {
		this.filename = filename;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		LetterOccurence occ = new LetterOccurence();
		System.out.print("Enter the file name: ");
		String filename = input.nextLine();
		occ.setFileName(filename);
		occ.readFile();
		occ.printOccurences();
	}
}
