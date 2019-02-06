

import java.util.Scanner;
import java.util.Iterator;
import java.util.StringTokenizer;

import java.io.FileNotFoundException;
import java.io.FileReader;



/** Thrown when a user input cannot be processed. */
class InvalidCommandException extends Exception
{
  static final long serialVersionUID = -5607746478748725987L;
}

/**
 * Class implementing a text based user interface.
 */
public class TUI
{
  /** Prints all cards on the console. */
  static void print(Iterator<FlashCard> iter)
  {
    while (iter.hasNext())
    {
      System.out.println( iter.next().toString() );
    }
  }

  /** Prints an error message. */
  static void error(String msg)
  {
    System.out.println("Err: " + msg);
  }

  /** UI for studying with the Leitner method. */
  static void study(Leitner leitner)
  {
    Scanner inp = new Scanner(System.in);

    for (;;)
    {
      String  answer;
      boolean flip = false;

      leitner.pickCard();

      do
      {
        System.out.println(" ?" + (flip ? leitner.getAnswer() : leitner.getQuestion()) );

        System.out.print(" >");
        answer = inp.nextLine();
        flip = !flip;
      } while ("%".equals(answer));

      if ("!exit".equals(answer)) break;

      boolean validResponse = leitner.checkAnswer(answer);

      if (!validResponse) System.out.println(":(" + leitner.getAnswer() + '\n');
    }
  }

  /** imports cards from a given file. */
  static int importCards(FlashCardApp app, String filename) throws FileNotFoundException
  {
    int        cnt = 0;
    FileReader freader = null;

    try
    {
      freader = new FileReader(filename);

      Scanner inp = new Scanner(freader);

      while (inp.hasNextLine())
      {
        String challenge = inp.nextLine();

        if (!inp.hasNextLine()) break;
        String response  = inp.nextLine();

        app.create(challenge, response);
        ++cnt;

        // skip empty line (except for end of file)
        if (inp.hasNextLine()) inp.nextLine();
      }
    }
    finally
    {
      try { freader.close(); } catch (Exception ex) { ex.printStackTrace(); }
    }

    return cnt;
  }

  /** tokenizes user command. */
  static String nextToken(StringTokenizer tok) throws InvalidCommandException
  {
    if (!tok.hasMoreTokens()) throw new InvalidCommandException();

    return tok.nextToken();
  }

  /** checks that there remains no user input unhandled. */
  static void endOfCommand(StringTokenizer tok) throws InvalidCommandException
  {
    if (tok.hasMoreTokens()) throw new InvalidCommandException();
  }

  /** handles user input and calls functions as needed. */
  static void handleCommand(FlashCardApp app, String s) throws InvalidCommandException
  {
    StringTokenizer tok = new StringTokenizer(s, " ", false);
    String cmd = nextToken(tok);

    if (cmd.equals("import"))
    {
      String filename = nextToken(tok);

      endOfCommand(tok);

      try
      {
        int cnt = importCards(app, filename);

        System.out.println(cnt + " cards imported.");
      }
      catch (FileNotFoundException ex)
      {
        error("File " + filename + "not found");
      }
    }
    else if (cmd.equals("study"))
    {
      endOfCommand(tok);
      study(app.leitner());
    }
    else if (cmd.equals("listAll"))
    {
      endOfCommand(tok);
      print(app.listAll());
    }
    else if (cmd.equals("list"))
    {
      String what = nextToken(tok);

      endOfCommand(tok);

      int    boxnum = 0;

      try
      {
        Integer num = new Integer(what);

        if (num.toString().equals(what)) boxnum = num;
      }
      catch (NumberFormatException ex)
      {}

      if (boxnum != 0) print(app.list(boxnum));
      else print(app.list(what));
    }
    else if (cmd.equals("!exit"))
    {
      endOfCommand(tok);
      System.exit(0);
    }
    else
    {
      throw new InvalidCommandException();
    }
  }

  /** Main function and main user input loop. */
  public static void main(String[] args)
  {
    FlashCardApp app = new FlashCardApp();
    Scanner      inp = new Scanner(System.in);

    System.out.print(":");
    while (inp.hasNextLine())
    {
      try
      {
        handleCommand(app, inp.nextLine());
      }
      catch (InvalidCommandException e)
      {
        error("invalid command");
      }

      System.out.print(":");
    }
  }
}
