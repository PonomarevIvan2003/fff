package lab5.client.util;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lab5.client.data.Transport;
import lab5.client.exceptions.NumberOutOfBoundsException;
import lab5.client.exceptions.WrongAmountOfCoordinatesException;

import javax.swing.text.StyledEditorKit;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;

public class ValidationClass {
    public static void checkFloat(String s, Boolean nullable, Boolean leftRange, Float range) throws NumberFormatException, NumberOutOfBoundsException{
        if (s.equals("") && !nullable){
            throw new NullPointerException();
        }
        Float n =Float.valueOf(s);

        if((leftRange && n <= range) | (!(leftRange) && n > range)){
            throw new NumberOutOfBoundsException();
        }
    }
    public static void checkInt(String s, Boolean nullable, Boolean leftRange, Integer range) throws NumberFormatException, NumberOutOfBoundsException{
        if(s.equals("") && !nullable){
            throw new NullPointerException();
        }
        else if (!s.equals("")){
            Integer n = Integer.valueOf(s);
            if ((leftRange && n <= range) | (!(leftRange) && n > range)){
                throw new NumberOutOfBoundsException();
            }
        }
    }
    public static void checkInt(String s, Boolean nullable, Boolean leftRange) throws NumberFormatException{
        if(s.equals("") && !nullable){
            throw new NullPointerException();
        }
    }
    public static void checkString(String s, Boolean nullable){
        if (s.equals("") && !nullable){
            throw new NullPointerException();
        }
    }
    public static void checkString(String s, Boolean nullable, int length){
        if (s.equals("") && !nullable){
            throw new NullPointerException();
        }
    }
    public static void checkCoordinates(String s, Boolean nullable) throws NumberOutOfBoundsException, WrongAmountOfCoordinatesException{
        if (s.equals("") && !nullable){
            throw  new NullPointerException();
        }
        String[] sList = s.split(" ");
        String[] values = new String[realLength(sList)];
        int j = 0;
        for (int i = 0; i < sList.length; i++){
            if (!sList[i].equals("")){
                values[j] = sList[i];
                j+=1;
            }
        }
        if (values.length == 2){
            checkInt(values[0], false, false);
            checkFloat(values[1], false, true, -279f);
        }
        else throw new WrongAmountOfCoordinatesException();
    }
    private static int realLength(String[] sList){
        int ans = 0;
        for (int i = 0; i < sList.length; i++){
            if (!sList[i].equals("")) ans +=1;
        }
        return ans;
    }
    public static void checkTransport(String s, Boolean nullable) throws IllegalArgumentException{
        if (s.equals("") && !nullable){
            throw new NullPointerException();
        }
        Transport transport = Transport.valueOf(s);
    }
    public static void checkBoolean(String s, Boolean nullable) throws IllegalArgumentException{
        if (s.equals("") && !nullable){
            throw new NullPointerException();
        }else if(!s.equals("")) {
            if (!s.equals("true") && !s.equals("false")) {
                throw new IllegalArgumentException();
            }
        }
    }
    public static void checkLong(String s, Boolean nullable, Boolean leftRange, Long range) throws NumberFormatException, NumberOutOfBoundsException{
        if(s.equals("") && !nullable){
            throw new NullPointerException();
        }else if(!s.equals("")) {
            Long n = Long.valueOf(s);
            if ((leftRange && n <= range) | (!(leftRange) && n > range)) {
                throw new NumberOutOfBoundsException();
            }
        }
    }
    public static void checkInt(String s, Boolean nullable, Boolean leftRange, Boolean rightRange, Integer leftrange, Integer rigthrange) throws NumberFormatException, NumberOutOfBoundsException{
        if(s.equals("") && !nullable){
            throw new NullPointerException();
        }
        else if (!s.equals("")){
            Integer n = Integer.valueOf(s);
            if ((leftRange && n <= leftrange) | (rightRange && n > rigthrange)){
                throw new NumberOutOfBoundsException();
            }
        }
    }
    public static void checkLong(String s, Boolean nullable) throws NullPointerException{
        Long n = Long.valueOf(s);
        if (s.equals("") && !nullable){
            throw new NullPointerException();
        }
    }
    /*public static void checkLong(String s, Boolean leftRange, Long range) throws NumberOutOfBoundsException{
        Long n = Long.valueOf(s);
        if(leftRange && n<=range){
            throw new NumberOutOfBoundsException();
        }
    } */
    public static void checkDate(String s, Boolean nullable) throws IllegalArgumentException {
        if (s.equals("") && !nullable) {
            throw new NullPointerException();
        } else if (!s.equals("")) {
            LocalDate birthday = LocalDate.parse(s, ISO_LOCAL_DATE);
        }
    }

}
