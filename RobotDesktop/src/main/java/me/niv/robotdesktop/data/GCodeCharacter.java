package me.niv.robotdesktop.data;

public enum GCodeCharacter {
    X("X"), Y("Y"), Z("Z"), SECONDS("S");

    public final String value;

    GCodeCharacter(String value) {
        this.value = value;
    }


}
