package lab5.client.commands;

import lab5.client.util.UserInterface;

import java.util.Scanner;

public class ExecuteScriptCommand extends  Command{
    public ExecuteScriptCommand() {
        parametersCount = 1;
        setParameters("file_name");
    }
    @Override
    public String getName(){
        return "execute_script";
    }
    @Override
    public String getInfo(){
        return "исполняет скрипт из файла";
    }
    @Override
    public void execute(String s, Scanner scanner){
        s = s.split("")[1];
        UserInterface.scriptMode(s);
        System.out.println("Исполнение скрипта завершено");
        System.out.println(separatorString);
    }
}
