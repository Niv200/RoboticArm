package me.niv.robotdesktop;

import com.fazecast.jSerialComm.SerialPort;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import me.niv.robotdesktop.window.StartingWindow;

public class RobotDesktopApplication {

    private static StartingWindow startingWindow = StartingWindow.getInstance();

    public static void main(String[] args) {
        List<SerialPort> ports = Arrays.stream(SerialPort.getCommPorts()).toList();

//        System.out.println(ports.size());
//        ports.forEach(p -> System.out.println(p.getSystemPortName())); //Com 3

        System.out.println("Starting...");

        JFrame frame = new JFrame("RobotDesktop");
        frame.setContentPane(startingWindow.getMainPanel());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.pack();
    }
}
