package lab5.client.util;

import lab5.client.data.Flat;

import java.io.*;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.lang.reflect.Type;
import java.util.TreeMap;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import sun.reflect.generics.tree.Tree;

public class Parser {
    private TreeMap<Long,Flat> flatCollection;
    public void readFile() throws IOException {
        File file = new File("flats.json");
        BufferedReader fileReader;
        try{
            fileReader = new BufferedReader (new InputStreamReader(new FileInputStream(file)));
        }
        catch (IOException e){
            System.err.println("Файл недоступен или не найден.");
            return;
        }
        String collectionJson = " ";
        String sTemp = "";
        while ((sTemp = (fileReader.readLine())) != null){
            collectionJson += sTemp;
        }
        flatCollection = Parser.fromJson(collectionJson);
        System.out.println(flatCollection.size());
        System.out.println("Коллекция была загружена из файла ");
    }

    static public String toJson(TreeMap<Long,Flat> collection ){
        Gson gson = new Gson();
        return toJson(collection);
    }
    static public TreeMap<Long,Flat> fromJson(String json){
        try{
            Gson gson = new Gson();
            Type type = new TypeToken <TreeMap<Long,Flat>>(){}.getType();
            return gson.fromJson(json, type);
        }
        catch (JsonSyntaxException e){
            return null;
        }
    }
}
