package me.niv.robotdesktop.service;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import me.niv.robotdesktop.serial.SerialHandler;

public interface IActionService {

    ActionListener serialConnectActionListener(SerialHandler handler, JComboBox comboBox, JLabel comStatusText);
}
