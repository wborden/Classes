

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public interface Side {
    
    
    //This will return the label used to store 
    //the text or image of a given side.
    public JLabel getSideLabel();
    
    
    
    //Returns the text of a given side.
    public String getSideText();
    
    //returns the ImageIcon used to store the 
    //string or image of a given side.
    public ImageIcon getIcon();
    
    
    
    
    

}
