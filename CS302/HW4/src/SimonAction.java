import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;


/**
 * 
 * @author wborden
 *
 */

public class SimonAction implements ActionListener {
    
    
    
    //actionFrame for the purpose of repainting
    private JFrame actionFrame;
    
    //activeColor variable in order to reset only this variable with ".brighter()"
    private Color activeColor;
    
    
    
    /**
     * 
     * @param a
     * @param b
     */
    public SimonAction(JFrame a, Color b) {

	this.actionFrame = a;
	this.activeColor = b;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

	((Timer) e.getSource()).stop();

	activeColor = activeColor.darker();

	    actionFrame.repaint();

	}

}
