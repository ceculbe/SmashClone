import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

class SmashScreen extends JComponent {
  private BufferedImage offImg;

  public SmashScreen(int w, int h){
		setPreferredSize(new Dimension(w, h));
		setBackground(Color.BLACK);
  }
    
  public Graphics2D createDemoGraphics2D(Graphics g) {
    Graphics2D g2 = null;

    if (offImg == null || offImg.getWidth() != getSize().width
        || offImg.getHeight() != getSize().height) {
      offImg = (BufferedImage) createImage(getSize().width, getSize().height);
    }

    if (offImg != null) {
      g2 = offImg.createGraphics();
      g2.setBackground(getBackground());
    }
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
    g2.clearRect(0, 0, getSize().width, getSize().height);
    return g2;
  }

  public void paint(Graphics g) {
    if (getSize().width <= 0 || getSize().height <= 0)
      return;

    Graphics2D g2 = createDemoGraphics2D(g);
    g2.setColor(Color.WHITE);
    g2.drawString("TEST", 140, 190);
    g2.dispose();

    if (offImg != null && isShowing()) {
      g.drawImage(offImg, 0, 0, this);
    }
  }

}
