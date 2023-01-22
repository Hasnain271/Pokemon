import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class StartPanel {
    DrawAPanel startPanel;
    JButton play; 

    public StartPanel() {
        startPanel = new DrawAPanel("/Users/hasnain/Desktop/Pokemon/assets/StartscreenBG.jpeg");
        play = new JButton("Play!");
        playButton();
        startPanel.setVisible(true);
        

    }

    public DrawAPanel getStartPanel() {
        return startPanel;
    }


    public void playButton() {

        startPanel.add(play);

        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI.cl.show(GUI.panels.getContentPane(), "Battle Panel");;
            }
        });
    }

}
