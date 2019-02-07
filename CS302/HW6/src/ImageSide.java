

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageSide implements Side {
    
    
    
    /**
     * Tests whether a given string represents an image file name.
     * @param str
     * @return
     */
    public static boolean imgTest(String str) {
	      
	      if(str.contains(".jpg") || str.contains(".png")
		      || str.contains(".jpeg") || str.contains(".bmp") || str.contains(".gif")) {
		  
		  return true;
		  
	      }   else return false;
	      
	 
	  }
	  
	  public Image readImage(String src) {
	      
	      
	      File imgFile = new File(src);
	       Image img = null;
	       
	       try {
		   
		    img = ImageIO.read(imgFile);
		   
	       } catch (IOException imgError) {
		   
		   imgError.printStackTrace();	   
	       }
	       
	       return img;
	       
	  }
    
	/**
	 * Constructs a new ImageSide Object
	 * @param str
	 */
    public ImageSide(String str) {
	  
	  this.str = str;
	  
	  imgIcon = new ImageIcon(readImage(str));
	  
	  container = new JLabel(imgIcon);
	  
    }


  public JLabel getSideLabel() {
	
	return container;
	
  }

//This will return the string of a given side 
 
  public String getSideText() {

	return this.str;
	
  }

  //Returns the icon image of a given side.
  public ImageIcon getIcon() {
	
	return imgIcon;
  }
  
  private JLabel container;
  private String str;
  private ImageIcon imgIcon;
  
  
    
}
