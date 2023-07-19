package me.niv.robotdesktop.serial;

import com.fazecast.jSerialComm.*;
import me.niv.robotdesktop.window.StartingWindow;

public class SerialListener implements SerialPortDataListener {

    private static String bufferReadToString = "";
    private static int cutOff = 10;  //cut off character

    @Override
    public int getListeningEvents() {
        return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
    }

    @Override
    public void serialEvent(SerialPortEvent event) {
        byte[] buffer = new byte[event.getSerialPort().bytesAvailable()];
        event.getSerialPort().readBytes(buffer, buffer.length);

        String s = new String(buffer);
        bufferReadToString = bufferReadToString.concat(s);

        if ((bufferReadToString.indexOf(cutOff) + 1) > 0) {
            StartingWindow.getInstance().writeToConsole("<< " + bufferReadToString);
        }
    }
}