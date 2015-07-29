/**File Header
 * @file Project1.java
 * @project CMSC 202 - Fall 2012 - Project 1
 * @author Rachael Birky <rbirky1@umbc.edu>
 * @version 9/21/12
Ê* @section 02
 * */

package proj1;

import java.util.Scanner;

/**
Ê* This class is a user interface that regulates the interaction between
 * the user and the CashRegister class to simulate a convenience store.
Ê*/
public class Project1 {
	
	static Scanner input = new Scanner(System.in);

	/**
	 * @name firstAddMoney
	 * @description Adds the initial amount of bills to both registers when the store is opened
	 * Precondition: aReg1 and aReg2 must be declared
	 * Postcondition: numOnes, numFives, numTens, numTwenties is added to the cash register
	 * 					instance variables
	 * @param CashRegister aReg1 - first cash register
	 * @param CashRegister aReg2 - second cash register
	 * @return none 
	 */
	private static void firstAddMoney(CashRegister aReg1, CashRegister aReg2){
		
		System.out.print("Adding money to both registers....\n");
		
		//Variable to hold user input (number of bills)
		//Calls getNumBills to re-use code
		int numOnes = getNumBillsAdd("ones");
		int numFives = getNumBillsAdd("fives");
		int numTens = getNumBillsAdd("tens");
		int numTwenties = getNumBillsAdd("twenties");
		input.nextLine();
		
		//Add amounts to registers (same amount in each)
		aReg1.addMoney(numOnes, numFives, numTens, numTwenties);
		aReg2.addMoney(numOnes, numFives, numTens, numTwenties);
	}
	
	/**
	 * @name addMoney
	 * @description adds the user-defined number of bills to the user-defined
	 * 					cash register
	 * Precondition: aReg1 and aReg2 must be declared
	 * 				numOnes, numFives, numTens, numTwenties must be non-negative integer values
	 * Postcondition: numOnes, numFives, numTens, numTwenties is added to the cash register
	 * 					instance variables 
	 * @param CashRegister aReg1 - first cash register
	 * @param CashRegister aReg2 - second cash register 
	 * @return none 
	 */
	private static void addMoney(CashRegister aReg1, CashRegister aReg2){
		
		//Get valid register number
		System.out.print("\nAdd money to which register? (1 or 2): ");
		int regNum = input.nextInt();
		regNum = isValidReg(regNum);
		input.nextLine();
		
		CashRegister thisReg;
		
		if (regNum == 1)
			thisReg = aReg1;
		else
			thisReg = aReg2;
		
		if (!thisReg.isLocked()){
			//Get user input
			System.out.print("How many ones? ");
			int numOnes = input.nextInt();
			System.out.print("How many fives? ");
			int numFives = input.nextInt();
			System.out.print("How many tens? ");
			int numTens = input.nextInt();
			System.out.print("How many twenties? ");
			int numTwenties = input.nextInt();
			input.nextLine();
			
			//Validate user input. Cannot be negative.
			//I originally validated and notified the user after each input
			// but the project outline says to do this instead...
			if (numOnes>=0 && numFives>=0 && numTens>=0 && numTwenties>=0)
				//Add values to appropriate register
				thisReg.addMoney(numOnes, numFives, numTens, numTwenties);
			else
				System.out.println("\n*Sorry, you entered an invalid (negative) value. Try again.*");
		}
		else
			System.out.println("*Sorry, this register is locked. You must unlock it before use.*");
	}
	
