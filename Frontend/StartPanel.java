import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;


public class StartPanel {
    DrawAPanel startPanel;
    FlowLayout fl = new FlowLayout();
    JButton play; 

    public StartPanel() {
        startPanel = new DrawAPanel("assets/StartscreenBG.jpeg");
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
