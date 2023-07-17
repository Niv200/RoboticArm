package me.niv.robotdesktop.data;

import java.util.ArrayList;
import java.util.List;

public class SerialCommand {

    private String command = "";

    private GCodeCommand gCodeCommand;
    private List<KeyValuePair> values = new ArrayList<>();

    public SerialCommand(){
    }

    public SerialCommand gCode(GCodeCommand gCodeCommand){
        this.gCodeCommand = gCodeCommand;
        return this;
    }

    public SerialCommand value(GCodeCharacter gCodeCharacter, Double value){
        values.add(new KeyValuePair(gCodeCharacter, value));
        return this;
    }

    public String build(){
        command = command + gCodeCommand.command;
        values.forEach(pair -> command = command + " " + pair.toStringValue());
        return command;
    }

}
