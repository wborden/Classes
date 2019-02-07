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
public abstract class ReaderDecorator extends Reader {

	protected void setCipher(Cipher cipher) {
	
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.Reader#read(char[], int, int)
	 */
	@Override
	abstract public int read(char[] cbuf, int off, int len) throws IOException;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.Reader#close()
	 */
	@Override
	abstract public void close() throws IOException;

}
