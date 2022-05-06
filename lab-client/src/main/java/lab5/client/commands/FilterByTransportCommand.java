package lab5.client.commands;

import lab5.client.data.Flat;
import lab5.client.data.Transport;
import lab5.client.util.CollectionManager;
import lab5.client.util.ValidationClass;
import org.apache.commons.lang3.BooleanUtils;

import java.util.Scanner;

public class FilterByTransportCommand extends Command{
    public FilterByTransportCommand(){
        parametersCount = 1;
    }
    @Override
    public String getName(){
        return "filter_by_transport";
    }
    @Override
    public String getInfo(){
        return "выводит элементы, значение поля transport которых равно заданному";
    }
    @Override
    public void execute(String s, Scanner scanner){
        s = s.split(" ")[1];
        int counter = 0;
        ValidationClass.checkTransport(s,false);
        Transport transport = Transport.valueOf(s);
        for (Flat flat : CollectionManager.getFlatCollection().values()){
            if(flat.getTransport() == transport){
                counter+=1;
                System.out.println(flat.toString());
            }
        }
        if(counter == 0){
            System.out.println("Подходящих элементов нет.");
        }
        System.out.println(separatorString);
    }
}
