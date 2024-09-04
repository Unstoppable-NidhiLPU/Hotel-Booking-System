package testexception;

import java.util.Scanner;

public class TestException {

	public static void main(String[] args) {

      /*
       * try
       * catch 
       * finally 
       * throw
       * throws
       */
		
//		Scanner scanner = new Scanner(System.in);
//		
//	int dividant =scanner.nextInt();
//	int divisor = scanner.nextInt();
	
		
//	try {
//		int result = dividant/divisor;
//		System.out.println("The result is : "+  result);
//		
//	} catch (ArithmeticException e) {
//	System.out.println("This is from catch block : "+ e.getMessage());
//	}
//		

		
		int array[]= new int[5];
		
		//array[6]=15;
	
//		try {
//			//array[6]=25/0;
//			
//			array[6]=10/0;
//		} catch ( ArithmeticException e) {
//			System.out.println("This is from ArithmeticException  block : " + e.getMessage());
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("This is from ArrayIndexOutOfBoundsException  block : " + e.getMessage());
//
//		}
//		try {
//			//array[6]=25/0;
//			
//			System.out.println("our program is running without any issue");
//		} catch ( ArithmeticException | ArrayIndexOutOfBoundsException e) {
//			System.out.println("This is from catch  block : " + e.getMessage());
//		} finally {
//			System.out.println("this executes without any problem");
//		}
		
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Please enter your age :");
//		int age = scanner.nextInt();
		
//		if(age<18) {
//			throw new RuntimeException("You are not eligible to vote!!");
//		}else {
//			System.out.println("You are eligible to vote!!");
//		}
		
		
		
		try {
			int arry[] = new int[3];
			
			arry[10]=9;
			int result = divide(10, 5);
			System.out.println("Result" + result);
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
		
	}
	
	public static int divide(int a,int b)throws Exception {
		
		if(b==0) {
			throw new Exception("Division by zero");
		}
		
		return a/b;
		
	}

}
