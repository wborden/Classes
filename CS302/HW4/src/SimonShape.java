
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Arc2D;
import javax.swing.Timer;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.util.Random;

 /**
  * 
  */


//No idea why I had to do this.
@SuppressWarnings("serial")

         /**
	 * 
	 * * 
	 * @author wborden
	 *
	 */
public class SimonShape extends JFrame  implements KeyListener {

    
    // Creates instance of JFrame
    private JFrame frame = new JFrame();    
    
    private Timer timer;    //Declare Timer
    
    private KeyListener listener;  //Declare classes KeyListener 
    
    private SimonAction aListener; //Declare classes SimonAction
    
    private Color activeColor;  //Color variable to store "activeColor"
    
    // Create all needed colors, and set them to darker.
    private Color blue = Color.blue.darker();
    private Color green = Color.green.darker();
    private Color red = Color.red.darker();
    private Color yellow = Color.yellow.darker();

    //Classes x/y and height/width variables. For use in the paint method
    private int x; private int y;
    private int w; private int h;

    /**
     * 
     * @param shapeW
     * @param shapeH
     * @param x
     * @param y
     */
    public SimonShape(int shapeW, int shapeH, int x, int y) {

	this.w = shapeW; this.h = shapeH;
	this.x = x; this.y = y;

	frame.setSize(800, 800);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);
	frame.setLayout(new BorderLayout());

	DrawShape shape = new DrawShape();

	frame.add(shape, BorderLayout.CENTER);
	frame.addKeyListener(listener);

	frame.setFocusable(true);
	frame.setVisible(true);

	frame.requestFocus();
	
	
	//Used to call random color method.
	//Left in only to show how it was used.
	
	//randomChange(2);
    }

    
    public class DrawShape extends JComponent {    //Class implemented to draw the shape.


	//Paint method, handles all drawing and graphics.
    public void paint(Graphics g) {
	super.paint(g);
	Graphics2D g2D = (Graphics2D) g;
	g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	int angDeg = 90;
	int deg = 45;


	g2D.setStroke(new BasicStroke(2.0f));
	g2D.setPaint(blue);

	g2D.fill(new Arc2D.Double(x, y, w, h, deg - 180 , angDeg, Arc2D.PIE));

	g2D.setStroke(new BasicStroke(2.0f));
	g2D.setPaint(green);
	g2D.fill(new Arc2D.Double(x, y, w, h, deg + 90, angDeg, Arc2D.PIE));
	
	g2D.setStroke(new BasicStroke(2.0f));
	g2D.setPaint(yellow);
	g2D.fill(new Arc2D.Double(x, y, w, h, deg, angDeg, Arc2D.PIE));
	
	g2D.setStroke(new BasicStroke(2.0f));
	g2D.setPaint(red);
	g2D.fill(new Arc2D.Double(x, y, w, h, deg - 90, angDeg, Arc2D.PIE));
	
	g2D.setColor(Color.BLACK);
	g2D.drawArc(x, y, w, h, deg - 180 , angDeg);
	g2D.drawArc(x, y, w, h,  deg, angDeg);
	g2D.drawArc(x, y, w, h, deg + 90, angDeg);
	g2D.drawArc(x, y, w, h, deg - 90, angDeg);
	g2D.drawLine(x + 74, y + 74, w + 66, h + 66);
	g2D.drawLine(x + 74, y + 427, w + 66, h - 287);
    	}
    }
    
    /**
     * 
     * @param num
     */
  //Method intended to change colors randomly, at a number of times equal to num.
    public void randomChange(int num) {   

	int random = (new Random()).nextInt(4);

	for (int i = 0; i <= num; i++) {

	    if (random == 0) {
		yellow = yellow.brighter(); repaint();
		setActiveColor(yellow);
		aListener = new SimonAction(this.frame, yellow); //create new SimonAction
		    timer = new Timer(500, aListener);  //Create new timer

		    timer.start();
		}

	    else if (random == 1) {
		red = red.brighter();
		repaint();
		setActiveColor(red);
		aListener = new SimonAction(this.frame, red); //create new SimonAction
		    timer = new Timer(500, aListener);   //Create new timer

		    timer.start();
		}

	    else if (random == 2) {
		blue = blue.brighter();
		repaint();
		setActiveColor(blue);
		aListener = new SimonAction(this.frame, blue); //create new SimonAction
		    timer = new Timer(500, aListener);  //Create new timer

		    timer.start();
	    }
	    else if (random == 3) {

		green = green.brighter();
		setActiveColor(green);
		aListener = new SimonAction(this.frame, green); //create new SimonAction
		    timer = new Timer(500, aListener); //Create new timer

		    timer.start();

		}
	     random = (new Random()).nextInt(4);

	    }
	}

    /**
     * 
     * @param a
     */
    public void setActiveColor(Color a) {   //setter for active Color
	this.activeColor = a;
    }

    /**
     * 
     * @return
     */
    public Color getActiveColor() {   //getter for active color

	return activeColor;
    }

    @Override
    public void keyPressed(KeyEvent e) {
	
	if(e.getKeyCode() == KeyEvent.VK_UP) {
	    yellow = yellow.brighter();
	    repaint();
	    
	    
	}
	else if (e.getKeyCode() == KeyEvent.VK_DOWN){
	    blue = blue.brighter();
	    repaint();
	    }
	else if (e.getKeyCode() == KeyEvent.VK_LEFT){
	    green = green.brighter();
	    repaint();	    

	    }

	else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
	    red = red.brighter();
	    repaint();	    
	    }
	}




    @Override
    public void keyReleased(KeyEvent e) {

	if (e.getKeyCode() == KeyEvent.VK_UP) {
	    yellow = yellow.darker();
	    repaint();
	}

	else if (e.getKeyCode() == KeyEvent.VK_DOWN){
	    blue = blue.darker();
	    repaint();	    
	    
	    }
	
	else if (e.getKeyCode() == KeyEvent.VK_LEFT){
	    green = green.darker();
	    repaint();	    
	    
	    }
	
	else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
	    red = red.darker();
	    repaint();	    
	    
	    }
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }
    
    
    

   




}
