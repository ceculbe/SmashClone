package Main;
import javax.swing.JFrame;

public class Frame {

  public static void main(String[] args) {
    JFrame f = new JFrame("Frame Title Goes Here"); 
    Panel p = new Panel();
    //f.setContentPane(p);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.add(p);
    f.pack();
    f.setVisible(true);
    p.setFocusable(true); //Called in panel class
    f.setResizable(false);
    p.requestFocusInWindow(); //Called in panel class
    p.run();
    f.dispose();
  }
}