	/**
	 * @name removeMoney
	 * @description Removes the user-defined number of bills from the user-defined
	 * 					cash register
	 * Precondition: aReg1 and aReg2 must be declared
	 * 				numOnes, numFives, numTens, numTwenties must be non-negative integer values,
	 * 					no greater than the number of bills already in the cash register
	 * Postcondition: numOnes, numFives, numTens, numTwenties is removed from the cash register
	 * 					instance variables 
	 * @param CashRegister aReg1 - first cash register
	 * @param CashRegister aReg2 - second cash register 
	 * @return none  
	 */
	private static void removeMoney(CashRegister aReg1, CashRegister aReg2){
		
		//Get valid register number
		System.out.print("\nRemove money from which register? (1 or 2): ");
		int regNum = input.nextInt();
		regNum = isValidReg(regNum);
		input.nextLine();
		
		CashRegister thisReg;
		if (regNum == 1)
			thisReg = aReg1;
		else
			thisReg = aReg2;
		
		if(!thisReg.isLocked()){
		
		//Get user input
		System.out.print("How many ones? ");
		int numOnes = input.nextInt();
		System.out.print("How many fives? ");
		int numFives = input.nextInt();
		System.out.print("How many tens? ");
		int numTens = input.nextInt();
		System.out.print("How many twenties? ");
		int numTwenties = input.nextInt();
		input.nextLine();
		
		//Validate user input.
		//I originally validated and notified the user after each input (see below)
		// but the project outline says to do this instead...
			if (numOnes<=thisReg.getNumOnes() && numFives<=thisReg.getNumFives() 
					&& numTens<=thisReg.getNumTens() && numTwenties<=thisReg.getNumTwenties()
					&& numOnes>=0 && numFives>=0 && numTens>=0 && numTwenties>=0)
				thisReg.removeMoney(numOnes, numFives, numTens, numTwenties);
			else
				System.out.println("\n*Sorry, you entered a negative value or there are insufficient funds. Try again.*");}

			//Error message if register is locked; return to menu so user can unlock it
		else
			System.out.println("*Sorry, this register is locked. You must unlock it before use.*");
	}
	
	/**
	 * @name transferMoney
	 * @description Removes the user-defined number of bills from the user-defined
	 * 					cash register and adds them to the other cash register 
	 * Precondition: aReg1 and aReg2 must be declared
	 * 				numOnes, numFives, numTens, numTwenties must be non-negative integer values,
	 * 					no greater than the number of bills already in the cash register
	 * Postcondition: numOnes, numFives, numTens, numTwenties is removed from the cash register
	 * 					instance variables and added to the other cash register's instance variables
	 * @param CashRegister aReg1 - first cash register
	 * @param CashRegister aReg2 - second cash register 
	 * @return none 
	 */
	private static void transferMoney(CashRegister aReg1, CashRegister aReg2){
		
		CashRegister thisReg;
		CashRegister otherReg;
		
		//Get valid register number
		System.out.print("\nTransfer money from which register? (1 or 2): ");
		int regNum = isValidReg(input.nextInt());
		input.nextLine();
		
		//Alias chosen register and other register
		if (regNum == 1){
			thisReg = aReg1;
			otherReg = aReg2;
		}
		else{
			thisReg = aReg2;
			otherReg = aReg1;
		}
		
		//If both registers are unlocked, proceed to get user input
		if(!thisReg.isLocked() && !otherReg.isLocked()){
			//Get user input
			System.out.print("How many ones? ");
			int numOnes = input.nextInt();
			System.out.print("How many fives? ");
			int numFives = input.nextInt();
			System.out.print("How many tens? ");
			int numTens = input.nextInt();
			System.out.print("How many twenties? ");
			int numTwenties = input.nextInt();
			input.nextLine();
			
			//Validate user input
			if (numOnes<=thisReg.getNumOnes() && numFives<=thisReg.getNumFives() 
					&& numTens<=thisReg.getNumTens() && numTwenties<=thisReg.getNumTwenties()
					&& numOnes>=0 && numFives>=0 && numTens>=0 && numTwenties>=0){
				thisReg.removeMoney(numOnes, numFives, numTens, numTwenties);
				otherReg.addMoney(numOnes, numFives, numTens, numTwenties);}
			else
				System.out.println("\n*Sorry, you entered a negative value or there are insufficient funds. Try again.*");}
		
		//Error messages if one or both registers are locked
		else if (thisReg.isLocked() && otherReg.isLocked())
			System.out.println("*Sorry, both registers are locked. You must unlock them before use.*");
		else if (thisReg.isLocked())
			System.out.println("*Sorry, register "+regNum+" is locked. You must unlock it before use.*");
		else
			System.out.println("*Sorry, the other register is locked. You must unlock it before use.*");
		//Return to menu so user can unlock appropriate registers
	}
	
