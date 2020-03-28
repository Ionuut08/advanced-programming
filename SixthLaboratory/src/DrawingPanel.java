import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingPanel extends JPanel {

    final MainFrame frame;
    final static int W = 800, H = 600;

    BufferedImage image;
    Graphics2D graphics;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffScreenImage();
        init();
    }

    private void init() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });
        repaint();
        paintComponent(graphics);
    }

    /*
     *   Creating a random color generator to generate light/ bright colors
     * */
    Random random = new Random();

    private void drawShape(int x, int y) {
        int radius = new Random().nextInt(50);
        int sides = (int) frame.configPanel.sidesField.getValue();

        float r = (float) (random.nextFloat() / 2f + 0.5);
        float g = (float) (random.nextFloat() / 2f + 0.5);
        float b = (float) (random.nextFloat() / 2f + 0.5);
        Color color = new Color(r, g, b);
        graphics.setColor(color);
        graphics.draw(new RegularPolygon(x, y, radius, sides));
        graphics.fill(new RegularPolygon(x, y, radius, sides));
        update(graphics);
    }

    // We will use direct drawing into an offscreen image
    public void createOffScreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }

    @Override
    public void update(Graphics g) {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 20, 30, this);
    }
}

