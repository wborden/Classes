/**
 * 
 */
package edu.uab.decorator;

import java.io.IOException;
import java.io.Reader;

import edu.uab.strategy.Cipher;

/**
 * @ref Cay Horstmann object oriented design
 * 
 */
public class DecryptingReader extends ReaderDecorator {

	

	private Reader reader;
	private Cipher cipher;
	/**
	 * Construct an decrypting reader that decorates a given reader
	 * 
	 * @param reader
	 *            the reader to decorate
	 */
	public DecryptingReader(Reader reader, Cipher cipher) {
		
		this.cipher = cipher;
		this.reader = reader;
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uab.decorator.ReaderDecorator#read(char[], int, int)
	 */
	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		
		int result = reader.read(cbuf, off, len);
		
		cipher.decrypt(cbuf, off, len);
		
		

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uab.decorator.ReaderDecorator#close()
	 */
	@Override
	public void close() throws IOException {
		
		reader.close();
	}

}
