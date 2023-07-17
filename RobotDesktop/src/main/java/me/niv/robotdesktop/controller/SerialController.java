package me.niv.robotdesktop.controller;

import me.niv.robotdesktop.data.GCodeCharacter;
import me.niv.robotdesktop.data.GCodeCommand;
import me.niv.robotdesktop.data.SerialCommand;

public class SerialController implements ISerialController{

    @Override
    public void home() {
        //TODO Home serial output
        String command = new SerialCommand().gCode(GCodeCommand.HOME).build();
        System.out.println(command);
    }

    @Override
    public void dwell(Integer seconds) {
        if(seconds >= 0){
            //TODO Dwell serial output
            String command = new SerialCommand().gCode(GCodeCommand.DWELL)
                .value(GCodeCharacter.SECONDS, Double.valueOf(seconds)).build();
            System.out.println(command);
        }else{
            System.out.println("A number bigger than 0 must be used");
        }
    }
}
