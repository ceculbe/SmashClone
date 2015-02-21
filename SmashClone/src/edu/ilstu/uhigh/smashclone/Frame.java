package edu.ilstu.uhigh.smashclone;
import javax.swing.JFrame;

public class Frame {

  public static void main(String[] args) {
	//System.out.println("Working Dir:"+System.getProperty("user.dir"));
	JFrame f = new JFrame("Frame Title Goes Here"); 
    Panel p = new Panel();
    //f.setContentPane(p);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.add(p);
    f.pack();
    f.setVisible(true);
    p.setFocusable(true);
    f.setResizable(false);
    p.requestFocusInWindow(); 
    p.run();
    f.dispose();
  }
}