	/**
	 * @name lockReg
	 * @description Locks the user-defined register
	 * Precondition: aReg1 and aReg2 must be declared
	 * Postcondition: Locks the appropriate cash register by setting the
	 * 					instance variable isLocked to true.
	 * @param CashRegister aReg1 - first cash register
	 * @param CashRegister aReg2 - second cash register 
	 * @return none 
	 */
	private static void lockReg(CashRegister aReg1, CashRegister aReg2){
		
		//Get valid register number
		System.out.print("Lock which register? (1 or 2): ");
		int regNum = isValidReg(input.nextInt());
		input.nextLine();
		
		//Call register method of correct register to lock
		if (regNum == 1){
			if (aReg1.isLocked())
				System.out.println("This register is already locked.");
			else{
				aReg1.lock();
				System.out.println("Register 1 has been locked.");}}
		else{
			if (aReg2.isLocked())
				System.out.println("This register is already locked.");
			else{
				aReg2.lock();
				System.out.println("Register 2 has been locked.");}}
	}
	
	/**
	 * @name unlockReg
	 * @description Unlocks the user-defined register
	 * Precondition: aReg1 and aReg2 must be declared
	 * Postcondition: Unlocks the appropriate cash register by setting the
	 * 					instance variable isLocked to false.
	 * @param CashRegister aReg1 - first cash register
	 * @param CashRegister aReg2 - second cash register 
	 * @return none  
	 */
	private static void unlockReg(CashRegister aReg1, CashRegister aReg2){
		
		//Get valid register number
		System.out.print("Unlock which register? (1 or 2): ");
		int regNum = isValidReg(input.nextInt());
		input.nextLine();
		
		//Call register method of correct register to lock
		if (regNum == 1){
			if (!aReg1.isLocked())
				System.out.println("This register is already unlocked.");
			else{
				aReg1.unlock();
				System.out.println("Register 1 has been unlocked.");}}
		else{
			if (!aReg2.isLocked())
				System.out.println("This register is already unlocked.");
			else{
				aReg2.unlock();
				System.out.println("Register 2 has been unlocked.");}}
	}
	
	/**
	 * @name displayReg
	 * @description Displays the status of the user-defined cash register
	 * 				in formatted Strings
	 * Precondition: aReg1 and aReg2 must be declared
	 * 				numOnes, numFives, numTens, numTwenties must be declared
	 * 					 and initialized
	 * Postcondition: Prints the status to the screen
	 * @param CashRegister aReg1 - first cash register
	 * @param CashRegister aReg2 - second cash register
	 * @return none 
	 */
	private static void displayReg(CashRegister aReg1, CashRegister aReg2){
		
		//Get valid register number
		System.out.print("\nDisplay status of which register? (1 or 2): ");
		int regNum = isValidReg(input.nextInt());
		input.nextLine();
		
		//Set temporary CashRegister variable as alias to correct register object
		CashRegister thisReg;
		if (regNum == 1)
			thisReg = aReg1;
		else
			thisReg = aReg2;
		
		//Create string versions of boolean returned by CashRegister method isLocked()
		String isLocked;
		if (thisReg.isLocked())
			isLocked = "locked";
		else
			isLocked = "unlocked";
		
		//Print formatted status
		System.out.println("\nRegister "+regNum+" is "+isLocked+".");
		System.out.printf("This register has %d one dollar bill(s),", thisReg.getNumOnes());
		System.out.printf("\n%19d five dollar bill(s),", thisReg.getNumFives());
		System.out.printf("\n%19d ten dollar bill(s),", thisReg.getNumTens());
		System.out.printf("\nand %15d twenty dollar bill(s),", thisReg.getNumTwenties());
		System.out.printf("\nFor a total of $%3d.\n", thisReg.getTotal());
		
	}
	
