package project2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ReboundPanel extends JPanel {
	   private int height;
	   private int width;
	   private ImageIcon image;
	   private int x, y;
	  
	   //Sets up rebound panel
	   public ReboundPanel(int w, int h)
	   {	
		  width = w;
		  height = h;

	      image = new ImageIcon (this.getClass().getResource("/project2/doctor.gif"));
	      x = 0;
	      y = 40;
      
	      setPreferredSize (new Dimension(w, h));
	      setBackground (new Color(232, 194, 145));
	   }
	  
	   //  Draws the image in the current location.
	   public void paintComponent (Graphics page)
	   {
	      super.paintComponent (page);
	      image.paintIcon (this, page, x, y);
	   }

}
