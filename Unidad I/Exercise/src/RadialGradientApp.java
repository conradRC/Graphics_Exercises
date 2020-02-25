import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class RadialGradientApp extends JFrame {
    
    /** Creates a new instance of RadialGradientApp */
    public RadialGradientApp() {
        super("Radial Gradient");
        
        JPanel panel = new JPanel();
        panel.add(new SphereComponent());
        add(panel);
        
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String... args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RadialGradientApp().setVisible(true);
            }
        });
    }
}

 class SphereComponent extends JComponent {
    
    /** Creates a new instance of SphereComponent */
    public SphereComponent() {
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(120, 120);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        Paint oldPaint = g2.getPaint();
        // Fills the circle with solid blue color
        g2.setColor(new Color(255,0,0));
        g2.fillOval(0, 0, getWidth() - 1, getHeight() - 1);
        
        Paint p;
        // Creates dark edges for 3D effect
        p = new RadialGradientPaint(new Point2D.Double(getWidth() / 2.0,
                getHeight() / 2.0), getWidth() / 2.0f,
                new float[] { 0.0f, 1.0f },
                new Color[] { new Color(6, 76, 160, 127),
                    new Color(0.0f, 0.0f, 0.0f, 0.8f) });
        g2.setPaint(p);
        g2.fillOval(0, 0, getWidth() - 1, getHeight() - 1);
        
        // Adds oval inner highlight at the bottom
        p = new RadialGradientPaint(new Point2D.Double(getWidth() / 2.0,
                getHeight() * 1.5), getWidth() / 2.3f,
                new Point2D.Double(getWidth() / 2.0, getHeight() * 1.75 + 6),
                new float[] { 0.0f, 0.8f },
                new Color[] { new Color(64, 142, 203, 255),
                    new Color(64, 142, 203, 0) },
                RadialGradientPaint.CycleMethod.NO_CYCLE,
                RadialGradientPaint.ColorSpaceType.SRGB,
                AffineTransform.getScaleInstance(1.0, 0.5));
        g2.setPaint(p);
        g2.fillOval(0, 0, getWidth() - 1, getHeight() - 1);
        
        // Adds oval specular highlight at the top left
        p = new RadialGradientPaint(new Point2D.Double(getWidth() / 2.0,
                getHeight() / 2.0), getWidth() / 1.4f,
                new Point2D.Double(45.0, 25.0),
                new float[] { 0.0f, 0.5f },
                new Color[] { new Color(1.0f, 1.0f, 1.0f, 0.4f),
                    new Color(1.0f, 1.0f, 1.0f, 0.0f) },
                RadialGradientPaint.CycleMethod.NO_CYCLE);
        g2.setPaint(p);
        g2.fillOval(0, 0, getWidth() - 1, getHeight() - 1);
        
        // Restores the previous state
        g2.setPaint(oldPaint);

    }
}

