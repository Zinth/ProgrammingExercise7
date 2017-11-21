/** Program: Palindromic Prime Numbers
* File: PalindromicPrimeNumbers.java
* Summary: Loops through the first 100,000 integers and lists all the Prime Palindromic Integers.  
* Author: Chris Hyde
* Date: November 21, 2017 
**/



public class PalindromicPrimeNumbers {

	public static void main(String[] args) {
		int counter = 0; // counter for the do/while loop
		int lineCounter = 0; // counter for determining when a new line should be started.
		String primePalindroms = ""; // string to store the numbers that are prime and palindromic.
		
		//Loop through the first 100,000 numbers and find every prime palindromic number. 
		do { // Start do/while loop 
			
			//Test if the number counter represents is prime and pralidromic
			if (isPalindrom(counter) && isPrime(counter)) {
				primePalindroms += String.format("%-8d", counter); // add the prime palidromic number to primePalindroms with min 3 space padding. 
				lineCounter++;
			}
			
			//Test if lineCounter = 4 and add "\n" to format columns correctly
			if(lineCounter == 4) {
				primePalindroms += "\n"; // Separate the list of prime palindromic numbers into 4 columns
				lineCounter = 0; // Reset line counter.
			}
			
			counter++; // Increment the counter
			
		}while(counter <= 100000); // End do/while loop
		
		// Print the primePalindroms formated list to the console. 
		System.out.println("Prime Palindromic Numbers in the first 100,000 integers:\n" + primePalindroms);

	}
	
	// Method for determining if a number is Palindromic 
	public static Boolean isPalindrom(int num) {
		int possiblePal = num; // Set the possible Palindrom to = num 
		int reversed = 0; // variable that will hold the reverse of num
		
		//Loop until possiblePal = 0
		while(possiblePal != 0) {
			int remainder = possiblePal % 10; // get digit in the ones place as a remainder
			reversed = reversed * 10 + remainder; // reverse the order by adding the remainder and moving the previous reverse over one.
			possiblePal = possiblePal / 10; // remove the first digit from possiblePal and repeat until possiblePal = 0
		}
		
		// Compare the original number to the reversed version of it and return result. 
		if (num == reversed) {
			return true;
		} else {
			return false;
		}
	}
	
	// Method to determine if a number a number is prime
	public static Boolean isPrime(int num) {
		//Check if number is less than 2 (the first prime) if true return false
		if (num <= 1) { // also since 1 and the num are the only factors in a prime
			return false;
		}
		
		//Loop through every possible factor of the number starting with 2
		for(int i = 2; i < num; i++) { 
			if (num % i == 0) {
				return false; // return false 
			}
		}
		return true; // return true if it gets past the for loop as the number has no other factors but 1 and itself. 
	}

}
