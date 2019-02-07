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
public class EncryptingWriter extends WriterDecorator {


	private Writer writer;

	/**
	 * Construct an encrypting writer that decorates a given writer
	 * 
	 * @param writer
	 *            the writer to decorate
	 */
	public EncryptingWriter(Writer writer, Cipher cipher) {
		
		this.cipher = cipher;
		this.writer = writer;
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uab.decorator.WriterDecorator#write(char[], int, int)
	 */
	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		
	cipher.encrypt(cbuf, off, len);
	writer.write(cbuf, off, len);
	
	

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uab.decorator.WriterDecorator#flush()
	 */
	@Override
	public void flush() throws IOException {

		writer.flush();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uab.decorator.WriterDecorator#close()
	 */
	@Override
	public void close() throws IOException {
	
		writer.close();
	}

}
