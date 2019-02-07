/**
 * 
 */
package edu.uab.client;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import edu.uab.decorator.DecryptingReader;
import edu.uab.decorator.EncryptingWriter;
import edu.uab.strategy.CeasarCipher;
import edu.uab.strategy.Cipher;

/**
 * 
 * @ref Cay Horstmann object oriented design
 */
public class AppMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		
		 String file = "encrypt these letters";
		 char[] charArr = file.toCharArray();
		 
		  FileWriter writer = new FileWriter("test.out");
		
		//which cipher to use 
		  Cipher cipher = new CeasarCipher();
		//decorating FileWriter with EncryptingWriter // write encrypted word to test.out file
		
		  EncryptingWriter enWriter = new EncryptingWriter(writer, cipher);		
		  enWriter.write(charArr, 0, file.length());
		  enWriter.flush();
		  enWriter.close();
		//decorating EncryptingWriter and FileWriter with PrintWriter
		//Use PrintWriter to read from test.out file
		  
		 
		  
		  FileReader reader = new FileReader("test.out");
		// use DecryptingReader to read from the file (test.out)
		  DecryptingReader deRead = new DecryptingReader(reader, cipher);
		  deRead.read(charArr, 0, file.length());
		  deRead.close();
		  
		  // use BufferedReader  reader to read from test.out file  // and display it in console
		
		  for(int i = 0; i < file.length(); i++) {
			  
			  System.out.print(charArr[i]);
			  
			  
		  }

	}

}
