import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {

    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    private JTextField filename = new JTextField(), dir = new JTextField();

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 4));

        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);

        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
    }

    private void save(ActionEvent saving) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("../images/saved_image.png"));
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    // Push the load button, then click on the canvas
    private void load(ActionEvent loading) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                BufferedImage image = ImageIO.read(new File(selectedFile.getAbsolutePath()));
                frame.canvas.graphics.drawImage(image, 1, 0, null);
            }
        } catch (Exception e) {
            System.err.printf("The file did not load");
        }
    }

    // Push the reset button then click on the canvas
    private void reset(ActionEvent e) {
        this.frame.canvas.createOffScreenImage();
    }

    private void exit(ActionEvent exiting) {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}
