/**
 * 
 */
package edu.uab.decorator;

import java.io.IOException;
import java.io.Writer;

import edu.uab.strategy.Cipher;

/**
 * @ref Cay Horstmann object oriented design
 * 
 */
public abstract class WriterDecorator extends Writer {

	protected Cipher cipher;
	
	protected void setCipher(Cipher cipher){
		this.cipher=cipher;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.Writer#write(char[], int, int)
	 */
	@Override
	abstract public void write(char[] cbuf, int off, int len)
			throws IOException;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.Writer#flush()
	 */
	@Override
	abstract public void flush() throws IOException;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.Writer#close()
	 */
	@Override
	abstract public void close() throws IOException;

}
