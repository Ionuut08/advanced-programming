import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ControlPanel controlPanel;
    DesignPanel designPanel;
    public MainFrame() {
        super("Swing Designer");
        this.setLayout(new BorderLayout());
        rootPane.setPreferredSize(new Dimension(1000, 800));
        init();
        addComponents();
        this.setVisible(true);
    }
    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.controlPanel = new ControlPanel(this);
        this.designPanel = new DesignPanel(this);

        pack();
    }

    private void addComponents(){
        this.add(controlPanel, BorderLayout.NORTH);
        this.add(designPanel, BorderLayout.CENTER);
    }

}
