package lab5.client.util;


import lab5.client.data.*;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import lab5.client.data.Coordinates;
import lab5.client.data.Flat;
import lab5.client.data.House;
import lab5.client.data.Transport;
import lab5.client.exceptions.NumberOutOfBoundsException;
import lab5.client.exceptions.WrongAmountOfCoordinatesException;
import org.json.simple.parser.ParseException;


import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TreeMap;

import com.opencsv.CSVWriter;

import java.io.IOException;


public class Parser {
    static String exceptionPointer;

    public static TreeMap<Long, Flat> readTreeMapFromISR(InputStreamReader isr) throws IOException, ParseException, CsvValidationException {
        CSVReader reader = new CSVReader(isr);
        String[] nextLine;
        TreeMap<Long, Flat> treeMap = new TreeMap<>();
        Flat flat = null;
        while ((nextLine = reader.readNext()) != null) {
            try {
                if (nextLine != null) {
                    if (nextLine.length == 11) {
                        String name = FieldSetterClass.getFlatName(nextLine[0]);
                        Coordinates coordinates = FieldSetterClass.getFlatCoordinates(nextLine[1] + " " + nextLine[2]);
                        Long area = FieldSetterClass.getFlatArea(nextLine[3]);
                        Integer numberOfRooms = FieldSetterClass.getFlatNumberOfRooms(nextLine[4]);
                        Integer height = FieldSetterClass.getFlatHeight(nextLine[5]);
                        Boolean newness = FieldSetterClass.getFlatNewness(nextLine[6]);
                        Transport transport = FieldSetterClass.getFlatTransport(nextLine[7]);
                        String houseName = FieldSetterClass.getHouseName(nextLine[8]);
                        int houseYear = FieldSetterClass.getHouseYear(nextLine[9]);
                        Integer houseNumberOfLifts = FieldSetterClass.getHouseNumberOfLifts(nextLine[10]);
                        LocalDateTime creationDate = LocalDateTime.now();
                        House house = new House(houseName, houseYear, houseNumberOfLifts);
                        flat = new Flat(name, coordinates, creationDate , area, numberOfRooms, height, newness ,transport, house);
                        treeMap.put(flat.getId(), flat);
                    }
                    else if (nextLine.length == 13){
                        Long id = FieldSetterClass.getFlatId(nextLine[0]);
                        String name = FieldSetterClass.getFlatName(nextLine[1]);
                        Coordinates coordinates = FieldSetterClass.getFlatCoordinates(nextLine[2] + " " + nextLine[3]);
                        LocalDate creationDate = FieldSetterClass.getFlatCreationDate((nextLine[4]));
                        Long area = FieldSetterClass.getFlatArea(nextLine[5]);
                        Integer numberOfRooms = FieldSetterClass.getFlatNumberOfRooms(nextLine[6]);
                        Integer height = FieldSetterClass.getFlatHeight(nextLine[7]);
                        Boolean newness = FieldSetterClass.getFlatNewness(nextLine[8]);
                        Transport transport = FieldSetterClass.getFlatTransport(nextLine[9]);
                        String houseName = FieldSetterClass.getHouseName(nextLine[10]);
                        int houseYear = FieldSetterClass.getHouseYear(nextLine[11]);
                        Integer houseNumberOfLifts = FieldSetterClass.getHouseNumberOfLifts(nextLine[12]);
                        House house = new House(houseName, houseYear, houseNumberOfLifts);
                        flat = new Flat(name, coordinates, creationDate , area, numberOfRooms, height, newness ,transport, house);
                        treeMap.put(flat.getId(), flat);
                    }
                }
            }
            catch(IllegalArgumentException e){
                System.out.println("Некорректное значение в поле " + exceptionPointer);
            }
            catch(NumberOutOfBoundsException f){
                System.out.println("Значение не входящее в указанные рамки в поле " + exceptionPointer);
            }
            catch (WrongAmountOfCoordinatesException g){
                System.out.println("Неверное количество координат в поел " + exceptionPointer);
            }
        }
        return treeMap;
    }

    public static void writeTreeMapToFile(TreeMap<Long,Flat> flatCollection) {
        String fileName = "1.csv";
        FileWriter fr = null;
        BufferedWriter buff = null;
        CSVWriter writer = null;
        try{
            fr = new FileWriter(fileName);//второй аргумент false;
            buff = new BufferedWriter(fr);
            writer = new CSVWriter(buff);
        for (Flat flat : flatCollection.values()) {
            String[] entries = {String.valueOf(flat.getId()),
                    String.valueOf(flat.getName()),
                    String.valueOf(flat.getCoordinates().getX()),
                    String.valueOf(flat.getCoordinates().getY()),
                    String.valueOf(flat.getCreationDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))),
                    String.valueOf(flat.getArea()),
                    String.valueOf(flat.getNumberOfRooms()),
                    String.valueOf(flat.getHeight()),
                    String.valueOf(flat.getNewness()),
                    String.valueOf(flat.getTransport()),
                    String.valueOf(flat.getHouse().getName()),
                    String.valueOf(flat.getHouse().getYear()),
                    String.valueOf(flat.getHouse().getNumberOfLifts())};


            writer.writeNext(entries);
        }
            writer.flush();
        } catch (IOException e) {
                System.err.println("Не удалось записать данные в файл");
        }
    }

}