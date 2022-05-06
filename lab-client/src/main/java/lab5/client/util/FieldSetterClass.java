package lab5.client.util;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lab5.client.data.Coordinates;
import lab5.client.data.Transport;
import lab5.client.exceptions.NumberOutOfBoundsException;
import lab5.client.exceptions.WrongAmountOfCoordinatesException;

import java.time.LocalDate;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;

public class FieldSetterClass {
    public static String getFlatName(String s){
        Parser.exceptionPointer = "name";
        ValidationClass.checkString(s, false);
        String name = new String(s);
        return name;
    }
    public static Coordinates getFlatCoordinates(String s) throws NumberOutOfBoundsException, WrongAmountOfCoordinatesException{
        Parser.exceptionPointer = "coordinates";
        ValidationClass.checkCoordinates(s, false);
        Coordinates coordinates = Coordinates.valueOf(s);
        if (s.equals("")){
            return null;
        }
        return coordinates;
    }
    public static Long getFlatArea(String s) throws NumberOutOfBoundsException{
        Parser.exceptionPointer = "area";
        ValidationClass.checkLong(s, true, true, 0L);
        if(s.equals("")){
            return null;
        }
        Long area = Long.valueOf(s);
        return area;
    }
    public static Integer getFlatNumberOfRooms(String s) throws NumberOutOfBoundsException{
        Parser.exceptionPointer = "numberOfRooms";
        ValidationClass.checkInt(s, true, true, true, 0, 15);
        if (s.equals("")){
            return null;
        }
        Integer numberOfRooms = Integer.valueOf(s);
        return numberOfRooms;
    }
    public static Integer getFlatHeight(String s) throws NumberOutOfBoundsException{
        Parser.exceptionPointer = "height";
        ValidationClass.checkInt(s, true, true,0);
        if (s.equals("")){
            return null;
        }
        Integer height = Integer.valueOf(s);
        return height;
    }
    public static Boolean getFlatNewness(String s){
        Parser.exceptionPointer = "newness";
        ValidationClass.checkBoolean(s, true);
        if (s.equals("")){
            return null;
        }
        Boolean newness = Boolean.valueOf(s);
        return newness;
    }
    public static Transport getFlatTransport(String s){
        Parser.exceptionPointer = "transport";
        ValidationClass.checkTransport(s, false);
        if (s.equals("")){
            return null;
        }
        Transport transport = Transport.valueOf(s);
        return transport;
    }
    public static String getHouseName(String s){
        Parser.exceptionPointer = "houseName";
        ValidationClass.checkString(s,false);
        String houseName = new String(s);
        return houseName;
    }
    public static int getHouseYear(String s) throws NumberOutOfBoundsException {
        Parser.exceptionPointer = "houseYear";
        ValidationClass.checkInt(s, true, true, 0);
        if (s.equals("")){
            return 0;
        }
        int year = Integer.valueOf(s);
        return year;
    }
    public static Integer getHouseNumberOfLifts(String s) throws NumberOutOfBoundsException {
        Parser.exceptionPointer = "houseNumberOfLifts";
        ValidationClass.checkInt(s, true, true, 0);
        if (s.equals("")){
            return null;
        }
        Integer numberOfLifts = Integer.valueOf(s);
        return numberOfLifts;
    }
    public static Long getFlatId(String s) throws NumberOutOfBoundsException{
        Parser.exceptionPointer = "id";
        ValidationClass.checkLong(s, false);
        Long id = Long.valueOf(s);
        if(s.equals("")){
            return null;
        }
        return id;
    }
    public static LocalDate getFlatCreationDate(String s){
        Parser.exceptionPointer = "creationDate";
        ValidationClass.checkDate(s, true);
        if (s.equals("")){return null;}
        LocalDate creationDate = LocalDate.parse(s, ISO_LOCAL_DATE);
        return creationDate;
    }
}
