package me.niv.robotdesktop.service;

import static java.util.Objects.isNull;

import com.fazecast.jSerialComm.SerialPort;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import me.niv.robotdesktop.data.GCodeCharacter;
import me.niv.robotdesktop.data.GCodeCommand;
import me.niv.robotdesktop.data.SerialCommand;
import me.niv.robotdesktop.serial.SerialHandler;

public class ActionService implements IActionService{

    private SerialHandler serialHandler = SerialHandler.getInstance();

    //Connect to serial
    @Override
    public ActionListener serialConnectActionListener(JComboBox comboBox, JLabel comStatusText) {
        return (listener) -> {
            if(comboBox.getSelectedObjects().length == 0){
                comStatusText.setText("No ports found");
                return;
            }
            SerialPort port = serialHandler.getPort(comboBox.getSelectedItem().toString());

            if(isNull(port)){
                comStatusText.setText("Port not available");
            }else{
                if(port.openPort()){
                    serialHandler.openWriter();
                    comStatusText.setText("Connected");
                    comStatusText.setForeground(Color.GREEN);
                }else{
                    if(!port.isOpen()){
                        comStatusText.setText("Error connecting");
                        comStatusText.setForeground(Color.RED);
                    }
                }
            }
        };
    }

    //Homing
    @Override
    public ActionListener homeActionListener(){
        return  e -> {
            String command = new SerialCommand().gCode(GCodeCommand.HOME).build();
            SerialPort port = serialHandler.getConnectedPort();
            if(!isNull(port)){
                port.setComPortParameters(115200, 8, 1, 0); // default connection settings for Arduino
                port.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);

                serialHandler.out(command);
            }
        };
    }

    @Override
    public ActionListener dwellActionListener(JTextField dwellField){
        return e -> {
            try {
                Integer sec = Integer.parseInt(dwellField.getText());
                if(sec == null || sec <= 0){
                    System.out.println("Dwell seconds must be defined.");
                }
                String command = new SerialCommand().gCode(GCodeCommand.DWELL).value(GCodeCharacter.SECONDS, sec.doubleValue()).build();

                serialHandler.out(command);
            } catch (NumberFormatException ex) {
                dwellField.setText("");
            }
        };
    }

    @Override
    public ActionListener sendConsoleActionListener(JTextField consoleInputField, JTextArea consoleTextArea){
        return e -> {
            System.out.println(consoleInputField.getText());
            if(!"".equalsIgnoreCase(consoleInputField.getText())){
                consoleTextArea.append(">> " + consoleInputField.getText() + "\n");
            }
        };
    }

    @Override
    public ActionListener retrieveLocation(){
        return e -> {
            String command = new SerialCommand().gCode(GCodeCommand.REPORT_POSITION).build();
            serialHandler.out(command);
        };
    }

}
