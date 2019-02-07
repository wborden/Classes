

import java.util.Scanner;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
  /**
   * Prints all cards on the console. 
   * @param iter
   */
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

      boolean validResponse = leitner.checkAnswer(leitner.getCurrBack().getSideText());

      if (!validResponse) System.out.println(":(" + leitner.getAnswer() + '\n');
    }
  }

  /**
   * imports cards from a given file. 
   * @param app
   * @param filename
   * @return
   * @throws FileNotFoundException
   */
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

  /**
   * tokenizes user command. 
   * @param tok
   * @return
   * @throws InvalidCommandException
   */
  static String nextToken(StringTokenizer tok) throws InvalidCommandException
  {
    if (!tok.hasMoreTokens()) throw new InvalidCommandException();

    return tok.nextToken();
  }

  /**
   * @throws InvalidCommandException
   * @param tok
   * @throws InvalidCommandException
   */
 
  static void endOfCommand(StringTokenizer tok) throws InvalidCommandException
  {
    if (tok.hasMoreTokens()) throw new InvalidCommandException();
  }

  /**
   * handles user input and calls functions as needed.
   * @param app
   * @param s
   * @throws InvalidCommandException
   */
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
    
    else if (cmd.equals("leitner-gui"))
    {
      endOfCommand(tok);
      studyWindow(app.leitner());
    }
    else if (cmd.equals("drill-gui"))
    {
      endOfCommand(tok);
      studyWindow(app.drill());
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
  
  /**
   * 
   * @param type
   * 
   * Method responsible for creating the GUI window.
   */
  
  static void studyWindow(StudyMethod type) {
      
      final StudyMethod method = type;  //StudyMethod type chosen by user.
      
      
      //JLabel question = new JLabel();
      
      final JPanel display = new JPanel();  //
      
      display.setLayout(new FlowLayout());
     
      final JTextArea inputArea = new JTextArea(5, 10);  //Sets the area where users input answers.
      
      JPanel buttonPanel = new JPanel();  //Button container
      buttonPanel.setLayout(new FlowLayout());
      
      //Sets up all the buttons
      JButton doNotKnow = new JButton("Do Not Know");
      JButton flipCard = new JButton("Flip Card");
      JButton iKnow = new JButton("I Know");
      JButton exit = new JButton("Exit");
      
      //adds all the new buttons to the button panel
      buttonPanel.add(doNotKnow);
      buttonPanel.add(flipCard);
      buttonPanel.add(iKnow);
      buttonPanel.add(exit);
      
      //initializes last panel
      final JPanel window = new JPanel();
      window.setLayout(new BorderLayout());
      
      //adds all the components to the last panel
      window.add(buttonPanel, BorderLayout.SOUTH);
      window.add(display, BorderLayout.NORTH);
      window.add(inputArea, BorderLayout.CENTER);
      
      final JFrame frame = new JFrame();      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //not sure why but this seemed to help
      frame.pack();
      
      frame.add(window);
      frame.setVisible(true);
      
      method.pickCard();
      
      JLabel question = method.getQuestion();
      
      display.add(question);
      display.repaint();
      frame.pack();
      
      
      
      
      iKnow.addActionListener(new ActionListener()
	      {

		
		public void actionPerformed(ActionEvent e) {
		    
		    boolean correct = method.checkAnswer(inputArea.getText());
		    
		    
                    if (!correct) {JOptionPane.showMessageDialog( //Displays correct answer
                            null,
                            "correct answer: " + method.getAnswer(),
                            "Sorry, incorrect",
                            JOptionPane.ERROR_MESSAGE);}
                    
                    if(!method.hasMoreCards()) {  //Makes sure there are still cards left, exiting if not.
                	
                	JOptionPane.showMessageDialog(null,
                		
                		"The box for your current session is empty!",
                		"The session will end now.",
                		JOptionPane.ERROR_MESSAGE);
                		System.exit(0); }                 
                    
                    
                    inputArea.setText("");
                                	
                    method.pickCard();
                    display.removeAll();
                    display.add(method.getQuestion());
                    
                    display.repaint();
                    frame.pack();
                    
                 
            }
    });
      
      doNotKnow.addActionListener(new ActionListener() {

	
	public void actionPerformed(ActionEvent e) {
	   
	    
	    JOptionPane.showMessageDialog(    //Displays correct answer 
                    null,
                    "correct answer: " + method.getCurrBack().getSideText(),
                    "Better luck next time",
                    JOptionPane.ERROR_MESSAGE);
	    
	    
	    if(!method.hasMoreCards()) {  //Makes sure there are still cards left, exiting if not.
        	
        	JOptionPane.showMessageDialog(null,
        		
        		"The box for your current session is empty!",
        		"The session will end now.",
        		JOptionPane.ERROR_MESSAGE);
        		System.exit(0); }
	    
	    inputArea.setText("");
    	
            method.pickCard(); //pick new card
            display.removeAll();
            display.add(method.getQuestion());
            
            display.repaint();
            frame.pack();
	}
	
	
	
	  
      });
      
      
      flipCard.addActionListener(new ActionListener()
      {

	
	public void actionPerformed(ActionEvent e) {
	    
	    JLabel currBack = null;
	    
	    if(method.getCurrBack() instanceof ImageSide) {
		  
		currBack.setText("");  
		currBack.setIcon(method.getCurrBack().getIcon());		  
		  display.removeAll();
		  display.add(currBack);
		  frame.pack();
		  
		  
		  JOptionPane.showMessageDialog( 
	                    null,
	                    currBack,
	                    "Flipped",
	                    JOptionPane.ERROR_MESSAGE);	  
		  
	      }
	    
	    else {
		
		
		
		JOptionPane.showMessageDialog( 
	                    null,
	                    "The other side of the card was: " + method.getCurrBack().getSideText(),
	                    "Flipped",
	                    JOptionPane.ERROR_MESSAGE);
	            
	            if(!method.hasMoreCards()) {  //Makes sure there are still cards left, exiting if not.
	        	
	        	JOptionPane.showMessageDialog(null,
	        		
	        		"The box for your current session is empty!",
	        		"The session will end now.",
	        		JOptionPane.ERROR_MESSAGE);
	        		System.exit(0); }                 
	            
	            
	            inputArea.setText("");
	                        	
	            method.pickCard();   //pick new card
	            display.removeAll();
	            display.add(method.getQuestion());
	            
	            display.repaint();
	            frame.pack();
	            
		
	    }
	    
	    
	    if(!method.hasMoreCards()) {  //Makes sure there are still cards left, exiting if not.
        	
        	JOptionPane.showMessageDialog(null,
        		
        		"The box for your current session is empty!",
        		"The session will end now.",
        		JOptionPane.ERROR_MESSAGE);
        		System.exit(0); }
	    
	    
	}
         
    });
      
      
      exit.addActionListener(new ActionListener()
      {

	
	public void actionPerformed(ActionEvent e) {
	    
	    JOptionPane.showMessageDialog( 
                    null,
                    "Goodbye!",
                    "Exiting",
                    JOptionPane.ERROR_MESSAGE);
            
            System.exit(0);
            
	}
         
    });
		
	  
      
  }
  
  
  
  
  
  
  

  /**
   * Main function and main user input loop. 
   * @param args
   */
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
