/**
 * 
 */
package edu.uab.strategy;

/**
 * 
 * @ref Cay Horstmann object oriented design 
 * 
 */
public class CeasarCipher implements Cipher {

	static final int CAESAR_OFFSET = 3;
	static final int ALPHABET_SIZE = 26;

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uab.strategy.Cipher#encrypt(char[], int, int)
	 */
	public void encrypt(char[] cbuf, int off, int len) {
		for (int i = off; i < off + len; i++) {
			char c = cbuf[i];
			if (Character.isLetter(c)) {
				c = (char) ((int) c + CAESAR_OFFSET);
				if (!Character.isLetter(c))
					c = (char) ((int) c - ALPHABET_SIZE);
				// C s no longer in alphabet. Move it back in.
				cbuf[i] = c;
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uab.strategy.Cipher#decrypt(char[], int, int)
	 */
	public void decrypt(char[] cbuf, int off, int len) {
		for (int i = off; i < off + len; i++) {
			char c = cbuf[i];
			if (Character.isLetter(c)) {
				c = (char) ((int) c - CAESAR_OFFSET);
				if (!Character.isLetter(c))
					c = (char) ((int) c + ALPHABET_SIZE);
				// C is no longer in the alphabet. Move it back in.

				cbuf[i] = c;
			}
		}

	}

}
