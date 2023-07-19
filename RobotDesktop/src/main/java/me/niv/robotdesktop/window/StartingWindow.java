package me.niv.robotdesktop.window;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import me.niv.robotdesktop.data.GCodeCharacter;
import me.niv.robotdesktop.serial.SerialHandler;
import me.niv.robotdesktop.service.ActionService;

public class StartingWindow {

    private static StartingWindow INSTANCE;

    private SerialHandler serialHandler = SerialHandler.getInstance();
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
    private JButton consoleSendButton;
    private JTextField consoleInputField;
    private JTextArea consoleTextArea;
    private JScrollPane consoleScrollPane;
    private JScrollPane consolePanel;

    private WindowData data = new WindowData();

    private StartingWindow() {
        List<String> serialPorts = serialHandler.getPortsNames();

        serialPorts.forEach(portName -> comPortsComboBox.addItem(portName));

        //Home
        homingExecuteButton.addActionListener(actionService.homeActionListener());

        //Dwell
        dwellExecuteButton.addActionListener(actionService.dwellActionListener(dwellSecondsInput));

        //Serial
        connectPortButton.addActionListener(actionService.serialConnectActionListener(comPortsComboBox, comStatusText));

        //Console send
        consoleSendButton.addActionListener(actionService.sendConsoleActionListener(consoleInputField, consoleTextArea));

        //TODO TEST
        //Retrieve position M114
        executeButton1.addActionListener(actionService.retrieveLocation());


    }

    public static StartingWindow getInstance(){
        if(null == INSTANCE){
            return new StartingWindow();
        }
        return INSTANCE;
    }

    public JPanel getMainPanel(){
        return mainPanel;
    }

    public JPanel getAxisOnePanel(){
        return this.axisOnePanel;
    }

    public  void writeToConsole(String text){
        this.consoleTextArea.append(text);
        consoleTextArea.setForeground(new Color(0x06DFFF));
    }

    private List<JButton> loadButtons(){
        List<JButton> buttonList = new ArrayList<>();

        /*
    private JButton zPlusOneButton;
    private JButton zMinusOneButton;
    private JButton zMinusFiveButton;
    private JButton zPlusFiveButton;
    private JButton zPlusTenButton;
    private JButton zMinusTenButton;

    private JButton yPlusOneButton;
    private JButton yMinusOneButton;
    private JButton yMinusFiveButton;
    private JButton yPlusFiveButton;
    private JButton yPlusTenButton;
    private JButton yMinusTenButton;
         */

        return buttonList;
    }
}
