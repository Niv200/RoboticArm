package me.niv.robotdesktop.validator;

import me.niv.robotdesktop.data.GCodeCharacter;
import me.niv.robotdesktop.data.GCodeCommand;
import me.niv.robotdesktop.data.SerialCommand;

public class TextBoxValidator {

    public static boolean validDouble(String text){
        if(null == text) return false;
        if(text.equals("")) return false;

        try {
            Double value = Double.parseDouble(text);
            if(value == null){
                System.out.println("Invalid Input");
                return false;
            }
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
