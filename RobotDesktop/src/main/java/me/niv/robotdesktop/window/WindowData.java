package me.niv.robotdesktop.window;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class WindowData {

    private int originX = 0;
    private int originY = 0;

    private int firstX = 0;
    private int firstY = 0;

    private int secondX = 0;
    private int secondY = 0;

    private int rotation = 0;


    public WindowData (){
    }


    //TODO
    public void updateFirstAxisPanel(JPanel panel){
        Graphics2D g = (Graphics2D) panel.getGraphics();
        g.setStroke(new BasicStroke(5));
        g.setColor(Color.black);
        g.drawLine(panel.getX(), panel.getHeight()/2, 50, 50);
    }
    //TODO

    public int getOriginX() {
        return originX;
    }

    public void setOriginX(int originX) {
        this.originX = originX;
    }

    public int getOriginY() {
        return originY;
    }

    public void setOriginY(int originY) {
        this.originY = originY;
    }

    public int getFirstX() {
        return firstX;
    }

    public void setFirstX(int firstX) {
        this.firstX = firstX;
    }

    public int getFirstY() {
        return firstY;
    }

    public void setFirstY(int firstY) {
        this.firstY = firstY;
    }

    public int getSecondX() {
        return secondX;
    }

    public void setSecondX(int secondX) {
        this.secondX = secondX;
    }

    public int getSecondY() {
        return secondY;
    }

    public void setSecondY(int secondY) {
        this.secondY = secondY;
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }
}
