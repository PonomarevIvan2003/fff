package lab5.client.util;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lab5.client.commands.Command;
import lab5.client.commands.CommandManager;
import lab5.client.commands.FilterByTransportCommand;
import lab5.client.data.Coordinates;
import lab5.client.data.Flat;
import lab5.client.data.House;
import lab5.client.data.Transport;
import lab5.client.exceptions.*;
import org.apache.commons.lang3.ObjectUtils;

import javax.swing.text.StyledEditorKit;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private static final String waitForCommand = "$";
    private static boolean isScriptMode = false;

    public static void interactiveMode(){
        CommandManager.setCommands();
        String input = "";
        Command command = null;
        while (!input.equals("exit")){
            try{
                Scanner console = new Scanner(System.in);
                System.out.print(waitForCommand);
                input = console.nextLine();
                command = getCommandFromInput(input);
                if (command.getParametersCount()+1 > input.split(" ").length){
                    throw new WrongNumberOfParametersException();
                }
                command.execute(input, console);
            }
            catch (WrongAmountOfCoordinatesException e){
                System.err.println("Неверное количество координат.");
            }
            catch (WrongNumberOfParametersException e){
                System.err.println("Неверное количество параметров у команды, должно быть - " + command.getParametersCount() + "(" + command.getParameters() + ")");
            }
            catch (CommandNotFoundException e){
                System.err.println("Такой команды нет");
            }
            catch (NumberOutOfBoundsException e){
                System.err.println("Параметр не вписывается в установленные рамки");
            }
            catch(IllegalArgumentException e){
                System.err.println("Неверный формат параметра, должно быть " + command.getParameters());
            }

        }
    }
    public static Flat getElement(Scanner scanner) throws NumberOutOfBoundsException, WrongAmountOfCoordinatesException{
        if (isScriptMode()){
            return getElementFromScript(scanner);
        }
        else{
            return getElementFromUser(scanner);
        }
    }
    public static Command getCommandFromInput(String input) throws CommandNotFoundException{
        String[] values = input.split(" ");
        List<Command> commands = CommandManager.getCommands();
        for (Command command : commands){
            if (command.getName().equals(values[0])){
                return command;
            }
        }
        throw new CommandNotFoundException();
    }
    private static Flat getElementFromUser(Scanner scanner){
        String nameS; String name = null;
        do {
            try{
                System.out.println("Введите название квартиры");
                nameS = scanner.nextLine();
                if(checkIfExit(nameS)){
                    return null;
                }
                name = FieldSetterClass.getFlatName(nameS);
            }
            catch (NullPointerException e){
                System.out.println("Это поле не может быть null.");
            }
            catch (IllegalArgumentException e){
                System.out.println("Значение неверного формата.");
            }
        }
        while (name == null);
        String cooddinatesS;
        Coordinates coordinates = null;
        do {
            try {
                System.out.println("Введите координаты квартиры");
                cooddinatesS = scanner.nextLine();
                if(checkIfExit(cooddinatesS)){
                    return null;
                }
                coordinates = FieldSetterClass.getFlatCoordinates(cooddinatesS);
            }
            catch (NumberOutOfBoundsException e){
                System.out.println("Значение не входит в установленный диапазон.");
            }
            catch (WrongAmountOfCoordinatesException e){
                System.out.println("Неверное количество координат.");
            }
            catch (IllegalArgumentException e){
                System.out.println("Значение неверного формата.");
            }
            catch (NullPointerException e){
                System.out.println("Это поле не может быть null.");
            }
        } while (coordinates == null);

        String areaS; Long area = Long.valueOf(0);
        do{
            try{
                System.out.println("Введите район");
                areaS = scanner.nextLine();
                if(checkIfExit(areaS)){
                    return null;
                }
                area = FieldSetterClass.getFlatArea(areaS);
                if (areaS.equals("")){
                    break;
                }
            }
            catch(NumberOutOfBoundsException e){
                System.out.println("Значение не входит в установленный диапазон.");
            }
            catch (IllegalArgumentException e){
                System.out.println("Значение неверного формата.");
            }
        } while (area == 0);

        String numberOfRoomsS; Integer numberOfRooms = 0;
        do{
            try{
                System.out.println("Введите количество комнат");
                numberOfRoomsS = scanner.nextLine();
                if(checkIfExit(numberOfRoomsS)){
                    return null;
                }
                numberOfRooms = FieldSetterClass.getFlatNumberOfRooms(numberOfRoomsS);
                if (numberOfRoomsS.equals("")){
                    break;
                }
            }
            catch(NumberOutOfBoundsException e){
                System.out.println("Значение не входит в установленный диапазон.");
            }
            catch (IllegalArgumentException e){
                System.out.println("Значение неверного формата.");
            }
        }while (numberOfRooms == 0);

        String heigthS; Integer height = 0;
        do{
            try{
                System.out.println("Введите этаж");
                heigthS = scanner.nextLine();
                if(checkIfExit(heigthS)){
                    return null;
                }
                height = FieldSetterClass.getFlatHeight(heigthS);
                if (heigthS.equals("")){
                    break;
                }
            }
            catch(NumberOutOfBoundsException e){
                System.out.println("Значение не входит в установленный диапазон.");
            }
            catch (IllegalArgumentException e){
                System.out.println("Значение неверного формата.");
            }
        }while (height == 0);

        String newnessS; Boolean newness = null;
        do{
            try{
                System.out.println("Введите новизну");
                newnessS = scanner.nextLine();
                if(checkIfExit(newnessS)){
                    return null;
                }
                newness = FieldSetterClass.getFlatNewness(newnessS);
                if (newnessS.equals("")){
                    break;
                }
            }
            catch (IllegalArgumentException e){
                System.out.println("Значение неверного формата.");
            }
        }while (newness == null);

        String transportS; Transport transport = null;
        do{
            try{
                System.out.println("Введите наличие транспорта");
                System.out.println("Доступные варианты: " + Arrays.toString(Transport.values()));
                transportS = scanner.nextLine();
                if(checkIfExit(transportS)){
                    return null;
                }
                transport = FieldSetterClass.getFlatTransport(transportS);
            }
            catch (IllegalArgumentException e){
                System.out.println("Значение неверного формата");
            }
            catch (NullPointerException e){
                System.out.println("Это поле не может быть null.");
            }
        } while (transport == null);

        String houseNameS; String houseName = null;
        do{
            try{
                System.out.println("Введите название дома");
                houseNameS = scanner.nextLine();
                if(checkIfExit(houseNameS)){
                    return null;
                }
                houseName = FieldSetterClass.getHouseName(houseNameS);
            }
            catch (NullPointerException e){
                System.out.println("Это поле не может быть null.");
            }
        }while (houseName == null);

        String yearS; int year = 0;
        do{
            try{
                System.out.println("Введите год");
                yearS = scanner.nextLine();
                if(checkIfExit(yearS)){
                    return null;
                }
                year = FieldSetterClass.getHouseYear(yearS);
                if (yearS.equals("")){
                    break;
                }
            }
            catch(NumberOutOfBoundsException e){
                System.out.println("Значение не входит в установленный диапазон.");
            }
            catch (IllegalArgumentException e){
                System.out.println("Значение неверного формата.");
            }
        }while (year == 0);

        String numberOfLiftsS; Integer numberOfLifts = 0;
        do{
            try{
                System.out.println("Введите количество лифтов");
                numberOfLiftsS = scanner.nextLine();
                if(checkIfExit(numberOfLiftsS)){
                    return null;
                }
                numberOfLifts = FieldSetterClass.getHouseYear(numberOfLiftsS);
                if (numberOfLiftsS.equals("")){
                    break;
                }
            }
            catch(NumberOutOfBoundsException e){
                System.out.println("Значение не входит в установленный диапазон.");
            }
            catch (IllegalArgumentException e){
                System.out.println("Значение неверного формата.");
            }
        }while (numberOfLifts == 0);
        LocalDateTime creationDate = LocalDateTime.now();
        House house = new House(houseName, year, numberOfLifts);
        Flat flat = new Flat(name,coordinates, creationDate, area, numberOfLifts, height, newness, transport, house);
        return flat;

    }
    private static  boolean checkIfExit(String s){
        if (s.equals("exit")){
            System.out.println("Вы хотите прекратить ввод? (yes/no)");
            String answer = new Scanner(System.in).nextLine();
            if (answer.equals("yes")){
                return true;
            }
        }
        return false;
    }
    public static void scriptMode(String path){
        int line = 0;
        isScriptMode = true;
        Scanner reader;
        try{
            File file = new File("commands.txt");
            reader = new Scanner(file);
            while(reader.hasNext()){
                String input = reader.nextLine();
                line +=1;
                Command command = getCommandFromInput(input);
                if (command.getParametersCount()+1 != input.split(" ").length){
                    throw  new WrongNumberOfParametersException();
                }
                System.out.println("Команда " + line + ": ");
                command.execute(input, reader);
            }
        }
        catch(WrongAmountOfCoordinatesException e){
            System.out.println("Неверное количество координат в строке " + line);
        }
        catch (FileNotFoundException e){
            System.out.println("Файл не найден");
        }
        catch (WrongNumberOfParametersException e){
            System.out.println("Неверное количество параметров в строке " + line);
        }
        catch (NumberOutOfBoundsException e){
            System.out.println("Параметр, не вписывающийся в установленные рамки, в строке " + line);
        }
        catch (CommandNotFoundException e){
            System.out.println("Такой команды не существует в строке " + line);
        }
        catch (IllegalArgumentException e){
            System.out.println("Неверные формат параметра у одной из команд в строке " + line);
        } catch (StackOverflowError e){
            System.out.println("При выполнении скрипта, произошли рекурсивные вызовы и случилось переполнение стека");
        }
        finally {
            isScriptMode = false;
        }
    }
    private static Flat getElementFromScript(Scanner scanner) throws NumberOutOfBoundsException, WrongAmountOfCoordinatesException{
        String nameS = scanner.nextLine();
        String name = FieldSetterClass.getFlatName(nameS);

        String coordinatesS = scanner.nextLine();
        Coordinates coordinates = FieldSetterClass.getFlatCoordinates(coordinatesS);

        String areaS = scanner.nextLine();
        Long area = FieldSetterClass.getFlatArea(areaS);

        String numberOfRoomsS = scanner.nextLine();
        Integer numberOfRooms = FieldSetterClass.getFlatNumberOfRooms(numberOfRoomsS);

        String heightS = scanner.nextLine();
        Integer height = FieldSetterClass.getFlatHeight(heightS);

        String newnessS = scanner.nextLine();
        Boolean newness = FieldSetterClass.getFlatNewness(newnessS);

        String transportS = scanner.nextLine();
        Transport transport = FieldSetterClass.getFlatTransport(transportS);

        String houseNameS = scanner.nextLine();
        String houseName = FieldSetterClass.getHouseName(houseNameS);

        String yearS = scanner.nextLine();
        int year = FieldSetterClass.getHouseYear(yearS);

        String numberOfLiftsS = scanner.nextLine();
        Integer numberOfLifts = FieldSetterClass.getHouseNumberOfLifts(numberOfLiftsS);

        House house = new House(houseName, year, numberOfLifts);
        LocalDate creationDate = LocalDate.now();
        Flat flat = new Flat(name,coordinates, creationDate, area,numberOfRooms,height,newness,transport,house);

        return flat;
    }
    private static boolean isScriptMode(){
        return isScriptMode;
    }
    private static boolean isRecursive(File file){
        int line = 0;
        try{
            Scanner reader = new Scanner("commands.txt");
            while(reader.hasNext()){
                String input = reader.nextLine();
                line +=1;
                Command command = getCommandFromInput(input);
                if(input.equals("execute_script" + file.getPath())){
                    return true;
                }
                if (command.getParametersCount()+1 != input.split(" ").length){
                    throw new WrongNumberOfParametersException();
                }
            }
        }
        catch(Exception e){

        }
        return false;
    }
}
