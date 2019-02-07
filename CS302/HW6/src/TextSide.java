

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TextSide implements Side{     
    
    
    	/**
	 * Constructs a new TextSide Object
	 * @param str
	 */
    public TextSide(String sideText) {
	  
	  this.str = sideText;
	  
	  this.container = new JLabel(str);
    }
    
    
  //This will return the label used to store 
    //the text or image of a given side.
    public JLabel getSideLabel() {
	
	return this.container;
	
  }

  //This will return the string of a given side 
   
  public String getSideText() {
	
	return str;
  }

  //Returns the icon image of a given side.
  //Not applicable for a TextSide.
  public ImageIcon getIcon() {
	
	return null;
  }
  
  
  private String str;
  private JLabel container;
    
}
