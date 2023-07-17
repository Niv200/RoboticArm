package me.niv.robotdesktop;

import static me.niv.robotdesktop.data.GCodeCharacter.*;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import me.niv.robotdesktop.data.GCodeCommand;
import me.niv.robotdesktop.data.SerialCommand;
import me.niv.robotdesktop.window.StartingWindow;

public class RobotDesktopApplication {

    private static StartingWindow startingWindow = StartingWindow.getStartingWindow();

    public static void main(String[] args) {
        System.out.println("Starting...");

        JFrame frame = new JFrame("RobotDesktop");
        frame.setContentPane(startingWindow.getMainPanel());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.pack();
    }
}
