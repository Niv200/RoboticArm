package me.niv.robotdesktop.data;

public enum GCodeCommand {
    HOME("G28"), DWELL("G4"), ABSOLUTE_MODE("G90"), RELATIVE_MODE("G91"),
    SET_POSITION("G92"), ENABLE_STEPPERS("M117"), DISABLE_STEPPERS("M118"), REPORT_POSITION("M114");

    public final String command;


    GCodeCommand(String command) {
        this.command = command;
    }
}
