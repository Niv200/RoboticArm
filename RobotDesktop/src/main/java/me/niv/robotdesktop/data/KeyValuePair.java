package me.niv.robotdesktop.data;

public class KeyValuePair {

    private Double value;
    private GCodeCharacter key;

    public KeyValuePair(GCodeCharacter key, Double value){
        this.key = key;
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public GCodeCharacter getKey() {
        return key;
    }

    public String toStringValue(){
        if(value == null){
            return key.value;
        }
        return key.value + value.toString();
    }
}
