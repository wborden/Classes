package calc;

/**
  enum TokenKind
  {
    invalid, plus, minus, mul, div, open, close, floatval
  }

  public class CalcTokenizer
  {
  /// Constructs a new tokenizer with the input that needs to be processed
  CalcTokenizer(String s)

  /// reads the next token from the input and matches
  /// the kind of tokens.
  public void nextTokenKind()

  ///
  ///
  public TokenKind currentTokenKind()

  /// Returns the Float representation of the token
  public Float getValue()
}
*/

/**
 * Calculator
 *
 * Floating point calculator. The calculator is invoked through { @link #compute }.
 * Note in order to make the calculator easily extensible towards other types,
 * we use Float objects instead of float values for the computation. Likewise,
 * operations on these objects are encapsulated by a class FloatOperations.
 */
public class Calculator<N extends Number>
{
 
  
  public Calculator(String expr, Operation<N> operation) {
      
      op = operation;
      
      tokenizer = new CalcTokenizer(expr);
      
      
  }
  

  // calculation

  /**
   * Handles optional parenthesis, otherwise parses the next number
   *
   * @return the next floating point value
   */
  private N parens()
  {
    N res = null;
    TokenKind kind = tokenizer.currentTokenKind();

    if (kind == TokenKind.open)
    {
      tokenizer.nextTokenKind();
      res = plusminus();

      TokenKind closeparen = tokenizer.currentTokenKind();
      assert closeparen == TokenKind.close;
      tokenizer.nextTokenKind();
    }
    else
    {
      assert kind == TokenKind.val;

       res = op.getValue(tokenizer.theToken());
      
      tokenizer.nextTokenKind();
    }

    assert res != null;
    return res;
  }

  /**
   * Tests whether a token is either plus or minus
   *
   * @param k a token
   */
  static boolean isPlusMinusKind(TokenKind k) { return  k == TokenKind.plus || k == TokenKind.minus; }

  /**
   * Tests whether a token is either mul or div
   *
   * @param k a token
   */
  static boolean isMulDivKind   (TokenKind k) { return  k == TokenKind.mul  || k == TokenKind.div;   }

  /**
   * Handles multiplication/division, otherwise returns next number
   *
   * @return computed value
   */
  private N muldiv()
  {
    N lhs = parens();

    while (isMulDivKind(tokenizer.currentTokenKind()))
    {
      TokenKind kind = tokenizer.currentTokenKind();

      tokenizer.nextTokenKind();
      N rhs = parens();

      if (kind == TokenKind.mul)
      {
        lhs = op.mul(lhs, rhs);
      }
      else
      {
        assert kind == TokenKind.div;
        lhs = op.div(lhs, rhs);
      }
    }

    assert lhs != null;
    return lhs;
  }


  /**
   * Handles addition/subtraction, otherwise returns next number
   *
   * @return computed value
   */
  private N plusminus()
  {
    N lhs = muldiv();

    while (isPlusMinusKind(tokenizer.currentTokenKind()))
    {
      TokenKind kind = tokenizer.currentTokenKind();

      tokenizer.nextTokenKind();
      N rhs = muldiv();

      if (kind == TokenKind.plus)
      {
       lhs = op.plus(lhs, rhs);
      }
      else
      {
        assert kind == TokenKind.minus;
        lhs = op.minus(lhs, rhs);
      }
    }

    assert lhs != null;
    return lhs;
  }

  /**
   * Invokes start production
   *
   * @return computed value
   */
  private N calc()
  {
    tokenizer.nextTokenKind();
    return plusminus();
  }
  
  /**
   * Computes the value for a given expression
   *
   * @param expr input expression
   * @return computed value
   * @throws RuntimeException if the input is not valid
   */
  
  public N compute()
  {
    assert tokenizer != null;
    return calc();
  }
  
  /** We use a simple tokenizer to chop up the input stream. */
  private CalcTokenizer tokenizer;
  private Operation<N> op;
  
  
}
