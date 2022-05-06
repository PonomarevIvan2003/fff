package lab5.client;

import java.io.*;
import java.util.TreeMap;

import com.opencsv.exceptions.CsvValidationException;
import lab5.client.data.Flat;
import lab5.client.util.CollectionManager;
import lab5.client.util.Parser;
import lab5.client.util.UserInterface;
import org.json.simple.parser.ParseException;


public final class Client {
   public static void main(String[] args) throws IOException, CsvValidationException, ParseException {
       File file = new File(System.getenv("LAB5"));
       FileInputStream fileInputStream = new FileInputStream(file);
       InputStreamReader isr = new InputStreamReader(fileInputStream);
       TreeMap<Long, Flat> treeMap = Parser.readTreeMapFromISR(isr);
       CollectionManager.initCollection(treeMap);
       UserInterface.interactiveMode();
   }
}
