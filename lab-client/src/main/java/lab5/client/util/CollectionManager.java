package lab5.client.util;

import com.opencsv.exceptions.CsvValidationException;
import lab5.client.data.Flat;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.*;

public class CollectionManager {
    private static TreeMap<Long, Flat> flatCollection = new TreeMap<>();
    private static LocalDateTime initDate;

    public CollectionManager(InputStreamReader isr) throws IOException, ParseException, CsvValidationException {
        flatCollection = Parser.readTreeMapFromISR(isr);
        //initDate = new LocalDateTime();
    }
    public static void add (Long key, Flat flat){
        flatCollection.put(key, flat);
    }
    public void removeKey (Long key){
        flatCollection.remove(key);
    }
    public static void clear(){
        flatCollection.clear();
    }
    public static TreeMap<Long, Flat> getFlatCollection(){
        return flatCollection;
    }
    public static void remove(Long key){
        if (flatCollection.containsKey(key)){
            flatCollection.remove(key);
            System.out.println("Элемент с ключом " + key + " был удален из коллекции");
        } else{
            System.out.println("Коллекция не содержит данный ключ");
        }
    }

    public static void initCollection(TreeMap<Long, Flat> treeMap){
        flatCollection = treeMap;
        initDate = LocalDateTime.now();
    }
    public static Class getType(){
        return flatCollection.getClass();
    }
    public void initCollection(){
        initDate = LocalDateTime.now();
    }
    public static LocalDateTime getInitTime(){
        return initDate;
    }
}
