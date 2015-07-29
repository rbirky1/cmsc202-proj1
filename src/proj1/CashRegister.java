/**File Header
 * @file CashRegister.java
 * @project CMSC 202 - Fall 2012 - Project 1
 * @author Rachael Birky <rbirky1@umbc.edu>
 * @version 9/21/12
Ê* @section 02
 * */

package proj1;

/**
Ê* This class represents a cash register.
 * It can...
 * 	empty, lock, unlock itself
 * 	add and remove money from itself
 * 	return its contents (bills)
 * 	calculate and return the total monetary
 *   value of its contents (bills)
Ê*/

public class CashRegister {
	
	private int numOnes;
	private int numFives;
	private int numTens;
	private int numTwenties;
	private int total;
	private boolean isLocked;
	
	/**
	 * @name CashRegister
	 * @description Creates a new cash register instance, locked,
	 * 				 	with initial monetary value of zero
	 * Precondition: none
	 * Postcondition: A CashRegister is created and its instance
	 * 					variables initialized
	 * @param none
	 * @return none
	 */
	public CashRegister(){
		numOnes = 0;
		numFives = 0;
		numTens = 0;
		numTwenties = 0;
		total = 0;
		isLocked = true;
	}
	
	/**
	 * @name addMoney
	 * @description Adds the number of bills specified to the instance variables
	 * Precondition: aNumOnes,aNumFives, aNumTens, and aNumTwenties
	 * 					must not be negative
	 * Postcondition: The parameter value is added to the appropriate instance variable
	 * @param Integer values representing the number of bills to add in the order:
	 * 			ones, fives, tens, twenties
	 * @return none 
	 */
	public void addMoney(int aNumOnes, int aNumFives, int aNumTens, int aNumTwenties){
		//Throw exception if value is invalid (negative)
		// add to current value if valid
		if (aNumOnes < 0)
			throw new RuntimeException("Cannot add a negative amount");
		else
			numOnes+=aNumOnes;
		
		if (aNumFives < 0)
			throw new RuntimeException("Cannot add a negative amount");
		else
			numFives+=aNumFives;
		
		if (aNumTens < 0)
			throw new RuntimeException("Cannot add a negative amount");
		else
			numTens+=aNumTens;
		
		if (aNumTwenties < 0)
			throw new RuntimeException("Cannot add a negative amount");
		else
			numTwenties+=aNumTwenties;
	}
	
	/**
	 * @name removeMoney
	 * @description Subtracts the number of bills specified from the instance variables
	 * Precondition: aNumOnes,aNumFives, aNumTens, and aNumTwenties
	 * 					must not be negative or greater than the current instance variable value
	 * Postcondition: The parameter value is removed to the appropriate instance variable
	 * @param Integer values representing the number of bills to be removed in the order:
	 * 			ones, fives, tens, twenties
	 * @return none
	 */
	public void removeMoney(int aNumOnes, int aNumFives, int aNumTens, int aNumTwenties){
		if (aNumOnes < 0 || aNumOnes > numOnes)
			throw new RuntimeException("Cannot remove negative value OR insufficient funds");
		else
			numOnes-=aNumOnes;
		
		if (aNumFives < 0 || aNumFives > numFives)
			throw new RuntimeException("Cannot remove negative value OR insufficient funds");
		else
			numFives-=aNumFives;
		
		if (aNumTens < 0 || aNumTens > numTens)
			throw new RuntimeException("Cannot remove negative value OR insufficient funds");
		else
			numTens-=aNumTens;
		
		if (aNumTwenties < 0 || aNumTwenties > numTwenties)
			throw new RuntimeException("Cannot remove negative value OR insufficient funds");
		else
			numTwenties-=aNumTwenties;
	}
	
	/**
	 * @name unlock
	 * @description Sets the CashRegister instance variable "isLocked" to false
	 * Precondition: isLocked is a boolean variable; declared & initialized
	 * Postcondition: The CashRegister is unlocked ("isLocked" = false)
	 * @param none
	 * @return none
	 */
	public void unlock(){
		isLocked = false;
	}
	