	private static void displayBothReg(CashRegister aReg1, CashRegister aReg2){
		//Create string versions of boolean returned by CashRegister method isLocked()
		// First Register
			
				String isLockedOne;
				if (aReg1.isLocked())
					isLockedOne = "locked";
				else
					isLockedOne = "unlocked";
				
				//Print formatted status
				System.out.println("\nRegister 1 is "+isLockedOne+".");
				System.out.printf("This register has %d one dollar bill(s),", aReg1.getNumOnes());
				System.out.printf("\n%19d five dollar bill(s),", aReg1.getNumFives());
				System.out.printf("\n%19d ten dollar bill(s),", aReg1.getNumTens());
				System.out.printf("\nand %15d twenty dollar bill(s),", aReg1.getNumTwenties());
				System.out.printf("\nFor a total of $%3d.\n", aReg1.getTotal());
			
		//Create string versions of boolean returned by CashRegister method isLocked()
		//Second Register
				String isLockedTwo;
				if (aReg1.isLocked())
					isLockedTwo = "locked";
				else
					isLockedTwo = "unlocked";
				
				//Print formatted status
				System.out.println("\nRegister 2 is "+isLockedTwo+".");
				System.out.printf("This register has %d one dollar bill(s),", aReg2.getNumOnes());
				System.out.printf("\n%19d five dollar bill(s),", aReg2.getNumFives());
				System.out.printf("\n%19d ten dollar bill(s),", aReg2.getNumTens());
				System.out.printf("\nand %15d twenty dollar bill(s),", aReg2.getNumTwenties());
				System.out.printf("\nFor a total of $%3d.\n", aReg2.getTotal());
	}
	
	/**
	 * @name openStore
	 * @description "Opens" the store by unlocking both registers and calling the
	 * 				firstAddMoney method to add the initial amount of bills to both registers
	 * Precondition: aReg1 and aReg2 must be declared
	 * Postcondition: Sets the instance variable isLocked of both register objects to false
	 * 					Calls firstAddMoney to add initial number of bills
	 * @param CashRegister aReg1 - first cash register
	 * @param CashRegister aReg2 - second cash register
	 * @return none 
	 */
	private static void openStore(CashRegister aReg1, CashRegister aReg2){
		aReg1.unlock();
		aReg2.unlock();
		
		//Call method to input initial monetary values
		firstAddMoney(aReg1, aReg2);
	}
	
	/**
	 * @name closeStore
	 * @description "Closes" the store by emptying and locking both registers
	 * Precondition: aReg1 and aReg2 must be declared
	 * Postcondition: Calls the empty method of both cash registers to set the bill instance 
	 * 					variables to zero and the instance variable isLocked of both register 
	 * 					objects to true
	 * @param CashRegister aReg1 - first cash register
	 * @param CashRegister aReg2 - second cash register
	 * @return none 
	 */
	private static void closeStore(CashRegister aReg1, CashRegister aReg2){
		displayBothReg(aReg1, aReg2);		
		aReg1.empty();
		aReg2.empty();
	}

	/**
	 * @name displayMenu
	 * @description Prints the menu to the screen for user
	 * Precondition: none
	 * Postcondition: Prints options to the screen 
	 * @param none
	 * @return none 
	 */
	private static void displayMenu(){
		System.out.println("\nA - Add money\nR - Remove money\nT - Transfer money\nL - Lock register\nU - Unlock register\nS - Display register state\nC - Close the store and quit");
	}
	
	/**
	 * @name isValidChoice
	 * @description Verifies user input of menu option
	 * Precondition: aChoice must be declared and initialized (by user input)
	 * 				must be a character type variable
	 * Postcondition: Verifies the choice is on the menu
	 * @param aChoice - the user-defined menu option chosen
	 * @return true if the choice is on the menu, false if it is not
	 */
	private static boolean isValidChoice(char aChoice){
		switch (aChoice){
			case 'A':
			case 'R':
			case 'T':
			case 'L':
			case 'U':
			case 'S':
			case 'C':
				return true;
			default:
				return false;
		}
	}
	
