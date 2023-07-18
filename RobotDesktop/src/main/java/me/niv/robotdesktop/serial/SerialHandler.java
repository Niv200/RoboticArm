package me.niv.robotdesktop.serial;

import static java.lang.String.format;
import static java.util.Objects.isNull;
import static java.util.Optional.empty;

import com.fazecast.jSerialComm.SerialPort;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SerialHandler {

    private SerialPort port;

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

    public SerialPort getConnectedPort(){
        if(isNull(port)){
            return null;
        }
        return this.port;
    }

    public boolean connectToPort(SerialPort serialPort){
        return serialPort.openPort();
    }

}
