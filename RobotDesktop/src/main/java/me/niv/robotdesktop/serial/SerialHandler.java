package me.niv.robotdesktop.serial;

import static java.lang.String.format;
import static java.util.Objects.isNull;
import static java.util.Optional.empty;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortEvent;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SerialHandler {

    private static SerialHandler INSTANCE;

    private PrintWriter writer;
    private SerialPort port;


    private SerialHandler(){
    }

    public static SerialHandler getInstance(){
        if(INSTANCE == null){
            INSTANCE = new SerialHandler();
        }
        return INSTANCE;
    }

    public List<String> getPortsNames(){
        List<SerialPort> ports = Arrays.stream(SerialPort.getCommPorts()).collect(Collectors.toList());
        List<String> portNames =  ports.stream().map(SerialPort::getSystemPortName).collect(Collectors.toList());

        return portNames;
    }

    public List<SerialPort> getPorts(){
        return Arrays.stream(SerialPort.getCommPorts()).collect(Collectors.toList());
    }

    public SerialPort getPort(String name){
        Optional<SerialPort> port = empty();
        if(getPortsNames().contains(name)){
            port = getPorts().stream().filter(p -> p.getSystemPortName().equalsIgnoreCase(name)).findAny();
        }
        if(port.isEmpty()){
            System.out.println(format("Could not connect to serial port named '%s'", name));
            return null;
        }
        this.port = port.get();
        return port.get();
    }

    public void openWriter(){
        writer = new PrintWriter(getConnectedPort().getOutputStream(),true);
    }

    public SerialPort getConnectedPort(){
        if(isNull(port)){
            return null;
        }
        return this.port;
    }

    public void out(String command){
        writer.println(command);
    }


}
