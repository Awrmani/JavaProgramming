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

public class TestClass2 {

	public static void main(String[] args) {
		try
		{
			TriangleWithException correct = new TriangleWithException(7, 5, 3);
			TriangleWithException wrong = new TriangleWithException(5, 2, 10);
		}
		catch(TriangleException e) {
			System.out.print(e);
		}
	}
}