	/**
	 * @name isValidChoice
	 * @description Verifies user input of register number (1 or 2)
	 * Precondition: regNum must be declared and initialized (by user input)
	 * 				must be an integer type variable
	 * Postcondition: Verifies the choice is 1 or 2
	 * @param regNum - the user-defined register number chosen
	 * @return true if the value is 1 or 2, false if it is not
	 */
	private static int isValidReg(int regNum){
		while (regNum!=1 && regNum!=2){
			System.out.print("*Invalid choice.* Please choose again: ");
			regNum = input.nextInt();
		} 
		return regNum;
	}
	
	/**
	 * @name getNumBillsAdd
	 * @description A prompt and validation loop to ensure the user has
	 * 				entered a non-negative integer of number of bills
	 * 				to add to the register
	 * Precondition: billType must be declared and initialized
	 * Postcondition: A valid number of bills is defined and chosen, returned
	 * 					to be added to appropriate register 
	 * @param billType - ones, fives, tens, twenties; used to modify prompt
	 * 			for appropriate question of "how many...?"
	 * @return numBills - the final valid user-defined number of bills
	 */
	private static int getNumBillsAdd(String billType){
	
	//Validate user input of bills count
	//  Cannot be negative, cannot be more than amount in register
	int numBills;
	do{
		System.out.print("How many "+billType+"? ");
		numBills = input.nextInt();
		if (numBills<0)
			System.out.println("*Cannot add a negative amount. Try again*");
		} while(numBills<0);
	return numBills;
	}
	
	/**
	 * @name main
	 * @description The main method of the program that runs and calls the other methods
	 * 				to simulate a cash register user interface program
	 * Precondition: none
	 * Postcondition: The user will successfully interact with two cash register objects to
	 * 					perform the desired operations
	 * @param String[]args - the command line arguments (unused in this project)
	 * @return none 
	 */
	public static void main(String[] args){
		
		//Declare registers 1 and 2
		CashRegister reg1 = new CashRegister();
		CashRegister reg2 = new CashRegister();
		
		System.out.println("Welcome to our convenience store cash register interface!\n");
		//Open store by unlocking reg 1 and 2 and setting in initial amounts
		openStore(reg1, reg2);
		
		//Flow control variables
		boolean isValid;
		char choice;
		
		//Display menu, get user input, until they choose to quit ('C')
		do{
			//Menu choice validation loop
			do{
				displayMenu();
				
				//Prompt user for input, store in choiceStr
				System.out.print("\nSelect from the menu above: ");
				String choiceStr = input.nextLine();
				
				//Verify input, if none, repeat prompt
				while (choiceStr.equals("")){
					System.out.print("\nPlease enter a character from the menu: ");
					choiceStr = input.nextLine();}
				
				//Convert input to char for comparison
				choiceStr = choiceStr.toUpperCase();
				choice = choiceStr.charAt(0);
				
				//Validate user choice
				isValid = isValidChoice(choice);
		
				//If invalid, notify user
				if (!isValid)
					System.out.println("\n*Invalid option! Try again*");
				
			} while(!isValid);
		
			//Call appropriate menu method
			switch (choice){
			case 'A':
				addMoney(reg1, reg2);
				break;
			case 'R':
				removeMoney(reg1, reg2);
				break;
			case 'T':
				transferMoney(reg1, reg2);
				break;
			case 'L':
				lockReg(reg1, reg2);
				break;
			case 'U':
				unlockReg(reg1, reg2);
				break;
			case 'S':
				displayReg(reg1, reg2);
				break;
			case 'C':
				closeStore(reg1, reg2);
				break;
			}
		
		} while (choice!='C');

		System.out.println("\nGoodbye!"); 
	}
}
