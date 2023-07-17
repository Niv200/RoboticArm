package me.niv.robotdesktop.window;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import me.niv.robotdesktop.data.GCodeCharacter;
import me.niv.robotdesktop.data.GCodeCommand;
import me.niv.robotdesktop.data.SerialCommand;
import me.niv.robotdesktop.panels.DrawingPanel;

public class StartingWindow {

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
    private JPanel dwellPanel;
    private JButton dwellExecuteButton;
    private JPanel calibrationInnerPanel;
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

    public StartingWindow() {
        homingExecuteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO Home serial output
                String command = new SerialCommand().gCode(GCodeCommand.HOME).build();
                System.out.println(command);

                axisOnePanel.setSize(new Dimension(200, 200));
                axisOnePanel.setVisible(true);
                JPanel jPanel = new DrawingPanel();
//                axisOnePanel.add(jPanel);
                jPanel.repaint();
                axisOnePanel.repaint();

                mainPanel.add(axisOnePanel);
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