	/**
	 * @name lock
	 * @description Sets the CashRegister instance variable "isLocked" to true
	 * Precondition: isLocked is a boolean variable; declared & initialized
	 * Postcondition: The CashRegister is unlocked ("isLocked" = true)
	 * @param none
	 * @return none
	 */
	public void lock(){
		isLocked = true;
	}
	
	/**
	 * @name isLocked
	 * @description Returns the value of the boolean isLocked
	 * Precondition: isLocked is a boolean variable; declared & initialized
	 * Postcondition: isLocked is returned (value of true or false)
	 * @param none
	 * @return Returns a boolean: true if the CashRegister is locked,
	 * 			false if it is unlocked.
	 */
	public boolean isLocked(){
		return isLocked;
	}

	/**
	 * @name getNumOnes
	 * @description Returns an integer value representing the number
	 * 					of one dollar bills in the CashRegister
	 * Precondition: numOnes has been declared & initialized
	 * Postcondition: numOnes is returned
	 * @param none
	 * @return Returns and integer: the number of one dollar bills
	 */
	public int getNumOnes(){
		return numOnes;
	}
	
	/**
	 * @name getNumFives
	 * @description Returns an integer value representing the number
	 * 					of five dollar bills in the CashRegister
	 * Precondition: numFives has been declared & initialized
	 * Postcondition: numFives is returned
	 * @param none
	 * @return Returns and integer: the number of five dollar bills
	 */
	public int getNumFives(){
		return numFives;
	}
	
	/**
	 * @name getNumTens
	 * @description Returns an integer value representing the number
	 * 					of ten dollar bills in the CashRegister
	 * Precondition: numTens has been declared & initialized
	 * Postcondition: numTens is returned
	 * @param none
	 * @return Returns and integer: the number of ten dollar bills
	 */
	public int getNumTens(){
		return numTens;
	}
	
	/**
	 * @name getNumTwenties
	 * @description Returns an integer value representing the number
	 * 					of twenty dollar bills in the CashRegister
	 * Precondition: numTwenties has been declared & initialized
	 * Postcondition: numTwenties is returned
	 * @param none
	 * @return Returns and integer: the number of twenty dollar bills
	 */
	public int getNumTwenties(){

		return numTwenties;
	}
	
	/**
	 * @name getTotal
	 * @description Calculates the total monetary value by multiplying the number
	 * 					of each type of bill by its respective value;
	 * 				Returns this value as an integer
	 * Precondition: aNumOnes,aNumFives, aNumTens, and aNumTwenties must be
	 * 					declared and initialized
	 * Postcondition: Returns an integer value representing the total
	 * @param none
	 * @return Returns and integer: the total monetary value of the bills
	 */
	public int getTotal(){
		total = (numOnes*1)+(numFives*5)+(numTens*10)+(numTwenties*20);
		return total;
	}
	
	/**
	 * @name empty
	 * @description "Empties" the CashRegister by setting all bill instance variables to
	 * 					zero and "locking" the register by setting isLocked to true
	 * Precondition: All instance variables must be declared 
	 * Postcondition: All instance variables are reset to their default value 
	 * @param none
	 * @return none
	 */
	public void empty(){
		numOnes = 0;
		numFives = 0;
		numTens = 0;
		numTwenties = 0;
		total = 0;
		isLocked = true;
	}
	
	/**
	 * @name getBills
	 * @description Gets the number of bills associated with the provided bill type
	 * Precondition: aNumOnes,aNumFives, aNumTens, and aNumTwenties must be declared
	 * 					billType must be a valid bill type (ones, fives, tens, twenties)
	 * Postcondition: bill type quantity is returned
	 * @param billType - a string used to determine which bill value to return
	 * @return quantity of indicated bill type
	 */
	public int getBills(String billType){
		if (billType.equalsIgnoreCase("ones"))
			return numOnes;
		else if (billType.equalsIgnoreCase("fives"))
			return numFives;
		else if (billType.equalsIgnoreCase("tens"))
			return numTens;
		else if(billType.equalsIgnoreCase("twenties"))
			return numTwenties;
		else
			throw new RuntimeException("Invalid billType.");
	}
}
