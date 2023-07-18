package me.niv.robotdesktop.service;

import static java.util.Objects.isNull;

import com.fazecast.jSerialComm.SerialPort;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import me.niv.robotdesktop.serial.SerialHandler;

public class ActionService implements IActionService{


    @Override
    public ActionListener serialConnectActionListener(SerialHandler handler, JComboBox comboBox, JLabel comStatusText) {
        return (listener) -> {
            if(comboBox.getSelectedObjects().length == 0){
                comStatusText.setText("No ports found");
                return;
            }
            SerialPort port = handler.getPort(comboBox.getSelectedItem().toString());

            if(isNull(port)){
                comStatusText.setText("Port not available");
            }else{
                if(port.openPort()){
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
}
