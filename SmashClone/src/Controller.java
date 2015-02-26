import javax.swing.JFrame;

public class Controller {
  public static void main(String[] a) {
    JFrame window = new JFrame("Smash Clone");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.getContentPane().add(new SmashScreen(640,480));
    window.pack();
    window.setResizable(false);
    window.setVisible(true);     
  }
}