package lab5.client;

import java.io.IOException;
import lab5.client.util.Parser;

public final class Client {
   /*
   private Client() {
        throw new UnsupportedOperationException("This is an utility class and can not be instantiated");
    }
    public static final String INPUT_COMMAND= "$ ";
    public static final String INPUT_INFO = "> ";
    */
   public static void main(String[] args) {
       Parser File1 = new Parser();
       try {
           File1.readFile();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}
