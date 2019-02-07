package main;

import java.util.Scanner;

import calc.*;


public class Calc<N extends Number>
{
  /**
   * Generates a new calculator object (factory function)
   */
  
    
   

  /**
   * main - test driver
   *
   * Reads an expression from the standard input stream
   * and prints the output to the console
   *
   * @param args unused
   */
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    
    Operation<Float> op = new FloatOperation();
    
    while (sc.hasNextLine())
    {
	
	
      Calculator<Float> testCalc = new Calculator<Float>(sc.nextLine(), op);
      Float res = testCalc.compute();

      System.out.println(res);
    }
  }
}
