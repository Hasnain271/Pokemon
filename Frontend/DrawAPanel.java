import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Graphics;


public class DrawAPanel extends javax.swing.JPanel {

  private Image bg;
    
    public DrawAPanel(String file) {
      try {
        bg = ImageIO.read(new File(file));
      } catch (Exception e) {
        System.out.println(e);
      }


    }

    @Override
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
  
      // Draw the background image.
      g.drawImage(bg, 0, 0, this);
    }




}
