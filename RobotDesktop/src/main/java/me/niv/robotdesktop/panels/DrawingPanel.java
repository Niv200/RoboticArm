package me.niv.robotdesktop.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel {

    public DrawingPanel(){
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(this.getWidth(), this.getHeight());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);

        int width = getWidth();
        int height = getHeight();
        g.drawLine(width / 2, height / 2, width, height/ 2);
    }
}