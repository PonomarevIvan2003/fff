package lab5.client.commands;

import java.util.Scanner;

public class ExitCommand  extends Command{
    ExitCommand(){
        parametersCount = 0;
    }
    @Override
    public String getName(){
        return "exit";
    }
    @Override
    public String getInfo() {
        return "завершает программу";
    }
    @Override
    public void execute(String s, Scanner scanner){};
}
