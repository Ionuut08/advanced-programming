import javax.swing.*;

import static java.awt.BorderLayout.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Application for Drawing");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Creating the components
        canvas = new DrawingPanel(this);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);

        // Arranging the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(canvas, CENTER);
        add(configPanel, NORTH);
        add(controlPanel, SOUTH);

        // Invoking the layout manager
        pack();
    }


}
