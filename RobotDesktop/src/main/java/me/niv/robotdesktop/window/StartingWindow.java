package me.niv.robotdesktop.window;

import static java.util.Objects.isNull;

import com.fazecast.jSerialComm.SerialPort;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import me.niv.robotdesktop.data.GCodeCharacter;
import me.niv.robotdesktop.data.GCodeCommand;
import me.niv.robotdesktop.data.SerialCommand;
import me.niv.robotdesktop.serial.SerialHandler;
import me.niv.robotdesktop.service.ActionService;

public class StartingWindow {

    private SerialHandler serialHandler = new SerialHandler();
    private ActionService actionService = new ActionService();

    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JTextField textField3;
    private JButton executeButton;
    private JButton xMinusTenButton;
    private JButton xPlusTenButton;
    private JButton xPlusFiveButton;
    private JButton xMinusFiveButton;
    private JButton xMinusOneButton;
    private JButton xPlusOneButton;
    private JButton homingExecuteButton;
    private JTextField dwellSecondsInput;
    private JButton executeButton1;
    private JPanel axisCombinedPanel;
    private JPanel axisTwoPanel;
    private JPanel axisOnePanel;
    private JPanel axisPanel;
    private JButton dwellExecuteButton;
    private JLabel zPositionField;
    private JLabel yPositionField;
    private JLabel xPositionField;
    private JPanel innerPositionPanel;
    private JButton zPlusOneButton;
    private JButton zMinusOneButton;
    private JButton zMinusFiveButton;
    private JButton zPlusFiveButton;
    private JButton zPlusTenButton;
    private JButton zMinusTenButton;
    private JPanel innerPanelRelativeZ;
    private JButton yPlusOneButton;
    private JButton yMinusOneButton;
    private JButton yMinusFiveButton;
    private JButton yPlusFiveButton;
    private JButton yPlusTenButton;
    private JButton yMinusTenButton;
    private JPanel innerPanelRelativeY;
    private JPanel innerPanelRelativeX;
    private JPanel calibrationInnerPanel;
    private JPanel dwellPanel;
    private JComboBox comPortsComboBox;
    private JButton connectPortButton;
    private JLabel comStatusText;

    private WindowData data = new WindowData();

    public StartingWindow() {
        List<String> serialPorts = serialHandler.getPortsNames();

        serialPorts.forEach(portName -> comPortsComboBox.addItem(portName));

        homingExecuteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO Home serial output
                String command = new SerialCommand().gCode(GCodeCommand.HOME).build();
                SerialPort port = serialHandler.getConnectedPort();
                if(!isNull(port)){
                    port.setComPortParameters(115200, 8, 1, 0); // default connection settings for Arduino
                    port.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);

                    PrintWriter out = new PrintWriter(port.getOutputStream(),true);
                    out.println(command);
                    out.flush();

                }

                //TODO DRAWING PANEL TESTING
                data.updateFirstAxisPanel(axisOnePanel);
            }
        });

        dwellExecuteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO Dwell Serial Output;
                try {
                    Integer seconds = Integer.parseInt(dwellSecondsInput.getText());
                    if(seconds == null || seconds <= 0){
                        System.out.println("Dwell seconds must be defined.");
                    }
                    String command = new SerialCommand().gCode(GCodeCommand.DWELL).value(GCodeCharacter.SECONDS, seconds.doubleValue()).build();
                    System.out.println(command);
                } catch (NumberFormatException ex) {
                    System.out.println("Dwell must be defined as complete seconds. (integer)");
                    dwellSecondsInput.setText("");
                }
            }
        });

        //Serial
        connectPortButton.addActionListener(actionService.serialConnectActionListener(serialHandler, comPortsComboBox, comStatusText));
    }

    public static StartingWindow getStartingWindow(){
        return new StartingWindow();
    }

    public JPanel getMainPanel(){
        return mainPanel;
    }

    public JPanel getAxisOnePanel(){
        return this.axisOnePanel;
    }
}
