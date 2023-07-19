package me.niv.robotdesktop.service;

import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public interface IActionService {

    ActionListener serialConnectActionListener(JComboBox comboBox, JLabel comStatusText);

    ActionListener homeActionListener();

    ActionListener dwellActionListener(JTextField dwellField);

    ActionListener sendConsoleActionListener(JTextField consoleInputField,  JTextArea consoleTextArea);

    ActionListener retrieveLocation();
}
