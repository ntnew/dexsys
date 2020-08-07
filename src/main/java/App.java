import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;




public class App {
    public static void main(String[] args) throws IOException {
        Commands.showHelp();
        while (true){
            System.out.println("Введите команду!");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            CommandHandler.commandHandler(bufferedReader.readLine());
        }

    }
}
