/**********************************************
Workshop #10
Course: JAC444 - Semester Winter 2022
Last Name: Valaee Asr
First Name: Arman
ID: 139550206
Section: ZBB
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature A.V.A
Date: 2022-4-17
**********************************************/

package task2;

public class Banks {

    static double[][][] mBanks = new double[5][][];
    public static void main(String[] args) {

        //Bank #0
        mBanks[0] = new double[3][2];
        mBanks[0][0][0] = 25;
        
        mBanks[0][1][0] = 1;
        mBanks[0][1][1] = 100.5;
        
        mBanks[0][2][0] = 4;
        mBanks[0][2][1] = 320.5;
        
        //Bank #1
        mBanks[1] = new double[3][2];
        mBanks[1][0][0] = 125;
        
        mBanks[1][1][0] = 2;
        mBanks[1][1][1] = 40;
        
        mBanks[1][2][0] = 3;
        mBanks[1][2][1] = 85;
        
        //Bank #2
        mBanks[2] = new double[3][2];
        mBanks[2][0][0] = 175;
        
        mBanks[2][1][0] = 0;
        mBanks[2][1][1] = 125;
        
        mBanks[2][2][0] = 3;
        mBanks[2][2][1] = 75;
        
        //Bank #3
        mBanks[3] = new double[2][2];
        mBanks[3][0][0] = 75;
        
        mBanks[3][1][0] = 0;
        mBanks[3][1][1] = 125;
        
      //Bank #4
        mBanks[4] = new double[2][2];
        mBanks[4][0][0] = 181;
        
        mBanks[4][1][0] = 2;
        mBanks[4][1][1] = 125;

        boolean[] unsafeBank = checkBanks();

        for (int i = 0; i < unsafeBank.length; i++) 
        	if (unsafeBank[i] == true)
        		System.out.println("Bank #" + i + " is unsafe!");
    }

    public static boolean[] checkBanks() {

        boolean[] unsafeBanks = new boolean[mBanks.length];
        double total;
        boolean isSafe = false;

        while (!isSafe) {
            isSafe = true;
            for (int banks = 0; banks < mBanks.length; banks++) {
                total = mBanks[banks][0][0];
                for (int LoanedBanks = 1; LoanedBanks < mBanks[banks].length; LoanedBanks++) {
                    int index = (int)mBanks[banks][LoanedBanks][0];
                    if (!unsafeBanks[index])
                        total += mBanks[banks][LoanedBanks][1];
                }

                if (total < 201 && !unsafeBanks[banks]) {
                    unsafeBanks[banks] = true;
                    isSafe = false;
                }
            }
        }
        return unsafeBanks;
    }



}